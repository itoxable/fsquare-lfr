<#assign imageLocalService = utilLocator.findUtil("com.liferay.portal.service.ImageLocalService")>


<div class="container">
    <div class="row product">
        <div class="span6">
            <div class="product-gallery">
                <div class="product-main-image">
                    <div><a href='${Main_Image.getData()}' data-lightbox="images-galery-set" class="product-main-image-item"><img alt="Main Image" src="${Main_Image.getData()}" /></a></div>
                    <#if Images.getSiblings()?has_content>
                        <#list Images.getSiblings() as cur_Images>
                    		<div><a href='${cur_Images.getData()}' data-lightbox="images-galery-set" class="product-main-image-item"><img alt="Images" src="${cur_Images.getData()}" /></a></div>
                    	</#list>
                    </#if>
                </div>
                <#if Images.getSiblings()?has_content>
                    <div class="product-images">
                        <div class="product-images-item"><img alt="Main Image" src="${Main_Image.getData()}" /></div>
                    	<#list Images.getSiblings() as cur_Images>
                    		<div class="product-images-item"><img alt="Images" src="${cur_Images.getData()}" /></div>
                    	</#list>
                    </div>
                </#if>
            </div>
        </div>
        
        <div class="span6">
            <div class="product-details">
                <h1 class="product-details-title">${.vars['reserved-article-title'].data}</h1>
                <p class="product-details-author">By<span class="product-details-author-name">${Author.getData()}</span></p>
                <p class="product-details-text">${Text.getData()}</p>
                <h2 class="product-details-price">${Price.getData()}</2>
            </div>
        </div>
    </div>
</div>
<#if Images.getSiblings()?has_content>
	<script>
		$('.product-main-image').slick({
			slidesToShow: 1,
			slidesToScroll: 1,
			arrows: false,
			fade: true,
			asNavFor: '.product-images',
			fade: true,
			cssEase: 'linear'
		});
		$('.product-images').slick({
			slidesToShow: 3,
			slidesToScroll: 1,
			asNavFor: '.product-main-image',
			dots: false,
			centerMode: true,
			focusOnSelect: true,
			nextArrow: '<button type="button" class="btn btn-primary">Next</button>',
			prevArrow: '<button type="button" class="btn btn-primary">Prev</button>'
		});
	</script>
</#if>