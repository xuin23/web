package com.xu.platform.persistence.model;

import com.xu.platform.persistence.IDataService;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;

public interface IPObjectList<T extends IPObject> extends List<T> {
    IPObjectList EMPTY_POBJECTLIST = new EmptyList();

    IDataService getDataService();

    void resolveAll();

    void resolveFirst(int var1);

    void resolve(int var1, int var2);

    public static class EmptyList extends AbstractList implements IPObjectList, Serializable {
        private static final long serialVersionUID = -7066388566707217392L;

        private EmptyList() {
        }

        public int size() {
            return 0;
        }

        public boolean contains(Object obj) {
            return false;
        }

        public Object get(int index) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        private Object readResolve() {
            return EMPTY_POBJECTLIST;
        }

        public void resolveAll() {
        }

        public void resolveFirst(int n) {
        }

        public void resolve(int first, int lenght) {
        }

        public IDataService getDataService() {
            return null;
        }
    }
}