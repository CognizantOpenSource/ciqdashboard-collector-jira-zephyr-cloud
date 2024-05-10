package com.cognizant.collector.jirazephyr.db.repo;

import com.cognizant.collector.jirazephyr.beans.core.*;
import com.cognizant.collector.jirazephyr.beans.zephyr.*;
import org.springframework.data.mongodb.repository.*;

/**
 * ZephyrExecutionRepository
 * @author Cognizant
 */

public interface ZephyrExecutionRepository extends MongoRepository<ZephyrExecution, Long> {

    ZephyrExecution findFirstByProjectIdOrderByExecutedOnDesc(int projectId);
}
