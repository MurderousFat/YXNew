<#--文件头  fitIE8参数作用:因为IE10不支持FCKEditor，所以在使用FCK的页面，此参数要传true-->
<#macro page title extDisabled="false" backgroundStyle="" extrequired=[] fitIE8 = "false" enableSupcan="false">
<#if enableSupcan == "false">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
</#if>
<html>
<head>
<title>互联网+电梯安全监管平台</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<#if fitIE8=="true">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
</#if>
<link rel="shortcut icon" href="/favicon.ico" />
<link rel="stylesheet" type="text/css" href="${base}/resources/extjs4/resources/css/ext-all.css"/>
<link rel="stylesheet" type="text/css" href="${base}/resources/extjs4/resources/css/ext_icon.css"/>
<link rel="stylesheet" type="text/css" href="${base}/resources/css/animated-dataview.css"/>
<#if  extDisabled=="false" >   
	<script type="text/javascript" src="${base}/resources/extjs4/ext-all.js"></script>
	<script type="text/javascript" src="${base}/resources/extjs4/locale/ext-lang-zh_CN.js"></script>
	<!--script type="text/javascript" src="${base}/resources/extjs4/ux/TabCloseMenu.js"></script-->
	<script type="text/javascript" src="${base}/resources/extjs4/GridComboBox.js"></script>
	<script type="text/javascript" src="${base}/resources/extjs4/GridComboBoxList.js"></script>     
</#if>
<#if enableSupcan == "true"><#--启发用硕正套件-->
<script type="text/javascript" src="${base}/binary/dynaload.js?10840"></script>
<script type="text/javascript" src="${base}/resources/commonjs/supcan_gx.js"></script>
<script type="text/javascript" src="${base}/resources/commonjs/TreeList.js"></script>
<script type="text/javascript" src="${base}/resources/commonjs/FreeForm.js"></script>
<script>
<#--google chrome和firefox会话同步处理-->
</script>
</#if>
<@artdialog />
<script type="text/javascript">
window.JSESSIONID = '${STATIC_SESSION_ID?default('')}';
art.dialog.data('JSESSIONID',window.JSESSIONID);
</script>
<script type="text/javascript" src="${base}/resources/commonjs/common.js?${temp}"></script>
<script type="text/javascript">
 var webContext = '${base}';
 function btExit_OnClick() {
	Ext.getCmp('mainTabs').getActiveTab().close();
	<#--
 	Ext.MessageBox.confirm('<@s.text name="prompt" />', '<@s.text name="Confirm.title" />', function(btn){
		if(btn == "yes"){
			window.parent.$("mainTabs").getActiveTab().close();
		}
	});
	-->
 }
 <#if extDisabled=="false" >   
	  Ext.Loader.setConfig({
		  enabled: true
		  ,paths:{
			 'Ext.ux':'../resources/extjs4/ux'
		  }
	  });
	  
 </#if>
 Ext.require([
 	<#if enableSupcan == "true">
 	'Ext.supcan.TreeList',
 	'Ext.supcan.FreeForm',
 	</#if>
    'Ext.data.*',
    'Ext.button.*',
    'Ext.container.*',
    'Ext.layout.*',
    'Ext.menu.*',
    'Ext.panel.*',
    'Ext.selection.*',
    'Ext.slider.*',
    'Ext.state.*',
    'Ext.tab.*',
    'Ext.tip.*',
    'Ext.toolbar.*',
    'Ext.tree.*',
    'Ext.util.*',
    'Ext.toolbar.*',
    'Ext.view.*',
    'Ext.window.*',
 ]);
 Ext.onReady(function() {
 		 <#if enableSupcan == "true">
 		 Ext.useShims = true;<#--盖住treelist-->
 		 </#if>
	     Ext.QuickTips.init();
	     Ext.define('Datadic', {
					    extend: 'Ext.data.Model',
					    fields: [
					        {name: 'code', type: 'string'},
					        {name: 'codedesc',  type: 'string'}      
					    ]
	     });
 });   
     
   //全局变量，当前行（上一条，下一条查询用）
   var cur_record;
  
   // 图片渲染
   function imageRender(value) {	   	    
       return "<img src='" + webContext
				+ "/resources/extjs4/resources/image/ext/"+value+"'/>";		
   }
  
  
  //公共日期渲染器
  function formatDate(value){        
        return !isEmpty(value) ? Ext.Date.dateFormat(value, 'Y M, d') : '';
  }
   <#assign preCode = "" />
   <#list codeList as code >       
      <#if  preCode != "" &&  preCode != code.field >
          //数据字典渲染器
		  function ${preCode}CodeRender(value) {   
		       <#list codeList as code1 >   
		          <#if preCode = code1.field >
                     if (value == '${code1.code}') return '<span style="color:${code1.fshowColor}">${code1.codedesc}</span>';   
                  </#if>
               </#list>   		    
		  	   return value
		  }  
      </#if>
		<#assign preCode = code.field />     
   </#list>
   <#if preCode != "" >
          //数据字典渲染器
		  function ${preCode}CodeRender(value) {     
		        <#list codeList as code2 >   
		          <#if preCode = code2.field >
                     if (value == '${code2.code}') return '<span style="color:${code2.fshowColor?default('')}">${code2.codedesc}</span>';   
                  </#if>
               </#list>   		    
		  	   return value
		  }  
   </#if>
   Ext.define('treeMode', {
		extend : 'Ext.data.Model',
		fields : [ {
			name : 'id',
			type : 'string'
		}, {
			name : 'text',
			type : 'string'
		} ]
	});
</script>
</head>
  <body  <#if backgroundStyle != "">style="${backgroundStyle}"</#if> <#--style="background-image:url(/bn.jpg)"-->>
    <#nested>
  </body>
</html>
</#macro>

<#macro artdialog>
<link rel="stylesheet" type="text/css" href="/resources/artdialog/skins/blue.css"/>
<script type="text/javascript" src="/resources/artdialog/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/resources/artdialog/artDialog.js"></script>
<script type="text/javascript" src="/resources/artdialog/iframeTools.js"></script>
<script type="text/javascript" src="/resources/artdialog/jquery.json-2.4.min.js"></script>
</#macro>

<#-- 操作列定义 -->
<#macro actioncolumn name actionType="all">
	  {
        xtype: 'actioncolumn',  
        text:'操作',
        width: 40,
        width: 40,		               
        items: [
       <#if actionType=="all">         
	          {
                    icon   : '${base}/resources/extjs4/resources/image/ext/add.gif',  
                    tooltip: '新增',
                    handler: function(grid, rowIndex, colIndex) {
                        ${name}ActionColumnAdd_OnClick(grid, rowIndex, colIndex);
                    }
                },{
                    icon   : '${base}/resources/extjs4/resources/image/ext/delete.gif', 
                    tooltip: '删除',
                    handler: function(grid, rowIndex, colIndex) {
                        ${name}ActionColumnDelete_OnClick(grid, rowIndex, colIndex);
                    }
                }
	    <#elseif actionType=="add">
	         {
                    icon   : '${base}/resources/extjs4/resources/image/ext/add.gif',  
                    tooltip: '新增',
                    handler: function(grid, rowIndex, colIndex) {
                        ${name}ActionColumnAdd_OnClick(grid, rowIndex, colIndex);
                    }
                }
        <#elseif actionType=="del">
              {
                    icon   : '${base}/resources/extjs4/resources/image/ext/delete.gif', 
                    tooltip: '删除',
                    handler: function(grid, rowIndex, colIndex) {
                        ${name}ActionColumnDelete_OnClick(grid, rowIndex, colIndex);
                    }
                }
        </#if>

        ]
      }		
</#macro>


<#-- 普通树定义 -->
<#macro defineTree url name modelStr="" rootExpand = "true" store = "" rootText="" useArrows="false" 
			clickEvent="true" dblClickEvent="false" title="" width=175 defineModel="false" fieldStr="" 
			rootVisible="false" autoLoad="true" toolbarStr="" rootId="0" applyName="">
	<#if modelStr != "">
	Ext.define('${name}treeMode', {
		extend : 'Ext.data.Model',
		fields : [ {
			name : 'id',
			type : 'string'
		}, {
			name : 'text',
			type : 'string'
		},${modelStr} ]
	});
	</#if>
	<#if store == "">
	var ${name}TreeStore = new Ext.data.TreeStore({
		<#if modelStr == "">
		model : 'treeMode',
		<#else>
		model : '${name}treeMode',
		</#if>
		proxy : {
			type : 'ajax',
			url : '${url}'
		},
		root : {
			text : '${rootText}',
			id : '${rootId}',
			expanded : ${rootExpand}
		},
		listeners : {
		   	'beforeload' : function(store, options){
		   		<#if applyName != "">
		   		try{
	    			Ext.apply(store.proxy.extraParams, ${applyName}());
	    		}catch(e){
	    			console.log(e);	
	    		}
	    		</#if>
		    }
	    },            
		autoLoad:${autoLoad}
	});
	<#else>
	${name}TreeStore = ${store};
	</#if>
	var ${name}Tree = Ext.create('Ext.tree.Panel', {
		store :  ${name}TreeStore,
		rootVisible : ${rootVisible},		
		title : '${title}',
		autoHeight:true,
		width : ${width},	
		useArrows : ${useArrows},
		autoWidth : false,
		autoScroll : false,
		animate : false,
		border : false,
		containerScroll : true,
		<#if toolbarStr !="">
		tbar : Ext.create('Ext.toolbar.Toolbar', {layout: {overflowHandler: 'Menu'},items: [${toolbarStr}]}),
		</#if>
		listeners : {
			<#if clickEvent=="true">
			'itemclick' : function(view, re, item, index, e, eOpts) {
				view.expand(re);
                ${name}ItemClick(view, re, item, index, e, eOpts);
			}
			</#if>
			<#if dblClickEvent=="true">
			<#if clickEvent=="true">,</#if>
			'itemdblclick' : function(view, record, item, index, e, eOpts) {
                ${name}ItemDblClick(view, record, item, index, e, eOpts);
			}
			</#if>
		}
	});
		
</#macro>

<#-- 列表定义 -->
<#macro defineStore url name fieldStr autoLoad="true" pageSize=20  rootItem="items" remoteSort="false"
	totalProperty="total" sorters=""  groupField="" maskFlag="true" enablePage="true" 
	applyName="getParams" collectionName="" collectionKey="" smName="" >
    Ext.define('${name}Data', {
		extend : 'Ext.data.Model',
		fields : [ ${fieldStr} ]		
	});
	 // 创建数据源
    var ${name}GridStore = Ext.create('Ext.data.Store', {
        model: '${name}Data',                          
        pageSize: ${pageSize},   
        storeId: '${name}GridStore', 
        remoteSort : ${remoteSort},                                                      
        proxy: {                                                                                                  
            type: 'ajax',
            url: '${url}',                                                                                   
            reader: {                                                                                             
                type: 'json',                                                                                     
                root: '${rootItem}',                
                totalProperty  : '${totalProperty}'                                                                                  
            }
        },  
        listeners : {
		   	'beforeload' : function(store, options){
		   		<#if enablePage == "true" && applyName != "">
		   		try{
		   			<#if collectionKey != "">
		   				store.each(function(rec){
							if(${smName}.isSelected(rec)){
								${collectionName}.add(rec.get("${collectionKey}"),rec);
							}else{
								${collectionName}.remove(${collectionName}.get(rec.get("${collectionKey}")));
								Ext.util.Observable.capture(${smName},function(eventName){
									if(eventName == 'deselect'){
										return false;
									}
								});
							}		   				
		   				});
		   			</#if>
	    			Ext.apply(${name}GridStore.proxy.extraParams, ${applyName}());
	    		}catch(e){}
	    		</#if>
		    },
		    'load':function(store, records, options){
		    	<#if collectionKey != "">
		    	var total = store.getCount();
		    	for(var i = 0; i < total; i++){
		    		var rec = store.getAt(i);
		    		if(${collectionName}.containsKey(rec.get("${collectionKey}"))){
		    			${smName}.select(i, true, false);
		    		}
		    	}
		    	</#if>
		    }
	    },                                                                                                            
        autoLoad: ${autoLoad}
        <#if sorters!="">
		   , sorters: ${sorters}
		</#if>
		<#if groupField!="">
		   , groupField: ${groupField}
		</#if>                                                                                            
    });  
</#macro>


<#-- 列表定义 注:maskFlag属性已经废弃,2013-10-15系统切换至extjs4.1.1，已经无需自定义grid加载提示条了 -->
<#macro defineGrid url name fieldStr colStr toolbarStr actionType="none" title="" enablePage="true" 
  	height=0 width=0  autoLoad="true" isRowEdit="false" pageSize=50 itemdblclick="true" renderTo=""
    gridCheckOnly="false" rootItem="items"  totalProperty="total" mulSel="true" sorters=""  groupField="" 
    checkbox="true" enableColumnHide="false" singleSelect="false" enableColumnMove="false" plugins="" 
    maskFlag="true" panelClass="Ext.grid.Panel" customBars = "" 
    applyName="getParams" remoteSort="false" 
    collectionKey="" >
    var ${name}Collection = new Ext.util.MixedCollection();
    var ${name}Sm = Ext.create('Ext.selection.CheckboxModel' ,{
		<#assign ss = 0 />
		<#if gridCheckOnly=="true">
			checkOnly:true
			<#assign ss = ss + 1 />
		</#if>
		<#if singleSelect=="true">
		<#assign collectionKey =""/>
		<#if ss != 0>,
		</#if>
		mode:'SINGLE'
		<#assign ss = ss + 1 />
		</#if>
		<#if collectionKey != "">
		<#if ss != 0>,
		</#if>
		multiSelect : true,
		listeners : {
			'select' : function(${name}Sm,colIndex,rowIndex){
				var record = ${name}Sm.getStore().getAt(rowIndex);
				${name}Collection.add(record.get("${collectionKey}"),record);
			},
			'deselect' : function(${name}Sm,colIndex,rowIndex){
				var record = ${name}Sm.getStore().getAt(rowIndex);
				${name}Collection.remove(${name}Collection.get(record.get("${collectionKey}")));
			}
		}
		<#assign ss = ss + 1 />
		</#if>
	});
    
    <@defineStore url=url name=name fieldStr=fieldStr autoLoad=autoLoad pageSize=pageSize remoteSort=remoteSort
          rootItem=rootItem totalProperty=totalProperty sorters=sorters groupField=groupField maskFlag=maskFlag 
          applyName=applyName collectionName= "${name}Collection" collectionKey=collectionKey smName="${name}Sm" /> 
    
    <#if isRowEdit=="true">         
	   	var ${name}CellEditing = Ext.create('Ext.grid.plugin.CellEditing', {
	        clicksToEdit: 1,
	    });
    </#if>
    
    var ${name}Grid = Ext.create('${panelClass}', {
        store: ${name}GridStore,
        enableColumnHide:${enableColumnHide},
        enableColumnMove :${enableColumnMove},
        columns: [       
        <#if actionType!="none">         
	      <@actioncolumn name=name actionType=actionType />
	      ,
        </#if>       
        ${colStr}               
        ],   
        <#if height==0>         
	    autoHeight : true,
	    <#else>
	    height : ${height},
        </#if>
        <#if plugins?exists && plugins != "">
        plugins : ${plugins},
        </#if>                 		
		<#if width != 0>         
	    width:${width},
	    autoWidth : false,  	
	    <#else>
	    autoWidth : true,      
        </#if>     
		autoScroll : true,
		border : false,
		<#if renderTo != "">
              renderTo: ${renderTo},   
        </#if>     
		containerScroll : true,
        title: '${title}',
         <#if isRowEdit=="true">         
          selModel: {
            selType: 'cellmodel'
          },
          plugins: [${name}CellEditing],
         </#if>
        frame: true,
        <#--当类型为 Ext.ux.LiveSearchGridPanel 是，customBars用来传入自定义工具条，显示于默认工具条之后-->
        <#if customBars != "">
        customBars : [${customBars}],
        <#else>
        tbar : Ext.create('Ext.toolbar.Toolbar', {layout: {overflowHandler: 'Menu'},items: [${toolbarStr}]}),
        </#if>              
        features: [{
        	ftype: 'summary'        	
        }
        <#if groupField!="">
		 ,{
            ftype: 'groupingsummary',
            groupHeaderTpl: '{name}',
            hideGroupedHeader: true,
            enableGroupingMenu: false
        }
		</#if>        
        ]
        <#if enablePage=="true">    
            ,      
	        dockedItems: [{
		        xtype: 'pagingtoolbar',
		        store: ${name}GridStore, 
		        dock: 'bottom',
		        displayInfo: true,
		        listeners : {
				   	'beforechange' : function() {
	                  
				    }
			    }
            }]
        </#if>
        <#if mulSel=="true" && checkbox == "true">         
         ,selModel: ${name}Sm
         </#if>   
         
    }); 
    <#if itemdblclick=="true">
     ${name}Grid.addListener('itemdblclick', function(obj, record, item, index, e, eOpts){
    	${name}GridItemdblclick(obj, record, item, index, e, eOpts);
     });
    </#if>
</#macro>


<#-- DATAVIEW定义 -->
<#macro defineView url name fieldStr imgBasePath="" imgStyle="" pageSize=20 imgWidth=64 fontSizeNum=12
	autoResize="false" showField="" pathField="" renderTo="" autoLoad="true" hidden="false" imgSmall="false" >
   Ext.define('${name}ViewData', {
		extend : 'Ext.data.Model',
		fields : [ ${fieldStr} ]
	});
	 // 创建数据源
    var ${name}ViewStore = Ext.create('Ext.data.Store', {
        model: '${name}ViewData',
        pageSize: ${pageSize},                                                                                              
        proxy: {                                                                                                             
            type: 'ajax',
            url: '${url}',                                                                                                                                                                                                     
            reader: {                                                                                             
                type: 'json',                                                                                     
                root: 'items',                
                totalProperty  : 'total'                                                                                  
            }                       
        },                                                                                                        
        autoLoad: ${autoLoad}                                                                                            
    }); 
    
	var ${name}Dataview = Ext.create('Ext.view.View', {
        deferInitialRefresh: false,
        store: ${name}ViewStore,
        tpl  : Ext.create('Ext.XTemplate',
            
            '<tpl for=".">',
                '<div class="phone" <#if autoResize=="true">style=" <#if imgSmall=="true">margin: 0px;height:22px;padding: 0px 0px;text-align:left;<#else>width:auto;height:auto;</#if>float:left;"</#if>>',
                    (!Ext.isIE6? '<img <#if imgSmall!="false">width="14px"<#else>width="${imgWidth}"</#if> src="${imgBasePath}{[values.${pathField}]}" />' :
                     '<div style="<#if imgSmall=="false">width:74px;height:74px;<#else>float:left;width:14px;height:14px;</#if>filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src=\'${imgBasePath}{[values.${pathField}]}\',sizingMethod=\'scale\')"></div>'),
                    <#if showField != "">
                    <#assign arr = showField?split(",") />
                    <#if arr?size == 1>
                    '<span style="font-size:${fontSizeNum}px;"><strong <#if imgSmall=="true">style="display:inline"</#if>>{${showField}}</strong></span>',
                    <#else>
                    '<strong><#list arr as k><div style="text-align:left;padding-left:10px">${action.getText(k)}:{${k}}</div></#list></strong>',
                    </#if>
                    </#if>
                '</div>',
            '</tpl>'           
        ),      
        cls:'phones',
        hidden:${hidden},
        itemSelector: 'div.phone',
        overItemCls : 'phone-hover',
        multiSelect : false,
        autoScroll  : true,
        autoHeight : true,
        
        listeners : {
			'itemclick' : function(view, re,item,index,e,eOpts) {
                ${name}ViewItemClick(view, re,item,index,e,eOpts);
			},
			'itemdblclick' : function(view, re,item,index,e,eOpts) {
                ${name}ViewItemDbClick(view, re,item,index,e,eOpts);
			}
		}		
		<#if renderTo == "">
                ,renderTo: Ext.getBody()    
        </#if> 
    });  
</#macro>

<#-- 树列表定义 -->
<#macro defineTreeGrid url name fieldStr colStr toolbarStr="" title="" >    
    Ext.define('${name}TreeGridMode', {
        extend: 'Ext.data.Model',
        fields: [${fieldStr}]
    });

    var ${name}TreeGridStore = Ext.create('Ext.data.TreeStore', {
        model: '${name}TreeGridMode',
        proxy: {
            type: 'ajax',            
            url: '${url}'
        },     
        folderSort : false
    });
        
    var ${name}TreeGrid = Ext.create('Ext.tree.Panel', {
        title: '${title}',
        height : 900,
		autoWidth : true,		 		
		autoScroll : true,          
        collapsible: false,
        border:false,
        useArrows: true,
        rootVisible: false,
        store: ${name}TreeGridStore,
        multiSelect: false,
        singleExpand: true,        
        columns: [${colStr}],
        listeners : {
			'itemclick' : function(view, re) {
               if (re) {						 								 
						  ${name}TreeGrid_ItemClick(view, re);						 												 
			           }
			}
		},
        tbar : Ext.create('Ext.toolbar.Toolbar', {layout: {overflowHandler: 'Menu'},items: [${toolbarStr}]})
    });

</#macro>


<#-- 窗体定义 -->
<#macro defineForm  name  itemStr toolbarStr disableEdit="0" timeout=30 autoHeight="true" height=400 title="" labelAlign="right" hidden="false" trackResetOnLoad="false"  renderTo="">	
   var ${name}Form = Ext.create('Ext.form.Panel', {           
        title:'${title}', 
        frame:true,
        timeout:${timeout},
		<#if autoHeight=="true">
		  autoHeight : true,
		<#else>
		  height : ${height}, 
		</#if> 
        trackResetOnLoad : ${trackResetOnLoad},
		autoWidth : true,
		    
		hidden:${hidden},
		<#if renderTo!="">
		 renderTo:${renderTo},
		</#if>
        border : false,                
        autoScroll : true,
        bodyStyle:'padding:5px 5px 0',        
        fieldDefaults: {
            msgTarget: 'side',            
            labelAlign: '${labelAlign}',
            labelWidth: 80            
            <#if disableEdit=="1">
		     ,readOnly:true		
		    </#if> 
        },
        defaultType: 'textfield',
        defaults: {
            anchor: '98%'
        },
        items: [${itemStr}]
        <#if toolbarStr!="">
		,tbar: Ext.create('Ext.toolbar.Toolbar', {layout: {overflowHandler: 'Menu'},items: [${toolbarStr}]})
		</#if> 
    });
</#macro>


<#-- 下拉树模板 -->
<#macro defineTreeComb url name id store="" afterSubTpl="" fieldLabel="" useArrows="false" beforeExpand="false" autoLoad="true" flex=1 labelWidth=80 emptyText="" width = "250" model="" labelAlign='right' allowBlank = "false" curPre="">
 var ${name}TreeComboBox = Ext.create('Ext.form.field.ComboBox', {
 		<#if flex != 0>
 		flex:${flex},
 		</#if>
 		<#assign flabel = fieldLabel />
	    <#if allowBlank == "false">
	    	<#assign flabel = flabel + "<span style=color:red>*</span>" />
	    </#if>  
        fieldLabel: '${flabel}',  
        emptyText:'${emptyText}',
        name:'${name}',
        anchor : '98%', 
        labelAlign:'${labelAlign}', 
        labelWidth:${labelWidth},            
        editable : false,
        allowBlank : ${allowBlank},
        afterSubTpl:'${afterSubTpl}',
        hideEmptyLabel : true,
        typeAhead: false,                   
        width:${width},
        autoHeight : true,
        store : new Ext.data.SimpleStore({
					fields : [],
					data : [[]]
				}),
        queryMode: 'local',
        listConfig: {
            getInnerTpl: function() {               
                return '<div id="${name}TreeDiv" style="width:500px" ></div>';
            }
        }
    });
	// 监听下拉框的下拉展开事件
	${name}TreeComboBox.on('expand', function() {	 
		 <#if beforeExpand=="false">
		 <#if autoLoad=="false">     
		 ${name}TreeStore.proxy.url="${url}";
		 </#if>
         ${name}TreeStore.load();
         <#else>
         <#--如果需要自己定义下拉时如何加载数据，需设置beforeExpand为true-->
         ${name}TreeComboBox_beforeExpand();
         </#if>
         if(isEmpty(Ext.getDom("${name}TreeDiv").innerHTML)){
             // 将UI树挂到treeDiv容器
	         ${name}Tree.render('${name}TreeDiv');	
         }
	});
	
	 <#if model!="">
		Ext.define('${name}TreeCombMode', {
			extend : 'Ext.data.Model',
			fields : [ ${model} ]
		});
	</#if>
	<#if store == "">	
	var ${name}TreeStore = new Ext.data.TreeStore({
            <#if model!="">
                model:'${name}TreeCombMode',
            </#if>				
			proxy : {
				type : 'ajax',
				url : '<#if autoLoad=="false">blank<#else>${url}</#if>'
			},
			root : {
				text : 'Ext JS',
				id : '0',
				expanded : true
			},
			autoLoad:${autoLoad}
	   })
	 <#else>
	 var ${name}TreeStore = ${store};
	 </#if>		
	var ${name}Tree = Ext.create('Ext.tree.Panel', {
		store :${name}TreeStore,
		rootVisible : false,			
		useArrows : ${useArrows},	
		height: 200,
		autoWidth : true,    
		autoScroll : true,
		animate : false,
		border : false,		
		listeners : {
			'itemclick' : function(view, re) {
               if (re) {
               		 <#--此处代码顺序不能变，否则${name}TreeComboBox_itemclick方法中将无法取到此控件的值-->
               		 ${name}TreeComboBox.setValue(re.get('text'));	
					 if (!isEmpty(${curPre}Form.form.findField('${id}'))) {
					     ${curPre}Form.form.findField('${id}').setValue(re.data.id);
					 }
                     try{
                     	${name}TreeComboBox_itemclick(view, re);
                     }catch(e){}
					 // 关闭tree
					 ${name}TreeComboBox.collapse();
				   }
			}
		}
	});
</#macro>


<#--下拉Grid定义 -->
<#macro defineComboGrid name fieldStr colStr toolBar valueField displayField store="" fieldLabel="" emptyText=""
			allowBlank="false" pageSize = 30 labelWidth=80 rootItem="items" labelAlign="left" totalProperty="total" 
			multiSelect="false" width=250 url="#" gridWidth=400 gridHeight=300>
    
    <#if store=="">		 
		Ext.define('${name}ComboGridData', {
			extend : 'Ext.data.Model',
			fields : [ ${fieldStr} ]
		});
		var ${name}ComboGridStore = new Ext.data.Store({
			pageSize : ${pageSize},
			autoLoad : false,
			model: '${name}ComboGridData',
			proxy : {
				type : 'ajax',
				<#--定义为#，当点击下拉列表时在show${name}Combo方法里动态传入，-->
				url : '${url}',
				reader : {
					type : 'json',
					root : '${rootItem}',
					totalProperty : '${totalProperty}'
				}
			}
		});		 		 
    <#else>
         var ${name}ComboGridStore = ${store};
	</#if>
        									
	var ${name}GridComboBox = new Ext.form.field.GridComboBox({
		flex:1,
		<#assign flabel = fieldLabel />
	    <#if allowBlank == "false">
	    	<#assign flabel = flabel + "<span style=color:red>*</span>" />
	    </#if>
		fieldLabel : '${flabel}',
		labelAlign : '${labelAlign}',
		labelWidth : ${labelWidth},
		multiSelect : ${multiSelect},
		displayField:'${displayField}',
        valueField:'${valueField}',
        allowBlank:${allowBlank},
        emptyText:'${emptyText}',
		width : ${width},
		name:'${name}',
		store : ${name}ComboGridStore,
		queryMode : 'remote',
		matchFieldWidth : false,
		pickerAlign : 'bl',
		editable : false,
		gridCfg : {
			store : ${name}ComboGridStore,
			<#if multiSelect=="true">
			selModel : new Ext.selection.CheckboxModel({
				checkOnly: true
			}),
			</#if>
			height : ${gridHeight},
			width : ${gridWidth},
			columns : [${colStr}],
			tbar:Ext.create('Ext.toolbar.Toolbar', {layout: {overflowHandler: 'Menu'},items: [${toolBar}]}),
			bbar : Ext.create('Ext.PagingToolbar', {
				store :  ${name}ComboGridStore,
				displayInfo : true
			})
		}
	});
	${name}GridComboBox.on('expand', function() {	
		try{   	    
		${name}GridComboBoxExpand();
		}catch(e){}
	});

</#macro>



<#--定义一个获取后台数据的下拉列表 name:名称，fieldLabel:字段标签,pageSize：页大小 
	hiddenId:下拉列表字段对应的隐藏域字段ID
	必须重写的方法 ${name}GridComboBoxExpand();	
-->
<#macro defineRemotCombo fieldStr name url displayField valueField labelWidth=80 flex=1 
		idProperty="" anchor="" editable="false" allowBlank="false" store="" autoLoad="true" emptyText="" 
		fieldLabel="标题" pageSize = 50  width=250 hideEmptyLabel="false"
		multiSelect ="false" afterSubTpl="">
    <#if store=="">		 
		Ext.define("${name}RemotComboData", {
	        extend: 'Ext.data.Model',
	        fields: [${fieldStr}]
	    });
		var ${name}RemotComboStore = Ext.create('Ext.data.Store', {
	        model: '${name}RemotComboData',                          
	        pageSize: ${pageSize},                                                                
	        proxy: {                                                                                                  
	            type: 'ajax',            
	            url: '${url}',                                                                                   
	            reader: {                                                                                             
	                type: 'json',                                                                                     
	                root: 'items',                
	                totalProperty  : 'total'
	                
	                <#if idProperty!="">
	                ,
	                idProperty: '${idProperty}'    
	                </#if>	                                                                                                          
	            }
	        },                                                                                                        
	        autoLoad: ${autoLoad}                                                                                            
	    }); 	 		 
    <#else>
         var ${name}RemotComboStore = ${store};
	</#if>
	<#assign flabel = fieldLabel />
    <#if allowBlank == "false">
    	<#assign flabel = flabel + "<span style=color:red>*</span>" />
    </#if>        
    var ${name}RemotCombo = Ext.create('Ext.form.field.ComboBox', {
    	flex:${flex},
        fieldLabel: '${flabel}',
        <#if fieldLabel == "">
        hideEmptyLabel:${hideEmptyLabel},
        </#if>
        labelAlign:'right',  
        name:'${name}',
        displayField: '${displayField}',
        store:${name}RemotComboStore,
        <#if anchor != "">
        anchor:'${anchor}',
        <#else>
        width:${width},
        </#if>
        typeAhead: false,
        allowBlank: ${allowBlank},
        editable:${editable},
        hideTrigger:false,     
        emptyText:'${emptyText}',   
        valueField:'${valueField}',
        labelWidth:${labelWidth},
        multiSelect : ${multiSelect},
        <#if afterSubTpl != "">
        afterSubTpl : '${afterSubTpl}',
        </#if>
        listConfig: {
        	emptyText: '<@s.text name="Nomatchingdatafound" />'           
        },        
        listeners:{
           'change':function(b, newValue, oldValue){
           		try{
        		${name}RemotComboChange(b, newValue, oldValue);
        		}catch(e){}
	        },
	       'expand':function(){
	       		try{
	       			${name}RemotComboExpand();
	       		}catch(e){}
	        } 
        }                
       
        
    });	
</#macro>


<#-- 窗体定义 -->
<#macro defineUploadForm itemStr title="${action.getText('FileUpload')}"  url="upload.gx" name="uplad">	
   var ${name}UploadForm =  Ext.create('Ext.form.Panel', {
        renderTo: Ext.getBody(),
        width: 300,
        frame: true,
        hidden:true,
        title: '${title}',
        bodyPadding: '10 10 0',
        x: 60,
        y: document.body.clientWidth / 15,       
        defaults: {
            anchor: '100%',
            allowBlank: false,
            msgTarget: 'side',            
            labelWidth: 50
        },

        items: [${itemStr}],

        buttons: [{
            text: '<@s.text name="btUpload" />',
            handler: function(){                
                ${name}UploadFormUpload();
      
            }
        },{
            text: '<@s.text name="btReset" />',
            handler: function() {
                this.up('form').getForm().reset();
            }
        },{
            text: '<@s.text name="btClose" />',
            handler: function() {
                this.up('form').hide();
            }
        }]
    });
</#macro>

<#macro defineSubmitCheck step map>	

 <#if map.get("fchkModel") == "1">   
 	<@CommonMacro.defineComboGrid name="submit_nextEmp" colStr="${map.empCol}" toolBar="${map.empToolBar}" displayField="fempName" valueField="fempId"
    		fieldLabel="${action.getText('AppointResolveEmploy')}" labelAlign="right" fieldStr="${map.empFieldStr}" pageSize=20 rootItem="rows" />
    		
    function submit_nextEmpGridComboBoxExpand(){
		submit_nextEmpComboGridStore.proxy.url="/baseinfos/listOndutyByEmploy.gx";	
		submit_nextEmpComboGridStore.load();
	}
	function employComboQuery(){
		var query_employ = "";
        if (!isEmpty($("query_employ"))) {
            query_employ = $("query_employ").value;
        }
        submit_nextEmpComboGridStore.load({
			params:{
				queryParam:query_employ
			}
		});
	}
 </#if>
var submitCheckForm = Ext.create('Ext.form.Panel', {           
		autoHeight : true,
		autoWidth : true,    
        border : false,                
        autoScroll : true,
        bodyStyle:'padding:5px 5px 0',        
        fieldDefaults: {
            msgTarget: 'side',
            labelAlign: 'right',
            labelWidth: 80
        },
        defaultType: 'textfield',
        defaults: {
            anchor: '98%'
        },
        items:[
        	{xtype:"hidden",name:"wait_check_id"},
        	{xtype:'displayfield',width:350,fieldLabel:'<@s.text name="fchkModel" />',value:'${system_code_desc.get('CHECKMODEL').get(map.get('fchkModel'))}'},
			<#if map.get("fchkModel") == "1">
			{xtype:'displayfield',width:350,fieldLabel:'${system_code_desc.get('FLOWSTEPTYPE').get('2')}',value:'${step.fchkName}'},
			{xtype:"radiofield",name:"submit_action",inputValue:"0",fieldLabel:"<@s.text name="ResolveModel" />",boxLabel:"<@s.text name="SendToEndDirect" />"},
			{labelSeparator:"-",hideEmptyLabel:false,xtype:"radiofield",name:"submit_action",inputValue:"1",fieldLabel:"",boxLabel:"<@s.text name="AppointResolveEmploy" />",checked:true},
			 submit_nextEmpGridComboBox
			<#else>
			{xtype:'displayfield',width:350,fieldLabel:'${system_code_desc.get('FLOWSTEPTYPE').get('0')}',value:'${step.fchkName}'}
			</#if>
        ]
    });
    <#if map.get("fchkModel") == "1">
    $("submit_next_action0").addListener('change', function(){
    	if(this.checked){
    		submit_nextEmpGridComboBox.disabled=true;
    		submit_nextEmpGridComboBox.hide();
    	}else{
    		submit_nextEmpGridComboBox.show();
    		submit_nextEmpGridComboBox.disabled=false;
    	}
    });
    </#if>
    var submitWindow = Ext.create('Ext.Window', {
        title: '<@s.text name="btSubmit" />',
        width: 400,
        height:260,
        border : false,
        x: 20,
        modal:true,
        y: document.body.clientWidth / 15,
        resizable : true,
		draggable : true,
		closeAction : 'close',
        plain: true,
        layout: 'fit',
        items : [submitCheckForm],
        buttons : [
        	{
        		text:'<@s.text name="btSubmit" />',
        		iconCls:'acceptIcon',
        		handler:function(){
        			submit_btSubmit_OnClick();
        		}
        	},{text:'<@s.text name="btClose" />',iconCls:'deleteIcon',handler:function(){$("submitWindowId").hide();}}
        ]
    });
    
</#macro>


<#macro defineCheck step map biz hisFieldStr hisColStr  customfieldstr = "">	
<@CommonMacro.defineGrid url="/baseinfos/getCheckHisByCheck.gx?checkEntityId=${map.wait_check_id}&bizCode=${biz.fbizCode}" name="chkhis" title="" enablePage="false"
                 fieldStr="${hisFieldStr}" colStr="${hisColStr}" mulSel="false" toolbarStr="" itemdblclick="false" height=200/>
<#if biz.fchkModel == "1">
		<#--自由审批模式start-->
			<#if !step.rpcheck?exists>
			<#--如果当前节点不是结束节点，则表示可以自由选择下一步开始-->
				<@CommonMacro.defineComboGrid name="nextEmp" colStr="${map.empCol}" toolBar="${map.empToolBar}" displayField="fempName" valueField="fempId"
		    		fieldLabel="指定交办人" fieldStr="${map.empField}" pageSize=20 rootItem="rows" />
		    	function nextEmpGridComboBoxExpand(){
					nextEmpComboGridStore.proxy.url="/baseinfos/listOndutyByEmploy.gx";	
					nextEmpComboGridStore.load();
				}
				function employComboQuery(){
					var query_employ = "";
			        if (!isEmpty($("query_employ"))) {
			            query_employ = $("query_employ").value;
			        }
			        nextEmpComboGridStore.load({
						params:{
							queryParam:query_employ
						}
					});
				}
				var checkForm = Ext.create('Ext.form.Panel', {           
			        frame:true,
					autoHeight : true,
			        trackResetOnLoad : false,
					autoWidth : true,    
			        border : false,                
			        autoScroll : true,
			        bodyStyle:'padding:5px 5px 0',        
			        fieldDefaults: {
			            msgTarget: 'side',
			            labelAlign: 'right',
			            labelWidth: 80
			        },
			        defaultType: 'textfield',
			        defaults: {
			            anchor: '98%'
			        },
			        items: [
			        	<#if customfieldstr?exists && customfieldstr != "">
			        	${customfieldstr},
			        	</#if>
			        	{xtype:"hidden",value:"${map.wait_check_id}",name:"wait_check_id"},
			        	{xtype:"displayfield",fieldLabel:'<@s.text name="curChkName" />',value:"${step.fchkName}",name:"curChkName"},
			        	{xtype:"radiofield",name:"submit_action",inputValue:"0",fieldLabel:"交办模式",boxLabel:"直接交办给结束节点"},
						{labelSeparator:"-",hideEmptyLabel:false,xtype:"radiofield",name:"submit_action",inputValue:"1",fieldLabel:"",boxLabel:"指定交办人",checked:true},
						 nextEmpGridComboBox,
			        	{xtype:"textarea",fieldLabel:'<@s.text name="fcheckIdea" />',name:"fcheckIdea"},
			        	{xtype:"hidden",name:"direct"},
			        	{
			        		xtype:'panel',
			        		layout:'fit',
			        		title:'<@s.text name="btChkhis" />',
			        		items:[
			        			chkhisGrid
			        		]
			        	}
			        ],
					buttons : [
			        	{
			        		text:'<@s.text name="btCheck" />',
			        		iconCls:'acceptIcon',
			        		handler:function(){
			        			check_btCheck_OnClick();
			        		}
			        	},{
			        		text:'<@s.text name="btRefuse" />',
			        		iconCls:'deleteIcon',
			        		handler:function(){
			        			refuse_btCheck_OnClick();
			        		}
			        	},
			        	{text:'<@s.text name="btClose" />',iconCls:'deleteIcon',handler:function(){$('checkWindow').hide();}}
			        ]
			    });
			     $("next_action0").addListener('change', function(){
			    	if(this.checked){
			    		nextEmpGridComboBox.disabled=true;
			    		nextEmpGridComboBox.hide();
			    	}else{
			    		nextEmpGridComboBox.show();
			    		nextEmpGridComboBox.disabled=false;
			    	}
			    });
			    <#--如果当前节点不是结束节点，则表示可以自由选择下一步end-->
			<#else>
				<#--如果当前节点是结束节点，则表示下一步为结束st-->
				var checkForm = Ext.create('Ext.form.Panel', {           
			        frame:true,
					autoHeight : true,
			        trackResetOnLoad : false,
					autoWidth : true,    
			        border : false,                
			        autoScroll : true,
			        bodyStyle:'padding:5px 5px 0',        
			        fieldDefaults: {
			            msgTarget: 'side',
			            labelAlign: 'right',
			            labelWidth: 80
			        },
			        defaultType: 'textfield',
			        defaults: {
			            anchor: '98%'
			        },
			        items: [
			        	<#if customfieldstr?exists && customfieldstr != "">
			        	${customfieldstr},
			        	</#if>
			        	{xtype:"hidden",value:"${map.wait_check_id}",name:"wait_check_id"},
			        	{xtype:"displayfield",fieldLabel:'<@s.text name="curChkName" />',value:"${step.fchkName}",name:"curChkName"},
			        	{xtype:"displayfield",fieldLabel:'<@s.text name="fchkNext" />',name:"nextChkName",value:'${action.getText("CheckOver")}'},
			        	{xtype:"textarea",fieldLabel:'<@s.text name="fcheckIdea" />',name:"fcheckIdea"},
			        	{xtype:"hidden",name:"direct"},
			        	{
			        		xtype:'panel',
			        		layout:'fit',
			        		title:'<@s.text name="btChkhis" />',
			        		items:[
			        			chkhisGrid
			        		]
			        	}
			        ],
					buttons : [
			        	{
			        		text:'<@s.text name="btCheck" />',
			        		iconCls:'acceptIcon',
			        		handler:function(){
			        			check_btCheck_OnClick();
			        		}
			        	},{
			        		text:'<@s.text name="btRefuse" />',
			        		iconCls:'deleteIcon',
			        		handler:function(){
			        			refuse_btCheck_OnClick();
			        		}
			        	},
			        	{text:'<@s.text name="btClose" />',iconCls:'deleteIcon',handler:function(){$('checkWindow').hide();}}
			        ]
			    });
			    <#--如果当前节点是结束节点，则表示下一步为结束end-->
	    	</#if>
	    	<#--自由审批模式end-->	   
		<#else>
		<#--固定审批模式start-->
			
			var checkForm = Ext.create('Ext.form.Panel', {           
			        frame:true,
					autoHeight : true,
			        trackResetOnLoad : false,
					autoWidth : true,    
			        border : false,                
			        autoScroll : true,
			        bodyStyle:'padding:5px 5px 0',        
			        fieldDefaults: {
			            msgTarget: 'side',
			            labelAlign: 'right',
			            labelWidth: 80
			        },
			        defaultType: 'textfield',
			        defaults: {
			            anchor: '98%'
			        },
			        items: [
			        	<#if customfieldstr?exists && customfieldstr != "">
			        	${customfieldstr},
			        	</#if>
			        	{xtype:"hidden",value:"${map.wait_check_id}",name:"wait_check_id"},
			        	{xtype:"displayfield",fieldLabel:'<@s.text name="curChkName" />',value:"${step.fchkName}",name:"curChkName"},
			        	{xtype:"displayfield",fieldLabel:'<@s.text name="fchkNext" />',name:"curChkName",value:'${(step.rpcheck.next.fchkName)?default(action.getText("CheckOver"))}'},
			        	{xtype:"textarea",fieldLabel:'<@s.text name="fcheckIdea" />',name:"fcheckIdea"},
			        	{xtype:"hidden",name:"direct"},
			        	{
			        		xtype:'panel',
			        		layout:'fit',
			        		title:'<@s.text name="btChkhis" />',
			        		items:[
			        			chkhisGrid
			        		]
			        	}
			        ],
					buttons : [
			        	{
			        		text:'<@s.text name="btCheck" />',
			        		iconCls:'acceptIcon',
			        		handler:function(){
			        			check_btCheck_OnClick();
			        		}
			        	},{
			        		text:'<@s.text name="btRefuse" />',
			        		iconCls:'deleteIcon',
			        		handler:function(){
			        			refuse_btCheck_OnClick();
			        		}
			        	},
			        	{text:'<@s.text name="btClose" />',iconCls:'deleteIcon',handler:function(){$('checkWindow').hide();}}
			        ]
			    });
		</#if>
</#macro>


<#macro defineArea width=220 flex=1 provinceName="fprovince" cityName="fcity" allowBlank="false" labelWidth=80>	
Ext.define("${provinceName}RemotComboData", {
    extend: 'Ext.data.Model',
    fields: [{name:'areacode',type:'string',dateFormat:''},{name:'areaname',type:'string',dateFormat:''}]
});
var ${provinceName}RemotComboStore = Ext.create('Ext.data.Store', {
    model: '${provinceName}RemotComboData',                          
    pageSize: 50,                                                                
    proxy: {                                                                                                  
        type: 'ajax',            
        url: '/baseinfos/getDataByArea.gx',                                                                                   
        reader: {                                                                                             
            type: 'json',                                                                                     
            root: 'items',                
            totalProperty  : 'total'
        }
    },                                                                                                        
    autoLoad: true                                                                                            
}); 	 		 
var ${provinceName}RemotCombo = Ext.create('Ext.form.field.ComboBox', {
	flex:${flex},
    fieldLabel: '省',
    labelAlign:'right',  
    name:'${provinceName}',
    displayField: 'areaname',
    store:${provinceName}RemotComboStore,
    width:${width},
    typeAhead: false,
    allowBlank:${allowBlank},
    editable:false,
    hideTrigger:false,     
    emptyText:'',   
    valueField:'areacode',
    labelWidth:${labelWidth},
    listConfig: {
    	emptyText: '没有找到匹配的数据！'           
    },        
    listeners:{
       'change':function(b, newValue, oldValue){
    		$('${cityName}').setValue('');        
			${cityName}RemotComboStore.proxy.url= '/baseinfos/getDataByArea.gx?areacode='+newValue;
			${cityName}RemotComboStore.load();    
        }
    }                
});	
Ext.define("${cityName}RemotComboData", {
    extend: 'Ext.data.Model',
    fields: [{name:'areacode',type:'string',dateFormat:''},{name:'areaname',type:'string',dateFormat:''}]
});
var ${cityName}RemotComboStore = Ext.create('Ext.data.Store', {
    model: '${cityName}RemotComboData',                          
    pageSize: 80,                                                                
    proxy: {                                                                                                  
        type: 'ajax',            
        url: '/baseinfos/getDataByArea.gx?queryCity=1',                                                                                   
        reader: {                                                                                             
            type: 'json',                                                                                     
            root: 'items',                
            totalProperty  : 'total'
        }
    },                                                                                                        
    autoLoad: false                                                                                            
}); 	 		 
var ${cityName}RemotCombo = Ext.create('Ext.form.field.ComboBox', {
	flex:${flex},
    fieldLabel: '市',
    labelAlign:'right',  
    name:'${cityName}',
    displayField: 'areaname',
    store:${cityName}RemotComboStore,
    width:${width},
    typeAhead: false,
    allowBlank:${allowBlank},
    editable:false,
    hideTrigger:false,     
    emptyText:'',   
    valueField:'areacode',
    labelWidth:${labelWidth},
    listConfig: {
    	emptyText: '没有找到匹配的数据！'           
    }           
});	
</#macro>	  

<#macro defineSearch itemStr toolbarStr searchscripts>
	<@CommonMacro.defineForm name="search" title="" labelAlign='right' 
                 itemStr="${itemStr}"  toolbarStr="${toolbarStr}" />
	${searchscripts} 
</#macro>


<#--新的审批提交宏，自由模式，由客户自行决定什么时候结束 hubo 2013-06-24-->
<#macro defineNewSubmitCheck step map>	
     <#--员工资料grid参数载入-->
     function getSubmitEmployParams(){
		var submit_query_employ_name = $("submit_query_employ_name").getValue();
		var params={
			query_fempNo : submit_query_employ_name
		};
		return params;
	}
	<#assign tbar = "{xtype:'textfield',hideEmptyLabel:true,width:150,name:'query_employ_name'}," />                 
	<#assign tbar = tbar + uiCreater('toolbar', 'btQuery,btReset,btClose', 'submit_employ') />
	<@CommonMacro.defineGrid url="/baseinfos/getDataBySysuser.gx" name="submit_employ" title="" 
            fieldStr="${uiCreater('field', 'com.gx.facade.ui.common.RpsysuserUi', '')}"
            colStr="${uiCreater('column', 'com.gx.facade.ui.common.RpsysuserUi', '', 'grid', 'submit_employ')}"
            toolbarStr=tbar autoLoad="false" applyName="getSubmitEmployParams" singleSelect="true" 
            checkbox="false"/>
           <#-- {xtype:'textfield',hideEmptyLabel:true,flex:1,name:'query_employ_name'},
	           	${uiCreater('toolbar', 'btQuery,btReset,btClose', 'submit_employ')}
	           	-->
	           	<#--
	           	{anchor:'98%',xtype:'button',text:'<@s.text name="btQuery" />',iconCls:'previewIcon',handler:function(){submit_employGridStore.load();}},
	           	{anchor:'98%',xtype:'button',text:'<@s.text name="btReset" />',iconCls:'tbar_synchronizeIcon',handler:function(){resetSubmitEmployQuery()}},
	           	{anchor:'98%',xtype:'button',text:'<@s.text name="btClose" />',iconCls:'deleteIcon',handler:function(){submitEmployWindow.hide();}},
	           	-->
	function submit_employ_btQuery_OnClick(){
		submit_employGridStore.load();
		$("submit_query_employ_name").focus();
	}
	function submit_employ_btReset_OnClick (){
		$("submit_query_employ_name").setValue('');
		$("submit_query_employ_name").focus();
	}
	function submit_employ_btClose_OnClick (){
		submitEmployWindow.hide();
	}
    var submitEmployWindow = Ext.create('Ext.Window', {
        title: '<@s.text name="Choose" /><@s.text name="Employ" />',
        width: 700,
        height:400,
        border : false,
        x: 20,
        modal : true,
        y: document.body.clientWidth / 15,
        resizable : true,
		draggable : true,
		closeAction : 'close',
        plain: true,
        layout:'fit',
        items:[submit_employGrid]
    });
    $("submit_query_employ_name").addListener(
		'specialkey' , 
		function(field, e) {
		  	if (e.getKey() == Ext.EventObject.ENTER) {
				submit_employGridStore.load();
			}
		}
	);
    <#--打开员工资料选择窗口--> 
    function openSubmitEmployWindow(){
    	submitEmployWindow.show();
    	if(submit_employGridStore.count() == 0){
    		submit_employGridStore.load();
    	}
    }
    <#--员工资料行双击-->
    function submit_employGridItemdblclick (obj, record, item, index, e, eOpts){
    	$("submit_nextEmpName").setValue(record.data.username);
    	$("submit_nextEmp").setValue(record.data.sysuserid);
    	submitEmployWindow.hide();
    }               
var submitCheckForm = Ext.create('Ext.form.Panel', {           
		autoHeight : true,
		autoWidth : true,    
        border : false,                
        autoScroll : true,
        bodyStyle:'padding:5px 5px 0',        
        fieldDefaults: {
            msgTarget: 'side',
            labelAlign: 'right',
            labelWidth: 80
        },
        defaultType: 'textfield',
        defaults: {
            anchor: '98%'
        },
        items:[
        	{xtype:"hidden",name:"wait_check_id"},
			{flex:1,xtype:'fieldcontainer',fieldLabel:'选择交办人',combineErrors:true,msgTarget:'side',layout:'hbox',labelAlign:'right',defaults:{hideLabel:true},items:[{flex:1,afterSubTpl:'',xtype:'textfield',readOnly:true,allowBlank:false,name:'submit_nextEmpName',anchor:'98%',value:''},{xtype:'button',iconCls:'previewIcon',text:'',scale:'small',maxWidth:23,handler:function(){openSubmitEmployWindow();}}]},
			{xtype:'hiddenfield',name:'submit_nextEmp',value:''}
        ]
    });
    var submitWindow = Ext.create('Ext.Window', {
        title: '<@s.text name="btSubmit" />',
        width: 600,
        height:260,
        border : false,
        x: 20,
        modal:true,
        y: document.body.clientWidth / 15,
        resizable : true,
		draggable : true,
		closeAction : 'close',
        plain: true,
        layout: 'fit',
        items : [submitCheckForm],
        tbar : [
        	{
        		text:'<@s.text name="btSubmit" />',
        		iconCls:'acceptIcon',
        		handler:function(){
        			submit_btSubmit_OnClick();
        		}
        	},{text:'<@s.text name="btClose" />',iconCls:'deleteIcon',handler:function(){$("submitWindowId").hide();}}
        ]
    });
</#macro>

<#--新审批宏-->
<#macro defineNewCheck step map biz customfieldstr = "">	
<@CommonMacro.defineGrid url="/baseinfos/getCheckHisByCheck.gx?checkEntityId=${map.wait_check_id}&bizCode=${biz.fbizCode}" 
				name="chkhis" title="" enablePage="false"
                 fieldStr="${uiCreater('field', 'com.gx.facade.ui.rp.RpcheckUiDetail', 'Y-m-d H:i')}" 
                 colStr="${uiCreater('column',  'com.gx.facade.ui.rp.RpcheckUiDetail', 'Y-m-d H:i', 'grid', 'chk')}"
                  mulSel="false" toolbarStr="" checkbox="false" itemdblclick="false" />
	
     <#--员工资料grid参数载入-->
     function getCheckEmployParams(){
		var check_query_employ_name = $("check_query_employ_name").getValue();
		var params={
			query_fempNo : check_query_employ_name
		};
		return params;
	}     
	<#assign tbar = "{xtype:'textfield',hideEmptyLabel:true,width:150,name:'query_employ_name'}," />                 
	<#assign tbar = tbar + uiCreater('toolbar', 'btQuery,btReset,btClose', 'check_employ') />            
	<@CommonMacro.defineGrid url="/baseinfos/getDataBySysuser.gx" name="check_employ" title="" 
            fieldStr="${uiCreater('field', 'com.gx.facade.ui.common.RpsysuserUi', '')}"
            colStr="${uiCreater('column', 'com.gx.facade.ui.common.RpsysuserUi', '', 'grid', 'check_employ')}"
            toolbarStr=tbar autoLoad="false" applyName="getCheckEmployParams" singleSelect="true" 
            checkbox="false"/>
    function check_employ_btQuery_OnClick(){
		check_employGridStore.load();
		$("check_query_employ_name").focus();
	}
	function check_employ_btReset_OnClick (){
		$("check_query_employ_name").setValue('')
		$("check_query_employ_name").focus();
	}
	function check_employ_btClose_OnClick (){
		checkEmployWindow.hide();
	}     
	$("check_query_employ_name").addListener(
		'specialkey' , 
		function(field, e) {
		  	if (e.getKey() == Ext.EventObject.ENTER) {
				check_employGridStore.load();
			}
		}
	);     
    var checkEmployWindow = Ext.create('Ext.Window', {
        title: '<@s.text name="Choose" /><@s.text name="Employ" />',
        width: 700,
        height:400,
        border : false,
        x: 20,
        modal : true,
        y: document.body.clientWidth / 15,
        resizable : true,
		draggable : true,
		closeAction : 'close',
        plain: true,
        layout:'fit',
        items:[check_employGrid],
    });
    <#--打开员工资料选择窗口--> 
    function openCheckEmployWindow(){
    	checkEmployWindow.show();
    	if(check_employGridStore.count() == 0){
    		check_employGridStore.load();
    	}
    }
    <#--员工资料行双击-->
    function check_employGridItemdblclick (obj, record, item, index, e, eOpts){
    	$("check_nextEmpName").setValue(record.data.username);
    	$("check_nextEmp").setValue(record.data.sysuserid);
    	checkEmployWindow.hide();
    }  
	var checkForm = Ext.create('Ext.form.Panel', {           
        frame:true,
        timeout : 600,
        trackResetOnLoad : false,
        autoHeight : true,
        border : false,                
        autoScroll : true,
        bodyStyle:'padding:5px 5px 0',        
        fieldDefaults: {
            msgTarget: 'side',
            labelAlign: 'right',
            labelWidth: 80
        },
        defaultType: 'textfield',
        defaults: {
            anchor: '98%'
        },
        items: [
        	<#if customfieldstr?exists && customfieldstr != "">
        	${customfieldstr},
        	</#if>
        	{xtype:"hidden",value:"${map.wait_check_id}",name:"wait_check_id"},
        	{xtype:"displayfield",fieldLabel:'<@s.text name="curChkName" />',value:"${step.fchkName}",name:"curChkName"},
        	{
                fieldLabel: '结束审批',
                boxLabel: '是否结束审批',
                name: 'over_check',
                xtype:'checkbox',
                checked:true,
                inputValue: '1',
                listeners : {
					'change' : function(obj, newValue, oldValue, eOpts) {
		                if(!newValue){
		                	$("container_check_nextEmpName").setDisabled(false);
		                }else{
		                	$("container_check_nextEmpName").setDisabled(true);
		                }
					}
				}
            },
			{flex:1,xtype:'fieldcontainer',disabled:true,fieldLabel:'选择交办人',combineErrors:true,msgTarget:'side',layout:'hbox',labelAlign:'right',defaults:{hideLabel:true},items:[{flex:1,afterSubTpl:'',xtype:'textfield',readOnly:true,allowBlank:false,name:'check_nextEmpName',anchor:'98%'},{xtype:'button',iconCls:'previewIcon',text:'',scale:'small',maxWidth:23,handler:function(){openCheckEmployWindow();}}]},
			{xtype:'hiddenfield',name:'check_nextEmp',},
        	{xtype:"textarea",fieldLabel:'<@s.text name="fcheckIdea" />',name:"fcheckIdea"},
        	{xtype:"hidden",name:"direct"},
        	{
        		xtype:'panel',
        		layout:'fit',
        		title:'<@s.text name="btChkhis" />',
        		items:[
        			chkhisGrid
        		]
        	}
        ],
		tbar : [
        	{
        		text:'<@s.text name="btCheck" />',
        		iconCls:'acceptIcon',
        		handler:function(){
        			check_btCheck_OnClick();
        		}
        	},{
        		text:'<@s.text name="btRefuse" />',
        		iconCls:'deleteIcon',
        		handler:function(){
        			refuse_btCheck_OnClick();
        		}
        	},
        	{text:'<@s.text name="btClose" />',iconCls:'deleteIcon',handler:function(){window.parent.$('checkWindow').hide();}}
        ]
    });
    <#--如果当前节点不是结束节点，则表示可以自由选择下一步end-->
</#macro>

<#--票证宏-->
<#macro defineNewPuriCheck step map biz customfieldstr = "">	
	<@CommonMacro.defineGrid url="/baseinfos/getCheckHisByCheck.gx?checkEntityId=${map.wait_check_id}&bizCode=${biz.fbizCode}" 
				name="chkhis" title="" enablePage="false"
                 fieldStr="${uiCreater('field', 'com.gx.facade.ui.rp.RpcheckUiDetail', 'Y-m-d H:i')}" 
                 colStr="${uiCreater('column',  'com.gx.facade.ui.rp.RpcheckUiDetail', 'Y-m-d H:i', 'grid', 'chk')}"
                  mulSel="false" toolbarStr="" checkbox="false" itemdblclick="false" />
	
	<@CommonMacro.defineGrid url="/baseinfos/getCertDataByRpwanglai.gx?fwanglaiNo=${map.wanglaiNo}" name="wanglai" title="" enablePage="false"
                 fieldStr="${uiCreater('field', 'com.gx.facade.ui.rp.RpwanglaiUiCert', 'Y-m-d H:i')}" 
                 colStr="${uiCreater('column',  'com.gx.facade.ui.rp.RpwanglaiUiCert', 'Y-m-d H:i', 'grid', 'wl')}" 
                 mulSel="false" toolbarStr="" itemdblclick="false" checkbox="false"/>	
     <#--员工资料grid参数载入-->
     function getCheckEmployParams(){
		var check_query_employ_name = $("check_query_employ_name").getValue();
		var params={
			query_fempNo : check_query_employ_name
		};
		return params;
	}     
	<#assign tbar = "{xtype:'textfield',hideEmptyLabel:true,width:150,name:'query_employ_name'}," />                 
	<#assign tbar = tbar + uiCreater('toolbar', 'btQuery,btReset,btClose', 'check_employ') />            
	<@CommonMacro.defineGrid url="/baseinfos/getDataBySysuser.gx" name="check_employ" title="" 
            fieldStr="${uiCreater('field', 'com.gx.facade.ui.common.RpsysuserUi', '')}"
            colStr="${uiCreater('column', 'com.gx.facade.ui.common.RpsysuserUi', '', 'grid', 'check_employ')}"
            toolbarStr=tbar autoLoad="false" applyName="getCheckEmployParams" singleSelect="true" 
            checkbox="false"/>
    function check_employ_btQuery_OnClick(){
		check_employGridStore.load();
		$("check_query_employ_name").focus();
	}
	function check_employ_btReset_OnClick (){
		$("check_query_employ_name").setValue('')
		$("check_query_employ_name").focus();
	}
	function check_employ_btClose_OnClick (){
		checkEmployWindow.hide();
	}     
	$("check_query_employ_name").addListener(
		'specialkey' , 
		function(field, e) {
		  	if (e.getKey() == Ext.EventObject.ENTER) {
				check_employGridStore.load();
			}
		}
	);     
    var checkEmployWindow = Ext.create('Ext.Window', {
        title: '<@s.text name="Choose" /><@s.text name="Employ" />',
        width: 700,
        height:400,
        border : false,
        x: 20,
        modal : true,
        y: document.body.clientWidth / 15,
        resizable : true,
		draggable : true,
		closeAction : 'close',
        plain: true,
        layout:'fit',
        items:[check_employGrid],
    });
    <#--打开员工资料选择窗口--> 
    function openCheckEmployWindow(){
    	checkEmployWindow.show();
    	if(check_employGridStore.count() == 0){
    		check_employGridStore.load();
    	}
    }
    <#--员工资料行双击-->
    function check_employGridItemdblclick (obj, record, item, index, e, eOpts){
    	$("check_nextEmpName").setValue(record.data.username);
    	$("check_nextEmp").setValue(record.data.sysuserid);
    	checkEmployWindow.hide();
    }  
    
    function radio_OnHandler() {
    
	}

	var checkForm = Ext.create('Ext.form.Panel', {           
        frame:true,
        timeout : 600,
        trackResetOnLoad : false,
        autoHeight : true,
        border : false,                
        autoScroll : true,
        bodyStyle:'padding:5px 5px 0',        
        fieldDefaults: {
            msgTarget: 'side',
            labelAlign: 'right',
            labelWidth: 80
        },
        defaultType: 'textfield',
        defaults: {
            anchor: '98%'
        },
        items: [
        	<#if customfieldstr?exists && customfieldstr != "">
        	${customfieldstr},
        	</#if>
        	{xtype:"hidden",value:"${map.wait_check_id}",name:"wait_check_id"},
        	{xtype:"displayfield",fieldLabel:'<@s.text name="curChkName" />',value:"${step.fchkName}",name:"curChkName"},
        	{
                fieldLabel: '结束审批',
                boxLabel: '是否结束审批',
                name: 'over_check',
                xtype:'checkbox',
                checked:true,
                inputValue: '1',
                listeners : {
					'change' : function(obj, newValue, oldValue, eOpts) {
		                if(!newValue){
		                	$("container_check_nextEmpName").setDisabled(false);
		                	$("checkResult").setDisabled(true);
		                }else{
		                	$("container_check_nextEmpName").setDisabled(true);
		                	$("checkResult").setDisabled(false);
		                }
					}
				}
            },
			{flex:1,xtype:'fieldcontainer',disabled:true,fieldLabel:'选择交办人',combineErrors:true,msgTarget:'side',layout:'hbox',labelAlign:'right',defaults:{hideLabel:true},items:[{flex:1,afterSubTpl:'',xtype:'textfield',readOnly:true,allowBlank:false,name:'check_nextEmpName',anchor:'98%'},{xtype:'button',iconCls:'previewIcon',text:'',scale:'small',maxWidth:23,handler:function(){openCheckEmployWindow();}}]},
			{
		        xtype: 'radiogroup',
		        id : 'checkResult',
		        fieldLabel: '检验结果',
		        layout: 'column',
		        items: [
					{columnWidth:.40,boxLabel: '不合格',  name: 'fcheckResult', inputValue: "0",checked:false},
					{columnWidth:.40,boxLabel: '合格' ,  name: 'fcheckResult', inputValue: "1",checked:true}
		        ],
		        listeners:{
		        	change:{
		        		fn: function(){
		        			radio_OnHandler();
		        		}
		        	}
		        }
		    },
			{xtype:'hiddenfield',name:'check_nextEmp',},
        	{xtype:"textarea",fieldLabel:'<@s.text name="fcheckIdea" />',name:"fcheckIdea"},
        	{xtype:"hidden",name:"direct"},
        	{
        		xtype:'panel',
        		layout:'fit',
        		title:'<@s.text name="btChkhis" />',
        		items:[
        			chkhisGrid
        		]
        	},
        	{
        		xtype:'panel',
        		layout:'fit',
        		title:'供应商索证信息',
        		items:[
        			wanglaiGrid
        		]
        	}
        ],
		tbar : [
        	{
        		text:'<@s.text name="btCheck" />',
        		iconCls:'acceptIcon',
        		handler:function(){
        			check_btCheck_OnClick();
        		}
        	},{
        		text:'<@s.text name="btRefuse" />',
        		iconCls:'deleteIcon',
        		handler:function(){
        			refuse_btCheck_OnClick();
        		}
        	},
        	{text:'<@s.text name="btClose" />',iconCls:'deleteIcon',handler:function(){window.parent.$('checkWindow').hide();}}
        ]
    });
    <#--如果当前节点不是结束节点，则表示可以自由选择下一步end-->
</#macro>
