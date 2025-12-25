package com.xu.tracker.model;

import com.xu.platform.persistence.model.IPObjectPermissions;

public interface IWorkflowObjectPermissions extends IPObjectPermissions {
    boolean sign();

    boolean manageSignatures();

    boolean comment();
}
