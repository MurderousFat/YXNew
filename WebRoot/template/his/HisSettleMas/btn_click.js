function sendPrescription(formJson,gridJson,formDeleteArr,gridDeleteArr,callback){
	var formJsonParams = jQuery.extend({},{
		aac044:'',
		aac057:'',
		aka130:'',
		akc050:'',
		ckz564:'',
		aaa138:'',
		ckc803:'',
		yzz016:'',
		aae005:'',
		cab053:'',
		ake007:'',
		aae013:'',
		akc190:'',
		akc090:'',
		akc220:'',
		aab014:'',
		akc264:'',
		jyc:'',
		jmc:''
	},formJson,{
		ckz543:ckz543,//医院编号
		aae011:aae011,//登录账号
		sessionid:sessionid//已登录凭证
	});
	for(var i in formDeleteArr){
			delete formJsonParams[formDeleteArr[i]];
	}
	formJsonParams.ake007 = formJsonParams.ake007.replace(/-/g,'');
	formJsonParams.akc090 = '';
	
	var items = [];
	for(var i in gridJson){
		var item = jQuery.extend({},{
			ykc610:'',
			yka111:'',
			yka112:'',
			akc222y:'',
			akc223y:'',
			akc224:'',
			yke230:'',
			yke231:'',
			akc226:'',
			akc225:'',
			akc264:'',
			ykc611:'',
			aka074:'',
			aka067:'',
			cka588:'',
			cke522:'',
			aae030:'',
			aae031:'',
			akc056:'',
			akc273:'',
			aae386:'',
			akc221:'',
			aae011:'',
			ckc940:'',
			aka031:'',
			aka032:'',
			aka033:'',
			aka081:'',
			ake135:'',
			aka072:'',
			aka071:'',
			ake131:'',
			akc231:'',
			ake004:'',
			aka064:'',
			aka184:'',
			aka172:'',
			aka187:'',
			aac004:'',
			aka169:'',
			aka170:'',
			aka196:'',
			ake134:'',
			ake130:'',
			aae310:'',
		},gridJson[i]);
			
		for(var j in gridDeleteArr){
			if(item[gridDeleteArr[j]])
				delete item[gridDeleteArr[j]];
		}
		if(item.akc221){
			item.akc221 = item.akc221.replace(/-/g,'');
		}
		if(item.aae311){
			item.aae311 = null; 
		}
	
		item.aae011=aae011;
		items.push(item);
	}
	
	formJsonParams.dataset = {};
	formJsonParams.dataset.row = items;
	console.log(formJsonParams);
	var xmlParams = jQuery.json2xml(
		formJsonParams
	,{rootTagName:'input'});
	console.log(xmlParams);
	showWaitMsg();
	jQuery.ajax({
		type : 'post',
		url : '${base}/his/mzdjcscfDataByHis.tz',
		contentType : 'text/xml; charset=utf-8',
		data : xmlParams
	}).done(function(result) {
		console.log(result);
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

function backPrescription(aac044,aaz217,callback){
	showWaitMsg();
	var params = {
			ckz543:ckz543,//医院编号
			aae011:aae011,//登录账号
			sessionid:sessionid,//已登录凭证
			aac044:aac044,
			aaz217:aaz217
	};
	var xmlParams = jQuery.json2xml(params,{rootTagName:'input'});
	console.log(xmlParams);
	jQuery.ajax({
		type : 'post',
		url : '${base}/his/mzjzhtDataByHis.tz',
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
	},_params,{jyc:jyc||'',jmc:jmc||''});
	var xmlParams = jQuery.json2xml(params,{rootTagName:'input'});
	console.log(xmlParams);
	showWaitMsg();
	jQuery.ajax({
		type : 'post',
		url : '${base}/his/fyjsDataByHis.tz',
		contentType : 'text/xml; charset=utf-8',
		data : xmlParams
	}).done(function(result) {
		console.log(result);
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
		url : '${base}/his/fyjshtDataByHis.tz',
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
		async: false,
		data : xmlParams
	}).done(function(result) {
		hideWaitMsg();

		var d = jQuery.xml2json(result);
		
		console.log( d );

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