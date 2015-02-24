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
<portlet:resourceURL var="editChatRoomURL" id="editChatRoom" />
<portlet:resourceURL var="deleteChatRoomURL" id="deleteChatRoom" />
<portlet:resourceURL var="showChatRoomsURL" id="showChatRooms" />
<portlet:resourceURL var="adminSectionsURL" id="adminSections" />
<div id="chat-rooms-overview-help-content" class="yui3-widget component helpbox">
	<div class="portlet-description helpbox-content" data-visible-panel="true">		
		<fmt:message key="com.rcs.admin.chat.rooms.overview.message"/>
	</div>
	<br/>
</div>
<h3><fmt:message key="com.rcs.admin.chat.rooms.overview"/></h3>
<a class="btn btn-success" href="#" id="<portlet:namespace/>addChatRoom"><fmt:message key="com.rcs.admin.add"/></a>
<div id="viewChatRooms" style="padding-top:10px;">	
	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th><fmt:message key="com.rcs.admin.chat.room.name"/></th>
				<th><fmt:message key="com.rcs.admin.chat.room.description"/></th>				
				<th><fmt:message key="com.rcs.admin.chat.room.creation.date"/></th>				
				<th><fmt:message key="com.rcs.admin.chat.room.groups"/></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${chatRooms}" var="chatRoom">
				<tr>
					<td>${chatRoom.name}</td>
					<td>${chatRoom.description}</td>					
					<td>${chatRoom.createDate}</td>
					<td>
						<c:forEach items="${chatRoom.chatRoomGroups}" var="chatRoomGroup" varStatus="rowCounter">						
							${chatRoomGroup.group.descriptiveName}<c:if test="${rowCounter.count != chatRoom.chatRoomGroups.size()}">,</c:if> 							            				
						</c:forEach>
					</td>
					<td><button class="btn btn-primary" type="button" rel="${chatRoom.chatRoomId}"><fmt:message key="com.rcs.admin.chat.room.edit"/></button><button class="btn btn-danger" type="button" rel="${chatRoom.chatRoomId}" style="margin-left:5px;"><fmt:message key="com.rcs.admin.chat.room.delete"/></button></td>					
				</tr>
			</c:forEach>				
		</tbody>
	</table>
</div>

<%--
    Dialogs
    ##################
--%>
<div style="display:none">
    <div id="delete-dialog<portlet:namespace/>" title="<fmt:message key="com.rcs.admin.chatroom.confirm.delete.chatroom.title"/>">
        <fmt:message key="com.rcs.admin.chatroom.confirm.delete.chatroom.body"/>
    </div>
</div>

<script type="text/javascript">

function loadChatRooms() {
	jQuery("#<portlet:namespace/>chat-rooms").load("${adminSectionsURL}"
         ,{
             "section" : "chatroomsOverview"
         }
     );
}

jQuery(document).ready(function() {
	
    //  confirm delete dialog
    jQuery("#delete-dialog<portlet:namespace/>").dialog({
        autoOpen: false,
        modal: true
    });
	
	<c:if test="${chatRooms.size() == 0}" >jQuery('#chat-rooms-overview-help-content').show();</c:if>
	<c:if test="${chatRooms.size() != 0}" >jQuery('#chat-rooms-overview-help-content').hide();</c:if>
	
	jQuery("#<portlet:namespace/>addChatRoom").click(function() {		
		jQuery(".alert-success").hide();
        jQuery(".alert-error").hide();
		jQuery("#<portlet:namespace/>chat-rooms").load("${editChatRoomURL}");
	});
	
	function deleteHandleResponse(responseText, statusText, xhr, form) {
    	var response = getResponseTextInfo(responseText);
        if (!response[0]) {
        	showError(response[1]);                           
        } else {
        	showInfo(response[1]);                               
            var responseBodyObj = jQuery.parseJSON(response[2]);
            loadChatRooms();
        }					
	}
	
	jQuery(".btn-danger").click(function(e){
		e.preventDefault();
		jQuery(".alert-success").hide();
        jQuery(".alert-error").hide();
		var chatRoomId = jQuery(this).attr("rel");

        jQuery("#delete-dialog<portlet:namespace/>").dialog({
            autoOpen: false,
            modal: true,
            buttons : {
                "<fmt:message key="com.rcs.admin.chatroom.confirm.button.yes"/>" : function() {
                    jQuery.ajax({
                        url: '${deleteChatRoomURL}'
                        ,type: 'POST'
                        ,data: {chatRoomId: chatRoomId}
            		    ,success : deleteHandleResponse
                        ,failure: function(response){
                            $(this).dialog("close");
                        }
                    });
                    $(this).dialog("close");
                },
                "<fmt:message key="com.rcs.admin.chatroom.confirm.button.cancel" />" : function() {
                    $(this).dialog("close");
                }
            }
        });
        jQuery("#delete-dialog<portlet:namespace/>").dialog("open");		

	});
	
	jQuery(".btn-primary").click(function(e){
		e.preventDefault();
		jQuery(".alert-success").hide();
        jQuery(".alert-error").hide();
		var chatRoomId = jQuery(this).attr("rel");
		jQuery("#<portlet:namespace/>chat-rooms").load(
			"${editChatRoomURL}",{"chatRoomId": chatRoomId}	
		);
	});

});	
  
</script>
