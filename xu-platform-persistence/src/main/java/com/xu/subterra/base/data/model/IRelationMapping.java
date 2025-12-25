package com.xu.subterra.base.data.model;

import com.xu.subterra.base.location.ILocation;

import java.util.Collection;

public interface IRelationMapping {
    
    String getId();

    
    String getName();

    
    IType getFrom();

    
    IType getTo();

    
    ILocation getLocation();

    
    Collection<IValueMapping> getValueMappings();

    
    Collection<?> getFilteredValues( Object var1);
}