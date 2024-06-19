package com.cognizant.collector.jirazephyr.util;

import com.cognizant.collector.jirazephyr.beans.core.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class SprintDetailsDeserializer extends JsonDeserializer {

    @Override
    public SprintDetails deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JacksonException {

        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        String sprint = jsonNode.asText();

        sprint = sprint.split("\\[")[1];

        HashMap<String, String> map =
                (HashMap<String, String>) Arrays.asList(sprint.split(","))
                        .stream()
                        .map(s -> s.split("="))
                        .collect(Collectors.toMap(
                                e -> e[0], e -> e[1]));
        createSprint(map);

        return null;
    }

    private void createSprint(HashMap<String, String> sprint) {

        SprintDetails sprintDetails = new SprintDetails();

        sprint.keySet().forEach(key -> {

            switch (key.trim()) {
                case "id":
                    sprintDetails.setSprintId(sprint.get(key).trim());
                    break;
                case "name":
                    sprintDetails.setSprintName(sprint.get(key).trim());
                    break;
                case "startDate":
                    sprintDetails.setSprintStartDate(sprint.get(key).trim());
                    break;
                case "endDate":
                    sprintDetails.setSprintEndDate(sprint.get(key).trim());
                    break;
                case "completeDate":
                    sprintDetails.setSprintCompleteDate(sprint.get(key).trim());
                    break;
                case "activatedDate":
                    sprintDetails.setSprintActivatedDate(sprint.get(key).trim());
                    break;
                case "sequence":
                    sprintDetails.setSprintSequence(Integer.parseInt(sprint.get(key).trim()));
                    break;
                case "autoStartStop":
                    sprintDetails.setSprintAutoStartStop(Boolean.parseBoolean(sprint.get(key).trim()));
                    break;

            }




        });






    }
}
