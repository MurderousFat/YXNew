_fillInDataModel(
        'com.tenze.pms.facade.dto.mer.MerFaultRepairDto',
        {
            table:Ext_UiTable({
                beanId:'merFaultRepairId',
                beanName:'merFaultRepairName',
                formLayout:'hbox',
                hboxColumnCount:2
            })
            ,
            fields:[
                    Ext_UiField({type:'string',name:'id',text:'id',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                    Ext_UiField({type:'string',name:'version',text:'version',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                    Ext_UiField({type:'string',name:'createtime',text:'createtime',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                    Ext_UiField({type:'string',name:'updatetime',text:'updatetime',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                    Ext_UiField({type:'string',name:'fdelFlag',text:'fdelFlag',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'merName',text:'商家名称',xtype:'textfield',readOnly:true,hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'merNo',text:'商户编号',xtype:'textfield',readOnly:true,hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'deviceId',text:'deviceId',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'deviceNo',text:'设备编号',xtype:'btnfield',readOnly:true,hidden:false,allowBlank:false,queryFlag:true}),
                 Ext_UiField({type:'string',name:'faultType',text:'故障类型',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'faultDesc',text:'故障描述',xtype:'textfield',width:300,hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'contactPerson',text:'联系人姓名',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'contactPhone',text:'联系人电话',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'contactAddr',text:'联系人地址',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'acceptState',text:'受理状态',xtype:'combobox',datadic:'ACCEPT_STATE',readOnly:true,hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'acceptTime',text:'受理时间',xtype:'datefield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'acceptPerson',text:'受理人',xtype:'textfield',readOnly:true,hidden:false,allowBlank:true,queryFlag:true}),
            ]
    }        
);