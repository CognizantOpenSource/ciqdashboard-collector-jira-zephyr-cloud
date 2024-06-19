package com.cognizant.collector.jirazephyr.beans.zephyr;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@Data
public class Execution {

    @JsonProperty("id")
    private String id;
    @JsonProperty("issueId")
    private Long issueId;
    @JsonProperty("versionId")
    private Long versionId;
    @JsonProperty("projectId")
    private Long projectId;
//    @JsonProperty("cycleId")
//    private String cycleId;
    @JsonProperty("orderId")
    private Long orderId;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("executedBy")
    private String executedBy;
    @JsonProperty("executedByAccountId")
    private String executedByAccountId;
    private Date executedOn;

    @JsonProperty("executedOn")
    public void setExecutedOn(Long executedOn) {
        this.executedOn = new Date(executedOn);
    }

    @JsonProperty("modifiedBy")
    private String modifiedBy;
    @JsonProperty("modifiedByAccountId")
    private String modifiedByAccountId;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("createdByAccountId")
    private String createdByAccountId;
    private Status status;

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
        this.statusId = status.getId();
        this.statusName = status.getName();
        this.statusDescription = status.getDescription();
    }

    @Setter(AccessLevel.NONE)
    private Long statusId;
    @Setter(AccessLevel.NONE)
    private String statusName;
    @Setter(AccessLevel.NONE)
    private String statusDescription;

//    @JsonProperty("cycleName")
//    private String cycleName;
    @JsonProperty("assignedTo")
    private String assignedTo;
    @JsonProperty("defects")
    private Defect[] defects;
    @JsonProperty("stepDefects")
    private Object stepDefects;
    @JsonProperty("executionDefectCount")
    private Long executionDefectCount;
    @JsonProperty("stepDefectCount")
    private Long stepDefectCount;
    @JsonProperty("totalDefectCount")
    private Long totalDefectCount;
    private Date creationDate;

    @JsonProperty("creationDate")
    public void setCreationDate(Long creationDate) {
        this.creationDate = new Date(creationDate);
    }

    @JsonProperty("executedByZapi")
    private Boolean executedByZapi;
    private Date assignedOn;

    @JsonProperty("assignedOn")
    public void setAssignedOn(Long assignedOn) {
        this.assignedOn = new Date(assignedOn);
    }

    @JsonProperty("customFieldValues")
    private Object customFieldValues;
    @JsonProperty("issueIndex")
    private Long issueIndex;
    @JsonProperty("projectCycleVersionIndex")
    private String projectCycleVersionIndex;
    @JsonProperty("executionStatusIndex")
    private Long executionStatusIndex;
    @JsonProperty("projectIssueCycleVersionIndex")
    private String projectIssueCycleVersionIndex;

}
