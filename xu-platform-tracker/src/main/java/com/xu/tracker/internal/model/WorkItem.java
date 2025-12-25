package com.xu.tracker.internal.model;

import com.xu.platform.persistence.IEnumOption;
import com.xu.platform.persistence.lowlevel.LowLevelWorkItem;
import com.xu.platform.persistence.model.IPObjectList;
import com.xu.platform.persistence.model.IRevision;
import com.xu.tracker.ITrackerService;
import com.xu.tracker.model.*;
import com.xu.tracker.model.signatures.IWorkflowSignature;
import com.xu.tracker.model.signatures.IWorkflowSignaturesManager;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class WorkItem extends WorkflowObject implements IInternalWorkItem {

    private LowLevelWorkItem lowLevelWorkItem;

    @Override
    public String getReferencePath() {
        return "";
    }

    @Override
    public IWorkItemFieldCopier copy() {
        return null;
    }

    @Override
    public void setNotOnlyCommentsChanged() {

    }

    @Override
    public void prepareForRevisionNotification(IRevision var1) {

    }

    @Override
    public List<ILinkedWorkItemStruct> getLowLevelWorkItemLinks() {
        return List.of();
    }

    @Override
    public IAttachment createAttachment(String var1, String var2, InputStream var3) {
        return null;
    }

    @Override
    public IPObjectList<IAttachment> getAttachments() {
        return null;
    }

    @Override
    public IAttachment getAttachment(String var1) {
        return null;
    }

    @Override
    public void deleteAttachment(IAttachment var1) {

    }


    @Override
    public Path toRelativeFilePath() {
        return null;
    }

    @Override
    public SignaturesMode getSignaturesMode() {
        return null;
    }

    @Override
    public boolean addLinkedOslcResource(URI var1, IEnumOption var2, String var3) {
        return false;
    }

    @Override
    public Collection<ILinkedOslcResourceStruct> getLinkedOslcResourcesStructs() {
        return List.of();
    }

    @Override
    public void setType(ITypeOpt var1) {

    }

    @Override
    public ITypeOpt getType() {
        return null;
    }

    @Override
    public IStatusOpt getStatus() {
        return null;
    }

    @Override
    public IWorkflowAction[] getAvailableActions() {
        return new IWorkflowAction[0];
    }

    @Override
    public Map<IWorkflowAction, String> getUnavailableActions() {
        return Map.of();
    }

    @Override
    public IWorkflowAction getInitialAction() {
        return null;
    }

    @Override
    public IPObjectList performAction(int var1) {
        return null;
    }

    @Override
    public void resetWorkflow() {

    }

    @Override
    public ITrackerService getTrackerService() {
        return null;
    }

    @Override
    public IWorkflowObjectPermissions can() {
        return null;
    }

    @Override
    public <T extends IWorkflowSignature> IWorkflowSignaturesManager<T> getWorkflowSignaturesManager() {
        return null;
    }

    @Override
    public <T extends IWorkflowSignature> List<T> getWorkflowSignatures() {
        return List.of();
    }
}
