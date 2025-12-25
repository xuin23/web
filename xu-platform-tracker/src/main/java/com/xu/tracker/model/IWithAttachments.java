package com.xu.tracker.model;

import com.xu.platform.persistence.model.IPObjectList;

import java.io.InputStream;

public interface IWithAttachments<T extends IAttachmentBase> {
    String KEY_ATTACHMENTS = "attachments";

    
    T createAttachment( String var1, String var2,  InputStream var3);

    
    IPObjectList<T> getAttachments();

   
    T getAttachment( String var1);

    void deleteAttachment( T var1);
}
