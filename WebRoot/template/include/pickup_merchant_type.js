TenzePreLoad(['com.tenze.pms.facade.dto.bi.BiMerchantTypeDto'],function(){
			 Ext_BuildGrid('com.tenze.pms.facade.dto.bi.BiMerchantTypeDto','pickupMerchantType',{
				url:'${base}/bi/listPageByBiMerchantType.tz',
				preffix:'pickupMerchantType_'
			 });

		TenzeExt.pickupMerchantTypeWin = Ext.create('Ext.Window', {
		    title: '选择商户类型',
		    width: document.documentElement.clientWidth,
		    height: document.documentElement.clientHeight,
		    border : false,
		    resizable : true,
			draggable : true,
			closeAction : 'close',
		    plain: true,
		    layout: 'fit',
		    items : [TenzeExt.pickupMerchantTypeGrid],
		    tbar : Ext_BuildToolbarBtns(['confirm','close'],{preffix:'pickupMerchantType_'})
		});			 
		
		window.pickupMerchantType_bt_close_OnClick = function(){
			TenzeExt.pickupMerchantTypeWin.hide();
		}
		
		window.pickupMerchantTypeGridItemdbclick = function(obj, record, item, index, e, eOpts){
			pickupMerchantTypeSelectCallback(obj, record, item, index, e, eOpts);
			TenzeExt.pickupMerchantTypeWin.hide();
		}
 });
