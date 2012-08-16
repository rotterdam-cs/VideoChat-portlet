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

package com.rcs.service.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author flor
 */
public class ChatRoomGroupPK implements Comparable<ChatRoomGroupPK>,
	Serializable {
	public long chatRoomId;
	public long chatRoomGroupId;

	public ChatRoomGroupPK() {
	}

	public ChatRoomGroupPK(long chatRoomId, long chatRoomGroupId) {
		this.chatRoomId = chatRoomId;
		this.chatRoomGroupId = chatRoomGroupId;
	}

	public long getChatRoomId() {
		return chatRoomId;
	}

	public void setChatRoomId(long chatRoomId) {
		this.chatRoomId = chatRoomId;
	}

	public long getChatRoomGroupId() {
		return chatRoomGroupId;
	}

	public void setChatRoomGroupId(long chatRoomGroupId) {
		this.chatRoomGroupId = chatRoomGroupId;
	}

	public int compareTo(ChatRoomGroupPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (chatRoomId < pk.chatRoomId) {
			value = -1;
		}
		else if (chatRoomId > pk.chatRoomId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (chatRoomGroupId < pk.chatRoomGroupId) {
			value = -1;
		}
		else if (chatRoomGroupId > pk.chatRoomGroupId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ChatRoomGroupPK pk = null;

		try {
			pk = (ChatRoomGroupPK)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		if ((chatRoomId == pk.chatRoomId) &&
				(chatRoomGroupId == pk.chatRoomGroupId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(chatRoomId) + String.valueOf(chatRoomGroupId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("chatRoomId");
		sb.append(StringPool.EQUAL);
		sb.append(chatRoomId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("chatRoomGroupId");
		sb.append(StringPool.EQUAL);
		sb.append(chatRoomGroupId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}