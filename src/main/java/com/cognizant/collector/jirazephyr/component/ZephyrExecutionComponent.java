package com.cognizant.collector.jirazephyr.component;

import com.cognizant.collector.jirazephyr.beans.*;
import com.cognizant.collector.jirazephyr.beans.zephyr.*;
import com.cognizant.collector.jirazephyr.client.*;
import com.cognizant.collector.jirazephyr.service.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;

import java.util.*;

import static com.cognizant.collector.jirazephyr.constants.Constant.*;

@Component
@Slf4j
public class ZephyrExecutionComponent {

    @Autowired
    ZephyrClient zephyrClient;
    @Autowired
    ZephyrExecutionService zephyrExecutionService;
    @Autowired
    CommonUtilComponent utilComponent;


    private List<Cycle> getCycles(String projectId, String projectVersionId) {

        Map<String, Object> cycleRequestParams = new HashMap<>();
        cycleRequestParams.put(PROJECT_ID, projectId);
        cycleRequestParams.put(VERSION_ID, projectVersionId);

        return zephyrClient.getCycles(utilComponent.getHeaders(ENDPOINT_CYCLE, cycleRequestParams), cycleRequestParams);
    }

    private ExecutionInfo getExecutions(String projectId, String projectVersionId, String cycleId, Integer size, Integer offset) {

        Map<String, Object> executionRequesParams = new HashMap<>();
        executionRequesParams.put(PROJECT_ID, projectId);
        executionRequesParams.put(VERSION_ID, projectVersionId);
        executionRequesParams.put(SIZE, size);
        executionRequesParams.put(OFFSET, offset);

        return zephyrClient.getExecutions(utilComponent.getHeaders(String.format(ENDPOINT_EXECUTION, cycleId), executionRequesParams), cycleId,executionRequesParams);
    }

    public void getZephyrTests(Project project, String projectVersionId) {

        List<Cycle> cycles = getCycles(project.getId(), projectVersionId);

        cycles.forEach(cycle -> {

            int offset = OFFSET_VALUE;
            int size = SIZE_VALUE;
            boolean iscompleted = false;

            do {

                ExecutionInfo executionInfo = getExecutions(project.getId(), projectVersionId, cycle.getCycleId(), size, offset);

                if(CollectionUtils.isEmpty(executionInfo.getSearchObjectList())) {
                    iscompleted = true;
                }
                else {

                    log.info("Zephyr Request Params = VersionId : {}, CycleId : {}, SIze : {}, Offset : {}",projectVersionId, cycle.getCycleId(), size, offset);

                    offset += size;
                    if(executionInfo.getTotalCount() < offset) iscompleted = true;

                    log.info("Executions count form server : {}", executionInfo.getSearchObjectList().size());

                    executionInfo.getSearchObjectList().forEach(exec -> {

                        ZephyrExecution zephyrExecution = new ZephyrExecution();

                        BeanUtils.copyProperties(exec , zephyrExecution);
                        BeanUtils.copyProperties(exec.getExecution() , zephyrExecution);
                        BeanUtils.copyProperties(cycle , zephyrExecution);

                        zephyrExecution.setProjectName(project.getName());
                        zephyrExecution.setProjectKey(project.getKey());

                        this.storeTestInDB(zephyrExecution);
                    });
                }
            }
            while(!iscompleted);

        });

    }


    private void storeTestInDB(ZephyrExecution execution) {
        zephyrExecutionService.save(execution);
    }
}
