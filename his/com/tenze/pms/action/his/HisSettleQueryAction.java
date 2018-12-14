package com.tenze.pms.action.his;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tenze.action.common.BaseAction;
import com.tenze.common.utils.LoginInfo;
import com.tenze.pms.facade.service.his.HisService;

@Controller("HisSettleQueryAction")
@Scope(value="prototype")
public class HisSettleQueryAction extends BaseAction {
	
	@Autowired
	private HisService hisService;

	private String ckz543;
	private String aae011;
	private String sessionid;

	public String mng(){
		initLogin();
		return INPUT_RESULT;
	}

	public String getCkz543() {
		return ckz543;
	}

	public void setCkz543(String ckz543) {
		this.ckz543 = ckz543;
	}

	public String getAae011() {
		return aae011;
	}

	public void setAae011(String aae011) {
		this.aae011 = aae011;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	
	private boolean initLogin(){
		ckz543 = this.getUserInSession().getAsString("hisNo");
		String vhid = this.getUserInSession().getAsString("hisId") ;
		
		if (vhid.equals("") || (vhid == null)) 
			vhid =  LoginInfo.loginHisId ;
		if ( (ckz543.equals("") || (ckz543 == null) ) )   
			ckz543 = LoginInfo.loginUserId;
		 
		if(LoginEnum.INSTANCE.getSessionId(ckz543)==null){
			hisService.doLogin(ckz543,vhid);
		}
		aae011 = LoginEnum.INSTANCE.getUserId(ckz543);
		sessionid = LoginEnum.INSTANCE.getSessionId(ckz543);
		
		if ( (aae011.equals("")) || (aae011 == null) )
			   aae011 = LoginInfo.loginHisAae011;
		if ( (sessionid.equals("")) || (sessionid == null) )
			sessionid = LoginInfo.loginSession ;
		
		return true;
	}
}
