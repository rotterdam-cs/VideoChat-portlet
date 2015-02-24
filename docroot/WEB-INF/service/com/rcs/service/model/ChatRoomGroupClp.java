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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rcs.service.service.ChatRoomGroupLocalServiceUtil;
import com.rcs.service.service.ClpSerializer;
import com.rcs.service.service.persistence.ChatRoomGroupPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Flor
Ale
 */
public class ChatRoomGroupClp extends BaseModelImpl<ChatRoomGroup>
	implements ChatRoomGroup {
	public ChatRoomGroupClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ChatRoomGroup.class;
	}

	@Override
	public String getModelClassName() {
		return ChatRoomGroup.class.getName();
	}

	@Override
	public ChatRoomGroupPK getPrimaryKey() {
		return new ChatRoomGroupPK(_chatRoomId, _chatRoomGroupId);
	}

	@Override
	public void setPrimaryKey(ChatRoomGroupPK primaryKey) {
		setChatRoomId(primaryKey.chatRoomId);
		setChatRoomGroupId(primaryKey.chatRoomGroupId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ChatRoomGroupPK(_chatRoomId, _chatRoomGroupId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ChatRoomGroupPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("chatRoomId", getChatRoomId());
		attributes.put("chatRoomGroupId", getChatRoomGroupId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long chatRoomId = (Long)attributes.get("chatRoomId");

		if (chatRoomId != null) {
			setChatRoomId(chatRoomId);
		}

		Long chatRoomGroupId = (Long)attributes.get("chatRoomGroupId");

		if (chatRoomGroupId != null) {
			setChatRoomGroupId(chatRoomGroupId);
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

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	@Override
	public long getChatRoomId() {
		return _chatRoomId;
	}

	@Override
	public void setChatRoomId(long chatRoomId) {
		_chatRoomId = chatRoomId;

		if (_chatRoomGroupRemoteModel != null) {
			try {
				Class<?> clazz = _chatRoomGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setChatRoomId", long.class);

				method.invoke(_chatRoomGroupRemoteModel, chatRoomId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getChatRoomGroupId() {
		return _chatRoomGroupId;
	}

	@Override
	public void setChatRoomGroupId(long chatRoomGroupId) {
		_chatRoomGroupId = chatRoomGroupId;

		if (_chatRoomGroupRemoteModel != null) {
			try {
				Class<?> clazz = _chatRoomGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setChatRoomGroupId", long.class);

				method.invoke(_chatRoomGroupRemoteModel, chatRoomGroupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_chatRoomGroupRemoteModel != null) {
			try {
				Class<?> clazz = _chatRoomGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_chatRoomGroupRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_chatRoomGroupRemoteModel != null) {
			try {
				Class<?> clazz = _chatRoomGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_chatRoomGroupRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_chatRoomGroupRemoteModel != null) {
			try {
				Class<?> clazz = _chatRoomGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_chatRoomGroupRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_chatRoomGroupRemoteModel != null) {
			try {
				Class<?> clazz = _chatRoomGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_chatRoomGroupRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_chatRoomGroupRemoteModel != null) {
			try {
				Class<?> clazz = _chatRoomGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_chatRoomGroupRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_chatRoomGroupRemoteModel != null) {
			try {
				Class<?> clazz = _chatRoomGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_chatRoomGroupRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_type = type;

		if (_chatRoomGroupRemoteModel != null) {
			try {
				Class<?> clazz = _chatRoomGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setType", int.class);

				method.invoke(_chatRoomGroupRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public com.liferay.portal.model.Group getGroup() {
		try {
			String methodName = "getGroup";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.portal.model.Group returnObj = (com.liferay.portal.model.Group)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getChatRoomGroupRemoteModel() {
		return _chatRoomGroupRemoteModel;
	}

	public void setChatRoomGroupRemoteModel(
		BaseModel<?> chatRoomGroupRemoteModel) {
		_chatRoomGroupRemoteModel = chatRoomGroupRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _chatRoomGroupRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_chatRoomGroupRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ChatRoomGroupLocalServiceUtil.addChatRoomGroup(this);
		}
		else {
			ChatRoomGroupLocalServiceUtil.updateChatRoomGroup(this);
		}
	}

	@Override
	public ChatRoomGroup toEscapedModel() {
		return (ChatRoomGroup)ProxyUtil.newProxyInstance(ChatRoomGroup.class.getClassLoader(),
			new Class[] { ChatRoomGroup.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ChatRoomGroupClp clone = new ChatRoomGroupClp();

		clone.setChatRoomId(getChatRoomId());
		clone.setChatRoomGroupId(getChatRoomGroupId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setType(getType());

		return clone;
	}

	@Override
	public int compareTo(ChatRoomGroup chatRoomGroup) {
		ChatRoomGroupPK primaryKey = chatRoomGroup.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ChatRoomGroupClp)) {
			return false;
		}

		ChatRoomGroupClp chatRoomGroup = (ChatRoomGroupClp)obj;

		ChatRoomGroupPK primaryKey = chatRoomGroup.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{chatRoomId=");
		sb.append(getChatRoomId());
		sb.append(", chatRoomGroupId=");
		sb.append(getChatRoomGroupId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", type=");
		sb.append(getType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.rcs.service.model.ChatRoomGroup");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>chatRoomId</column-name><column-value><![CDATA[");
		sb.append(getChatRoomId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chatRoomGroupId</column-name><column-value><![CDATA[");
		sb.append(getChatRoomGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _chatRoomId;
	private long _chatRoomGroupId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _type;
	private BaseModel<?> _chatRoomGroupRemoteModel;
}