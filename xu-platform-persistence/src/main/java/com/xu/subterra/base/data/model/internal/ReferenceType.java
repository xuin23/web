package com.xu.subterra.base.data.model.internal;

import com.xu.subterra.base.data.model.IReferenceType;

import java.io.Serializable;

public class ReferenceType implements IReferenceType, Serializable {

    private final String prototypeName;

    public ReferenceType(String prototypeName) {
        this.prototypeName = prototypeName;
    }

    public String toString() {
        return "ReferenceType[prototype=" + this.prototypeName + "]";
    }

    public String getPrototype() {
        return this.prototypeName;
    }

    public boolean equals(Object obj) {
        if (obj instanceof IReferenceType) {
            IReferenceType lt = (IReferenceType)obj;
            return this.getPrototype().equals(lt.getPrototype());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.getPrototype().hashCode();
    }
}