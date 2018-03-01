Ext.define('Ext.supcan.FreeForm',
		{
			config : {
				freeFormObj : undefined
			},
			constructor : function(config) {
				this.initConfig(config);
				return this;
			},
			getConfig : function() {
				return this.config;
			},
			/**
			 * 取消某个事件
			 */
			cancelEvent : function(freeFormObj) {
				freeFormObj.func("CancelEvent", '');
			},
			/**
			 * 加载freeform数据
			 * 
			 * @param url
			 *            加载数据的URL
			 */
			load : function(freeFormObj, url) {
				freeFormObj.func("load", url);
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
			setDroplistProp : function(freeFormObj, dropListId, propName,
					propValue) {
				freeFormObj.func("SetDroplistProp", dropListId + "\r\n"
						+ propName + "\r\n" + propValue);
			},
			/**
			 * 获取一个控件的值
			 * 
			 * @param id
			 *            控件ID
			 */
			getValue : function(freeFormObj, id) {
				var val = freeFormObj.func("GetValue", id);
				return val;
			},
			setValue : function(freeFormObj, id, val) {
				freeFormObj.func("SetValue", id + "\r\n" + val);
			},
			setText : function(freeFormObj, id, val) {
				freeFormObj.func("SetText", id + "\r\n" + val);
			},
			/**
			 * 为某下拉Input控件的Treelist加载数据
			 */
			loadDropData : function(freeFormObj, id, url) {
				freeFormObj.func("Load", id + "\r\n" + url);
			},
			/**
			 * 显示错误消息
			 * 
			 * @param inputid
			 *            错误消息指向的某个控件的ID
			 * @param msg
			 *            消息内容
			 */
			showErrorMsg : function(freeFormObj, inputid, msg) {
				freeFormObj.func("MessageBoxPoint", inputid + "\r\n" + msg
						+ "\r\n title=Error; icon=Information; hold=2");
			},
			/**
			 * 显示操作成功的提示消息
			 * 
			 * @param inputid
			 *            提示消息指向的某个控件的ID
			 * @param msg
			 *            消息内容
			 */
			showInfoMsg : function(freeFormObj, inputid, msg) {
				freeFormObj.func("MessageBoxPoint", inputid + "\r\n" + msg
						+ "\r\n title=Success; icon=Information; hold=2");
			},
			/**
			 * 强制某个控件获得焦点
			 */
			selectCell : function(freeFormObj, inputid) {
				freeFormObj.func("SelectCell", inputid);
			},
			/**
			 * 动态更改XML中某Object(如Input、Line、image等)的属性, 也可以是自定义属性
			 */
			setObjectProp : function(freeFormObj, inputid, propName, val) {
				freeFormObj.func("SetObjectProp", inputid + "\r\n" + propName
						+ "\r\n" + val);
			},
			getObjectProp : function(freeFormObj, inputid, propName) {
				return freeFormObj.func("GetObjectProp", inputid + "\r\n" + propName);
			},
			toJson : function(freeFormObj, xmlStr) {
				return freeFormObj.func("toJson", xmlStr);
			},
			getChangedXML : function(freeFormObj) {
				return freeFormObj.func("GetChangedXML",
						"level=0;dateFormat=%Y-%m-%d");
			},
			getChangedJSON : function(freeFormObj) {
				var xml = this.getChangedXML(freeFormObj);
				return this.toJson(freeFormObj, xml);
			},
			/**
			 * 取得当前freeform、或内部非模式对话框、或Validation、或下拉的句柄
			 * 
			 * @param param
			 *            空串(无参数) -
			 *            取当前Freeform的句柄，常用于Export、GetChanged、GetChangedXML函数;
			 *            innerDialog - 取内部非模式对话框的Freeform句柄; Validation -
			 *            取Validation的句柄, 常用于全局函数动态存取Validation; 某下拉 List 控件的ID -
			 *            取得某下拉 Llist 的句柄，也包括下拉字典型的EditWithButton.
			 *            操控下拉List的内容请参见“全局函数”; 某下拉 TreeLlist 控件的ID -
			 *            取得某下拉Treelist控件的Treelist的句柄，操控下拉TreeList的内容请参见“扩展函数”;
			 */
			getHandle : function(freeFormObj, param) {
				if (!param) {
					param = "";
				}
				return freeFormObj.func("GetHandle", param);
			},
			/**
			 * 判断是否被修改过
			 * 
			 * @param param
			 *            空串 - 检查整个Freeform是否被修改过; ID号 - 检查某个ID的输入框是否被修改过;
			 *            某Radio的GroupID号 - 检查某组Radio框是否被修改过;
			 *            include=[Freeform句柄],[Feeeform句柄] -
			 *            同时检查其它几个Freeform，逗号分隔。(注：可用GetHandle( )取得句柄)
			 * @return 1/0 - 是/否
			 */
			getChanged : function(freeFormObj, param) {
				if (!param) {
					param = "";
				}
				return freeFormObj.func("GetChanged", param);
			},
			/**
			 * 取得XML中某Object(如Input、Line、image等)的属性, 也可以是自定义属性
			 */
			getObjectProp : function(freeFormObj, objId, paramName) {
				return freeFormObj.func("GetObjectProp", objId + "\r\n"
						+ paramName);
			},
			editButtonDialog : function(freeFormObj, callBackFn){
				freeFormObj.func("SetDialogFreeform", "/baseinfos/getDialogXmlBySupcan.gx");
				freeFormObj.func("SetDialogPara", "width=300;height=30;bgColor=#aaccff;alpha=100");
				freeFormObj.func("OpenInnerDialog", "");
				setTimeout(function(){
					freeFormObj.func("closeInnerDialog", "");
					if(callBackFn){
						callBackFn();
					}
				}, 1500)
			},
			/**
			 * 获取一个下拉的句柄
			 */
			getDropListHandle : function(freeFormObj, fieldName) {
				var h = freeFormObj.func("GetHandle", fieldName);
				return h;
			},
			/**
			 * 取得某DropTreelist的当前行
			 * 
			 * @param handle
			 *            下拉的句柄
			 */
			getDropListCurRow : function(freeFormObj, handle) {
				var row = freeFormObj.func(handle + "GetCurrentRow", "");
				return row;
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
			getDropListCellData : function(freeFormObj, handle, row, dropListColumn) {
				var data = freeFormObj.func(handle + "GetCellData", row + "\r\n "
						+ dropListColumn);
				return data;
			}
		});