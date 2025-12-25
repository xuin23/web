package com.xu.platform.persistence.model;

import com.xu.platform.persistence.IDataService;
import com.xu.subterra.base.data.model.ITypedWrapperFactory;
import com.xu.subterra.base.data.object.IDataObject;

public interface IPObjectFactory extends ITypedWrapperFactory {

    IPObject createObjectForDAO(IDataObject var1, IDataService var2);

    IPObject createNewObject(IPrototype var1, IDataService var2);
}
