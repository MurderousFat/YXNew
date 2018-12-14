function checkUpdate(){
	showWaitMsg("正在检查更新，请稍候！");
	Ext.Ajax.request({
		url : '/baseinfos/getVersionByAutoUpdate.js?',
		method : 'get',
		success : function(response) {
			hideWaitMsg();
			var text = response.responseText;
			var result = Ext.JSON.decode(text);
			if(result.success){
				if(result.patch){
					var newVersion = result.patch.fversion;
					showTitMsg("目标版本："+newVersion+" 点击“确定”按钮开始更新<br /><a href='http://www.gxsofts.com:7000/pack/"+newVersion+"/pack.htm' style='color:red' target='_blank'>点击“这里”查看更新说明 </a>", function(){
						confirmMessage("本次更新需要的时间取决于网络传输速度。更新期间，部分用户可能无法使用系统且更新完成之后，系统会强制停止WEB服务，建议您在使用人数较少的时间段更新或者通知使用者停止使用。确定现在更新吗？", function(){
							Ext.MessageBox.show({
					           msg: '正在下载和安装补丁程序，请稍候...',
					           progressText: 'Saving...',
					           width:300,
					           wait:true,
					           waitConfig: {interval:200}
					       });
						   Ext.Ajax.request({
								url : '/baseinfos/runByAutoUpdate.js',
								method : 'get',
								timeout: 6000000,
								success : function(response) {
									hideWaitMsg();
									var text = response.responseText;
									var obj = Ext.JSON.decode(text);
									
									
									if(obj.success){
										if(!result.patch.fneedReboot || 'false'==result.patch.fneedReboot){
											showTitMsg("系统更新成功");
										}else{
											showTitMsg("系统更新成功，WEB服务已强制停止，请重新启动WEB服务器以使更新生效。");
										}
									}else{
										showErrorMsg("系统更新失败，原因为："+obj.failure+"。请联系技术人员");
									}
								}
							})
						});
					});
				}else{
					showErrorMsg("您的系统已经是最新版本");
				}
			}else{
				showErrorMsg(obj.failure);
			}
		}
	})
}
