TenzePreLoad(['com.tenze.pms.facade.dto.sys.SysRoleDto'],function(){
			 Ext_BuildGrid('com.tenze.pms.facade.dto.sys.SysRoleDto','pickupRole',{
				url:'${base}/sys/listPageBySysRole.tz',
				preffix:'pickupRole_'
			 });

		TenzeExt.pickupRoleWin = Ext.create('Ext.Window', {
		    title: '选择角色',
		    width: document.documentElement.clientWidth,
		    height: document.documentElement.clientHeight,
		    border : false,
		    resizable : true,
			draggable : true,
			closeAction : 'close',
		    plain: true,
		    layout: 'fit',
		    items : [TenzeExt.pickupRoleGrid],
		    tbar : Ext_BuildToolbarBtns(['confirm','close'],{preffix:'pickupRole_'})
		});			 
		
		window.pickupRole_bt_close_OnClick = function(){
			TenzeExt.pickupRoleWin.hide();
		}
		
		window.pickupRoleGridItemdbclick = function(obj, record, item, index, e, eOpts){
			pickupRoleSelectCallback(obj, record, item, index, e, eOpts);
			TenzeExt.pickupRoleWin.hide();
		}
 });
