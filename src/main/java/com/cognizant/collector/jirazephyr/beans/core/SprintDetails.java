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

package com.cognizant.collector.jirazephyr.beans.core;

import com.cognizant.collector.jirazephyr.util.*;
import com.fasterxml.jackson.databind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * SprintDetails
 * @author Cognizant
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize(using = SprintDetailsDeserializer.class)
public class SprintDetails {
    private String sprintId;
    private Integer sprintRapidViewId;
    private String sprintState;
    private String sprintName;
    private Integer sprintSequence;
    private Object sprintGoal;
    private String sprintStartDate;
    private String sprintEndDate;
    private String sprintCompleteDate;
    private String sprintActivatedDate;
    private Boolean sprintAutoStartStop;
}
