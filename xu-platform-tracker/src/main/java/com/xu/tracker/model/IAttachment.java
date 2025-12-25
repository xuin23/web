package com.xu.tracker.model;

public interface IAttachment extends IAttachmentBase {
    String PROTO = "Attachment";
    String KEY_WORK_ITEM = "workItem";

    IWorkItem getWorkItem();
}