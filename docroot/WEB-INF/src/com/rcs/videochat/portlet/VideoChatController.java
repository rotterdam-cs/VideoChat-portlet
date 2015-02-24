package com.rcs.videochat.portlet;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.opentok.OpenTok;
import com.opentok.Role;
import com.opentok.TokenOptions;
import com.rcs.common.LocalResponse;
import com.rcs.common.ResourceBundleHelper;
import com.rcs.common.UserData;
import com.rcs.expert.UtilsExpert;
import com.rcs.service.model.ChatRoom;
import com.rcs.service.service.ChatRoomLocalServiceUtil;
import com.rcs.service.service.ConfigurationLocalServiceUtil;


@Controller(value="VideoChatController") 
@RequestMapping("VIEW")
public class VideoChatController {
	private static Log log = LogFactoryUtil.getLog(VideoChatController.class);	
	private Locale locale;
	
	private UtilsExpert utilsExpert = new UtilsExpert();
	
	@RenderMapping
	public ModelAndView resolveView(PortletRequest request, PortletResponse response) throws PortalException, SystemException {		
		
		// sessionId, chatRoomName
		Map<String, Object> model = new HashMap<String, Object>();
		try {							
			User user = PortalUtil.getUser(request);
			
			if(user == null) {
				locale = LocaleUtil.fromLanguageId(LanguageUtil.getLanguageId(request));
				String message = ResourceBundleHelper.getKeyLocalizedValue("com.rcs.videochat.login.error", locale);
				model.put("errorMessage", message);
				model.put("errorCode", "1");
				return new ModelAndView("view", model);
			}
						
			List<ChatRoom> chatRooms = ChatRoomLocalServiceUtil.getChatRoomsForUser(user.getUserId());
			
			if(chatRooms.size() == 0) {
				locale = LocaleUtil.fromLanguageId(LanguageUtil.getLanguageId(request));
				String message = ResourceBundleHelper.getKeyLocalizedValue("com.rcs.videochat.no.chatroom.error", locale);
				model.put("errorMessage", message);
				model.put("errorCode", "1");
				return new ModelAndView("view", model);
			}
			model.put("chatRooms", chatRooms);
			model.put("apiKey", ConfigurationLocalServiceUtil.getApiKey());
			model.put("isTestServer", ConfigurationLocalServiceUtil.isTestServer());			
			
			UserData userData = new UserData();	        
	        if(user!=null) {	        		        
				userData.setUserId(user.getUserId());
				userData.setEmail(user.getEmailAddress());
				userData.setFirstName(user.getFirstName());
				userData.setLastName(user.getLastName());
	        }
	        Gson gson = new Gson();
	        String userDataJSON = gson.toJson(userData);	        
	        model.put("userData", userDataJSON);
	        model.put("userFirstName", user.getFirstName());
		} catch (Exception e) {
			log.error(e.getMessage());
		}  		
		return new ModelAndView("view", model);
	}
	
	@ResourceMapping(value = "getToken")
    public ModelAndView getTokenController(
    		String sessionId
    		,ResourceRequest request
            ,ResourceResponse response
    ) throws Exception {
		LocalResponse result = new LocalResponse();
				
		// Generate a token. The user needs a token to be able to connect to the chatroom.		
		OpenTok opentok = new OpenTok(Integer.parseInt(ConfigurationLocalServiceUtil.getApiKey()), ConfigurationLocalServiceUtil.getApiSecret());
		User user = PortalUtil.getUser(request);
        String userEmail = "";
        if(user!=null) {
        	userEmail = PortalUtil.getUser(request).getEmailAddress();
        }	        
        String connectionMetadata = userEmail;


        // Generate a token:
        TokenOptions options = new com.opentok.TokenOptions.Builder().role(Role.PUBLISHER).data(connectionMetadata).build();        
        
        
        
		// Use the RoleConstants value appropriate for the user.
		String token = opentok.generateToken(sessionId,options);
		result.setSuccess(true);
		result.setMessage(token);        
        response.getWriter().write(utilsExpert.getJsonFromLocalResponse(result));        
		return null;
	}
}
