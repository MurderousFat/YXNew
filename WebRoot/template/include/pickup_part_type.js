TenzePreLoad(['com.tenze.pms.facade.dto.bi.BiPartTypeDto'],function(){
			 Ext_BuildGrid('com.tenze.pms.facade.dto.bi.BiPartTypeDto','pickupPartType',{
				url:'${base}/bi/listPageByBiPartType.tz',
				preffix:'pickupPartType_'
			 });

		TenzeExt.pickupPartTypeWin = Ext.create('Ext.Window', {
		    title: '选择配件类型',
		    width: document.documentElement.clientWidth,
		    height: document.documentElement.clientHeight,
		    border : false,
		    resizable : true,
			draggable : true,
			closeAction : 'close',
		    plain: true,
		    layout: 'fit',
		    items : [TenzeExt.pickupPartTypeGrid],
		    tbar : Ext_BuildToolbarBtns(['confirm','close'],{preffix:'pickupPartType_'})
		});			 
		
		window.pickupPartType_bt_close_OnClick = function(){
			TenzeExt.pickupPartTypeWin.hide();
		}
		
		window.pickupPartTypeGridItemdbclick = function(obj, record, item, index, e, eOpts){
			pickupPartTypeSelectCallback(obj, record, item, index, e, eOpts);
			TenzeExt.pickupPartTypeWin.hide();
		}
 });
