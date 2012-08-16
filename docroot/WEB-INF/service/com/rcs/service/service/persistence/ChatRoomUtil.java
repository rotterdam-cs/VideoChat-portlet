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

import com.rcs.service.model.ChatRoom;

import java.util.List;

/**
 * The persistence utility for the chat room service. This utility wraps {@link ChatRoomPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author flor
 * @see ChatRoomPersistence
 * @see ChatRoomPersistenceImpl
 * @generated
 */
public class ChatRoomUtil {
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
	public static void clearCache(ChatRoom chatRoom) {
		getPersistence().clearCache(chatRoom);
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
	public static List<ChatRoom> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChatRoom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChatRoom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ChatRoom update(ChatRoom chatRoom, boolean merge)
		throws SystemException {
		return getPersistence().update(chatRoom, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ChatRoom update(ChatRoom chatRoom, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(chatRoom, merge, serviceContext);
	}

	/**
	* Caches the chat room in the entity cache if it is enabled.
	*
	* @param chatRoom the chat room
	*/
	public static void cacheResult(com.rcs.service.model.ChatRoom chatRoom) {
		getPersistence().cacheResult(chatRoom);
	}

	/**
	* Caches the chat rooms in the entity cache if it is enabled.
	*
	* @param chatRooms the chat rooms
	*/
	public static void cacheResult(
		java.util.List<com.rcs.service.model.ChatRoom> chatRooms) {
		getPersistence().cacheResult(chatRooms);
	}

	/**
	* Creates a new chat room with the primary key. Does not add the chat room to the database.
	*
	* @param chatRoomId the primary key for the new chat room
	* @return the new chat room
	*/
	public static com.rcs.service.model.ChatRoom create(long chatRoomId) {
		return getPersistence().create(chatRoomId);
	}

	/**
	* Removes the chat room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param chatRoomId the primary key of the chat room
	* @return the chat room that was removed
	* @throws com.rcs.service.NoSuchChatRoomException if a chat room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoom remove(long chatRoomId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomException {
		return getPersistence().remove(chatRoomId);
	}

	public static com.rcs.service.model.ChatRoom updateImpl(
		com.rcs.service.model.ChatRoom chatRoom, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(chatRoom, merge);
	}

	/**
	* Returns the chat room with the primary key or throws a {@link com.rcs.service.NoSuchChatRoomException} if it could not be found.
	*
	* @param chatRoomId the primary key of the chat room
	* @return the chat room
	* @throws com.rcs.service.NoSuchChatRoomException if a chat room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoom findByPrimaryKey(
		long chatRoomId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomException {
		return getPersistence().findByPrimaryKey(chatRoomId);
	}

	/**
	* Returns the chat room with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param chatRoomId the primary key of the chat room
	* @return the chat room, or <code>null</code> if a chat room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoom fetchByPrimaryKey(
		long chatRoomId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(chatRoomId);
	}

	/**
	* Returns all the chat rooms.
	*
	* @return the chat rooms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.ChatRoom> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the chat rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chat rooms
	* @param end the upper bound of the range of chat rooms (not inclusive)
	* @return the range of chat rooms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.ChatRoom> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the chat rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chat rooms
	* @param end the upper bound of the range of chat rooms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of chat rooms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.ChatRoom> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the chat rooms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of chat rooms.
	*
	* @return the number of chat rooms
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ChatRoomPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ChatRoomPersistence)PortletBeanLocatorUtil.locate(com.rcs.service.service.ClpSerializer.getServletContextName(),
					ChatRoomPersistence.class.getName());

			ReferenceRegistry.registerReference(ChatRoomUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ChatRoomPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ChatRoomUtil.class, "_persistence");
	}

	private static ChatRoomPersistence _persistence;
}