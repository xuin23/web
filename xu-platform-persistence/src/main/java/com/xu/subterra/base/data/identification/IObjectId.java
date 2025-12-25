package com.xu.subterra.base.data.identification;

public interface IObjectId {
    String CONTEXT_DELIM = "$";
    char CONTEXT_DELIM_CHAR = '$';

    IContextId getContextId();

    ILocalId getLocalId();

    IObjectId removeContextId();

    IObjectId removeRevision();

    IObjectId setContextId(IContextId var1);

    IObjectId setLocalId(ILocalId var1);

    String toNormalizedString();

    String toPrototypeLessNormalizedString();
}
