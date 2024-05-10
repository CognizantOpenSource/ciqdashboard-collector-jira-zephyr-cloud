package com.cognizant.collector.jirazephyr.beans.core;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.*;

@Data
public class IssueLink {

    @JsonProperty("inwardIssue")
    private JiraIssueInfo inwardIssue;

    @JsonProperty("outwardIssue")
    private JiraIssueInfo outwardIssue;

    private String parentId;

}
