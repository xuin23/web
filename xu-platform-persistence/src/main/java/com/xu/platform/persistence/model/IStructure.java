package com.xu.platform.persistence.model;

import com.xu.platform.persistence.IEnumeration;
import com.xu.subterra.base.data.model.IStructType;

public interface IStructure extends IChangeListener, IChangeGenerator, IHasValues {
    IStructType getPrototype();

    Object getValue(String var1);

    void setValue(String var1, Object var2);

    boolean isReadOnly();

    boolean isReadOnly(String var1);

    boolean isModified();

    IEnumeration getEnumeration(String var1);
}
