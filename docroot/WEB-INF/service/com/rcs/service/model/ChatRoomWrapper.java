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

package com.rcs.service.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ChatRoom}.
 * </p>
 *
 * @author    flor
 * @see       ChatRoom
 * @generated
 */
public class ChatRoomWrapper implements ChatRoom, ModelWrapper<ChatRoom> {
	public ChatRoomWrapper(ChatRoom chatRoom) {
		_chatRoom = chatRoom;
	}

	public Class<?> getModelClass() {
		return ChatRoom.class;
	}

	public String getModelClassName() {
		return ChatRoom.class.getName();
	}

	/**
	* Returns the primary key of this chat room.
	*
	* @return the primary key of this chat room
	*/
	public long getPrimaryKey() {
		return _chatRoom.getPrimaryKey();
	}

	/**
	* Sets the primary key of this chat room.
	*
	* @param primaryKey the primary key of this chat room
	*/
	public void setPrimaryKey(long primaryKey) {
		_chatRoom.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the chat room ID of this chat room.
	*
	* @return the chat room ID of this chat room
	*/
	public long getChatRoomId() {
		return _chatRoom.getChatRoomId();
	}

	/**
	* Sets the chat room ID of this chat room.
	*
	* @param chatRoomId the chat room ID of this chat room
	*/
	public void setChatRoomId(long chatRoomId) {
		_chatRoom.setChatRoomId(chatRoomId);
	}

	/**
	* Returns the group ID of this chat room.
	*
	* @return the group ID of this chat room
	*/
	public long getGroupId() {
		return _chatRoom.getGroupId();
	}

	/**
	* Sets the group ID of this chat room.
	*
	* @param groupId the group ID of this chat room
	*/
	public void setGroupId(long groupId) {
		_chatRoom.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this chat room.
	*
	* @return the company ID of this chat room
	*/
	public long getCompanyId() {
		return _chatRoom.getCompanyId();
	}

	/**
	* Sets the company ID of this chat room.
	*
	* @param companyId the company ID of this chat room
	*/
	public void setCompanyId(long companyId) {
		_chatRoom.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this chat room.
	*
	* @return the user ID of this chat room
	*/
	public long getUserId() {
		return _chatRoom.getUserId();
	}

	/**
	* Sets the user ID of this chat room.
	*
	* @param userId the user ID of this chat room
	*/
	public void setUserId(long userId) {
		_chatRoom.setUserId(userId);
	}

	/**
	* Returns the user uuid of this chat room.
	*
	* @return the user uuid of this chat room
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoom.getUserUuid();
	}

	/**
	* Sets the user uuid of this chat room.
	*
	* @param userUuid the user uuid of this chat room
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_chatRoom.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this chat room.
	*
	* @return the user name of this chat room
	*/
	public java.lang.String getUserName() {
		return _chatRoom.getUserName();
	}

	/**
	* Sets the user name of this chat room.
	*
	* @param userName the user name of this chat room
	*/
	public void setUserName(java.lang.String userName) {
		_chatRoom.setUserName(userName);
	}

	/**
	* Returns the create date of this chat room.
	*
	* @return the create date of this chat room
	*/
	public java.util.Date getCreateDate() {
		return _chatRoom.getCreateDate();
	}

	/**
	* Sets the create date of this chat room.
	*
	* @param createDate the create date of this chat room
	*/
	public void setCreateDate(java.util.Date createDate) {
		_chatRoom.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this chat room.
	*
	* @return the modified date of this chat room
	*/
	public java.util.Date getModifiedDate() {
		return _chatRoom.getModifiedDate();
	}

	/**
	* Sets the modified date of this chat room.
	*
	* @param modifiedDate the modified date of this chat room
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_chatRoom.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the session ID of this chat room.
	*
	* @return the session ID of this chat room
	*/
	public java.lang.String getSessionId() {
		return _chatRoom.getSessionId();
	}

	/**
	* Sets the session ID of this chat room.
	*
	* @param sessionId the session ID of this chat room
	*/
	public void setSessionId(java.lang.String sessionId) {
		_chatRoom.setSessionId(sessionId);
	}

	/**
	* Returns the name of this chat room.
	*
	* @return the name of this chat room
	*/
	public java.lang.String getName() {
		return _chatRoom.getName();
	}

	/**
	* Sets the name of this chat room.
	*
	* @param name the name of this chat room
	*/
	public void setName(java.lang.String name) {
		_chatRoom.setName(name);
	}

	/**
	* Returns the description of this chat room.
	*
	* @return the description of this chat room
	*/
	public java.lang.String getDescription() {
		return _chatRoom.getDescription();
	}

	/**
	* Sets the description of this chat room.
	*
	* @param description the description of this chat room
	*/
	public void setDescription(java.lang.String description) {
		_chatRoom.setDescription(description);
	}

	public boolean isNew() {
		return _chatRoom.isNew();
	}

	public void setNew(boolean n) {
		_chatRoom.setNew(n);
	}

	public boolean isCachedModel() {
		return _chatRoom.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_chatRoom.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _chatRoom.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _chatRoom.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_chatRoom.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _chatRoom.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_chatRoom.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ChatRoomWrapper((ChatRoom)_chatRoom.clone());
	}

	public int compareTo(com.rcs.service.model.ChatRoom chatRoom) {
		return _chatRoom.compareTo(chatRoom);
	}

	@Override
	public int hashCode() {
		return _chatRoom.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.rcs.service.model.ChatRoom> toCacheModel() {
		return _chatRoom.toCacheModel();
	}

	public com.rcs.service.model.ChatRoom toEscapedModel() {
		return new ChatRoomWrapper(_chatRoom.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _chatRoom.toString();
	}

	public java.lang.String toXmlString() {
		return _chatRoom.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_chatRoom.persist();
	}

	public java.util.List<com.rcs.service.model.ChatRoomGroup> getChatRoomGroups()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chatRoom.getChatRoomGroups();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ChatRoom getWrappedChatRoom() {
		return _chatRoom;
	}

	public ChatRoom getWrappedModel() {
		return _chatRoom;
	}

	public void resetOriginalValues() {
		_chatRoom.resetOriginalValues();
	}

	private ChatRoom _chatRoom;
}