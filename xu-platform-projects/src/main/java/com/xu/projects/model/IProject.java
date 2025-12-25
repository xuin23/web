package com.xu.projects.model;

import com.xu.subterra.base.location.ILocation;
import com.xu.core.util.types.Text;
import java.util.Date;

public interface IProject extends IGroupEntity {
    String PROTO = "Project";
    String KEY_PROJECT_GROUP = "projectGroup";
    String KEY_ID = "id";
    String KEY_NAME = "name";
    String KEY_DESCRIPTION = "description";
    String KEY_LEAD = "lead";
    String KEY_ACTIVE = "active";
    String KEY_LOCK_WORK_RECORDS_DATE = "lockWorkRecordsDate";

    IProjectGroup getProjectGroup();

    ILocation getLocation();

    String getId();

    String getName();

    void setName(String var1);

    Text getDescription();

    void setDescription(Text var1);

    IUser getLead();

    void setLead(IUser var1);

    boolean isActive();

    void setActive(boolean var1);

    Date getLockWorkRecordsDate();

    void setLockWorkRecordsDate(Date var1);

}