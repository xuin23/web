package com.xu.tracker.model;

import com.xu.platform.persistence.IEnumOption;

import java.net.URI;
import java.util.Collection;

public interface IWithLinkedOslcResources extends IWorkflowObject {
    String KEY_LINKED_OSLC_RESOURCES = "linkedOslcResources";

    boolean addLinkedOslcResource( URI var1,  IEnumOption var2,  String var3);

    
    Collection<ILinkedOslcResourceStruct> getLinkedOslcResourcesStructs();

}