package com.cognizant.collector.jirazephyr.beans.zephyr;

import lombok.*;

@Data
public class Defect {

    private Long id;
    private String key;
    private String summary;
    private Status status;

}
