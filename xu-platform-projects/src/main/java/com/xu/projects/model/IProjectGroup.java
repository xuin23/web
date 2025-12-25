package com.xu.projects.model;

import com.xu.platform.persistence.model.IPObjectList;

public interface IProjectGroup extends IGroupEntity {
    String PROTO = "ProjectGroup";
    String KEY_PARENT = "parent";
    String KEY_PROJECTS = "projects";
    String KEY_GROUPS = "groups";
    String KEY_NAME = "name";

    IProjectGroup getParentProjectGroup();

    IPObjectList getContainedProjects();

    IPObjectList getSortedContainedProjects();

    IPObjectList getSortedDeepContainedProjects();

    IPObjectList getDeepContainedProjects();

    String getName();

    IPObjectList getContainedGroups();

    IPObjectList getSortedContainedGroups();
}