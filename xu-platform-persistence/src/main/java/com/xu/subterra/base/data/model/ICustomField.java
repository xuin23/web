package com.xu.subterra.base.data.model;

import java.util.Collection;

public interface ICustomField {
    String getId();

    IType getType();

    String getName();

    String getDescription();

    boolean isRequired();

    boolean isMulti();

    boolean isReference();

    Object getDefaultValue();

    String getDependsOn();

    Collection<String> getDependentFieldIds();

    IRelationMapping getDependencyMapping();
}
