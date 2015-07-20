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

<%@ include file="/html/portlet/login/init.jsp" %>

<liferay-util:buffer var="social">
	<liferay-ui:icon-list>

		<%
		for (String section : PropsValues.LOGIN_FORM_NAVIGATION_PRE) {
		%>
			<liferay-util:include page='<%= "/html/portlet/login/navigation/" + _getSectionJsp(section) + ".jsp" %>' portletId="<%= portletDisplay.getRootPortletId() %>" />

		<%
		}
		%>

		

	</liferay-ui:icon-list>
</liferay-util:buffer>

<%
social = social.trim();
%>

<c:if test="<%= Validator.isNotNull(social) %>">
	<div class="social">
		<p class="social-legend text-center"><%= LanguageUtil.get(pageContext, "social.login.help") %></p>
		<%= social %>
	</div>
	<hr>
</c:if>

<%!
private String _getSectionJsp(String name) {
	System.out.println("XXX: "+name);
	return TextFormatter.format(name, TextFormatter.N);
}
%>