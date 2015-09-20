<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
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

	int columns = 4; 
	if(layoutColumns.equals("span12")){
		columns = 1; 
	}else if(layoutColumns.equals("span6")){
		columns = 2; 
	}else if(layoutColumns.equals("span4")){
		columns = 3; 
	}else if(layoutColumns.equals("span3")){
		columns = 4; 
	}else if(layoutColumns.equals("span2")){
		columns = 6; 
	}else if(layoutColumns.equals("span1")){
		columns = 12; 
	}

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
	String smallImagePath = "";
	String secondSection = "";
	
	if (Validator.isNull(title)) {
		title = assetRenderer.getTitle(locale);
	}
	
	String viewURL = AssetPublisherHelperImpl.getAssetViewURL(liferayPortletRequest, liferayPortletResponse, assetEntry, viewInContext);

	try {
	
        journalArticleResource = JournalArticleResourceLocalServiceUtil.getArticleResource(assetEntry.getClassPK());
        journalArticle = JournalArticleLocalServiceUtil.getArticle(assetEntry.getGroupId(), journalArticleResource.getArticleId());
        //System.out.println("journalArticle.getSmallImageURL(): "+journalArticle.getSmallImageURL());
        smallImagePath = journalArticle.getSmallImageURL();
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
				if(Validator.isNull(smallImagePath)){
					smallImagePath = imagePath;
				}
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
	
// 	.span2:nth-child(6n+1) {
//     	margin-left: 0;
// 	}
%>


<c:if test='<%= assetEntryIndex == 0 || ((assetEntryIndex+1) % columns) == 0 %>'>
	<div class="container">
	<div class="row">
</c:if>


	<a href="<%= smallImagePath %>" class="gallery-item <%= layoutColumns %>"  data-caption-html="<%= HtmlUtil.escape(text) %>">
		<div class="gallery-item-poster">
			<img src="<%= imagePath %>" />
			
			<div class="gallery-item-details">
				<%= text %>
			</div>
		</div>
		

  	</a>

	
<c:if test='<%= assetEntryIndex == (results.size()-1)  || ((assetEntryIndex+1) % columns) == 0 %>'>
	</div>
	</div>
</c:if>
