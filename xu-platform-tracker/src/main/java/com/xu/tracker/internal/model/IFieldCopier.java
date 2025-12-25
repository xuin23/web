package com.xu.tracker.internal.model;

import com.xu.platform.persistence.model.IPObject;

import java.util.Set;

public interface IFieldCopier<T extends IPObject> {
    
    IFieldCopier<T> includeKeys( Set<String> var1);

    
    IFieldCopier<T> includeAllCustomFields(boolean var1);

    
    IFieldCopier<T> excludeKeys( Set<String> var1);

    
    IResult to( T var1);

    public interface IResult {
        
        Set<String> convertedCopiedCustomFields();
    }
}
