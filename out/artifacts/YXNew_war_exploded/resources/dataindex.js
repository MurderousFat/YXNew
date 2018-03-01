var _global_text_index = {
		'test':'测试',
		'global.test':'全局测试'
		,'tips.select.row':'请选择列表中的行'
		,'tips.save.success':'保存成功'
		,'tips.remove.success':'删除成功'
};

var _global_btn_index = {
		'add':{icon:'addIcon',text:'新增'}
		,'edit':{icon:'edit1Icon',text:'编辑'}
		,'del':{icon:'deleteIcon',text:'删除'}
		,'refresh':{icon:'arrow_refreshIcon',text:'刷新'}
		,'exit':{icon:'deleteIcon',text:'退出'}
		,'save':{icon:'acceptIcon',text:'保存'}
		,'close':{icon:'deleteIcon',text:'关闭'}
		,'preview':{icon:'previewIcon',text:'查看'}
		,'refresh':{icon:'arrow_refreshIcon',text:'刷新'}
		,'search':{icon:'previewIcon',text:'查询'}
		,'menuPerm':{icon:'group_linkIcon',text:'菜单授权'}
		,'btnsPerm':{icon:'group_linkIcon',text:'按钮授权'}
		,'copyPerm':{icon:'comments_addIcon',text:'复制授权'}
		,'pastePerm':{icon:'comments_addIcon',text:'粘贴授权'}
		,'copy':{icon:'comments_addIcon',text:'复制'}
		,'paste':{icon:'comments_addIcon',text:'粘贴'}
		,'handup':{icon:'uploadIcon',text:'上报'}
		,'send':{icon:'app_rightIcon',text:'传送'}
		,'settle':{icon:'arrow_switchIcon',text:'结算'}
		,'seize':{icon:'s_customer',text:'受理'}
		,'reject':{icon:'exclamation24',text:'驳回'}
		,'sendAndSettle':{icon:'app_rightIcon',text:'传送并结算'}
		,'back':{icon:'app_leftIcon',text:'回退'}
		,'back1':{icon:'app_leftIcon',text:'回退'}
		,'print':{icon:'printerIcon',text:'打印'}
		,'reset':{icon:'arrow_refreshIcon',text:'重置'}
		,'read':{icon:'previewIcon',text:'读卡'}
		,'settle1':{icon:'arrow_switchIcon',text:'结算'}
		,'settle2':{icon:'arrow_switchIcon',text:'结算'}
		,'login':{icon:'arrow_switchIcon',text:'登录'}
};


function g_TextFromIndex(_key){
	return _global_text_index[_key];
}

function g_BtnFromIndex(_key){
	return _global_btn_index[_key];
}

art.dialog.data('g_TextFromIndex',g_TextFromIndex);
art.dialog.data('g_BtnFromIndex',g_BtnFromIndex);