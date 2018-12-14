TenzePreLoad(['com.tenze.pms.facade.dto.bi.BiRegionDto'],function(){
	 Ext_BuildTree('com.tenze.pms.facade.dto.bi.BiRegionDto','pickupRegion',{
		 url:'${base}/bi/listByBiRegion.tz',
		 rootText:'区域',
		 rootVisible:false,
		 dblClickevent:true,
		 listTreeSetting:{
			 convertProps:[{key:'expandedFlag',target:'expanded'},{key:'leafFlag',target:'leaf'}],
			 extIdKey:'id',
			 extTextKey:'rgnName',
			 simpleData:{
				 idKey:'rgnNo',
				 pIdKey:'parentNo'
			 }
		 }
	 });
     
     TenzeExt.pickupRegionWin = Ext.create('Ext.Window', {
	        title: '编辑',
	        width:document.documentElement.clientWidth * 0.5,
	        height:document.documentElement.clientHeight,
	        border : false,
	        resizable : true,
			draggable : true,
			closeAction : 'close',
	        plain: true,
	        layout: 'fit',
	        items : [TenzeExt.pickupRegionTree],
	        tbar : Ext_BuildToolbarBtns(['close'],{preffix:'pickupRegion_'})
	 });
     TenzeExt.pickupRegionTree.on('load',function(){
	     TenzeExt.pickupRegionTree.expandAll();
     });
     
     window.pickupRegionTreeItemDblClick = function(view, record, item, index, e, eOpts){
    	 pickupRegionSelectCallback(view, record, item, index, e, eOpts);
    	 TenzeExt.pickupRegionWin.hide();
     }
     
     window.pickupRegionTreeItemClick=function(){};
     
     
     window.pickupRegion_bt_close_OnClick = function(){
    	 TenzeExt.pickupRegionWin.hide();
     }
     
});