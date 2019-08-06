_fillInDataModel(
        'com.tenze.pms.facade.dto.his.HisSettleQueryDto',
        {
            table:Ext_UiTable({
                beanId:'hisHisSettleQueryId',
                beanName:'hisHisSettleQueryName',
                formLayout:'hbox',
                hboxColumnCount:4
            })
            ,
            fields:[
                 Ext_UiField({type:'string',name:'aac003',text:'姓名',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aac044',text:'证件号码',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aac001',text:'医保号码',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aac004',text:'性别',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aac006',text:'出生日期',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aac027',text:'人员类别',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aab004',text:'单位名称',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aae004',text:'患者联系人',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aae005',text:'患者联系电话',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aaz217',text:'就诊记录号',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aka130',text:'就诊类别',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckb519',text:'医院名称',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aka101',text:'医疗机构登记',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akc050',text:'入院疾病诊断名称',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ykc701',text:'入院日期',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ack185',text:'出院疾病诊断名称',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ykc702',text:'出院日期',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ykc618',text:'结算业务号',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ykc675',text:'结算类型',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aae040',text:'结算时间',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akc264',text:'医疗费总额',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akc253',text:'本次就诊政策范围外个人自费金额',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akc254',text:'本次就诊政策范围内个人自费金额',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'yka319',text:'允许报销部分',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ykc624',text:'个人自付金额',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aka151',text:'本次就诊基本医疗保险统筹基金起付标准额',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akb066',text:'个人账户支付金额合计',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ykc631',text:'超报销限额自付金额',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akb068',text:'统筹支付金额合计',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ake039',text:'基本医疗保险统筹基金支付金额',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ykc627',text:'基本医疗统筹自付部分',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc504',text:'补充医疗统筹支付',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc688',text:'补充医疗分段自付',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc573',text:'本年统筹基金可用金额',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akc630',text:'大病医疗统筹支付部分',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ykc666',text:'自费原因',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'yka430',text:'统筹累计已支付',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'yka341',text:'补充医疗累计已支付',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akb063',text:'住院天数',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'yka402',text:'共付段个人支付',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aae185',text:'基本医疗报销比例',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'cka584',text:'补充医疗报销比例',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc802',text:'年度最高支付限额',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc573',text:'本年统筹基金可用金额',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 //Ext_UiField({type:'string',name:'akc254',text:'本次就诊政策范围内个人自付金额',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'cke995',text:'特需服务费',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'bhe434',text:'居住地址',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}), 
                 Ext_UiField({type:'string',name:'aab999',text:'单位编码',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'akc190',text:'住院号(门诊号)',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'bae001',text:'社保机构',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc518',text:'本年医保大病保险金额',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc553',text:'本年累计起付金额',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'cke996',text:'本年累计个人自付比例部分金额',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc938',text:'民政补助金额',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc939',text:'民政自付段金额',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc940',text:'预留报销金额1',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc941',text:'预留自付金额1',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc942',text:'预留报销金额2',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc943',text:'预留自付金额2',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc944',text:'预留报销金额3',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc945',text:'预留自付金额3',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ckc946',text:'民政报销比例拼串',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'ryjbrmc',text:'入院经办人',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'jsjbrmc',text:'结算经办人',xtype:'textfield',hidden:false,allowBlank:true,queryFlag:true}),
                 Ext_UiField({type:'string',name:'aae013',text:'备注',xtype:'textareafield',hidden:false,allowBlank:true,queryFlag:true}),
            ]
    }        
);

