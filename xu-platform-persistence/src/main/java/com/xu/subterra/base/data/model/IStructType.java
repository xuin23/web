package com.xu.subterra.base.data.model;

import java.util.Collection;

public interface IStructType extends IType {
    String getStructTypeId();

    boolean hasKey(String var1);

    Collection getKeyNames();

    IType getKeyType(String var1);

}
