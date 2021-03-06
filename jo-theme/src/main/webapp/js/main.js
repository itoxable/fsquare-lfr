function debug(a,b,c,d,e){
	var xx;
}


function openLogin(url){
	openPopUp(url, "Login", {
		width: 600,
		height: 420
	});
}


function openPopUp(url, title, config){
	
	AUI().use('aui-base','liferay-util-window','aui-io-plugin-deprecated',function(A){
		
		var modalConfigDefault= {
			centered: true,
			constrain2view: true,
			modal: true,
			resizable: false,
			stack: true
		};

		if(config){
			var modalConfig = A.merge(modalConfigDefault, config);
		}else{
			var modalConfig = modalConfigDefault;
		}
		
		modalConfig.cssClass = modalConfig.cssClass?modalConfig.cssClass+"custom-modal":"custom-modal";
		
		
		
		var login_popup= Liferay.Util.Window.getWindow(
    		{
				dialog: modalConfig
    		}).plug(A.Plugin.DialogIframe,
                {
                 	autoLoad: true,
                 	iframeCssClass: 'dialog-iframe',
                 	uri:url
                }).render();
         login_popup.show();
         if(title){
        	 login_popup.titleNode.html(title);
         }
        	  
     });
}





AUI().ready(

	/*
	This function gets loaded when all the HTML, not including the portlets, is
	loaded.
	*/
		function() {
			
			$.cookieBar({
				message:"This website uses cookies. By continuing to browse the site you are agreeing to our use of cookies.",
				acceptText:"×",
				policyButton: true,
				policyText: 'Find out more here'
			});
		}
//	function() {
//	}
);

Liferay.Portlet.ready(

	/*
	This function gets loaded after each and every portlet on the page.

	portletId: the current portlet's id
	node: the Alloy Node object of the current portlet
	*/

	function(portletId, node) {
	}
);

Liferay.on(
	'allPortletsReady',

	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/

	function() {
//		$.cookieBar({
//			message:"This website uses cookies. By continuing to browse the site you are agreeing to our use of cookies.",
//			acceptText:"×",
//			policyButton: true,
//			policyText: 'Find out more here'
//		});
	}
);

//function animScrollTo(id, scrollFinishFunction){
//    
//	var duration = 500;
//	// easing values: swing | linear
//	var easing='swing';
//	var target=jQuery(id).offset().top;
//    // animate to target and set the hash to the window.location after the animation
//	//var scrolled = false;
//    jQuery("html:not(:animated),body:not(:animated)").animate({ scrollTop: target }, duration, easing
//		/*function(){ 
//			if(!scrolled && isDefined(scrollFinishFunction)) 
//				scrollFinishFunction(); 
//			scrolled = true;
//		}*/
//	);
//
//}  
//
//function animScrollLinks(){
//	  jQuery('a.scroll').click(function(){
//	    var id = jQuery(this).attr('href');
//		animScrollTo(id);
//		return false;
//	  });
//	}