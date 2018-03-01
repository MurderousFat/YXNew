_fillInDataModel(
        'com.tenze.pms.facade.dto.bi.BiPartTypeDto',
        {
            table:Ext_UiTable({
                beanId:'biPartTypeId',
                beanName:'biPartTypeName',
            })
            ,
            fields:[
                 Ext_UiField({type:'string',name:'id',text:'id',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'version',text:'version',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'createtime',text:'createtime',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'updatetime',text:'updatetime',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'fdelFlag',text:'fdelFlag',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'typeNo',text:'配件类型编号',xtype:'textfield',width:200,hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'typeName',text:'配件类型名称',xtype:'textfield',width:200,hidden:false,allowBlank:false,queryFlag:true}),
            ]
    }        
);