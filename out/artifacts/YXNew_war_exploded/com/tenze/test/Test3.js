_fillInDataModel(
		'com.tenze.test.Test3',
		{
			table:Ext_UiTable({
				beanId:'testBeanId',
				beanName:'testBeanName',
				formLayout:'hbox',
				hboxColumnCount:3
			})
			,
			fields:[
			     Ext_UiField({name:'fid',type:'string'}),
			     Ext_UiField({name:'fname',type:'string'}),
			     Ext_UiField({name:'fage',type:'string'}),
			]
	}		
);
