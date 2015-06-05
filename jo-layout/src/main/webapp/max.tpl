<div class="columns-max" id="main-content" role="main">

#set ($containerClass = "")
#if ($layout.getTheme().getName() == "GeoPlace Theme")
	#set ($containerClass = "container")
#end

	<div class="$containerClass">
		<div class="portlet-layout row-fluid">
			<div class="portlet-column portlet-column-only span12" id="column-1">
				$processor.processMax()
			</div>
		</div>
	</div>
</div>