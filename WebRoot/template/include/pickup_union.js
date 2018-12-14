TenzePreLoad(['com.tenze.pms.facade.dto.bi.BiUnionDto'],function(){
	 Ext_BuildTree('com.tenze.pms.facade.dto.bi.BiUnionDto','pickupUnion',{
		 url:'${base}/bi/listByBiUnion.tz',
		 rootText:'组织',
		 rootVisible:false,
		 dblClickevent:true,
		 listTreeSetting:{
			 convertProps:[{key:'expandedFlag',target:'expanded'},{key:'leafFlag',target:'leaf'}],
			 extIdKey:'id',
			 extTextKey:'unionName',
			 simpleData:{
				 idKey:'unionNo',
				 pIdKey:'parentNo'
			 }
		 }
	 });
     
     TenzeExt.pickupUnionWin = Ext.create('Ext.Window', {
	        title: '编辑',
	        width:document.documentElement.clientWidth * 0.5,
	        height:document.documentElement.clientHeight,
	        border : false,
	        resizable : true,
			draggable : true,
			closeAction : 'close',
	        plain: true,
	        layout: 'fit',
	        items : [TenzeExt.pickupUnionTree],
	        tbar : Ext_BuildToolbarBtns(['close'],{preffix:'pickupUnion_'})
	 });
     TenzeExt.pickupUnionTree.on('load',function(){
	     TenzeExt.pickupUnionTree.expandAll();
     });
     
     window.pickupUnionTreeItemDblClick = function(view, record, item, index, e, eOpts){
    	 pickupUnionSelectCallback(view, record, item, index, e, eOpts);
    	 TenzeExt.pickupUnionWin.hide();
     }
     
     window.pickupUnionTreeItemClick=function(){};
     
     
     window.pickupUnion_bt_close_OnClick = function(){
    	 TenzeExt.pickupUnionWin.hide();
     }
     
});