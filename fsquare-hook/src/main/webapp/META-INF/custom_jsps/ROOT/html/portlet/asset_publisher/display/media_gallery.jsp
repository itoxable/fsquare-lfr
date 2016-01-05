<%@page import="com.liferay.portlet.asset.model.AssetCategoryConstants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
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
	
	List<AssetCategory> assetEntryCategories =  AssetCategoryLocalServiceUtil.getAssetEntryAssetCategories(assetEntry.getEntryId());
	StringBuilder catFilters = new StringBuilder();
	for(AssetCategory assetCategory: assetEntryCategories){
		if(assetCategory.getVocabularyId() == filterVocabularyId){
			catFilters.append(assetCategory.getName().replaceAll(" ", StringPool.UNDERLINE).toLowerCase()).append(StringPool.SPACE);
		}
		
		
	}
	JournalArticleResource journalArticleResource = null;
	JournalArticle journalArticle = null;
	
	String title = (String)request.getAttribute("view.jsp-title");
	String text = StringPool.BLANK;
	String price = StringPool.BLANK;
	String author = StringPool.BLANK;
	String imagePath = StringPool.BLANK;
	String smallImagePath = StringPool.BLANK;
	String secondSection = StringPool.BLANK;
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
			Node fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Main_Image']/dynamic-content");
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
			
			fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Price']/dynamic-content");
			if (fieldContent != null) {
				price = fieldContent.getText();
			}
			
			fieldContent = document.selectSingleNode("//*/dynamic-element[@name='Author']/dynamic-content");
			if (fieldContent != null) {
				author = fieldContent.getText();
			}
			
		}

	} catch (PortalException e2) {
		e2.printStackTrace();
	} catch (SystemException e2) {
		e2.printStackTrace();
	}
	List<AssetCategory> assetCategoryList = new ArrayList<AssetCategory>();
	if(Validator.isNotNull(filterVocabularyId)){
		assetCategoryList = AssetCategoryLocalServiceUtil.getVocabularyCategories(AssetCategoryConstants.DEFAULT_PARENT_CATEGORY_ID,filterVocabularyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}
%>


<c:if test='<%= assetEntryIndex == 0 %>'>
	
	<c:if test='<%= Validator.isNotNull(filterSettings) %>'>
		<div class="row">
			<div class="span12">
				<div class="filter-separator"></div>
				
				<div class="gallery-filter">
					<a href="javascript:;" id="category-toggle-<%=portletId %>" class="category-toggle-mobile p-event-menu" >Categories<span class="fa fa-bars"></span></a>
					<div class="gallery-filter-wrapper" id="gallery-filter-wrapper-<%=portletId %>">
						<span class="gallery-filter-item-wrapper gallery-filter-first">
				        	<a href="javascript:;" class="gallery-filter-item" data-filter="*">All</a>
				        </span>
						<%
						
						String[] filtersArr = filterSettings.split(StringPool.SEMICOLON);
						int index = 1;
						for(AssetCategory assetCategory: assetCategoryList){
							String filter = assetCategory.getName();
							%>
						        <span class='gallery-filter-item-wrapper <%= index == filtersArr.length?"gallery-filter-last":StringPool.BLANK %>'>
						        	<a href="javascript:;" class="gallery-filter-item" data-filter=".<%= assetCategory.getName().replaceAll(" ", StringPool.UNDERLINE).toLowerCase() %>"><%= filter %></a>
						        </span>
							<%
							index++;			
						}
						%>
					</div>
				</div>
				
			</div>
		</div>
	</c:if>
	<div class="row media-gallery media-gallery-<%=portletId %>" id='media-gallery-<%=portletId %>'>
</c:if>

	<div class='media-gallery-item <%= layoutColumns + " " + catFilters.toString() %> span-xs-6'  id="<portlet:namespace />_asset_<%= assetEntry.getEntryId() %>" >
		<c:if test='<%= assetRenderer.hasEditPermission(themeDisplay.getPermissionChecker()) %>'>
			<%@ include file="/html/portlet/asset_publisher/display/item_actions.jspf" %>
		</c:if>
		<div class='gallery-item-wrap'>
			<a href="<%= viewURL %>" class='gallery-item'>
				<span class="gallery-item-poster" style="background-image: url('<%= imagePath %>')" data-caption="<a class='media-gallery-sliphover' href='<%= PortalUtil.escapeRedirect(viewURL) %>' ><h2><%= title %></h2></a>">
				</span>
				<div class="gallery-item-details">
					<span class="gallery-item-price"><%= price %>
						<span class="regular-price">127</span>
					</span>
					<span class="gallery-item-title"><%= title %></span>
					<span class="gallery-item-author"><%= author %></span>
				</div>
		 	</a>
	 	</div>
	</div>
	
<c:if test='<%= assetEntryIndex == (results.size()-1) %>'>
	</div>

	<script type="text/javascript" charset="utf-8">
		<c:if test='<%= Validator.isNotNull(filterSettings) %>'>
			
			$('#media-gallery-<%=portletId %>').ready(function() {
				window.mediaGallery<%=portletId %> = $('#media-gallery-<%=portletId %>').isotope({});
			});
			
			
			$('.gallery-filter-item').click(function(){
				var filter = $(this).attr('data-filter');
				window.mediaGallery<%=portletId %>.isotope({ filter: filter});
				if(window.innerWidth < 768){
					$('#gallery-filter-wrapper-<%=portletId %>').fadeOut(0);
				}
			});
			
		</c:if>
		
		stroll.bind('#media-gallery-<%=portletId %>');
		
		/*$('#media-gallery-<%=portletId %>').sliphover({
			caption: 'data-caption',
			target:'.gallery-item-poster'
		});*/
		
		$('#category-toggle-<%= portletId %>').click(function(){
			$('#gallery-filter-wrapper-<%= portletId %>').slideToggle();
		});
		
		$(window).resize(function(){
			if(window.innerWidth > 767){
				$('#gallery-filter-wrapper-<%= portletId %>').fadeIn();
			}else{
				$('#gallery-filter-wrapper-<%= portletId %>').fadeOut();
			}
		});
		
	</script>
</c:if>
