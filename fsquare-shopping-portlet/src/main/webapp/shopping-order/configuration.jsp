<%@ include file="/shopping-order/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<%

%>


<aui:form action="<%= configurationURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveSettings();" %>'>
	
	
</aui:form>    





<aui:script>
	
</aui:script> 
