function toggleBtnBG(obj, flag) {
	if (flag) {
		var src = $(obj).attr("src");
		if (src != "") {
			src = src.substring(0, src.lastIndexOf(".")) + "_2.png";
			$(obj).attr("src", src);
		}
	} else {
		var src = $(obj).attr("src");
		if (src != "") {
			src = src.substring(0, src.lastIndexOf(".") - 2) + ".png";
			$(obj).attr("src", src);
		}
	}
}