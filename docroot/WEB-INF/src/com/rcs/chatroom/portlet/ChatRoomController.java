package com.rcs.chatroom.portlet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WebsiteLocalServiceUtil;
import com.liferay.portal.util.comparator.GroupTypeComparator;
import com.rcs.chatroom.expert.ChatRoomExpert;
import com.rcs.chatroom.expert.ChatRoomGroupExpert;
import com.rcs.common.LocalResponse;
import com.rcs.common.PortalInstanceIdentifier;
import com.rcs.common.ResourceBundleHelper;
import com.rcs.common.ServiceActionResult;
import com.rcs.expert.UtilsExpert;
import com.rcs.service.model.ChatRoom;
import com.rcs.service.model.ChatRoomGroup;
import com.rcs.service.model.Configuration;
import com.rcs.service.service.ChatRoomGroupLocalServiceUtil;
import com.rcs.service.service.ChatRoomLocalServiceUtil;
import com.rcs.service.service.ConfigurationLocalServiceUtil;
import com.rcs.service.service.impl.ChatRoomGroupLocalServiceImpl;
import com.rcs.service.service.persistence.ChatRoomGroupPersistenceImpl;
import com.rcs.service.service.persistence.ChatRoomGroupUtil;

@Controller(value="ChatRoomController")
@RequestMapping("VIEW")
public class ChatRoomController {

	private static Log log = LogFactoryUtil.getLog(ChatRoomController.class);
	private PortalInstanceIdentifier pII;
	private Locale locale;	
	private boolean authorized;
	
	@Autowired
    private UtilsExpert utilsExpert;
	
	@Autowired
    private ChatRoomExpert chatRoomExpert;
	
	@Autowired
    private ChatRoomGroupExpert chatRoomGroupExpert;
	/**
	 * Main view
	 * @param request
	 * @param response
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@RenderMapping
	public ModelAndView resolveView(PortletRequest request, PortletResponse response) throws PortalException, SystemException {		  
		return new ModelAndView("chatroom/chatrooms");
	}
	
	@ResourceMapping(value = "adminSections")
    public ModelAndView adminSectionsController(
             String section
            ,ResourceRequest request
            ,ResourceResponse response
    ) throws Exception {		
	    HashMap<String, Object> model = new HashMap<String, Object>();		            
	    //Configuration
	    List<Configuration> configurations = ConfigurationLocalServiceUtil.getConfigurations(0,1);
        if (section.equals("configuration")) {       	        	        
        	if(configurations.size() > 0) {
        		Configuration configuration = configurations.get(0);
        		model.put("apiKey", configuration.getApiKey());
        		model.put("apiSecret", configuration.getApiSecret());
        		model.put("type", configuration.getType());
        	} 
        //View Configuration
        } else if (section.equals("chatroomsOverview")) {        	        	        	    		
        	if(configurations.size() == 0) {        		
        		/*locale = LocaleUtil.fromLanguageId(LanguageUtil.getLanguageId(request));        		
        		String message = ResourceBundleHelper.getKeyLocalizedValue("com.rcs.admin.chatroom.overview.info", locale);
        		model.put("errorMessage", message);*/                
        		return new ModelAndView("chatroom/configuration", model);
        	}        	
			List<ChatRoom> chatRooms = ChatRoomLocalServiceUtil.getChatRooms(0, ChatRoomLocalServiceUtil.getChatRoomsCount());
			model.put("chatRooms", chatRooms);
        } 
        return new ModelAndView("chatroom/" + section, model);       
    }
	
	@ResourceMapping(value = "showChatRooms")
	public ModelAndView showChatRoomsController(ResourceRequest request,ResourceResponse response) throws PortalException, SystemException {
		Map<String, Object> model = new HashMap<String, Object>();				
		if(ConfigurationLocalServiceUtil.getConfigurationsCount() == 0) {
			return new ModelAndView("chatroom/configuration", model);
		}
		// get chat rooms
		try {			
			List<ChatRoom> chatRooms = ChatRoomLocalServiceUtil.getChatRooms(0, ChatRoomLocalServiceUtil.getChatRoomsCount());
			model.put("chatRooms", chatRooms);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		return new ModelAndView("chatroom/chatroomsOverview", model);
	}
	
	/**
	 * Save one configuration parameter
	 * @param configurationname
	 * @param configurationvalue
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResourceMapping(value = "editChatRoom")
    public ModelAndView editChatRoomController(
    		 String chatRoomId
             ,ResourceRequest request
            ,ResourceResponse response
    ) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();		
		// get user groups, organizations and sites
		try {
			List<Group> groups = GroupLocalServiceUtil.getGroups(0, GroupLocalServiceUtil.getGroupsCount());							
			model.put("userGroups", groups);
			if(StringUtils.hasText(chatRoomId)) {				
				// get selected groups
				ChatRoom chatRoom = ChatRoomLocalServiceUtil.getChatRoom(Long.parseLong(chatRoomId));
				model.put("chatRoom", chatRoom);
				
				List<ChatRoomGroup> chatRoomGroups = chatRoom.getChatRoomGroups();
				List<Group> selectedGroups = ChatRoomGroupLocalServiceUtil.getGroupsByChatRoomGroups(chatRoomGroups);
				model.put("selectedGroups", selectedGroups);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new ModelAndView("chatroom/edit", model);	
	}
	
	/**
	 * Save one configuration parameter
	 * @param configurationname
	 * @param configurationvalue
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResourceMapping(value = "saveChatRoom")
    public ModelAndView saveChatRoomController(
    		String chatRoomId
            ,String chatRoomName
            ,String chatRoomDescription
            ,String siteId
            ,String organizationId
            ,String userGroupId
            ,ResourceRequest request
            ,ResourceResponse response
    ) throws Exception {
		pII = utilsExpert.getPortalInstanceIdentifier(request);
		LocalResponse result = new LocalResponse();		
		String message = "";				
		locale = LocaleUtil.fromLanguageId(LanguageUtil.getLanguageId(request));
		ServiceActionResult<ChatRoom> resultupdate;
		// save chat room
		if(StringUtils.hasText(chatRoomId)) {
			resultupdate = chatRoomExpert.updateChatRoom(pII, Long.parseLong(chatRoomId), chatRoomName, chatRoomDescription);
			chatRoomGroupExpert.deleteChatRoomGroups(Long.parseLong(chatRoomId));
		} else {
			resultupdate = chatRoomExpert.addChatRoom(pII, chatRoomName, chatRoomDescription);
		}
        
        if (!resultupdate.isSuccess()) {        	
            result.setSuccess(false);             
            message = ResourceBundleHelper.getKeyLocalizedValue("com.rcs.admin.chatroom.saved.error", locale);
            result.setMessage(message);        
            response.getWriter().write(utilsExpert.getJsonFromLocalResponse(result));
            return null;
        }
        // save chat room groups        
        ChatRoom newChatRoom = resultupdate.getPayload();        
        if(StringUtils.hasText(siteId)) {
            List<String> siteIds = Arrays.asList(siteId.split("\\s*,\\s*"));
            log.error("siteIds.size()" + siteIds.size());
            for(String siteIdStr : siteIds) {    			
    			chatRoomGroupExpert.addChatRoomGroup(pII, newChatRoom.getChatRoomId(), Long.parseLong(siteIdStr), 1); //@@ set constant
    		}
        }
        if(StringUtils.hasText(organizationId)) {
        	List<String> organizationIds = Arrays.asList(organizationId.split("\\s*,\\s*"));
        	log.error("organizationIds.size()" + organizationIds.size());
        	for(String organizationIdStr : organizationIds) {
    			chatRoomGroupExpert.addChatRoomGroup(pII, newChatRoom.getChatRoomId(), Long.parseLong(organizationIdStr), 3); //@@ set constant
    		}
        }
        if(StringUtils.hasText(userGroupId)) {
        	List<String> userGroupIds = Arrays.asList(userGroupId.split("\\s*,\\s*"));
        	log.error("userGroupIds.size()" + userGroupIds.size());    		    	
    		for(String userGroupIdStr : userGroupIds) {
    			chatRoomGroupExpert.addChatRoomGroup(pII, newChatRoom.getChatRoomId(), Long.parseLong(userGroupIdStr), 0); //@@ set constant
    		}
        }		                                           
        result.setSuccess(true);        
        message = ResourceBundleHelper.getKeyLocalizedValue("com.rcs.admin.chatroom.saved.info", locale);        
        result.setMessage(message);        
        response.getWriter().write(utilsExpert.getJsonFromLocalResponse(result));
        return null;	
	}
	
	@ResourceMapping(value = "deleteChatRoom")
    public ModelAndView deleteChatRoomController(
             ResourceRequest request
            ,ResourceResponse response
    ) throws Exception {
		LocalResponse result = new LocalResponse();
		String message = "";
		String chatRoomId = request.getParameter("chatRoomId");		
		locale = LocaleUtil.fromLanguageId(LanguageUtil.getLanguageId(request));
		result = chatRoomGroupExpert.deleteChatRoomGroups(Long.parseLong(chatRoomId));
		
		boolean success = chatRoomExpert.deleteChatRoom(Long.parseLong(chatRoomId));
		if (success) {
			result.setSuccess(true);
			message = ResourceBundleHelper.getKeyLocalizedValue("com.rcs.admin.chatroom.deleted.info", locale);
			result.setMessage(message);
		} else {
			result.setSuccess(false);
			message = ResourceBundleHelper.getKeyLocalizedValue("com.rcs.admin.chatroom.deleted.error", locale);
			result.setMessage(message);
		}		
		response.getWriter().write(utilsExpert.getJsonFromLocalResponse(result));
		return null;	
	}
	
	@ResourceMapping(value = "saveConfiguration")
    public ModelAndView saveConfigurationController(
    		String apiKey
            ,String apiSecret                   //
            ,ResourceRequest request
            ,ResourceResponse response
    ) throws Exception {
		pII = utilsExpert.getPortalInstanceIdentifier(request);
		LocalResponse result = new LocalResponse();					
		locale = LocaleUtil.fromLanguageId(LanguageUtil.getLanguageId(request));
		String type = request.getParameter("type");			
		// save chat room		
		Configuration configuration = ConfigurationLocalServiceUtil.updateConfiguration(pII.getUserId(), apiKey, apiSecret, Integer.parseInt(type));                              
        result.setSuccess(true);        
        String message = ResourceBundleHelper.getKeyLocalizedValue("com.rcs.admin.configuration.saved.info", locale);            
        result.setMessage(message);        
        response.getWriter().write(utilsExpert.getJsonFromLocalResponse(result));
        return null;	
	}
}
