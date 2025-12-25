package com.xu.tracker.model.signatures;

import com.xu.platform.persistence.model.IStructure;
import com.xu.projects.model.IUser;

import java.util.Date;

public interface ISignature extends IStructure {
    
    String STRUCTURE_ID = "Signature";
    
    String KEY_SIGNED_BY = "signedBy";
    
    String KEY_VERDICT = "verdict";
    
    String KEY_VERDICT_TIME = "verdictTime";
    
    String KEY_SIGNED_REVISION = "signedRevision";
    
    String KEY_SIGNER_ROLE = "signerRole";
    
    String KET_VERDICT_COMMENT = "verdictComment";
    
    String ENUM_ID_SIGNATURE_VERDICT = "signature-verdict";

    
    IUser getSignedBy();

    
    ISignatureVerdictOpt getVerdict();

    ISignature sign( String var1);

    void setSignedRevision( String var1);

    void setVerdict( ISignatureVerdictOpt var1);

    
    Date getVerdictTime();

    
    String getSignedRevision();

    
    String getSignerRole();

    void setSignerRole( String var1);

}