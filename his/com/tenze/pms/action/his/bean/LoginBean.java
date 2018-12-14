package com.tenze.pms.action.his.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name="input") 
@XmlType(name = "input")
public class LoginBean {

	@XmlElement(required = true)  
	private String ckz543;
	
	@XmlElement(required = true)  
	private String operid;
	
	@XmlElement(required = true)  
	private String password;

	

	public String getCkz543() {
		return ckz543;
	}

	public void setCkz543(String ckz543) {
		this.ckz543 = ckz543;
	}

	public String getOperid() {
		return operid;
	}

	public void setOperid(String operid) {
		this.operid = operid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
