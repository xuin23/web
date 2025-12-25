package com.xu.platform.persistence;

import com.xu.platform.persistence.model.IPObject;
import com.xu.platform.persistence.model.IPObjectList;

public interface IDataService {

    <T extends IPObject> IPObjectList<T> sqlSearch(String sql);
}
