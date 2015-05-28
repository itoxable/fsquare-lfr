<#assign liferay_ui = taglibLiferayHash["/WEB-INF/tld/liferay-ui.tld"] />

<#if entries?has_content>
    <#assign id = randomizer.nextInt()/>
      <div class="carousel carousel-${id}">
        <#list entries as entry>
            <#assign assetRenderer = entry.getAssetRenderer() />
			<#assign article = assetRenderer.getArticle()/>
			<#assign entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale)) />
            <#assign imageUrl = assetRenderer.getURLImagePreview(renderRequest) />
            
            <#assign article = assetRenderer.getArticle()/>
            <#assign doc = saxReaderUtil.read(article.getContentByLocale(locale)) />
			
			<#assign image = doc.selectSingleNode("/root/dynamic-element[@name='Image']/dynamic-content").getText() />
            <#assign text = doc.selectSingleNode("/root/dynamic-element[@name='Text']/dynamic-content").getText() />
            <div>
                <div class="lfr-meta-actions asset-actions" style="float: none">
			        <@getEditIcon/>
			    </div>
                <img src="${image}" />
                <#if text?has_content>
                    <div class="carousel-caption">${text}</div>
                </#if>
            </div>
        </#list>
        
    </div>
    
    <script type="text/javascript" charset="utf-8">
        $('.carousel-${id}').slick({
            autoplay: true,
            autoplaySpeed: 5000,
            dots: true,
            mobileFirst: true
        });
    </script>
</#if>

<#macro getEditIcon>
	<#if assetRenderer.hasEditPermission(themeDisplay.getPermissionChecker())>
		<#assign redirectURL = renderResponse.createRenderURL() />
		
		${redirectURL.setParameter("struts_action", "/asset_publisher/add_asset_redirect")}
		${redirectURL.setWindowState("pop_up")}
		
		<#assign editPortletURL = assetRenderer.getURLEdit(renderRequest, renderResponse, windowStateFactory.getWindowState("pop_up"), redirectURL)!"" />
		
		<#if validator.isNotNull(editPortletURL)>
			<#assign title = languageUtil.format(locale, "edit-x", entryTitle) />
		

    			<@liferay_ui["icon"]
    			label=true
    			image="edit"
    			message="Edit"
    			url="javascript:Liferay.Util.openWindow({dialog: {width: 960}, id:'" + renderResponse.getNamespace() + "editAsset', title: '" + title + "', uri:'" + htmlUtil.escapeURL(editPortletURL.toString()) + "'});"
    			/>
		</#if>
	</#if>
</#macro>