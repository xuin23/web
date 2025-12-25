package com.xu.subterra.base.data.model.internal;

import com.xu.subterra.base.data.model.IEnumType;

import java.io.Serializable;

public class EnumType implements IEnumType, Serializable {

    private final String enumId;

    public EnumType(String enumId) {
        if (enumId == null) {
            throw new NullPointerException("Enum Id can't be null");
        } else {
            this.enumId = enumId;
        }
    }

    public String getEnumerationId() {
        return this.enumId;
    }

    public boolean equals(Object obj) {
        if (obj instanceof IEnumType lt) {
            return this.getEnumerationId().equals(lt.getEnumerationId());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.enumId.hashCode();
    }

    public String toString() {
        return "EnumType[enumId=" + this.getEnumerationId() + "]";
    }
}
