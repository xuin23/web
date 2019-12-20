package com.cloud.common.utils;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Excel {

    @Test
    public void excelDemo() throws FileNotFoundException {
        File file = new File("D:\\单元测试报告模板.xlsx");
        InputStream inputStream = new FileInputStream(file);

        List<ExcelBean> resultList = excel(inputStream);
        for (ExcelBean bean : resultList) {

            System.out.println(bean.getNo() + "   " + bean.getOkNg());
        }
    }

    class ExcelBean {
        private String no;
        private String okNg;

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getOkNg() {
            return okNg;
        }

        public void setOkNg(String okNg) {
            this.okNg = okNg;
        }
    }

    /**
     * 解析Excel
     *
     * @param inputStream 文件流
     */
    private List<ExcelBean> excel(InputStream inputStream) {
        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;
        try {
            List<ExcelBean> resultList = new ArrayList<>();

            workbook = new XSSFWorkbook(inputStream);
            //第三个sheet
            sheet = workbook.getSheetAt(2);
            //标题
            XSSFRow row = sheet.getRow(1);
            //获取首列和尾列
            Map<String, Integer> map = getStartAndEnd(row);


            Integer startNum = map.get("start");
            Integer lastNum = map.get("end");

            //获取可用行
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                if (i > 3) {
                    XSSFRow xssfRow = sheet.getRow(i);
                    XSSFCell cell = xssfRow.getCell(startNum);
                    if (null != cell) {
                        String value = cell.getStringCellValue();
                        if (null != value && !value.isEmpty()) {
                            list.add(i);
                        }
                    }
                }
            }

            List<Integer> addedList = new ArrayList<>();
            for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
                CellRangeAddress range = sheet.getMergedRegion(i);
                if (startNum == range.getFirstColumn() && startNum == range.getLastColumn()) {
                    if (range.getFirstRow() > 3 && range.getLastRow() > 3) {
                        int firstRow = range.getFirstRow();
                        int lastRow = range.getLastRow();
                        resultList.add(getDate(sheet, startNum, lastNum, firstRow, lastRow));
                        addedList.add(firstRow);
                    }
                }
            }
            for (Integer integer : list) {
                if (!addedList.contains(integer)) {
                    resultList.add(getDate(sheet, startNum, lastNum, integer, integer));
                }
            }
            return resultList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取数据
     *
     * @param sheet    sheet
     * @param startNum 开始列
     * @param lastNum  结束列
     * @param firstRow 开始行
     * @param lastRow  结束行
     * @return Map<String, String>
     */
    private ExcelBean getDate(XSSFSheet sheet, Integer startNum, Integer lastNum, int firstRow, int lastRow) {
        ExcelBean resultMap = new ExcelBean();
        resultMap.setNo(sheet.getRow(firstRow).getCell(startNum).getStringCellValue());
        resultMap.setOkNg(sheet.getRow(lastRow + 1).getCell(lastNum).getStringCellValue());
        return resultMap;
    }

    /**
     * 获取开始和结束列
     *
     * @param row 行
     * @return Map<String, Integer>
     */
    private Map<String, Integer> getStartAndEnd(XSSFRow row) {
        Integer startNum = null;
        Integer lastNum = null;
        Map<String, Integer> resultMap = new HashMap<>();
        int index = 0;
        while (true) {
            XSSFCell cell = row.getCell(index);
            if (null == cell) {
                break;
            }
            String value = cell.getStringCellValue();
            if (null != value && !value.isEmpty()) {
                if (null == startNum) {
                    startNum = index;
                    lastNum = index;
                } else {
                    lastNum = index;
                }
            }
            index++;
        }
        resultMap.put("start", startNum);
        resultMap.put("end", lastNum);
        return resultMap;
    }

}
