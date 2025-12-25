package com.xu.subterra.base.data.model.internal;


import com.xu.subterra.base.data.model.IPrimitiveType;

import java.io.Serializable;

public final class PrimitiveType implements IPrimitiveType, Serializable {

    private final String typeName;
    private static final char SUBTYPE_DELIM = '/';
    private transient String realTypeName;
    private transient String realSubtype;

    public PrimitiveType(String typeName) {
        this(typeName, (String)null);
    }

    public PrimitiveType(String typeName, String subtype) {
        this.realTypeName = null;
        if (subtype != null) {
            this.typeName = typeName + '/' + subtype;
        } else {
            this.typeName = typeName;
        }

        this.realTypeName = typeName;
        this.realSubtype = subtype;
    }

    private void ensureRealValues() {
        if (this.realTypeName == null) {
            int i = this.typeName.indexOf(47);
            if (i >= 0) {
                this.realTypeName = this.typeName.substring(0, i);
                this.realSubtype = this.typeName.substring(i + 1);
            } else {
                this.realTypeName = this.typeName;
            }
        }

    }

    public String getTypeName() {
        this.ensureRealValues();
        return this.realTypeName;
    }

    public String getSubtype() {
        this.ensureRealValues();
        return this.realSubtype;
    }


    public String toString() {
        return "PrimitiveType[typeName=" + this.getTypeName() + ", subtype=" + this.getSubtype() + "]";
    }
}
