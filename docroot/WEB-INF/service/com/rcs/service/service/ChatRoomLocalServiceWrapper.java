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

package com.rcs.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ChatRoomLocalService}.
 * </p>
 *
 * @author    flor
 * @see       ChatRoomLocalService
 * @generated
 */
public class ChatRoomLocalServiceWrapper implements ChatRoomLocalService,
	ServiceWrapper<ChatRoomLocalService> {
	public ChatRoomLocalServiceWrapper(
		ChatRoomLocalService chatRoomLocalService) {
		_chatRoomLocalService = chatRoomLocalService;
	}

	/**
	* Adds the chat room to the database. Also notifies the appropriate model listeners.
	*
	* @param chatRoom the chat room
	* @return the chat room that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.ChatRoom addChatRoom(
		com.rcs.service.model.ChatRoom chatRoom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomLocalService.addChatRoom(chatRoom);
	}

	/**
	* Creates a new chat room with the primary key. Does not add the chat room to the database.
	*
	* @param chatRoomId the primary key for the new chat room
	* @return the new chat room
	*/
	public com.rcs.service.model.ChatRoom createChatRoom(long chatRoomId) {
		return _chatRoomLocalService.createChatRoom(chatRoomId);
	}

	/**
	* Deletes the chat room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param chatRoomId the primary key of the chat room
	* @throws PortalException if a chat room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteChatRoom(long chatRoomId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_chatRoomLocalService.deleteChatRoom(chatRoomId);
	}

	/**
	* Deletes the chat room from the database. Also notifies the appropriate model listeners.
	*
	* @param chatRoom the chat room
	* @throws SystemException if a system exception occurred
	*/
	public void deleteChatRoom(com.rcs.service.model.ChatRoom chatRoom)
		throws com.liferay.portal.kernel.exception.SystemException {
		_chatRoomLocalService.deleteChatRoom(chatRoom);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.rcs.service.model.ChatRoom fetchChatRoom(long chatRoomId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomLocalService.fetchChatRoom(chatRoomId);
	}

	/**
	* Returns the chat room with the primary key.
	*
	* @param chatRoomId the primary key of the chat room
	* @return the chat room
	* @throws PortalException if a chat room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.ChatRoom getChatRoom(long chatRoomId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomLocalService.getChatRoom(chatRoomId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.rcs.service.model.ChatRoom> getChatRooms(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomLocalService.getChatRooms(start, end);
	}

	/**
	* Returns the number of chat rooms.
	*
	* @return the number of chat rooms
	* @throws SystemException if a system exception occurred
	*/
	public int getChatRoomsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomLocalService.getChatRoomsCount();
	}

	/**
	* Updates the chat room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chatRoom the chat room
	* @return the chat room that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.ChatRoom updateChatRoom(
		com.rcs.service.model.ChatRoom chatRoom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomLocalService.updateChatRoom(chatRoom);
	}

	/**
	* Updates the chat room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chatRoom the chat room
	* @param merge whether to merge the chat room with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the chat room that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.ChatRoom updateChatRoom(
		com.rcs.service.model.ChatRoom chatRoom, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomLocalService.updateChatRoom(chatRoom, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _chatRoomLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_chatRoomLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.rcs.service.model.ChatRoom addChatRoom(long userId,
		java.lang.String name, java.lang.String description,
		java.lang.String sessionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomLocalService.addChatRoom(userId, name, description,
			sessionId);
	}

	public com.rcs.service.model.ChatRoom updateChatRoom(long userId,
		long chatRoomId, java.lang.String name, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomLocalService.updateChatRoom(userId, chatRoomId, name,
			description);
	}

	public java.util.List<com.rcs.service.model.ChatRoom> getChatRoomsForUser(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomLocalService.getChatRoomsForUser(userId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ChatRoomLocalService getWrappedChatRoomLocalService() {
		return _chatRoomLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedChatRoomLocalService(
		ChatRoomLocalService chatRoomLocalService) {
		_chatRoomLocalService = chatRoomLocalService;
	}

	public ChatRoomLocalService getWrappedService() {
		return _chatRoomLocalService;
	}

	public void setWrappedService(ChatRoomLocalService chatRoomLocalService) {
		_chatRoomLocalService = chatRoomLocalService;
	}

	private ChatRoomLocalService _chatRoomLocalService;
}