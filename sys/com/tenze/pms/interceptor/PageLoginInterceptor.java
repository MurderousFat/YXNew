package com.tenze.pms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tenze.action.common.WebConts;

public class PageLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Object user_in_session = session
					.getAttribute(WebConts.USER_IN_SESSION);
			if (user_in_session==null) {
					ServletActionContext.getResponse().sendRedirect(
							request.getContextPath()+"/loginPage.tz");
					return null;

			}
			return ai.invoke();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
