<#--显示swf文件(用于将office文件转换为swf文件后的显示，在Action中，应将swf路径“swfpath”放置于map中)-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>浏览文件</title>
<style type="text/css" media="screen">
html,body {
	height: 100%;
}

body {
	margin: 0;
	padding: 0;
	overflow: auto;
}

#flashContent {
	display: none;
}
</style>
<script type="text/javascript" src="/resources/jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/flexpaper/js/flexpaper_flash.js"></script>
</head>

<body >
	<div style="text-align:center;">
		<a id="viewerPlaceHolder"
			style="width: 100%; height: 100%; display: block"></a>

		<script type="text/javascript">
	     		var fp = new FlexPaperViewer(	
						 '/flexpaper/FlexPaperViewer',
						 'viewerPlaceHolder', { config : {
						 SwfFile :escape('${map.swfpath?default('')}'),
							Scale : 0.6,
							ZoomTransition : 'easeOut',
							ZoomTime : 0.5,
							ZoomInterval : 0.2,
							FitPageOnLoad : true,
							FitWidthOnLoad : true,
							PrintEnabled : false,
							FullScreenAsMaxWindow : false,
							ProgressiveLoading : true,
							MinZoomSize : 0.2,
							MaxZoomSize : 5,
							SearchMatchAll : false,
							InitViewMode : 'Portrait',

							ViewModeToolsVisible : true,
							ZoomToolsVisible : true,
							NavToolsVisible : true,
							CursorToolsVisible : true,
							SearchToolsVisible : true,

							localeChain : 'zh_CN'
						}
					});
		</script>
	</div>
</body>
</html>
