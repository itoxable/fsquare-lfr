<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.CharPool"%>
<%@page import="com.liferay.portal.kernel.templateparser.TemplateNode"%>
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
	String link = "";
	String imagePath = "";
	String smallImagePath = "";
	String rows = layoutColumns;
	double priority = assetEntry.getPriority();
	if (Validator.isNull(title)) {
		title = assetRenderer.getTitle(locale);
	}
	
	String viewURL = AssetPublisherHelperImpl.getAssetViewURL(liferayPortletRequest, liferayPortletResponse, assetEntry, viewInContext);
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
			fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Rows']/dynamic-content");
			if (fieldContent != null) {
				rows = fieldContent.getText();
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
		e2.printStackTrace();
	} catch (SystemException e2) {
		e2.printStackTrace();
	}
// 	System.out.println("columns: "+columns);
// 	System.out.println("assetEntryIndex: "+assetEntryIndex);
// 	System.out.println(""+((assetEntryIndex+1) % columns));
	
%>


<c:if test='<%= assetEntryIndex == 0 %>'>
	<div class="container">
	<div class="row">
</c:if>

	<div class="<%= rows %> span-xs-4 big-link-wrapper" id="<portlet:namespace />_asset_<%= assetEntry.getEntryId() %>">
		
		<c:if test='<%= assetRenderer.hasEditPermission(themeDisplay.getPermissionChecker()) %>'>
			<%@ include file="/html/portlet/asset_publisher/display/item_actions.jspf" %>
		</c:if>
		
		<a href="<%= link %>" class="big-link-item" style='<%= Validator.isNotNull(imagePath)?"background-image: url(\""+imagePath+"\")":"" %>'>
			<div class="big-link-item-text-wrapper">
				<h2 class="big-link-item-text"><%= title %></h2>
			</div>
	  	</a>
	</div>
	
<c:if test='<%= assetEntryIndex == (results.size()-1) %>'>
	</div>
	</div>
</c:if>
