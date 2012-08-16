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
 * This class is a wrapper for {@link ChatRoomGroup}.
 * </p>
 *
 * @author    flor
 * @see       ChatRoomGroup
 * @generated
 */
public class ChatRoomGroupWrapper implements ChatRoomGroup,
	ModelWrapper<ChatRoomGroup> {
	public ChatRoomGroupWrapper(ChatRoomGroup chatRoomGroup) {
		_chatRoomGroup = chatRoomGroup;
	}

	public Class<?> getModelClass() {
		return ChatRoomGroup.class;
	}

	public String getModelClassName() {
		return ChatRoomGroup.class.getName();
	}

	/**
	* Returns the primary key of this chat room group.
	*
	* @return the primary key of this chat room group
	*/
	public com.rcs.service.service.persistence.ChatRoomGroupPK getPrimaryKey() {
		return _chatRoomGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this chat room group.
	*
	* @param primaryKey the primary key of this chat room group
	*/
	public void setPrimaryKey(
		com.rcs.service.service.persistence.ChatRoomGroupPK primaryKey) {
		_chatRoomGroup.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the chat room ID of this chat room group.
	*
	* @return the chat room ID of this chat room group
	*/
	public long getChatRoomId() {
		return _chatRoomGroup.getChatRoomId();
	}

	/**
	* Sets the chat room ID of this chat room group.
	*
	* @param chatRoomId the chat room ID of this chat room group
	*/
	public void setChatRoomId(long chatRoomId) {
		_chatRoomGroup.setChatRoomId(chatRoomId);
	}

	/**
	* Returns the chat room group ID of this chat room group.
	*
	* @return the chat room group ID of this chat room group
	*/
	public long getChatRoomGroupId() {
		return _chatRoomGroup.getChatRoomGroupId();
	}

	/**
	* Sets the chat room group ID of this chat room group.
	*
	* @param chatRoomGroupId the chat room group ID of this chat room group
	*/
	public void setChatRoomGroupId(long chatRoomGroupId) {
		_chatRoomGroup.setChatRoomGroupId(chatRoomGroupId);
	}

	/**
	* Returns the group ID of this chat room group.
	*
	* @return the group ID of this chat room group
	*/
	public long getGroupId() {
		return _chatRoomGroup.getGroupId();
	}

	/**
	* Sets the group ID of this chat room group.
	*
	* @param groupId the group ID of this chat room group
	*/
	public void setGroupId(long groupId) {
		_chatRoomGroup.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this chat room group.
	*
	* @return the company ID of this chat room group
	*/
	public long getCompanyId() {
		return _chatRoomGroup.getCompanyId();
	}

	/**
	* Sets the company ID of this chat room group.
	*
	* @param companyId the company ID of this chat room group
	*/
	public void setCompanyId(long companyId) {
		_chatRoomGroup.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this chat room group.
	*
	* @return the user ID of this chat room group
	*/
	public long getUserId() {
		return _chatRoomGroup.getUserId();
	}

	/**
	* Sets the user ID of this chat room group.
	*
	* @param userId the user ID of this chat room group
	*/
	public void setUserId(long userId) {
		_chatRoomGroup.setUserId(userId);
	}

	/**
	* Returns the user uuid of this chat room group.
	*
	* @return the user uuid of this chat room group
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomGroup.getUserUuid();
	}

	/**
	* Sets the user uuid of this chat room group.
	*
	* @param userUuid the user uuid of this chat room group
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_chatRoomGroup.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this chat room group.
	*
	* @return the user name of this chat room group
	*/
	public java.lang.String getUserName() {
		return _chatRoomGroup.getUserName();
	}

	/**
	* Sets the user name of this chat room group.
	*
	* @param userName the user name of this chat room group
	*/
	public void setUserName(java.lang.String userName) {
		_chatRoomGroup.setUserName(userName);
	}

	/**
	* Returns the create date of this chat room group.
	*
	* @return the create date of this chat room group
	*/
	public java.util.Date getCreateDate() {
		return _chatRoomGroup.getCreateDate();
	}

	/**
	* Sets the create date of this chat room group.
	*
	* @param createDate the create date of this chat room group
	*/
	public void setCreateDate(java.util.Date createDate) {
		_chatRoomGroup.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this chat room group.
	*
	* @return the modified date of this chat room group
	*/
	public java.util.Date getModifiedDate() {
		return _chatRoomGroup.getModifiedDate();
	}

	/**
	* Sets the modified date of this chat room group.
	*
	* @param modifiedDate the modified date of this chat room group
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_chatRoomGroup.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the type of this chat room group.
	*
	* @return the type of this chat room group
	*/
	public int getType() {
		return _chatRoomGroup.getType();
	}

	/**
	* Sets the type of this chat room group.
	*
	* @param type the type of this chat room group
	*/
	public void setType(int type) {
		_chatRoomGroup.setType(type);
	}

	public boolean isNew() {
		return _chatRoomGroup.isNew();
	}

	public void setNew(boolean n) {
		_chatRoomGroup.setNew(n);
	}

	public boolean isCachedModel() {
		return _chatRoomGroup.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_chatRoomGroup.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _chatRoomGroup.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _chatRoomGroup.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_chatRoomGroup.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _chatRoomGroup.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_chatRoomGroup.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ChatRoomGroupWrapper((ChatRoomGroup)_chatRoomGroup.clone());
	}

	public int compareTo(com.rcs.service.model.ChatRoomGroup chatRoomGroup) {
		return _chatRoomGroup.compareTo(chatRoomGroup);
	}

	@Override
	public int hashCode() {
		return _chatRoomGroup.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.rcs.service.model.ChatRoomGroup> toCacheModel() {
		return _chatRoomGroup.toCacheModel();
	}

	public com.rcs.service.model.ChatRoomGroup toEscapedModel() {
		return new ChatRoomGroupWrapper(_chatRoomGroup.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _chatRoomGroup.toString();
	}

	public java.lang.String toXmlString() {
		return _chatRoomGroup.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_chatRoomGroup.persist();
	}

	public com.liferay.portal.model.Group getGroup() {
		return _chatRoomGroup.getGroup();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ChatRoomGroup getWrappedChatRoomGroup() {
		return _chatRoomGroup;
	}

	public ChatRoomGroup getWrappedModel() {
		return _chatRoomGroup;
	}

	public void resetOriginalValues() {
		_chatRoomGroup.resetOriginalValues();
	}

	private ChatRoomGroup _chatRoomGroup;
}