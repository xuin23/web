package com.xu.platform.persistence.lowlevel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "workitem")
public class LowLevelWorkItem extends LowLevelPObject {

    @Id
    @Column(name = "c_pk")
    private Long pk;

    @Column(name = "c_uri")
    private Long uri;

    @Column(name = "c_rev")
    private Long rev;

    @Column(name = "c_deleted")
    private String deleted;

    @Column(name = "fk_author")
    private Long fkAuthor;

    @Column(name = "fk_uri_author")
    private Long uriAuthor;

    @Column(name = "c_created")
    private LocalDateTime created;

    @Column(name = "c_description")
    private String description;

    @Column(name = "c_duedate")
    private LocalDate dueDate;

    @Column(name = "c_id")
    private String id;

    @Column(name = "c_initialestimate")
    private Float initialEstimate;

    @Column(name = "c_location")
    private String location;

    @Column(name = "fk_module")
    private Long moduleId;

    @Column(name = "fk_uri_module")
    private Long uriModule;

    @Column(name = "c_outlinenumber")
    private String outlineNumber;

    @Column(name = "c_plannedend")
    private LocalDateTime plannedEnd;

    @Column(name = "c_plannedstart")
    private LocalDateTime plannedStart;

    @Column(name = "c_previousstatus")
    private String previousStatus;

    @Column(name = "c_priority")
    private String priority;

    @Column(name = "fk_project")
    private Long projectId;

    @Column(name = "fk_uri_project")
    private Long uriProject;

    @Column(name = "c_remainingestimate")
    private Float remainingEstimate;

    @Column(name = "c_resolution")
    private String resolution;

    @Column(name = "c_resolvedon")
    private LocalDateTime resolvedOn;

    @Column(name = "c_severity")
    private String severity;

    @Column(name = "c_status")
    private String status;

    @Column(name = "fk_timepoint")
    private Long timepointId;

    @Column(name = "fk_uri_timepoint")
    private Long uriTimepoint;

    @Column(name = "c_timespent")
    private Float timeSpent;

    @Column(name = "c_title")
    private String title;

    @Column(name = "c_type")
    private String type;

    @Column(name = "c_updated")
    private LocalDateTime updated;


    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public Long getUri() {
        return uri;
    }

    public void setUri(Long uri) {
        this.uri = uri;
    }

    public Long getRev() {
        return rev;
    }

    public void setRev(Long rev) {
        this.rev = rev;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public Long getFkAuthor() {
        return fkAuthor;
    }

    public void setFkAuthor(Long fkAuthor) {
        this.fkAuthor = fkAuthor;
    }

    public Long getUriAuthor() {
        return uriAuthor;
    }

    public void setUriAuthor(Long uriAuthor) {
        this.uriAuthor = uriAuthor;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getInitialEstimate() {
        return initialEstimate;
    }

    public void setInitialEstimate(Float initialEstimate) {
        this.initialEstimate = initialEstimate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Long getUriModule() {
        return uriModule;
    }

    public void setUriModule(Long uriModule) {
        this.uriModule = uriModule;
    }

    public String getOutlineNumber() {
        return outlineNumber;
    }

    public void setOutlineNumber(String outlineNumber) {
        this.outlineNumber = outlineNumber;
    }

    public LocalDateTime getPlannedEnd() {
        return plannedEnd;
    }

    public void setPlannedEnd(LocalDateTime plannedEnd) {
        this.plannedEnd = plannedEnd;
    }

    public LocalDateTime getPlannedStart() {
        return plannedStart;
    }

    public void setPlannedStart(LocalDateTime plannedStart) {
        this.plannedStart = plannedStart;
    }

    public String getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(String previousStatus) {
        this.previousStatus = previousStatus;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUriProject() {
        return uriProject;
    }

    public void setUriProject(Long uriProject) {
        this.uriProject = uriProject;
    }

    public Float getRemainingEstimate() {
        return remainingEstimate;
    }

    public void setRemainingEstimate(Float remainingEstimate) {
        this.remainingEstimate = remainingEstimate;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public LocalDateTime getResolvedOn() {
        return resolvedOn;
    }

    public void setResolvedOn(LocalDateTime resolvedOn) {
        this.resolvedOn = resolvedOn;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTimepointId() {
        return timepointId;
    }

    public void setTimepointId(Long timepointId) {
        this.timepointId = timepointId;
    }

    public Long getUriTimepoint() {
        return uriTimepoint;
    }

    public void setUriTimepoint(Long uriTimepoint) {
        this.uriTimepoint = uriTimepoint;
    }

    public Float getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Float timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
