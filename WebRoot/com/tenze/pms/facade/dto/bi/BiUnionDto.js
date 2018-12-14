_fillInDataModel(
        'com.tenze.pms.facade.dto.bi.BiUnionDto',
        {
            table:Ext_UiTable({
                beanId:'biUnionId',
                beanName:'biUnionName',
            })
            ,
            fields:[
                Ext_UiField({type:'string',name:'id',text:'id',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                Ext_UiField({type:'string',name:'version',text:'version',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                Ext_UiField({type:'string',name:'createtime',text:'createtime',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                Ext_UiField({type:'string',name:'updatetime',text:'updatetime',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                Ext_UiField({type:'string',name:'fdelFlag',text:'fdelFlag',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'unionNo',text:'unionNo',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'unionName',text:'组织名称',xtype:'textfield',hidden:false,allowBlank:false,queryFlag:true}),
                 Ext_UiField({type:'string',name:'parentNo',text:'parentNo',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'parentName',text:'上级组织',xtype:'btnfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'expandedFlag',text:'折叠',xtype:'combobox',datadic:'UNFOLDING',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'leafFlag',text:'leafFlag',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
            ]
    }        
);