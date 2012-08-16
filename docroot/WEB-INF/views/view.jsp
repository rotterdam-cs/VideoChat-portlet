<%@page contentType="text/html" pageEncoding="UTF-8" import="com.liferay.portal.util.PortalUtil" import="com.rcs.service.service.ConfigurationLocalServiceUtil" import ="com.rcs.service.model.ChatRoom"%>
<%@taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<%@taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setBundle basename="Language"/>
<portlet:defineObjects />
<portlet:resourceURL var="getTokenURL" id="getToken" />
<c:if test="${isTestServer}">
	<script src="https://staging.tokbox.com/v0.91/js/TB.min.js" ></script>
</c:if>
<c:if test="${! isTestServer}">
	<script src="https://swww.tokbox.com/v0.91/js/TB.min.js" ></script>
</c:if>   
<div id="main-div">
	<div id="error-message" class="alert alert-block alert-error fade in" style="display:none;"></div>	
	<div id="connect-to-chat-room-div">
		<div class="btn-group">
		    <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#">
		    	<fmt:message key="com.rcs.videochat.select.chat.room"/>
		    	<span class="caret"></span>
		    </a>
		    <ul class="dropdown-menu">
		    	<c:forEach var="chatRoom"  items="${chatRooms}">
		    		<li>
						<a href="#" rel="${chatRoom.sessionId}" class="chat-room-link">${chatRoom.name}</a>
					</li>	
		    	</c:forEach>	    			
		    </ul>		    
	    </div>
	   	<label class="checkbox" style="padding-top:10px;">
			<input id="show-video-checkbox" type="checkbox" checked> <fmt:message key="com.rcs.videochat.show.video.streamings"/>
		</label>
	</div>
	<div id="chat-room-div" style="display:none;">
		<div id="main-container-div" class="container-fluid" style="min-height:100px;">
			<div class="row-fluid">
				<div class="span2" style="min-width:230px; padding-right:20px;" id="leftDiv">
    				<ul id="usersDiv" class="nav nav-list">
	    				<li class="nav-header">${userFirstName}</li>
	    				<li>
							<a id="disconnect-link" href="#">
								<i class="icon-off"></i>
								<fmt:message key="com.rcs.videochat.disconnect"/>
							</a>
						</li>
						<li>
							<div id="publisher-div"></div>
						</li>
						<li id="users-title-li" class="nav-header" style="display:none;"><fmt:message key="com.rcs.videochat.users"/> <i class="icon-info-sign" rel="tooltip" title="<fmt:message key="com.rcs.videochat.camera.icon"/>" data-placement="right" trigger="hover"></i></li>						
	    			</ul>	    				    		
	    		</div>
	    		<div class="span5">	    			    	
		    		<div id="subscribers-div">		    			
		    			<select id="video-chat-mode-select" class="span2">
							<option id="group-chat-option" selected="selected"><fmt:message key="com.rcs.videochat.group.chat"/></option>
							<option id="presentation-option"><fmt:message key="com.rcs.videochat.presentation"/></option>						
						</select><i class="icon-info-sign" rel="tooltip" title="<fmt:message key="com.rcs.videochat.chat.mode.info"/>" data-placement="right" trigger="hover"></i>						
						<div id="message-div" class="alert alert-success fade in" style="display:none;"></div>    			    					  					 
					  	<ul id="list1" class="thumbnails presenter">						  
					  	</ul>	  
				  	</div>	    		
	    		</div>
	    	</div>
		</div>
	</div>
</div>
<input name="list1SortOrder" type="hidden" />
<script type="text/javascript">	
	
	var apiKey = '${apiKey}';
		var sessionId = '';
		var token = '';
		var publisher;   	
	TB.setLogLevel(TB.ERROR);    
	var globalStreams = new Object();	
	         
	var session;
	var usersChecked = new Object();
	var automaticallyShowVideo = false;
	var publisherWidth = 132;
	var publisherHeight = 99;
	var videoSmallWidth = 140;
	var videoSmallHeight = 97;
	var videoBigWidth = 460;
	var videoBigHeight = 317;
	var isUserPublishing = false;
	
	function checkUsersInChatroom() {		
		if(jQuery('#usersDiv').children().size() < 5) {
			jQuery('#message-div').html('<fmt:message key="com.rcs.videochat.users.video.info"/>');
			jQuery('#message-div').show();
			jQuery('#users-title-li').hide();	   				
		}
	}
	
	Liferay.on('portletReady', function(event) {
   		if('_' + event.portletId + '_' == '<portlet:namespace/>') {
   			
   			<c:if test="${errorMessage != null && errorMessage != ''}" >
   				jQuery('#error-message').html('${errorMessage}');
   				jQuery('#error-message').show();
   				jQuery('#connect-to-chat-room-div').hide();
   			</c:if>
   			
   			jQuery("#disconnect-link").click(function(e){
   				e.preventDefault();
   				disconnect();
   			});
   			
   			jQuery(".chat-room-link").click(function(e){
   				e.preventDefault();
   				var chosenSessionId = jQuery(this).attr("rel");
   				goToChatRoom(chosenSessionId);
   			});
   			
   			jQuery('i').tooltip();
   			
   			jQuery("#video-chat-mode-select").change(function () {   				   			
 				setVideoChatMode(jQuery(this).find(":selected").attr('id') == 'group-chat-option');   				   					     
  			}).trigger('change');   			   		
   			
   			jQuery(document).on('click', '.user-link', function(e) {   				
   				e.preventDefault();   				   			
   				var userId = jQuery(this).attr("rel");
   				var stream = globalStreams[userId];
   				var userId = getJSONProp(stream.connection.data, 'userId');
   				if(jQuery('#i' + userId).hasClass("icon-grey")) {   					
   					unsubscribe(userId);
   					jQuery('#i' + userId).removeClass('icon-grey');
   				} else {
   					subscribe(userId);
   					jQuery('#i' + userId).addClass('icon-grey');
   				}
   			});
  		}
	});	
	
  	// get a JSON property from a JSON string
  	function getJSONProp(json, prop) {
  		var obj = jQuery.parseJSON(json);
		return obj[prop];
  	}
  	
  	/* set the chat mode layout: group chat or presentation,
  	 * the group chat mode has all the videos with the same size,
  	 * the presentation mode has one video larger and the other
  	 * small with the same size */
    function setVideoChatMode(isGroupChatMode) {
    	var liFirstElement = jQuery('#list1').children(":first");
    	var divContainer = liFirstElement.children(":first");
		if(isGroupChatMode) {
	    	liFirstElement.removeClass('speaker');
	    	liFirstElement.addClass('video-small');
	    	divContainer.removeClass('speaker');
	    	divContainer.addClass('video-small');
	    	divContainer.children(":first").width(videoSmallWidth);
	    	divContainer.children(":first").height(videoSmallHeight);
		} else {				
	    	liFirstElement.removeClass('video-small');
	    	liFirstElement.addClass('speaker');
	    	divContainer.removeClass('video-small');
	    	divContainer.addClass('speaker');
	    	liFirstElement.children(":first").children(":first").width(videoBigWidth);
			liFirstElement.children(":first").children(":first").height(videoBigHeight);
		}

    }
   
  	/* connect to the opentok session */
	function connectToSession() {    	
	   	jQuery("#main-div").mask('<fmt:message key="com.rcs.videochat.loading"/>');	   	
		session = TB.initSession(sessionId);	   	
	   	// add listener when the session is connected
	   	session.addEventListener('sessionConnected', sessionConnectedHandler);
	   	/* add listener when the stream is created 
	   	 * (after the user starts streaming to the session) */
    	session.addEventListener('streamCreated', streamCreatedHandler);
	   	/* add listener when the user stops streaming */
	    session.addEventListener('streamDestroyed', streamDestroyedHandler);
	   	/* Just in case an exception occurs. */
	    TB.addEventListener('exception', exceptionHandler);
	    /* add user properties to the opentok connection,
	     * to know the firstname, lastname, email, userid */
	    var sessionConnectProperties = new Object();
	    sessionConnectProperties.connectionData = '${userData}';	    
	    session.connect(apiKey, token, sessionConnectProperties);	    
    }   
  	
	// subscribe to a user video
	function subscribe(userId) {    		        
	   	// Subscribe to the stream    		   	
	    var stream = globalStreams[userId];
	    var userId = getJSONProp(stream.connection.data, "userId");	   	   	   		   	   		
   		var userStreamDivId = 'stream' + stream.streamId;
   		var userVideoHTML = '<li id="li'+stream.streamId+'">' + 
								'<div id="containerDiv'+ stream.streamId +'" class="thumbnail video-small">' +
									'<div id="' + userStreamDivId + '" />' +
								'</div>' +
								'<span class="user">' + getJSONProp(stream.connection.data, "firstName"); + '</span>' +
							'</li>';
		jQuery('#list1').append(userVideoHTML);
   					
   		var divProps = {width: videoSmallWidth, height:videoSmallHeight};
   		session.subscribe(stream, userStreamDivId, divProps);   		
   		usersChecked[userId] = true;
   		var isFirstElementInPresenterMode = (jQuery('#video-chat-mode-select').find(":selected").attr('id') == 'presentation-option') && (('li'+stream.streamId) == jQuery('#list1').children(":first").attr('id'));
   		if(isFirstElementInPresenterMode) {
    		setVideoChatMode(false);
    	}
	}
   
	// unsubscribe from a user video
	function unsubscribe(userId) {    	
	        
	   	// unsubscribe from the stream    		   	
	    var stream = globalStreams[userId];
	    var userId = getJSONProp(stream.connection.data, "userId");
	   	if(usersChecked[userId] && usersChecked[userId] == true) {
	   		// unsubscribe from user	   		   		    	   		   	
	   		var isFirstElementInPresenterMode = (jQuery('#video-chat-mode-select').find(":selected").attr('id') == 'presentation-option') && (('li'+stream.streamId) == jQuery('#list1').children(":first").attr('id'));
	   		session.unsubscribe(stream);
	   		jQuery('#li'+stream.streamId).remove();	   		
	    	if(isFirstElementInPresenterMode) {
	    		setVideoChatMode(false);
	    	}   		   		   	
	    	usersChecked[userId] = false;
	   	}   	   
	}
	
	/* add users in a list */
	function listUsersConnected(streams) {   	   	
	   	for (var i = 0; i < streams.length; i++) {
	   		var stream = streams[i];
	   		if (stream.connection.connectionId != session.connection.connectionId) {
	   			if(isUserPublishing) {
	   				jQuery('#subscribers-div').css('margin-left','0px');	
	   			} else {
	   				jQuery('#subscribers-div').css('margin-left','50px');
	   			}	
	   			jQuery('#users-title-li').show();
	   			var data = stream.connection.data;
	   			var userId = getJSONProp(data, "userId");
	   			globalStreams[userId] = stream;	   				   		
	   			var userHTML = '<li id="li'+userId+'">' + 									
									'<a id="a' + userId + '" href="#" rel="'+userId+'" class="user-link">' +
										'<i id="i' + userId + '" class="icon-facetime-video"></i>' +
											getJSONProp(data, "firstName") + " " + getJSONProp(data, "lastName") +
									'</a>' +									
								'</li>';			
				jQuery('#usersDiv').append(userHTML);
				if(usersChecked[userId] || automaticallyShowVideo) {
   					jQuery('#i' + userId).addClass('icon-grey');
					// so the user gets subscribed
       			    usersChecked[userId] = false;
       			 	subscribe(userId);
   				}
				jQuery('#message-div').hide();				
	   		} else {
	   			isUserPublishing = true;
	   			jQuery('#subscribers-div').css('margin-left','0px');
	   			checkUsersInChatroom();	   			 
	   		}
	   	}    	
	}
    
	function disconnect() {	   	
	   	jQuery('#chat-room-div').attr('style','display:none;');
	   	jQuery('#connect-to-chat-room-div').attr('style','');
	   	for(var userId in globalStreams) {   		
	   		var stream = globalStreams[userId];	   		
	   		jQuery('#li'+userId).remove();
	   		jQuery('#li'+stream.streamId).remove(); 	   		
	   	}
	   	session.cleanup();
	    session.disconnect();    
   	}
   
   	function sessionConnectedHandler(event) {              
       if(jQuery('#publisher')) {
    	   jQuery('#publisher').remove();
       }
       
       jQuery('#publisher-div').html('<div id="publisher" ></div>');
       jQuery('#leftDiv').attr('style','display:""');
       jQuery('#subscribers-div').attr('style','display:""');
       
       publisher = session.publish('publisher', {wmode: "window", width: publisherWidth, height: publisherHeight});       
       //publisher = session.publish('publisher', {width: publisherWidth, height: publisherHeight});
       jQuery("#main-div").unmask();
            
       listUsersConnected(event.streams);       
   	}
    
	function streamCreatedHandler(event) {		
   		listUsersConnected(event.streams);
    }    	
   
	function exceptionHandler(event) {					
		jQuery("#main-div").unmask();
		jQuery('#chat-room-div').hide();
		jQuery('#connect-to-chat-room-div').hide();
		jQuery('#error-message').html('<fmt:message key="com.rcs.videochat.error"/> ' + event.code + ': <fmt:message key="com.rcs.videochat.error.message"/>');
		jQuery('#error-message').show();					
	}
	function streamDestroyedHandler(event) {    	
   		for (var i = 0; i < event.streams.length; i++) {
           var stream = event.streams[i];           
           if(stream) {
	            if (stream.connection.connectionId != session.connection.connectionId) {
	            	var userId = getJSONProp(stream.connection.data, 'userId');
	            	var isFirstElementInPresenterMode = (jQuery('#video-chat-mode-select').find(":selected").attr('id') == 'presentation-option') && (('li'+stream.streamId) == jQuery('#list1').children(":first").attr('id'));            	
	            	jQuery('#li'+userId).remove();
	            	jQuery('#li'+stream.streamId).remove();            	
	            	if(isFirstElementInPresenterMode) {
	            		setVideoChatMode(false);
	            	}
	            	try {
	            		session.unsubscribe(stream);	
	            	} catch(e) {
	            		// go on
	            	}
	            	checkUsersInChatroom();
	            } else {
	            	isUserPublishing = false;
	            	jQuery('#publisher-div').html('<div id="publisher" />');            			       
			        publisher = session.publish('publisher', {wmode: "window", width: publisherWidth, height: publisherHeight});	            	
	            }
			}           
       	}   	
	}
	
	jQuery("#list1").dragsort({ dragEnd: updatePresenterMode});
	function updatePresenterMode() {		
		if((jQuery('#video-chat-mode-select').find(":selected").attr('id') == 'presentation-option')) {
			$('li').removeClass('speaker');					
			$('li').children().each(function(i) {
				if($(this).hasClass('speaker')) {					
					$(this).children(":first").width(videoSmallWidth);
					$(this).children(":first").height(videoSmallHeight);
					$(this).removeClass('speaker');
					$(this).addClass('video-small');
				}
			});
			
			var liFirstElement = $('#list1').children(":first");		
			liFirstElement.children(":first").removeClass("video-small");
			liFirstElement.children(":first").addClass("speaker");		
			liFirstElement.addClass("speaker");
					
			liFirstElement.children(":first").children(":first").width(videoBigWidth);
			liFirstElement.children(":first").children(":first").height(videoBigHeight);
						
		}			
	};
	
	function connectToChatRoom(data) {		
		var response = getResponseTextInfo(data);		
		token = response[1];		
		connectToSession();
		jQuery('#connect-to-chat-room-div').attr('style','display:none;');
		jQuery('#chat-room-div').attr('style','');
	}
	
	function goToChatRoom(chosenSessionId) {		
		sessionId = chosenSessionId;		
		automaticallyShowVideo = $('#show-video-checkbox').is(':checked');
		jQuery.ajax({
			url: "${getTokenURL}"
			,data: {"sessionId": sessionId}
			,success: function(data) {
				connectToChatRoom(data);
			}
		});		
	};	
	
	
</script>   	