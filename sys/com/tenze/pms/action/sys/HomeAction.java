package com.tenze.pms.action.sys;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tenze.action.common.BaseAction;

@Controller("HomeAction")
@Scope(value="prototype")
public class HomeAction extends BaseAction {


	public String mng(){
		
		return INPUT_RESULT;
	}
	
	public String index(){
		return INPUT_RESULT;
	}
	
	public String test(){
		
		return INPUT_RESULT;
	}
	
	public String workbench(){
		
		return INPUT_RESULT;
	}
	
	public String jumpLogin(){
		return INPUT_RESULT;
	}
}
