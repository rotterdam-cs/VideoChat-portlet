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

import com.rcs.service.model.ChatRoomGroup;

/**
 * The persistence interface for the chat room group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author flor
 * @see ChatRoomGroupPersistenceImpl
 * @see ChatRoomGroupUtil
 * @generated
 */
public interface ChatRoomGroupPersistence extends BasePersistence<ChatRoomGroup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChatRoomGroupUtil} to access the chat room group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the chat room group in the entity cache if it is enabled.
	*
	* @param chatRoomGroup the chat room group
	*/
	public void cacheResult(com.rcs.service.model.ChatRoomGroup chatRoomGroup);

	/**
	* Caches the chat room groups in the entity cache if it is enabled.
	*
	* @param chatRoomGroups the chat room groups
	*/
	public void cacheResult(
		java.util.List<com.rcs.service.model.ChatRoomGroup> chatRoomGroups);

	/**
	* Creates a new chat room group with the primary key. Does not add the chat room group to the database.
	*
	* @param chatRoomGroupPK the primary key for the new chat room group
	* @return the new chat room group
	*/
	public com.rcs.service.model.ChatRoomGroup create(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK);

	/**
	* Removes the chat room group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param chatRoomGroupPK the primary key of the chat room group
	* @return the chat room group that was removed
	* @throws com.rcs.service.NoSuchChatRoomGroupException if a chat room group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.ChatRoomGroup remove(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomGroupException;

	public com.rcs.service.model.ChatRoomGroup updateImpl(
		com.rcs.service.model.ChatRoomGroup chatRoomGroup, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the chat room group with the primary key or throws a {@link com.rcs.service.NoSuchChatRoomGroupException} if it could not be found.
	*
	* @param chatRoomGroupPK the primary key of the chat room group
	* @return the chat room group
	* @throws com.rcs.service.NoSuchChatRoomGroupException if a chat room group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.ChatRoomGroup findByPrimaryKey(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomGroupException;

	/**
	* Returns the chat room group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param chatRoomGroupPK the primary key of the chat room group
	* @return the chat room group, or <code>null</code> if a chat room group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.ChatRoomGroup fetchByPrimaryKey(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the chat room groups where chatRoomId = &#63;.
	*
	* @param chatRoomId the chat room ID
	* @return the matching chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.service.model.ChatRoomGroup> findByBY_chatRoomId(
		long chatRoomId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.service.model.ChatRoomGroup> findByBY_chatRoomId(
		long chatRoomId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.service.model.ChatRoomGroup> findByBY_chatRoomId(
		long chatRoomId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rcs.service.model.ChatRoomGroup findByBY_chatRoomId_First(
		long chatRoomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomGroupException;

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
	public com.rcs.service.model.ChatRoomGroup findByBY_chatRoomId_Last(
		long chatRoomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomGroupException;

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
	public com.rcs.service.model.ChatRoomGroup[] findByBY_chatRoomId_PrevAndNext(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK,
		long chatRoomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomGroupException;

	/**
	* Returns all the chat room groups where chatRoomId = &#63; and type = &#63;.
	*
	* @param chatRoomId the chat room ID
	* @param type the type
	* @return the matching chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.service.model.ChatRoomGroup> findByBY_chatRoomIdAndType(
		long chatRoomId, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.service.model.ChatRoomGroup> findByBY_chatRoomIdAndType(
		long chatRoomId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.service.model.ChatRoomGroup> findByBY_chatRoomIdAndType(
		long chatRoomId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rcs.service.model.ChatRoomGroup findByBY_chatRoomIdAndType_First(
		long chatRoomId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomGroupException;

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
	public com.rcs.service.model.ChatRoomGroup findByBY_chatRoomIdAndType_Last(
		long chatRoomId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomGroupException;

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
	public com.rcs.service.model.ChatRoomGroup[] findByBY_chatRoomIdAndType_PrevAndNext(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK,
		long chatRoomId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchChatRoomGroupException;

	/**
	* Returns all the chat room groups.
	*
	* @return the chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.service.model.ChatRoomGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.service.model.ChatRoomGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.service.model.ChatRoomGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chat room groups where chatRoomId = &#63; from the database.
	*
	* @param chatRoomId the chat room ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBY_chatRoomId(long chatRoomId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chat room groups where chatRoomId = &#63; and type = &#63; from the database.
	*
	* @param chatRoomId the chat room ID
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBY_chatRoomIdAndType(long chatRoomId, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chat room groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chat room groups where chatRoomId = &#63;.
	*
	* @param chatRoomId the chat room ID
	* @return the number of matching chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByBY_chatRoomId(long chatRoomId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chat room groups where chatRoomId = &#63; and type = &#63;.
	*
	* @param chatRoomId the chat room ID
	* @param type the type
	* @return the number of matching chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByBY_chatRoomIdAndType(long chatRoomId, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chat room groups.
	*
	* @return the number of chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}