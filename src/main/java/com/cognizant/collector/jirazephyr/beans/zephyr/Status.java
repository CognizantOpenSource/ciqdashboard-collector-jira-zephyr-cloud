package com.cognizant.collector.jirazephyr.beans.zephyr;

import com.cognizant.collector.jirazephyr.util.*;
import com.fasterxml.jackson.databind.annotation.*;
import lombok.*;

import java.util.*;

@Data
public class Status {

    private Long id;
    private String name;
    private String description;

}

