<#import "/include/CommonTagMacro.ftl" as CommonMacro>
<#assign extrequired = ['*'] />
<@CommonMacro.page title="" extrequired = extrequired >
<div id="div.card.nav" style="overflow: auto;  width: 100%;"></div>
<div id="bottom_div" style="display:none;background:#D9E7F8;height:20px;line-height:20px;color:#4798D7;padding-left:10px">
	<table width="100%">
		<tr>
			<td align="left">
				<img src="/resources/extjs4/resources/image/ext/comments2.png" />
				欢迎您,${user_in_session.userName}！  
				帐户:${user_in_session.account}  
				角色:${user_in_session.roleName}
			</td>
			<td align="right" style="padding-right:20px">
				Copyright&copy ${map.year} <a style=";color:#4798D7" href="http://www.gxsofts.com" target="_blank">格讯软件</a> <#if map.SysVersion?exists && map.SysVersion != ''>版本号：${map.SysVersion?default('')}</#if>
			</td>
		</tr>
	</table>
</div>
<div id="downloads" style="display:none">
	<#include "/include/indexDownload.ftl" />
</div>
<a id="jumpTarget" target="_blank" ></a>
<div style="position:fixed;top:0px;left:0px;width:100%;height:100%;z-index:-100;">
	<img src="/resources/images/login_banner.jpg" style="width:100%;height:100%;"/>
</div>
<link rel="stylesheet" type="text/css" href="${base}/resources/css/ExtTit.css"/>
<script src="${base}/resources/commonjs/ExtTit.js"></script>
<script>
var _globalSession = eval('('+'${globalSession}'+')');
var _globalCtx = '${base?default("")}';
function addTabsPanel(comp){
	var mainTabs = Ext.getCmp('mainTabs');
	mainTabs.add(Ext.create(comp));
}
function addTabsFrame(url){
	var mainTabs = Ext.getCmp('mainTabs');
	var n = mainTabs.add({
					title : '预警各事项', 
					closable : true,
					layout : 'fit',
					html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src='
							+ url + '></iframe>'
				});
	mainTabs.setActiveTab(n);
}
<#--打开收件箱页-->
function showUnReadMsg(){
	var id = "tab_id_01010402";
	var mainTabs = $('mainTabs');
	var n = mainTabs.getComponent(id);
	var url = "/baseinfos/receive_Message.js?main_menuid=01010402"
	if (!n) {
		n = mainTabs.add({
			id : id,
			title : "我的收件箱", 
			closable : true,
			layout : 'fit',
			html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src='
					+ url + '></iframe>'
		});
	}
	mainTabs.setActiveTab(n);	
}
<#if listItem?size != 0>
Ext.onReady(function() {
	<#assign menuModelStr = uiCreater('field','com.gx.facade.ui.common.RpmenuUi', '') />
    <@CommonMacro.defineTree url="/baseinfos/getTreeDataByMenu.js" 
    	autoLoad="true" name="menu"  width=180 rootId="01" modelStr=menuModelStr />
	<#--常用下载窗口-->
	var downloadwin = Ext.create('Ext.Window', {
        title: '常用下载',
        width: 400,
        border : false,
        resizable : true,
		draggable : true,
		closeAction : 'close',
        plain: true,
        layout: 'fit',
        id:'downloadwin',
        modal:true,
        contentEl: 'downloads',
        tbar:[
        	{xtype:'button',text:'<@s.text name="btClose" />',iconCls:'deleteIcon',handler:function(){
        		$("downloadwin").hide();
        	}}
        ]
    });
	var mainMenu = new Ext.menu.Menu({
		id : 'mainMenu',
		items : [{
			text : '密码修改',
			iconCls : 'keyIcon',
			handler : function() {
				var mainTabs = Ext.getCmp('mainTabs')
				mainTabs.setActiveTab(0);	
				changeWin.show();
			}
		}, {
			text : '系统锁定',
			iconCls : 'lockIcon',
			handler : function() {
				var mainTabs = Ext.getCmp('mainTabs')
				mainTabs.setActiveTab(0);	
				lockWindow.show();
				Ext.getCmp("password").setValue('');
				setCookie("gx.lockflag", '1', 240);
			}
		},{
			text : '常用下载',
			iconCls : 'downloadIcon',
			handler : function() {
				var mainTabs = Ext.getCmp('mainTabs')
				mainTabs.setActiveTab(0);	
				document.getElementById("downloads").style.display="block";
				downloadwin.show();
			}
		}<#if user_in_session.roleType == '3' || user_in_session.roleType == '4'>
		,{
			text : '检查更新',
			iconCls : 'downloadIcon',
			handler : function() {
				var mainTabs = Ext.getCmp('mainTabs')
				mainTabs.setActiveTab(0);
				checkUpdate();	
			}
		}
		</#if>
		]
	});
	var first_item = Ext.create('Ext.Button', {
		    text : '<@s.text name="Index.item" />',
			iconCls : 'config2Icon',
			iconAlign : 'left',
			scale : 'medium',
			width : 100,
			tooltip : '<span style="font-size:12px"><@s.text name="Login.logout" /></span>',
			pressed : true,
			style:{
				marginTop:'10px'
			},
			menu:mainMenu
	});
	var first_item2 = Ext.create('Ext.Button', {
			iconCls : 'cancel_48Icon',
			iconAlign : 'left',
			scale : 'medium',
			style:{
				marginLeft:'10px',
				marginTop:'10px'
			},
			tooltip : '<span style="font-size:12px"><@s.text name="Login.logout" /></span>',
			pressed : true,
		    handler: function() {
				var mainTabs = Ext.getCmp('mainTabs')
				mainTabs.setActiveTab(0);		    	
		    	Ext.Msg.confirm('确认','<span style="color:red">你确定退出系统吗?</span>', function(bid){
		    		if(bid == "yes"){
		    			window.location='/logout.js'
		    		}
		    	});
		    }
	});
	var currentItem;
	var viewport = Ext.create('Ext.Viewport', {
		id : 'border-example',
		layout : 'border',
		animateTarget : document.body,
		listeners : {
			afterlayout : function() {
				document.getElementById("bottom_div").style.display="block";
				<#--当前时间计时器-->
				var updateClock = function () {
					var now = new Date();
					var hour = now.getHours();
					var minute = now.getMinutes();
					var second = now.getSeconds();
					hour = hour<10?"0"+hour:hour;
					minute = minute<10?"0"+minute:minute;
					second = second < 10?"0"+second:second;
					var str = hour+":"+minute+":"+second;
     				Ext.fly('clock').update(str);
				}
				var task = Ext.TaskManager.start({
				     run: updateClock,
				     interval: 1000
				});
			}
		},
		items : [{
				region : 'north',
				split : true,
				height : 45,
				minSize : 100,
				maxSize : 200,
				border:false,
				collapsible : false,
				collapsed : false,
				margins : '0 0 0 5',
				layout:'border',
				bodyStyle:{
					background:'#D9E7F8'
				},
				items : [{
					region : 'west',
					width:400,
					height:45,
					border:false,
					bodyStyle:{
						background:'#D9E7F8'
					},
					<#assign logo_img = "/resources/images/login_banner.png" />
					html:'<img src="${logo_img}" height="45"/>'
				}
				,{
					region : 'east',
					width:150,
					height:45,
					border:false,
					layout:'column',
					bodyStyle:{
						background:'#D9E7F8'
					},
					items:[first_item, first_item2]
				},{
					region : 'center',
					height:45,
					border:false,
					bodyStyle:{
						background:'#D9E7F8'
					},
					html:'<br /><br /><div style="color:#4798D7;text-align:right;padding-right:20px">${map.hello},${user_in_session.userName}! 今天是:${map.today} ${map.dayOfWeek}  当前时间：<span id="clock"></span>  </div>'
				}]
			}, {
				region : 'south',
				split : false,
				border:false,
				height : 20,
				minSize : 100,
				maxSize : 200,
				collapsible : false,
				collapsed : false,
				margins : '0 0 0 0',
				contentEl:'bottom_div'
			}, {
				title : '<@s.text name="功能菜单" />',
				iconCls : 'layout_contentIcon',
				tools : [ ],
				collapsible : true,
				width : 185,
				split : true,
				region : 'west',
				autoScroll : true,
				items : [menuTree]
		}, Ext.create('Ext.tab.Panel', {
			id : 'mainTabs',					
			region : 'center', 
			plugins : Ext.create('Ext.ux.TabCloseMenu', {
				extraItemsTail : ['-', {
							text : '可否关闭',
							checked : true,
							hideOnClick : true,
							handler : function(item) {
								currentItem.tab
										.setClosable(item.checked);
							}
						}],
				listeners : {
					aftermenu : function() {
						currentItem = null;
					},
					beforemenu : function(menu, item) {
						var menuitem = menu.child('*[text="可否关闭"]');
						currentItem = item;
						menuitem.setChecked(item.closable);
					}
				}
			}),
			activeTab : 0, 
			items : [{
				id : 'workbench',
				title : "我的工作台", 
				closable : false,
				iconCls:'application_homeIcon',
				layout : 'fit',
				html : ''
			 }]
		})]
	});
	
	function menuItemClick (view, re, item, index, e, eOpts){
		var menuid = re.data.id;
		//var menuid = re.data.fid;
		var id = "tab_id_" + menuid;
		var url = re.data.request;
		var iconCls = re.data.iconCls;				
		var mainTabs = Ext.getCmp('mainTabs');
		if (url == '#' || url == '') {
			view.expand(re);
			return;
		} else if(url.indexOf('$')>-1){
			jQuery('#jumpTarget').attr('href',url.substring(1));			
			var evt = document.createEvent("MouseEvents");
			evt.initEvent("click",false,false);
			jQuery('#jumpTarget').get(0).dispatchEvent(evt);
		} else if(url.indexOf('@')>-1){
			var _id = url.substring(1);
			var n = mainTabs.getComponent(_id);
			if (!n) {
				n = mainTabs.add(Ext.create(_id));
			}
			mainTabs.setActiveTab(n);
		}else {
			var index = url.indexOf('.js');
			if (index != -1){
				if(url.indexOf('?') == -1)
					url = url + '?main_menuid=' + menuid;
				else
					url = url + '&main_menuid=' + menuid;
			}
			var n = mainTabs.getComponent(id);
			if (!n) {
				n = mainTabs.add({
					id : id,
					iconCls:iconCls,
					title : re.data.text, 
					closable : true,
					layout : 'fit',
					html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src='
							+ url + '></iframe>'
				});
			}
			mainTabs.setActiveTab(n);
		}
	}	
   var lockForm = Ext.create('Ext.panel.Panel', {
	   	layout:'fit',
	    bodyPadding: 6,
	    defaultType: 'textfield',
	    border:false,
	    items: [
	    	{
				xtype : 'form',
				id : 'lockForm',
        		border:false,
				defaultType : 'textfield',
				items : [{
					fieldLabel : '<@s.text name="Login.password" />',
					labelAlign:'right',
					labelWidth:50,
					name : 'password',
					id : 'password',
					inputType : 'password',
					blankText : '<@s.text name="Login.password.cannot.null" />',
					maxLength : 20,
					maxLengthText : '<@s.text name="Login.account.maxLength" />',
					allowBlank : false,
					listeners : {
						specialkey : function(field, e) {
							if (e.getKey() == Ext.EventObject.ENTER) {
								unlockSystem();
							}
						}
					}
				}]
			}
	    ]
	});
	var lockWindow = Ext.create('Ext.window.Window', {
	    title: '<@s.text name="System" /><@s.text name="lock" />',
	    height: 100,
	    width: 260,
	    iconCls:'lockIcon',
	    closable:false,
	    border:false,
	    resizable:false,
	    draggable:false,
	    modal:true,
	    layout: 'fit',
	    items:[lockForm],
	    animateTarget : document.body,
	    buttons : [{
					text : '<@s.text name="unlock" />',
					iconCls : 'keyIcon',
					handler : function() {
						unlockSystem();
					}
				}, {
					text : '<@s.text name="relogin" />',
					iconCls : 'tbar_synchronizeIcon',
					handler : function() {
						setCookie("gx.lockflag", '0', 240);
						window.location.href = '/logout.js';
					}
				}]
	});
	if (getCookie("gx.lockflag") == '1') {
		lockWindow.show();
	}
	function unlockSystem() {
		if (Ext.getCmp('lockForm').form.isValid()) {
			Ext.getCmp('lockForm').form.submit({
				url : '/lockOut.js',
				waitTitle : '<@s.text name="prompt" />',
				method : 'POST',
				waitMsg : '<@s.text name="Login.wait" />',
				success : function(form, action) {
					lockWindow.hide();
					setCookie("gx.lockflag", '0', 240);
				},
				failure : function(form, action) {
					var errmsg = action.result.failure;
					lockWindow.hide();
					showErrorMsg('<span style="color:red">'+errmsg+'</span>', function(){
						lockWindow.show();	
					});
				}
			});
		}
	}
	
	
	var changeForm = Ext.create("Ext.form.Panel", {
		autoWidth : true,    
        border : false,                
        defaultType: 'textfield',
        defaults : {
        	width : 260,
			labelWidth: 60
		},
		bodyStyle:'padding:5px 0 5px 5px',
		items: [
        	{
				fieldLabel : '<@s.text name="SrcPassword" />',
				name : 'srcpassword',
				id : 'srcpassword',
				inputType : 'password',
				blankText : '<@s.text name="Login.password.cannot.null" />',
				maxLength : 20,
				maxLengthText : '<@s.text name="Login.account.maxLength" />',
				allowBlank : false,
				listeners : {
					specialkey : function(field, e) {
						if (e.getKey() == Ext.EventObject.ENTER) {
							login();
						}
					}
				}
			},
			{
				fieldLabel : '<@s.text name="NewPassword" />',
				name : 'newpassword',
				id : 'newpassword',
				inputType : 'password',
				blankText : '<@s.text name="Login.password.cannot.null" />',
				maxLength : 20,
				maxLengthText : '<@s.text name="Login.account.maxLength" />',
				allowBlank : false,
				listeners : {
					specialkey : function(field, e) {
						if (e.getKey() == Ext.EventObject.ENTER) {
							login();
						}
					}
				}
			}
			,
			{
				fieldLabel : '<@s.text name="confirmPassword" />',
				name : 'confirmpassword',
				id : 'confirmpassword',
				inputType : 'password',
				blankText : '<@s.text name="Login.password.cannot.null" />',
				maxLength : 20,
				maxLengthText : '<@s.text name="Login.account.maxLength" />',
				allowBlank : false,
				listeners : {
					specialkey : function(field, e) {
						if (e.getKey() == Ext.EventObject.ENTER) {
							login();
						}
					}
				}
			}
        ]
	});
	
	var changeWin = Ext.create('Ext.window.Window',{
		title:'<@s.text name="ChangePassword" />',
		width:300,
		height:150,
		layout:'fit',
		modal:true,
		items:[changeForm],
		buttons : [{
			text : '<@s.text name="btSave" />',
			iconCls : 'acceptIcon',
			handler : function() {
				submitForm('/baseinfos/changePasswordBySysuser.js', changeForm, function(form, action){
	    			changeWin.hide();
		    		showTitMsg('<@s.text name="Save.success" />');
		    	},function(form, action){
		    		var errmsg = action.result.failure;
		    		changeWin.hide();
					showErrorMsg('<span style="color:red">'+errmsg+'</span>',function(){
						changeWin.show();
					});
		    	});
			}
		},{
			text : '<@s.text name="btCancel" />',
			iconCls : 'deleteIcon',
			handler : function() {
				changeWin.hide();
			}
		}]
	});
	
	changeWin.on("show", function(){
		Ext.getCmp("srcpassword").setValue("");
		Ext.getCmp("newpassword").setValue("");
		Ext.getCmp("confirmpassword").setValue("");
	});
	
	
	<#include "/include/index/mainArea.ftl" />
	
	window.onbeforeunload = function(){
		return ("您的操作会导致您离开社保金融服务应用平台");
	}
	
	<#if user_in_session.userType?exists>
	art.dialog.data('mqttConfig',{
		host:'${map.mqtt_host}',
		port:'${map.mqtt_ws_port}',
		user:'${map.mqtt_user}',
		password:'${map.mqtt_password}',
		clientId:'${user_in_session.sysuserid}'.substr(8,16),
		topic:'${user_in_session.userType.frefId}'
	});
	</#if>
	window.mqttEvent = {}
	art.dialog.data('mqtt.msg.arrived',window.mqttEvent);
	window.mqttEvent['notification'] = function(data){
		art.dialog({
		    title: data.contentTitle,
		    content: data.contentText,
		    width: 300,
		    height: 200,
		    left: '100%',
		    top: '100%',
		    fixed: true,
		    drag: false,
		    resize: false
		});
	};
	
	art.dialog.data('mqt.msg.map.regist',{});
	window.mqttEvent['map'] = function(data){
		var events = art.dialog.data('mqt.msg.map.regist');
		for(var p in events){
			if(events[p])
				events[p](data);
		}
	}
	
});

var elevatorDetailWindow = null;
function buildElevatorDetail(felevId){
    	elevatorDetailWindow = Ext.getCmp('elevator.detailByRpElevator');
    	if(elevatorDetailWindow==null){
    		elevatorDetailWindow = Ext.create('elevator.detailByRpElevator');
    	}
    	elevatorDetailWindow.felevId = felevId;
    	elevatorDetailWindow.show();
    	elevatorDetailWindow.refreshAll();
}
art.dialog.data('buildElevatorDetail',buildElevatorDetail);

var H_elevWindow = null;
art.dialog.data('RpElevator.List',function(){
    	H_elevWindow = Ext.getCmp('elevator.includeByRpElevator');
    	if(H_elevWindow==null){
    		H_elevWindow = Ext.create('elevator.includeByRpElevator');
    	}
    	H_elevWindow.show();
});

<#include '/include/version.ftl'/>
<#else>
Ext.onReady(function(){
	showErrorMsg('<span style="color:red">您的当前角色没有被授权任何菜单，请联系上级角色或管理员</span>');
});
</#if>
</script>
<iframe src="${base}/resources/mqtt/mqtt.html" style="display:none;"></iframe>
</@CommonMacro.page>
