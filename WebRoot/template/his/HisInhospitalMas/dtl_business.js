function sendHisResult(masId,type,content,callback){
	jQuery.ajax({
		type : 'post',
		url : '${base}/his/updateByHisResult.tz',
		data : {
			masId:masId,
			type:type,
			content:jQuery.toJSON(content),
			version:0
		},
		dataType:'json'
	}).done(function(result) {
		if(result.success){
			if(callback)callback();
		}else{
			showErrorMsg(result.failure);
		}
	});
}
function sendPrescription(formJson,gridJson,formDeleteArr,gridDeleteArr,callback){
	var formJsonParams = jQuery.extend({},{
		aac044:'',
		aaz217:'',
		akc220:'',
		aab014:'',
	},formJson,{
		ckz543:ckz543,//医院编号
		aae011:aae011,//登录账号
		sessionid:sessionid//已登录凭证
	});
	for(var i in formDeleteArr){
			delete formJsonParams[formDeleteArr[i]];
	}
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
	
		items.push(item);
	}
	
	formJsonParams.dataset = {};
	formJsonParams.dataset.row = items;
	console.log(formJsonParams);
	var xmlParams = jQuery.json2xml(
		formJsonParams
	,{rootTagName:'input'});
	showWaitMsg();
	jQuery.ajax({
		type : 'post',
		url : '${base}/his/cfxmcsDataByHis.tz',
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
