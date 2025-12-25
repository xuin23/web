package com.xu.tracker.model;

import com.xu.tracker.internal.model.IAttachmentId;
import com.xu.tracker.internal.model.IFieldCopier;

import java.util.Map;
import java.util.Set;

public interface IWorkItemFieldCopier {
    
    IWorkItemFieldCopier includeKeys( Set<String> var1);

    
    IWorkItemFieldCopier includeAllCustomFields(boolean var1);

    
    IWorkItemFieldCopier excludeKeys( Set<String> var1);

    
    IWorkItemResult to( IWorkItem var1);

    
    IWorkItemFieldCopier includeAttachmentsFromDescription(boolean var1);

    public interface IWorkItemResult extends IFieldCopier.IResult {
        
        Map<IAttachmentId, IAttachmentId> getAttachmentsMap();
    }
}
