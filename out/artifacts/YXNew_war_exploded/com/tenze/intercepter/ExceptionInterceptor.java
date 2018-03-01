package com.tenze.intercepter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 
 * @author 胡波
 * 
 */
public class ExceptionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 4958635572293895837L;

	@Override
	public String intercept(ActionInvocation ai) throws Exception  {
		try {
			String rtn = ai.invoke();
			return rtn;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
