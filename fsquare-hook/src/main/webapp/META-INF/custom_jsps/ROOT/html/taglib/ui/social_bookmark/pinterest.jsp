<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ include file="/html/taglib/ui/social_bookmark/init.jsp" %>

<%
// String twitterDisplayStyle = "none";

// if (displayStyle.equals("horizontal") || displayStyle.equals("vertical")) {
// 	twitterDisplayStyle = displayStyle;
// }
//ThemeDisplay 
//themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);


String cUrl = themeDisplay.getPortalURL()+themeDisplay.getURLCurrent();
String media = StringPool.BLANK;
String description = StringPool.BLANK;
%>

 <a href="https://www.pinterest.com/pin/create/button/?url=<%=url %>
        &media=<%= media %>
        &description=<%=description %>"
        data-pin-do="buttonPin"
        data-pin-config="above">
        <img src="//assets.pinterest.com/images/pidgets/pin_it_button.png" />
    </a>