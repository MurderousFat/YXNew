function Dsy(){
	this.Items = {};
};
Dsy.prototype.add = function(id,iArray){
	this.Items[id] = iArray;
};
Dsy.prototype.Exists = function(id){
	if(typeof(this.Items[id]) == "undefined") return false;
	return true;
};
var dsy = new Dsy();

var sss = localStorage.getItem("tempdata");//取回students变量
    if (sss == null || sss == undefined || sss == '') {
        var tempdata="";
        var url="/getBiRegion.tz";
        $.ajaxSettings.async = false;
        jQuery.getJSON(url,function(data){
            tempdata = JSON.stringify(data);
            localStorage.setItem("tempdata",tempdata);
            for(var key in data){
                // console.log("属性：" + key + ",值：" + data[key]);
                var json = eval('(' + data[key] + ')');
                dsy.add(key,json);
            }
        });
    }else {
        sss = JSON.parse(sss);
        for(var key in sss){
            var json = eval('(' + sss[key] + ')');
            dsy.add(key,json);
        }
    }




// dsy.add("0",["北京市","天津市","上海市","重庆市","河北省","山西省","内蒙古","辽宁省","吉林省","黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","广西","海南省","四川省","贵州省","云南省","西藏","陕西省","甘肃省","青海省","宁夏","新疆","香港","澳门","台湾省"]);