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

package com.cognizant.collector.jirazephyr.client;

import com.cognizant.collector.jirazephyr.beans.*;
import com.cognizant.collector.jirazephyr.beans.core.JiraIssueDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
/**
 * JiraClient - Refers to jirazephyr server API's
 * @author Cognizant
 */

public interface JiraClient {

    @GetMapping("/myself")
    MySelf getMySelf();

    @GetMapping("/project")
    List<Project> getJiraProjects();

    @GetMapping("/search")
    JiraIssueDetails getJiraIssues(@RequestParam Map<String, String> requestParams);

    @GetMapping("/project/{projectId}/versions")
    List<Map<?,?>> getProjectVersions(
            @PathVariable String projectId
    );

}
