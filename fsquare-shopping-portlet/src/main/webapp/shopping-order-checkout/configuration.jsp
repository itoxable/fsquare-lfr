<%@ include file="init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<%

%>


<aui:form action="<%= configurationURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveSettings();" %>'>
	
	
</aui:form>    





<aui:script>
function <portlet:namespace />saveSettings() {
	submitForm(window.document.<portlet:namespace />fm);
}
</aui:script> 
