package com.xu.tracker.internal.model;

import com.xu.platform.persistence.spi.PObject;
import com.xu.projects.model.IProject;
import com.xu.projects.model.IUniqueObject;

public class UniqueObject  extends PObject implements IUniqueObject {

    public String getId() {
        return (String)this.getValue("id");
    }

    public IProject getProject() {
        return null;
    }

    public String getProjectId() {
        return null;
    }


}
