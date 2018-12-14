/*
 * Created on 2005-2-6
 *
 * $Id: CommonException.java,v 1.2 2005/05/25 08:47:30 liuwen Exp $
 *
 * Copyright 2005 Shanghai Huateng Software, Limited. All rights reserved.
 * HUATENG PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.tenze.common.utils;

/**
 * @author liu_wen@huateng.com
 * @version $Revision: 1.2 $ ��
 */
public class CommonException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8418580429031326784L;
	/**
	 * error key, see struts's ApplicationResources
	 */
	private String errMessage;

	private String params[];

	private String param;

	/**
	 * the real value of the param in the error messages. for example
	 * 
	 */
	private String[] objs = null;

	public CommonException() {
		super();
	}

	public CommonException(String errorMsg) {
		super(errorMsg);
		this.errMessage = errorMsg;
	}

	public CommonException(String errorMsg, Throwable t) {
		super(errorMsg, t);
		this.errMessage = errorMsg;
	}

	public CommonException(String errMessage, String param) {
		super();
		this.errMessage = errMessage;
		this.param = param;
	}

	public CommonException(String errMessage, String[] params) {
		super();
		this.errMessage = errMessage;
		this.params = params;
	}

	public String[] getObjs() {
		return objs;
	}

	public void setObjs(String[] objs) {
		this.objs = objs;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

}