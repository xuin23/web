package com.cloud.common.utils.bean;

public interface Test {

    default void defFun() {
        System.out.println("DefFun");
    }

    void fun();
}

class TestImpl implements Test {
    {
        System.out.println(" TestImpl");
    }

    static {
        System.out.println("static TestImpl");
    }

    public TestImpl() {
        System.out.println("constr TestImpl");
    }

    @Override
    public void fun() {
        System.out.println("fun()");
    }
}

class TestExtend extends TestImpl {
    {
        System.out.println(" TestExtend");
    }

    static {
        System.out.println("static TestExtend");
    }

    public TestExtend() {
        System.out.println("constr TestExtend");
    }

    @Override
    public void defFun() {
        super.defFun();
    }

    @Override
    public void fun() {
        super.fun();
    }

    public static void main(String[] args) {
        new TestExtend().defFun();
    }
}


interface C1 {
    default void fun() {
        System.out.println("C1");
    }

    default void fun2() {
        System.out.println("C1 fun2");
    }

    void fun3();
}

class C2 implements C1 {
    public void fun() {
        System.out.println("C2");
    }

    @Override
    public void fun3() {
        System.out.println("C2 fun3");
    }
}

class Te extends C2 implements C1 {

    public void funTest() {
        fun();
        fun2();
        fun3();
    }

    public static void main(String[] args) {
//        new Te().funTest();

            fun11();

    }

    private static void fun11() {

        try {
            int i = 0;
            fun22();
        } catch (Exception e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    private static void fun22() {
        try {
            int i = 0;
            fun33();
        } catch (Exception e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void fun33() {
        try {
            int i = 0;
            fun44();
        } catch (Exception e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void fun44() {
        try {
            int i = 0;
            fun55();
        } catch (Exception e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    private static void fun66() {

        if (true) {

//            e.printStackTrace();
            throw new RuntimeException("fuck");
        }
    }


    private static void fun55() {

        if (true) {

//            e.printStackTrace();
            throw new RuntimeException("fuck");
        }
    }
}