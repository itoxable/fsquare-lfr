<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.CharPool"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.kernel.portlet.WindowStateFactory"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetRenderer"%>
<%@ include file="/html/portlet/asset_publisher/init.jsp" %>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil" %>
<%@page import="com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil" %>
<%@page import="com.liferay.portlet.journal.model.JournalArticleResource" %>
<%@page import="com.liferay.portlet.journal.model.JournalArticle" %>
<%@page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@page import="com.liferay.portal.kernel.xml.SAXReaderUtil" %>
<%@page import="com.liferay.portal.kernel.xml.Document" %>
<%@page import="com.liferay.portal.kernel.xml.Node" %>

<%

List results = (List)request.getAttribute("view.jsp-results");

int assetEntryIndex = ((Integer)request.getAttribute("view.jsp-assetEntryIndex")).intValue();
request.setAttribute("view.jsp-showIconLabel", true);

AssetEntry assetEntry = (AssetEntry)request.getAttribute("view.jsp-assetEntry");
AssetRendererFactory assetRendererFactory = (AssetRendererFactory)request.getAttribute("view.jsp-assetRendererFactory");
AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");

JournalArticleResource journalArticleResource = null;
JournalArticle journalArticle = null;

String title = (String)request.getAttribute("view.jsp-title");
String text = "";
String imagePath = "";
String secondSection = "";
String link = "";
double priority = assetEntry.getPriority();
if (Validator.isNull(title)) {
	title = assetRenderer.getTitle(locale);
}

String editTitle = null;
/*if(assetRenderer.hasEditPermission(themeDisplay.getPermissionChecker())){
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("struts_action", "/asset_publisher/add_asset_redirect");
	portletURL.setWindowState(LiferayWindowState.POP_UP);
	//redirect = portletURL.toString();
	PortletURL editPortletURL = assetRenderer.getURLEdit(renderRequest, renderResponse, WindowStateFactory.getWindowState("pop_up"), portletURL);
	if (Validator.isNotNull(editPortletURL)) {
		editTitle = LanguageUtil.format(locale, "edit-x", title);
		
	}
}

*/

String editURL = null;

try {
	
	if(assetRenderer.hasEditPermission(themeDisplay.getPermissionChecker())){
		PortletURL renderURL = liferayPortletResponse.createRenderURL();
		renderURL.setWindowState(LiferayWindowState.POP_UP);
		renderURL.setParameter("struts_action", "/asset_publisher/add_asset_redirect");
		PortletURL editPortletURL = assetRenderer.getURLEdit(liferayPortletRequest, liferayPortletResponse, LiferayWindowState.POP_UP, renderURL);
		editURL = HtmlUtil.escapeURL(editPortletURL.toString());
	}
    journalArticleResource = JournalArticleResourceLocalServiceUtil.getArticleResource(assetEntry.getClassPK());
    journalArticle = JournalArticleLocalServiceUtil.getArticle(assetEntry.getGroupId(), journalArticleResource.getArticleId());
           
	String content = journalArticle.getContent();
	Document document = null;
	try {
		document = SAXReaderUtil.read(content);
	} catch (Exception de) {
		de.printStackTrace();
	}

	if (Validator.isNotNull(document)) {
		Node fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Image']/dynamic-content");
		if (fieldContent != null) {
			imagePath = fieldContent.getText();
		}
		
		fieldContent = document
				.selectSingleNode("//*/dynamic-element[@name='Text']/dynamic-content");
		if (fieldContent != null) {
			text = fieldContent.getText();
		}
		
		fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Link_to_Page']/dynamic-content");
		if (fieldContent != null) {
			String data = fieldContent.getText();
			String[] layoutDetails = data.split(Character.toString(CharPool.AT));				
			try {
				long groupId = Long.parseLong(layoutDetails[2]);
				Group group = GroupLocalServiceUtil.getGroup(groupId);
				
				if (groupId == 0) {
					groupId = themeDisplay.getScopeGroupId();
				}
				
				boolean privateLayout = !"public".equals(layoutDetails[1]);
				long layoutId = Long.parseLong(layoutDetails[0]);
				Layout _layout = LayoutLocalServiceUtil.getLayout(groupId, privateLayout, layoutId);

				link = PortalUtil.getLayoutFriendlyURL(_layout, themeDisplay);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
					
	}

} catch (PortalException e2) {
	// TODO Auto-generated catch block
	e2.printStackTrace();
} catch (SystemException e2) {
	// TODO Auto-generated catch block
	e2.printStackTrace();
}
%>



<div class="image-carousel-wrapper" style="background-image: url('<%=imagePath %>')">

	<c:if test='<%= assetRenderer.hasEditPermission(themeDisplay.getPermissionChecker()) %>'>
		<div class="lfr-meta-actions asset-actions" style="float: none;">
			<c:if test='<%= Validator.isNotNull(editURL) %>'>
				<a class="fa fa-pencil-square edit-button" target="_self" href=
				"javascript:Liferay.Util.openWindow({dialog: {width: 960}, id:'<%= liferayPortletResponse.getNamespace() %>editAsset', title: '<%= title %>', uri:'<%= editURL %>'});">
					Edit
				</a>
			</c:if>
			<div class="inline-priority-set-wrapper">
				<input type="number" name="priority" id="<portlet:namespace />priority_input<%= journalArticle.getId() %>" value="<%= priority %>" maxlength="3" size="3" ></input>
				<a class="priority-button" onclick="<portlet:namespace />changePriority(<%= assetEntry.getEntryId() %>,<%= journalArticle.getId() %>)"><i class="fa fa-chevron-circle-right"></i></a>
			</div>
		</div>
	</c:if>

	<c:if test='<%= editTitle != null && !editTitle.equals("") %>'>
	<liferay-ui:icon image="edit" label="<%= true %>" message='Edit' 
   		url="javascript:Liferay.Util.openWindow({dialog: {width: 960}, id:'<%=renderResponse.getNamespace()%> editAsset', title: '<%= editTitle %>', uri:'<%= HtmlUtil.escapeURL(editPortletURL.toString())%>'});"
	/>
    </c:if>
	<c:if test='<%= text != null && !text.equals("") %>'>
        <div class="image-carousel-caption"><%=text %></div>
    </c:if>
</div>

