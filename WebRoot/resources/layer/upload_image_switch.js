var uploadImageSwitchWin = Ext.create('Ext.Window', {
    title: '选择上传方式',
	width: 400,
	modal:false,
	autoHeight:true,
	resizable : false,
	draggable : false,
	closeAction : 'close',
	layout: 'fit',
	id:'file_upload_switch_window',
	items : [  
		{
			xtype:'panel',
			width: 400,
			height:70,
			defaults: {
				style:{margin: '5px'}
			},
			layout: {
		        type: 'vbox',       // Arrange child items vertically
		        align: 'stretch',    // Each takes up full width
		        padding: 5
		    },
		    items:[
		    	{
		            xtype: 'button',
		            text : '本地上传', 
		            listeners: {
				        click: function() {
				        	_uploadImageLocalWin();
				            uploadImageSwitchWin.hide();
				        }
				    }
		        },{
		            xtype: 'button',
		            text : '在线拍照',
		            listeners: {
			            click: function() {
			            	_uploadImageOnlineWin();
				            uploadImageSwitchWin.hide();
				        }
				    }
		        }
		    ]
		}
		]
});

Ext.define('resources.commonjs.upload',{
	extend:'Ext.Window',
	title: '文件上传',
	width: 400,
	modal:true,
	autoHeight:true,
	resizable : false,
	draggable : false,
	closeAction : 'close',
	layout: 'fit',
	uploadCallback:null,
	initUploadConfig:null,
	constructor: function() {
		var that = this;
		var upload_file_form = Ext.create('Ext.form.Panel', {
			title : '',
			frame : true,
			timeout : 30,
			autoHeight : true,
			minHeight:100,
			trackResetOnLoad : false,
			autoWidth : true,
			hidden : false,
			border : false,
			autoScroll : true,
			bodyStyle : 'padding:5px 5px 0',
			fieldDefaults : {
				msgTarget : 'side',
				labelAlign : 'right',
				labelWidth : 80
			},
			defaultType : 'textfield',
			defaults : {
				anchor : '95%'
			},
			tbar:[
				{text:'上传',scale:'small',disabled:false,iconCls:'uploadIcon',handler:function(){uploadFile();}},
		    	{text:'关闭',scale:'small',disabled:false,iconCls:'deleteIcon',handler:function(){that.hide();}},
			],
			items : [
				{xtype:'hidden',name:'allowExt',value:''},
				{xtype:'hidden',name:'directory',value:''},
				{
					xtype:'filefield',
					fieldLabel:'选择文件',
					buttonText:'浏览',
					flex:1,
					name:'file',
					allowBlank:false
				},
				{xtype:'hidden',name:'file_upload_is_resize',value:'1'},
				{xtype:'hidden',name:'method',value:'ajax'},
			]
		});	
		
		that.initUploadConfig = function(_cf){
			if(!isEmpty(_cf.allowExt)){
				upload_file_form.form.findField("allowExt").setValue(_cf.allowExt);
			}
			if(!isEmpty(_cf.directory)){
				upload_file_form.form.findField("directory").setValue(_cf.directory);
			}
			if(!isEmpty(_cf.is_resize)){
				upload_file_form.form.findField("file_upload_is_resize").setValue(_cf.is_resize);
			}
		}
		
		function uploadFile(){
			submitForm('http://image.yinxindata.com/Upload,', upload_file_form, function(form, action){
				showTitMsg('上传文件成功', function(){
					if(action.result.success=='true'){
						var path = action.result.file_path;
						var filename= action.result.file_name;
						var miniPath = action.result.small_path;
						try{
							if(that.uploadCallback!=null){
								that.uploadCallback(path,filename,miniPath);
							}
						}catch(e){}
						that.hide();
					}else{
						showErrorMsg(action.result.failure);
					}
				});
			},function(form, action){
				var errmsg = action.result.failure;
				showErrorMsg(errmsg);
			});
		}
		
		 this.items =  [upload_file_form];
		 this.callParent(arguments);
	}
});

var _uploadWindow = null;
function _uploadImageLocalWin(){
	var _uploadImageConfig = uploadImageConfig || {};
	var _cfg = jQuery.extend({},{
		allowExt:'png|jpg|bmp',
		directory:'common',
		file_upload_is_resize:'1'
		},_uploadImageConfig.options);
	if(_uploadWindow==null){
		_uploadWindow = Ext.create('${base}.resources.commonjs.upload');
	}
	_uploadWindow.initUploadConfig(_cfg);
	/** parameters: path:原图路径，fileName:文件名称 miniPath：缩略图路径*/
	_uploadWindow.uploadCallback =  _uploadImageConfig.callback || function(){};
	/*
	function(path,miniPath){
		${curPre}Form.form.findField('fyyzzImage').setValue(path);
		fyyzzImageShowExtImg.setSrc(path);
	};
	*/
	_uploadWindow.show();
}

function _uploadImageOnlineWin(){
	var _uploadImageConfig = uploadImageConfig || {};
	var _cfg = jQuery.extend({},{
		allowExt:'png|jpg|bmp',
		directory:'common',
		file_upload_is_resize:'1'
		},_uploadImageConfig.options);
	art.dialog.data('scanner_upload_params',_cfg);
	art.dialog.data('scanner_upload_callback',function(data){
		if(_uploadImageConfig && _uploadImageConfig.callback){
			_uploadImageConfig.callback(data.file_path,data.file_name,data.small_path);
		}
	});
	art.dialog.open('/resources/scannerUpload/dialog.html',{
		title:'在线拍照',
		width:document.documentElement.clientWidth,
		height:document.documentElement.clientHeight,
		lock:true
	},false);
}