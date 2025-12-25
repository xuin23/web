package com.xu.tracker.model.signatures;

import com.xu.platform.persistence.IEnumeration;
import com.xu.tracker.model.IStatusOpt;

import java.util.List;

public interface IWorkflowSignaturesManager<T extends IWorkflowSignature> {
    
    List<T> getSortedWorkflowSignatures();

    
    T addWorkflowSignature( IStatusOpt var1);


    T getWorkflowSignature( IStatusOpt var1);

    void removeWorkflowSignature( IStatusOpt var1);

    
    IEnumeration<ISignatureVerdictOpt> getVerdictEnumeration();
}