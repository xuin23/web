package com.xu.tracker.internal.model;

import com.xu.tracker.model.IWorkflowObject;

public interface IInternalWorkflowObject extends IWorkflowObject {
    
    SignaturesMode getSignaturesMode();

    enum SignaturesMode {
        OFF,
        AUTO,
        ON;
    }
}
