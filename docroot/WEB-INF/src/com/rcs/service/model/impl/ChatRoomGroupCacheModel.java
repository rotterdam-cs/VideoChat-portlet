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

import com.rcs.service.model.ChatRoomGroup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ChatRoomGroup in entity cache.
 *
 * @author Flor|Ale
 * @see ChatRoomGroup
 * @generated
 */
public class ChatRoomGroupCacheModel implements CacheModel<ChatRoomGroup>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{chatRoomId=");
		sb.append(chatRoomId);
		sb.append(", chatRoomGroupId=");
		sb.append(chatRoomGroupId);
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
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ChatRoomGroup toEntityModel() {
		ChatRoomGroupImpl chatRoomGroupImpl = new ChatRoomGroupImpl();

		chatRoomGroupImpl.setChatRoomId(chatRoomId);
		chatRoomGroupImpl.setChatRoomGroupId(chatRoomGroupId);
		chatRoomGroupImpl.setGroupId(groupId);
		chatRoomGroupImpl.setCompanyId(companyId);
		chatRoomGroupImpl.setUserId(userId);

		if (userName == null) {
			chatRoomGroupImpl.setUserName(StringPool.BLANK);
		}
		else {
			chatRoomGroupImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			chatRoomGroupImpl.setCreateDate(null);
		}
		else {
			chatRoomGroupImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			chatRoomGroupImpl.setModifiedDate(null);
		}
		else {
			chatRoomGroupImpl.setModifiedDate(new Date(modifiedDate));
		}

		chatRoomGroupImpl.setType(type);

		chatRoomGroupImpl.resetOriginalValues();

		return chatRoomGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		chatRoomId = objectInput.readLong();
		chatRoomGroupId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		type = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(chatRoomId);
		objectOutput.writeLong(chatRoomGroupId);
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
		objectOutput.writeInt(type);
	}

	public long chatRoomId;
	public long chatRoomGroupId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int type;
}