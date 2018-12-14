function sendInpatientRegistration(formJson,formDeleteArr,callback){
	var formJsonParams = jQuery.extend({},{
		aac044:'',
		aac057:'',
		yzz016:'',
		aka130:'',
		akc190:'',
		akc090:'',
		akf001:'',
		ykc012:'',
		akc050:'',
		akc193:'',
		ykc601:'',
		ykc602:'',
		ckz564:'',
		ckc798:'',
		ckc949:'',
		ykc701:'',
		aae005:'',
		aae013:'',
		IN_HOSP_TYPE:'',
		aab014:'',
		ckc936:'',
		ckc936:'',
		jyc:'',
		jmc:'',
	},formJson,{
		ckz543:ckz543,//医院编号
		aae011:aae011,//登录账号
		sessionid:sessionid//已登录凭证
	});
	for(var i in formDeleteArr){
			delete formJsonParams[formDeleteArr[i]];
	}
	formJsonParams.ykc701 = formJsonParams.ykc701.replace(/-/g,'');
	
	var xmlParams = jQuery.json2xml(
		formJsonParams
	,{rootTagName:'input'});
	console.log(xmlParams);
	showWaitMsg();
	jQuery.ajax({
		type : 'post',
		url : '${base}/his/rydjDataByHis.tz',
		contentType : 'text/xml; charset=utf-8',
		data : xmlParams
	}).done(function(result) {
		hideWaitMsg();
		var d = jQuery.xml2json(result);
		console.log(d);
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

function backInpatientRegistration(aac044,aaz217,callback){
	var params = {
			ckz543:ckz543,//医院编号
			aae011:aae011,//登录账号
			sessionid:sessionid,//已登录凭证
			aac044:aac044,
			aaz217:aaz217
	};
	var xmlParams = jQuery.json2xml(params,{rootTagName:'input'});
	showWaitMsg();
	jQuery.ajax({
		type : 'post',
		url : '${base}/his/jzdjhtDataByHis.tz',
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


function feeSettlement(_params,callback){
	var params = jQuery.extend({},{
		ckz543:ckz543,//医院编号
		aae011:aae011,//登录账号
		sessionid:sessionid,//已登录凭证
		aac044:'',
		ykc675:'',//结算类型
		aaz217:'',//就诊记录号
		akc264:'',
		jbrmc:'',
		aae013:'',
	},_params,{
		jyc:jyc,
		jmc:jmc
	});
	var xmlParams = jQuery.json2xml(params,{rootTagName:'input'});
	showWaitMsg();
	jQuery.ajax({
		type : 'post',
		url : '${base}/his/fyjsDataByHis.tz',
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

function backFeeSettlement(aac044,aaz217,ykc618,callback){
	var params = {
			ckz543:ckz543,//医院编号
			aae011:aae011,//登录账号
			sessionid:sessionid,//已登录凭证
			aac044:aac044,
			aaz217:aaz217,
			ykc618:ykc618
	};
	var xmlParams = jQuery.json2xml(params,{rootTagName:'input'});
	showWaitMsg();
	jQuery.ajax({
		type : 'post',
		url : '${base}/hisfyjshtDataByHis.tz',
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


function treatmentJudgment(_params,callback){
	var params = jQuery.extend({},{
		ckz543:ckz543,//医院编号
		aae011:aae011,//登录账号
		sessionid:sessionid,//已登录凭证
		aac044:'',
		bbd068:'',//业务类别
		ake007:''//就诊日期
	},_params);
	var xmlParams = jQuery.json2xml(params,{rootTagName:'input'});
	console.log(xmlParams);
	showWaitMsg();
	jQuery.ajax({
		type : 'post',
		url : '${base}/his/dyxsDataByHis.tz',
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

/** 就诊资料查询 */
function queryJzzlcx(_params,callback){
	var params = jQuery.extend({},{
		ckz543:ckz543,//医院编号
		aae011:aae011,//登录账号
		sessionid:sessionid,//已登录凭证
		aac044:'',
		aaz217:'',
		aae030:'20170615',//业务类别
		aae031:'20170617'//就诊日期
	},_params);
	var xmlParams = jQuery.json2xml(params,{rootTagName:'input'});
	console.log(xmlParams);
	showWaitMsg();
	jQuery.ajax({
		type : 'post',
		url : '${base}/his/jzzlcxDataByHis.tz',
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

