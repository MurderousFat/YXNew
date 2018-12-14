<#import "/include/CommonTagMacro.ftl" as CommonMacro>
<@CommonMacro.page title="">
<script type="text/javascript">

Ext.onReady(function() {
	Ext.MessageBox.show({
           title: '<@s.text name="Sorry" />',
           msg: '<@s.text name="Login.timeout" />',
           buttons: Ext.MessageBox.OK,
           fn:function(){
           		window.parent.location="/loginInit.js";
           },
           icon: 'x-message-box-error'
       }); 
});
</script>
</@CommonMacro.page>
