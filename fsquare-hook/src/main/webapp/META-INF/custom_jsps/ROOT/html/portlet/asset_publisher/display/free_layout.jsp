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
	
	if (Validator.isNull(title)) {
		title = assetRenderer.getTitle(locale);
	}
	
	String viewURL = AssetPublisherHelperImpl.getAssetViewURL(liferayPortletRequest, liferayPortletResponse, assetEntry, viewInContext);

	try {
	
	

	
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
			
			fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Text']/dynamic-content");
			if (fieldContent != null) {
				text = fieldContent.getText();
			}
				
		}

	} catch (PortalException e2) {
		e2.printStackTrace();
	} catch (SystemException e2) {
		e2.printStackTrace();
	}

	
	String itemTemplate = GetterUtil.getString(portletPreferences.getValue("itemTemplate", "span3"));

	String itemTemplate = "<a href='[VIEW_URL]' class='free-layout-item-image'><img src='[IMAGE_PATH]'/></a><div class='panel-body'><div class='free-layout-item-caption'>[TEXT]</div><a class='btn btn-small free-layout-item-link' href='[VIEW_URL]'>[VIEW_TEXT]</a></div>";
	String itemDisplay = itemTemplate.replaceAll("\\[IMAGE_PATH\\]", imagePath).replaceAll("\\[VIEW_TEXT\\]", "view").replaceAll("\\[VIEW_URL\\]", viewURL).replaceAll("\\[TEXT\\]", text);

%>


<c:if test='<%= assetEntryIndex == 0 %>'>
	<div class="row">
</c:if>
<div class="<%= freeLayoutColumns %>">
	<div class="free-layout-item">
		<div class="free-layout-item-wrapper">
			<liferay-util:include page="/html/portlet/asset_publisher/asset_actions.jsp" />
			<%=itemDisplay %>

	    </div>
	</div>
</div>
<c:if test='<%= assetEntryIndex == (results.size()-1) %>'>
	</div>
</c:if>
