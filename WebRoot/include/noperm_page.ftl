<#import "/include/CommonTagMacro.ftl" as CommonMacro>
<@CommonMacro.page title="">
<script type="text/javascript">
Ext.onReady(function() {
	Ext.MessageBox.show({
           title: '<@s.text name="Sorry" />',
           msg: '<@s.text name="NopermForAccess" />',
           buttons: Ext.MessageBox.OK,
           icon: 'x-message-box-error'
       }); 
});
</script>
</@CommonMacro.page>
