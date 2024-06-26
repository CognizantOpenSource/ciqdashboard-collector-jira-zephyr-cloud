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

package com.cognizant.collector.jirazephyr.service;

import com.cognizant.collector.jirazephyr.beans.core.IssueLink;
import com.cognizant.collector.jirazephyr.beans.core.JiraIssue;
import com.cognizant.collector.jirazephyr.component.CommonUtilComponent;
import com.cognizant.collector.jirazephyr.db.repo.JiraIssueRepository;
import com.mongodb.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
/**
 * JiraIssueService
 * @author Cognizant
 */

@Service
public class JiraIssueService {
    @Autowired
    JiraIssueRepository repository;
    @Autowired
    MongoTemplate mongoTemplate;

    public List<JiraIssue> getAll() {
        return repository.findAll();
    }

    public Optional<JiraIssue> get(String id) {
        return repository.findById(id);
    }

    public JiraIssue add(JiraIssue issue){
        return repository.save(issue);
    }

    public List<JiraIssue> addAll(List<JiraIssue> issues){
        return repository.saveAll(issues);
    }

//    public Date getMaxUpdatedDate(String projectKey){
//        JiraIssue first = repository.findFirstByProjectKeyOrderByUpdatedDesc(projectKey);
//        return first == null ? null : first.getUpdated();
//    }

    public Date getMaxUpdatedDate(String projectId) {
        JiraIssue first = repository.findFirstByProjectIdOrderByUpdatedDesc(projectId);
        return first == null ? null : first.getUpdated();
    }

    public List<JiraIssue> findByProjectId(String projectId) {
        return repository.findByProjectId(projectId);
    }

    public List<JiraIssue> deleteByKey(String key) {
        return repository.deleteByKey(key);
    }

    public List<JiraIssue> deleteByProjectId(String projectId) {

        return repository.deleteByProjectId(projectId);

    }

}
