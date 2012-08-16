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

package com.rcs.service.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rcs.service.model.ChatRoomGroup;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ChatRoomGroup in entity cache.
 *
 * @author flor
 * @see ChatRoomGroup
 * @generated
 */
public class ChatRoomGroupCacheModel implements CacheModel<ChatRoomGroup>,
	Serializable {
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