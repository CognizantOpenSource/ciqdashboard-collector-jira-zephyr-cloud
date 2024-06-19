package com.cognizant.collector.jirazephyr.beans.zephyr;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
public class Version {

    @JsonProperty("value")
    private String id;
    @JsonProperty("archived")
    private Boolean archived;
    @JsonProperty("label")
    private String name;

}