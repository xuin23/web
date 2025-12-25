package com.xu.tracker.model.signatures;

import com.xu.platform.persistence.IEnumOption;

public interface ISignatureVerdictOpt extends IEnumOption {
    
    String OPT_INVITED = "invited";
    
    String OPT_SIGNED = "signed";
    
    String OPT_DECLINED = "declined";
}
