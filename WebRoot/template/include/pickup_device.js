TenzePreLoad(['com.tenze.pms.facade.dto.bi.BiDeviceDto'],function(){
			 Ext_BuildGrid('com.tenze.pms.facade.dto.bi.BiDeviceDto','pickupDevice',{
				url:'${base}/bi/listPageByBiDevice.tz',
				preffix:'pickupDevice_',
				applyName:'pickupDeviceParams'
			 });
	   /* 
			 var _toolbar = [{xtype:'textfield',hideLabel:true,name:'query_school_key',id:'query_school_key',emptyText:'名称｜速查码',width:100,value:'',enableKeyEvents:true,listeners:{specialkey:function(field,e){if(e.getKey()==Ext.EventObject.ENTER){query_school_keyComboQuery();}}}},
				{text:'查询',scale:'small',disabled:false,id:'chkschool_btQuery',scope:this,iconCls:'previewIcon',handler:function(){chkschool_btQuery_OnClick();}}]
		*/	 
		var _querybox = {xtype:'textfield',hideLabel:true,name:'query_key',id:'pickupDevice_query_key',emptyText:'名称｜速查码',width:100,value:'',enableKeyEvents:true,listeners:{specialkey:function(field,e){if(e.getKey()==Ext.EventObject.ENTER){pickupDevice_bt_search_OnClick();}}}};	 
		TenzeExt.pickupDeviceWin = Ext.create('Ext.Window', {
		    title: '选择终端',
		    width: document.documentElement.clientWidth,
		    height: document.documentElement.clientHeight,
		    border : false,
		    resizable : true,
			draggable : true,
			closeAction : 'close',
		    plain: true,
		    layout: 'fit',
		    items : [TenzeExt.pickupDeviceGrid],
		    tbar : Ext_BuildToolbarBtns([_querybox,'search','close'],{preffix:'pickupDevice_'})
		});			 
		
		window.pickupDevice_bt_close_OnClick = function(){
			TenzeExt.pickupDeviceWin.hide();
		}
		
		window.pickupDeviceGridItemdbclick = function(obj, record, item, index, e, eOpts){
			pickupDeviceSelectCallback(obj, record, item, index, e, eOpts);
			TenzeExt.pickupDeviceWin.hide();
		}
		
		window.pickupDeviceParams = function(){
			var params = {
				query_key : $("pickupDevice_query_key").getValue()
			};
			return params
		}
		
		window.pickupDevice_bt_search_OnClick = function(){
			TenzeExt.pickupDeviceGridStore.loadPage(1);
		}

 });
