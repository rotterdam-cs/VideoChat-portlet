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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rcs.service.model.ChatRoom;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ChatRoom in entity cache.
 *
 * @author Flor|Ale
 * @see ChatRoom
 * @generated
 */
public class ChatRoomCacheModel implements CacheModel<ChatRoom>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{chatRoomId=");
		sb.append(chatRoomId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", sessionId=");
		sb.append(sessionId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ChatRoom toEntityModel() {
		ChatRoomImpl chatRoomImpl = new ChatRoomImpl();

		chatRoomImpl.setChatRoomId(chatRoomId);
		chatRoomImpl.setGroupId(groupId);
		chatRoomImpl.setCompanyId(companyId);
		chatRoomImpl.setUserId(userId);

		if (userName == null) {
			chatRoomImpl.setUserName(StringPool.BLANK);
		}
		else {
			chatRoomImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			chatRoomImpl.setCreateDate(null);
		}
		else {
			chatRoomImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			chatRoomImpl.setModifiedDate(null);
		}
		else {
			chatRoomImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (sessionId == null) {
			chatRoomImpl.setSessionId(StringPool.BLANK);
		}
		else {
			chatRoomImpl.setSessionId(sessionId);
		}

		if (name == null) {
			chatRoomImpl.setName(StringPool.BLANK);
		}
		else {
			chatRoomImpl.setName(name);
		}

		if (description == null) {
			chatRoomImpl.setDescription(StringPool.BLANK);
		}
		else {
			chatRoomImpl.setDescription(description);
		}

		chatRoomImpl.resetOriginalValues();

		return chatRoomImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		chatRoomId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		sessionId = objectInput.readUTF();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(chatRoomId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (sessionId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sessionId);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long chatRoomId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String sessionId;
	public String name;
	public String description;
}