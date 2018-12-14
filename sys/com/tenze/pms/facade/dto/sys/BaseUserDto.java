package com.tenze.pms.facade.dto.sys;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.tenze.background.common.entity.BaseEntity;

/**
 * 基本用户信息
 * @author TenzeTseng
 *
 */
public class BaseUserDto extends BaseEntity {

	/**
	 * 账号
	 */
	private String faccount;
	
	/**
	 * 用户名
	 */
	private String fusername;
	
	/**
	 * 密码
	 */
	private String fpassword;
	
	/**
	 * 最后登录时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date flastLogin;
	
	/**
	 * 是否启用
	 */
	private Integer fenabled;

	public String getFaccount() {
		return faccount;
	}

	public void setFaccount(String faccount) {
		this.faccount = faccount;
	}

	public String getFusername() {
		return fusername;
	}

	public void setFusername(String fusername) {
		this.fusername = fusername;
	}

	public String getFpassword() {
		return fpassword;
	}

	public void setFpassword(String fpassword) {
		this.fpassword = fpassword;
	}

	public Date getFlastLogin() {
		return flastLogin;
	}

	public void setFlastLogin(Date flastLogin) {
		this.flastLogin = flastLogin;
	}

	public Integer getFenabled() {
		return fenabled;
	}

	public void setFenabled(Integer fenabled) {
		this.fenabled = fenabled;
	}
	
	
}
