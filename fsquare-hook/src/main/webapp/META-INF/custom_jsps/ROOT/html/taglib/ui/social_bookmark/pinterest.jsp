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

<%@ include file="/html/taglib/ui/social_bookmark/init.jsp" %>

<%
String twitterDisplayStyle = "none";

if (displayStyle.equals("horizontal") || displayStyle.equals("vertical")) {
	twitterDisplayStyle = displayStyle;
}
%>

<a class="twitter-share-button" data-count="<%= twitterDisplayStyle %>" data-lang="<%= locale.getDisplayLanguage() %>" data-text="<%= HtmlUtil.escapeAttribute(title) %>" data-url="<%= url %>" href="http://twitter.com/share"><liferay-ui:message key="tweet" /></a>

<liferay-util:html-bottom outputKey="twitter">
	<script src="<%= HttpUtil.getProtocol(request) %>://platform.twitter.com/widgets.js" type="text/javascript"></script>
</liferay-util:html-bottom>




 <a href="https://www.pinterest.com/pin/create/button/
        ?url=http%3A%2F%2Fwww.flickr.com%2Fphotos%2Fkentbrew%2F6851755809%2F
        &media=http%3A%2F%2Ffarm8.staticflickr.com%2F7027%2F6851755809_df5b2051c9_z.jpg
        &description=Next%20stop%3A%20Pinterest"
        data-pin-do="buttonPin"
        data-pin-config="above">
        <img src="//assets.pinterest.com/images/pidgets/pin_it_button.png" />
    </a>