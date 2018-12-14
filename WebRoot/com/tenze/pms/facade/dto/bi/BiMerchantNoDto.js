_fillInDataModel(
        'com.tenze.pms.facade.dto.bi.BiMerchantNoDto',
        {
            table:Ext_UiTable({
                beanId:'biMerchantNoId',
                beanName:'biMerchantNoName',
            })
            ,
            fields:[
                Ext_UiField({type:'string',name:'id',text:'id',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                Ext_UiField({type:'string',name:'version',text:'version',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                Ext_UiField({type:'string',name:'createtime',text:'createtime',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                Ext_UiField({type:'string',name:'updatetime',text:'updatetime',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                Ext_UiField({type:'string',name:'fdelFlag',text:'fdelFlag',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'merId',text:'merId',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'merName',text:'商家名称',xtype:'btnfield',width:200,hidden:false,allowBlank:false,queryFlag:true}),
                 Ext_UiField({type:'string',name:'noName',text:'商户编号',xtype:'textfield',width:200,hidden:false,allowBlank:false,queryFlag:true}),
                 Ext_UiField({type:'string',name:'merTenantName',text:'商户名称',xtype:'textfield',width:200,hidden:false,allowBlank:false,queryFlag:true}),
            ]
    }        
);