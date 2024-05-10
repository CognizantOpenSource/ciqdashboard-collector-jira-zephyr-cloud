package com.cognizant.collector.jirazephyr.beans.zephyr;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@Data
public class ExecutionInfo {

    @JsonProperty("searchObjectList")
    private List<SearchObject> searchObjectList = new ArrayList<>();

    @JsonProperty("summaryList")
    private Object summaryList;

    @JsonProperty("totalCount")
    private Integer totalCount;

    @JsonProperty("currentOffset")
    private Integer currentOffset;

    @JsonProperty("maxAllowed")
    private Integer maxAllowed;

    @JsonProperty("executionStatus")
    private Object executionStatus;

    @JsonProperty("stepExecutionStatus")
    private Object stepExecutionStatus;

}
