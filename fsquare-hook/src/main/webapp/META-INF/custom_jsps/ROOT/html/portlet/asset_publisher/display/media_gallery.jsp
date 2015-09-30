<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portlet.asset.model.AssetRenderer"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
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
	String portletId = (String)request.getAttribute("view.jsp-portletId");
	int assetEntryIndex = ((Integer)request.getAttribute("view.jsp-assetEntryIndex")).intValue();
	
	request.setAttribute("view.jsp-showIconLabel", true);
	
	AssetEntry assetEntry = (AssetEntry)request.getAttribute("view.jsp-assetEntry");
	AssetRendererFactory assetRendererFactory = (AssetRendererFactory)request.getAttribute("view.jsp-assetRendererFactory");
	AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");
	
	JournalArticleResource journalArticleResource = null;
	JournalArticle journalArticle = null;
	
	String title = (String)request.getAttribute("view.jsp-title");
	String text = StringPool.BLANK;
	String filterType = StringPool.BLANK;
	String imagePath = StringPool.BLANK;
	String smallImagePath = StringPool.BLANK;
	String secondSection = StringPool.BLANK;
	double priority = assetEntry.getPriority();
	if (Validator.isNull(title)) {
		title = assetRenderer.getTitle(locale);
	}
	
	String viewURL = AssetPublisherHelperImpl.getAssetViewURL(liferayPortletRequest, liferayPortletResponse, assetEntry, viewInContext);
	String editURL = null;
// 	System.out.println("viewInContext: "+viewInContext);
// 	System.out.println("viewURL: "+viewURL);

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
			
			fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Filter']/dynamic-content");
			if (fieldContent != null) {
				filterType = fieldContent.getText();
			}

		}

	} catch (PortalException e2) {
		e2.printStackTrace();
	} catch (SystemException e2) {
		e2.printStackTrace();
	}
	
%>


<c:if test='<%= assetEntryIndex == 0 %>'>
	
	<c:if test='<%= Validator.isNotNull(filterSettings) %>'>
		<div class="row">
		<div class="span12">
			<div class="filter-separator"></div>
			<ul class="gallery-filter">
				<li class="gallery-filter-first">
		        	<a href="javascript:;" class="gallery-filter-item" data-filter="*">All</a>
		        </li>
				<%
				String[] filtersArr = filterSettings.split(StringPool.SEMICOLON);
				int index = 1;
				for(String filter: filtersArr){
					String[] filterArr = filter.split(StringPool.DASH);
					%>
				        <li class='<%= index == filtersArr.length?"gallery-filter-last":StringPool.BLANK %>'>
				        	<a href="javascript:;" class="gallery-filter-item" data-filter=".<%= filterArr.length>1?filterArr[1]:filterArr[0] %>"><%= filterArr[0] %></a>
				        </li>
					<%
					index++;			
				}
				%>
			</ul>
		</div>
		</div>
	</c:if>
	<div class="row media-gallery media-gallery-<%=portletId %>" id='media-gallery-<%=portletId %>'>
</c:if>

	<div class='<%= layoutColumns + " " + filterType %>'>
		
		<c:if test='<%= assetRenderer.hasEditPermission(themeDisplay.getPermissionChecker()) %>'>
			<%@ include file="/html/portlet/asset_publisher/display/item_actions.jspf" %>
		</c:if>
		
		<a href="<%= viewURL %>" class='gallery-item '>
			<div class="gallery-item-poster">
				<img src="<%= imagePath %>"></img>
				<div class="gallery-item-details">
					<div><%= title %></div>
				</div>
			</div>
	 	</a>
	</div>
	
<c:if test='<%= assetEntryIndex == (results.size()-1) %>'>
	</div>

	<script type="text/javascript" charset="utf-8">
	<c:if test='<%= Validator.isNotNull(filterSettings) %>'>
		
		$('#media-gallery-<%=portletId %>').ready(function() {
			window.mediaGallery<%=portletId %> = $('#media-gallery-<%=portletId %>').isotope({});
		});
		/*window.mediaGallery<%=portletId %>.isotope({ filter: '*' })*/
		$('.gallery-filter-item').click(function(){
			var filter = $(this).attr('data-filter');
			console.log("filter: "+filter);
			window.mediaGallery<%=portletId %>.isotope({ filter: filter})
		});
	</c:if>
	
	</script>
</c:if>
