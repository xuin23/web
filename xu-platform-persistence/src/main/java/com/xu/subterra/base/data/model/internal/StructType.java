package com.xu.subterra.base.data.model.internal;


import com.xu.subterra.base.data.model.IStructType;
import com.xu.subterra.base.data.model.IType;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public final class StructType implements IStructType, Serializable {

    private final String id;
    private final Map<String,Object> keys;
    private final String toString;

    public StructType(String id, Map keys) {
        if (id == null) {
            throw new NullPointerException("Type id can not be null.");
        } else {
            this.id = id;
            this.keys = keys;
            this.toString = "StructType[id=" + id + ";keys=" + keys + "]";
        }
    }

    public String getStructTypeId() {
        return this.id;
    }

    public Collection<String> getKeyNames() {
        return Collections.unmodifiableCollection(this.keys.keySet());
    }

    public boolean hasKey(String key) {
        return this.keys.containsKey(key);
    }

    public IType getKeyType(String key) {
        return (IType)this.keys.get(key);
    }


    public String toString() {
        return this.toString;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof IStructType) {
            IStructType lt = (IStructType)obj;
            return this.id.equals(lt.getStructTypeId()) && this.compareKeys(lt);
        } else {
            return false;
        }
    }

    private boolean compareKeys(IStructType lt) {
        Collection<String> keyNames = this.getKeyNames();
        if (lt.getKeyNames().size() != keyNames.size()) {
            return false;
        } else {
            for(String key : keyNames) {
                if (!this.getKeyType(key).equals(lt.getKeyType(key))) {
                    return false;
                }
            }

            return true;
        }
    }

    public int hashCode() {
        return this.toString().hashCode();
    }
}
