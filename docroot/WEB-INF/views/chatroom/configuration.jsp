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
<portlet:resourceURL var="saveConfigurationURL" id="saveConfiguration" />
<div class="yui3-widget aui-component aui-helpbox">
	<div class="portlet-description aui-helpbox-content" data-visible-panel="true">		
		<fmt:message key="com.rcs.admin.configuration.message"/>
	</div>
	<br/>
</div>
<form class="well" id="<portlet:namespace/>configurationform">
	<h3><fmt:message key="com.rcs.admin.configuration"/></h3>  
        
    <p>
        <label for="<portlet:namespace/>apiKey"><fmt:message key="com.rcs.admin.configuration.api.key"/>:</label>
        <input type="text" name="<portlet:namespace/>apiKey" class="required span6" id="<portlet:namespace/>apiKey" value="${apiKey}" />
    </p>
    <p>
        <label for="<portlet:namespace/>apiSecret"><fmt:message key="com.rcs.admin.configuration.api.secret"/>:</label>
        <input type="text" name="<portlet:namespace/>apiSecret" class="required span6" id="<portlet:namespace/>apiSecret" value="${apiSecret}" />
    </p>
    <p>
    	<label for="<portlet:namespace/>type-select"><fmt:message key="com.rcs.admin.configuration.key.type"/>:</label>
	    <select id="<portlet:namespace/>type-select" class="span2">
			<option id="test-server-option" <c:if test="${type == 0}" >selected="selected"</c:if> value="0"><fmt:message key="com.rcs.admin.configuration.test.server"/></option>
			<option id="production-server-option" <c:if test="${type == 1}" >selected="selected"</c:if> value="1"><fmt:message key="com.rcs.admin.configuration.production.server"/></option>						
		</select><i class="icon-info-sign" rel="tooltip" title="<fmt:message key="com.rcs.admin.configuration.select.info"/>" data-placement="right" trigger="hover"></i>
	</p>
    <p>
        <button type="button" class="btn" id="<portlet:namespace/>save-configuration" ><fmt:message key="com.rcs.admin.chat.room.save"/></button>       
    </p>
</form>


<script type="text/javascript">		

    jQuery(function() {
    	    
    	jQuery('i').tooltip();
    	<%--//Show messages or errors when the section is loaded--%>
    	<c:if test="${errorMessage != null && errorMessage != ''}" >showError('${errorMessage}');</c:if>
    	<c:if test="${infoMessage != null && infoMessage != ''}" >showInfo('${infoMessage}');</c:if>    	    
    	
        <%--//Handle SAVE Response--%>
        function saveHandleResponse(responseText, statusText, xhr, form) {  
        	//jQuery("#<portlet:namespace/>administration-container-mask").unmask();
        	console.log('${errorMessage}');
        	
        	var response = getResponseTextInfo(responseText);
            if (!response[0]) {
            	showError(response[1]);                           
            } else {
            	showInfo(response[1]);               
                //jQuery(".admin-right-menu li.disabled").removeClass("disabled");
                //jQuery("#<portlet:namespace/>save-configuration").attr("disabled", true);
                var responseBodyObj = jQuery.parseJSON(response[2]);                
            }
        }        
               
        <%--//Enable save when onchange
        jQuery(document).on("keypress", ".required", function() {
            jQuery("#<portlet:namespace/>save-configuration").attr("disabled", false); 
            jQuery("#<portlet:namespace/>save-configuration").show();
        });--%>
        
        
        
        <%--//Validation Options --%>
        jQuery("#<portlet:namespace/>configurationform").validate({
       	  rules: {
       		  '<portlet:namespace/>apiKey': {
	       	       required: true
	       	       ,digits: true
	       	       ,maxlength: 10
       		  }
       		  ,'<portlet:namespace/>apiSecret': {
	       	       required: true	       	      
      		  }
       	  }
       	});
        
        <%--//Configuration Form Button Listener--%> 
        jQuery("#<portlet:namespace/>save-configuration").click(function() {        	        
        	if(jQuery('#<portlet:namespace/>configurationform').valid()) {
        		var optionsSave = {
       	             url : '${saveConfigurationURL}'
       	             ,type : 'POST'
       	             ,data: {"type": jQuery("#<portlet:namespace/>type-select option:selected").attr('value')}
       	             ,success : saveHandleResponse             
       	         };
        		jQuery('#<portlet:namespace/>configurationform').ajaxSubmit(optionsSave);	
        	}
        	
            //if(jQuery('#<portlet:namespace/>configurationform').valid()) {
                //jQuery("#<portlet:namespace/>administration-container-mask").mask('<fmt:message key="com.rcs.general.mask.loading.text"/>');
                
            //}
        });
    });  
</script>