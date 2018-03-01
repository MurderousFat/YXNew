Ext.define('resources.commonjs.fileUpload',{
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
				{
		            xtype: 'displayfield',
		            name: 'allow',
		            fieldLabel: '文件格式',
		            value: 'png|jpg|bmp|txt|doc|docx|xls|xlsx|ppt|pdf'
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
		};
		
		function uploadFile(){
			submitForm('/uploadFile.gx', upload_file_form, function(form, action){
				showTitMsg('上传文件成功', function(){
					if(action.result.success=='true'){
						var path = action.result.file_path;
						var filename= action.result.file_name;
						try{
							if(that.uploadCallback!=null){
								that.uploadCallback(path,filename);
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

