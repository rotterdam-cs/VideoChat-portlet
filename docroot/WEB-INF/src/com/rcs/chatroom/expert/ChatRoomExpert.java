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
import com.opentok.api.OpenTokSession;
import com.rcs.common.PortalInstanceIdentifier;
import com.rcs.common.ServiceActionResult;
import com.rcs.service.model.ChatRoom;
import com.rcs.service.model.Configuration;
import com.rcs.service.service.ChatRoomLocalServiceUtil;
import com.rcs.service.service.ConfigurationLocalServiceUtil;

@Component
public class ChatRoomExpert {
	private static Log log = LogFactoryUtil.getLog(ChatRoomExpert.class);
	
	/**
	 * Create chat room
	 * @param pII
	 * @param chatRoomName
	 * @param chatRoomDescription
	 * @param chatRoomGroupId
	 * @return
	 */
	public ServiceActionResult<ChatRoom> addChatRoom (
			 PortalInstanceIdentifier pII
			, String chatRoomName
			, String chatRoomDescription			
	) {				
		ServiceActionResult<ChatRoom> resultupdate = null;		
		try {
			if (pII.validateFullParameters()) {
				List<Configuration> configurations = ConfigurationLocalServiceUtil.getConfigurations(0, 1);
				if(configurations.size() == 0) {
					resultupdate = ServiceActionResult.buildFailure(null);
					resultupdate.setMessage("@@ There is no configuration added in opentok.");
					//@@ seguir acá, como paso el mensaje de error, modificar service action result
					return resultupdate;
				}
				Configuration configuration = configurations.get(0);
				// generate the session id to create a chat room in opentok server
				OpenTokSDK sdk = new OpenTokSDK(Integer.parseInt(ConfigurationLocalServiceUtil.getApiKey()), ConfigurationLocalServiceUtil.getApiSecret());															
				System.out.println("sdk: " + sdk);
				//@@ chequear este error
				String sessionId = "";
				try {
					OpenTokSession session =sdk.create_session();					
					sessionId = session.getSessionId();
				} catch(Exception e) {					
					resultupdate = ServiceActionResult.buildFailure(null);
					resultupdate.setMessage("@@ The api key and/or api secret provided for opentok are wrong.");
					return resultupdate;
				}
				System.out.println("sessionId: " + sessionId);
				// create the chat room
				ChatRoom chatRoom = ChatRoomLocalServiceUtil.addChatRoom(pII.getUserId(), chatRoomName, chatRoomDescription, sessionId);		        
		        resultupdate = ServiceActionResult.buildSuccess(chatRoom);
		        resultupdate.setMessage("Chat room successfully saved.");
			} else {
				resultupdate = ServiceActionResult.buildFailure(null);
			}
	        
		} catch (NoSuchUserException e) {
			log.error("NoSuchUserException " + e.getMessage());
			resultupdate = ServiceActionResult.buildFailure(null);
			resultupdate.setMessage("@@ The user that tried to create the chat room does not exist");
		} catch (SystemException e) {
			log.error("SystemException " + e.getMessage());
			resultupdate = ServiceActionResult.buildFailure(null);
			resultupdate.setMessage("@@ Error saving the chatroom");
		}catch (PortalException e) {
			log.error("PortalException " + e.getMessage());
			resultupdate = ServiceActionResult.buildFailure(null);
			resultupdate.setMessage("@@ Error saving the chatroom");
		} catch (Exception e) {
			log.error("Exception " + e.getMessage());
			resultupdate = ServiceActionResult.buildFailure(null);
			resultupdate.setMessage("@@ Error saving the chatroom");
		} 
		return resultupdate;
    }
	
	//@@ seguri acá, agregar los grupos
	public ServiceActionResult<ChatRoom> updateChatRoom (
			 PortalInstanceIdentifier pII
			, long chatRoomId
			, String chatRoomName
			, String chatRoomDescription			
	) {				
		ServiceActionResult<ChatRoom> resultupdate = null;
		try {
			if (pII.validateFullParameters()) {												
				// create the chat room
				//ChatRoom chatRoom = ChatRoomLocalServiceUtil.addChatRoom(pII.getUserId(), chatRoomName, chatRoomDescription, sessionId);
				ChatRoom chatRoom = ChatRoomLocalServiceUtil.getChatRoom(chatRoomId);
				chatRoom.setName(chatRoomName);
				chatRoom.setDescription(chatRoomDescription);				
				chatRoom = ChatRoomLocalServiceUtil.updateChatRoom(chatRoom);
		        resultupdate = ServiceActionResult.buildSuccess(chatRoom);
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
	/**
	 * Delete chat room
	 * @param chatRoomId
	 * @return
	 */
	/*public ServiceActionResult<ChatRoom> deleteChatRoom(long chatRoomId) {
		ServiceActionResult<ChatRoom> resultDelete = null;
		try {
			ChatRoomLocalServiceUtil.deleteChatRoom(chatRoomId);			
			resultDelete = ServiceActionResult.buildSuccess(ChatRoom);
		} catch (SystemException e) {
			log.error("SystemException " + e.getMessage());
			resultDelete = ServiceActionResult.buildFailure(null);
		}catch (PortalException e) {
			log.error("PortalException " + e.getMessage());
			resultDelete = ServiceActionResult.buildFailure(null);
		} catch (Exception e) {
			log.error("Exception " + e.getMessage());
			resultDelete = ServiceActionResult.buildFailure(null);
		} 
		return resultDelete;
	}*/
	//@@ cambiar esto!!
	public boolean deleteChatRoom(long chatRoomId) {
		ServiceActionResult<ChatRoom> resultDelete = null;
		try {
			ChatRoomLocalServiceUtil.deleteChatRoom(chatRoomId);			
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
}
