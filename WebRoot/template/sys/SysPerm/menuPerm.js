Ext.define('MenuPermWindow', {
		    extend: 'Ext.Window',
	        width : document.documentElement.clientWidth,	
			height:document.documentElement.clientHeight,
	        autoScroll : true,
	        border : false,
	        x: 0,
	        y: 0,
	        modal:false,
	        resizable : true,
			draggable : true,
			closeAction : 'close',
			layout:'fit',
	        plain: true
 });

window.menuCheckTreeItemClick = function(){};

function showMenuPermWindow(record){
	var roleName = record.get("roleName");
	var roleId = record.get('id');
	if(_global_roleId==roleId){
		showErrorMsg('相同角色自身不能授权');
		return;
	}
	jQuery.ajax({
		type:'get',
		url:'${base}/sys/menuRoleDataBySysPerm.tz?roleId='+roleId,
		dataType:'json'
	}).done(function(resp){
		var enableCheckObj = {};
		for(var i in resp){
			enableCheckObj[resp[i].menuId+''] = resp[i].roleId;
		}
		Ext_BuildTree('com.tenze.pms.facade.dto.sys.SysMenuDto','menuCheck',{
			 url:'${base}/sys/roleMenuPermBySysPerm.tz',
			 rootText:'菜单',
			 rootVisible:true,
			 listTreeSetting:{
				 convertProps:[{key:'expandedFlag',target:'expanded'},{key:'leafFlag',target:'leaf'}],
				 enableCheck:enableCheckObj,
				 extIdKey:'id',
				 extTextKey:'menuName',
				 simpleData:{
					 idKey:'menuNo',
					 pIdKey:'parentNo'
				 }
			 }
		});
		
		var menuPermWin = Ext.create('MenuPermWindow',{
			modal:false,
			tbar:[{
	                text: '保存',
	                iconCls:'acceptIcon',
	                handler: function(){
	                    var records = TenzeExt.menuCheckTree.getView().getChecked();
	                    if(records.length == 0){
	                    	Ext.MessageBox.confirm('确认提示', '是否保存 ['+roleName+'] 菜单权限', function(btn){
								if(btn == "no"){
									return false;
								}else{
									submitMenuPerm(records, record, menuPermWin);
								}
							});
	                    }else{
		                    Ext.MessageBox.confirm('确认提示', '是否保存 ['+roleName+'] 菜单权限', function(btn){
								if(btn == "yes"){
		                    		submitMenuPerm(records, record, menuPermWin);
		                    	}
							});
	                    }
	                }
	            },{
	                text: '关闭',
	                iconCls:'deleteIcon',
	                handler: function(){
	                   menuPermWin.hide();
	                }
	            }]
		});
		menuPermWin.on("hide", function(){
			menuPermWin.destroy();
		});
		TenzeExt.menuCheckTree.on("checkchange", function(node, checked){
			node.cascadeBy(function(child){
				child.set("checked", checked);
			});
			if(checked){
				var path = node.getPath();
				path += "/";
				var root = menuCheckTree.getRootNode();
				root.cascadeBy(function(child){
					var id = child.data.id;
					if(path.indexOf("/"+id+"/") != -1){
						child.set("checked", checked);
					}				
				});
			}
		}, TenzeExt.menuCheckTree);
		menuPermWin.add(TenzeExt.menuCheckTree);
		menuPermWin.setTitle('['+roleName+'] 菜单授权');
	    menuPermWin.show();
	    setTimeout(function(){
		    TenzeExt.menuCheckTree.expandAll();
	    },200);
	});
	
}

function submitMenuPerm(treeRecords, gridRecord, menuPermWin){
	ids = [];
    Ext.Array.each(treeRecords, function(rec){
        ids.push(rec.get('id'));
    });
    var key = ids.join(',');
	showWaitMsg();
	Ext.Ajax.request({
	    url: '${base}/sys/createMenuRoleListBySysPerm.tz',
	    params: {
	        key:key,
	        roleId:gridRecord.get("id")
	    },
	    success: function(response){
	    	hideWaitMsg();
	    	var text = response.responseText;
    		var kk = Ext.JSON.decode(text).success;
    		if(!isEmpty(kk) && kk == "true"){
    			menuPermWin.hide();
    		 	showTitMsg('保存成功');
    		}else{
    			showErrorMsg(Ext.JSON.decode(text).failure);
    		}
	    }
	});
}