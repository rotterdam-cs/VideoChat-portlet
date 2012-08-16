/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rcs.service.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rcs.service.model.ChatRoomGroup;

import java.util.List;

/**
 * The persistence utility for the chat room group service. This utility wraps {@link ChatRoomGroupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author flor
 * @see ChatRoomGroupPersistence
 * @see ChatRoomGroupPersistenceImpl
 * @generated
 */
public class ChatRoomGroupUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ChatRoomGroup chatRoomGroup) {
		getPersistence().clearCache(chatRoomGroup);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ChatRoomGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChatRoomGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChatRoomGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ChatRoomGroup update(ChatRoomGroup chatRoomGroup,
		boolean merge) throws SystemException {
		return getPersistence().update(chatRoomGroup, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ChatRoomGroup update(ChatRoomGroup chatRoomGroup,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(chatRoomGroup, merge, serviceContext);
	}

	/**
	* Caches the chat room group in the entity cache if it is enabled.
	*
	* @param chatRoomGroup the chat room group
	*/
	public static void cacheResult(
		com.rcs.service.model.ChatRoomGroup chatRoomGroup) {
		getPersistence().cacheResult(chatRoomGroup);
	}

	/**
	* Caches the chat room groups in the entity cache if it is enabled.
	*
	* @param chatRoomGroups the chat room groups
	*/
	public static void cacheResult(
		java.util.List<com.rcs.service.model.ChatRoomGroup> chatRoomGroups) {
		getPersistence().cacheResult(chatRoomGroups);
	}

	/**
	* Creates a new chat room group with the primary key. Does not add the chat room group to the database.
	*
	* @param chatRoomGroupPK the primary key for the new chat room group
	* @return the new chat room group
	*/
	public static com.rcs.service.model.ChatRoomGroup create(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK) {
		return getPersistence().create(chatRoomGroupPK);
	}

	/**
	* Removes the chat room group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param chatRoomGroupPK the primary key of the chat room group
	* @return the chat room group that was removed
	* @throws com.rcs.service.NoSuchChatRoomGroupException if a chat room group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoomGroup remove(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomGroupException {
		return getPersistence().remove(chatRoomGroupPK);
	}

	public static com.rcs.service.model.ChatRoomGroup updateImpl(
		com.rcs.service.model.ChatRoomGroup chatRoomGroup, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(chatRoomGroup, merge);
	}

	/**
	* Returns the chat room group with the primary key or throws a {@link com.rcs.service.NoSuchChatRoomGroupException} if it could not be found.
	*
	* @param chatRoomGroupPK the primary key of the chat room group
	* @return the chat room group
	* @throws com.rcs.service.NoSuchChatRoomGroupException if a chat room group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoomGroup findByPrimaryKey(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomGroupException {
		return getPersistence().findByPrimaryKey(chatRoomGroupPK);
	}

	/**
	* Returns the chat room group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param chatRoomGroupPK the primary key of the chat room group
	* @return the chat room group, or <code>null</code> if a chat room group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoomGroup fetchByPrimaryKey(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(chatRoomGroupPK);
	}

	/**
	* Returns all the chat room groups where chatRoomId = &#63;.
	*
	* @param chatRoomId the chat room ID
	* @return the matching chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.ChatRoomGroup> findByBY_chatRoomId(
		long chatRoomId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBY_chatRoomId(chatRoomId);
	}

	/**
	* Returns a range of all the chat room groups where chatRoomId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chatRoomId the chat room ID
	* @param start the lower bound of the range of chat room groups
	* @param end the upper bound of the range of chat room groups (not inclusive)
	* @return the range of matching chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.ChatRoomGroup> findByBY_chatRoomId(
		long chatRoomId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBY_chatRoomId(chatRoomId, start, end);
	}

	/**
	* Returns an ordered range of all the chat room groups where chatRoomId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chatRoomId the chat room ID
	* @param start the lower bound of the range of chat room groups
	* @param end the upper bound of the range of chat room groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.ChatRoomGroup> findByBY_chatRoomId(
		long chatRoomId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBY_chatRoomId(chatRoomId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first chat room group in the ordered set where chatRoomId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chatRoomId the chat room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chat room group
	* @throws com.rcs.service.NoSuchChatRoomGroupException if a matching chat room group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoomGroup findByBY_chatRoomId_First(
		long chatRoomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomGroupException {
		return getPersistence()
				   .findByBY_chatRoomId_First(chatRoomId, orderByComparator);
	}

	/**
	* Returns the last chat room group in the ordered set where chatRoomId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chatRoomId the chat room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chat room group
	* @throws com.rcs.service.NoSuchChatRoomGroupException if a matching chat room group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoomGroup findByBY_chatRoomId_Last(
		long chatRoomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomGroupException {
		return getPersistence()
				   .findByBY_chatRoomId_Last(chatRoomId, orderByComparator);
	}

	/**
	* Returns the chat room groups before and after the current chat room group in the ordered set where chatRoomId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chatRoomGroupPK the primary key of the current chat room group
	* @param chatRoomId the chat room ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chat room group
	* @throws com.rcs.service.NoSuchChatRoomGroupException if a chat room group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoomGroup[] findByBY_chatRoomId_PrevAndNext(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK,
		long chatRoomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomGroupException {
		return getPersistence()
				   .findByBY_chatRoomId_PrevAndNext(chatRoomGroupPK,
			chatRoomId, orderByComparator);
	}

	/**
	* Returns all the chat room groups where chatRoomId = &#63; and type = &#63;.
	*
	* @param chatRoomId the chat room ID
	* @param type the type
	* @return the matching chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.ChatRoomGroup> findByBY_chatRoomIdAndType(
		long chatRoomId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBY_chatRoomIdAndType(chatRoomId, type);
	}

	/**
	* Returns a range of all the chat room groups where chatRoomId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chatRoomId the chat room ID
	* @param type the type
	* @param start the lower bound of the range of chat room groups
	* @param end the upper bound of the range of chat room groups (not inclusive)
	* @return the range of matching chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.ChatRoomGroup> findByBY_chatRoomIdAndType(
		long chatRoomId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBY_chatRoomIdAndType(chatRoomId, type, start, end);
	}

	/**
	* Returns an ordered range of all the chat room groups where chatRoomId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chatRoomId the chat room ID
	* @param type the type
	* @param start the lower bound of the range of chat room groups
	* @param end the upper bound of the range of chat room groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.ChatRoomGroup> findByBY_chatRoomIdAndType(
		long chatRoomId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBY_chatRoomIdAndType(chatRoomId, type, start, end,
			orderByComparator);
	}

	/**
	* Returns the first chat room group in the ordered set where chatRoomId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chatRoomId the chat room ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chat room group
	* @throws com.rcs.service.NoSuchChatRoomGroupException if a matching chat room group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoomGroup findByBY_chatRoomIdAndType_First(
		long chatRoomId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomGroupException {
		return getPersistence()
				   .findByBY_chatRoomIdAndType_First(chatRoomId, type,
			orderByComparator);
	}

	/**
	* Returns the last chat room group in the ordered set where chatRoomId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chatRoomId the chat room ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chat room group
	* @throws com.rcs.service.NoSuchChatRoomGroupException if a matching chat room group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoomGroup findByBY_chatRoomIdAndType_Last(
		long chatRoomId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomGroupException {
		return getPersistence()
				   .findByBY_chatRoomIdAndType_Last(chatRoomId, type,
			orderByComparator);
	}

	/**
	* Returns the chat room groups before and after the current chat room group in the ordered set where chatRoomId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chatRoomGroupPK the primary key of the current chat room group
	* @param chatRoomId the chat room ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chat room group
	* @throws com.rcs.service.NoSuchChatRoomGroupException if a chat room group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoomGroup[] findByBY_chatRoomIdAndType_PrevAndNext(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK,
		long chatRoomId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomGroupException {
		return getPersistence()
				   .findByBY_chatRoomIdAndType_PrevAndNext(chatRoomGroupPK,
			chatRoomId, type, orderByComparator);
	}

	/**
	* Returns all the chat room groups.
	*
	* @return the chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.ChatRoomGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the chat room groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chat room groups
	* @param end the upper bound of the range of chat room groups (not inclusive)
	* @return the range of chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.ChatRoomGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the chat room groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chat room groups
	* @param end the upper bound of the range of chat room groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.ChatRoomGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the chat room groups where chatRoomId = &#63; from the database.
	*
	* @param chatRoomId the chat room ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBY_chatRoomId(long chatRoomId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBY_chatRoomId(chatRoomId);
	}

	/**
	* Removes all the chat room groups where chatRoomId = &#63; and type = &#63; from the database.
	*
	* @param chatRoomId the chat room ID
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBY_chatRoomIdAndType(long chatRoomId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBY_chatRoomIdAndType(chatRoomId, type);
	}

	/**
	* Removes all the chat room groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of chat room groups where chatRoomId = &#63;.
	*
	* @param chatRoomId the chat room ID
	* @return the number of matching chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBY_chatRoomId(long chatRoomId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBY_chatRoomId(chatRoomId);
	}

	/**
	* Returns the number of chat room groups where chatRoomId = &#63; and type = &#63;.
	*
	* @param chatRoomId the chat room ID
	* @param type the type
	* @return the number of matching chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBY_chatRoomIdAndType(long chatRoomId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBY_chatRoomIdAndType(chatRoomId, type);
	}

	/**
	* Returns the number of chat room groups.
	*
	* @return the number of chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ChatRoomGroupPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ChatRoomGroupPersistence)PortletBeanLocatorUtil.locate(com.rcs.service.service.ClpSerializer.getServletContextName(),
					ChatRoomGroupPersistence.class.getName());

			ReferenceRegistry.registerReference(ChatRoomGroupUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ChatRoomGroupPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ChatRoomGroupUtil.class,
			"_persistence");
	}

	private static ChatRoomGroupPersistence _persistence;
}