package com.rcs.chatroom.expert;

import java.util.List;

import org.springframework.stereotype.Component;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.opentok.api.API_Config;
import com.opentok.api.OpenTokSDK;
import com.rcs.common.LocalResponse;
import com.rcs.common.PortalInstanceIdentifier;
import com.rcs.common.ServiceActionResult;
import com.rcs.service.model.ChatRoom;
import com.rcs.service.model.ChatRoomGroup;
import com.rcs.service.service.ChatRoomGroupLocalServiceUtil;
import com.rcs.service.service.ChatRoomLocalServiceUtil;
import com.rcs.service.service.persistence.ChatRoomGroupPK;

@Component
public class ChatRoomGroupExpert {
	private static Log log = LogFactoryUtil.getLog(ChatRoomGroupExpert.class);
	
	/**
	 * Create chat room
	 * @param pII
	 * @param chatRoomName
	 * @param chatRoomDescription
	 * @param chatRoomGroupId
	 * @return
	 */
	public ServiceActionResult<ChatRoomGroup> addChatRoomGroup (
			 PortalInstanceIdentifier pII
			, long chatRoomId
			, long chatRoomGroupId
			, int type
	) {				
		ServiceActionResult<ChatRoomGroup> resultupdate = null;
		try {
			if (pII.validateFullParameters()) {							
				// create the chat room group
				ChatRoomGroup chatRoomGroup = ChatRoomGroupLocalServiceUtil.addChatRoomGroup(pII.getUserId(), chatRoomId, chatRoomGroupId, type);		        
		        resultupdate = ServiceActionResult.buildSuccess(chatRoomGroup);
			} else {
				resultupdate = ServiceActionResult.buildFailure(null);
			}
	        
		} catch (NoSuchUserException e) {
			log.error("NoSuchUserException " + e.getMessage());
			resultupdate = ServiceActionResult.buildFailure(null);
		} catch (SystemException e) {
			log.error("SystemException " + e.getMessage());
			resultupdate = ServiceActionResult.buildFailure(null);
		}catch (PortalException e) {
			log.error("PortalException " + e.getMessage());
			resultupdate = ServiceActionResult.buildFailure(null);
		} catch (Exception e) {
			log.error("Exception " + e.getMessage());
			resultupdate = ServiceActionResult.buildFailure(null);
		} 
		return resultupdate;
    }
		
	public boolean deleteChatRoomGroup(long chatRoomId, long chatRoomGroupId) {
		ServiceActionResult resultDelete = null;
		try {
			ChatRoomGroupPK chatRoomGroupPK = new ChatRoomGroupPK(chatRoomId, chatRoomGroupId);
			ChatRoomGroupLocalServiceUtil.deleteChatRoomGroup(chatRoomGroupPK);			
			return true;
		} catch (SystemException e) {
			log.error("SystemException " + e.getMessage());			
		}catch (PortalException e) {
			log.error("PortalException " + e.getMessage());			
		} catch (Exception e) {
			log.error("Exception " + e.getMessage());			
		} 
		return false;
	}
	
	public LocalResponse deleteChatRoomGroups(long chatRoomId) {
		LocalResponse response = new LocalResponse();
		try {
			List<ChatRoomGroup> chatRoomGroups = ChatRoomGroupLocalServiceUtil.getChatRoomsByChatRoomId(chatRoomId);
			for(ChatRoomGroup chatRoomGroup : chatRoomGroups) {
				try {
					ChatRoomGroupPK chatRoomGroupPK = new ChatRoomGroupPK(chatRoomId, chatRoomGroup.getChatRoomGroupId());
					ChatRoomGroupLocalServiceUtil.deleteChatRoomGroup(chatRoomGroupPK);
				} catch (SystemException e) {
					log.error("SystemException " + e.getMessage());
					response.setSuccess(false);
					response.setMessage(e.getMessage());
					return response;
				}catch (PortalException e) {
					log.error("PortalException " + e.getMessage());			
					response.setSuccess(false);
					response.setMessage(e.getMessage());
					return response;
				}
			}			
		} catch (SystemException e) {
			log.error("SystemException " + e.getMessage());			
			response.setSuccess(false);
			response.setMessage(e.getMessage());
			return response;
		}catch (PortalException e) {
			log.error("PortalException " + e.getMessage());			
			response.setSuccess(false);
			response.setMessage(e.getMessage());
			return response;
		} catch (Exception e) {
			log.error("Exception " + e.getMessage());			
			response.setSuccess(false);
			response.setMessage(e.getMessage());
			return response;
		}
		response.setSuccess(true);
		return response;
	}			
}
