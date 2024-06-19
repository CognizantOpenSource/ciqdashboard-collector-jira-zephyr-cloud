package com.cognizant.collector.jirazephyr.beans.zephyr;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
public class SearchObject {

    @JsonProperty("execution")
    private Execution execution;

    @JsonProperty("issueKey")
    private String issueKey;
    @JsonProperty("issueLabel")
    private String issueLabel;
    @JsonProperty("component")
    private String component;
    @JsonProperty("issueSummary")
    private String issueSummary;
    @JsonProperty("issueDescription")
    private String issueDescription;
    @JsonProperty("projectName")
    private String projectName;
    @JsonProperty("versionName")
    private String versionName;
    @JsonProperty("priority")
    private String priority;
    @JsonProperty("executedByDisplayName")
    private String executedByDisplayName;
    @JsonProperty("assigneeType")
    private String assigneeType;
    @JsonProperty("assignedToDisplayName")
    private String assignedToDisplayName;
    @JsonProperty("testStepBeans")
    private Object testStepBeans;
    @JsonProperty("defectsAsString")
    private Object defectsAsString;
    @JsonProperty("projectKey")
    private String projectKey;
    @JsonProperty("plannedExecutionTimeFormatted")
    private Object plannedExecutionTimeFormatted;
    @JsonProperty("actualExecutionTimeFormatted")
    private Object actualExecutionTimeFormatted;
    @JsonProperty("executionWorkflowStatus")
    private Object executionWorkflowStatus;
    @JsonProperty("workflowLoggedTimedIncreasePercentage")
    private String workflowLoggedTimedIncreasePercentage;
    @JsonProperty("workflowCompletePercentage")
    private String workflowCompletePercentage;
    @JsonProperty("versionReleased")
    private Object versionReleased;
    @JsonProperty("customFieldValuesAsString")
    private Object customFieldValuesAsString;
    @JsonProperty("viewIssuePermission")
    private Boolean viewIssuePermission;
    @JsonProperty("executionWorkflowEnabled")
    private Boolean executionWorkflowEnabled;

}
