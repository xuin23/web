package com.xu.tracker.model;

import com.xu.platform.persistence.model.IPObjectList;
import com.xu.tracker.ITrackerService;
import com.xu.tracker.model.signatures.IWorkflowSignature;
import com.xu.tracker.model.signatures.IWorkflowSignaturesManager;

import java.util.List;
import java.util.Map;

public interface IWorkflowObject {

    String KEY_TYPE = "type";

    String KEY_STATUS = "status";

    String KEY_WORKFLOW_SIGNATURES = "workflowSignatures";


    void setType( ITypeOpt var1);

    
    ITypeOpt getType();

    
    IStatusOpt getStatus();

    
    IWorkflowAction[] getAvailableActions();

    
    Map<IWorkflowAction, String> getUnavailableActions();

    
    IWorkflowAction getInitialAction();

    
    IPObjectList performAction(int var1);

    void resetWorkflow();

    
    ITrackerService getTrackerService();


    IWorkflowObjectPermissions can();

    
    <T extends IWorkflowSignature> IWorkflowSignaturesManager<T> getWorkflowSignaturesManager();

    
    <T extends IWorkflowSignature> List<T> getWorkflowSignatures();
}
