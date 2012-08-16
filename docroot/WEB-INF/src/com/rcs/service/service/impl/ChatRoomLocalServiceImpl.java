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

package com.rcs.service.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.rcs.service.model.ChatRoom;
import com.rcs.service.model.ChatRoomGroup;
import com.rcs.service.service.ChatRoomLocalServiceUtil;
import com.rcs.service.service.base.ChatRoomLocalServiceBaseImpl;

/**
 * The implementation of the chat room local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rcs.service.service.ChatRoomLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author flor
 * @see com.rcs.service.service.base.ChatRoomLocalServiceBaseImpl
 * @see com.rcs.service.service.ChatRoomLocalServiceUtil
 */
public class ChatRoomLocalServiceImpl extends ChatRoomLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rcs.service.service.ChatRoomLocalServiceUtil} to access the chat room local service.
	 */
	public ChatRoom addChatRoom(long userId, String name, String description, String sessionId) throws PortalException, SystemException {
	    User user = UserUtil.findByPrimaryKey(userId);
	    Date now = new Date();
	    long chatRoomId = CounterLocalServiceUtil.increment(ChatRoom.class.getName());
	    
	    ChatRoom chatRoom = chatRoomPersistence.create(chatRoomId);
	    
	    
	    chatRoom.setName(name);
	    chatRoom.setDescription(description);
	    chatRoom.setSessionId(sessionId);	    
	    
	    chatRoom.setUserId(user.getUserId());
	    chatRoom.setCompanyId(user.getCompanyId());
	    chatRoom.setUserName(user.getFullName());
	    chatRoom.setCreateDate(now);
	    chatRoom.setModifiedDate(now);
	    
	    chatRoom = chatRoomPersistence.update(chatRoom, true);	    
	    chatRoomPersistence.clearCache();	    	    
	    return chatRoom;
	}
	
	public ChatRoom updateChatRoom(long userId, long chatRoomId, String name, String description) throws PortalException, SystemException {
		User user = UserUtil.findByPrimaryKey(userId);
	    Date now = new Date();
	    ChatRoom chatRoom = chatRoomPersistence.findByPrimaryKey(chatRoomId);	    	   
	    
	    chatRoom.setName(name);
	    chatRoom.setDescription(description);	    	   
	    
	    chatRoom.setUserId(user.getUserId());
	    chatRoom.setCompanyId(user.getCompanyId());
	    chatRoom.setUserName(user.getFullName());	    
	    chatRoom.setModifiedDate(now);
	    
	    chatRoom = chatRoomPersistence.update(chatRoom, true);	    
	    chatRoomPersistence.clearCache();	    	    
	    return chatRoom;
	}
	
	public List<ChatRoom> getChatRoomsForUser(long userId) throws PortalException, SystemException {
		List<ChatRoom> userChatRooms = new ArrayList<ChatRoom>();
		User user = UserUtil.findByPrimaryKey(userId);
		List userGroups = user.getGroups();
		List<ChatRoom> chatRooms = chatRoomPersistence.findAll();
		for(ChatRoom chatRoom : chatRooms) {
			System.out.println("chatRoom.getChatRoomId(): " + chatRoom.getChatRoomId());
			List<ChatRoomGroup> chatRoomGroups = chatRoom.getChatRoomGroups();
			System.out.println("chatRoomGroups.size(): " + chatRoomGroups.size());
			if(chatRoomGroups.size() == 0) {
				userChatRooms.add(chatRoom);
			} else {
				for(ChatRoomGroup chatRoomGroup : chatRoomGroups) {
					System.out.println("chatRoomGroup.getChatRoomGroupId(): " + chatRoomGroup.getChatRoomGroupId());
					Group group = chatRoomGroup.getGroup();
					if(userGroups.contains(group)) {
						userChatRooms.add(chatRoom);
						break;
					}
				}
			}					
		}
		return userChatRooms;
	}
}
