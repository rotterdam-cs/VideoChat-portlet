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
import com.rcs.service.service.ChatRoomGroupLocalServiceUtil;
import com.rcs.service.service.base.ChatRoomGroupLocalServiceBaseImpl;
import com.rcs.service.service.persistence.ChatRoomGroupPK;
import com.rcs.service.service.persistence.ChatRoomGroupUtil;

/**
 * The implementation of the chat room group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rcs.service.service.ChatRoomGroupLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author flor
 * @see com.rcs.service.service.base.ChatRoomGroupLocalServiceBaseImpl
 * @see com.rcs.service.service.ChatRoomGroupLocalServiceUtil
 */
public class ChatRoomGroupLocalServiceImpl
	extends ChatRoomGroupLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rcs.service.service.ChatRoomGroupLocalServiceUtil} to access the chat room group local service.
	 */
	public ChatRoomGroup addChatRoomGroup(long userId, long chatRoomId, long chatRoomGroupId, int type) throws PortalException, SystemException {
		User user = UserUtil.findByPrimaryKey(userId);
	    Date now = new Date();	    
	    
	    ChatRoomGroupPK chatRoomGroupPK = new ChatRoomGroupPK(chatRoomId, chatRoomGroupId);
	    ChatRoomGroup chatRoomGroup = chatRoomGroupPersistence.create(chatRoomGroupPK);
	    
	    chatRoomGroup.setType(type);
	    
	    chatRoomGroup.setUserId(user.getUserId());
	    chatRoomGroup.setCompanyId(user.getCompanyId());
	    chatRoomGroup.setUserName(user.getFullName());
	    chatRoomGroup.setCreateDate(now);
	    chatRoomGroup.setModifiedDate(now);
	    
	    chatRoomGroup = chatRoomGroupPersistence.update(chatRoomGroup, true);	    
	    chatRoomGroupPersistence.clearCache();	    	    
	    return chatRoomGroup;
	}
	
	public List<ChatRoomGroup> getChatRoomsByChatRoomId(long chatRoomId) throws PortalException, SystemException {
		List<ChatRoomGroup> chatRoomGroups = new ArrayList<ChatRoomGroup>();
		chatRoomGroups = chatRoomGroupPersistence.findByBY_chatRoomId(chatRoomId);
		return chatRoomGroups;
		/*try {
			System.out.println("ChatRoomGroupLocalServiceImpl:getChatRoomsByChatRoomId:chatRoomId: " + chatRoomId);
			chatRoomGroups = chatRoomGroupPersistence.findByBY_chatRoomId(chatRoomId);			
			System.out.println("ChatRoomGroupLocalServiceImpl:getChatRoomsByChatRoomId:chatRoomGroups: " + chatRoomGroups.size());
		} catch (NullPointerException e) {
			return new ArrayList<ChatRoomGroup>();
		}
		
		return chatRoomGroups;*/
	}
	
	public List<Group> getGroupsByChatRoomGroups(List<ChatRoomGroup> chatRoomGroups) {
		List<Group> groups = new ArrayList<Group>();
		for(ChatRoomGroup chatRoomGroup : chatRoomGroups) {
			groups.add(chatRoomGroup.getGroup());
		}
		return groups;
	}
	//public List<ChatRoomGroup> getChatRoomsGroups
}