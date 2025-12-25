package com.xu.subterra.base.data.object;

import com.xu.subterra.base.data.model.ICustomField;

import java.util.Set;

public interface IDataObject {


    Object getValue(String var1);

    void setValue(String var1, Object var2);

    Set<String> getKeySet();

    IDataObject cloneInstance();

    void removeKey(String var1);

    Object getCustomValue(String var1);

    void setCustomValue(String var1, Object var2);

    void setCustomValue(String var1, Object var2, ICustomField var3);

    Set<String> getCustomKeySet();

    void removeCustomKey(String var1);

    Set<String> getIncompatibleCustomKeySet();

    ICustomField getIncompatibleCustomField(String var1);

    Object getIncompatibleCustomValue(String var1);
}
