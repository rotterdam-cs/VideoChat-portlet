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

import com.rcs.service.service.persistence.ChatRoomGroupPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    flor
 * @generated
 */
public class ChatRoomGroupSoap implements Serializable {
	public static ChatRoomGroupSoap toSoapModel(ChatRoomGroup model) {
		ChatRoomGroupSoap soapModel = new ChatRoomGroupSoap();

		soapModel.setChatRoomId(model.getChatRoomId());
		soapModel.setChatRoomGroupId(model.getChatRoomGroupId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static ChatRoomGroupSoap[] toSoapModels(ChatRoomGroup[] models) {
		ChatRoomGroupSoap[] soapModels = new ChatRoomGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChatRoomGroupSoap[][] toSoapModels(ChatRoomGroup[][] models) {
		ChatRoomGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChatRoomGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChatRoomGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChatRoomGroupSoap[] toSoapModels(List<ChatRoomGroup> models) {
		List<ChatRoomGroupSoap> soapModels = new ArrayList<ChatRoomGroupSoap>(models.size());

		for (ChatRoomGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChatRoomGroupSoap[soapModels.size()]);
	}

	public ChatRoomGroupSoap() {
	}

	public ChatRoomGroupPK getPrimaryKey() {
		return new ChatRoomGroupPK(_chatRoomId, _chatRoomGroupId);
	}

	public void setPrimaryKey(ChatRoomGroupPK pk) {
		setChatRoomId(pk.chatRoomId);
		setChatRoomGroupId(pk.chatRoomGroupId);
	}

	public long getChatRoomId() {
		return _chatRoomId;
	}

	public void setChatRoomId(long chatRoomId) {
		_chatRoomId = chatRoomId;
	}

	public long getChatRoomGroupId() {
		return _chatRoomGroupId;
	}

	public void setChatRoomGroupId(long chatRoomGroupId) {
		_chatRoomGroupId = chatRoomGroupId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	private long _chatRoomId;
	private long _chatRoomGroupId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _type;
}