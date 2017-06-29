(function(fsStyleEditor, jQuery) {
	//return;
	String.prototype.replaceAll = function(target, replacement) {
		return this.split(target).join(replacement);
	};

	fsStyleEditor.selector = ".portlet-boundary";

	fsStyleEditor.stylesMemory = [];
	fsStyleEditor.currentStyleIndex = 0; 
	
	fsStyleEditor.saveLayout = function(){
		
		var toSave = {};
		for(var i = (fsStyleEditor.stylesMemory.length - 1); i > -1; i--){
			var style = fsStyleEditor.stylesMemory[i];
			var key = Object.keys(style)[0];
			if (key in toSave){
				continue;
			}
			toSave[key] = style[key];
		}
		
		console.log(JSON.stringify(toSave));
		///c/portal/fs/portlet_style
		jQuery.ajax({
			url: '/c/portal/fs/portlet_style',
			dataType: 'json',
			method: 'POST',
			data: {'data': JSON.stringify(toSave)}
		}).done(function(){
			console.log("done");
		}).fail(function() {
			console.log("fail");
		});
	}
			
	fsStyleEditor.undoLayout = function(){
		fsStyleEditor.currentStyleIndex--;
		console.log("UNDO: currentStyleIndex: "+fsStyleEditor.currentStyleIndex+ "; stylesMemory.length: " + fsStyleEditor.stylesMemory.length);
		var styles = fsStyleEditor.stylesMemory[fsStyleEditor.currentStyleIndex-1];
		fsStyleEditor.applyStyles(styles);		
		
	}
	
	fsStyleEditor.redoLayout = function(){
		if(fsStyleEditor.currentStyleIndex == fsStyleEditor.stylesMemory.length){
			return;
		}
		fsStyleEditor.currentStyleIndex++;
		console.log("REDO: currentStyleIndex: "+fsStyleEditor.currentStyleIndex+ "; stylesMemory.length: " + fsStyleEditor.stylesMemory.length);
		var styles = fsStyleEditor.stylesMemory[fsStyleEditor.currentStyleIndex];
		fsStyleEditor.applyStyles(styles);
	}
	
	fsStyleEditor.addToHistory = function(id, style){
		
		var styleToHistory = {};
		styleToHistory[id] = style;
		if(fsStyleEditor.currentStyleIndex < fsStyleEditor.stylesMemory.length){
			var howmany = fsStyleEditor.stylesMemory.length - fsStyleEditor.currentStyleIndex;
			fsStyleEditor.stylesMemory.splice(fsStyleEditor.currentStyleIndex, howmany);
		}
		
		fsStyleEditor.stylesMemory.push(styleToHistory);
		fsStyleEditor.currentStyleIndex = fsStyleEditor.stylesMemory.length;
		
	}
	
	fsStyleEditor.applyStyles = function(styles){
		var id = Object.keys(styles)[0];
		var style = styles[id];
		var element = $('#'+id);
		element.addClass('all-animation');
		element.css(style);
	}

	fsStyleEditor.removeInteraction = function(interactionName, elem){
		//jQuery('#'+id).remove();
		var id = elem.id+'interactions-'+interactionName.replaceAll(' ','').toLowerCase();
		jQuery('#'+id).fadeOut(200);
	}
	
	fsStyleEditor.updateInteraction = function(interactionName, elem, values){
		for(var i = 0; i< values.length; i++){
			var value = values[i];
			jQuery(elem).find('.interaction-value-'+value.label.replaceAll(' ','')).text(value.value+value.unit);
		}
	}
	
	fsStyleEditor.showInteraction = function(interactionName, elem, values){
		//interactionName.replaceAll(' ','').toLowerCase();
		var id = elem.id+'interactions-'+interactionName.replaceAll(' ','').toLowerCase();
		
		var valuesDisplay = [];
		for(var i = 0; i< values.length; i++){
			var value = values[i];
			valuesDisplay.push('<span class="interaction-label">');
			valuesDisplay.push(value.label);
			valuesDisplay.push(': </span><span class="interaction-value interaction-value-'+value.label.replaceAll(' ','')+'">');
			valuesDisplay.push(value.value.toFixed(2));
			valuesDisplay.push(value.unit);
			valuesDisplay.push('</span>');
		}
		
		if(jQuery('#'+id).length == 0){
			jQuery(elem).append('<div id="'+id+'" class="ui-interactions">'+valuesDisplay.join('')+'</div>')
		}else{
			jQuery('#'+id).fadeIn(200);
		}
	}
	
	fsStyleEditor.startInteraction = function(interactionName, elem, values){}

	fsStyleEditor.stopEditing = function(elem){
		elem = elem || fsStyleEditor.selector;

		jQuery(elem).each(function() {
			var item =jQuery(this);
			var dr = item.draggable("instance");
			if(item.draggable('instance')){
				item.draggable('disable');
			}
			if(item.resizable('instance')){
				item.resizable('disable');
			}
			item.removeClass('ui-resizable');
			item.removeClass('ui-draggable');

		});

	}

	fsStyleEditor.startEditing = function(elem){
		var item =jQuery(elem);

			item.resizable({
				handles: "all",
				start: function (event, ui) {

					fsStyleEditor.addToHistory(this.id, {
						width: ui.size.width,
						height: ui.size.height
					});

					fsStyleEditor.showInteraction('size', this, [{
						label: "Width",
						value: ui.size.width,
						unit: 'px'
					}, {
						label: "Height",
						value: ui.size.height,
						unit: 'px'
					}]);
				},

				resize: function (event, ui) {
					fsStyleEditor.updateInteraction('size', this, [{
						label: "Width",
						value: ui.size.width,
						unit: 'px'
					}, {
						label: "Height",
						value: ui.size.height,
						unit: 'px'
					}]);
				},

				stop: function (event, ui) {
					fsStyleEditor.removeInteraction('size', this);
					fsStyleEditor.addToHistory(this.id, {
						width: ui.size.width,
						height: ui.size.height
					});
				}
			});
		//}
		//if(item.draggable("instance")) {
			item.draggable({
				start: function (event, ui) {
					fsStyleEditor.addToHistory(this.id, {
						left: ui.position.left,
						top: ui.position.top
					});

					fsStyleEditor.showInteraction('position', this, [{
						label: "X",
						value: ui.position.left,
						unit: 'px'
					}, {
						label: " Y",
						value: ui.position.top,
						unit: 'px'
					}]);
				},
				drag: function (event, ui) {
					fsStyleEditor.updateInteraction('position', this, [{
						label: "X",
						value: ui.position.left,
						unit: 'px'
					}, {
						label: " Y",
						value: ui.position.top,
						unit: 'px'
					}]);

				},
				stop: function (event, ui) {
					fsStyleEditor.removeInteraction('position', this);
					fsStyleEditor.addToHistory(this.id, {
						left: ui.position.left,
						top: ui.position.top
					});
				}
			});
		//}
	}


	jQuery(fsStyleEditor.selector).click(function(event){
		console.log('.');
		event.stopPropagation();
		var item = jQuery(this);

		if(item.draggable("instance") || item.resizable("instance")){
			fsStyleEditor.stopEditing();
			if(!item.hasClass('ui-resizable')){
				item.addClass('ui-resizable');
			}
			if(!item.hasClass('ui-draggable')){
				item.addClass('ui-draggable');
			}

			item.draggable("enable");
			item.resizable("enable");
		}else{
			fsStyleEditor.stopEditing();
			fsStyleEditor.startEditing(this);
		}


	});
	jQuery('body').click(function(event){
		fsStyleEditor.stopEditing();
	});
	jQuery('body').append('<div style="position: fixed; bottom: 20px; left: 20px; z-index: 99999"><button type="button" onclick="fsStyleEditor.saveLayout()"> Save </button><button type="button" onclick="fsStyleEditor.undoLayout()"> Undo </button><button type="button" onclick="fsStyleEditor.redoLayout()"> Redo </button></div>');
	
	
}(window.fsStyleEditor = window.fsStyleEditor || {}, jQuery));


		  
		  
		  
		  