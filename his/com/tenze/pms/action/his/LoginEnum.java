package com.tenze.pms.action.his;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tenze.pms.action.his.bean.LoginBean;
import com.tenze.utils.PropUtil;
import com.tenze.ws.utils.HttpClientCallSoapUtil;
import com.tenze.ws.utils.JaxbUtil;
import com.tenze.ws.utils.Xml2JsonUtil;

public enum LoginEnum {

	INSTANCE;
	
	private Map<String,String> sessionMap = new HashMap<String,String>();
	private Map<String,String> userid = new HashMap<String,String>();
	private Map<String,String> keyMap = new HashMap<String,String>();
	
	public void putSessionId(String key , String sessionId){
		this.sessionMap.put(key, sessionId);
	}
	
	public String getSessionId(String key){
		return this.sessionMap.get(key);
	}
	
	public String getUserId(String key){
		return this.userid.get(key);
	}
	
	public void putUserId(String key, String userId){
		this.userid.put(key, userId);
	}
	
	public void putHisKey(String slot, String key){
		this.keyMap.put(slot, key);
	}
	
	public String getHisKey(String slot){
		return this.keyMap.get(slot);
	}
	
	public boolean doLogin(String key){
		
		if(this.sessionMap.get(key)==null){
			String xml = WebserviceConst.LOGIN_SOAP_XML//
					.replace("#INTERFACE_ID#", WebserviceConst.LONGIN)//
					.replace("#HIS_ID#", "950002")//
					.replace("#OPERID#", "胡燕玲")//
					.replace("#PASSWORD#", "8888")//
					;

			String yxSocialIp = PropUtil.getValue("YX_SOCIAL_IP");
			String yxSocialPort = PropUtil.getValue("YX_SOCIAL_PORT");
			yxSocialIp = yxSocialIp + ":" + yxSocialPort ;	// "+yxSocialIp+"
			
			HttpClientCallSoapUtil.doPostSoap1_1("http://"+yxSocialIp+"/facadeServiceProxy", xml, "");
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		LoginBean bean = new LoginBean();
		bean.setCkz543("950002");
		bean.setOperid("胡燕玲");
		bean.setPassword("8888");
		String xml = JaxbUtil.convertToXml(bean);
		System.out.println(xml);
		LoginBean _b = JaxbUtil.converyToJavaBean(xml, LoginBean.class);
		String ckz543 = "950002";
		System.out.println(_b.getCkz543());
		String result = xml = "<result><code>1</code><message>登陆成功!</message><output><aae011>20001286</aae011><SESSIONID>HISID-8A8E957FCBD14C2F82A86C379A648D87</SESSIONID></output></result>";
		JSONObject s = JSON.parseObject(Xml2JsonUtil.xml2JSON(result)).getJSONObject("result");//parseText(Xml2JsonUtil.xml2JSON(result));
		if("1".equals(s.getString("code"))){
			JSONObject output = s.getJSONObject("output");
			LoginEnum.INSTANCE.putUserId(ckz543, output.getString("aae011"));
			LoginEnum.INSTANCE.putSessionId(ckz543,  output.getString("SESSIONID"));
			
			System.out.println(LoginEnum.INSTANCE.getUserId(ckz543));
			System.out.println(LoginEnum.INSTANCE.getSessionId(ckz543));
		}
	}
			
}
