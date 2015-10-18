function addToShoppingCartX(assetId){
	
	AUI().use('aui-base','selector-css3','aui-io-request',function(A){
		console.log("adding to cart: "+assetId);
    	A.io.request('<%= addToCartURL %>',{
              dataType: 'json',
              method: 'POST',
              data: {
            	  entryId: assetId
              },
              on: {
                  success: function() {
                  	var response = this.get('responseData');
                  	A.one('cart-size').set('text', response.size);
                  }
              }
        });
	});
}