Ext
		.define(
				'Ext.supcan.TreeList',
				{
					config : {
						treeListObj : undefined
					},
					constructor : function(config) {
						this.initConfig(config);
						return this;
					},
					/**
					 * 加载treelist数据
					 * 
					 * @param url
					 *            加载数据的URL
					 * @param fillMode
					 *            数据填充方式, 默认为空表示先彻底清除原有数据，也可以为： replaceByOrder -
					 *            不增删行，仅逐行替换数据; replaceByKey -
					 *            不增删行，仅按相同Key的行替换数据; insert -
					 *            不清理原有的数据，新数据是插入到表中的;clearData表示先彻底清除原有数据
					 * @param asNewRow
					 *            是否作为新增的数据
					 * @param method
					 */
					load : function(treeListObj, url, fillMode, asNewRow,
							method) {
						var param = url + "\r\nmode=asynch";
						if (fillMode != '') {
							param = param + ";FillMode=" + fillMode;
						}
						param = param + ";asNewRow=" + asNewRow;
						if (!method) {
							param = param + ";method=Get";
						} else {
							param = param + ";method=" + method;
						}
						treeListObj.func("load", param);
					},
					getConfig : function() {
						return this.config;
					},
					/**
					 * 取消某个事件
					 */
					cancelEvent : function(treeListObj) {
						treeListObj.func("CancelEvent", '');
					},
					/**
					 * 获取一个下拉的句柄
					 */
					getDropListHandle : function(treeListObj, columnName) {
						var h = treeListObj.func("GetHandle", columnName);
						return h;
					},
					/**
					 * 动态更改XML中某 Droplist 的属性
					 * 
					 * @param dropListId
					 *            Droplist的ID, 也可以是某列的列名
					 * @param propName
					 *            属性名
					 * @param propValue
					 *            内容
					 */
					setDroplistProp : function(treeListObj, dropListId,
							propName, propValue) {
						treeListObj.func("SetDroplistProp", dropListId + "\r\n"
								+ propName + "\r\n" + propValue);
					},
					/**
					 * 设置某行是否可编辑
					 */
					setRowEditAble : function(treeListObj, rowNumber, EditAble) {
						treeListObj.func("SetRowEditAble", rowNumber + "\r\n"
								+ EditAble);
					},
					/**
					 * /** 删除treelist中的所有行
					 * 
					 * @param insertAnotherRow
					 *            删除之后，是否重新插入一行，默认为true
					 */
					clearData : function(treeListObj, insertAnotherRow) {
						if (undefined == insertAnotherRow) {
							insertAnotherRow = true;
						}
						treeListObj.func("DeleteRows", "0 \r\n -1");
						if (insertAnotherRow) {
							this.insertRows(treeListObj, 0);
						}
					},
					/**
					 * 取得某DropTreelist的当前行
					 * 
					 * @param handle
					 *            下拉的句柄
					 */
					getDropListCurRow : function(treeListObj, handle) {
						var row = treeListObj
								.func(handle + "GetCurrentRow", "");
						return row;
					},
					/**
					 * 取得当前和选中的行号
					 */
					getCurrentRow : function(treeListObj) {
						return treeListObj.func("GetCurrentRow");
					},
					/**
					 * 取得某DropTreeList的当前行的某一个单元格的数据
					 * 
					 * @param handle
					 *            下拉的句柄
					 * @param row
					 *            DropTreelist某一行
					 * @param dropListColumn
					 *            dropTreeList的列名
					 * @returns
					 */
					getDropListCellData : function(treeListObj, handle, row,
							dropListColumn) {
						var data = treeListObj.func(handle + "GetCellData", row
								+ "\r\n " + dropListColumn);
						return data;
					},
					/**
					 * 设置某单元格的数据
					 * 
					 * @param rownumber
					 *            行号
					 * @param columnName
					 *            列名
					 * @param data
					 *            数据
					 */
					setCellData : function(treeListObj, rownumber, columnName,
							data) {
						treeListObj.func("SetCellData", rownumber + "\r\n "
								+ columnName + " \r\n" + data);
					},
					/**
					 * 取得某单元格的数据
					 * 
					 * @param rownumber
					 *            行号
					 * @param columnName
					 *            列名
					 * @param isCache
					 *            可选, true(或1)表示取原始缓存中的数据(即被修改前的数据),
					 *            默认是false(或0)
					 * 
					 */
					getCellData : function(treeListObj, rownumber, columnName,
							isCache) {
						if (isCache != true) {
							isCache = false;
						}
						return treeListObj.func("GetCellData", rownumber
								+ "\r\n" + columnName + " \r\n " + isCache);
					},
					/**
					 * 插入一行
					 * 
					 * @param rownumber
					 *            行号位置
					 */
					insertRows : function(treeListObj, rownumber) {
						return treeListObj.func("InsertRows", rownumber
								+ "\r\n 1 \r\n selectRow=true;openEdit:true");
					},
					toJson : function(treeListObj, xmlStr) {
						return treeListObj.func("toJson", xmlStr
								+ "\r\nrecordset");
					},
					getChangedXML : function(treeListObj) {
						return treeListObj.func("GetChangedXML",
								"isIgnoreChange=true;DateFormat=%Y-%m-%d");
					},
					getChangedJSON : function(treeListObj) {
						var xml = this.getChangedXML(treeListObj);
						return this.toJson(treeListObj, xml);
					},
					/**
					 * 动态更改XML文档中 Properties 定义的属性、以及自定义属性
					 */
					setProp : function(treeListObj, propName, propValue) {
						treeListObj.func("SetProp", propName + "\r\n"
								+ propValue);
					},
					/**
					 * 获取XML文档中 Properties 定义的属性、以及自定义属性
					 */
					getProp : function(treeListObj, propName) {
						treeListObj.func("GetProp", propName);
					},
					/**
					 * 动态更改XML文档中 列属性
					 */
					setColProp : function(treeListObj, colName, propName,
							propValue) {
						treeListObj.func("SetColProp", colName + "\r\n"
								+ propName + "\r\n" + propValue);
					},
					/**
					 * 隐藏/显示列
					 * 
					 * @param columName
					 *            列名
					 * @param isShow
					 *            true/false-隐藏/显示
					 */
					hideCol : function(treeListObj, columnName, isShow) {
						treeListObj.func("HideCol", columnName + "\r\n"
								+ isShow);
					},
					hideCols : function(treeListObj, columnNames, isShow) {
						var arr = [];
						arr = columnNames.split(",");
						for ( var i = 0; i < arr.length; i++) {
							treeListObj.func("HideCol", arr[i] + "\r\n"
									+ isShow);
						}
					},
					/**
					 * 处理需要隐藏/显示的货品属性
					 */
					hideItemParamCol : function(treeListObj, paramNos) {
						var allNos = ",color,size,style,spef,font,param1,param2,";
						var arr = [];
						arr = paramNos.split(",");
						for ( var i = 0; i < arr.length; i++) {
							allNos = allNos.replace("," + arr[i] + ",", ',');
							treeListObj.func("HideCol", arr[i] + "\r\nfalse");
						}
						if (allNos != ",") {
							allNos = allNos.substring(1, allNos.length - 1);
						}
						arr = allNos.split(",");
						for ( var i = 0; i < arr.length; i++) {
							treeListObj.func("HideCol", arr[i] + "\r\ntrue");
						}
					},
					setCellEditAble : function(treeListObj, rownumber,
							columnName, isEditAble) {
						treeListObj.func("SetCellEditAble", rownumber + "\r\n"
								+ columnName + "\r\n" + isEditAble);
					},
					/**
					 * 删除满足条件的行
					 * 
					 * @param express
					 *            表达式
					 */
					deleteRows : function(treeListObj, express) {
						treeListObj.func("deleteRows", express);
					},
					/**
					 * 插入货号的横排列
					 * 
					 * @param itemno
					 *            货号，多个以逗号分隔
					 * @param columnname
					 *            列名，插入此列之前
					 * @param crossType
					 *            系统横排类型，对应于SysParam.fcrossParam
					 * @param afterFn
					 *            回调方法，一般可用于重新获取货号的焦点，但是如果加的列太多，导航页面有晃动时，此回调无效，无效时，人为再打一次回车键即可再次获取焦点
					 * @param totalDecimal
					 *            插入列的小数点位数
					 */
					insertCrossColumn : function(treeListObj, itemno,
							columnname, crossType, afterFn, decimal) {
						if (isEmpty(decimal)) {
							decimal = 2;
						}
						ajaxCallBackByParams(
								"/baseinfos/getCrossParamsByItem.gx",
								{
									fitemNo : itemno,
									unshowmsg : 1
								},
								function(obj, text) {
									if (obj.success) {
										var crossNos = obj.crossNos;
										var crossNames = obj.crossNames;
										var columnWidth = 60;
										if (fitemParamColumnWidth) {
											columnWidth = fitemParamColumnWidth;
										}
										if (!isEmpty(crossNos)) {
											var nos = crossNos.split(",");
											var names = crossNames.split(",");
											var colCount = treeListObj
													.func("GetCols");
											var columnnumber = 0;
											var colname = "";
											var crosscols = ",";
											for ( var i = 0; i < colCount; i++) {
												colname = treeListObj.func(
														"GetColName", i);
												if (colname.indexOf("sp_"
														+ crossType) != -1) {
													crosscols = crosscols
															+ colname + ","
												}
												if (colname == columnname) {
													columnnumber = i;
													break;
												}
											}
											for ( var i = 0; i < nos.length; i++) {
												colname = "sp_" + crossType
														+ "_" + nos[i];
												if (crosscols.indexOf(","
														+ colname + ",") == -1) {
													treeListObj
															.func(
																	"InsertCol",
																	columnnumber
																			+ "\r\nname=sp_"
																			+ crossType
																			+ "_"
																			+ nos[i]
																			+ ";width=\""
																			+ columnWidth
																			+ "\";title="
																			+ names[i]
																			+ ";dataType=double;decimal="
																			+ decimal
																			+ ";editAble=true;minWidth=30;totalDecimal="
																			+ decimal
																			+ ";totalExpress=@sum;totalAlign=right");
													columnnumber++;
												}
											}
										}
										if (afterFn) {
											afterFn();
										}
									}
								}, "POST");
					},
					/**
					 * 选择某单元格
					 */
					selectCell : function(treeListObj, rownumber, columnname) {
						treeListObj.func("SelectCell", rownumber + "\r\n"
								+ columnname)
					},
					/**
					 * 取得列数
					 */
					getCols : function(treeListObj) {
						return treeListObj.func("GetCols")
					},
					/**
					 * 取列名
					 */
					getColName : function(treeListObj, columnnumber) {
						return treeListObj.func("GetColName", columnnumber);
					},
					/**
					 * 取得某行或整表的修改状态
					 * 
					 * @param rownumber
					 *            行号(从0开始). 如果为 -1，表示所有行，即整个表.
					 * @param mask
					 *            可选, 状态掩码，为字母 N、M、D 的组合(简称“ni-ma-的”)： N -
					 *            表示有新增行; M - 表示有修改过的行; D - 表示有删除行(仅用于整表) 默认值为
					 *            NM 或 NMD(如果是整表)
					 * @return 为上述3个字母的组合，空串表示未符合掩码
					 */
					getRowChanged : function(treeListObj, rownumber, mask) {
						if (!rownumber) {
							rownumber = -1;
						}
						if (!mask) {
							mask = "NMD";
						}
						return treeListObj.func("GetRowChanged", rownumber
								+ "\r\n" + mask);
					},
					/**
					 * 打开导出的对话框
					 */
					openExportDialog : function(treeListObj, params) {
						treeListObj.func("OpenExportDialog", params);
					},
					/**
					 * 打印预览
					 */
					printPreview : function(treeListObj) {
						treeListObj.func("PrintPreview");
					},
					getRows : function(treeListObj) {
						return treeListObj.func("GetRows");
					},
					/**
					 * 显示错误消息
					 * 
					 * @param rownumber
					 *            行号
					 * @param columnName
					 *            列名
					 * @param msg
					 *            消息内容
					 */
					showErrorMsg : function(treeListObj, rownumber, columnName,
							msg, hold) {
						if (!hold) {
							hold = 2
						}
						treeListObj.func("MessageBoxPoint", rownumber + "\r\n"
								+ columnName + "\r\n" + msg
								+ "\r\n title=Error; icon=Information; hold="
								+ hold);
					},
					/**
					 * 置某列能否修改
					 * 
					 * @param columnName
					 *            列名
					 * @param editAble
					 *            true/false(或1/0、yes/no)
					 */
					setColEditAble : function(treeListObj, columnName, editAble) {
						treeListObj.func("SetColEditAble", columnName + "\r\n"
								+ editAble);
					},
					/**
					 * 打印预览
					 */
					printPreview : function(treeListObj) {
						treeListObj.func("PrintPreview");
					},
					/**
					 * 选择单元格
					 */
					selectCell : function(treeListObj, rowNumber, columnName) {
						treeListObj.func("SelectCell", rowNumber + "\r\n"
								+ columnName);
					},
					/**
					 * 取得XML文档中某 Col 的属性内容、或者自定义属性的内容
					 */
					getColProp : function(treeListObj, columnName, propName) {
						return treeListObj.func("GetColProp", columnName
								+ "\r\n" + propName);
					},
					selectRow : function(treeListObj, rownumber) {
						return treeListObj.func("SelectRow", rownumber
								+ "\r\ntrue");
					},
					/**
					 * 设置某列是否可编辑
					 */
					setColEditAble : function(treeListObj, columnName, enable) {
						return treeListObj.func("SetColEditAble", columnName
								+ "\r\n" + enable);
					},
					/**
					 * 设置整列的值
					 */
					setColCellData : function(treeListObj, columnName, value) {
						treeListObj.func("SetColCellData", columnName + "\r\n"
								+ value);
					},
					/**
					 * 获取某一列的内容，以半角逗号分隔
					 */
					getColData : function(treeListObj, columnName) {
						var row = "-1";
						var rtnStr = "";
						for (row = treeListObj.func("GetNextValidRow", row); row != ""; row = treeListObj
								.func("GetNextValidRow", row)) {
							if (isEmpty(rtnStr)) {
								rtnStr = this.getCellData(treeListObj, row,
										columnName, false);
							} else {
								rtnStr = rtnStr
										+ ","
										+ this.getCellData(treeListObj, row,
												columnName, false);
							}
						}
						return rtnStr;
					}
				});