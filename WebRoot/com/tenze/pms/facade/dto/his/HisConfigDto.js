_fillInDataModel(
        'com.tenze.pms.facade.dto.his.HisConfigDto',
        {
            table:Ext_UiTable({
                beanId:'hisHisconfigId',
                beanName:'hisHisconfigName',
            })
            ,
            fields:[
                    Ext_UiField({type:'string',name:'id',text:'id',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                    Ext_UiField({type:'string',name:'version',text:'version',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                    Ext_UiField({type:'string',name:'createtime',text:'createtime',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                    Ext_UiField({type:'string',name:'updatetime',text:'updatetime',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                    Ext_UiField({type:'string',name:'fdelFlag',text:'fdelFlag',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'fhospitalName',text:'卫生站名称',xtype:'btnfield',hidden:false,readOnly:true,allowBlank:false,queryFlag:true}),
                 Ext_UiField({type:'string',name:'fkey',text:'医院编码',xtype:'textfield',hidden:false,readOnly:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'fusername',text:'登录用户',xtype:'textfield',hidden:false,allowBlank:false,queryFlag:true}),
                 Ext_UiField({type:'string',name:'fpassword',text:'登录密码',xtype:'textfield',hidden:false,allowBlank:false,queryFlag:true}),
                 Ext_UiField({type:'string',name:'merchantId',text:'merchantId',xtype:'hidden',hidden:true,allowBlank:false,queryFlag:true}),
                 Ext_UiField({type:'string',name:'fcounty',text:'所属地区',xtype:'textfield',hidden:false,allowBlank:false,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ffullName',text:'医院全称',xtype:'textfield',hidden:false,allowBlank:false,queryFlag:true}),
             ]
    }        
);