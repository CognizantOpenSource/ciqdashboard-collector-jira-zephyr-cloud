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

package com.cognizant.collector.jirazephyr.constants;
/**
 * Constant
 * @author Cognizant
 */

public class Constant {

    public static final int RESULTS_PER_PAGE = 100;
    public static final int PAGE_STARTS_AT = 0;
    public static final String MAX_RESULTS = "maxResults";
    public static final String START_AT = "startAt";
    public static final String PROJECT = "project='%s'";
    public static final String JQL_UPDATED_LT = "updated < '%s' ";
    public static final String JQL_UPDATED_GTE = "updated >= '%s' ";
    public static final String JQL_AND = " AND ";
    public static final String JQL = "jql";
    public static final String SOURCE_JIRA ="source_jira_";

    /*Zephyr*/
    public static final String SOURCE_ZEPHYR ="source_zephyr_";
    public static final String ZAPI_ACCESS_KEY = "zapiAccessKey";
    public static final String AUTHORIZATION = "Authorization";
    public static final String ENDPOINT_CYCLE = "/public/rest/api/1.0/cycles/search";
    public static final String ENDPOINT_VERSION = "/public/rest/api/1.0/util/versionBoard-list";
    public static final String ENDPOINT_EXECUTION = "/public/rest/api/1.0/executions/search/cycle/%s";
    public static final String PROJECT_ID = "projectId";
    public static final String VERSION_ID = "versionId";
    public static final String SIZE = "size";
    public static final String OFFSET = "offset";
    public static final Integer SIZE_VALUE = 50;
    public static final Integer OFFSET_VALUE = 0;
    public static final Integer JWT_EXPIRATION_IN_SEC = 360;
    /*Zephyr*/

    private Constant() {
    }
}
