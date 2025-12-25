package com.xu.projects.model;

import com.xu.platform.persistence.model.IPObject;

public interface IUniqueObject extends IPObject {
    String KEY_ID = "id";
    String KEY_PROJECT = "project";

    String getId();

    IProject getProject();

    String getProjectId();
}
