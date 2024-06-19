package com.cognizant.collector.jirazephyr.beans.zephyr;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.time.*;
import java.util.*;

@Data
public class Cycle {

    @JsonProperty("createdByAccountId")
    private String cycleCreatedByAccountId;
    @JsonProperty("endDate")
    private Date cycleEndDate;
    @JsonProperty("modifiedByAccountId")
    private String cycleModifiedByAccountId;
    @JsonProperty("tenantKey")
    private String cycleTenantKey;
    @JsonProperty("description")
    private String cycledDescription;
    @JsonProperty("cycleIndex")
    private String cycleIndex;
    @JsonProperty("creationDate")
    private Date cycleCreationDate;
    @JsonProperty("projectCycleVersionIndex")
    private String projectCycleVersionIndex;
    @JsonProperty("environment")
    private String environment;
    @JsonProperty("versionId")
    private Long versionId;
    @JsonProperty("build")
    private String build;
    @JsonProperty("createdBy")
    private String cycleCreatedBy;
    @JsonProperty("name")
    private String cycleName;
    @JsonProperty("modifiedBy")
    private String cycleModifiedBy;
    @JsonProperty("id")
    private String cycleId;
    @JsonProperty("projectId")
    private Long projectId;
    @JsonProperty("startDate")
    private Date cycleStartDate;

}
