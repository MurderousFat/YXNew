function tcjgFuc(aaz217,ykc618,callback){
	var params = {
			ckz543:ckz543,//医院编号
			aae011:aae011,//登录账号
			sessionid:sessionid,//已登录凭证
			aaz217:aaz217,
			ykc618:ykc618
	};
	var xmlParams = jQuery.json2xml(params,{rootTagName:'input'});
	showWaitMsg();
	jQuery.ajax({
		type : 'post',
		url : '${base}/his/jsdcxDataByHis.tz',
		contentType : 'text/xml; charset=utf-8',
		data : xmlParams
	}).done(function(result) {
		hideWaitMsg();
		var d = jQuery.xml2json(result);
        if(d.code){
			if(d.code=='1'){
				var _r = d.output;
				if(callback)callback(_r);
			}else{
				showErrorMsg(d.message);
			}
		}else{
			showErrorMsg(d.message);
		}
	});
}