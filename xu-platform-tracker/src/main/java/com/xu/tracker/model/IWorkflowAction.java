package com.xu.tracker.model;

import com.xu.platform.persistence.IEnumOption;

public interface IWorkflowAction {

    String getNativeActionId();

    int getActionId();


    String getActionName();


    String[] getRequiredFeatures();


    String[] getSuggestedFeatures();


    String[] getCleanedFeatures();


    String[] getRequiredRoles();

    IEnumOption getTargetStatus();

    boolean isSignatureRequired();

    boolean isAddingSignature();
}
