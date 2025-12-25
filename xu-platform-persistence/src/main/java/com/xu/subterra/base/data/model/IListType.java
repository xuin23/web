package com.xu.subterra.base.data.model;

public interface IListType extends IType {
    String getListTypeId();

    IType getItemType();
}
