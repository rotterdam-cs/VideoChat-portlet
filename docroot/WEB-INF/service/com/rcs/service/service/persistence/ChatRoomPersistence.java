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

import com.liferay.portal.service.persistence.BasePersistence;

import com.rcs.service.model.ChatRoom;

/**
 * The persistence interface for the chat room service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author flor
 * @see ChatRoomPersistenceImpl
 * @see ChatRoomUtil
 * @generated
 */
public interface ChatRoomPersistence extends BasePersistence<ChatRoom> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChatRoomUtil} to access the chat room persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the chat room in the entity cache if it is enabled.
	*
	* @param chatRoom the chat room
	*/
	public void cacheResult(com.rcs.service.model.ChatRoom chatRoom);

	/**
	* Caches the chat rooms in the entity cache if it is enabled.
	*
	* @param chatRooms the chat rooms
	*/
	public void cacheResult(
		java.util.List<com.rcs.service.model.ChatRoom> chatRooms);

	/**
	* Creates a new chat room with the primary key. Does not add the chat room to the database.
	*
	* @param chatRoomId the primary key for the new chat room
	* @return the new chat room
	*/
	public com.rcs.service.model.ChatRoom create(long chatRoomId);

	/**
	* Removes the chat room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param chatRoomId the primary key of the chat room
	* @return the chat room that was removed
	* @throws com.rcs.service.NoSuchChatRoomException if a chat room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.ChatRoom remove(long chatRoomId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomException;

	public com.rcs.service.model.ChatRoom updateImpl(
		com.rcs.service.model.ChatRoom chatRoom, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the chat room with the primary key or throws a {@link com.rcs.service.NoSuchChatRoomException} if it could not be found.
	*
	* @param chatRoomId the primary key of the chat room
	* @return the chat room
	* @throws com.rcs.service.NoSuchChatRoomException if a chat room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.ChatRoom findByPrimaryKey(long chatRoomId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomException;

	/**
	* Returns the chat room with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param chatRoomId the primary key of the chat room
	* @return the chat room, or <code>null</code> if a chat room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.ChatRoom fetchByPrimaryKey(long chatRoomId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the chat rooms.
	*
	* @return the chat rooms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.service.model.ChatRoom> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.service.model.ChatRoom> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.service.model.ChatRoom> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chat rooms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chat rooms.
	*
	* @return the number of chat rooms
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}