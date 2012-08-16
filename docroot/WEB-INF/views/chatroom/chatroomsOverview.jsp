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
<div id="chat-rooms-overview-help-content" class="yui3-widget aui-component aui-helpbox">
	<div class="portlet-description aui-helpbox-content" data-visible-panel="true">		
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

<script type="text/javascript">

jQuery(function() {
	<c:if test="${chatRooms.size() == 0}" >jQuery('#chat-rooms-overview-help-content').show();</c:if>
	<c:if test="${chatRooms.size() != 0}" >jQuery('#chat-rooms-overview-help-content').hide();</c:if>
	
	jQuery("#<portlet:namespace/>addChatRoom").click(function() {		
		jQuery(".alert-success").hide();
        jQuery(".alert-error").hide();
		jQuery("#<portlet:namespace/>chat-rooms").load("${editChatRoomURL}");
	});
	
	function deleteHandleResponse() {
		jQuery("#<portlet:namespace/>chat-rooms").load("${showChatRoomsURL}");
	}
	
	jQuery(".btn-danger").click(function(e){
		e.preventDefault();
		jQuery(".alert-success").hide();
        jQuery(".alert-error").hide();
		var chatRoomId = jQuery(this).attr("rel");
		 
		jQuery.ajax({
			url: "${deleteChatRoomURL}"
			,data: {chatRoomId: chatRoomId}
			,success: function() {
				deleteHandleResponse();
			}
		});
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