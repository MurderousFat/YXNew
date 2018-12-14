package com.tenze.pms.action.mer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tenze.action.common.BaseAction;
import com.tenze.common.utils.Md5;
import com.tenze.utils.Dto;
import com.tenze.utils.JsonHelper;
import com.tenze.utils.PropUtil;
import com.tenze.utils.helper.WebUtils;

@Controller("MerMchntTradeAction")
@Scope(value="prototype")
public class MerMchntTradeAction extends BaseAction {
	
	public String mng(){
		return INPUT_RESULT;
	}
    
    public String query() throws IOException{
    	Dto param = this.getRequestDto();
    	String yxUrl = PropUtil.getValue("YX_IF_URL");
		String version = PropUtil.getValue("YX_VERSION");
		String appid = PropUtil.getValue("YX_APPID");
		String secret = PropUtil.getValue("YX_SCRET"); 
		String signmethod = PropUtil.getValue("YX_SIGNMETHOD");
		String timestamp = System.currentTimeMillis()+"";
		
		Map<String,String> params = new HashMap<String,String>();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		if(param.get("merIds")!=null){
			String[] tempMerids = String.valueOf(param.get("merIds")).split(",");
			Map<String,Object> merMap ;
			for (String merId : tempMerids) {
				merMap = new HashMap<String,Object>();
				merMap.put("merId", merId);
				list.add(merMap);
			}
		}
		
		List<Map<String,Object>> terList = new ArrayList<Map<String,Object>>();
		if(param.get("merIds")!=null){
			String[] tempTerIds = String.valueOf(param.get("terIds")).split(",");
			Map<String,Object> merMap ;
			for (String terId : tempTerIds) {
				merMap = new HashMap<String,Object>();
				merMap.put("terId", terId);
				terList.add(merMap);
			}
		}
		
		param.put("merIds", list);
		param.put("terIds", terList);
		String payload = JSON.toJSONString(param);
		String sign1 = Md5.MD5Encode(String.format("appid=%s,timestamp=%s,data=%s", appid,timestamp,payload));
		String sign2 = Md5.MD5Encode(String.format("secret=%s,timestamp=%s", secret,timestamp));
		String signature = sign1+sign2;
		
		
		params.put("version", version);
		
		params.put("timestamp", timestamp);
		params.put("appid", appid);
		params.put("data", payload);
		//params.put("secret", secret);

		params.put("signmethod", signmethod);
		params.put("signature", signature);
		params.put("version", version);
		String result = "{\"some\":\"other\"}";
		try {
			result = WebUtils.doPost(yxUrl+"/mer/acoma", params,30000,30000);
		} catch (IOException e) {
			e.printStackTrace();
			write(JsonHelper.toJSON(Collections.emptyList()));
		}
		JSONArray arr = JSONObject.parseObject(result).getJSONArray("data");
		write(arr.toJSONString());
		//return arr.size()>0?arr.getJSONObject(0):JSONObject.parseObject("{}");
    	
        return NULL_SUCCESS;
    }
    
}