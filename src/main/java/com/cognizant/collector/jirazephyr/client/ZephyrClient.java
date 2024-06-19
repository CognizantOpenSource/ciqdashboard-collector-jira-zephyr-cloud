package com.cognizant.collector.jirazephyr.client;

import com.cognizant.collector.jirazephyr.beans.zephyr.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

public interface ZephyrClient {

    @GetMapping("/public/rest/api/1.0/cycles/search")
    List<Cycle> getCycles(
            @RequestHeader Map<String, String> headers,
            @RequestParam Map<String, Object> requestParams
    );

    @GetMapping("/public/rest/api/1.0/executions/search/cycle/{cycleId}")
    ExecutionInfo getExecutions(
            @RequestHeader Map<String, String> headers,
            @PathVariable String cycleId,
            @RequestParam Map<String, Object> requestParams
    );

}
