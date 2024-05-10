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

package com.cognizant.collector.jirazephyr.component;

import com.cognizant.collector.jirazephyr.constants.*;
import com.cognizant.collector.jirazephyr.service.JiraIssueService;
import com.thed.zephyr.cloud.rest.*;
import com.thed.zephyr.cloud.rest.client.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.*;

import javax.annotation.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

import static com.cognizant.collector.jirazephyr.constants.Constant.*;
/**
 * CommonUtilComponent
 * @author Cognizant
 */

@Component
@Slf4j
public class CommonUtilComponent {

    @Autowired
    JiraIssueService service;

    @Value("${zephyrServer.url}")
    private String zephyrServerUrl;
    @Value("${zephyrServer.accessKey}")
    private String zephyrAccessKey;
    @Value("${zephyrServer.secretKey}")
    private String zephyrSecretKey;
    public static String accountId;

    static String jiraIssueCollectionName;
    static String zephyrTestRunCollectionName;


    public Map<String, String> getHeaders(String endpoint, Map<String, Object> requestParams) {

        Map<String, String> headers = new HashMap<>();

        String requestParamString = requestParams.entrySet().stream()
                .map(e -> e.getKey()+"="+e.getValue())
                .collect(Collectors.joining("&"));

        try {

            ZFJCloudRestClient client = ZFJCloudRestClient
                    .restBuilder(zephyrServerUrl, zephyrAccessKey, zephyrSecretKey, accountId)
                    .build();

            URI uri = new URI(zephyrServerUrl + endpoint + "?" + requestParamString);
            String jwt = client.getJwtGenerator().generateJWT("GET", uri, JWT_EXPIRATION_IN_SEC);

            headers.put(AUTHORIZATION, jwt);
            headers.put(ZAPI_ACCESS_KEY, zephyrAccessKey);

            return headers;

        } catch (URISyntaxException e) {
            log.warn("Returns null header due to unexpected URI format : {}", zephyrServerUrl + endpoint + "?" + requestParamString);
            return null;
        }
    }

    public static String getJiraIssueCollectionName() {
        return jiraIssueCollectionName;
    }

    @Value("${spring.data.mongodb.collection.issue}")
    public void setJiraIssueCollectionName(String jiraIssueCollectionName) {
        CommonUtilComponent.jiraIssueCollectionName = SOURCE_JIRA+jiraIssueCollectionName;
    }

    public static String getZephyrTestRunCollectionName() {
        return zephyrTestRunCollectionName;
    }

    @Value("${spring.data.mongodb.collection.execution}")
    public void setZephyrTestRunCollectionName(String zephyrTestRunCollectionName) {
        CommonUtilComponent.zephyrTestRunCollectionName = SOURCE_ZEPHYR+zephyrTestRunCollectionName;
    }

    public String parseDateToString(Date date) {

        if (null == date) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(date);
    }

    public static LocalDateTime getDateTimeFromString(String dateTimeString) {

        LocalDateTime dateTime = null;

        if (!StringUtils.hasText(dateTimeString)) { return null; }

        try {
            dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        }
        catch(DateTimeParseException e) {

            try {
                dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS"));
            }
            catch(DateTimeParseException f) {

                try {
                    dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
                }
                catch(DateTimeParseException g) {
                    log.info("Return value as null, due to exception while parsing string to date, Exception:{}");
                }

            }

        }
        return dateTime;
    }

    public static LocalDate getDateFromString(String dateString) {

        LocalDate date = null;

        if(!StringUtils.hasText(dateString)) {return null;}

        try{
            date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MMM/yy"));
        }
        catch(DateTimeParseException e) {
            try{
                date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("d/MMM/yy"));
            }
            catch(DateTimeParseException f) {
                log.info("Return value as null, due to exception while parsing string to date, Exception:{}");
            }
        }

        return date;
    }

    public Integer getIntegerFromString(String integerString) {
        Integer integer = null;
        try {
            integer = Integer.valueOf(integerString);
        } catch (NumberFormatException e) {
            log.info("Return value as null, due to exception while parsing string to integer, Exception:{}");
        }
        return integer;
    }

    public Map<String, String> getMap(String input) {
        Map<String, String> map = new HashMap<>();
        if (!(input.contains("[") && input.contains("]"))) return map;

        String[] strings = input.substring(input.indexOf('[') + 1, input.indexOf(']')).split(",");
        List<String> list = Arrays.asList(strings);
        list.forEach(s -> {
            String[] split = s.split("=");
            String key = split[0];
            if (split.length == 2) {
                String value = split[1].equals("<null>") ? null : split[1];
                map.put(key, value);
            }
        });

        return map;
    }

    public String getJqlParamString(String projectId, Date lastUpdatedDate) {
        List<String> jqlParams = new ArrayList<>();
        jqlParams.add(String.format(PROJECT, projectId));

        Date now = Calendar.getInstance().getTime();
        String nowDateSting = parseDateToString(now);

        jqlParams.add(String.format(JQL_UPDATED_LT, nowDateSting));
        if (!StringUtils.isEmpty(lastUpdatedDate)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(lastUpdatedDate);
            calendar.add(Calendar.MINUTE, 1);
            String updatedDateString = parseDateToString(calendar.getTime());
            jqlParams.add(String.format(JQL_UPDATED_GTE, updatedDateString));
        }
//        else {
//            String updatedDateString = parseDateToString(lastUpdatedDate);
//            jqlParams.add(String.format(JQL_UPDATED_GTE, updatedDateString));
//        }

        String jqlString = jqlParams.stream().collect(Collectors.joining(JQL_AND));
        log.info("JQL string : " + jqlString);
        return jqlString;
    }

    public String getJqlParamString(String projectId) {
        String jqlParam = String.format(PROJECT, projectId);
        return jqlParam;
    }

}
