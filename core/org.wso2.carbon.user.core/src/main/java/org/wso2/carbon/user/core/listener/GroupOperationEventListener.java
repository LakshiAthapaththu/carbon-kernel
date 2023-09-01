/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org).
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.user.core.listener;

import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.UserStoreManager;
import org.wso2.carbon.user.core.common.Group;
import org.wso2.carbon.user.core.model.Condition;

import java.util.List;

/**
 * This allows an extension point to implement various additional operations before and after
 * actual group operation is done.
 */
public interface GroupOperationEventListener {

    /**
     * Get the execution order identifier for this listener.
     *
     * @return The execution order identifier integer value.
     */
    int getExecutionOrderId();

    /**
     * Defines any additional action before getting the group with id.
     *
     * @param groupID          Group unique id.
     * @param requestedClaims  Requested Claims.
     * @param userStoreManager The underlying UserStoreManager.
     * @return Whether execution of this method of the underlying UserStoreManager must happen.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean preGetGroupById(String groupID, List<String> requestedClaims, UserStoreManager userStoreManager)
            throws UserStoreException;

    /**
     * Defines any additional action before getting the group name by id.
     *
     * @param groupID          Group unique id.
     * @param userStoreManager The underlying UserStoreManager.
     * @return Whether execution of this method of the underlying UserStoreManager must happen.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean preGetGroupNameById(String groupID, UserStoreManager userStoreManager) throws UserStoreException;

    /**
     * Defines any additional action before getting the group by group name.
     *
     * @param groupName        Group unique name.
     * @param requestedClaims  Requested Claims.
     * @param userStoreManager The underlying UserStoreManager.
     * @return Whether execution of this method of the underlying UserStoreManager must happen.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean preGetGroupByName(String groupName, List<String> requestedClaims, UserStoreManager userStoreManager)
            throws UserStoreException;

    /**
     * Defines any additional action before getting the group id by group name.
     *
     * @param groupName        Group unique name.
     * @param userStoreManager The underlying UserStoreManager.
     * @return Whether execution of this method of the underlying UserStoreManager must happen.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean preGetGroupIdByName(String groupName, UserStoreManager userStoreManager) throws UserStoreException;

    /**
     * Defines any additional action before getting the groups list.
     *
     * @param condition        Conditional filter.
     * @param limit            No of search results.
     * @param offset           Start index of the user search.
     * @param domain           Userstore domain.
     * @param sortBy           Sorted by.
     * @param sortOrder        Sorted order.
     * @param userStoreManager The underlying UserStoreManager.
     * @return Whether execution of this method of the underlying UserStoreManager must happen.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean preListGroups(Condition condition, int limit, int offset, String sortBy, String domain, String sortOrder,
                          UserStoreManager userStoreManager) throws UserStoreException;

    /**
     * Defines any additional action before getting the groups list of the user with the given id.
     *
     * @param userId           User id.
     * @param userStoreManager The underlying UserStoreManager.
     * @return Whether execution of this method of the underlying UserStoreManager must happen.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean preGetGroupsListOfUserByUserId(String userId, UserStoreManager userStoreManager) throws UserStoreException;

    /**
     * Defines any additional action before getting the groups list of the user with the given id.
     *
     * @param userId           User id.
     * @param groupList        List of groups.
     * @param userStoreManager The underlying UserStoreManager.
     * @return Whether execution of this method of the underlying UserStoreManager must happen.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean postGetGroupsListOfUserByUserId(String userId, List<Group> groupList, UserStoreManager userStoreManager)
            throws UserStoreException;

    /**
     * Defines any additional action after getting the group by id.
     *
     * @param groupID          Group unique id.
     * @param requestedClaims  Requested Claims.
     * @param group            Group object.
     * @param userStoreManager The underlying UserStoreManager.
     * @return Whether execution of this method of the underlying UserStoreManager must happen.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean postGetGroupById(String groupID, List<String> requestedClaims, Group group,
                             UserStoreManager userStoreManager) throws UserStoreException;

    /**
     * Defines any additional action after getting the group name by id.
     *
     * @param groupID          Group unique id.
     * @param group            Group object.
     * @param userStoreManager The underlying UserStoreManager.
     * @return Whether execution of this method of the underlying UserStoreManager must happen.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean postGetGroupNameById(String groupID, Group group, UserStoreManager userStoreManager)
            throws UserStoreException;

    /**
     * Defines any additional action after getting the group by group name.
     *
     * @param groupName        Group unique name.
     * @param requestedClaims  Requested Claims.
     * @param group            Group object.
     * @param userStoreManager The underlying UserStoreManager.
     * @return Whether execution of this method of the underlying UserStoreManager must happen.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean postGetGroupByName(String groupName, List<String> requestedClaims, Group group,
                               UserStoreManager userStoreManager) throws UserStoreException;

    /**
     * Defines any additional action after getting the group id by group name.
     *
     * @param groupName        Group unique name.
     * @param group            Group object.
     * @param userStoreManager The underlying UserStoreManager.
     * @return Whether execution of this method of the underlying UserStoreManager must happen.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean postGetGroupIdByName(String groupName, Group group, UserStoreManager userStoreManager)
            throws UserStoreException;

    /**
     * Defines any additional action after getting the groups list.
     *
     * @param condition        Conditional filter.
     * @param limit            No of search results.
     * @param offset           Start index of the user search.
     * @param domain           Userstore domain.
     * @param sortBy           Sorted by.
     * @param sortOrder        Sorted order.
     * @param groupsList       Groups list.
     * @param userStoreManager The underlying UserStoreManager.
     * @return Whether execution of this method of the underlying UserStoreManager must happen.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean postListGroups(Condition condition, int limit, int offset, String sortBy, String domain, String sortOrder,
                           List<Group> groupsList, UserStoreManager userStoreManager) throws UserStoreException;
    boolean preAddGroupWithID(String roleName, String[] userList, UserStoreManager userStoreManager)
            throws UserStoreException;

    boolean postAddGroupWithID(String roleName, String[] userList, UserStoreManager userStoreManager)
            throws UserStoreException;

    boolean preDeleteGroupWithID(String roleName, UserStoreManager userStoreManager)
            throws UserStoreException;

    boolean postDeleteGroupWithID(String roleName, UserStoreManager userStoreManager)
            throws UserStoreException;
}
