
<%@ include file="/mini-cart/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<%


String displayType = "";
String linkTemplate = "";

String miniCartTemplate = "";

List<Layout> layoutsx = themeDisplay.getLayouts();


%>


<aui:form action="<%= configurationURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveSettings();" %>'>
	
	
	<aui:select cssClass="display-type" helpMessage="abstract-length-key-help" name="preferences--displayType--">
		<aui:option label="drop-menu" selected="<%= displayType.equals("dropMenu") %>" />
		<aui:option label="link-to-page" selected="<%= displayType.equals("linkToPage") %>" />
	</aui:select>
	
	<aui:select cssClass="display-type" helpMessage="abstract-length-key-help" name="preferences--cartPage--">
		<aui:option label="drop-menu" selected="<%= displayType.equals("dropMenu") %>" />
		<aui:option label="link-to-page" selected="<%= displayType.equals("linkToPage") %>" />
	</aui:select>
	
	<aui:input 
		cssClass="configuration-text link-template" 
		style="width: 500px; height: 200px;" 
		helpMessage="carousel-settings-help"
	 	id="<portlet:namespace />linkTemplate"
	 	name="preferences--linkTemplate--" 
	 	type="textarea" 
	 	value="<%= linkTemplate %>" />
    
    <aui:input 
		cssClass="configuration-text mini-cart-template" 
		style="width: 500px; height: 200px;" 
		helpMessage="carousel-settings-help"
	 	id="<portlet:namespace />miniCartTemplate"
	 	name="preferences--miniCartTemplate--" 
	 	type="textarea" 
	 	value="<%= miniCartTemplate %>" />
</aui:form>    





<aui:script>
	
</aui:script> 
