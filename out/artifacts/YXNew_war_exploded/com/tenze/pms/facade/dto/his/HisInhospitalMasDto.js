_fillInDataModel(
        'com.tenze.pms.facade.dto.his.HisInhospitalMasDto',
        {
            table:Ext_UiTable({
                beanId:'hisInhospitalMasId',
                beanName:'hisInhospitalMasName',
                formLayout:'hbox',
                hboxColumnCount:2
            })
            ,
            fields:[
                 Ext_UiField({type:'string',name:'id',text:'',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'version',text:'',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'createtime',text:'',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'updatetime',text:'',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'fdelFlag',text:'',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'hisBillState',text:'状态',xtype:'textfield',width:120,datadic:'HIS_BILL_STATE_RY',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aac044',text:'证件号码',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'personName',text:'人员名称',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ykc701',text:'入院日期',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aae005',text:'联系电话',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aka130',text:'就诊类别',xtype:'textfield',datadic:'aka130',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akc050',text:'入院诊断',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'inHospType',text:'入院方式',datadic:'IN_HOSP_TYPE',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akc190',text:'住院号',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akc090',text:'住院次数',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akf001',text:'入院科室',datadic:'akf001',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ykc012',text:'入院床位',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aaz217',text:'就诊记录号',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akc193',text:'ICD10_1',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ykc601',text:'ICD10_2',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ykc602',text:'ICD10_3',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckz564',text:'生育备案审批号',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aac057',text:'离退休证号',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'yzz016',text:'转诊备案号',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc798',text:'意外伤害标志',datadic:'ckc798',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc949',text:'二次返院传入标志',datadic:'ckc949',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aae013',text:'备注',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aab014',text:'医护人员公民身份号码',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc936',text:'医疗个人结算类型',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc937',text:'单病种诊断',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'merchantId',text:'',xtype:'hidden',hidden:true,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'merchantName',text:'医院',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'jbrmc',text:'经办人',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                
            ]
        
        ,Supcan:{
        	FreeForm:{
        		Items:[
            	       {'@id':'aac044','@leftText':'证件号码'}
            	       ,{'@id':'personName','@leftText':'人员名称'}
            	       ,{'@id':'ykc701','@leftText':'入院日期','@dataType':'date','@editmask':'YYYY年MM月DD日','@defaultValue':'=now()'}
            	       ,{'@id':'aka130','@leftText':'就诊类别','@defaultValue':'B12',DropList:{DropListId:'DropList_aka130',type:'DropList',datadic:'aka130'}}
            	       ,{'@id':'ckc936','@leftText':'医疗个人结算类型','@defaultValue':'',DropList:{DropListId:'DropList_ckc936',type:'DropList',datadic:'ckc936'}}
            	       ,{'@id':'ckc937','@leftText':'单病种诊断','@defaultValue':'',DropList:{DropListId:'DropList_ckc937',type:'DropList',datadic:'ckc937'}}
                       ,{'@id':'akf001','@leftText':'入院科室','@defaultValue':'B01',DropList:{DropListId:'DropList_akf001',type:'DropList',datadic:'akf001'}}
            	       ,{'@id':'ykc012','@leftText':'入院床位',DropList:{DropListId:'DropList_bedName',type:'EditAbleDropTreeList',DataCol:'bedName',DisplayCol:'bedName'}}
            	       ,{'@id':'akc050','@leftText':'入院诊断'}
            	       ,{'@id':'akc190','@leftText':'住院号'}
            	       ,{'@id':'inHospType','@leftText':'入院方式','@defaultValue':'B01',DropList:{DropListId:'DropList_IN_HOSP_TYPE',type:'DropList',datadic:'IN_HOSP_TYPE'}}
            	       ,{'@id':'akc090','@leftText':'住院次数','@dataType':'int','@defaultValue':'1'}
            	       ,{'@id':'aae005','@leftText':'联系电话'}
            	       ,{'@id':'cab053','@leftText':'手机'}
            	       ,{'@id':'aae013','@leftText':'备注'}
            	       ,{'@id':'ckc798','@leftText':'意外伤害标志','@defaultValue':'B02',DropList:{DropListId:'DropList_ckc798',type:'DropList',datadic:'ckc798'}}
            	       ,{'@id':'ckc949','@leftText':'二次返院传入标志','@defaultValue':'B02',DropList:{DropListId:'DropList_ckc949',type:'DropList',datadic:'ckc949'}}
            	       ,{'@id':'yzz016','@leftText':'转诊备案号'}
            	       ,{'@id':'aab014','@leftText':'医护人员公民身份证'}
            	       ,{'@id':'ckz564','@leftText':'生育备案审批号'}
            	       ,{'@id':'aac057','@leftText':'离退休证号'}
            	       ,{'@id':'yka115','@leftText':'本次已付起付线','@editAble':false}
            	       ,{'@id':'jbrmc','@leftText':'经办人','@defaultValue':_global_merchant.merchantName}
            	       ,{'@id':'hisBillState','@leftText':'状态','@defaultValue':'0','@editAble':false,DropList:{DropListId:'DropList_HIS_BILL_STATE',type:'DropList',datadic:'HIS_BILL_STATE_RY'}}
            	       ,{'@id':'merchantName','@leftText':'商家名称','@editAble':false,'@defaultValue':_global_merchant?'':(_global_merchant.merchantName||'')}
            	       ,{'@id':'aaz217','@leftText':'就诊记录号','@editAble':false}
            	       ,{'@id':'akc264','@leftText':'医疗费用总额','@editAble':false}
            	       ,{'@id':'ykc675','@leftText':'结算类型','@editAble':false,'@defaultValue':'B01',DropList:{DropListId:'DropList_ykc675',type:'DropList',datadic:'ykc675'}}
            	       ,{'@id':'ykc618','@leftText':'结算业务号','@editAble':false}
            	       ,{'@id':'ckz543','@leftText':'ckz543','@visible':false}
            	       ,{'@id':'aae011','@leftText':'aae011','@visible':false}
            	       ,{'@id':'sessionid','@leftText':'sessionid','@visible':false}
            	       ,{'@id':'id','@leftText':'id','@visible':false}
            	       ,{'@id':'version','@leftText':'version','@visible':false}
            	       ,{'@id':'merchantId','@leftText':'merchantId','@visible':false,'@editAble':false,'@defaultValue':_global_merchant?(_global_merchant.merchantId||''):''}
            	       ,{'@id':'fdelFlag','@leftText':'fdelFlag','@visible':false}
            	]
        	}
        }
    }        
);