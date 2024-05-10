package com.cognizant.collector.jirazephyr.component;

import com.cognizant.collector.jirazephyr.beans.*;
import com.cognizant.collector.jirazephyr.client.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
@Slf4j
public class JiraComponent {

    @Autowired
    JiraClient jiraClient;

    @Autowired
    ZephyrExecutionComponent zephyrExecutionComponent;
    @Autowired
    JiraIssueComponent jiraIssueComponent;

    @Value("${jiraServer.projects}")
    private List<String> projectKeys;

    public List<Project> getProjects() {
        return jiraClient.getJiraProjects().stream().filter(project -> projectKeys.contains(project.getKey())).collect(Collectors.toList());
    }

    public List<Map<?,?>> getProjectVersions(String projectId) {
        return jiraClient.getProjectVersions(projectId);
    }



    public void getIssues() {

        getProjects().forEach(project -> {

            log.info("********* Project Name: {}", project.getName());

            jiraIssueComponent.getAllIssuesByProjectId(project);

            List<String> projectVersions = getProjectVersions(project.getId()).stream()
                    .map(t -> (String) t.get("id"))
                    .collect(Collectors.toList());

            projectVersions.add("-1");
            projectVersions.forEach(projectVersion -> {
                zephyrExecutionComponent.getZephyrTests(project, projectVersion);
            });
        });

    }
}
