/**
 * v1.2.2 2012-05-07 author: Mac_J, �ġ�����
 */
Ext
		.define(
				'Ext.view.GridComboBoxList',
				{
					extend : 'Ext.view.AbstractView',
					alias : 'widget.gridcombolist',
					alternateClassName : 'Ext.GridComboBoxList',
					// 2012-05-07 Ext4.1�µ�Bug�Ľ��
					renderTpl : [ '<div class="list-ct" style="border: 1px solid #99BBE8"></div>' ],
					// renderTpl : [ '<div class="list-ct" style="border: 1px
					// solid #99BBE8"></div>' ],
					initComponent : function() {
						var me = this;
						// 2012-05-07 Ext4.1�µ�Bug�Ľ��
						me.itemSelector = "div.list-ct";
						// me.itemSelector = ".";
						me.tpl = Ext.create('Ext.XTemplate');
						me.callParent();
						Ext.applyIf(me.renderSelectors, {
							listEl : '.list-ct'
						});
						me.gridCfg.border = false;
						me.gridCfg.store = me.store;
						me.grid = Ext.create('Ext.grid.Panel', me.gridCfg);
						me.grid.store.addListener({
							beforeload : function() {
								me.owner.loading = true;
							},
							load : function() {
								me.owner.loading = false;
							}
						});
						var sm = me.grid.getSelectionModel();
						sm.addListener('selectionchange', function(a, sl) {

							var cbx = me.owner;
							if (cbx.loading)
								return;
							var sv = cbx.multiSelect ? cbx.getValue() : {};
							// sv = {}
							var EA = Ext.Array, vf = cbx.valueField;
							// al = [ 'G', 'Y', 'B' ]
							var al = EA.map(me.grid.store.data.items, function(
									r) {
								return r.data[vf];
							});
							var cs = EA.map(sl, function(r) {
								var d = r.data;
								if (d) {
									var k = d[vf];
									sv[k] = d;
									return k;
								}
							});
							// cs = [ 'G' ]
							var rl = EA.difference(al, cs);
							EA.each(rl, function(r) {
								delete sv[r];
							});
							cbx.setValue(sv);
						});
						sm.addListener('select', function(m, r, i) {

							var cbx = me.owner;
							var objid = cbx.id;
							// 扩展方法selectComboGridRecord，将选择的记录和当前控件的ID传入，做其它业务处理
							// 由hubo添加于2012-10-16
							try {
								selectComboGridRecord(r, objid);
							} catch (e) {
							}
							if (cbx.loading)
								return;
							if (!cbx.multiSelect)
								cbx.collapse();
						});
					},
					onRender : function() {
						this.callParent(arguments);
						this.grid.render(this.listEl);
					},
					bindStore : function(store, initial) {
						this.callParent(arguments);
						if (this.grid)
							this.grid.bindStore(store, initial);
					},
					onDestroy : function() {
						Ext.destroyMembers(this, 'grid', 'listEl');
						this.callParent();
					}
				});