/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ChatRoom}.
 * </p>
 *
 * @author Flor|Ale
 * @see ChatRoom
 * @generated
 */
public class ChatRoomWrapper implements ChatRoom, ModelWrapper<ChatRoom> {
	public ChatRoomWrapper(ChatRoom chatRoom) {
		_chatRoom = chatRoom;
	}

	@Override
	public Class<?> getModelClass() {
		return ChatRoom.class;
	}

	@Override
	public String getModelClassName() {
		return ChatRoom.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("chatRoomId", getChatRoomId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("sessionId", getSessionId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long chatRoomId = (Long)attributes.get("chatRoomId");

		if (chatRoomId != null) {
			setChatRoomId(chatRoomId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String sessionId = (String)attributes.get("sessionId");

		if (sessionId != null) {
			setSessionId(sessionId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this chat room.
	*
	* @return the primary key of this chat room
	*/
	@Override
	public long getPrimaryKey() {
		return _chatRoom.getPrimaryKey();
	}

	/**
	* Sets the primary key of this chat room.
	*
	* @param primaryKey the primary key of this chat room
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_chatRoom.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the chat room ID of this chat room.
	*
	* @return the chat room ID of this chat room
	*/
	@Override
	public long getChatRoomId() {
		return _chatRoom.getChatRoomId();
	}

	/**
	* Sets the chat room ID of this chat room.
	*
	* @param chatRoomId the chat room ID of this chat room
	*/
	@Override
	public void setChatRoomId(long chatRoomId) {
		_chatRoom.setChatRoomId(chatRoomId);
	}

	/**
	* Returns the group ID of this chat room.
	*
	* @return the group ID of this chat room
	*/
	@Override
	public long getGroupId() {
		return _chatRoom.getGroupId();
	}

	/**
	* Sets the group ID of this chat room.
	*
	* @param groupId the group ID of this chat room
	*/
	@Override
	public void setGroupId(long groupId) {
		_chatRoom.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this chat room.
	*
	* @return the company ID of this chat room
	*/
	@Override
	public long getCompanyId() {
		return _chatRoom.getCompanyId();
	}

	/**
	* Sets the company ID of this chat room.
	*
	* @param companyId the company ID of this chat room
	*/
	@Override
	public void setCompanyId(long companyId) {
		_chatRoom.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this chat room.
	*
	* @return the user ID of this chat room
	*/
	@Override
	public long getUserId() {
		return _chatRoom.getUserId();
	}

	/**
	* Sets the user ID of this chat room.
	*
	* @param userId the user ID of this chat room
	*/
	@Override
	public void setUserId(long userId) {
		_chatRoom.setUserId(userId);
	}

	/**
	* Returns the user uuid of this chat room.
	*
	* @return the user uuid of this chat room
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoom.getUserUuid();
	}

	/**
	* Sets the user uuid of this chat room.
	*
	* @param userUuid the user uuid of this chat room
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_chatRoom.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this chat room.
	*
	* @return the user name of this chat room
	*/
	@Override
	public java.lang.String getUserName() {
		return _chatRoom.getUserName();
	}

	/**
	* Sets the user name of this chat room.
	*
	* @param userName the user name of this chat room
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_chatRoom.setUserName(userName);
	}

	/**
	* Returns the create date of this chat room.
	*
	* @return the create date of this chat room
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _chatRoom.getCreateDate();
	}

	/**
	* Sets the create date of this chat room.
	*
	* @param createDate the create date of this chat room
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_chatRoom.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this chat room.
	*
	* @return the modified date of this chat room
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _chatRoom.getModifiedDate();
	}

	/**
	* Sets the modified date of this chat room.
	*
	* @param modifiedDate the modified date of this chat room
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_chatRoom.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the session ID of this chat room.
	*
	* @return the session ID of this chat room
	*/
	@Override
	public java.lang.String getSessionId() {
		return _chatRoom.getSessionId();
	}

	/**
	* Sets the session ID of this chat room.
	*
	* @param sessionId the session ID of this chat room
	*/
	@Override
	public void setSessionId(java.lang.String sessionId) {
		_chatRoom.setSessionId(sessionId);
	}

	/**
	* Returns the name of this chat room.
	*
	* @return the name of this chat room
	*/
	@Override
	public java.lang.String getName() {
		return _chatRoom.getName();
	}

	/**
	* Sets the name of this chat room.
	*
	* @param name the name of this chat room
	*/
	@Override
	public void setName(java.lang.String name) {
		_chatRoom.setName(name);
	}

	/**
	* Returns the description of this chat room.
	*
	* @return the description of this chat room
	*/
	@Override
	public java.lang.String getDescription() {
		return _chatRoom.getDescription();
	}

	/**
	* Sets the description of this chat room.
	*
	* @param description the description of this chat room
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_chatRoom.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _chatRoom.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_chatRoom.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _chatRoom.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_chatRoom.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _chatRoom.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _chatRoom.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_chatRoom.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _chatRoom.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_chatRoom.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_chatRoom.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_chatRoom.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ChatRoomWrapper((ChatRoom)_chatRoom.clone());
	}

	@Override
	public int compareTo(com.rcs.service.model.ChatRoom chatRoom) {
		return _chatRoom.compareTo(chatRoom);
	}

	@Override
	public int hashCode() {
		return _chatRoom.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rcs.service.model.ChatRoom> toCacheModel() {
		return _chatRoom.toCacheModel();
	}

	@Override
	public com.rcs.service.model.ChatRoom toEscapedModel() {
		return new ChatRoomWrapper(_chatRoom.toEscapedModel());
	}

	@Override
	public com.rcs.service.model.ChatRoom toUnescapedModel() {
		return new ChatRoomWrapper(_chatRoom.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _chatRoom.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _chatRoom.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_chatRoom.persist();
	}

	@Override
	public java.util.List<com.rcs.service.model.ChatRoomGroup> getChatRoomGroups()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chatRoom.getChatRoomGroups();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ChatRoomWrapper)) {
			return false;
		}

		ChatRoomWrapper chatRoomWrapper = (ChatRoomWrapper)obj;

		if (Validator.equals(_chatRoom, chatRoomWrapper._chatRoom)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ChatRoom getWrappedChatRoom() {
		return _chatRoom;
	}

	@Override
	public ChatRoom getWrappedModel() {
		return _chatRoom;
	}

	@Override
	public void resetOriginalValues() {
		_chatRoom.resetOriginalValues();
	}

	private ChatRoom _chatRoom;
}