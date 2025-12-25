package com.xu.tracker.model.signatures;

import com.xu.projects.model.IUniqueObject;
import com.xu.projects.model.IUser;
import com.xu.tracker.model.IStatusOpt;
import com.xu.tracker.model.IWorkflowObject;

import java.util.List;

public interface IWorkflowSignature extends IUniqueObject {
    String PROTO = "WorkflowSignature";
    
    String KEY_TARGET_STATUS_ID = "targetStatusId";
    
    String KEY_SIGNATURE_STATE = "signatureState";
    
    String KEY_TRANSITION_DATA_REVISION = "transitionDataRevision";
    
    String KEY_SIGNATURES = "signatures";
    
    String KEY_WORKFLOW_OBJECT = "workflowObject";
    
    String ENUM_ID_SIGNATURE_STATE = "signature-state";

    
    IWorkflowObject getWorkflowObject();

    
    IStatusOpt getTargetStatus();

    
    String getTransitionRevision();

    boolean isClosed();

    
    List<ISignature> getSignatures();

    
    ISignature addSignature( IUser var1);

    
    ISignature getSignature( IUser var1);

    void removeSignature( IUser var1);

    void resetSignatures();

    
    ISignatureStateOpt getSignatureState();

    void setObsolete(boolean var1);

    
    String getLabel();
}