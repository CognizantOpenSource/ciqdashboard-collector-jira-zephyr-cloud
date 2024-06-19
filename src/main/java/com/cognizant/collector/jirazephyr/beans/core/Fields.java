/*
 *  © [2021] Cognizant. All rights reserved.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.cognizant.collector.jirazephyr.beans.core;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Fields
 * @author Cognizant
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "issuetype",
        "components",
        "timespent",
        "timeoriginalestimate",
        "description",
        "project",
        "fixVersions",
        "aggregatetimespent",
        "resolution",
//        "customfield_10035",
        "timetracking",
//        "customfield_10104",
//        "customfield_10203",
//        "customfield_10105",
        "attachment",
        "aggregatetimeestimate",
        "resolutiondate",
        "workratio",
        "summary",
        "lastViewed",
        "watches",
        "creator",
        "subtasks",
        "created",
        "reporter",
//        "customfield_10000",
        "aggregateprogress",
        "priority",
//        "customfield_10100",
//        "customfield_10201",
        "labels",
//        "customfield_10202",
        "environment",
        "timeestimate",
        "aggregatetimeoriginalestimate",
        "versions",
        "duedate",
        "progress",
        "comment",
        "issuelinks",
        "votes",
        "worklog",
        "assignee",
        "updated",
        "status"
})
public class Fields {
    @JsonProperty("issuetype")
    private IssueType issuetype;
    @JsonProperty("components")
    private List<Object> components = null;
    @JsonProperty("timespent")
    private Object timeSpent;
    @JsonProperty("timeoriginalestimate")
    private Object timeOriginalEstimate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("project")
    private Project project;
    @JsonProperty("fixVersions")
    private List<FixVersion> fixVersions = null;
    @JsonProperty("aggregatetimespent")
    private Object aggregateTimeSpent;
    @JsonProperty("resolution")
    private Resolution resolution;
    //    @JsonProperty("customfield_10035")
//    private Object customfield_10035;
    @JsonProperty("timetracking")
    private Object timeTracking;
//    @JsonProperty("customfield_10104")
//    private Object customField10104;

    //    @JsonProperty("customfield_10101")
//    private List<String> customfield_10101 = null;
//    @JsonProperty("customfield_10203")
//    private Object customField10203;
//    @JsonProperty("customfield_10105")
//    private Object customField10105;
    @JsonProperty("attachment")
    private List<Object> attachment = null;
    @JsonProperty("aggregatetimeestimate")
    private Object aggregateTimeEstimate;
    @JsonProperty("resolutiondate")
    private String resolutionDate;
    @JsonProperty("workratio")
    private Long workRatio;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("lastViewed")
    private Object lastViewed;
    @JsonProperty("watches")
    private Object watches;
    @JsonProperty("creator")
    private User creator;
    @JsonProperty("subtasks")
    private List<Object> subTasks = null;
    @JsonProperty("created")
    private Date created;
    @JsonProperty("reporter")
    private User reporter;
    //    @JsonProperty("customfield_10000")
//    private Object customField10000;
    @JsonProperty("aggregateprogress")
    private Object aggregateProgress;
    @JsonProperty("priority")
    private Object priority;
    //    @JsonProperty("customfield_10100")
//    private Object customField10100;
//    @JsonProperty("customfield_10201")
//    private Object customField10201;
    @JsonProperty("labels")
    private List<Object> labels = null;
    //    @JsonProperty("customfield_10202")
//    private Object customField10202;
    @JsonProperty("timeestimate")
    private Object timeEstimate;
    @JsonProperty("aggregatetimeoriginalestimate")
    private Object aggregateTimeOriginalEstimate;
    @JsonProperty("versions")
    private Object versions = null;
//    private Versions versions;

    @JsonProperty("duedate")
    private Object dueDate;
    @JsonProperty("progress")
    private Object progress;
    @JsonProperty("comment")
    private Object comment;
    @JsonProperty("issuelinks")
    private List<IssueLink> issueLinks;
    @JsonProperty("votes")
    private Object votes;
    @JsonProperty("worklog")
    private Object workLog;
    @JsonProperty("assignee")
    private User assignee;
    @JsonProperty("updated")
    private Date updated;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("customfield_10005")
    private List<SprintDetails> sprintDetails;

//    @JsonProperty("customfield_11500")
//    private Object customfield_11500;
//    @JsonProperty("customfield_10416")
//    private Object customfield_10416;
//    @JsonProperty("customfield_10417")
//    private Object customfield_10417;
//    @JsonProperty("customfield_10418")
//    private Object customfield_10418;
//    @JsonProperty("customfield_10419")
//    private Object customfield_10419;
//    @JsonProperty("customfield_10106")
//    private Double customfield_10106;
//    @JsonProperty("customfield_10411")
//    private Object customfield_10411;

    @JsonProperty("customfield_16808")
    private Object defectType;
    @JsonProperty("customfield_11300")
    private Object causeOfDefect;
    @JsonProperty("customfield_10307")
    private Object severity;
    @JsonProperty("customfield_16801")
    private Object workstream;
    @JsonProperty("customfield_17101")
    private Object module;
    @JsonProperty("customfield_21807")
    private Object detectedInEnvironment;
    @JsonProperty("environment")
    private String environment;

    /*   @JsonIgnore
       private Map<String, Object> additionalProperties = new HashMap<>();

       @JsonAnyGetter
       public Map<String, Object> getAdditionalProperties() {
           return this.additionalProperties;
       }

       @JsonAnySetter
       public void setAdditionalProperty(String name, Object value) {
           this.additionalProperties.put(name, value);
       }
   */
    @JsonIgnore
    public JiraIssue getJiraIssue(JiraIssue issue) {
        BeanUtils.copyProperties(this, issue);

        this.setJiraIssueProject(issue);
        this.setJiraIssueIssueType(issue);
        this.setJiraIssueCreator(issue);
        this.setJiraIssueReporter(issue);
        this.setJiraIssueAssignee(issue);
        this.setJiraIssueResolution(issue);
        this.setJiraIssueStatus(issue);
        this.setJiraIssueSprintDetails(issue);
        this.setCustomField(issue);
        this.setJiraIssuePriority(issue);
        this.setJiraIssueFixVersion(issue);
        this.setJiraIssueComponents(issue);
        this.setJiraIssueVersion(issue);
        this.setLinkedIssue(issue);
        return issue;
    }

    private JiraIssue setCustomField(JiraIssue issue) {
        String value = "value";

        if (null != severity) issue.setSeverity((String) ((Map) severity).get(value));
        if (null != workstream) issue.setWorkstream((String) ((Map) workstream).get(value));
        if (null != module) issue.setModule((String) ((Map) module).get(value));
        if (null != causeOfDefect) issue.setCauseOfDefect((String) ((Map) causeOfDefect).get(value));
        if (null != detectedInEnvironment) issue.setDetectedInEnvironment((String) ((Map) detectedInEnvironment).get(value));
        if (null != defectType) issue.setDefectType((String) ((Map) defectType).get(value));

        return issue;
    }

    private JiraIssue setJiraIssueSprintDetails(JiraIssue issue) {
        if (null == sprintDetails) return issue;
        Optional<SprintDetails> sprint = Optional.empty();

        sprint = this.sprintDetails.stream().filter(s -> s.getSprintState()=="ACTIVE").findFirst();

        if(sprint.isPresent()) {
            return setSprintInfo(sprint, issue);
        }

        sprint = this.sprintDetails.stream().filter(s -> s.getSprintState()=="FUTURE").findFirst();

        if(sprint.isPresent()) {
            return setSprintInfo(sprint, issue);
        }

        sprint = this.sprintDetails.stream().filter(s -> s.getSprintState()=="CLOSED").findFirst();

        if(sprint.isPresent()) {
            return setSprintInfo(sprint, issue);
        }

        return issue;
    }

    @JsonIgnore
    private JiraIssue setSprintInfo(Optional<SprintDetails> sprint, JiraIssue issue) {
        if(sprint.isPresent()) {
            issue.setSprintActivatedDate(sprint.get().getSprintActivatedDate());
            issue.setSprintCompleteDate(sprint.get().getSprintCompleteDate());
            issue.setSprintEndDate(sprint.get().getSprintEndDate());
            issue.setSprintId(sprint.get().getSprintId());
            issue.setSprintName(sprint.get().getSprintName());
            issue.setSprintRapidViewId(sprint.get().getSprintRapidViewId());
            issue.setSprintSequence(sprint.get().getSprintSequence());
            issue.setSprintStartDate(sprint.get().getSprintStartDate());
            issue.setSprintState(sprint.get().getSprintState());
        }
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueStatus(JiraIssue issue) {
        /* status */
        if (null == status) return issue;
        issue.setStatusDescription(status.getDescription());
        issue.setStatusIconUrl(status.getIconUrl());
        issue.setStatusId(status.getId());
        issue.setStatusName(status.getName());
        issue.setStatusSelf(status.getSelf());

        /* statusCategory */
        StatusCategory statusCategory = status.getStatusCategory();
        if (null == statusCategory) return issue;
        issue.setStatusCategoryColorName(statusCategory.getColorName());
        issue.setStatusCategoryId(statusCategory.getId());
        issue.setStatusCategoryKey(statusCategory.getKey());
        issue.setStatusCategoryName(statusCategory.getName());
        issue.setStatusCategorySelf(statusCategory.getSelf());
        /* statusCategory */
        /* status */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueResolution(JiraIssue issue) {
        /* resolution */
        if (null == resolution) return issue;
        issue.setResolutionDescription(resolution.getDescription());
        issue.setResolutionId(resolution.getId());
        issue.setResolutionName(resolution.getName());
        issue.setResolutionSelf(resolution.getSelf());
        /* resolution */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueAssignee(JiraIssue issue) {
        /* assignee */
        if (null == assignee) return issue;
        issue.setAssigneeActive(assignee.getActive());
        issue.setAssigneeAvatarUrls(assignee.getAvatarUrls());
        issue.setAssigneeDisplayName(assignee.getDisplayName());
        issue.setAssigneeEmailAddress(assignee.getEmailAddress());
        issue.setAssigneeKey(assignee.getKey());
        issue.setAssigneeName(assignee.getName());
        issue.setAssigneeSelf(assignee.getSelf());
        issue.setAssigneeTimeZone(assignee.getTimeZone());
        /* assignee */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueReporter(JiraIssue issue) {
        /* reporter */
        if (null == reporter) return issue;
        issue.setReporterActive(reporter.getActive());
        issue.setReporterAvatarUrls(reporter.getAvatarUrls());
        issue.setReporterDisplayName(reporter.getDisplayName());
        issue.setReporterEmailAddress(reporter.getEmailAddress());
        issue.setReporterKey(reporter.getKey());
        issue.setReporterName(reporter.getName());
        issue.setReporterSelf(reporter.getSelf());
        issue.setReporterTimeZone(reporter.getTimeZone());
        /* reporter */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueCreator(JiraIssue issue) {
        /* creator */
        if (null == creator) return issue;
        issue.setCreatorActive(creator.getActive());
        issue.setCreatorAvatarUrls(creator.getAvatarUrls());
        issue.setCreatorDisplayName(creator.getDisplayName());
        issue.setCreatorEmailAddress(creator.getEmailAddress());
        issue.setCreatorKey(creator.getKey());
        issue.setCreatorName(creator.getName());
        issue.setCreatorSelf(creator.getSelf());
        issue.setCreatorTimeZone(creator.getTimeZone());
        /* creator */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueVersion(JiraIssue issue) {
        /* issueType */
        if(!CollectionUtils.isEmpty((Collection<?>) versions)) {
            issue.setVersionsId((String) ((Map) ((List) versions).get(0)).get("id"));
            issue.setVersionsName(((String) ((Map) ((List) versions).get(0)).get("name")));
        }
        this.versions = null;
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueIssueType(JiraIssue issue) {
        /* issueType */
        IssueType issueType = this.issuetype;
        if (null == issueType) return issue;
        issue.setIssueTypeId(issueType.getId());
        issue.setIssueTypeSelf(issueType.getSelf());
        issue.setIssueTypeName(issueType.getName());
        issue.setIssueTypeAvatarId(issueType.getAvatarId());
        issue.setIssueTypeDescription(issueType.getDescription());
        issue.setIssueTypeIconUrl(issueType.getIconUrl());
        issue.setIssueTypeSubtask(issueType.getSubtask());
        /* issueType */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueProject(JiraIssue issue) {
        /* project */
        if (null == project) return issue;
        issue.setProjectId(project.getId());
        issue.setProjectKey(project.getKey());
        issue.setProjectName(project.getName());
        issue.setProjectSelf(project.getSelf());
        issue.setProjectAvatarUrls(project.getAvatarUrls());
        issue.setProjectTypeKey(project.getProjectTypeKey());
        /* project */
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssuePriority(JiraIssue issue) {
        if (priority == null) return issue;
        issue.setPriority((String) ((Map) priority).get("name"));
        issue.setPriorityId((String) ((Map) priority).get("id"));
        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueFixVersion(JiraIssue issue) {
        if (fixVersions == null || fixVersions.size() <= 0) return issue;

        fixVersions.stream().findFirst().ifPresent(first -> {
            issue.setFixVersionId(first.getId());
            issue.setFixVersionName(first.getName());
            issue.setFixVersionArchived(first.getArchived());
            issue.setFixVersionReleased(first.getReleased());
            issue.setFixVersionReleaseDate(first.getReleaseDate());
        });

        return issue;
    }

    @JsonIgnore
    private JiraIssue setJiraIssueComponents(JiraIssue issue) {
        if (components == null || components.size() <= 0) return issue;
        issue.setComponentId((String) ((Map) components.get(0)).get("id"));
        issue.setComponentName((String) ((Map) components.get(0)).get("name"));
        return issue;
    }

    @JsonIgnore
    public JiraIssue setLinkedIssue(JiraIssue issue) {

        for(IssueLink issueLink : this.issueLinks) {

            if(null != issueLink.getInwardIssue()) {
                issue = setLinks(issueLink.getInwardIssue(), issue);
           }

           if(null != issueLink.getOutwardIssue()) {
               issue = setLinks(issueLink.getOutwardIssue(), issue);
           }

        }

        return issue;
    }

    @JsonIgnore
    public JiraIssue setLinks(JiraIssueInfo childIssue, JiraIssue jiraIssue) {

        String issueType;

        try {
            issueType = childIssue.getFields().getIssuetype().getName();
        }
        catch(NullPointerException e) {
            return jiraIssue;
        }

        switch (issueType){

            case "Epic":
                if(null == jiraIssue.getLinkedEpicId() && null == jiraIssue.getLinkedEpicKey()) {
                    jiraIssue.setLinkedEpicId(childIssue.getId());
                    jiraIssue.setLinkedEpicKey(childIssue.getKey());
                }
                else if(!isAlreadyLinked(jiraIssue.getLinkedEpicId(), childIssue.getId())) {
                    jiraIssue.setLinkedEpicId(jiraIssue.getLinkedEpicId()+","+childIssue.getId());
                    jiraIssue.setLinkedEpicKey(jiraIssue.getLinkedEpicKey()+","+childIssue.getKey());
                }
                return jiraIssue;

            case "Story":
                if(null == jiraIssue.getLinkedStoryId() && null == jiraIssue.getLinkedStoryKey()) {
                    jiraIssue.setLinkedStoryId(childIssue.getId());
                    jiraIssue.setLinkedStoryKey(childIssue.getKey());
                }
                else if(!isAlreadyLinked(jiraIssue.getLinkedStoryId(), childIssue.getId())) {
                    jiraIssue.setLinkedStoryId(jiraIssue.getLinkedStoryId()+","+childIssue.getId());
                    jiraIssue.setLinkedStoryKey(jiraIssue.getLinkedStoryKey()+","+childIssue.getKey());
                }
                return jiraIssue;

            case "Task":
                if(null == jiraIssue.getLinkedTaskId() && null == jiraIssue.getLinkedTaskKey()) {
                    jiraIssue.setLinkedTaskId(childIssue.getId());
                    jiraIssue.setLinkedTaskKey(childIssue.getKey());
                }
                else if(!isAlreadyLinked(jiraIssue.getLinkedTaskId(), childIssue.getId())) {
                    jiraIssue.setLinkedTaskId(jiraIssue.getLinkedTaskId()+","+childIssue.getId());
                    jiraIssue.setLinkedTaskKey(jiraIssue.getLinkedTaskKey()+","+childIssue.getKey());
                }
                return jiraIssue;

            case "Sub-task":
                if(null == jiraIssue.getLinkedSubTaskId() && null == jiraIssue.getLinkedSubTaskKey()) {
                    jiraIssue.setLinkedSubTaskId(childIssue.getId());
                    jiraIssue.setLinkedSubTaskKey(childIssue.getKey());
                }
                else if(!isAlreadyLinked(jiraIssue.getLinkedSubTaskId(), childIssue.getId())) {
                    jiraIssue.setLinkedSubTaskId(jiraIssue.getLinkedSubTaskId()+","+childIssue.getId());
                    jiraIssue.setLinkedSubTaskKey(jiraIssue.getLinkedSubTaskKey()+","+childIssue.getKey());
                }
                return jiraIssue;

            case "Test":
                if(null == jiraIssue.getLinkedTestId() && null == jiraIssue.getLinkedTestKey()) {
                    jiraIssue.setLinkedTestId(childIssue.getId());
                    jiraIssue.setLinkedTestKey(childIssue.getKey());
                }
                else if(!isAlreadyLinked(jiraIssue.getLinkedTestId(), childIssue.getId())) {
                    jiraIssue.setLinkedTestId(jiraIssue.getLinkedTestId()+","+childIssue.getId());
                    jiraIssue.setLinkedTestKey(jiraIssue.getLinkedTestKey()+","+childIssue.getKey());
                }
                return jiraIssue;

            case "Bug":
                if(null == jiraIssue.getLinkedBugId() && null == jiraIssue.getLinkedBugKey()) {
                    jiraIssue.setLinkedBugId(childIssue.getId());
                    jiraIssue.setLinkedBugKey(childIssue.getKey());
                }
                else if(!isAlreadyLinked(jiraIssue.getLinkedBugId(), childIssue.getId())) {
                    jiraIssue.setLinkedBugId(jiraIssue.getLinkedBugId()+","+childIssue.getId());
                    jiraIssue.setLinkedBugKey(jiraIssue.getLinkedBugKey()+","+childIssue.getKey());
                }
                return jiraIssue;
        }

        return jiraIssue;
    }

    @JsonIgnore
    private boolean isAlreadyLinked(String currentString,String newString) {

        if(currentString.contains(",")) {
            return List.of(currentString.split(",")).contains(newString);
        }
        return currentString.equals(newString);
    }

}

