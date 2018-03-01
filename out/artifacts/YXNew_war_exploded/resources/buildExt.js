
Ext.define('Ext.data.reader.List2TreeJson', {
    extend: 'Ext.data.reader.Json',
    alternateClassName: 'Ext.data.List2TreeJsonReader',
    alias : 'reader.list2treejson',

    readRecords: function(data) {
        
        if (data.metaData) {
            this.onMetaChange(data.metaData);
        }
        var me = this;
        var _setting = me.proxy.listTreeSetting;
        if(_setting.sort){
        	data.sort(function (obj1, obj2) {
        	    var val1 = obj1[_setting.sort.key || 'sortNo'] || 999;
        	    var val2 = obj2[_setting.sort.key || 'sortNo'] || 999;
        	    return Number(val1) - Number(val2);
        	});
        	
        }
        var _data = listToTree(data,_setting);
        this.jsonData = _data;
        return this.callParent([_data]);
    }
    
});


var TenzeExt = {
};
var _global_context = '';

function _preloadDataModel(target){
	 return art.dialog.data('g_preloadDataModel')(target);
}

function _fillInDataModel(target,_dataModel){
	art.dialog.data('g_fillInDataModel')(target,_dataModel);
}

function _getExtDatadic(dicName){
	return art.dialog.data('g_getExtDatadic')(dicName);
}
function _getDatadic(dicName){
	return art.dialog.data('g_getDatadic')(dicName);
}
function _getDatadicText(dicName,code){
	return art.dialog.data('g_getDatadicText')(dicName,code);
}
function _getDatadicStore(dicName){
	return art.dialog.data('g_getDatadicStore')(dicName);
}

function _TextFromIndex(_key){
	return art.dialog.data('g_TextFromIndex')(_key);
}

function _BtnFromIndex(_key){
	return art.dialog.data('g_BtnFromIndex')(_key);
}

function _TenzePreLoad_buildPromise(_js){
	var _dtd = jQuery.Deferred();
	 Ext.Loader.loadScript({
		url: _global_context+'/'+_js.replace(/\./g, '/') +'.js'
		,onLoad:function(){
			//TODO data fill in the container and cache
			_dtd.resolve();
		},onError:function(){
			_dtd.reject();
		}
	 });
	 return _dtd.promise();
}


function TenzePreLoad(_jsArr,_done,_fail){
	var _when = jQuery.when;
	var _promises = [];
	var self = this;
	var _flag = false;
	for(var i in _jsArr){
		if(typeof(_jsArr[i])==='string'){
			if(!_preloadDataModel(_jsArr[i])){
				_promises.push(_TenzePreLoad_buildPromise(_jsArr[i]));
			}
		}else if(typeof(_jsArr[i])==='object'){
			_promises.push(_jsArr[i]);
		}
	}
	if(_promises.length>0){
		_when.apply(null,_promises).done(_done).fail(_fail);
	}else{
		if(_done)_done();
	}
}

var _treeConvertSetting = {
		extIdKey:'id',
		extTextKey:'text',
		simpleData:{
			idKey:'id',
			pIdKey:'pId'
		}
		,key:{
			children:'children',
			leaf:'leaf'
		}
};

var _treeConfig = {
		url:'',
		model:null,
		rootExpand:true,
		store:null,
		rootText:'',
		useArrows:false,
		clickEvent:true,
		dblClickEvent:false,
		title:'',
		width:175,
		defineMode:false,
		fields:null,
		rootVisible:false,
		autoLoad:true,
		toolbar:null,
		rootId:0
};


var _formConfig = {
		disableEdit:false,
		timeout:30,
		autoHeight:true,
		height:400,
		title:'',
		labelAlign:'right',
		hidden:false,
		trackResetOnLoad:false,
		renderTo:'',
		hboxQueryColumnCount:2,
		hboxColumnCount:1
};

var _gridStoreConfig = {
		autoLoad:true,
		pageSize:20,
		rootItem:'items',
		totalProperty:'total',
		remoteSort:false,
		maskFlag:true,
		enablePage:true,
		applyName:'getParams'
};

var _gridConfig = {
		panelClass:'Ext.grid.Panel',
		actionType:'none',
		title:'',
		enablePage:true,
		height:0,
		width:0,
		autoLoad:true,
		isRowEdit:false,
		pageSize:50,
		itemdbclick:true,
		gridCheckOnly:false,
		rootItem:'rows',
		totalProperty:'total',
		mulSel:true,
		checkbox:true,
		enableColumnHide:false,
		singleSelect:false,
		enableColumnMove:false,
		applyName:'getParams',
		remoteSort:false,
		headerCheckbox:true,
		toolbar:[]
};

var _fieldcontainer = {
		flex: 1,
		xtype: 'fieldcontainer',
		defaultType: 'textfield',
		defaults: {
			anchor: '98%',
			labelWidth: 80
		}
}

function Ext_BuildTreeModel(target,_name,__options){
	var _fieldsCfg = [{
		name : 'id',
		type : 'string'
	}, {
		name : 'text',
		type : 'string'
	}];
	var _fields = Ext_BuildModelFields(target);
	for(var i in _fields){
		_fieldsCfg.push(_fields[i]);
	}
	Ext.define(_name+'treeModel', {
		extend : 'Ext.data.Model',
		fields :  _fieldsCfg
	});
}

function Ext_BuildTreeStore(target,_name,__options){
	Ext_BuildTreeModel(target,_name,__options);
	var _config = {
			model : __options.model || (_name+'treeMode'),
			proxy : {
				url:__options.url,
				type : 'ajax',
				reader:'list2treejson',
				listTreeSetting:__options.listTreeSetting
			},
			root : {
				text : __options.rootText,
				id : __options.rootId,
				expanded : __options.rootExpand
			},
			autoLoad:__options.autoLoad
	};
	TenzeExt[_name+'TreeStore'] = new Ext.data.TreeStore(_config);
	return TenzeExt[_name+'TreeStore'];
}

function Ext_BuildTree(target,_name,__options){
	var _options = jQuery.extend({},_treeConfig,__options);
	if(!_options.store)Ext_BuildTreeStore(target,_name,_options);
	var _config = {
			store :  _options.store || TenzeExt[_name+'TreeStore'],
			rootVisible : _options.rootVisible,		
			title : _options.title,
			autoHeight:true,
			width : _options.width,	
			useArrows : _options.useArrows,
			autoWidth : false,
			autoScroll : false,
			animate : false,
			id:_name+'TreeId',
			border : false,
			containerScroll : true,
			listeners : {}
		};
	if(_options.tbar)_config.tbar = Ext.create('Ext.toolbar.Toolbar', {layout: {overflowHandler: 'Menu'},items: _options.tbar});
	if(_options.clickEvent){
		_config.listeners.itemclick = function(view, re, item, index, e, eOpts) {
			view.expand(re);
	        eval(_name+'TreeItemClick(view, re, item, index, e, eOpts)');
		}
	}
	if(_options.dblClickevent){
		_config.listeners.itemdblclick = function(view, record, item, index, e, eOpts) {
            eval(_name+'TreeItemDblClick(view, record, item, index, e, eOpts)');
		}
	}
	TenzeExt[_name+'Tree'] = Ext.create('Ext.tree.Panel',_config);
	return TenzeExt[_name+'Tree'];
}

function Ext_BuildFieldContainer(_xtype){
	return jQuery.extend({},_fieldcontainer,{xtype:_xtype}); 
}

function _Ext_BuildTextItem(_field,_preffix,_labelAlign,_search){
	
	var obj = {
			flex: 1,
			afterSubTpl: _field.afterSubTpl,
			xtype: _field.xtype,
			labelAlign: _field.labelAlign || _labelAlign || 'right',
			readOnly: _field.readOnly,
			fieldLabel: (_TextFromIndex(_field.text || _field.name) || _field.text || _field.name)+ (_search?'':( _field.allowBlank?'':'<span style=color:red>*</span>')),
			disabled: _field.disabled,
			allowBlank:  _search?true:_field.allowBlank,
			name:_field.name,
			id: (_search?'query_':'')+(_preffix || '')+_field.name,
			anchor: '98%',
			value: _field.defVal || '',
	};
	if(_field.inputType && _field.inputType.length>0)obj.inputType=_field.inputType;
	if(_field.vtype && _field.vtype.length>0)obj.vtype=_field.vtype;
	if(_field.minValue || _field.minValue!=0)obj.minValue=_field.minValue;
	if(_field.maxValue || _field.maxValue!=0)obj.maxValue=_field.maxValue;
	if(_field.minLength || _field.minLength!=0)obj.minLength=_field.minLength;
	if(_field.decimalPrecision || _field.maxValue!=0)obj.decimalPrecision=_field.decimalPrecision;
	return obj;
}

function _Ext_BuildComboboxItem(_field,_preffix,_labelAlign,_search){
	var obj = _Ext_BuildTextItem(_field,_preffix,_labelAlign,_search);
	obj.displayField = 'codedesc';
	obj.queryMode = 'local';
	obj.valueField = 'code';
	obj.multiSelect = false;
	obj.store = _getDatadicStore(_field.datadic);
	return obj;
}

function _Ext_BuildToolbarBtn(_name,_data,_preffix){
	var obj = {
			id: (_preffix || '' ) + 'bt_'+_name,
			text:_data.text,
			iconCls:_data.icon,
			scope:this,
			scale:'small',
			handler:function(){
				eval((_preffix || '' ) + 'bt_'+_name+'_OnClick()');
			}
	}
	return obj;
}

function Ext_BuildToolbarBtns(_arrs,_options){
	_options = _options || {};
	var _data;
	var _btnArr = [];
	for(var i in _arrs){
		if(typeof(_arrs[i])==='string'){
			_data = _BtnFromIndex(_arrs[i]);
			if(_data){
				_btnArr.push(_Ext_BuildToolbarBtn(_arrs[i],_data,_options.preffix||''));
			}
		}else if(typeof(_arrs[i])==='object'){
			_btnArr.push(_arrs[i]);
		}
	}
	return _btnArr;
}

function _Ext_BuildBtnFieldButtons_Item(_field,_name,_preffix,_search,_data){
	var obj = {
			xtype:'button',
			id: (_preffix || '' ) + 'btn_' + (_search?'query_':'') + _name +'_'+_field,
			iconCls:_data.icon,
			scope:this,
			maxWidth:23,
			scale:'small',
			handler:function(){
				eval((_preffix || '') + 'btn_' + (_search?'query_':'') +_name + '_' + _field +'_OnClick()');
			}
	}
	return obj;
}

function _Ext_BuildBtnFieldButtons(_arrs,_name,_preffix,_search){
	var _data;
	var _btnArr = [];
	for(var i in _arrs){
		if(typeof(_arrs[i])==='string'){
			_data = _BtnFromIndex(_arrs[i]);
			if(_data){
				_btnArr.push(_Ext_BuildBtnFieldButtons_Item(_arrs[i],_name,_preffix,_search,_data));
			}
		}else if(typeof(_arrs[i])==='object'){
			_btnArr.push(_arrs[i]);
		}
	}
	return _btnArr;
	/*
	_data = _BtnFromIndex(_arrs[i]);
	var _btn = {
			xtype: 'button',
			id: (_preffix || '') + 'btn_' + _name +'_' + _type,
			iconCls: _type+'Icon',
			scale: 'small',
			maxWidth: 23,
			handler: function () {
				eval((_preffix || '') +_name + '_' + _type +'_OnHandler()');
			}
	}
	*/
	return _btn;
}

function _Ext_BuildBtnFieldItem(_field,_preffix,_labelAlign,_search){
	var obj = {
			flex: 1,
			xtype: 'fieldcontainer',
			id: (_preffix || '')+'container_'+(_search?'query_':'')+_field.name,
			fieldLabel: (_TextFromIndex(_field.text || _field.name) || _field.text || _field.name)+ (_search?'':( _field.allowBlank?'':'<span style=color:red>*</span>')),
			combineErrors: true,
			msgTarget: 'side',
			layout: 'hbox',
			labelAlign: _field.labelAlign || _labelAlign,
			defaults: {
				hideLabel: true
			},
			items:[]
	};
	var _obj = _Ext_BuildTextItem(_field,_preffix,_labelAlign,_search);
	_obj.xtype='textfield';
	obj.items.push(_obj);
	var btns = _Ext_BuildBtnFieldButtons( _field.btns || ['preview'],_field.name,_preffix,_search);
	for(var i in btns){
		obj.items.push(btns[i]);
	}
			
	return obj;

}

function _Ext_BuildFormImageItem(_name,_preffix){
	var obj = [{
			xtype: 'image',
			width: 120,
			name: (_preffix || '') + _name,
			id: (_preffix || '') + _name,
			style: {
				border: '1px solid black'
			},
			src: '/resources/images/nopic.png'
		}, {
			xtype: 'button',
			text: '点击放大',
			iconCls: 'previewIcon',
			width: 80,
			handler: function () {
				eval( (_preffix || '')+_name+'_OnClick()');
			}
		}];
	return obj;
	
}

function _Ext_BuildFormItems(_field,_preffix,_labelAlign,_search){
	if(!_field.xtype || _field.xtype==='textfield' || _field.xtype=='numberfield' || _field.xtype=='textareafield'){
		return _Ext_BuildTextItem(_field,_preffix,_labelAlign,_search);
	}else if(_field.xtype==='hidden'){
		 return _Ext_BuildTextItem(_field,_preffix,_labelAlign,_search);
	}else if(_field.xtype==='btnfield'){
		return _Ext_BuildBtnFieldItem(_field,_preffix,_labelAlign,_search);
	}else if(_field.xtype==='combobox'){
		return _Ext_BuildComboboxItem(_field,_preffix,_labelAlign,_search);
	}else if(_field.xtype==='image'){
		return _Ext_BuildFormImageItem(_field.name,_preffix,_labelAlign);
	}else if(_field.xtype==='datefield'){
		var obj = _Ext_BuildTextItem(_field,_preffix,_labelAlign,_search);
		obj.xtype='datefield';
		return obj;
	}else if(_field.xtype==='textarea'){
		var obj = _Ext_BuildTextItem(_field,_preffix,_labelAlign,_search);
		obj.xtype='textareafield';
		return obj;
	}
}

function Ext_BuildFormItems(target,_name,__options){
	var arr =_preloadDataModel(target).fields;
	var reArr = [];
	var imageArr = [];
	var hiddenArr = [];
	var imageObj;
	var _hbox_flag = false;
	if(__options.formLayout==='hbox' || __options.queryFormLayout==='hbox')_hbox_flag=true;
	var _idx = 0;
	var _row_idx = -1;
	var _col_count = __options.search?__options.hboxQueryColumnCount:__options.hboxColumnCount;
	var _change_row = true;
	for(var i in arr){
		if(arr[i].exclude || arr[i].i_noDisplay || (__options.search && !arr[i].queryFlag))continue;
		//if(__options.search)arr[i].name = 'query_'+arr[i].name;
		if(arr[i].xtype==='image'){
			if(__options.search)continue;
			imageObj = _Ext_BuildFormItems(arr[i],__options.preffix,__options.labelAlign,__options.search);
			imageArr.push(imageObj[0]);
			imageArr.push(imageObj[1]);
			continue;
		}
		if(_hbox_flag || __options.search){
			if(_change_row){
				reArr.push({
					flex: 1,
					xtype: 'fieldcontainer',
					layout: 'hbox',
					defaultType: 'textfield',
					defaults: {
						anchor: '98%',
						labelWidth: 80
					},
					items: []
				});
				_change_row = false;
				_row_idx++;
			}
			
			if(arr[i].xtype!=='hidden'){
				_idx++;
				_change_row = (_idx%_col_count)==0;
				reArr[_row_idx].items.push(_Ext_BuildFormItems(arr[i],__options.preffix,__options.labelAlign,__options.search));
			}else{
				hiddenArr.push(_Ext_BuildFormItems(arr[i],__options.preffix,__options.labelAlign,__options.search));
			}
		}else{
			reArr.push(_Ext_BuildFormItems(arr[i],__options.preffix,__options.labelAlign,__options.search));
		}
	}
	if(_hbox_flag && hiddenArr.length>0){
		for(var i in hiddenArr){
			reArr.push(hiddenArr[i]);
		}
	}
	if(imageArr.length>0){
		var _total_container = [{
			flex: 1,
			xtype: 'fieldcontainer',
			layout: 'hbox',
			defaultType: 'textfield',
			defaults: {
				anchor: '98%',
				labelWidth: 80
			},
			items:[{
				flex: 1,
				xtype: 'fieldcontainer',
				layout: 'anchor',
				defaultType: 'textfield',
				defaults: {
					anchor: '98%',
					labelWidth: 80
				},items:reArr
			}, {
				width: 120,
				xtype: 'fieldcontainer',
				layout: 'anchor',
				defaultType: 'textfield',
				defaults: {
					anchor: '98%',
					labelWidth: 80
				},
				items: imageArr
			}]
		}];
		return _total_container;
	}
	return reArr;
}

function Ext_BuildSearchWin(target,_name,__options,__winOptions){
	Ext_BuildSearchForm(target,_name,__options||{});
	TenzeExt['search_'+_name+'Win'] = Ext.create('Ext.Window', 
			{title:'查询',width: 600,autoHeight:true,id:'search_'+_name+'Window',modal:true,border:false,
			x:20,y:20,resizable:true,draggable:true,closeAction:'close',plain:true,layout:'fit',
			items:[TenzeExt['search_'+_name+'Form']]
			,tbar:Ext.create('Ext.toolbar.Toolbar', {layout: {overflowHandler: 'Menu'}
				,items: [{text:'查询',scale:'small',disabled:false,id:'search_'+_name+'btQuery',scope:this,iconCls:'previewIcon',handler:function(){eval('search_'+_name+'btQuery_OnClick()');TenzeExt['search_'+_name+'Win'].hide();}}
						,{text:'重置',scale:'small',disabled:false,id:'search_'+_name+'btReset',scope:this,iconCls:'tbar_synchronizeIcon',handler:function(){if(TenzeExt['extend_search_'+_name+'btReset_OnClick']){TenzeExt['extend_search_'+_name+'btReset_OnClick']();}else{TenzeExt['search_'+_name+'Form'].getForm().reset();}}}
						,{text:'关闭',scale:'small',disabled:false,id:'search_'+_name+'btClose',scope:this,iconCls:'deleteIcon',handler:function(){TenzeExt['search_'+_name+'Win'].hide();}}]})

	});
}

function Ext_BuildSearchForm(target,_name,__options){
	__options.search = true;
	__options.queryFormLayout = 'hbox';
	Ext_BuildForm(target,'search_'+_name,__options);
	TenzeExt['search_'+_name+'getParams'] = function(){
		return TenzeExt['search_'+_name+'Form'].getValues();
	}
}

function Ext_BuildForm(target,_name,__options){
	var _options = jQuery.extend({},_formConfig,_preloadDataModel(target).table,__options);
	var _config = {           
        title:_options.title, 
        frame:true,
        timeout:_options.timeout,
        id:_name+'FormId', 
        trackResetOnLoad : _options.trackResetOnLoad,
		autoWidth : true,
		hidden:_options.hidden,
        border : false,                
        autoScroll : true,
        bodyStyle:'padding:5px 5px 0',        
        defaultType: 'textfield',
        defaults: {
            anchor: '98%'
        },
        items: _options.items || Ext_BuildFormItems(target,_name,_options)
	}
		_config.fieldDefaults = {
            msgTarget: 'side',            
            labelAlign: _options.labelAlign,
            labelWidth:  _options.labelWidth || 80
        };
        if(_options.disableEdit)_config.fieldDefaults.readOnly=true;
		if(_options.toolbar)_config.tbar = Ext.create('Ext.toolbar.Toolbar', {layout: {overflowHandler: 'Menu'}, items: _options.toolbar||[]});
		if(_options.renderTo)_config.renderTo = _option.renderTo;
		if(_options.autoHeight){_config.autoHeight=true;}else{_config.height=_options.height;}
		TenzeExt[_name+'Form'] = Ext.create('Ext.form.Panel',_config);
		//TenzeExt[_name+'Form'].getForm().trackResetOnLoad = true;
}

function Ext_BuildColumFields(target,_preffix){
	var arr =  _preloadDataModel(target).fields;
	var reArr = [];
	
	var obj;
	reArr.push(Ext.create('Ext.grid.RowNumberer',{width:30}));
	for(var i in arr){
		if(arr[i].exclude || arr[i].c_noDisplay)continue;
		obj  = {
				text:_TextFromIndex(arr[i].text || arr[i].name) || arr[i].text || arr[i].name,
				align:arr[i].columnAlign ,
				id:(_preffix||'')+'re_'+arr[i].name,
				sortable:arr[i].sortable,
				hidden:arr[i].hidden,
				dataIndex:arr[i].name,
				width:arr[i].width || 100
		};
		if(arr[i].decimalPrecision)obj.decimalPrecision = arr[i].decimalPrecision;
		if(arr[i].renderer && arr[i].renderer.length>0)obj.renderer = arr[i].renderer;
		if(arr[i].summaryType && arr[i].summaryType.length>0)obj.summaryType = arr[i].summaryType;
		if(arr[i].summaryRenderer && arr[i].summaryRenderer.length>0)obj.summaryRenderer = arr[i].summaryRenderer;
		if(arr[i].datadic && arr[i].datadic.length>0){
			obj.renderer = _getExtDatadic(arr[i].datadic);
		}
		reArr.push(obj);
	}
	return reArr;
}


function Ext_BuildGrid(target,_name,__options){
	var _options = jQuery.extend({},_gridConfig,__options);
	Ext_BuildStore(target,_name,_options);
	var _config = {
			store:TenzeExt[_name+'GridStore'],
			id:_name+'GridId',
			enableColumnHide:_options.enableColumnHide,
			enableColumnMove:_options.enableColumnMove,
			autoScroll:true,
			border:false,
			containerScroll:true,
			title:_options.title,
			frame:true,
			columns:_options.columns || Ext_BuildColumFields(target,_options.preffix)
	};
	if(_options.region && _options.region.length>1)_config.region = _options.region;
	if(_options.height==0){_config.autoHeight=true;}else{_config.height=_options.height;}
	if(_options.width==0){_config.autoWidth=true;}else{_config.width=_options.width;_config.autoWidth=false;}
	if(_options.renderTo)_config.renderTo = _options.renderTo;
	if(_options.isRowEdit){
		var _cellEditing = Ext.create('Ext.grid.plugin.CellEditing', {
	        clicksToEdit: 1,
	        id:_name+'CellEditing'
	    });
		_config.selModel={selType:'cellmodel'};
		_config.plugins = [_cellEditing];
	}
	if(_options.customBars){
		_config.customBars = _options.customBars;
	}else{
		_config.tbar = Ext.create('Ext.toolbar.Toolbar', {layout: {overflowHandler: 'Menu'},items: _options.tbar ||[] });
	}
	var _config_features = [{ftype:'summary'}];
	if(_options.groupField)_config_features.push({
        id: _name+'group',
        ftype: 'groupingsummary',
        groupHeaderTpl: '{name}',
        hideGroupedHeader: true,
        enableGroupingMenu: false
    });
	if(_options.enablePage)_config.dockedItems = [{
        xtype: 'pagingtoolbar',
        store: TenzeExt[_name+'GridStore'], 
        dock: 'bottom',
        displayInfo: true,
        listeners : {
		   	'beforechange' : function() {
              
		    }
	    }
    }];
	if(_options.mulSel && _options.checkbox)_config.selModel = TenzeExt[_name+'Sm'];
	TenzeExt[_name+'Grid'] = Ext.create(_options.panelClass,_config);
	
	if(_options.itemdbclick){
		TenzeExt[_name+'Grid'].addListener('itemdblclick', function(obj, record, item, index, e, eOpts){
	    	try{eval(_name+'GridItemdbclick(obj, record, item, index, e, eOpts)');}catch(e){}
	    });
	}
}

function Ext_BuildCollection(_name){
	TenzeExt[_name+'Collection'] = new Ext.util.MixedCollection();
}

function Ext_BuildSelectModel(_name,_options){

	var _config = {};
	Ext_BuildCollection(_name);
	if(_options){
		if(_options.gridCheckOnly==true){
			_config.checkOnly = true;
		}
		if(_options.signleSelect==true){
			_config.mode = 'SINGLE';
		}else if(_options.collectionKey && _options.collectionKey.length>0){
			_config.multiSelect = true,
			_config.listeners = {
				'select' : function(_sm,colIndex,rowIndex){
					var record = _sm.getStore().getAt(rowIndex);
					TenzeExt[_name+'Collection'].add(record.get(_options.collectionKey),record);
				},
				'deselect' : function(_sm,colIndex,rowIndex){
					var record = _sm.getStore().getAt(rowIndex);
					TenzeExt[_name+'Collection'].remove(TenzeExt[_name+'Collection'].get(record.get(_options.collectionKey)));
				}
			};
		}
	}
	TenzeExt[_name+'Sm'] = Ext.create('Ext.selection.CheckboxModel' ,_config);
}

function Ext_BuildStore(target,_name,__options){
		 var _options = jQuery.extend({},_gridStoreConfig,__options);
		 Ext_BuildModel(target,_name);
		 Ext_BuildSelectModel(_name,_options);
		 var _config = {
			        model: _name+'Data',                          
			        pageSize: _options.pageSize ,   
			        storeId: _name+'GridStore', 
			        id:_name+'GridStoreId',      
			        remoteSort: _options.remoteSort,
			        proxy: {                                                                                                  
			            type: 'ajax',
			            url: _options.url,                                                                                   
			            reader: {                                                                                             
			                type: 'json',                                                                                     
			                root: _options.rootItem ,                
			                totalProperty  : _options.totalProperty                                                                          
			            }
			        },  
			        autoLoad: _options.autoLoad 
	    };
			 if(_options.sorters && _options.sorters.length>1)_config.sorters = _options.sorters;
			 if(_options.groupField && _options.groupField.length>1)_config.groupField = _options.groupField;
			 var _config_listeners = {};
			 if(_options.enablePage== true && _options.applyName != ""){
				 _config_listeners.beforeload = function(store, options){
				   			try{
					   			if(_options.collectionKey &&_options.collectionKey != ''){
					   				store.each(function(rec){
										if(TenzeExt[_name+'Sm'].isSelected(rec)){
											TenzeExt[_name+'Collection'].add(rec.get("${collectionKey}"),rec);
										}else{
											TenzeExt[_name+'Collection'].remove(TenzeExt[_name+'Collection'].get(rec.get(_options.collectionKey)));
											Ext.util.Observable.capture(TenzeExt[_name+'Sm'],function(eventName){
												if(eventName == 'deselect'){
													return false;
												}
											});
										}
					   				});
					   			}
				    			Ext.apply(TenzeExt[_name+'GridStore'].proxy.extraParams, eval(_options.applyName+'()'));
				    		}catch(e){}
				    };
			 }
			 if(_options.collectionKey &&_options.collectionKey != ''){
				 _config_listeners.load = function(store, records, options){
				    	var total = store.getCount();
				    	for(var i = 0; i < total; i++){
				    		var rec = store.getAt(i);
				    		if(TenzeExt[_name+'Collection'].containsKey(rec.get(_options.collectionKey))){
				    			TenzeExt[_name+'Sm'].select(i, true, false);
				    		}
				    	}
				    };
			 }
			 _config.listeners = _config_listeners;
			 TenzeExt[_name+'GridStore'] = Ext.create('Ext.data.Store', _config);
 
}

function Ext_BuildModel(target,_name){
	try{
		Ext.create(_name+'Data');
	}catch(e){
		var fields = Ext_BuildModelFields(target) ;
		Ext.define(_name+'Data', {
				extend : 'Ext.data.Model',
				fields : fields
		});
	}
}

function Ext_BuildModelFields(target){
	var arr =_preloadDataModel(target).fields;
	var reArr = [];
	var obj = {};
	for(var i in arr){
		if(arr[i].exclude)continue;
		obj = {
				name:arr[i].name || '',
				type:arr[i].type || 'string',
				sortable:arr[i].sortable
		};
		if(obj.type==='date'){
			obj.dateFormat = arr[i].dateFormat || 'Y-m-d H:i:s';
		}
		reArr.push(obj);
	}
	return reArr;
}


var __ExtUiTable = {
	hboxColumnCount:1,
	hboxQueryColumnCount:2,
	formLayout:'',
	labelAlign:'right',
	labelWidth:80,
	formEditBar:'btSave,btClose',
	formBtn_prefix:'form',
	columnBtn_prefix:'',
	beanName:'',
	beanId:'',
	lockRownumber:'',
	enableRowNumber:'',
	imgWidth:120,
	radioGroupName:'',
	radioColumns:1,
	checkboxGroupName:'',
	checkboxColumns:1
};

var __ExtUiField = {
		xtype:'',
	     cancelbtn:false,
	     //inputType:null,
	     vtype:'',
	     renderer:'',
	     allowBlank:true,
	     minValue:'',
	     maxValue:'',
	     maxLength:0,
	     minLength:0,
	     readOnly:false,
	     editable:false,
	     multiSelect:false,
	     disabled:false,
	     id:'',
	     emptText:'',
	     hidden:false,
	     defValue:'',
	     width:120,
	     //decimalPrecision:2,
	     //summaryType:'',
	     //summaryRenderer:'',
	     queryFieldXType:'',
	     queryReadOnly:false,
	     fseq:999,
	     querySeq:999,
	     cseq:999,
	     sortable:true,
	     columnAlign:'left',
	     locked:false,
	     iconCls:'previewIcon',
	     
	     exclude:false,
	     c_noDisplay:false,
	     i_noDisplay:false,
	     queryFlag:false,
	     isPassword:'',
	     isStartEnd:false,
	     isCurMonthStartEnd:true,
	     //datadic:'',
	     combogrid:false,
	     gHeadName:'',
	     fieldGroupNo:1,
	     queryFieldGroupNo:1,
	     text:'',
	     afterSubTpl:'',
	     radioGroupNo:0,
	     dateFormat:null
};


function Ext_UiTable(options){
	//Ext.apply(options,new __ExtUiTable());
	return jQuery.extend({},__ExtUiTable,options);
}

function Ext_UiField(options){
	//Ext.apply(options,new __ExtUiField());
	return jQuery.extend({},__ExtUiField,options);
}

var _$_tools = {		
		isArray: function(arr) {
			return Object.prototype.toString.apply(arr) === "[object Array]";
		}
};

function _bolConvert(val){
	if(val===1 || val==='1' || val===true || val==='true')return true;
	if(val===0 || val==='0' || val===false || val==='false')return false;
	return false;
}

function listToTree(sNodes,_setting) {
	var setting = jQuery.extend({},_treeConvertSetting,_setting||{});
	var i,l,
	key = setting.simpleData.idKey,
	parentKey = setting.simpleData.pIdKey,
	childKey = setting.key.children,
	leafKey = setting.key.leaf ,
	convertProps = setting.convertProps,
	enableCheck = setting.enableCheck
	;
	if (!key || key=="" || !sNodes) return [];
	if (_$_tools.isArray(sNodes)) {
		var r = [];
		var tmpMap = [];
		for (i=0, l=sNodes.length; i<l; i++) {
			tmpMap[sNodes[i][key]] = sNodes[i];
		}
		for (i=0, l=sNodes.length; i<l; i++) {
			if (tmpMap[sNodes[i][parentKey]] && sNodes[i][key] != sNodes[i][parentKey]) {
				if (!tmpMap[sNodes[i][parentKey]][childKey]){
					tmpMap[sNodes[i][parentKey]][childKey] = [];
				}
					
				tmpMap[sNodes[i][parentKey]][childKey].push(sNodes[i]);
			} else {
				r.push(sNodes[i]);
			}
			sNodes[i].id = sNodes[i][setting.extIdKey];
			sNodes[i].text = sNodes[i][setting.extTextKey];
			if(convertProps && convertProps.length>1){
				for(var j in convertProps){
					sNodes[i][convertProps[j].target] = _bolConvert(sNodes[i][convertProps[j].key]);
				}
			}
			if(enableCheck){
				sNodes[i].checked = enableCheck[sNodes[i].id+'']?true:false;
			}
		}
		return r;
	}else {
		return [sNodes];
	}
};


