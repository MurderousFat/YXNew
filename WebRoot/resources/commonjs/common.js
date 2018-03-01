/**
 * 显示请求等待进度条窗口
 * 
 * @param {}
 *            msg
 */
function showWaitMsg(msg) {
	Ext.MessageBox.show({
		title : '系统提示',
		msg : msg == null ? '正在处理数据,请稍候...' : msg,
		progressText : 'processing now,please wait...',
		width : 300,
		wait : true,
		closable : false,
		waitConfig : {
			interval : 150
		}
	});
}
function randParam() {
	return parseInt(Math.random() * 10000);
}
function showErrorMsg(msgText, afterfn) {
	setTimeout(function(){
		Ext.MessageBox.show({
			title : '对不起',
			msg : '<span style="color:red">' + msgText + '</span>',
			buttons : Ext.MessageBox.OK,
			icon : 'x-message-box-error',
			fn : afterfn
		});
	},50);
}
function showTitMsg(msgText, afterfn) {
	setTimeout(function(){
		Ext.MessageBox.show({
			title : '提示',
			msg : msgText,
			buttons : Ext.MessageBox.OK,
			icon : 'x-message-box-info',
			fn : afterfn
		});
	},50);
}
/**
 * 打印标识图片
 * 
 * @param val
 *            1已打印 其它未打印
 * @returns {String}
 *          做了小的调整,以前用0来做未打控制,担新增时可能是null就会判断不出来,现只做已打印,这样就可避过这个问题,//wmle
 */

function printStatu(val) {
	if ("1" == val) {
		return '<img src="/resources/extjs4/resources/image/ext/accept.png" height="14" title="已打印"/>';
	} else {
		return '<img src="/resources/extjs4/resources/image/ext/delete.png" height="14" title="未打印"/>';
	}
}
/**
 * 记录移到上一条下一条
 * 
 * @param sgrid
 * @param sform
 * @param flag
 *            0:上一条 1：下一条
 */
function moveToNextRecord(sgrid, sform, flag) {
	if (Ext.isEmpty(cur_record)) {
		cur_record = sgrid.getSelectionModel().getLastSelected();
	}

	if (Ext.isEmpty(cur_record)) {
		return;
	}

	var index = sgrid.getStore().indexOf(cur_record);
	if (flag == 0) {
		index = index - 1;
	} else {
		index = index + 1;
	}
	var preRecord = sgrid.getStore().getAt(index);

	if (!Ext.isEmpty(preRecord)) {
		sform.getForm().loadRecord(preRecord);
		cur_record = preRecord;
	}
}

/**
 * 隐藏请求等待进度条窗口
 */
function hideWaitMsg() {
	Ext.MessageBox.hide();
}

/**
 * 将JS数组转换为JS字符串 表格复选框专用
 */
function jsArray2JsString(arrayChecked, id) {
	var strChecked = "";
	for ( var i = 0; i < arrayChecked.length; i++) {
		strChecked = strChecked + arrayChecked[i].get(id) + ',';
	}
	return strChecked.substring(0, strChecked.length - 1)
}

/**
 * 清除Ext.Form表单元素
 */
function clearForm(pForm) {
	var formItems = pForm.items['items'];
	for (i = 0; i < formItems.length; i++) {
		element = formItems[i];
		element.setValue('');
		element.reset(); // 避免出现红色波浪线
	}
}

/**
 * 设置表单未只读
 * 
 * @param pForm
 */
function setFormReadOnly(pForm) {
	var formItems = pForm.items;
	for (i = 0; i < formItems.length; i++) {
		element = formItems[i];
		element.readOnly = true;
	}
}

/**
 * 复制到剪贴板
 */
function copyToClipboard(txt) {
	if (window.clipboardData) {
		window.clipboardData.clearData();
		window.clipboardData.setData("Text", txt);
	} else if (navigator.userAgent.indexOf("Opera") != -1) {
		window.location = txt;
	} else if (window.netscape) {
		try {
			netscape.security.PrivilegeManager
					.enablePrivilege("UniversalXPConnect");
		} catch (e) {
			Ext.Msg
					.alert(
							'提示',
							"复制单元格操作被浏览器拒绝！\n请在浏览器地址栏输入'about:config'并回车\n然后将'signed.applets.codebase_principal_support'设置为'true'")
		}
		var clip = Components.classes['@mozilla.org/widget/clipboard;1']
				.createInstance(Components.interfaces.nsIClipboard);
		if (!clip)
			return;
		var trans = Components.classes['@mozilla.org/widget/transferable;1']
				.createInstance(Components.interfaces.nsITransferable);
		if (!trans)
			return;
		trans.addDataFlavor('text/unicode');
		var str = new Object();
		var len = new Object();
		var str = Components.classes["@mozilla.org/supports-string;1"]
				.createInstance(Components.interfaces.nsISupportsString);
		var copytext = txt;
		str.data = copytext;
		trans.setTransferData("text/unicode", str, copytext.length * 2);
		var clipid = Components.interfaces.nsIClipboard;
		if (!clip)
			return false;
		clip.setData(trans, null, clipid.kGlobalClipboard);
		// Ext.Msg.alert('提示','单元格内容已成功复制到剪贴板!')
	}
}

/**
 * 初始化报表打印窗口
 */
function doPrint2(pKey, pFlag, url, pWidth, pHeight) {
	var initUrl = url;
	if (!Ext.isEmpty(pFlag))
		initUrl = initUrl + '?flag=' + pFlag;
	if (!Ext.isEmpty(pKey))
		initUrl = initUrl + '&' + pKey;
	if (Ext.isEmpty(pWidth))
		pWidth = 800;
	if (Ext.isEmpty(pHeight))
		pHeight = 600;
	var left = (screen.width - pWidth) / 2;
	var top = (screen.height - pHeight) / 2;
	var str = 'width='
			+ pWidth
			+ ',height='
			+ pHeight
			+ ',top='
			+ top
			+ ",left="
			+ left
			+ ',toolbar=no,menubar=no,scrollbars=no,resizable=yes,location=no,status=no';
	window.open(webContext + initUrl, '', str);
}
/**
 * 初始化报表打印窗口
 */
function doPrint(pFlag, url, pWidth, pHeight) {
	var initUrl = url;
	if (!Ext.isEmpty(pFlag))
		initUrl = initUrl + '?flag=' + pFlag;
	if (Ext.isEmpty(pWidth))
		pWidth = 800;
	if (Ext.isEmpty(pHeight))
		pHeight = 600;
	var left = (screen.width - pWidth) / 2;
	var top = (screen.height - pHeight) / 2;
	var str = 'width='
			+ pWidth
			+ ',height='
			+ pHeight
			+ ',top='
			+ top
			+ ",left="
			+ left
			+ ',toolbar=no,menubar=no,scrollbars=no,resizable=yes,location=no,status=no';
	window.open(webContext + initUrl, '', str);
}

/**
 * 初始化报表打印窗口，窗口关闭后执行回调函数
 */
function doPrintWithCallback(pFlag, pWidth, pHeight) {
	var initUrl = '/report.ered?reqCode=initAppletPage';
	if (!Ext.isEmpty(pFlag))
		initUrl = initUrl + '&flag=' + pFlag;
	if (Ext.isEmpty(pWidth))
		pWidth = 800;
	if (Ext.isEmpty(pHeight))
		pHeight = 600;
	var timer, popwin;
	var left = (screen.width - pWidth) / 2;
	var top = (screen.height - pHeight) / 2;
	var str = 'width='
			+ pWidth
			+ ',height='
			+ pHeight
			+ ',top='
			+ top
			+ ",left="
			+ left
			+ ',toolbar=no,menubar=no,scrollbars=no,resizable=yes,location=no,status=no';
	popwin = window.open(webContext + initUrl, '', str);
	timer = window.setInterval(function() {
		if (popwin.closed == true) {
			window.clearInterval(timer);
			Ext.MessageBox.confirm('请确认', '打印是否成功?', function(btn, text) {
				if (btn == 'yes') {
					// 在这个回调函数中实现打印次数纪录功能,此函数不能写在Ext作用域内
					fnPrintCallback();
				} else {
					return;
				}
			});
		}
	}, 500);
}

/**
 * 初始化PDF导出窗口
 */
function doExport(pFlag, pWidth, pHeight) {
	var initUrl = '/report.ered?reqCode=initPdfPage';
	if (!Ext.isEmpty(pFlag))
		initUrl = initUrl + '&flag=' + pFlag;
	if (Ext.isEmpty(pWidth))
		pWidth = 800;
	if (Ext.isEmpty(pHeight))
		pHeight = 600;
	var left = (screen.width - pWidth) / 2;
	var top = (screen.height - pHeight) / 2;
	var str = 'width='
			+ pWidth
			+ ',height='
			+ pHeight
			+ ',top='
			+ top
			+ ",left="
			+ left
			+ ',toolbar=no,menubar=no,scrollbars=no,resizable=yes,location=no,status=no';
	window.open(webContext + initUrl, '', str);
}

/**
 * 初始化报PDF导出窗口，窗口关闭后执行回调函数
 */
function doExportWithCallback(pFlag, pWidth, pHeight) {
	var initUrl = '/report.ered?reqCode=initPdfPage';
	if (!Ext.isEmpty(pFlag))
		initUrl = initUrl + '&flag=' + pFlag;
	if (Ext.isEmpty(pWidth))
		pWidth = 800;
	if (Ext.isEmpty(pHeight))
		pHeight = 600;
	var timer, popwin;
	var left = (screen.width - pWidth) / 2;
	var top = (screen.height - pHeight) / 2;
	var str = 'width='
			+ pWidth
			+ ',height='
			+ pHeight
			+ ',top='
			+ top
			+ ",left="
			+ left
			+ ',toolbar=no,menubar=no,scrollbars=no,resizable=yes,location=no,status=no';
	popwin = window.open(webContext + initUrl, '', str);
	timer = window.setInterval(function() {
		if (popwin.closed == true) {
			window.clearInterval(timer);
			Ext.MessageBox.confirm('请确认', '打印/导出是否成功?', function(btn, text) {
				if (btn == 'yes') {
					// 在这个回调函数中实现打印次数纪录功能,此函数不能写在Ext作用域内
					fnExportCallback();
				} else {
					return;
				}
			});
		}
	}, 500);
}

/**
 * 通过iFrame实现类ajax文件下载
 */
function exportExcel(url) {
	var exportIframe = document.createElement('iframe');
	exportIframe.src = url;
	exportIframe.style.display = "none";
	document.body.appendChild(exportIframe);
	hideWaitMsg();
}

// 这个可以验证15位和18位的身份证，并且包含生日和校验位的验证。
function isIdCardNo(num) {
	if (Ext.isEmpty(num))
		return false;
	num = num.toUpperCase();
	// 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X。
	if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num))) {
		showErrorMsg('输入的身份证号长度不对，或者号码不符合规定！\n15位号码应全为数字，18位号码末位可以为数字或X。');
		return false;
	}
	// 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
	// 下面分别分析出生日期和校验位
	var len, re;
	len = num.length;
	if (len == 15) {
		re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);
		var arrSplit = num.match(re);
		// 检查生日日期是否正确
		var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/'
				+ arrSplit[4]);
		var bGoodDay;
		bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2]))
				&& ((dtmBirth.getMonth() + 1) == Number(arrSplit[3]))
				&& (dtmBirth.getDate() == Number(arrSplit[4]));
		if (!bGoodDay) {
			showErrorMsg('输入的身份证号里出生日期不对！');
			return false;
		} else {
			// 将15位身份证转成18位
			// 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
			var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5,
					8, 4, 2);
			var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4',
					'3', '2');
			var nTemp = 0, i;
			num = num.substr(0, 6) + '19' + num.substr(6, num.length - 6);
			for (i = 0; i < 17; i++) {
				nTemp += num.substr(i, 1) * arrInt[i];
			}
			num += arrCh[nTemp % 11];
			return num;
		}
	}
	if (len == 18) {
		re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);
		var arrSplit = num.match(re);
		// 检查生日日期是否正确
		var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/"
				+ arrSplit[4]);
		var bGoodDay;
		bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2]))
				&& ((dtmBirth.getMonth() + 1) == Number(arrSplit[3]))
				&& (dtmBirth.getDate() == Number(arrSplit[4]));
		if (!bGoodDay) {
			// alert(dtmBirth.getYear());
			// alert(arrSplit[2]);
			showErrorMsg('输入的身份证号里出生日期不对！');
			return false;
		} else {
			// 检验18位身份证的校验码是否正确。
			// 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
			var valnum;
			var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5,
					8, 4, 2);
			var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4',
					'3', '2');
			var nTemp = 0, i;
			for (i = 0; i < 17; i++) {
				nTemp += num.substr(i, 1) * arrInt[i];
			}
			valnum = arrCh[nTemp % 11];
			if (valnum != num.substr(17, 1)) {
				showErrorMsg('18位身份证的校验码不正确！应该为:' + valnum);
				return false;
			}
			return num;
		}
	}
	return false;
}

/**
 * 设置Cookie
 * 
 * @param {}
 *            name
 * @param {}
 *            value
 */
function setCookie(name, value, minuts) {
	var argv = setCookie.arguments;
	var argc = setCookie.arguments.length;
	var expiration = new Date((new Date()).getTime() + minuts * 60000 * 60);
	document.cookie = name + "=" + escape(value) + "; expires="
			+ expiration.toGMTString();
}

/**
 * 获取Cookie
 * 
 * @param {}
 *            Name
 * @return {}
 */
function getCookie(Name) {
	var search = Name + "="
	if (document.cookie.length > 0) {
		offset = document.cookie.indexOf(search)
		if (offset != -1) {
			offset += search.length
			end = document.cookie.indexOf(";", offset)
			if (end == -1)
				end = document.cookie.length
			return unescape(document.cookie.substring(offset, end))
		} else
			return ""
	}
}

/**
 * 从缓存中清除Cookie
 * 
 * @param {}
 *            name
 */
function clearCookie(name) {
	var expdate = new Date();
	expdate.setTime(expdate.getTime() - (86400 * 1000 * 1));
	setCookie(name, "", expdate);
}

/**
 * 提交表单
 * 
 * @param targetUrl
 *            表单提交目标地址
 * @param formObj
 *            表单对象
 * @param successFn
 *            提交成功回调方法
 * @param failureFn
 *            提交失败回调方法
 */
function submitForm(targetUrl, formObj, successFn, failureFn, checkFn) {
	if (formObj.form.isValid()) {
		if (checkFn != undefined) {
			if (checkFn() == false) {
				return false;
			}
		}
		showWaitMsg();
		formObj.form.submit({
			url : targetUrl,
			method : 'POST',
            submitEmptyText: false,
			success : function(form, action) {
				hideWaitMsg();
				successFn(form, action);
			},
			failure : function(form, action) {
				hideWaitMsg();
				failureFn(form, action);
			}
		});
	}
}

/**
 * 创建窗体
 * 
 * @param title
 *            标题
 * @param formObj
 *            窗体内放置的Form对象
 * @param wid
 *            窗体宽
 * @param buttons
 *            窗体按钮
 * @returns 返回创建好的窗体
 */
function createWindow(title, formObj, wid, buttons) {
	var win = Ext.create('Ext.Window', {
		title : title,
		width : wid,
		border : false,
		x : 20,
		y : document.body.clientWidth / 15,
		resizable : true,
		draggable : true,
		closeAction : 'close',
		plain : true,
		layout : 'fit',
		items : [ formObj ],
		buttons : [ buttons ]
	});
	win.on("hide", function() {
		formObj.form.reset();
	});

	return win;
}
/**
 * 获取一个grid被选中的行的数组
 * 
 * @param gridObj
 *            grid对象
 * @returns
 */
function getSelectionRecords(gridObj) {
	return gridObj.getSelectionModel().getSelection();
}
function getSelectedGridData(gridObj, mainKey) {
	var record = getSelectionRecords(gridObj);
	var ids = "";
	for ( var i = 0; i < record.length; i++) {
		ids += record[i].get(mainKey)
		if (i < record.length - 1) {
			ids = ids + ",";
		}
	}
	return ids;
}

/**
 * 批量删除
 * 
 * @param url
 *            请求的URL
 * @param gridObj
 *            grid对象
 * @param mainKey
 *            grid中用于选择的键名，如menuid
 * @param successFn
 *            ，删除成功后的回调方法
 * @returns {Boolean}
 */
function batchRemove(url, gridObj, mainKey, successFn) {
	var ids = getSelectedGridData(gridObj, mainKey);
	if ("" == ids) {
		showErrorMsg('<span style="color:red">请选择您要操作的行！</span>');
		return false;
	} else {
		Ext.MessageBox.confirm('确认', '你确定删除吗?', function(btn) {
			if (btn == "yes") {
				showWaitMsg();
				Ext.Ajax.request({
					url : url,
					params : {
						key : ids
					},
					success : function(response) {
						hideWaitMsg();
						successFn(response);
					}
				});
			}
		});

	}
}

function batchConfirm(url, gridObj, mainKey, successFn) {
	var ids = getSelectedGridData(gridObj, mainKey);
	if ("" == ids) {
		showErrorMsg('<span style="color:red">请选择您要操作的行！</span>');
		return false;
	} else {
		Ext.MessageBox.confirm('确认', '您确定通过吗?', function(btn) {
			if (btn == "yes") {
				showWaitMsg();
				Ext.Ajax.request({
					url : url,
					params : {
						key : ids
					},
					success : function(response) {
						hideWaitMsg();
						successFn(response);
					}
				});
			}
		});

	}
}

function batchRemoveExt(url, ids, mainKey, successFn) {
	if (Ext.isEmpty(ids)) {
		showErrorMsg('<span style="color:red">请选择您要操作的行！</span>');
		return false;
	} else {
		Ext.MessageBox.confirm('确认', '你确定删除吗?', function(btn) {
			if (btn == "yes") {
				showWaitMsg();
				Ext.Ajax.request({
					url : url,
					params : {
						key : ids
					},
					success : function(response) {
						hideWaitMsg();
						successFn(response);
					}
				});
			}
		});

	}
}

function batchOperation(url, gridObj, mainKey, successFn) {
	var ids = getSelectedGridData(gridObj, mainKey);
	if ("" == ids) {
		showErrorMsg('<span style="color:red">请选择您要操作的行！</span>');
		return false;
	} else {
		Ext.MessageBox.confirm('确认', '你确定进行此操作吗?', function(btn) {
			if (btn == "yes") {
				showWaitMsg();
				Ext.Ajax.request({
					url : url,
					params : {
						key : ids
					},
					success : function(response) {
						hideWaitMsg();
						successFn(response);
					}
				});
			}
		});
	}
}

/**
 * 批量行更新
 * 
 * @param store
 * @param url
 */
function batchRowUpdate(store, url, successFn) {
	var newRecs = store.getNewRecords();
	var updateRecs = store.getUpdatedRecords();
	var removeRecs = store.getRemovedRecords();
	var newJsonArray = [];
	var updateJsonArray = [];
	var removeJsonArray = [];
	Ext.each(newRecs, function(item) {
		newJsonArray.push(item.data);
	});
	Ext.each(updateRecs, function(item) {
		updateJsonArray.push(item.data);
	});
	Ext.each(removeRecs, function(item) {
		removeJsonArray.push(item.data);
	});
	showWaitMsg();
	Ext.Ajax.request({
		url : url,
		success : function(response) { // 回调函数有1个参数
			hideWaitMsg();
			successFn(response);
		},
		method : 'post',
		params : {
			newDatas : Ext.encode(newJsonArray),
			updateDatas : Ext.encode(updateJsonArray),
			removeDatas : Ext.encode(removeJsonArray)
		}
	});
}

function removeSelectedRow(gridObj) {
	gridObj.store.remove(gridObj.getSelectionModel().getSelection());
}
function removeSelectedRowWithTit(gridObj) {
	Ext.MessageBox.confirm('确认', '你确定进行此操作吗?', function(btn) {
		if (btn == "yes") {
			gridObj.store.remove(gridObj.getSelectionModel().getSelection());
		}
	});
}
function openDlg(url, height, width) {
	if (url.indexOf("?") == -1) {
		url = url + "?temp_param=" + parseInt(Math.random() * 10000);
	} else {
		url = url + "&temp_param=" + parseInt(Math.random() * 10000);
	}
	window.open(url)
}

function $(id) {
	return Ext.getCmp(id);
}

function isEmpty(obj) {
	return Ext.isEmpty(obj);
}
function heji() {
	return '合计：';
}

/**
 * 格式化合计列， 当value没有小数点的时候，不合计出小数点位， 即不理睬参数：precision
 * 
 * @param value
 * @param summaryData
 * @param dataIndex
 * @param precision
 * @returns
 */
function formatNum2(value, summaryData, dataIndex, precision) {
	var valueStr = value + "";
	var format = '00';
	if (valueStr.indexOf("\.") != -1) {
		if (isEmpty(precision)) {
			precision = 0;
		}
		if (precision != 0) {
			format = format + ".";
			for ( var i = 0; i < precision; i++) {
				format = format + "0";
			}
		}
	}
	return Ext.util.Format.number(parseFloat(value), format);
}

function formatNum(value, summaryData, dataIndex, precision) {
	if (isEmpty(precision)) {
		precision = 0;
	}
	var format = '00';
	if (precision != 0) {
		format = format + ".";
		for ( var i = 0; i < precision; i++) {
			format = format + "0";
		}
	}
	return Ext.util.Format.number(value, format);
}
function formatColumnNum(value, precision) {
	if (isEmpty(precision)) {
		precision = 0;
	}
	var format = '00';
	if (precision != 0) {
		format = format + ".";
		for ( var i = 0; i < precision; i++) {
			format = format + "0";
		}
	}
	return Ext.util.Format.number(value, format);
}
/**
 * 根据货品类型中，对规格类型、数量类型的维护，来动态修改列 boolParams 是否按照货品类型去加载货品属性列 fparamNos
 * 为货品类型中对规格类型的维护 boolQtys 是否按照货品类型加载数量列 fqtys 为货品类型中对数量类型的维护 这个方法，之所以不传参数：var
 * record = itemTypeGrid.getSelectionModel().getLastSelected();的原因是 因为这个方法在<所有有关货品类型选择的单据中>，
 * 查看信息装入单据明细前需要<初始明细单据grid>时，也将使用该方法
 */
function changeCols(boolParams, fparamNos, boolQtys, fqtys) {
	if (boolParams == "true") {
		var params = "color,size,style,spef,font,param1,param2";
		var paramarr = params.split(",");
		/* 动态修改货品属性列 */
		if (!isEmpty(fparamNos)) {
			for ( var i = 0; i < paramarr.length; i++) {
				try {
					/*
					 * 使用try-catch块，是由于在调整单中，列字段并不是color,size形式，
					 * 而是fromColor,targetColor形式，此时要在cus_itemTypeGridItemdblclick中实现
					 */
					if (fparamNos.indexOf(paramarr[i]) == -1) {
						$("ce_" + paramarr[i]).hide();
					} else {
						$("ce_" + paramarr[i]).show();
					}
				} catch (e) {
				}
			}
		}
	}
	if (boolQtys == "true") {
		/* 处理数量列 */
		if (fqtys.indexOf("qty1") == -1) {
			$("ce_fqty").hide();
		} else {
			$("ce_fqty").show();
		}
		if (fqtys.indexOf("qty2") == -1) {
			$("ce_fqty2").hide();
		} else {
			$("ce_fqty2").show();
		}
		if (fqtys.indexOf("qty3") == -1) {
			$("ce_fqty3").hide();
		} else {
			$("ce_fqty3").show();
		}
		if (fqtys.indexOf("qty4") == -1) {
			$("ce_fqty4").hide();
		} else {
			$("ce_fqty4").show();
		}
	}
}

/**
 * 选中开启的货品属性，且设置不让修改
 * 
 * @param fparamNos
 */
function selectItems(fparamNos) {
	var params = fparamNos;
	var paramarr = params.split(",");
	if (!isEmpty(fparamNos)) {
		for ( var i = 0; i < paramarr.length; i++) {
			try {
				if (!isEmpty($("checkboxlittle_" + paramarr[i]))) {
					$("checkboxlittle_" + paramarr[i]).setValue(true);
					$("checkboxlittle_" + paramarr[i]).setReadOnly(true);
				}
			} catch (e) {
			}
		}
	}
}
/**
 * 查询框控制货品类型联动
 * 
 * @param fparamNos
 */
function changeItems(fparamNos) {
	var params = "color,size,style,spef,font,param1,param2";
	var paramarr = params.split(",");
	/* 动态修改货品属性列 */
	if (!isEmpty(fparamNos)) {
		for ( var i = 0; i < paramarr.length; i++) {
			try {
				/*
				 * 使用try-catch块，是由于在调整单中，列字段并不是color,size形式，
				 * 而是fromColor,targetColor形式，此时要在cus_itemTypeGridItemdblclick中实现
				 */
				var boolParam = false;
				if (!isEmpty($("container_query_" + paramarr[i]))) {
					$("container_query_" + paramarr[i]).setDisabled(boolParam);
				}
				if (!isEmpty($("checkboxlittle_" + paramarr[i]))) {
					$("checkboxlittle_" + paramarr[i]).setDisabled(boolParam);
				}
				if (!isEmpty($("radiolittle_r" + paramarr[i]))) {
					$("radiolittle_r" + paramarr[i]).setDisabled(boolParam);
				}
				if (fparamNos.indexOf(paramarr[i]) == -1) {
					boolParam = true;
				} else {
					boolParam = false;
				}
				if (!isEmpty($("container_query_" + paramarr[i]))) {
					$("container_query_" + paramarr[i]).setDisabled(boolParam);
				}
				if (!isEmpty($("checkboxlittle_" + paramarr[i]))) {
					$("checkboxlittle_" + paramarr[i]).setDisabled(boolParam);
				}
				if (!isEmpty($("radiolittle_r" + paramarr[i]))) {
					$("radiolittle_r" + paramarr[i]).setDisabled(boolParam);
				}
			} catch (e) {
			}
		}
	}
}

/**
 * 查询框控制货品类型联动
 * 
 * @param fparamNos
 */
function hideItems(fparamNos) {
	var params = "color,size,style,spef,font,param1,param2";
	var paramarr = params.split(",");
	/* 动态修改货品属性列 */
	if (!isEmpty(fparamNos)) {
		for ( var i = 0; i < paramarr.length; i++) {
			try {
				/*
				 * 使用try-catch块，是由于在调整单中，列字段并不是color,size形式，
				 * 而是fromColor,targetColor形式，此时要在cus_itemTypeGridItemdblclick中实现
				 */
				if (fparamNos.indexOf(paramarr[i]) == -1) {
					if (!isEmpty($("container_query_" + paramarr[i]))) {
						$("container_query_" + paramarr[i]).hide();
					}
					if (!isEmpty($("checkboxlittle_" + paramarr[i]))) {
						$("checkboxlittle_" + paramarr[i]).hide();
					}
					if (!isEmpty($("radiolittle_r" + paramarr[i]))) {
						$("radiolittle_r" + paramarr[i]).hide();
					}
				} else {
					if (!isEmpty($("container_query_" + paramarr[i]))) {
						$("container_query_" + paramarr[i]).show();
					}
					if (!isEmpty($("checkboxlittle_" + paramarr[i]))) {
						$("checkboxlittle_" + paramarr[i]).show();
					}
					if (!isEmpty($("radiolittle_r" + paramarr[i]))) {
						$("radiolittle_r" + paramarr[i]).show();
					}
				}
			} catch (e) {
			}
		}
	}
}

/**
 * 查询框控制货品类型联动 同时将被隐藏的统一赋值
 * 
 * @param fparamNos
 */
function hideItems2(fparamNos, booleanVal) {
	var params = "color,size,style,spef,font,param1,param2";
	var paramarr = params.split(",");
	/* 动态修改货品属性列 */
	if (!isEmpty(fparamNos)) {
		for ( var i = 0; i < paramarr.length; i++) {
			try {
				/**
				 * 使用try-catch块，是由于在调整单中，列字段并不是color,size形式，
				 * 而是fromColor,targetColor形式，此时要在cus_itemTypeGridItemdblclick中实现
				 */
				if (fparamNos.indexOf(paramarr[i]) == -1) {
					if (!isEmpty($("container_query_" + paramarr[i]))) {
						$("container_query_" + paramarr[i]).hide();
					}
					if (!isEmpty($("checkboxlittle_" + paramarr[i]))) {
						$("checkboxlittle_" + paramarr[i]).hide();
						$("checkboxlittle_" + paramarr[i]).setValue(booleanVal);
					}
					if (!isEmpty($("radiolittle_r" + paramarr[i]))) {
						$("radiolittle_r" + paramarr[i]).hide();
						$("radiolittle_r" + paramarr[i]).setValue(booleanVal);
					}
				} else {
					if (!isEmpty($("container_query_" + paramarr[i]))) {
						$("container_query_" + paramarr[i]).show();
					}
					if (!isEmpty($("checkboxlittle_" + paramarr[i]))) {
						$("checkboxlittle_" + paramarr[i]).show();
					}
					if (!isEmpty($("radiolittle_r" + paramarr[i]))) {
						$("radiolittle_r" + paramarr[i]).show();
					}
				}
			} catch (e) {
			}
		}
	}
}
/**
 * 初始一个grid到单行状态，并清空该行数据 目前系统所有单据的grid，初始就有一空白行存在
 * 
 * @param store
 */
function clearStoreToOneItem(grid, store) {
	var c = store.count();
	if (c > 1) {
		for ( var i = c; i >= 1; i--) {
			store.removeAt(i);
		}
	}
	var record = store.getAt(0);
	clearRowsData(grid, record);
}
/**
 * 动态清空grid中，某行的数据（只做数据清空，不做行删除）
 * 
 * @param grid
 * @param record
 */
function clearRowsData(grid, record) {
	var cols = grid.columns;
	for ( var i = 0; i < cols.length; i++) {
		if (!isEmpty(cols[i].dataIndex)) {
			if (!isEmpty(record.get(cols[i].dataIndex))) {
				record.set(cols[i].dataIndex, "");
			}
		}
	}
}
/**
 * 动态隐藏一个grid布局中的所有自定义列 第二个参数的使用是为了避免删除掉一些extjs 对grid对象定义columns可能产生的参数
 * 
 * @param grid
 *            grid对象
 * @param startStr
 *            需要隐藏列的前缀，一般如："re_","ce_"， <参数的值必须参照grid模板内对dataIndex值的设置>
 */
function hideColumns(grid, startStr) {
	var cols = grid.columns;
	for ( var i = 0; i < cols.length; i++) {
		if (!isEmpty(cols[i].dataIndex)) {
			$(startStr + cols[i].dataIndex).hide();
		}
	}
}

/**
 * 实现类似java的replaceAll的功能
 * 
 * @param oldStr
 * @param newStr
 * @param Str
 */
function replaceAll(oldStr, newStr, str) {
	var rtn = str;
	if (str.indexOf(oldStr) > -1) {
		rtn = rtn.replace(oldStr, newStr);
		if (str.indexOf(oldStr) > -1) {
			rtn = replaceAll(oldStr, newStr, rtn);
		}
	}
	return rtn;
}
function showInDiv(value) {
	return '<div title="' + value + '">' + value + '</div>';
}

/**
 * 发送一个AJAX请求
 * 
 * @param url
 * @param successFn
 */
function ajaxRequest(url, successFn) {
	showWaitMsg();
	Ext.Ajax.request({
		url : url,
		success : function(response) {
			hideWaitMsg();
			successFn(response);
		}
	});
}
/**
 * 发送一个AJAX请求，回调函数中的obj为服务器传回的dto对象
 * 一个般服务器请求成功，需在dto中添加dto.put(SysConstants.SUCCESS, "true")以及其它需要的内容
 * 回调函数中验证方式可以这样： if(!isEmpty(obj.success)){.......}
 * 
 * @param url
 * @param successFn
 */
function ajaxCallBack(url, successFn, method) {
	if (isEmpty(method)) {
		method = "GET";
	}
	showWaitMsg();
	Ext.Ajax.request({
		url : url,
		method : method,
		success : function(response) {
			hideWaitMsg();
			var text = response.responseText;
			var obj = Ext.JSON.decode(text);
			successFn(obj);
		}
	});
}

/**
 * 为了报表提交硕正的XML而扩展的ajax方法
 * 
 * @param url
 * @param successFn
 * @param method
 * @param params
 */
function ajaxCallBackByParams(url, params, successFn, method) {
	if (isEmpty(method)) {
		method = "POST";
	}
	if (isEmpty(params.unshowmsg)) {// 扩展，是不明显示等待提示
		showWaitMsg();
	}
	Ext.Ajax.request({
		url : url,
		method : method,
		params : params,
		success : function(response) {
			if (isEmpty(params.unshowmsg)) {
				hideWaitMsg();
			}
			var text = response.responseText;
			var obj = Ext.JSON.decode(text);
			successFn(obj, text);
		}
	});
}

/**
 * 发送一个AJAX请求，回调函数中的obj为服务器传回的dto对象
 * 一个般服务器请求成功，需在dto中添加dto.put(SysConstants.SUCCESS, "true")以及其它需要的内容
 * 回调函数中验证方式可以这样： if(!isEmpty(obj.success)){.......}
 * 
 * @param url
 * @param params
 * @param successFn
 */
function ajaxCallBackByParam(url, params, successFn) {
	showWaitMsg();
	Ext.Ajax.request({
		url : url,
		params : params,
		success : function(response) {
			hideWaitMsg();
			var text = response.responseText;
			var obj = Ext.JSON.decode(text);
			successFn(obj);
		}
	});
}

/**
 * 处理淘宝事务方法，如果没令牌，跳转至获取牌页，否则执行传入的successFn
 * 
 * @param appId
 *            淘宝应用ID
 * @param successFn
 */
function resolveTaobaoTransaction(appId, successFn) {
	showWaitMsg("正在检测令牌信息，请稍候...");
	Ext.Ajax
			.request({
				url : "/netshops/getAccessTokenByTaobaoAccessToken.gx",
				params : {
					appId : appId
				},
				success : function(response) {
					hideWaitMsg();
					var text = response.responseText;
					var kk = Ext.JSON.decode(text).success;
					if (!isEmpty(kk) && kk == "true") {
						successFn();
					} else {
						Ext.MessageBox
								.confirm(
										'确认',
										'系统检测到您的令牌已失效，需要重新授权，跳转至淘宝进行授权吗？',
										function(btn) {
											if (btn == "yes") {
												window
														.open('/netshops/redirectToTop.gx?appId='
																+ appId
																+ '&backUrl='
																+ window.location);
											}
										});
					}
				}
			});
}
/**
 * 处理商东商城事务方法，如果没令牌，跳转至获取牌页，否则执行传入的successFn
 * 
 * @param appId
 *            淘宝应用ID
 * @param successFn
 */
function resolveBuy360Transaction(appId, successFn) {
	showWaitMsg("正在检测令牌信息，请稍候...");
	Ext.Ajax
			.request({
				url : "/netshops/getAccessTokenByBuy360AccessToken.gx",
				params : {
					appId : appId
				},
				success : function(response) {
					hideWaitMsg();
					var text = response.responseText;
					var kk = Ext.JSON.decode(text).success;
					if (!isEmpty(kk) && kk == "true") {
						successFn();
					} else {
						Ext.MessageBox
								.confirm(
										'确认',
										'系统检测到您的令牌已失效，需要重新授权，跳转至京东商城进行授权吗？',
										function(btn) {
											if (btn == "yes") {
												window
														.open('/netshops/redirectTo360Buy.gx?appId='
																+ appId
																+ '&backUrl='
																+ window.location);
											}
										});
					}
				}
			});
}
function createImage(value, width) {
	if(isEmpty(value)){
		"";
	}
	return '<img src="' + value + '" style="width:' + width + 'px" />';
}

/**
 * 序列化一个表单，组装成URL参数
 * 
 * @param form
 * @returns
 */
function serializeForm(form) {
	var serial = '';
	var values = form.getValues();
	for ( var value in values)
		serial += '&' + value + '=' + encodeURI(values[value]);
	if (serial.length > 0)
		return serial.substring(1);
	return "";
}

/**
 * 取仓储核算汇总表中需要被调整的价格 目前(2013-10-08)只需要取<转出价>
 * 
 */
var frPriceMap = new Ext.util.HashMap();
function dealFrPrice(fitemNo, fwhno, successFn, u) {
	if (!frPriceMap.containsKey("ficPrice_" + fwhno + "_" + fitemNo)) {
		frPriceMap.add(fitemNo, 1);
		var url = "/frinfo/listDtlByLgprice.gx?fitemNo=" + fitemNo;
		if (u) {
			url = u
		}
		if (!isEmpty(fwhno)) {
			url = url + "&fwhno=" + fwhno;
		}
		Ext.Ajax.request({
			url : url,
			success : function(response) {
				var text = response.responseText;
				var obj = Ext.JSON.decode(text);
				var len = obj.length;
				if (len > 0) {
					for ( var i = 0; i < obj.length; i++) {
						var keyArr = Ext.Object.getKeys(obj[i]);
						var valArr = Ext.Object.getValues(obj[i]);
						for ( var j = 0; j < keyArr.length; j++) {
							frPriceMap.add(keyArr[j], valArr[j]);
						}
					}
				}
				if (successFn) {
					successFn();
				}
			}
		});
	} else {
		if (successFn) {
			successFn();
		}
	}
}

/**
 * 取基本价格，最高价格，最低价格，退货价格和批发价格放于basePriceMap<br />
 * basePriceMap键分为两种：1：销售类型号_(币种号_)货号，值为1，表示已经取得此货号对应销售类型的值
 * 2:fprice(fminPrice|fmaxPrice|frtnPrice|fbatchPrice)_销售类型号_(币种号_)货号_七种属性号_单位号，值为对应价格（如果维护过的话）
 */
var basePriceMap = new Ext.util.HashMap();
function dealBasePrice(fitemNo, successFn, fcno, fsaleTypeNo) {
	var fcno1;
	if (!isEmpty(fcno)) {
		fcno1 = fcno + "_";
	} else {
		fcno1 = "";
	}
	if (!basePriceMap.containsKey(fsaleTypeNo + "_" + fcno1 + fitemNo)) {
		// 以销售类型号或者客户编号_币种号_货号标识此货号对应价格已经取出
		basePriceMap.add(fsaleTypeNo + "_" + fcno1 + fitemNo, 1);
		var url = "/priinfo/listDtlBySaleBasePrice.gx?fitemNo=" + fitemNo;
		if (!isEmpty(fcno)) {
			url = url + "&fcno=" + fcno;
		}
		if (!isEmpty(fsaleTypeNo)) {
			url = url + "&fsaleTypeNo=" + fsaleTypeNo;
		}
		Ext.Ajax.request({
			url : url,
			success : function(response) {
				var text = response.responseText;
				var obj = Ext.JSON.decode(text);
				var len = obj.length;
				if (len > 0) {
					for ( var i = 0; i < obj.length; i++) {
						var keyArr = Ext.Object.getKeys(obj[i]);
						var valArr = Ext.Object.getValues(obj[i]);
						for ( var j = 0; j < keyArr.length; j++) {
							basePriceMap.add(keyArr[j], valArr[j]);
						}
					}
				}
				if (successFn) {
					successFn();
				}
			}
		});
	} else {
		if (successFn) {
			successFn();
		}
	}
}
/**
 * 取采购价格放于purPriceMap basePriceMap键分为两种：1：货号，值为1，表示已经取得此货号对应采购价格
 * 2:fprice_货号_七种属性号_单位号，值为对应价格（如果维护过的话）
 */
var purPriceMap = new Ext.util.HashMap();
function dealPurPrice(fitemNo, successFn) {
	if (!purPriceMap.containsKey(fitemNo)) {
		purPriceMap.add(fitemNo, 1);
		var url = "/priinfo/listDtlBySalePurPrice.gx?fitemNo=" + fitemNo;
		showWaitMsg();
		Ext.Ajax.request({
			url : url,
			success : function(response) {
				hideWaitMsg();
				var text = response.responseText;
				var obj = Ext.JSON.decode(text);
				var len = obj.length;
				if (len > 0) {
					for ( var i = 0; i < obj.length; i++) {
						var keyArr = Ext.Object.getKeys(obj[i]);
						var valArr = Ext.Object.getValues(obj[i]);
						for ( var j = 0; j < keyArr.length; j++) {
							purPriceMap.add(keyArr[j], valArr[j]);
						}
					}
				}
				if (successFn) {
					successFn();
				}
			}
		});
	} else {
		if (successFn) {
			successFn();
		}
	}
}

var salePriceMap = new Ext.util.HashMap();
function dealSalePrice(fitemNo, fcustno, fcno, successFn) {
	if (!salePriceMap.containsKey(fcustno + "-" + fcno + "-" + fitemNo)) {
		salePriceMap.add(fcustno + "-" + fcno + "-" + fitemNo, 1);
		var url = "/priinfo/getSalePriceBySalePrice.gx?fitemNo=" + fitemNo
				+ "&fcustno=" + fcustno + "&fcno=" + fcno;
		Ext.Ajax.request({
			url : url,
			success : function(response) {
				var text = response.responseText;
				var obj = Ext.JSON.decode(text);
				var keyArr = Ext.Object.getKeys(obj);
				var valArr = Ext.Object.getValues(obj);
				for ( var j = 0; j < keyArr.length; j++) {
					salePriceMap.add(keyArr[j], valArr[j]);
				}
				if (successFn) {
					successFn();
				}
			}
		});
	} else {
		if (successFn) {
			successFn();
		}
	}
}
/**
 * 从销售发票获取最后一次的销售价
 * 
 * @param fitemNo
 * @param fcustno
 * @param fcno
 * @param successFn
 */
function dealLastArinvPrice(fitemNo, fcustno, fcno, successFn) {
	if (!salePriceMap.containsKey(fcustno + "-" + fcno + "-" + fitemNo)) {
		salePriceMap.add(fcustno + "-" + fcno + "-" + fitemNo, 1);
		var url = "/arinfo/getLastArinvPriceByArinvmas.gx?fitemNo=" + fitemNo
				+ "&fcustno=" + fcustno + "&fcno=" + fcno;
		Ext.Ajax.request({
			url : url,
			success : function(response) {
				var text = response.responseText;
				var obj = Ext.JSON.decode(text);
				var keyArr = Ext.Object.getKeys(obj);
				var valArr = Ext.Object.getValues(obj);
				for ( var j = 0; j < keyArr.length; j++) {
					salePriceMap.add(keyArr[j], valArr[j]);
				}
				if (successFn) {
					successFn();
				}
			}
		});
	} else {
		if (successFn) {
			successFn();
		}
	}
}
/**
 * 获取一个表单控件的值
 * 
 * @param field
 * @returns
 */
function getValue(field) {
	return $(field).getValue();
}

/**
 * 排除0，此方法用在grid的某一列上，当列值为0时，返回一个空串，否则按原值返回
 * 
 * @param value
 * @returns
 * @since 2013-06-12
 * @author hubo
 */
function excludeZero(value) {
	if ("0" == value) {
		return "";
	}
	return value;
}

function focusAndReset(fieldid) {
	$(fieldid).reset();
	$(fieldid).focus();
}

/**
 * 是否为一个正常的期间
 * 
 * @param period
 * @returns {Boolean}
 */
function isPeriod(period) {
	if (period.length != 6) {
		return false;
	}
	if (isNaN(period)) {
		return false;
	}
	var year = parseFloat(period.substring(0, 4));
	var month = parseFloat(period.substring(4, 6));
	if (year < 1970 || year > 3000) {
		return false;
	}
	if (!(month >= 1 && month <= 12)) {
		return false;
	}
	return true;
}
/**
 * 屏蔽部分按钮
 * 
 * @param toolbarStr
 *            按钮字符串
 * @param toolbarPrefix
 *            按钮前缀
 */
function hideToolbar(toolbarStr, toolbarPrefix, isHidden) {
	if (!isEmpty(toolbarPrefix)) {
		toolbarPrefix = toolbarPrefix + "_";
	}
	if (!isEmpty(toolbarStr)) {
		var arr = toolbarStr.split(",");
		if (isHidden) {
			for ( var i = 0; i < arr.length; i++) {
				if (!isEmpty($(toolbarPrefix + arr[i]))) {
					$(toolbarPrefix + arr[i]).hide();
				}

			}
		} else {
			for ( var i = 0; i < arr.length; i++) {
				if (!isEmpty($(toolbarPrefix + arr[i]))) {
					$(toolbarPrefix + arr[i]).show();
				}
			}
		}
	}
}
function disableToolbar(toolbarStr, toolbarPrefix, isDisabled) {
	if (!isEmpty(toolbarPrefix)) {
		toolbarPrefix = toolbarPrefix + "_";
	}
	if (!isEmpty(toolbarStr)) {
		var arr = toolbarStr.split(",");
		for ( var i = 0; i < arr.length; i++) {
			if (!isEmpty($(toolbarPrefix + arr[i]))) {
				$(toolbarPrefix + arr[i]).setDisabled(isDisabled);
			}

		}
	}
}
/**
 * 显示确认提示并且回调
 * 
 * @param title
 *            显示标题
 * @param yesFn
 *            yes按钮回调
 * @param noFn
 *            no按钮回调
 */
function confirmMessage(title, yesFn, noFn) {
	Ext.MessageBox.confirm('确认', '<span style=color:red>' + title + '</span>',
			function(btn, text) {
				if (btn == 'yes') {
					if (yesFn) {
						yesFn(btn, text);
					}
				} else {
					if (noFn) {
						noFn(btn, text);
					} else {
						return false;
					}
				}
			});
}
/**
 * 验证一个键盘编号是否可以在控件上输入内容
 * 
 * @param p2
 * @returns {Boolean}
 */
function isInputKeyNumber(p2) {
	if (p2 >= 65 && p2 <= 90 || p2 >= 49 && p2 <= 57 || p2 >= 96 && p2 <= 105
			|| p2 == 8 || p2 == 32 || p2 == 46 || p2 >= 186 && p2 <= 192
			|| p2 >= 106 && p2 <= 111 && p2 != 108) {
		return true;
	}
	return false
}

/**
 * 获取某个GRID中，某已知为数值的列的最大值的下一个能被10整除的数
 * 
 * @param gridStoreObj
 * @param indexKey
 */
function getStoreColMaxVal(gridStoreObj, indexKey) {
	var count = gridStoreObj.count();
	var maxVal = 0;
	var record;
	var rowVal = 0;
	for ( var i = 0; i < count; i++) {
		record = gridStoreObj.getAt(i);
		if (isEmpty(record.get(indexKey))) {
			rowVal = 0;
		} else {
			rowVal = parseInt(record.get(indexKey));
		}
		if (maxVal < rowVal) {
			maxVal = rowVal
		}
	}
	return (parseInt(maxVal/10)+1)*10;
}

function createImage(value,width){
	return '<image src="'+value+'" style="width:'+width+'px;height:'+width+'"/>';
}
String.prototype.replaceAll = function(s1,s2){
   	return this.replace(new RegExp(s1,'gm'),s2);
}

function fillSsLog(masId, masType,content,callback){
	jQuery.ajax({
		type : 'post',
		url : _global_context + '/his/createByHisSsLog.tz',
		dataType:'json',
		data :{
			masId:masId,
			ssType:masType,
			content:content
		} 
	}).done(function(result) {
		if(result.success){
			if(callback)callback();
		}else{
			showErrorMsg(d.message);
		}
	});
}