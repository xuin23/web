package com.xu.platform.persistence.spi;

import com.xu.platform.persistence.IDataService;
import com.xu.platform.persistence.IEnumOption;
import com.xu.platform.persistence.model.*;
import com.xu.subterra.base.data.identification.IContextId;
import com.xu.subterra.base.data.identification.ILocalId;
import com.xu.subterra.base.data.identification.IObjectId;
import com.xu.subterra.base.data.model.ICustomField;
import com.xu.subterra.base.data.model.IType;

import java.io.Serializable;
import java.util.*;

public class PObject  implements IPObject, Serializable, IHasChangeListeners {

    @Override
    public IPrototype getPrototype() {
        return null;
    }

    @Override
    public Object adapt(Class<?> targetClass) {
        return null;
    }

    @Override
    public void markChanged() {

    }

    @Override
    public Object getValue(String var1) {
        return null;
    }

    @Override
    public void setValue(String key, Object value) {

    }

    @Override
    public void addChangeListener(IChangeListener changeListener) {

    }
}