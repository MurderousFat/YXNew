//*****************************************上传的公共js***************************************************************//   


//...上传后填充控件的id   

var uploadid = "";

var formpanel = Ext.create("Ext.form.FormPanel", {
    title: '医疗执业资格上传（<font color="red">文件最大</font>)',
    width: '95%',
    height: '95%',
    layout: "form",
    bodyPadding: "5",
    defaultType: "textfield",
    fieldDefaults: {labelAlign: "left", labelWidth: 55},
    items: [
        {
            id: 'File',
            name: 'File',
            inputType: "file",
            fieldLabel: '上传图片',
            xtype: 'textfield',
            anchor: '40%',
            allowBlank: false,
            listeners: {//监听事件
                'render': function () {//读取
                    console.log('读取照片');
                    var path = Ext.getCmp('File').getValue()
                    var url = 'file:///' + path;
                    console.log(url);//浏览器安全保护下的虚拟路径
                    Ext.getCmp('File').on('change', function (field, newValue, oldValue) {//上传图片的控件对象,刚刚选择的图片仿真路径，上次选择的图片仿真路径
                        console.log(newValue);
                        console.log('浏览器类型：是ie？' + Ext.isIE);
                        var show = Ext.getCmp('browseImage');
                        console.log(show);
                        if (Ext.isIE) {

                        } else {//获取选择文件的路径信息？ 将路径绑定到显示图片的box内加载
                            var obj = Ext.getCmp('File').inputEl.dom.files;
                            console.log(len);
                            var len = obj.length;//选文件的数量
                            if (len < 1) {
                                console.log('没有选择图片');
                                return;
                            }

                            var imgurl = window.URL.createObjectURL(obj[0]);
                            console.log(imgurl)
                            Ext.getCmp('browseImage').getEl().dom.src = imgurl;

                        }
                    }, this);//这是选择文件
                }
            }
        },
        {
            xtype: 'box', //或者xtype: 'component',
            width: '100%', //图片宽度
            height: 200, //图片高度
            fieldLabel: "预览图片",
            id: 'browseImage',
            autoEl: {
                tag: 'img',    //指定为img标签
                //src: 'ftp://127.0.0.1/UserFile/UserData/20160320/hotel_hotel_20160820220330.jpg',  //Ext.BLANK_IMAGE_URL,//指定url路径
                src: Ext.BLANK_IMAGE_URL,
                id: 'imageBrowse'
            }
        }
    ],
    buttons: [
        {
            text: "上传",
            handler: function () {
                var formCmp = this.up("form");
                // if (!formCmp.isValid()) return;    //验证未通过，返回
                var photoName = Ext.getCmp('File').getValue();
                console.log(photoName);
                formCmp.submit({
                    url: '/Upload.tz',
                    method: "POST",
                    waitMsg: '正在上传...',
                    params: {
                        photoName: photoName
                    },
                    success: function (form, action, ret) {
                        var value = action.result.msg;
                        Ext.getCmp(uploadid).setValue(value);
                        Ext.Msg.alert('成功', '上传成功.');
                        win.hide();
                    },
                    failure: function (form, action, ret) {
                        console.log('submit认为请求失败，可是操作成功了');
                        console.log(form);
                        console.log(action);
                        console.log(ret);
                        switch (action.failureType) {
                            case Ext.form.action.Action.CLIENT_INVALID:
                                Ext.Msg.alert('失败1', 'Form fields may not be submitted with invalid values');
                                break;
                            case Ext.form.action.Action.CONNECT_FAILURE:
                                Ext.Msg.alert('失败2', 'Ajax communication failed');
                                break;
                            case Ext.form.action.Action.SERVER_INVALID:
                                Ext.Msg.alert('失败3', action.result.message);
                        }
                    }
                });
            }
        },
        {
            text: '关闭',
            handler: function () {
                win.hide();

            }
        },
        {
            text: '查看原图',
            handler: function () {
                var name=Ext.getCmp(uploadid).getValue().trim();
                if (name.length>0) {
                    window.open("/Image?name=" + Ext.getCmp(uploadid).getValue());
                }else {
                    alert("文件未上传");
                }
            }
        }
    ]
});

//窗体
var win = new Ext.Window({
    title: '上传文件窗口',
    width: 476,
    height: 374,
    x: 100,
    y: document.documentElement.clientWidth / 10,
    resizable: true,
    draggable: true,
    closeAction: 'close',
    plain: true,
    border: false,
    closeAction: 'hide',
    custormServiceAimObjectId: '',//这是给哪个对象进行文件上传操作（如哪家酒店ID）
    custormFileType: ''//自定义属性，指向文件的类型
});

//html页面种通过调用这个函数显示上传窗体
function btnUpload_click(maxFileSize, winTitle, fileCategory, custormServiceAimObjectId) {//其他窗体需要进行上传文件只需要调用这个函数就可以
    console.log('调用js脚本的函数进行窗体');
    win.setTitle(winTitle);
    win.custormFileType = fileCategory;
    console.log(custormServiceAimObjectId);
    win.custormServiceAimObjectId = custormServiceAimObjectId;
    uploadid = custormServiceAimObjectId;
    win.items.removeAll();//移除之前全部的items
    var limitFileMB = maxFileSize == null ? '10MB' : maxFileSize;
    formpanel.setTitle('医疗执业资格上传（<font color="red">文件最大' + limitFileMB + '</font>)');
    win.items.add(formpanel);
    win.doLayout();
    win.show();
    var img = Ext.getCmp("hisCert").getValue();
    if (img != null | img != "" | img != undefined | img.length != 0) {
        document.getElementById('browseImage').src = "/Image?name=" + img;
    } else {
        document.getElementById('browseImage').src = "";
    }

}


var formpane2 = Ext.create("Ext.form.FormPanel", {
    title: '小微商户收款图上传（<font color="red">文件最大</font>)',
    width: '95%',
    height: '95%',
    layout: "form",
    bodyPadding: "5",
    defaultType: "textfield",
    fieldDefaults: {labelAlign: "left", labelWidth: 55},
    items: [
        {
            id: 'File2',
            name: 'File',
            inputType: "file",
            fieldLabel: '上传图片',
            xtype: 'textfield',
            anchor: '40%',
            allowBlank: false,
            listeners: {//监听事件
                'render': function () {//读取
                    console.log('读取照片');
                    var path = Ext.getCmp('File2').getValue()
                    var url = 'file:///' + path;
                    console.log(url);//浏览器安全保护下的虚拟路径
                    Ext.getCmp('File2').on('change', function (field, newValue, oldValue) {//上传图片的控件对象,刚刚选择的图片仿真路径，上次选择的图片仿真路径
                        console.log(newValue);
                        console.log('浏览器类型：是ie？' + Ext.isIE);
                        var show = Ext.getCmp('browseImage2');
                        console.log(show);
                        if (Ext.isIE) {

                        } else {//获取选择文件的路径信息？ 将路径绑定到显示图片的box内加载
                            var obj = Ext.getCmp('File2').inputEl.dom.files;
                            console.log(len);
                            var len = obj.length;//选文件的数量
                            if (len < 1) {
                                console.log('没有选择图片');
                                return;
                            }

                            var imgurl = window.URL.createObjectURL(obj[0]);
                            console.log(imgurl)
                            Ext.getCmp('browseImage2').getEl().dom.src = imgurl;

                        }
                    }, this);//这是选择文件
                }
            }
        },
        {
            xtype: 'box', //或者xtype: 'component',
            width: '100%', //图片宽度
            height: 200, //图片高度
            fieldLabel: "预览图片",
            id: 'browseImage2',
            autoEl: {
                tag: 'img',    //指定为img标签
                //src: 'ftp://127.0.0.1/UserFile/UserData/20160320/hotel_hotel_20160820220330.jpg',  //Ext.BLANK_IMAGE_URL,//指定url路径
                src: Ext.BLANK_IMAGE_URL,
                id: 'imageBrowse2'
            }
        }
    ],
    buttons: [
        {
            text: "上传",
            handler: function () {
                var formCmp = this.up("form");
                // if (!formCmp.isValid()) return;    //验证未通过，返回
                var photoName = Ext.getCmp('File2').getValue();
                console.log(photoName);
                formCmp.submit({
                    url: '/Upload.tz',
                    method: "POST",
                    waitMsg: '正在上传...',
                    params: {
                        photoName: photoName
                    },
                    success: function (form, action, ret) {
                        var value = action.result.msg;
                        Ext.getCmp(uploadid).setValue(value);
                        Ext.Msg.alert('成功', '上传成功.');
                        win2.hide();
                    },
                    failure: function (form, action, ret) {
                        console.log('submit认为请求失败，可是操作成功了');
                        console.log(form);
                        console.log(action);
                        console.log(ret);
                        switch (action.failureType) {
                            case Ext.form.action.Action.CLIENT_INVALID:
                                Ext.Msg.alert('失败1', 'Form fields may not be submitted with invalid values');
                                break;
                            case Ext.form.action.Action.CONNECT_FAILURE:
                                Ext.Msg.alert('失败2', 'Ajax communication failed');
                                break;
                            case Ext.form.action.Action.SERVER_INVALID:
                                Ext.Msg.alert('失败3', action.result.message);
                        }
                    }
                });
            }
        }, {
            text: '关闭',
            handler: function () {
                win2.hide();
            }
        },{
            text: '查看原图',
            handler: function () {
                var name=Ext.getCmp(uploadid).getValue().trim()
                if (name.length>0) {
                    window.open("/Image?name=" + Ext.getCmp(uploadid).getValue());
                }else {
                    alert("文件未上传");
                }
            }
        }
    ]
});
//窗体
var win2 = new Ext.Window({
    title: '上传文件窗口',
    width: 476,
    height: 374,
    x: 100,
    y: document.documentElement.clientWidth / 10,
    resizable: true,
    draggable: true,
    closeAction: 'close',
    plain: true,
    border: false,
    closeAction: 'hide',
    custormServiceAimObjectId: '',//这是给哪个对象进行文件上传操作（如哪家酒店ID）
    custormFileType: ''//自定义属性，指向文件的类型
});

//html页面种通过调用这个函数显示上传窗体
function btnUpload_click2(maxFileSize, winTitle, fileCategory, custormServiceAimObjectId) {//其他窗体需要进行上传文件只需要调用这个函数就可以
    console.log('调用js脚本的函数进行窗体');
    win2.setTitle(winTitle);
    win2.custormFileType = fileCategory;
    console.log(custormServiceAimObjectId);
    win2.custormServiceAimObjectId = custormServiceAimObjectId;
    uploadid = custormServiceAimObjectId;
    win2.items.removeAll();//移除之前全部的items
    var limitFileMB = maxFileSize == null ? '10MB' : maxFileSize;
    formpane2.setTitle('小微商户收款图上传（<font color="red">文件最大' + limitFileMB + '</font>)');
    win2.items.add(formpane2);
    win2.doLayout();
    win2.show();
    var img = Ext.getCmp("isminimerchantCodePri").getValue();
    if (img != null | img != "" | img != undefined | img.length != 0) {
        document.getElementById('browseImage2').src = "/Image?name=" + img;
    } else {
        document.getElementById('browseImage2').src = "";
    }

}


//*****************************************上传的公共js***************************************************************//