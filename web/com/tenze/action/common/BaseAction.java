package com.tenze.action.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.tenze.background.common.page.PageParam;
import com.tenze.common.utils.LoginInfo;
import com.tenze.utils.BaseDto;
import com.tenze.utils.Dto;
import com.tenze.utils.SysConstants;
import com.tenze.utils.helper.WebUtils;

/**
 * 2016-11-26
 * 
 * @author TenzeTseng
 * 
 */
@Controller(value = "BaseAction")
@Scope(value = "prototype")
public class BaseAction extends ActionSupport implements ServletRequestAware,
		SessionAware, ServletResponseAware {

	private static final long serialVersionUID = 2911821988180115516L;

	private HttpServletRequest req;

	private HttpServletResponse res;

	private HttpSession session;
	
	protected Dto requestDto = null;

	protected String key = "";
	
	protected String idx[];

	protected long ids[];

	protected int page = 1;
	
	protected int limit = 1;
	
	protected int rows = 20;

	protected String temp = String.valueOf(new Random().nextInt(10000));

	public static final String INPUT_RESULT = "input_result";

	public static final String SUCCESS_RESULT = "success_result";

	public static final String NULL_SUCCESS = "null_success";

	public static final String SUPCAN_RESULT = "supcan_result";
	
	public String pageReadonly;
	
	protected Long mainMenuId;
	

	/**
	 * 输出响应
	 * 
	 * @param str
	 * @throws IOException
	 */
	protected void write(String str, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(str);
		out.flush();
		out.close();
	}

	/**
	 * 输出响应
	 * 
	 * @param str
	 * @throws IOException
	 */
	protected void write(String str) throws IOException {
		HttpServletResponse response = this.getRes();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(str);
		out.flush();
		out.close();
	}

	/**
	 * 
	 * 成功提示信息
	 * 
	 * @param
	 *
	 * @param
	 * @return
	 * @throws IOException
	 */
	protected void setSuccessTipMsg() throws IOException {
		setSuccessTipMsg("true");
	}


	protected void setSuccessTipMsg(String pStr) throws IOException {
		Dto outDto = new BaseDto(SysConstants.SUCCESS, pStr);
		write(outDto.toJson(), this.getRes());
	}
	protected void setSuccessTipMsg(String pStr,String aaz217) throws IOException {
		Dto outDto = new BaseDto(SysConstants.SUCCESS, pStr);
		outDto.put("aaz217",aaz217);
		write(outDto.toJson(), this.getRes());
	}

	protected void setFailureTipMsg(String pMsg) throws IOException {
		Dto outDto = new BaseDto(SysConstants.FAILURE, pMsg);
		System.out.println( outDto.toJson() );
		write(outDto.toJson(), this.getRes());
	}

	protected void writeTipMsg(Dto dto) throws IOException {
		write(dto.toJson());
	}


	public String getRootPath() {
		return this.getReq().getSession().getServletContext().getRealPath("/");
	}


	protected void setSessionAttribute(HttpServletRequest request,
			String sessionKey, Object objSessionAttribute) {
		if (session != null)
			session.setAttribute(sessionKey, objSessionAttribute);
	}


	/**
	 * 获取一个Session属性对象
	 * 
	 * @param request
	 * @param sessionName
	 * @return
	 */
	protected Object getSessionAttribute(HttpServletRequest request,
			String sessionKey) {
		Object objSessionAttribute = null;
		HttpSession session = request.getSession(false);
		if (session != null) {
			objSessionAttribute = session.getAttribute(sessionKey);
		}
		return objSessionAttribute;
	}

	/**
	 * 移除Session对象属性值
	 * 
	 * @param request
	 * @param sessionName
	 * @return
	 */
	protected void removeSessionAttribute(HttpServletRequest request,
			String sessionKey) {
		HttpSession session = request.getSession();
		if (session != null)
			session.removeAttribute(sessionKey);
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public boolean isGetMethod() {
		if (this.getReq().getMethod().equalsIgnoreCase("get"))
			return true;
		return false;
	}

	public boolean isPostMethod() {
		if (this.getReq().getMethod().equalsIgnoreCase("post"))
			return true;
		return false;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}


	public void setSession(HttpSession session) {
		this.session = session;
	}

	public HttpSession getSession() {
		this.session = this.getReq().getSession();
		return this.session;
	}

	public ServletContext getContext() {
		return this.getSession().getServletContext();
	}

	/**
	 * 取出Session中的用户登录信息
	 * 
	 * @return
	 */
	public Dto getUserInSession() {
		return (Dto) this.getSession().getAttribute(
				SysConstants.USER_IN_SESSION);
	}


	public void setServletRequest(HttpServletRequest req) {
		this.req = req;

	}

	public void setServletResponse(HttpServletResponse res) {
		this.res = res;
	}

	public HttpServletRequest getReq() {
		return req;
	}

	public void setReq(HttpServletRequest req) {
		this.req = req;
	}

	public HttpServletResponse getRes() {
		return res;
	}

	public void setRes(HttpServletResponse res) {
		this.res = res;
	}

	public void setSession(Map arg0) {

	}


	public String[] getIdx() {
		return idx;
	}

	public void setIdx(String[] idx) {
		this.idx = idx;
	}

	public long[] getIds() {
		return ids;
	}

	public void setIds(long[] ids) {
		this.ids = ids;
	}

	public Dto getRequestDto() {
		this.requestDto = WebUtils.getPraramsAsDto(this.getReq());
		requestDto.put("webroot", getRootPath());
		Dto uDto = this.getUserInSession();
		if(uDto!=null){
			this.requestDto.put(SysConstants.USER_IN_SESSION, uDto);
		}
		// 批量更新
		return requestDto;
	}

	public void setRequestDto(Dto requestDto) {
		this.requestDto.putAll(requestDto);
	}


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageParam getPageParam() {
		return new PageParam(page,limit);
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getPayload() throws IOException {
		BufferedReader reader = this.req.getReader();
		StringBuilder _payload = new StringBuilder();
		String s;
		while((s=reader.readLine())!=null){
			// 
			if (s.equals("<sessionid></sessionid>"))
				s = "<sessionid>"+LoginInfo.loginSession+"</sessionid>";
			
			_payload.append(s);
		}
		return _payload.toString();
	}

	public String getPageReadonly() {
		return pageReadonly;
	}

	public void setPageReadonly(String pageReadonly) {
		this.pageReadonly = pageReadonly;
	}

	public Long getMainMenuId() {
		return mainMenuId;
	}

	public void setMainMenuId(Long mainMenuId) {
		this.mainMenuId = mainMenuId;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	
}
