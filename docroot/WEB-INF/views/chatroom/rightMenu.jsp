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
<style type="text/css">
.nav-list-color {
    background-color: #D7F1FF;
    border: 1px solid #88C5D9;    
}
</style>
<ul class="nav nav-list nav-list-color"> 
	<%--//The "href" should start with # and the section should be the enum used in the controller --%>
	<%--//The "rel" should be the same "id" for the corresponding span in header.jsp --%>  
	<%--//The <li> could have the class "disabled" --%>                    
    <li>
        <a id="configuration" href="#chatroomsOverview" data-toggle="tab" rel="admin-menu-configuration">
            <i class="icon-comment"></i> <fmt:message key="com.rcs.admin.chat.rooms"/>                            
        </a>
    </li>

    <li>
        <a href="#configuration" data-toggle="tab" rel="admin-menu-analytics">
            <i class="icon-wrench"></i> <fmt:message key="com.rcs.admin.configuration"/>                           
        </a>
    </li>             
</ul>