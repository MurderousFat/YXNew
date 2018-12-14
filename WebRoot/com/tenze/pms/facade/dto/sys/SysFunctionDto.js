_fillInDataModel(
        'com.tenze.pms.facade.dto.sys.SysFunctionDto',
        {
            table:Ext_UiTable({
                beanId:'sysFunctionId',
                beanName:'sysFunctionName',
            })
            ,
            fields:[
                 Ext_UiField({type:'string',name:'id',text:'id',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'version',text:'version',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'createtime',text:'createtime',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'updatetime',text:'updatetime',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'fdelFlag',text:'fdelFlag',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'functionName',text:'按钮名称',xtype:'textfield',hidden:false,allowBlank:false,queryFlag:true}),
                 Ext_UiField({type:'string',name:'functionBtn',text:'按钮类型',xtype:'combobox',datadic:'BTNTYPE',hidden:false,allowBlank:false,queryFlag:true}),
                 Ext_UiField({type:'string',name:'functionUrl',text:'按钮权限',xtype:'textfield',hidden:false,allowBlank:false,queryFlag:true}),
                 Ext_UiField({type:'string',name:'sortNo',text:'排序',xtype:'numberfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'menuId',text:'menuId',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'enabled',text:'启用',xtype:'combobox',datadic:'ENABLED',hidden:false,allowBlank:false,queryFlag:true}),
            ]
    }        
);