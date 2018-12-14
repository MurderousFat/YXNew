TenzePreLoad(['com.tenze.pms.facade.dto.bi.BiOrgTypeDto'],function(){
			 Ext_BuildGrid('com.tenze.pms.facade.dto.bi.BiOrgTypeDto','pickupOrgType',{
				url:'${base}/bi/listPageByBiOrgType.tz',
				preffix:'pickupOrgType_'
			 });

		TenzeExt.pickupOrgTypeWin = Ext.create('Ext.Window', {
		    title: '选择机构类型',
		    width: document.documentElement.clientWidth,
		    height: document.documentElement.clientHeight,
		    border : false,
		    resizable : true,
			draggable : true,
			closeAction : 'close',
		    plain: true,
		    layout: 'fit',
		    items : [TenzeExt.pickupOrgTypeGrid],
		    tbar : Ext_BuildToolbarBtns(['confirm','close'],{preffix:'pickupOrgType_'})
		});			 
		
		window.pickupOrgType_bt_close_OnClick = function(){
			TenzeExt.pickupOrgTypeWin.hide();
		}
		
		window.pickupOrgTypeGridItemdbclick = function(obj, record, item, index, e, eOpts){
			pickupOrgTypeSelectCallback(obj, record, item, index, e, eOpts);
			TenzeExt.pickupOrgTypeWin.hide();
		}
 });
