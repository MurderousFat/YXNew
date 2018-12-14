package com.tenze.pms.service.impl.his;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tenze.common.utils.LoginInfo;
import com.tenze.pms.action.his.LoginEnum;
import com.tenze.pms.action.his.WebserviceConst;
import com.tenze.pms.facade.dto.his.HisConfigDto;
import com.tenze.pms.facade.service.his.HisConfigService;
import com.tenze.pms.facade.service.his.HisService;
import com.tenze.utils.PropUtil;
import com.tenze.ws.utils.HttpClientCallSoapUtil;
import com.tenze.ws.utils.Xml2JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("hisService")
public class HisServiceImpl implements HisService {
	
	@Autowired
	private HisConfigService hisConfigService;

	public boolean doLogin(String ckz543,String vid){
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("fkey", ckz543);  
		params.put("id", vid);


		HisConfigDto list = hisConfigService.getBy(params);
		if(list==null ){
			return false;
		}
		HisConfigDto hisConfig = list;
		String xml = WebserviceConst.LOGIN_SOAP_XML//
				.replace("#INTERFACE_ID#", WebserviceConst.LONGIN)//
				.replace("#HIS_ID#", ckz543)//
				.replace("#OPERID#", hisConfig.getFusername())//
				.replace("#PASSWORD#", hisConfig.getFpassword())//
				;
		
		String yxSocialIp = PropUtil.getValue("YX_SOCIAL_IP");
		String yxSocialPort = PropUtil.getValue("YX_SOCIAL_PORT");
		yxSocialIp = yxSocialIp.trim() + ":" + yxSocialPort.trim() ;	// "+yxSocialIp+"
		
		String result = HttpClientCallSoapUtil.doPostSoap1_1("http://"+yxSocialIp+"/facadeServiceProxy", xml, "");
		if(result==null || result.trim().length()==0 || result.contains("<error>")) return false;
		result = result.substring(result.indexOf("<return>")+"<return>".length(),result.indexOf("</return>"));
		result = result.replace("&gt;", ">").replace("&lt;", "<");
		JSONObject s = JSON.parseObject(Xml2JsonUtil.xml2JSON(result)).getJSONObject("result");
		if("1".equals(s.getString("code"))){
			
			System.out.println(" HisServiceLogin: ckz543 : " + ckz543 );
			
			JSONObject output = s.getJSONObject("output");
			String userId = output.getString("aae011");
			String sessionId = output.getString("sessionid");
			LoginEnum.INSTANCE.putUserId(ckz543, output.getString("aae011"));
			LoginEnum.INSTANCE.putSessionId(ckz543,  output.getString("sessionid"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String slot = ckz543+sdf.format(new Date());
			if(StringUtils.isEmpty(LoginEnum.INSTANCE.getHisKey(slot))){
				this.findKey(ckz543, userId, sessionId);
			} 
			
			//if ( !ckz543.equals("") && (ckz543 != null) ) {
				LoginInfo.loginUserId = ckz543 ; 
				LoginInfo.loginSession = sessionId ;
				LoginInfo.loginHisId = vid ;
				LoginInfo.loginHisAae011 = userId ;
			//}
			
			return true;
		} else { 
				LoginInfo.loginUserId = "" ; 
				LoginInfo.loginSession = "" ;
				LoginInfo.loginHisId = "0" ;
				
				return false ;
		}
		
	}
	
	public boolean findKey(String ckz543, String aae011, String sessionid){
		StringBuilder input = new StringBuilder();
		input.append("<input>");
		input.append("<sessionid>").append(sessionid).append("</sessionid>");
		input.append("<ckz543>").append(ckz543).append("</ckz543>");
		input.append("<aae011>").append(aae011).append("</aae011>");
		input.append("</input>");
		String xml = WebserviceConst.SOAP_XML.replace("#INTERFACE_ID#", "102").replace("#XML_CONTENT#",input.toString());

		
		String yxSocialIp = PropUtil.getValue("YX_SOCIAL_IP");
		String yxSocialPort = PropUtil.getValue("YX_SOCIAL_PORT");
		yxSocialIp = yxSocialIp + ":" + yxSocialPort ;	// "+yxSocialIp+"
		
		
		String result = HttpClientCallSoapUtil.doPostSoap1_1("http://"+yxSocialIp+"/facadeServiceProxy", xml, "");
		if(result==null || result.trim().length()==0 || result.contains("<error>")) return false;
		result = result.substring(result.indexOf("<return>")+"<return>".length(),result.indexOf("</return>"));
		result = result.replace("&gt;", ">").replace("&lt;", "<");
		JSONObject s = JSON.parseObject(Xml2JsonUtil.xml2JSON(result)).getJSONObject("result");
		if("1".equals(s.getString("code"))){
			JSONObject output = s.getJSONObject("output");
			String my = output.getString("my");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			LoginEnum.INSTANCE.putHisKey(ckz543+sdf.format(new Date()), my);
			return true;
		}
		return true;
	}
	
	public String doprocess(String interfaceId, String input){
		String xml = WebserviceConst.SOAP_XML//
				.replace("#INTERFACE_ID#",interfaceId)//
				.replace("#XML_CONTENT#", input)//
				;
		
		String yxSocialIp = PropUtil.getValue("YX_SOCIAL_IP");
		String yxSocialPort = PropUtil.getValue("YX_SOCIAL_PORT");
		yxSocialIp = yxSocialIp + ":" + yxSocialPort ;	// 
		
		String result = HttpClientCallSoapUtil.doPostSoap1_1("http://"+yxSocialIp+"/facadeServiceProxy", xml, "");
		result = result.substring(result.indexOf("<return>")+"<return>".length(),result.indexOf("</return>"));
		result = HtmlUtils.htmlUnescape(result);
		return result;
	}
}
