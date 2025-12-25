package com.xu.tracker.model;

import com.xu.core.util.types.Text;
import com.xu.platform.persistence.model.IPObject;
import com.xu.platform.persistence.model.IRevision;
import com.xu.tracker.spi.model.IHasRelativeFilePath;

import java.util.List;

public interface IInternalWorkItem extends IWorkItem, IPObject, IHasRelativeFilePath {
    String INDEX_FIELD_SUSPECT = "suspect";


    String getReferencePath();


    IWorkItemFieldCopier copy();

    void setNotOnlyCommentsChanged();

    void prepareForRevisionNotification( IRevision var1);



    List<ILinkedWorkItemStruct> getLowLevelWorkItemLinks();
}