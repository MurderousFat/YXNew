package com.tenze.pms.action.his;

import com.tenze.action.common.BaseAction;
import com.tenze.common.utils.LoginInfo;
import com.tenze.pms.facade.service.his.HisService;
import com.tenze.utils.Dto;
import com.tenze.utils.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller("HisAction")
@Scope(value="prototype")
public class HisAction extends BaseAction{
	
	@Autowired
	private HisService hisService;
	
	private String ckz543;

	private boolean initLogin(){
		String ckz543 = this.getUserInSession().getAsString("hisNo");
		String vhid = this.getUserInSession().getAsString("hisId") ;
		if (vhid.equals("") || (vhid == null)) 
			vhid =  LoginInfo.loginHisId ;
		if ( (ckz543.equals("") || (ckz543 == null) ) )   
			ckz543 = LoginInfo.loginUserId;
		
		if(LoginEnum.INSTANCE.getSessionId(ckz543)==null){
			hisService.doLogin(ckz543, vhid );
		}
		/*
		aae011 = LoginEnum.INSTANCE.getUserId(ckz543);
		sessionid = LoginEnum.INSTANCE.getSessionId(ckz543);
		if(aae011==null || aae011.trim().length()==0)aae011="20001286";
		if(sessionid==null || sessionid.trim().length()==0)sessionid="HISID-936E0B186E6B4B8A954FE4E366EE9194";
		*/
		return true;
	}
	
	/** @throws IOException */
	public String dyxsData() throws IOException{
		String input = this.getPayload();
		String result = hisService.doprocess(WebserviceConst.DYXS, input);
		write(result);
		return NULL_SUCCESS;
	}
	public String jzzlcxData() throws IOException{
		String input = this.getPayload();
		String result = hisService.doprocess(WebserviceConst.JZZLCX, input);
		write(result);
		return NULL_SUCCESS;
	}
	public String jsxxcxData() throws IOException{
		String input = this.getPayload();
		String result = hisService.doprocess(WebserviceConst.JSXXCX, input);
		write(result);
		return NULL_SUCCESS;
	}
	public String yscfymxcxData() throws IOException{
		String input = this.getPayload();
		String result = hisService.doprocess(WebserviceConst.YSCFYMXCX, input);
		write(result);
		return NULL_SUCCESS;
	}
	public String yydscxData() throws IOException{
		String input = this.getPayload();
		String result = hisService.doprocess(WebserviceConst.YYDSCX, input);
		write(result);
		return NULL_SUCCESS;
	}
	public String jsdcxData() throws IOException{
		//查看统筹结果数据
		String input = this.getPayload();
		String result = hisService.doprocess(WebserviceConst.JSDCX, input);
		System.out.println(result);
		write(result);
		return NULL_SUCCESS;
	}
	public String fyjsData() throws IOException{
		String input = this.getPayload();
		String result = hisService.doprocess(WebserviceConst.FYJS, input);
		write(result);
		return NULL_SUCCESS;
	}
	public String fyjshtData() throws IOException{
		String input = this.getPayload();
		String result = hisService.doprocess(WebserviceConst.FYJS_HT, input);
		write(result);
		return NULL_SUCCESS;
	}
	public String mzdjcscfData() throws IOException{
		String input = this.getPayload();
		String result = hisService.doprocess(WebserviceConst.MZDJCSCF, input);
		write(result);
		return NULL_SUCCESS;
	}
	public String mzjzhtData() throws IOException{
		String input = this.getPayload();
		String result = hisService.doprocess(WebserviceConst.MZJZHT, input);
		write(result);
		return NULL_SUCCESS;
	}
	public String rydjData() throws IOException{
		String input = this.getPayload();
		String result = hisService.doprocess(WebserviceConst.RYDJ, input);
		write(result);
		return NULL_SUCCESS;
	}
	public String jzdjhtData() throws IOException{
		String input = this.getPayload();
		String result = hisService.doprocess(WebserviceConst.JZDJ_HT, input);
		write(result);
		return NULL_SUCCESS;
	}
	public String cfxmcsData() throws IOException{
		String input = this.getPayload();
		String result = hisService.doprocess(WebserviceConst.CFXMCS, input);
		write(result);
		return NULL_SUCCESS;
	}
	public String cfmxhtData() throws IOException{
		String input = this.getPayload();
		String result = hisService.doprocess(WebserviceConst.CFMX_HT, input);
		write(result);
		return NULL_SUCCESS;
	}
	public String cydjData() throws IOException{
		String input = this.getPayload();
		String result = hisService.doprocess(WebserviceConst.CYDJ, input);
		write(result);
		return NULL_SUCCESS;
	}
	public String cydjhtData() throws IOException{
		String input = this.getPayload();
		String result = hisService.doprocess(WebserviceConst.CYDJ_HT, input);
		write(result);
		return NULL_SUCCESS;
	}
	public String gxjzdjxxData() throws IOException{
		String input = this.getPayload();
		String result = hisService.doprocess(WebserviceConst.GXJZDJXX, input);
		write(result);
		return NULL_SUCCESS;
	}
	
	public String doLogin() throws IOException{
		
        Dto dto = this.getRequestDto();
        String aid = dto.getAsString("id");
		 		
		boolean result = hisService.doLogin(ckz543,aid);
		if(result){
			String aae011 = LoginEnum.INSTANCE.getUserId(ckz543);
			String sessionid = LoginEnum.INSTANCE.getSessionId(ckz543);
			Map<String,Object> params = new HashMap<String,Object>();
 
			if ( (aae011.equals("")) || (aae011 == null) )
			   aae011 = LoginInfo.loginHisAae011;
			
			LoginInfo.loginHisId = aid ;
			
			params.put("success", "true");
			params.put("ckz543", ckz543);
			params.put("aae011", aae011);
			params.put("sessionid", sessionid);
			params.put("msg", "社保登录成功");
			write(JsonHelper.toJSON(params));
		}else{
			setFailureTipMsg("社保登录失败");
		}

		
		return NULL_SUCCESS;
	}

	public String getCkz543() {
		return ckz543;
	}

	public void setCkz543(String ckz543) {
		this.ckz543 = ckz543;
	}
	
	
}
