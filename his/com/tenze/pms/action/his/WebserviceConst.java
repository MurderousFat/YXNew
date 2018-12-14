package com.tenze.pms.action.his;

public interface WebserviceConst {

	public static final String LOGIN_SOAP_XML = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://services.agent.sinobest.cn/\"><soapenv:Header/><soapenv:Body><ser:login><arg0>#INTERFACE_ID#</arg0><arg1><![CDATA[<?xml version=\"1.0\"  encoding=\"UTF-8\"  standalone=\"yes\" ?><input><ckz543>#HIS_ID#</ckz543><operid>#OPERID#</operid><password>#PASSWORD#</password></input> ]]></arg1></ser:login></soapenv:Body></soapenv:Envelope>";
	public static final String SOAP_XML = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://services.agent.sinobest.cn/\"><soapenv:Header/><soapenv:Body><ser:process><arg0>#INTERFACE_ID#</arg0><arg1><![CDATA[<?xml version=\"1.0\"  encoding=\"UTF-8\"  standalone=\"yes\" ?>#XML_CONTENT#]]></arg1></ser:process></soapenv:Body></soapenv:Envelope>";

	/** 登录 */
	public static final String LONGIN = "100";
	/** 获取秘钥 */
	public static final String FINDKEY= "102";
	/** 待遇享受条件查询*/
	public static final String DYXS = "BDGR00";
	/** 就诊资料查询*/
	public static final String JZZLCX = "BDCX01";
	/** 结算信息查询 */
	public static final String JSXXCX= "BDCX02";
	/** 已上传费用明细查询 */
	public static final String YSCFYMXCX= "BDCX03";
	/** 医院对数查询 */
	public static final String YYDSCX= "BDCX04";
	/** 结算单查询 */
	public static final String JSDCX= "BDCX05";
	/** 费用结算 */
	public static final String FYJS= "BDGR05";
	/** 费用结算回退 */
	public static final String FYJS_HT = "BDGR05R";
	/** 门诊登记传送处方 */
	public static final String MZDJCSCF = "BDGR02";
	/** 门诊就诊回退 */
	public static final String MZJZHT = "BDGR02R";
	/** 入院登记 */
	public static final String RYDJ = "BDGR01";
	/** 就诊登记回退 */
	public static final String JZDJ_HT = "BDGR01R";
	/** 处方项目传送 */
	public static final String CFXMCS = "BDGR03";
	/** 处方明细回退 */
	public static final String CFMX_HT = "BDGR03R";
	/** 出院登记 */
	public static final String CYDJ = "BDGR04";
	/** 出院登记回退 */
	public static final String CYDJ_HT= "BDGR04R";
	/** 更新就诊登记信息 */
	public static final String GXJZDJXX = "BDGR06";
	
}
