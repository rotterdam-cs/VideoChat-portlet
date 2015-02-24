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

package com.rcs.service.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rcs.service.model.ChatRoomGroup;
import com.rcs.service.model.ChatRoomGroupModel;
import com.rcs.service.service.persistence.ChatRoomGroupPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ChatRoomGroup service. Represents a row in the &quot;VideoChat_ChatRoomGroup&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rcs.service.model.ChatRoomGroupModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ChatRoomGroupImpl}.
 * </p>
 *
 * @author Flor|Ale
 * @see ChatRoomGroupImpl
 * @see com.rcs.service.model.ChatRoomGroup
 * @see com.rcs.service.model.ChatRoomGroupModel
 * @generated
 */
public class ChatRoomGroupModelImpl extends BaseModelImpl<ChatRoomGroup>
	implements ChatRoomGroupModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a chat room group model instance should use the {@link com.rcs.service.model.ChatRoomGroup} interface instead.
	 */
	public static final String TABLE_NAME = "VideoChat_ChatRoomGroup";
	public static final Object[][] TABLE_COLUMNS = {
			{ "chatRoomId", Types.BIGINT },
			{ "chatRoomGroupId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "type_", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table VideoChat_ChatRoomGroup (chatRoomId LONG not null,chatRoomGroupId LONG not null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,type_ INTEGER,primary key (chatRoomId, chatRoomGroupId))";
	public static final String TABLE_SQL_DROP = "drop table VideoChat_ChatRoomGroup";
	public static final String ORDER_BY_JPQL = " ORDER BY chatRoomGroup.id.chatRoomId ASC, chatRoomGroup.id.chatRoomGroupId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY VideoChat_ChatRoomGroup.chatRoomId ASC, VideoChat_ChatRoomGroup.chatRoomGroupId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rcs.service.model.ChatRoomGroup"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rcs.service.model.ChatRoomGroup"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rcs.service.model.ChatRoomGroup"),
			true);
	public static long CHATROOMID_COLUMN_BITMASK = 1L;
	public static long TYPE_COLUMN_BITMASK = 2L;
	public static long CHATROOMGROUPID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rcs.service.model.ChatRoomGroup"));

	public ChatRoomGroupModelImpl() {
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
	public Class<?> getModelClass() {
		return ChatRoomGroup.class;
	}

	@Override
	public String getModelClassName() {
		return ChatRoomGroup.class.getName();
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
		_columnBitmask |= CHATROOMID_COLUMN_BITMASK;

		if (!_setOriginalChatRoomId) {
			_setOriginalChatRoomId = true;

			_originalChatRoomId = _chatRoomId;
		}

		_chatRoomId = chatRoomId;
	}

	public long getOriginalChatRoomId() {
		return _originalChatRoomId;
	}

	@Override
	public long getChatRoomGroupId() {
		return _chatRoomGroupId;
	}

	@Override
	public void setChatRoomGroupId(long chatRoomGroupId) {
		_chatRoomGroupId = chatRoomGroupId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
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
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (!_setOriginalType) {
			_setOriginalType = true;

			_originalType = _type;
		}

		_type = type;
	}

	public int getOriginalType() {
		return _originalType;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ChatRoomGroup toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ChatRoomGroup)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ChatRoomGroupImpl chatRoomGroupImpl = new ChatRoomGroupImpl();

		chatRoomGroupImpl.setChatRoomId(getChatRoomId());
		chatRoomGroupImpl.setChatRoomGroupId(getChatRoomGroupId());
		chatRoomGroupImpl.setGroupId(getGroupId());
		chatRoomGroupImpl.setCompanyId(getCompanyId());
		chatRoomGroupImpl.setUserId(getUserId());
		chatRoomGroupImpl.setUserName(getUserName());
		chatRoomGroupImpl.setCreateDate(getCreateDate());
		chatRoomGroupImpl.setModifiedDate(getModifiedDate());
		chatRoomGroupImpl.setType(getType());

		chatRoomGroupImpl.resetOriginalValues();

		return chatRoomGroupImpl;
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

		if (!(obj instanceof ChatRoomGroup)) {
			return false;
		}

		ChatRoomGroup chatRoomGroup = (ChatRoomGroup)obj;

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
	public void resetOriginalValues() {
		ChatRoomGroupModelImpl chatRoomGroupModelImpl = this;

		chatRoomGroupModelImpl._originalChatRoomId = chatRoomGroupModelImpl._chatRoomId;

		chatRoomGroupModelImpl._setOriginalChatRoomId = false;

		chatRoomGroupModelImpl._originalType = chatRoomGroupModelImpl._type;

		chatRoomGroupModelImpl._setOriginalType = false;

		chatRoomGroupModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ChatRoomGroup> toCacheModel() {
		ChatRoomGroupCacheModel chatRoomGroupCacheModel = new ChatRoomGroupCacheModel();

		chatRoomGroupCacheModel.chatRoomId = getChatRoomId();

		chatRoomGroupCacheModel.chatRoomGroupId = getChatRoomGroupId();

		chatRoomGroupCacheModel.groupId = getGroupId();

		chatRoomGroupCacheModel.companyId = getCompanyId();

		chatRoomGroupCacheModel.userId = getUserId();

		chatRoomGroupCacheModel.userName = getUserName();

		String userName = chatRoomGroupCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			chatRoomGroupCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			chatRoomGroupCacheModel.createDate = createDate.getTime();
		}
		else {
			chatRoomGroupCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			chatRoomGroupCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			chatRoomGroupCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		chatRoomGroupCacheModel.type = getType();

		return chatRoomGroupCacheModel;
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

	private static ClassLoader _classLoader = ChatRoomGroup.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ChatRoomGroup.class
		};
	private long _chatRoomId;
	private long _originalChatRoomId;
	private boolean _setOriginalChatRoomId;
	private long _chatRoomGroupId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _type;
	private int _originalType;
	private boolean _setOriginalType;
	private long _columnBitmask;
	private ChatRoomGroup _escapedModel;
}