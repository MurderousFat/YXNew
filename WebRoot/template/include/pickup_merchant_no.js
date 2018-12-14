TenzePreLoad(['com.tenze.pms.facade.dto.bi.BiMerchantNoDto'],function(){
			 Ext_BuildGrid('com.tenze.pms.facade.dto.bi.BiMerchantNoDto','pickupMerchantNo',{
				url:'${base}/bi/listPageByBiMerchantNo.tz',
				preffix:'pickupMerchantNo_',
				applyName:'pickupMerchantNoParams'
			 });
		var _querybox = {xtype:'textfield',hideLabel:true,name:'query_key',id:'pickupMerchantNo_query_key',emptyText:'名称｜速查码',width:100,value:'',enableKeyEvents:true,listeners:{specialkey:function(field,e){if(e.getKey()==Ext.EventObject.ENTER){pickupMerchantNo_bt_search_OnClick();}}}};
		TenzeExt.pickupMerchantNoWin = Ext.create('Ext.Window', {
		    title: '选择商家编号',
		    width: document.documentElement.clientWidth,
		    height: document.documentElement.clientHeight,
		    border : false,
		    resizable : true,
			draggable : true,
			closeAction : 'close',
		    plain: true,
		    layout: 'fit',
		    items : [TenzeExt.pickupMerchantNoGrid],
		    tbar : Ext_BuildToolbarBtns([_querybox,'search','close'],{preffix:'pickupMerchantNo_'})
		});			 
		
		window.pickupMerchantNo_bt_close_OnClick = function(){
			TenzeExt.pickupMerchantNoWin.hide();
		}
		
		window.pickupMerchantNoGridItemdbclick = function(obj, record, item, index, e, eOpts){
			pickupMerchantNoSelectCallback(obj, record, item, index, e, eOpts);
			TenzeExt.pickupMerchantNoWin.hide();
		}
		
		window.pickupMerchantNoParams = function(){
			var params = {
				query_key : $("pickupMerchantNo_query_key").getValue()
			};
			return params
		}
		
		window.pickupMerchantNo_bt_search_OnClick = function(){
			TenzeExt.pickupMerchantNoGridStore.loadPage(1);
		}
 });
