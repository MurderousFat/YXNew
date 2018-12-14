function showBtnsPermWindow(record){
    var roleType = record.get("roleType");
    if(roleType == "3"){
    	showErrorMsg("超级用户不用授权");
	    return;
    }
    var roleNo = record.get("id");
    if(roleNo == ""){
    	<#--不能给自己授权--->
    	showErrorMsg("不能给自己授权");
	}else{
		newBtnPermWin.show();
		showWaitMsg("正在加载可授权按钮列表，由于被授权按钮比较多，可能页面布局会稍慢，请稍候...");
		document.getElementById("newBtnPerm_frame").src="${base}/sys/btnsPerm_SysPerm.tz?roleId="+record.data.id;
	}
	    
}
var newBtnPermWin = Ext.create('Ext.Window', {
        title: '按钮授权',
        width: document.body.clientWidth,
        height: document.body.clientHeight,
        border : false,
        x: 0,
        y: 0,
        resizable : true,
		draggable : true,
		closeAction : 'close',
        plain: true,
        layout: 'fit',
        id:'newBtnPermWin',
        html:'<iframe scrolling="auto" id="newBtnPerm_frame" frameborder="0" width="100%" height="100%" ></iframe>'
});
