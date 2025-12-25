package com.xu.subterra.base.data.model.internal;

import com.xu.subterra.base.data.model.IListType;
import com.xu.subterra.base.data.model.IType;

import java.io.Serializable;

public final class ListType implements IListType, Serializable {
    private final String typeId;
    private final IType itemType;
    private final String toString;

    public ListType(String typeId, IType itemType) {
        if (typeId == null) {
            throw new NullPointerException("Type id can not be null.");
        } else {
            this.typeId = typeId;
            this.itemType = itemType;
            this.toString = "ListType[typeId=" + typeId + ";itemType=" + this.getItemType() + "]";
        }
    }

    public IType getItemType() {
        return this.itemType;
    }

    public String getListTypeId() {
        return this.typeId;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof IListType) {
            IListType lt = (IListType)obj;
            return this.getListTypeId().equals(lt.getListTypeId()) && this.getItemType().equals(lt.getItemType());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.toString().hashCode();
    }

    public String toString() {
        return this.toString;
    }
}