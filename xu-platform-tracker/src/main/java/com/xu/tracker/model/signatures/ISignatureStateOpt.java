package com.xu.tracker.model.signatures;

import com.xu.platform.persistence.IEnumOption;

public interface ISignatureStateOpt extends IEnumOption {
    
    String OPT_NOT_AVAILABLE = "notAvailable";
    
    String OPT_PENDING = "pending";
    
    String OPT_DECLINED = "declined";
    
    String OPT_READY = "ready";
    
    String OPT_DONE = "done";
    
    String OPT_OBSOLETE = "obsolete";

    boolean canPerformTransition();

    boolean isObsolete();

    boolean isClosed();

    boolean isActive();
}
