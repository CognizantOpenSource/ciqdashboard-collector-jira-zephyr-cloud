package com.cognizant.collector.jirazephyr.service;

import com.cognizant.collector.jirazephyr.beans.zephyr.*;
import com.cognizant.collector.jirazephyr.component.*;
import com.cognizant.collector.jirazephyr.db.repo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Service
public class ZephyrExecutionService {

    @Autowired
    ZephyrExecutionRepository zephyrExecutionRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    public ZephyrExecution save(ZephyrExecution execution) {
        return zephyrExecutionRepository.save(execution);
    }

    public List<ZephyrExecution> saveAll(List<ZephyrExecution> executions) {
        return zephyrExecutionRepository.saveAll(executions);
    }

//    public LocalDate getLastExecutionDate(String projectId) {
//        ZephyrExecution first = zephyrExecutionRepository.findFirstByProjectIdOrderByExecutedOnDesc(Integer.parseInt(projectId));
//        return first == null ? null : first.getExecutedOn();
//    }

}
