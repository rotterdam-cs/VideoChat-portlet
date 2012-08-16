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

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.rcs.service.model.ChatRoomGroup;
import com.rcs.service.service.ChatRoomGroupLocalServiceUtil;
import com.rcs.service.service.impl.ChatRoomGroupLocalServiceImpl;
import com.rcs.service.service.persistence.ChatRoomGroupUtil;

/**
 * The extended model implementation for the ChatRoom service. Represents a row in the &quot;VideoChat_ChatRoom&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rcs.service.model.ChatRoom} interface.
 * </p>
 *
 * @author flor
 */
public class ChatRoomImpl extends ChatRoomBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a chat room model instance should use the {@link com.rcs.service.model.ChatRoom} interface instead.
	 */
	public ChatRoomImpl() {
	}	
	
	public List<ChatRoomGroup> getChatRoomGroups() throws PortalException, SystemException {
		//ChatRoomGroupLocalServiceImpl chglsi = new ChatRoomGroupLocalServiceImpl();
		return ChatRoomGroupLocalServiceUtil.getChatRoomsByChatRoomId(getChatRoomId());
		//return ChatRoomGroupUtil.findByBY_chatRoomId(getChatRoomId());
		//return chglsi.getChatRoomsByChatRoomId(getChatRoomId());
	}
}