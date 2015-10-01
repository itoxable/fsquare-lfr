function validateMultipleCheckboxes(currentFieldValue, fieldsMap, portletNamespace){
	var result = false;
	AUI().use('aui-base', function(A){
		for(var i = 0; i< currentFieldValue.value; i++){
			var val = A.one('#'+portletNamespace+currentFieldValue.key+'_'+i).val();
			if(val == 'true'){
				result = val;
				break;
			}			
		}		
	});
	return result == 'true';
}


//return (fieldsMap['field2'] == "Bespoke / on-site training" && (!currentFieldValue || currentFieldValue == ''));

function findUPRN(uprn){
	var osURL = "//api.ordnancesurvey.co.uk/places/v1/addresses/uprn";
	AUI().use('aui-base','aui-modal','aui-io-request',function(A){
		A.io.request(osURL,{
            dataType: 'json',
            method: 'GET',
            data: { 
            	'format':'json',
            	'uprn': uprn,
            	'dataset':'DPA',
            	'key':'EoA4m9a9CEqKE15dtSQqT2VLTTebsP4h'
            },
            on: {
                success: function() {
                	var response = this.get('responseData');
                	debug(response);
                }
            }
      });
	});
}


function findPostcode(postcode){
	var osURL = "//api.ordnancesurvey.co.uk/places/v1/addresses/postcode";
	AUI().use('aui-base','aui-modal','aui-io-request',function(A){
		A.io.request(osURL,{
            dataType: 'json',
            method: 'GET',
            data: { 
            	'format':'json',
            	'postcode': postcode,
            	'dataset':'DPA',
            	'key':'EoA4m9a9CEqKE15dtSQqT2VLTTebsP4h'
            },
            headers:{
            	//'Access-Control-Allow-Origin':''
            },
            on: {
                success: function() {
                	var response = this.get('responseData');
                	debug(response);
                },
                start: function() {},
                complete: function() {},
                failure: function() {},
                end: function() {}
            }
      });
	});
}


function disableFields(elem, selector, fields){
	AUI().use('aui-base',function(A){
		var checkbox = A.one(elem);
		A.all(selector).set("disabled", checkbox.previous().val() == 'false');
	});
}
