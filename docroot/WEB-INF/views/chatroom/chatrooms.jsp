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

<portlet:defineObjects />
<portlet:resourceURL var="showChatRoomsURL" id="showChatRooms" />
<portlet:resourceURL var="adminSectionsURL" id="adminSections" />

<div id="<portlet:namespace/>main-container">	
	<div class="span12 admin-left-container">
	    <%@include file="topMessages.jsp" %>
	    <div id="<portlet:namespace/>chat-rooms" ></div>
	</div>
	<div class="span2 admin-right-menu">
	    <%@include file="rightMenu.jsp" %>
	</div>    
</div>
<script type="text/javascript">

Liferay.on('portletReady', function(event) {
	
    if('_' + event.portletId + '_' == '<portlet:namespace/>') {    	
    	
    	<%--//Load Boundle Messages for JS--%>    	
     	namespace = '<portlet:namespace/>';
     	
    	<%--//Show messages or errors when the section is loaded--%>
    	<c:if test="${errorMessage != null && errorMessage != ''}" >showError('${errorMessage}');</c:if>
    	<c:if test="${infoMessage != null && infoMessage != ''}" >showInfo('${infoMessage}');</c:if>
    	
    	<%--//Handle SAVE Response--%>
        function saveHandleResponse(responseText, statusText, xhr, form) {  
        	//jQuery("#<portlet:namespace/>administration-container-mask").unmask();
        	var response = getResponseTextInfo(responseText);
            if (!response[0]) {
            	showError(response[1]);                           
            } else {
            	showInfo(response[1]);               
                //jQuery(".admin-right-menu li.disabled").removeClass("disabled");
                //jQuery("#<portlet:namespace/>save-configuration").attr("disabled", true);
                var responseBodyObj = jQuery.parseJSON(response[2]);
                console.log(responseBodyObj);
            }
        }
        
    	jQuery("#<portlet:namespace/>chat-rooms").load("${adminSectionsURL}"
             ,{
                 "section" : "chatroomsOverview"
             },saveHandleResponse
         );
    	
    	
    	/*jQuery("#<portlet:namespace/>chat-rooms").load("${showChatRoomsURL}"
             ,function() {                 
                 console.log("it worked");
             }
         );*/
    	
    	<%--//Load the first section (Account)--%>
        jQuery(function () {
            jQuery('a[data-toggle="tab"]:first').tab('show');
        });
                
        <%--//Actions to perform when change section --%>
        jQuery('a[data-toggle="tab"]').click(function () {
            //jQuery("#<portlet:namespace/>administration-container-mask").mask('<fmt:message key="com.rcs.general.mask.loading.text"/>');
            ///jQuery(".alert").hide();
            console.log("change section");
            jQuery(".alert-success").hide();
            jQuery(".alert-error").hide();
            var link = jQuery(this).attr("href").replace("#","");                
            //jQuery(".toHide").addClass("hidden");
            //jQuery("#<portlet:namespace/>" + jQuery(this).attr("rel")).addClass("toHide").removeClass("hidden");                
            jQuery("#<portlet:namespace/>chat-rooms").load("${adminSectionsURL}"
                ,{
                    "section" : link
                },function() {
                    //jQuery("#<portlet:namespace/>administration-container-mask").unmask();
                }
            );
        });
    }
});	 
</script>