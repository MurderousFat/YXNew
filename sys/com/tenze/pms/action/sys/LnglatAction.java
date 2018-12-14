package com.tenze.pms.action.sys;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tenze.action.common.BaseAction;

@Controller("LnglatAction")
@Scope(value="prototype")
public class LnglatAction extends BaseAction {

	public String pickup(){
		return INPUT_RESULT;
	}

}
