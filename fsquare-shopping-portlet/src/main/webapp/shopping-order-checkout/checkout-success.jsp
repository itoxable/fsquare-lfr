<%@page import="freemarker.core.Environment"%>
<%@page import="java.io.StringReader"%>
<%@page import="freemarker.template.Template"%>
<%@page import="com.liferay.portal.kernel.io.unsync.UnsyncStringWriter"%>
<%@page import="freemarker.template.SimpleSequence"%>
<%@page import="freemarker.template.Configuration"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ include file="init.jsp" %>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.fsquare.shopping.portlet.util.ShoppingPortletUtil"%>
<%

Configuration configuration = new Configuration();
configuration.setDefaultEncoding(StringPool.UTF8);
configuration.setNumberFormat("0.######");
Map<String, Object> ctx = new HashMap<String, Object>();

SimpleSequence simpleSequence = new SimpleSequence();
//simpleSequence.

// ctx.put("shoppingOrderItems", shoppingOrderItems);
ctx.put("shoppingOrder", shoppingOrder);
ctx.put("shoppingStore", shoppingStore);

UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter();

Template template = new Template("templateName", new StringReader(shoppingStore.getCheckoutCompletePageTemplate()), configuration);
Environment env = template.createProcessingEnvironment(ctx, unsyncStringWriter);
env.process();


%>

<div><%= unsyncStringWriter.toString() %></div>