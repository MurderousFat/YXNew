TenzePreLoad(['com.tenze.pms.facade.dto.bi.BiMerchantDto'],function(){
			 Ext_BuildGrid('com.tenze.pms.facade.dto.bi.BiMerchantDto','pickupMerchant',{
				url:'${base}/bi/listPageByBiMerchant.tz',
				preffix:'pickupMerchant_',
				applyName:'pickupMerchantParams'
			 });

		var _querybox = {
			xtype:'textfield',hideLabel:true,name:'query_key',id:'pickupMerchant_query_key',emptyText:'名称｜速查码',width:100,value:'',enableKeyEvents:true,listeners:{specialkey:function(field,e){if(e.getKey()==Ext.EventObject.ENTER){pickupMerchant_bt_search_OnClick();}}}};
		TenzeExt.pickupMerchantWin = Ext.create('Ext.Window', {
		    title: '选择商家',
		    width: document.documentElement.clientWidth,
		    height: document.documentElement.clientHeight,
		    border : false,
		    resizable : true,
			draggable : true,
			closeAction : 'close',
		    plain: true,
		    layout: 'fit',
		    items : [TenzeExt.pickupMerchantGrid],
		    tbar : Ext_BuildToolbarBtns([_querybox,'search','close'],{preffix:'pickupMerchant_'})
		});			 
		
		window.pickupMerchant_bt_close_OnClick = function(){
			TenzeExt.pickupMerchantWin.hide();
            TenzeExt.pickupMerchantGridStore.loadPage(1);
		}
		
		window.pickupMerchantGridItemdbclick = function(obj, record, item, index, e, eOpts){
			pickupMerchantSelectCallback(obj, record, item, index, e, eOpts);
			TenzeExt.pickupMerchantWin.hide();
		}
		
		window.pickupMerchantParams = function(){
			var params = {
                queryKey : $("pickupMerchant_query_key").getValue()
			};
			return params
		}
		
		window.pickupMerchant_bt_search_OnClick = function(){
            TenzeExt.pickupMerchantGridStore.loadPage(1);
        }
 });
