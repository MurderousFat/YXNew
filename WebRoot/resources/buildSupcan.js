var _supcanColCfg = {
		'#':'',
		'@dataType':'string',
		//'@displayMask':'',
		//'@isUnique':false,
		//'@nullAble':false,
		//'@defaultValue':'0',
		//'@isHyperlink':false,
		//'@isHide':false,
		//'@decimal':2,
		//'@sortAble':true,
		'@width':90,
		//'@movaAble':false,
		//'@minWidth':40,
		'@align':'right',
		'@vAlign':'vcenter',
		'@alignHeader':'center',
		//'@isImage':false,
		//'@freeInputAble':false,
		//'@imageArrange':'useOriSize',
		//'@editAble':true,
		//'@editType':'Edit',
		//'@isCheckboxOnly':false,
		'@isSelectEditWhenFocude':true,
		//'@maxChars':'0',
		//'@spin':false,
		//'@spinAsCalendar':true,
		//'@isConvertToZeroIfInputNull':true,
		//'@totalExpress':'@sum',
		//'@totalAlign':'right',
		//'@totalDecimal':'2'
};

var _supcanItemCfg = {
		//'@id':''
		'@dataType':'string'
		,'@isLastInput':false
		,'@align':'left'
		,'@type':'Edit'
		,'@visible':true 
		,'@width':3
		,'@editSize':2
		,'@height':1
		,'@editAble':true
		,'@nullAble':true 
		,'@isSelectEditWhenFocus':true
		,'@freeInputAble':false
		,'@isDropDownWhenFocus':true
		,'@leftText':''
}

var _supcanTreeListPropertiesCfg = {
		//'@key':'',
		//'@ListTreeSwitchAble':true,
		'@rowHeight':30,
		'@headerHeight':24,
		'@curSelMode':'row',
		'@isShowRuler':true,
		'@autoBreakLine':'breakline',
		'@enter':'right',
		'@isSelectEditWhenFocus':true,
		'@isHiLightModified':true,
		'@isHiLightNewRow':true,
		'@sort':'',
		'@isAutoFitWidth':true,
		'@editAble':false,
		'@isTree':false,
		'@treeFormat':'normal',
		'@pageRows':''
}

var _supcanFreeFormPropertiesCfg = {
		//'@key':'',
		//'@ListTreeSwitchAble':true,
		'@bgColor':'#D9E7F8'
}

function Supcan_BuildTreeList(_target,_options){
	var _cfg = jQuery.extend({},_options);
	var _supcan =_preloadDataModel(_target).Supcan || {TreeList:{}};
	var _properties_cfg = jQuery.extend({},_supcanTreeListPropertiesCfg,_supcan.TreeList.Properties||{},_cfg.Properties || {});
	var _expresses = _cfg.Expresses || _supcan.TreeList.Expresses;
	var _fonts = _cfg.Fonts || _supcan.TreeList.Fonts || [{},{'@faceName':'微软雅黑','@bold':true,'@size':'-20'}];
	var _cols = _cfg.Cols || _supcan.TreeList.Cols || [];
	
	var _colArr = [];
	var _col;
	var _dropList = [];
	for(var i in _cols){
		_col = jQuery.extend({},_supcanColCfg,_cols[i]);
		_BuildDropList(_dropList,_col,'@editType');
		_colArr.push(_col);
	}
	var _DropListItems = Supcan_BuildDropList(_dropList);
	var _treeListCfg = {
		Properties:_properties_cfg,
		Fonts:{Font:_fonts},
		Cols:{Col:_colArr},
		DropLists:_DropListItems
	}
	if(_expresses){
		_treelistCfg.expresses = {};
		_treelistCfg.expresses.express = _expresses;
	}
	return jQuery.json2xml(_treeListCfg,{rootTagName:'TreeList',formatOutput:false});
}

function Supcan_BuildFreeForm(_target,_options){
	var _cfg = jQuery.extend({},_options);
	var _supcan =_preloadDataModel(_target).Supcan || {FreeForm:{}};
	var _properties_cfg = jQuery.extend({},_supcanFreeFormPropertiesCfg,_supcan.FreeForm.Properties||{},_cfg.Properties || {});
	var _expresses = _cfg.Expresses || _supcan.FreeForm.Expresses;
	var _fonts = _cfg.Fonts || _supcan.FreeForm.Fonts || [{},{'@faceName':'微软雅黑','@bold':true,'@size':'-20'}];
	var _items = _cfg.Items || _supcan.FreeForm.Items || [];
	
	var _itemArr = [];
	var _visibleArr = [];
	var _hiddenArr = [];
	var _dropList = [];
	var _obj;
	for(var i in _items){
		obj = jQuery.extend({},_supcanItemCfg,_items[i])
		if(!obj['@id'])continue;
		obj['@leftText'] = obj['@leftText']?obj['@leftText']+':':'';
		if(obj['@visible']){
			_visibleArr.push(obj);
		}else{
			_hiddenArr.push(obj);
		}
		_BuildDropList(_dropList,obj);
		/*
		if(obj.DropList){
			obj['@type'] = obj.DropList.type || 'DropList';
			obj['@droplistID'] = obj.DropList.DropListId || '';
			if(obj['@type'].toLowerCase()!='droplist'){
				obj['@dropdownWidth'] = obj.DropList.DropdownWidth || 700;
			}
			if(obj['@type'].toLowerCase()=='editabledroptreelist'){
				obj['@RefreshChars'] = obj.DropList.RefreshChars || 2;
			}
			_dropList.push(obj.DropList);
			delete obj.DropList;
		}
		*/
		/*
		if(obj['@type']=='DropList' || obj['@type']=='EditAbleDropTreelist' || obj['@type']=='DropTreeList'){
			_dropList.put(Ext.clone(obj.DropList || {}));
		}
		*/
	}
	
	var _colArr = [];
	for(var i=0;i<9;i++){
		_colArr.push({'@width':'11%'});
	}
	
	
	var idx = 0;
	var row_idx = 0;
	var breakline = true;
	var trArr = [];
	for(var i in _visibleArr){
		if(breakline){
			trArr.push({td:[],'@height':24});
			trArr.push({td:[],'@height':1});
		}
		trArr[row_idx].td.push({Input:_visibleArr[i]});
		trArr[row_idx].td.push({});
		trArr[row_idx].td.push({});
		idx++;
		if(idx%3==0){
			row_idx+=2;
			breakline = true;
		}else{
			breakline = false;
		}
	}
	
	idx = 0;
	row_idx += (breakline?0:2);
	breakline = true;
	for(var i in _hiddenArr){
		if(breakline){
			trArr.push({td:[],'@height':24});
			trArr.push({td:[],'@height':1});
		}
		trArr[row_idx].td.push({Input:_hiddenArr[i]});
		trArr[row_idx].td.push({});
		trArr[row_idx].td.push({});
		idx++;
		if(idx%3==0){
			row_idx+2;
			breakline = true;
		}else{
			breakline = false;
		}
	}
	
	var _TableLayout_Arr = {col:_colArr,tr:trArr,'@width':'100%'};
	var _DropListItems = Supcan_BuildDropList(_dropList);
	
	var _freeFormCfg = {
		Properties:_properties_cfg,
		Fonts:{Font:_fonts},
		Objects:{TableLayout:_TableLayout_Arr},
		DropLists:_DropListItems
	}
	if(_expresses){
		_freeFormCfg.expresses = {};
		_freeFormCfg.expresses.express = _expresses;
	}
	return jQuery.json2xml(_freeFormCfg,{rootTagName:'FreeForm',formatOutput:false});
}

function _BuildDropList(_dropList,obj,_type){
	if(obj.DropList){
		obj[_type || '@type'] = obj.DropList.type || 'DropList';
		obj['@droplistID'] = obj.DropList.DropListId || '';
		if(obj[_type || '@type'].toLowerCase()!='droplist'){
			obj['@dropdownWidth'] = obj.DropList.DropdownWidth || 700;
		}
		if(obj[_type || '@type'].toLowerCase()=='editabledroptreelist'){
			obj['@RefreshChars'] = obj.DropList.RefreshChars || 2;
			obj['@dropdownWidth'] = obj.DropList.DropdownWidth || 700;
		}
		_dropList.push(obj.DropList);
		delete obj.DropList;
	}
}

function Supcan_BuildDropList(dropListArr){
	var _dropArr = [];
	var obj;
	for(var i in dropListArr){
		if(dropListArr[i].type.toLowerCase()=='droplist'){
			var _data = _getDatadic(dropListArr[i].datadic) || [];
			var _store = [];
			for(var j in _data){
				_store.push({'@key':_data[j].code,'#':_data[j].codedesc});
			}
			obj = {
					'@id':dropListArr[i].DropListId
					,item:_store
			}
			_dropArr.push(obj);
		}
		else
		if(dropListArr[i].type.toLowerCase()=='editabledroptreelist'){
			obj = {
					'@id':dropListArr[i].DropListId,
					'@DataCol':dropListArr[i].DataCol,
					'@DisplayCol':dropListArr[i].DisplayCol
			};
			_dropArr.push(obj);
		}
	}
	return {DropList:_dropArr};
}