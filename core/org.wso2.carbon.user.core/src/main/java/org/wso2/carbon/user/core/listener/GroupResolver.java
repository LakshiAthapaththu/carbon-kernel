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

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service interface of the listener to resolve the group information. This listener is added to provide backward
 * compatibility for the userstores which does not support group id. This is not expected to use for any other purpose.
 */
public interface GroupResolver {

    /**
     * To check whether particular listener is enabled.
     *
     * @return true if particular listener is enabled.
     */
    boolean isEnable();

    /**
     * Get the execution order identifier for this listener.
     *
     * @return The execution order identifier integer value.
     */
    int getExecutionOrderId();

    /**
     * Resolve the domain name of the group with the given id.
     *
     * @param group    Group that the domain needs to be resolved.
     * @param tenantId Tenant id.
     * @return If the method execution was successful.
     * @throws UserStoreException If an error occurred.
     */
    boolean resolveGroupDomainByGroupId(Group group, int tenantId) throws UserStoreException;

    /**
     * Resolve the groups list of user with the given id..
     *
     * @param userId           User id.
     * @param groupList        List of groups.
     * @param userStoreManager The underlying UserStoreManager.
     * @return Whether execution of this method of the underlying UserStoreManager must happen.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean getGroupsListOfUserByUserId(String userId, List<Group> groupList, UserStoreManager userStoreManager)
            throws UserStoreException;

    /**
     * Resolve the group id of the group with the given name.
     *
     * @param groupName        Group unique name.
     * @param group            Group object.
     * @param userStoreManager The underlying UserStoreManager.
     * @return Whether execution of this method of the underlying UserStoreManager must happen.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean getGroupIdByName(String groupName, Group group, UserStoreManager userStoreManager)
            throws UserStoreException;

    /**
     * Resolve the group name of the group with the given id.
     *
     * @param groupID          Group unique id.
     * @param group            Group object.
     * @param userStoreManager The underlying UserStoreManager.
     * @return Whether execution of this method of the underlying UserStoreManager must happen.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean getGroupNameById(String groupID, Group group, UserStoreManager userStoreManager)
            throws UserStoreException;

    /**
     * Resolve the group of the group with the given id.
     *
     * @param groupID          Group unique id.
     * @param requestedClaims  Requested Claims.
     * @param group            Group object.
     * @param userStoreManager The underlying UserStoreManager.
     * @return Whether execution of this method of the underlying UserStoreManager must happen.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean getGroupById(String groupID, List<String> requestedClaims, Group group,
                         UserStoreManager userStoreManager) throws UserStoreException;

    /**
     * Resolve the group of the group with the given name.
     *
     * @param groupName        Group unique name.
     * @param requestedClaims  Requested Claims.
     * @param group            Group object.
     * @param userStoreManager The underlying UserStoreManager.
     * @return Whether execution of this method of the underlying UserStoreManager must happen.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean getGroupByName(String groupName, List<String> requestedClaims, Group group,
                           UserStoreManager userStoreManager) throws UserStoreException;

    /**
     * Resolve the groups with the matching condition.
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
    boolean listGroups(Condition condition, int limit, int offset, String sortBy, String domain, String sortOrder,
                       List<Group> groupsList, UserStoreManager userStoreManager) throws UserStoreException;

    /**
     * Create a group.
     *
     * @param displayName      Group name.
     * @param groupID          Group ID.
     * @param createdDate      Created date of the group.
     * @param lastModifiedDate Last modified date of the group.
     * @param location         Location of the group.
     * @param tenantID         Tenant ID.
     * @return Whether execution of this method happened successfully.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean addGroup(String displayName, String groupID, LocalDateTime createdDate,
                     LocalDateTime lastModifiedDate, String location, int tenantID) throws UserStoreException;

    /**
     * Delete a group.
     *
     * @param groupName Group name.
     * @param tenantID  Tenant ID.
     * @return Whether execution of this method happened successfully.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean deleteGroup(String groupName, int tenantID) throws UserStoreException;

    /**
     * Update name of a group.
     *
     * @param oldGroupName Existing group name.
     * @param newGroupName New group name.
     * @param tenantID     Tenant ID.
     * @return Whether execution of this method happened successfully.
     * @throws UserStoreException If an error occurred while performing the operation.
     */
    boolean updateGroupName(String oldGroupName, String newGroupName, int tenantID) throws UserStoreException;
}
