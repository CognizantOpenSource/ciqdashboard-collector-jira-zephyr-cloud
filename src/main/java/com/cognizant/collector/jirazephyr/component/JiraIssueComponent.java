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

package com.cognizant.collector.jirazephyr.component;

import com.cognizant.collector.jirazephyr.beans.Project;
import com.cognizant.collector.jirazephyr.beans.core.*;
import com.cognizant.collector.jirazephyr.client.JiraClient;
import com.cognizant.collector.jirazephyr.service.JiraIssueService;
import com.mongodb.client.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

import static com.cognizant.collector.jirazephyr.constants.Constant.*;
/**
 * JiraIssueComponent
 * @author Cognizant
 */

@Component
@Slf4j
public class JiraIssueComponent {

    @Autowired
    JiraIssueService service;
    @Autowired
    JiraClient client;
    @Autowired
    CommonUtilComponent utilComponent;


    public JiraIssueDetails getIssues(Map<String, String> requestParam) {
        return client.getJiraIssues(requestParam);
    }

    private List<JiraIssue> saveAllIssuesInDB(List<JiraIssue> issues) {
        return service.addAll(issues);
    }

    private void getIssuesAndStoreInDB(List<JiraIssueInfo> issueInfoList) {
        List<JiraIssue> issues = issueInfoList.stream().map(jiraIssueInfo -> jiraIssueInfo.getJiraIssue()).collect(Collectors.toList());

        List<JiraIssue> jiraIssues = saveAllIssuesInDB(issues);
    }

    public void getAllIssuesByProjectId(Project project) {

//        getAllIssuesKeyByProjectId(project);

        Map<String, String> map = new HashMap<>();
        int resultPerPage = RESULTS_PER_PAGE;
        int startAt = PAGE_STARTS_AT;
        boolean isCompleted = false;
        Date maxUpdatedDate = service.getMaxUpdatedDate(project.getId());
        String jqlParamString = utilComponent.getJqlParamString(project.getId(), maxUpdatedDate);
        map.put(JQL, jqlParamString);
        map.put(MAX_RESULTS, String.valueOf(resultPerPage));
        do {

            map.put(START_AT, String.valueOf(startAt));
            log.info("StartAt:{}, MaxResult:{}, JqlString:{}", startAt, resultPerPage, jqlParamString);
            JiraIssueDetails issues = getIssues(map);

            List<JiraIssueInfo> issueInfoList = issues.getIssues();

            if (CollectionUtils.isEmpty(issueInfoList)) {
                isCompleted = true;
            } else {
                startAt += resultPerPage;
                if (issues.getTotal() < startAt) isCompleted = true;
                log.info("Issues count form server : {}", issueInfoList.size());
                getIssuesAndStoreInDB(issueInfoList);
            }
        } while (!isCompleted);

    }

//    private void removeIssuesForDeletedProjectsFromDB(List<Project> projects) {
//
//        List<String> projectIdInResponse = projects.stream().map(Project::getId).distinct().collect(Collectors.toList());
//        List<String> projectIdInDB = service.getAll().stream().map(JiraIssue::getProjectId).distinct().collect(Collectors.toList());
//
//        projectIdInDB.removeAll(projectIdInResponse);
//        projectIdInDB.forEach(deletedProjectId -> service.deleteByProjectId(deletedProjectId));
//
//    }
//
//    private void getAllIssuesKeyByProjectId(Project project) {
//
//        List<String> issueKeysInResponse = new ArrayList<>();
//
//        Map<String, String> map = new HashMap<>();
//        int resultPerPage = RESULTS_PER_PAGE;
//        int startAt = PAGE_STARTS_AT;
//        boolean isCompleted = false;
//        String jqlParamString = utilComponent.getJqlParamString(project.getId());
//        map.put(JQL, jqlParamString);
//        map.put(MAX_RESULTS, String.valueOf(resultPerPage));
//
//        do {
//            map.put(START_AT, String.valueOf(startAt));
//            JiraIssueDetails issues = getIssues(map);
//
//            List<JiraIssueInfo> issueInfoList = issues.getIssues();
//
//            if (CollectionUtils.isEmpty(issueInfoList)) {
//                isCompleted = true;
//            } else {
//                startAt += resultPerPage;
//                if (issues.getTotal() < startAt) isCompleted = true;
//                issueKeysInResponse.addAll(issueInfoList.stream().map(JiraIssueInfo::getKey).collect(Collectors.toList()));
//            }
//        } while (!isCompleted);
//
//        removeDeletedIssuesFromDb(project, issueKeysInResponse);
//
//    }
//
//    private void removeDeletedIssuesFromDb(Project project, List<String> issueKeysInResponse) {
//
//        List<String> issueKeysInDB = service.findByProjectId(project.getId()).stream().map(JiraIssue::getKey).collect(Collectors.toList());
//        issueKeysInDB.removeAll(issueKeysInResponse);
//
//        issueKeysInDB.forEach(deletedIssueKey -> {
//            service.deleteByKey(deletedIssueKey);
//        });
//
//    }

}
