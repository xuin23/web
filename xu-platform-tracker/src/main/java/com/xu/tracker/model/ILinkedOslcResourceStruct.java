package com.xu.tracker.model;

import com.xu.platform.persistence.IEnumOption;
import com.xu.platform.persistence.model.IStructure;

import java.net.URI;

public interface ILinkedOslcResourceStruct extends IStructure, Comparable<ILinkedOslcResourceStruct> {
    String KEY_URI = "uri";
    String KEY_LABEL = "label";
    String KEY_ROLE = "role";

    String getLabel();

    IEnumOption getLinkRole();

    URI getURI();
}
