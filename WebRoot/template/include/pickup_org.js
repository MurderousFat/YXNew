TenzePreLoad(['com.tenze.pms.facade.dto.bi.BiOrgDto'],function(){
			 Ext_BuildGrid('com.tenze.pms.facade.dto.bi.BiOrgDto','pickupOrg',{
				url:'${base}/bi/listPageByBiOrg.tz',
				preffix:'pickupOrg_'
			 });

		TenzeExt.pickupOrgWin = Ext.create('Ext.Window', {
		    title: '选择机构',
		    width: document.documentElement.clientWidth,
		    height: document.documentElement.clientHeight,
		    border : false,
		    resizable : true,
			draggable : true,
			closeAction : 'close',
		    plain: true,
		    layout: 'fit',
		    items : [TenzeExt.pickupOrgGrid],
		    tbar : Ext_BuildToolbarBtns(['confirm','close'],{preffix:'pickupOrg_'})
		});			 
		
		window.pickupOrg_bt_close_OnClick = function(){
			TenzeExt.pickupOrgWin.hide();
		}
		
		window.pickupOrgGridItemdbclick = function(obj, record, item, index, e, eOpts){
			pickupOrgSelectCallback(obj, record, item, index, e, eOpts);
			TenzeExt.pickupOrgWin.hide();
		}
 });
