<#import "/include/CommonTagMacro.ftl" as CommonMacro>
<#assign extrequired = ['Ext.tip.QuickTipManager','Ext.container.Viewport','Ext.layout.*','Ext.form.Panel','Ext.form.Label','Ext.grid.*','Ext.data.*','Ext.tree.*','Ext.selection.*','Ext.tab.Panel','Ext.ux.layout.Center'] />
<#assign login_bg = "" />
<#if listItem?size == 0><#--如果没有设置首页图片，则使用默认的图片-->
<#assign login_bg = "background:#E6E6E6;text-align:center" />
<#else>
<#assign login_bg = "text-align:center" />
</#if>
<@CommonMacro.page title="" backgroundStyle=login_bg extrequired = extrequired>
	<div id="aboutDiv" class="x-hidden" style='color: black; padding-left: 10px; padding-top: 10px; font-size: 12px'>
	<div style="height:20px;line-height:20px">
	<div style="float:left;width:80px;text-align:left">技术支持:</div><div style="float:left">广东银信</div>
	</div>
	<div style="height:20px;line-height:20px">
	<div style="float:left;width:80px;text-align:left">网址:</div><div style="float:left"><a href="http://www.yxunionpay.com/" target="_blank" style="color:#04408C">http://www.yxunionpay.com/</a></div>
	</div>
	<div style="height:20px;line-height:20px">
	<div style="float:left;width:80px;text-align:left">TEL:</div><div style="float:left">0752-2085988</div>
	</div>
	</div>
<script type="text/javascript">
var timeout=100;    //比较时间 
var begintime  ;   //开始时刻 
var endtime   ;    //结束时间
function  keydown(){ 
    begintime=new Date().getTime()  
}  
Ext.onReady(function(){
	setInterval(function(){
		endtime=new Date().getTime() 
	   <#--时间间隔大于比较时间清空卡号-->
	   if(endtime-begintime>timeout) {
	    	document.getElementById("iccard-inputEl").value="";
	   }
	},timeout);
	 var loginForm = Ext.create('Ext.form.Panel', {           
		autoWidth : true,    
        border : false,                
        defaultType: 'textfield',
        defaults : {
			width : 260,
			labelWidth: 30
		},
		style: {
    		textAlgin:'center',
    		paddingLeft:'80px',
    		paddingTop:'30px'
		},
        items: [
        	{
				fieldLabel : '<@s.text name="Login.account" />',
				labelAlign:'right',
				name : 'account',
				id : 'account',
				blankText : '<@s.text name="Login.account.cannot.null" />',
				maxLength : 30,
				maxLengthText : '<@s.text name="Login.account.maxLength" />',
				allowBlank : false,
				listeners : {
					specialkey : function(field, e) {
						if (e.getKey() == Ext.EventObject.ENTER) {
							Ext.getCmp('password').focus();
						}
					}
				}
			}, {
				fieldLabel : '<@s.text name="Login.password" />',
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
							<#if map.get("gx_need_card")?default('1') == '1'>
							Ext.getCmp('iccard').focus();
							<#else>
							preLogin();
							</#if>
						}
					}
				}
			}<#if map.get("gx_need_card")?default('1') == '1'>, {
				fieldLabel : '<@s.text name="Login.icCard" />',
				name : 'iccard',
				id : 'iccard',
				enableKeyEvents:true,
				inputType : 'password',
				allowBlank : false,
				listeners : {
					specialkey : function(field, e) {
						if (e.getKey() == Ext.EventObject.ENTER) {
							preLogin();
						}
					}
				}
			}</#if>
        ]
    });
    
	var mainPanel = Ext.create("Ext.panel.Panel",{
		layout:'border',
		border:false,
		items : [ 
			{
				region : 'north',
				autoScroll : false,
				<#--2013-06-17 不允许客户自己行上传logo,hubo-->
				<#assign logo_img = "/resources/images/login_banner.png" />
				html:'<div id="banner-tabs"><img border="0" width="450" height="70" src="${logo_img}" /></div>'
			}, {
				region : 'center',
				xtype: 'tabpanel',
				activeTab: 0, // index or id
				items:[{
					layout:'fit',
				    title: '<@s.text name="Login.auth" />',
				    items:[ loginForm ]
				},{
				    title: '<@s.text name="Login.about" />格讯',
				    contentEl : 'aboutDiv'
				}]
			} 
		]
	});

	var mainMenu = new Ext.menu.Menu({
		id : 'mainMenu',
		items : [{
			text : '<@s.text name="Login.clear" />',
			iconCls : 'status_awayIcon',
			handler : function() {
				clearCookie('gxerp.login.account');
				var account = Ext.getCmp('account');
				Ext.getCmp('loginForm').form.reset();
				account.setValue('');
				account.focus();
			}
		}]
	});
	var win = new Ext.Window({
		title : '<@s.text name="Login.page" />',
		layout : 'fit',
		width : 460,
		height : 300,
		collapsible : true,
		maximizable : false,
		draggable : true,
		closable : false,
		resizable : false,
		animateTarget : document.body,
		items : [mainPanel],
		buttons : [
		{
			text:'注册',
			iconCls:'acceptIcon',
			handler:function(){
				window.location.href = '/regist/indexWithRegist.js';
			}
		},
		{
			text : '<@s.text name="Login.login" />',
			iconCls : 'acceptIcon',
			handler : function() {
				preLogin();
			}
		}, {
			text : '<@s.text name="Login.item" />',
			iconCls : 'tbar_synchronizeIcon',
			menu : mainMenu
		}]
	});
	var viewport = new Ext.Viewport({
		items : [win]
	});	
	win.show();
	win.on('show', function() {
		setTimeout(function() {
			var account = Ext.getCmp('account');
			var password = Ext.getCmp('password');
			var c_account = getCookie('gxerp.login.account');
			account.setValue(c_account);
			if (Ext.isEmpty(c_account)) {
				account.focus();
			} else {
				password.focus();
			}
		}, 200);
	}, this);

	function preLogin(){
		if (Ext.isIE) {
			Ext.MessageBox
						.alert('<@s.text name="prompt" />', '<@s.text name="Login.notIE" />')
				return false;
			
		}
		login();
	}
	function login() {
		if (loginForm.form.isValid()) {
			loginForm.form.submit({
				url : 'loginCheck.js',
				waitTitle : '<@s.text name="prompt" />',
				method : 'POST',
				waitMsg : '<@s.text name="Login.wait" />',
				success : function(form, action) {
					var account = Ext.getCmp('account');
					setCookie("gxerp.login.account", account.getValue(), 240);
					setCookie("gxerp.login.userid", action.result.userid, 240);
					setCookie("gxerp.lockflag", '0', 240);
					if(!isEmpty(action.result.willpastdue)){
						showTitMsg("<span style='color:red'>您的系统将在"+action.result.willpastdue+"天后到期，请与开发商联系</span>",function(){
							window.location.href = 'indexInit.js';
						});
					}else{
						window.location.href = 'indexInit.js';
					}
				},
				failure : function(form, action) {				
					var errmsg = action.result.failure;					
					showErrorMsg('<span style="color:red">'+errmsg+'</span>', function(){
						var havelogin = action.result.havelogin;
						if("1" == havelogin){
							window.location.href="/indexInit.js";
						}
					});
				}
			});
		}
	}
	var imgs = ['/resources/images/login_banner.png'];
	var wrappedImage = Ext.create('Ext.Img', {
	    src: imgs[0],
	    renderTo: Ext.getBody()
	});
	<#if map.get("gx_need_card")?default('1') == '1'>
		$("iccard").addListener("keydown", keydown);
		document.getElementById("iccard-inputEl").onpaste=function(){return false}
		document.getElementById("iccard-inputEl").onbeforepaste=function(){clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))}
	</#if>
	<#if listItem?size &gt; 0>
	<#--用于切换图片数组-->
	var imgs = [<#list listItem as k><#if k_index != 0>,</#if>'${k.fpicPath?default('')}'</#list>];
	var wrappedImage = Ext.create('Ext.Img', {
	    src: imgs[0],
	    renderTo: Ext.getBody()
	});
	<#if listItem?size &gt; 1>
	<#--开始索引为1，因为0已经在初始化的时候使用-->
	var imageIndex = 1;
	setTimeout(function(){<#--延时4秒启动-->
		var wid = wrappedImage.getWidth();<#--初始的图片宽和高-->
		var hei = wrappedImage.getHeight();
		Ext.TaskManager.start({
		     run: function(){
		     	<#--透明度渐变-->
	     		Ext.create('Ext.fx.Anim', {
				    target: wrappedImage,
				    duration: 3000,
				    from: {
				         opacity : 1
				    },
				    to: {
				         opacity : 0
				    },
				    listeners: {
				    	afteranimate : function(obj, startTime, eOpts){
				    		wrappedImage.setSrc(imgs[imageIndex]);
				    		imageIndex++;
							if(imageIndex == ${listItem?size}){
								imageIndex = 0;
							}
				    		Ext.create('Ext.fx.Anim', {
							    target: wrappedImage,
							    duration: 3000,
							    from: {
				         			 opacity : 0
							    },
							    to: {
				         			 opacity : 1
							    }
							});
				    	}
				    }
				});
		     },
		     interval: 10000
		});
	}, 4000);
	</#if>
	</#if>
});
</script>
</@CommonMacro.page>
