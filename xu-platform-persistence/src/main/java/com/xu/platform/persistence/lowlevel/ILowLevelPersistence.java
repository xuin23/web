package com.xu.platform.persistence.lowlevel;

import com.xu.platform.persistence.model.IPObject;

import java.util.List;

public interface ILowLevelPersistence {
    List<IPObject> sqlSearch(String var1);
}
