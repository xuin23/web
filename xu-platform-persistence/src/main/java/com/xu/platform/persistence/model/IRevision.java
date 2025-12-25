package com.xu.platform.persistence.model;

import java.util.Date;
import java.util.List;

public interface IRevision {
    String PROTO = "Revision";
    String KEY_NAME = "name";
    String KEY_REPOSITORY_NAME = "repositoryName";
    String KEY_AUTHOR = "author";
    String KEY_CREATED = "created";
    String KEY_MESSAGE = "message";
    String KEY_INTERNAL_COMMIT = "internalCommit";

    String getName();

    String getRepositoryName();

    String getStringAuthor();

    Date getCreated();

    String getMessage();

    boolean isInternalCommit();

    boolean isExternal();

    String getViewURL();

}
