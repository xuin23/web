package com.xu.tracker.model;

import com.xu.subterra.base.data.identification.ILocalId;

import java.util.Set;

public interface IWorkItem extends IWorkflowObject, IWithAttachments<IAttachment>, IWithLinkedOslcResources{

    String PROTO = "WorkItem";
    String KEY_TITLE = "title";
    String KEY_DESCRIPTION = "description";
    String KEY_RESOLUTION = "resolution";
    String KEY_CATEGORIES = "categories";
    String KEY_TIME_POINT = "timePoint";
    String KEY_APPROVALS = "approvals";
    String KEY_LINKED_REVISIONS = "linkedRevisions";
    String KEY_LINKED_REVISIONS_DERIVED = "linkedRevisionsDerived";
    String KEY_ASSIGNEE = "assignee";
    String KEY_AUTHOR = "author";
    String KEY_COMMENTS = "comments";
    String KEY_LINKED_WORK_ITEMS = "linkedWorkItems";
    String KEY_LINKED_WORK_ITEMS_DERIVED = "linkedWorkItemsDerived";
    String KEY_EXTERNALLY_LINKED_WORK_ITEMS = "externallyLinkedWorkItems";
    String KEY_HYPERLINKS = "hyperlinks";
    String KEY_PLANNING_CONSTRAINTS = "planningConstraints";
    String KEY_SEVERITY = "severity";
    String KEY_PRIORITY = "priority";
    String KEY_WORK_RECORDS = "workRecords";
    String KEY_LOCATION = "location";
    String KEY_LOCATION_TOKENIZED = "location.tokenized";
    String KEY_LOCATION_TREE = "location.tree";
    String KEY_MODULE = "module";
    String KEY_OUTLINE_NUMBER = "outlineNumber";
    String KEY_DUE_DATE = "dueDate";
    String KEY_INITIAL_ESTIMATE = "initialEstimate";
    String KEY_TIME_SPENT = "timeSpent";
    String KEY_REMAINING_ESTIMATE = "remainingEstimate";
    String KEY_CREATED = "created";
    String KEY_UPDATED = "updated";
    String KEY_PLANNED_START = "plannedStart";
    String KEY_PLANNED_END = "plannedEnd";

    String KEY_PLANNED_IN = "plannedIn";
    String KEY_RESOLVED_ON = "resolvedOn";
    String ENUM_ID_TYPE = "work-item-type";
    String ENUM_ID_STATUS = "status";
    String ENUM_ID_SEVERITY = "severity";
    String ENUM_ID_PRIORITY = "priority";
    String ENUM_ID_LINK_ROLE = "wi-link-role";
    String TYPE_STRUCT_APPROVAL = "Approval";
    String TYPE_STRUCT_LINKED_WORK_ITEM = "LinkedWorkItem";
    String TYPE_STRUCT_LINKED_REVISION = "LinkedRevision";
    String TYPE_STRUCT_HYPERLINK = "Hyperlink";
    String TYPE_STRUCT_PLANNING_CONSTRAINT = "PlanningConstraint";
    String ATTACHMENT_IMG_PREFIX = "workitemimg:";
    String ATTACHMENT_REVISION = "attachmentRevision";
    String ATTACHMENT_NAME = "attachmentName";
    String[] FIELD_ORDER = new String[]{"id", "type", "title", "description", "assignee", "status", "resolution", "comments", "workRecords", "plannedStart", "plannedEnd"};
    Set<String> DIFF_IGNORED_FIELDS = Set.of("updated", "previousStatus", "location", "plannedStart", "plannedEnd", "outlineNumber", "linkedWorkItemsDerived");

    public static class RenderingOptions {
        public boolean renderComments = true;
        public boolean renderImages = true;
        public boolean renderImagesAsPlainText = false;
        /** @deprecated */
        @Deprecated
        public boolean renderImagesFromHead = false;
        public boolean absoluteLinks = false;
        public ILocalId currentDocumentId = null;
    }
}
