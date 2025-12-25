package com.xu.tracker.model;

public interface ILinkedWorkItemStruct {
    String KEY_WORK_ITEM = "workItem";
    String KEY_ROLE = "role";
    String KEY_REVISION = "revision";
    String KEY_SUSPECT = "suspect";

    IWorkItem getLinkedItem();

    ILinkRoleOpt getLinkRole();

    boolean isSuspect();

    void setSuspect(boolean var1);

    String getRevision();

    void setRevision(String var1);
}
