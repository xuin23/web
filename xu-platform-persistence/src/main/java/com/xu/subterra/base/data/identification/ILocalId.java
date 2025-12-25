package com.xu.subterra.base.data.identification;

public interface ILocalId {

    String PROTOTYPE_START_DELIM = "{";
    char PROTOTYPE_START_DELIM_CHAR = '{';
    String PROTOTYPE_END_DELIM = "}";
    char PROTOTYPE_END_DELIM_CHAR = '}';
    String CONTAINER_DELIM = "#";
    char CONTAINER_DELIM_CHAR = '#';
    String REVISION_DELIM = "%";
    char REVISION_DELIM_CHAR = '%';
    String TEMPORARY_OBJECT_NAME_PREFIX = "*";
    char TEMPORARY_OBJECT_NAME_PREFIX_CHAR = '*';

    String getPrototypeName();

    ILocalId getContainerId();

    String getObjectName();

    ILocalId setObjectName(String var1);

    String getRevision();

    ILocalId removeRevision();

    ILocalId setRevision(String var1);

    boolean isTemporary();

    String toNormalizedString();

    String toPrototypeLessNormalizedString();
}
