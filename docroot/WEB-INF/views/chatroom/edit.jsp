<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<%@taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@taglib prefix="theme" uri="http://liferay.com/tld/theme" %>
<%@taglib prefix="liferay-util" uri="http://liferay.com/tld/util" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setBundle basename="Language"/>
<portlet:defineObjects />
<portlet:resourceURL var="saveChatRoomURL" id="saveChatRoom" />
<portlet:resourceURL var="showChatRoomsURL" id="showChatRooms" />
<portlet:resourceURL var="adminSectionsURL" id="adminSections" />
<div class="yui3-widget aui-component aui-helpbox">
	<div class="portlet-description aui-helpbox-content" data-visible-panel="true">		
		<fmt:message key="com.rcs.admin.chat.room.edit.message"/> 
	</div>
</div>
<br />
<form class="well" id="<portlet:namespace/>chat-room-form">
	<h3><fmt:message key="com.rcs.admin.chat.room"/> <i id="chat-room-info" class="icon-question-sign" rel="tooltip" title="<fmt:message key="com.rcs.admin.chat.room.info"/>" data-placement="right" trigger="hover"></i> </h3>	 
    <input type="hidden" name="chatRoomId" value="${chatRoom.chatRoomId}"/>    
    <p>
        <label for="<portlet:namespace/>chat-room-name"><fmt:message key="com.rcs.admin.chat.room.name"/>:*</label>
        <input type="text" name="<portlet:namespace/>chatRoomName" class="required span3" id="<portlet:namespace/>chat-room-name" value="${chatRoom.name}"/>
    </p>
    <p>
        <label for="<portlet:namespace/>chat-room-description"><fmt:message key="com.rcs.admin.chat.room.description"/>:*</label>
        <input type="text" name="<portlet:namespace/>chatRoomDescription" class="required span6" id="<portlet:namespace/>chat-room-description" value="${chatRoom.description}"/>
    </p>
    <p>
	    <div class="controls">
		    <label for="<portlet:namespace/>site-id"><fmt:message key="com.rcs.admin.chat.room.site.optional"/>: <i id="chat-room-info" class="icon-question-sign" rel="tooltip" title="<fmt:message key="com.rcs.admin.site.info"/>" data-placement="right" trigger="hover"></i></label>
			<select id="<portlet:namespace/>site-id" multiple="multiple" name="<portlet:namespace/>siteId">				
				<c:forEach items="${userGroups}" var="site">
					<c:if test="${(site.isSite() || site.isRegularSite()) && (!site.isControlPanel() && !site.isGuest())}" >
						<option value="${site.groupId}" ${selectedGroups.contains(site) ? "selected" : ""}>${site.descriptiveName}</option>
            		</c:if>			            			
				</c:forEach>				
			</select>
		</div>
	</p>
    <p>
	    <div class="controls">
		    <label for="<portlet:namespace/>organization-id"><fmt:message key="com.rcs.admin.chat.room.organization.optional"/>: <i id="chat-room-info" class="icon-question-sign" rel="tooltip" title="<fmt:message key="com.rcs.admin.organization.info"/>" data-placement="right" trigger="hover"></i></label>
			<select id="<portlet:namespace/>organization-id" multiple="multiple" name="<portlet:namespace/>organizationId">				
				<c:forEach items="${userGroups}" var="organization">
					<c:if test="${organization.isOrganization()}" >
						<option value="${organization.groupId}" ${selectedGroups.contains(organization) ? "selected" : ""}>${organization.descriptiveName}</option>
					</c:if>
				</c:forEach>				
			</select>
		</div>
	</p>
    <p>
	    <div class="controls">
		    <label for="<portlet:namespace/>user-group-id"><fmt:message key="com.rcs.admin.chat.room.user.group.optional"/>: <i id="chat-room-info" class="icon-question-sign" rel="tooltip" title="<fmt:message key="com.rcs.admin.user.group.info"/>" data-placement="right" trigger="hover"></i></label>
			<select id="<portlet:namespace/>user-group-id" multiple="multiple" name="<portlet:namespace/>userGroupId">				
				<c:forEach items="${userGroups}" var="userGroup">
					<c:if test="${userGroup.isUserGroup()}" >
						<option value="${userGroup.groupId}" ${selectedGroups.contains(userGroup) ? "selected" : ""}>${userGroup.descriptiveName}</option>
					</c:if>
				</c:forEach>				
			</select>
		</div>
	</p>
    <p>
        <button type="button" class="btn" id="<portlet:namespace/>save-chat-room" ><fmt:message key="com.rcs.admin.chat.room.save"/></button>
        <button type="button" class="btn" id="<portlet:namespace/>cancel-chat-room" style="margin-left:10px;"><fmt:message key="com.rcs.admin.chat.room.cancel"/></button>       
    </p>
</form>
<script type="text/javascript">
function loadChatRooms() {
	jQuery("#<portlet:namespace/>chat-rooms").load("${adminSectionsURL}"
         ,{
             "section" : "chatroomsOverview"
         },function() {
             //jQuery("#<portlet:namespace/>administration-container-mask").unmask();
         }
     );
}
	
	jQuery(function() {
		
		jQuery('i').tooltip();
		
		<%--//Validation Options --%>
        jQuery("#<portlet:namespace/>chat-room-form").validate({
       	  rules: {
       		  '<portlet:namespace/>chat-room-name': {
	       	       required: true	       	       
	       	       ,maxlength: 100
       		  }
       		  ,'<portlet:namespace/>chat-room-description': {
	       	       required: true
	       	       ,maxlength: 255
      		  }
       	  }
       	});
        
		<%--//Handle SAVE Response--%>
		function saveHandleResponse(responseText, statusText, xhr, form) {
			console.log('${errorMessage}');        	
        	var response = getResponseTextInfo(responseText);
            if (!response[0]) {
            	showError(response[1]);                           
            } else {
            	showInfo(response[1]);                               
                var responseBodyObj = jQuery.parseJSON(response[2]);
                loadChatRooms();
            }					    	           
		}
		
		<%--//Form Options for Save Button --%>	
		var optionsSave = {
		    url : '${saveChatRoomURL}'
		    ,type : 'POST'
		    ,success : saveHandleResponse
		};
    
		<%--//Chat Room Form Button Listener --%>
        jQuery("#<portlet:namespace/>save-chat-room").click(function() {
        	console.log("onClick");            
            if(jQuery('#<portlet:namespace/>chat-room-form').valid()) {                
                jQuery('#<portlet:namespace/>chat-room-form').ajaxSubmit(optionsSave);               
            }
        });
        
        jQuery("#<portlet:namespace/>cancel-chat-room").click(function() {
        	loadChatRooms();
        });
        
});
</script>   
