package com.cognizant.collector.jirazephyr.beans.zephyr;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@Data
public class VersionInfo {

    @JsonProperty("type")
    private String type;

    @JsonProperty("hasAccessToSoftware")
    private boolean hasAccessToSoftware;

    @JsonProperty("unreleasedVersions")
    private List<Version> unreleasedVersions;

    @JsonProperty("releasedVersions")
    private List<Version> releasedVersions;

}
