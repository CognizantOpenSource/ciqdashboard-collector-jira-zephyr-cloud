package com.cognizant.collector.jirazephyr.beans.zephyr;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "#{T(com.cognizant.collector.jirazephyr.component.CommonUtilComponent).getZephyrTestRunCollectionName()}")
public class ZephyrExecution {

    /* Execution */
    @Id
    private String id;
    private String comment;
    private String build;
    private String environment;
    private Date creationDate;
    private Date executedOn;
    private String createdBy;
    private String createdByAccountId;
    private Date assignedOn;
    private String assignedTo;
    private String assigneeType;
    private String assignedToDisplayName;
    private String executedBy;
    private String executedByDisplayName;
    private String executedByAccountId;
    private String modifiedBy;
    private String modifiedByAccountId;
    private String priority;
    private Long statusId;
    private String statusName;
    private String statusDescription;
    private Long executionStatusIndex;
    private Defect[] defects;
    private Object stepDefects;
    private Long executionDefectCount;
    private Long stepDefectCount;
    private Long totalDefectCount;
    private Boolean executedByZapi;
    private Object customFieldValues;
    private String projectCycleVersionIndex;
    private String projectIssueCycleVersionIndex;
    private Object testStepBeans;
    private Object defectsAsString;
    private Object plannedExecutionTimeFormatted;
    private Object actualExecutionTimeFormatted;
    private Object executionWorkflowStatus;
    private String workflowLoggedTimedIncreasePercentage;
    private String workflowCompletePercentage;
    private Object versionReleased;
    private Object customFieldValuesAsString;
    /* Execution */

    /*Project*/
    private Long projectId;
    private String projectKey;
    private String projectName;
    /*Project*/

    /*Version*/
    private Long versionId;
    private String versionName;
    /*Version*/

    /*Issue*/
    private Long issueId;
    private String issueKey;
    private Long issueIndex;
    private String issueLabel;
    private String component;
    private String issueSummary;
    private String issueDescription;
    private Boolean viewIssuePermission;
    private Boolean executionWorkflowEnabled;
    /*Issue*/

    /*cycle*/
    private String cycleId;
    private Long orderId;
    private String cycleName;
    private String cycleIndex;
    private String cycleTenantKey;
    private String cycledDescription;
    private Date cycleCreationDate;
    private Date cycleStartDate;
    private Date cycleEndDate;
    private String cycleCreatedBy;
    private String cycleCreatedByAccountId;
    private String cycleModifiedBy;
    private String cycleModifiedByAccountId;
    /*cycle*/

}
