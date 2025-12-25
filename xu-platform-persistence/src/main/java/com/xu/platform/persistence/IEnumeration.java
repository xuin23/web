package com.xu.platform.persistence;

import com.xu.platform.persistence.model.IPObject;

import java.util.List;

public interface IEnumeration<T extends IEnumOption> {
    T wrapOption(String var1);

    T wrapOption(String var1, Object var2);

    T wrapOption(String var1, IPObject var2);

    List<T> getAvailableOptions(Object var1);

    String getControlKey();

    List<T> getAllOptions();

    List<T> getAvailableOptions(Object var1, IEnumOption var2);

    T getDefaultOption(Object var1);
}
