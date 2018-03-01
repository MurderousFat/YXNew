_fillInDataModel(
        'com.tenze.pms.facade.dto.his.HisSettleMasDto',
        {
            table:Ext_UiTable({
                beanId:'hisSettleMasId',
                beanName:'hisSettleMasName',
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
                 Ext_UiField({type:'string',name:'hisBillState',text:'状态',xtype:'textfield',width:140,datadic:'HIS_BILL_STATE',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aac044',text:'证件号码',width:200,xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'personName',text:'人员名称',align:'center',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aac004',text:'性别',xtype:'textfield',width:60,datadic:'aac004',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ake007',text:'就诊日期',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aaz217',text:'就诊记录号',xtype:'textfield',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aka130',text:'就诊类别',xtype:'textfield',datadic:'aka130',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akc050',text:'入院疾病诊断',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akc264',text:'医疗费用总额',width:80,xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'selfPay',text:'自费金额',width:80,xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'cab053',text:'手机',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aac005',text:'联系电话',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akc190',text:'门诊号',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aae013',text:'备注',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akc090',text:'住院次数',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aab014',text:'医护人员公民身份证',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'jbrmc',text:'经办人',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akc220',text:'处方号',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ykc675',text:'结算类型',xtype:'textfield',datadic:'ykc675',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ykc618',text:'结算业务号',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aac057',text:'离退休证号',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckz564',text:'生育备案审批号',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'yzz016',text:'转诊备案号',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aaa138',text:'一般诊疗费标志',xtype:'textfield',datadic:'aaa138',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc803',text:'产前检查标志',xtype:'textfield',datadic:'ckc803',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckz543',text:'ckz543',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aae011',text:'aae011',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'sessionid',text:'sessionid',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'jmc',text:'加密串',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
            ]
        ,Supcan:{
        	FreeForm:{
        		Items:[
            	       {'@id':'aac044','@leftText':'证件号码'}
            	       ,{'@id':'personName','@leftText':'人员名称'}
            	       ,{'@id':'ake007','@leftText':'就诊日期','@dataType':'date','@editmask':'YYYY年MM月DD日','@defaultValue':'=now()'}
            	       ,{'@id':'aka130','@leftText':'就诊类别','@defaultValue':'B24',DropList:{DropListId:'DropList_ak130',type:'DropList',datadic:'aka130'}}
            	       ,{'@id':'aaa138','@leftText':'一般诊疗费标志','@defaultValue':'B03',DropList:{DropListId:'DropList_aaa138',type:'DropList',datadic:'aaa138'}}
            	       ,{'@id':'ckc803','@leftText':'产前检查标志','@defaultValue':'0',DropList:{DropListId:'DropList_ckc803',type:'DropList',datadic:'ckc803'}}
            	       ,{'@id':'settleTypeFlag','@leftText':'付费形式','@defaultValue':'0',DropList:{DropListId:'DropList_SETTLE_TYPE',type:'DropList',datadic:'SETTLE_TYPE'}}
            	       ,{'@id':'yzz016','@leftText':'转诊备案号','@visible':false}
            	       ,{'@id':'aac005','@leftText':'联系电话'}
            	       ,{'@id':'cab053','@leftText':'手机'}
            	       ,{'@id':'aae013','@leftText':'备注','@visible':false}
            	       ,{'@id':'akc220','@leftText':'处方号','@visible':false}
            	       ,{'@id':'akc050','@leftText':'入院疾病诊断'}
            	       ,{'@id':'jbrmc','@leftText':'经办人','@defaultValue':_global_merchant.merchantName}
            	       ,{'@id':'hisBillState','@leftText':'状态','@editAble':false,DropList:{DropListId:'DropList_HIS_BILL_STATE',type:'DropList',datadic:'HIS_BILL_STATE'}}
            	       ,{'@id':'akc264','@leftText':'医疗费用总额','@editAble':false}
            	       ,{'@id':'merchantName','@leftText':'商家名称','@editAble':false,'@defaultValue':_global_merchant?'':(_global_merchant.merchantName||'')}
            	       ,{'@id':'aaz217','@leftText':'就诊记录号','@editAble':false}
            	       ,{'@id':'ykc675','@leftText':'结算类型','@editAble':false,'@defaultValue':'B01',DropList:{DropListId:'DropList_ykc675',type:'DropList',datadic:'ykc675'}}
            	       ,{'@id':'ykc618','@leftText':'结算业务号','@editAble':false}
            	       ,{'@id':'ckz543','@leftText':'ckz543','@visible':false}
            	       ,{'@id':'aae011','@leftText':'aae011','@visible':false}
            	       ,{'@id':'sessionid','@leftText':'sessionid','@visible':false}
            	       ,{'@id':'jmc','@leftText':'加密串','@visible':false}
            	       ,{'@id':'id','@leftText':'id','@visible':false}
            	       ,{'@id':'version','@leftText':'version','@visible':false}
            	       ,{'@id':'merchantId','@leftText':'merchantId','@visible':false,'@editAble':false,'@defaultValue':_global_merchant?(_global_merchant.merchantId||''):''}
            	       ,{'@id':'akc090','@leftText':'住院次数','@dataType':'int','@visible':false}
            	       ,{'@id':'aab014','@leftText':'医护人员公民身份证','@visible':false}
            	       ,{'@id':'akc190','@leftText':'门诊号','@visible':false}
            	       ,{'@id':'ckz564','@leftText':'生育备案审批号','@visible':false}
            	       ,{'@id':'aac057','@leftText':'离退休证号','@visible':false}
            	       ,{'@id':'fdelFlag','@leftText':'fdelFlag','@visible':false}
            	       ,{'@id':'xybOrderNo','@leftText':'乡银保账单号','@editAble':false}
            	       ,{'@id':'selfPay','@leftText':'自费金额','@editAble':false}
            	]
        	}
        }
    }        
);