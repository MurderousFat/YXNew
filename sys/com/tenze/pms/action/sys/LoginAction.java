package com.tenze.pms.action.sys;

import com.tenze.action.common.BaseAction;
import com.tenze.common.utils.Md5;
import com.tenze.pms.facade.dto.bi.BiMerchantDto;
import com.tenze.pms.facade.dto.his.HisConfigDto;
import com.tenze.pms.facade.dto.sys.SysRoleDto;
import com.tenze.pms.facade.dto.sys.SysUserDto;
import com.tenze.pms.facade.service.bi.BiMerchantService;
import com.tenze.pms.facade.service.his.HisConfigService;
import com.tenze.pms.facade.service.sys.SysRoleService;
import com.tenze.pms.facade.service.sys.SysUserService;
import com.tenze.pms.servlet.RandCodeImageServlet;
import com.tenze.utils.BaseDto;
import com.tenze.utils.Dto;
import com.tenze.utils.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller("LoginAction")
@Scope(value="prototype")
public class LoginAction extends BaseAction {
	
	@Autowired
	private HisConfigService hisConfigService;
	
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private BiMerchantService biMerchantService;

	
	private String account;
	private String password;
	private String randCode;

	public String loginPage(){
		return SUCCESS;
	}

	public String loginCheck() throws IOException{
		if(account==null || account.trim().length()<1){
			setFailureTipMsg("请输入用户名");
			return NULL_SUCCESS;
		}
		if(password==null || password.trim().length()<1){
			setFailureTipMsg("请输入密码");
			return NULL_SUCCESS;
		}
		if(randCode==null || randCode.trim().length()<1){
			setFailureTipMsg("请输入验证码");
			return NULL_SUCCESS;
		}
		
		HttpSession session = this.getSession();
		
		Dto d = new BaseDto();

		d.put("account", account);
		SysUserDto sysUserDto = sysUserService.getBy(d);
		if(sysUserDto==null){
			setFailureTipMsg("用户不存在");
			return NULL_SUCCESS;
		}
		if(!sysUserDto.getPassword().equals(Md5.MD5Encode(password))){
			setFailureTipMsg("账号或密码错误");
			return NULL_SUCCESS;
		}
		if (!randCode.equalsIgnoreCase(String.valueOf(session.getAttribute(RandCodeImageServlet.SESSION_KEY_OF_RAND_CODE)))){
			setFailureTipMsg("验证码错误");
			return NULL_SUCCESS;
		}
		
		Dto userInSession = new BaseDto();
		userInSession.put("sysuserid", sysUserDto.getId());
		userInSession.put("username", sysUserDto.getUsername());
		userInSession.put("account", account);
		userInSession.put("unionId", sysUserDto.getUnionId());
		userInSession.put("unionNo", sysUserDto.getUnionNo());
		userInSession.put("unionName", sysUserDto.getUnionName());
		userInSession.put("merchantId", sysUserDto.getMerchantId());
		userInSession.put("merchantName", sysUserDto.getMerchantName());

		if(sysUserDto.getMerchantId()!=null && sysUserDto.getMerchantId()!=0){
			BiMerchantDto merchant = biMerchantService.getById(sysUserDto.getMerchantId());
			userInSession.put("hisNo", merchant.getHisNo());
			userInSession.put("hisPhone", merchant.getPhone());
			userInSession.put("hisId", merchant.getId() );
			
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("fkey", merchant.getHisNo() );
			params.put("merchant_id", merchant.getId() );
//			params.put("merchant_id", merchant.getId() );
			HisConfigDto hislst = hisConfigService.getBy(params);
			if(hislst ==null ){
				userInSession.put("hisLoginCfg", sysUserDto.getMerchantId() );
				userInSession.put("hisLoginCounty", "");
				userInSession.put("hisLoginFullName", "");
			} else {
				userInSession.put("hisLoginCfg", hislst.getFusername() );
				userInSession.put("hisLoginCounty",hislst.getFcounty() );
				userInSession.put("hisLoginFullName",hislst.getFfullName() );
				userInSession.put("hisPhone",hislst.getHisPhone() );

			}
		}
		
		userInSession.put("roleId", sysUserDto.getRoleId());
		userInSession.put("roleName", sysUserDto.getRoleName());
		SysRoleDto roleDto = sysRoleService.getById(sysUserDto.getRoleId());
		userInSession.put("roleType", roleDto.getRoleType());
		userInSession.put("JSESSIONID", session.getId());
		
		session.setAttribute("STATIC_SESSION_ID", session.getId());// 全局sessionId
		session.setAttribute(SysConstants.USER_IN_SESSION, userInSession);
		
		Dto jsonDto = new BaseDto();
		
		jsonDto.put("username", sysUserDto.getUsername());
		jsonDto.put("userid", sysUserDto.getId());
	
		jsonDto.put("success", new Boolean(true));
		write(jsonDto.toJson());
		
		return NULL_SUCCESS;
	}
	
	public String logout(){
		Dto dto = getUserInSession();
		if (null != dto) {
			this.getSession().removeAttribute(SysConstants.USER_IN_SESSION);
		}
		return SUCCESS_RESULT;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRandCode() {
		return randCode;
	}

	public void setRandCode(String randCode) {
		this.randCode = randCode;
	}




}
