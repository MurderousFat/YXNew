/****************************************************
 * name:扩展封装硕正套件的部分JS方法的公共文件
 * company:格讯软件
 * since:2013-11-09
 * author:szc
 ****************************************************/


/**
 * 用字段名称取获取到当前在supcan具体那一列的列ID
 * 
 * @param dsName
 *            数据源名称
 * @param fieldName
 *            字段名称
 * @returns 列id，获取到后最好自己做检查是否为数字isNaN
 */
function getColId(dsName, fieldName) {
	var sourceIds = AF.func("GetSourceInfo", dsName + " \r\n FieldID");
	var sourceArr = sourceIds.split("\r\n");

	var colids = AF.func("GetColsOfDs", dsName);
	var colArr = colids.split(",");

	var colMap = new Ext.util.HashMap();
	for ( var i = 0; i < sourceArr.length; i++) {
		colMap.add(sourceArr[i], colArr[i]);
	}
	var cloId = colMap.get(fieldName);
	if(isEmpty(cloId)){//没有该类似的列ID返回空
		return null;
	}else if(isNaN(cloId)){//不是数字则返回空
		return null;
	}else{
		return cloId;
	}
}

/**
 * 用id获取到当前的fieldName
 * @param dsName
 * @param cloId
 */
function getFieldName(dsName,cloId){
	var sourceIds = AF.func("GetSourceInfo", dsName + " \r\n FieldID");
	var sourceArr = sourceIds.split("\r\n");

	var colids = AF.func("GetColsOfDs", dsName);
	var colArr = colids.split(",");
	
	var colMap = new Ext.util.HashMap();
	for ( var i = 0; i < colArr.length; i++) {
		colMap.add(colArr[i],sourceArr[i]);
	}
	var fieldName = colMap.get(cloId);
	if(isEmpty(fieldName)){//没有该类似的列ID返回空
		return null;
	}else{
		return fieldName;
	}
}

/**
 * 控制列显示并重新加载数据
 * 
 * @param dsName
 *            数据源名称id
 * @param searchForm
 *            查询表单
 * @param spaceName
 *            xml中的namespace值
 * @param curClass
 *            模块中的curClass
 */
function reLoadSupcanRpt(dsName, searchFormValues, spaceName, curClass) {
	var headUrl, dataUrl;
	/* 检查是否有参数 */
	if (!isEmpty(searchFormValues)) {
		headUrl = "/" + spaceName + "/head" + curClass + "Report.gx?"
				+ searchFormValues;
		dataUrl = "/" + spaceName + "/list" + curClass + "Report.gx?"
				+ searchFormValues;
	} else {
		headUrl = "/" + spaceName + "/head" + curClass + "Report.gx";
		dataUrl = "/" + spaceName + "/list" + curClass + "Report.gx";
	}

	var sourceIds = AF.func("GetSourceInfo", dsName + " \r\n FieldID");
	var sourceArr = sourceIds.split("\r\n");

	var colids = AF.func("GetColsOfDs", dsName);
	var colArr = colids.split(",");
	
	var colMap = new Ext.util.HashMap();
	for ( var i = 0; i < sourceArr.length; i++) {
		colMap.add(sourceArr[i], colArr[i]);
	}

	ajaxCallBack(headUrl, function(obj) {
		AF.func("setSource", dsName + " \r\n " + dataUrl);
		AF.func("setSource", "reportHead \r\n /baseinfos/reportHeadByReportService.gx");
		AF.func("Fill");
		//修改为获取到隐藏的列，直接隐藏他们
//		var colids = AF.func("GetColsOfDs", dsName);
//		var colArr = colids.split(",");
//		for ( var i = 0; i < colArr.length; i++) {
//			AF.func("HideCol", colArr[i] + " \r\n 1 \r\n true");
//		}
		var tableStr = obj.tableStr;
		var headArr = tableStr.split(",");
		for ( var j = 0; j < headArr.length; j++) {
			AF.func("HideCol", colMap.get(headArr[j]) + " \r\n 1 \r\n true");
		}
	}, "get");
}

/**
 * 获取一个TreeList被选中的主键值
 * 
 * @param TreeListObj
 *            TreeList对象
 * @param quotes
 *            返回的主键值两边是否加引号
 * @returns 返回一个字符串，多个以半角逗号分隔
 */
function getSelectedTreeListKeys(TreeListObj, quotes) {
	var selectedRows = getSelectedTreeListRownumbers(TreeListObj);
	var rtnKeys = "";
	if (selectedRows != '') {
		var arr = selectedRows.split(",");
		for ( var i = 0; i < arr.length; i++) {
			var key = TreeListObj.func("GetRowKey", arr[i]);
			rtnKeys = rtnKeys + ",";
			if (quotes) {
				rtnKeys = rtnKeys + "'";
			}
			rtnKeys = rtnKeys + key;
			if (quotes) {
				rtnKeys = rtnKeys + "'";
			}
		}
	}
	if (rtnKeys != "") {
		rtnKeys = rtnKeys.substring(1);
	}
	return rtnKeys;
}
/**
 * 获取一个TreeList被选中行的行号，多个以半角逗号分隔
 * 
 * @param TreeListObj
 * @returns
 */
function getSelectedTreeListRownumbers(TreeListObj) {
	var selectedRows = TreeListObj.func("GetCurrentRow");
	return selectedRows;
}
/**
 * 针对于TreeList的批量操作方法
 * 
 * @param url
 *            请求的URL
 * @param TreeListObj
 *            TreeList对象
 * @param successFn
 *            成功的回调方法
 * @param quotes
 *            被选中的行的主键两边是否加引号
 */
function batchOperTreeList(url, TreeListObj, successFn, quotes) {
	var ids = getSelectedTreeListKeys(TreeListObj, quotes);
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
 * 获取一个TreeList的单元格数据
 * 
 * @param TreeListObj
 *            TreeList对象
 * @param rowNumber
 *            行号
 * @param colName
 *            列名
 * @returns
 */
function getCellData(TreeListObj, rowNumber, colName) {
	return TreeListObj.func("GetCellData", rowNumber + "\r\n" + colName);
}
/**
 * 取得某列的下拉DropTreelist、或下拉DropList、或EditWithButton的Droplist字典的句柄
 * 
 * @param TreeListObj
 *            树列表对象
 * @param columnName
 *            列名
 * @returns
 */
function getDropListHandle(TreeListObj, columnName) {
	var h = TreeListObj.func("GetHandle", columnName);
	return h;
}
/**
 * 取得某DropTreelist的当前行
 * 
 * @param TreeListObj
 *            树列表对象
 * @param handle
 *            下拉句柄
 * @returns 返回当前选中的行
 */
function getDropListCurRow(TreeListObj, handle) {
	var row = TreeListObj.func(handle + "GetCurrentRow", "");
	return row;
}

/**
 * 取得某DropTreeList的当前行的某一个单元格的数据
 * 
 * @param TreeListObj
 *            树列表对象
 * @param columnName
 *            树列表列名
 * @param dropListColumn
 *            dropTreeList的列名
 * @returns
 */
function getDropListCellData(TreeListObj, handle, row, dropListColumn) {
	var data = TreeListObj.func(handle + "GetCellData", row+"\r\n "+dropListColumn);
	return data;
}