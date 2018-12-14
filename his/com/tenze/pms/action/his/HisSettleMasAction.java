package com.tenze.pms.action.his;

import com.alibaba.fastjson.JSONObject;
import com.tenze.action.common.BaseAction;
import com.tenze.background.common.page.PageBean;
import com.tenze.common.utils.LoginInfo;
import com.tenze.pms.facade.dto.his.HisSettleMasDto;
import com.tenze.pms.facade.service.his.HisService;
import com.tenze.pms.facade.service.his.HisSettleMasService;
import com.tenze.utils.Dto;
import com.tenze.utils.JsonHelper;
import com.tenze.utils.PropUtil;
import com.tenze.utils.TenzeUtils;
import com.tenze.utils.helper.WebUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("HisSettleMasAction")
@Scope(value="prototype")
public class HisSettleMasAction extends BaseAction {
    
    @Autowired
    private HisSettleMasService hisSettleMasService;
    @Autowired
    private HisService hisService;
    
    private HisSettleMasDto mas;
    
    private Long id;
    
	private String ckz543;
	
	private String aae011;
	
	private String sessionid;
	
	private String nextStep;
	
	private String my;
	
	private Long masId;
	
	private String printFlag;
    

    public String listPage() throws IOException{
        
        PageBean pageBean = hisSettleMasService.listPage(this.getPageParam(),this.getRequestDto());
        
        write(JsonHelper.toJSON(pageBean));
        
        return NULL_SUCCESS;
    }
    
    public String list() throws IOException{
        
        List<HisSettleMasDto> list = hisSettleMasService.listBy(this.getRequestDto());
        
        write(JsonHelper.toJSON(list));
        
        return NULL_SUCCESS;
    }
    
    public String getSingle() throws IOException{
    	HisSettleMasDto masDto = hisSettleMasService.getById(id);
    	write(JsonHelper.toJSON(masDto));
    	return NULL_SUCCESS;
    }
    
    public String supcan(){
    	initLogin();
    	if(id!=null && id!=0){
    		mas = hisSettleMasService.getById(id);
    	}
		if(mas==null){
			mas = new HisSettleMasDto();
		}

		return INPUT_RESULT;
    }
    
    public String create() throws IOException{
        return this.save();
    }
    
    public String update() throws IOException{
        return this.save();
    }
    
    private String save() throws IOException{
        String payload = this.getPayload();
        try{
            long result = hisSettleMasService.saveAll(payload);
            if(result<1){
                setFailureTipMsg("保存失败");
                return NULL_SUCCESS;
            }
	        Map<String,Object> resultMap = new HashMap<String,Object>();
	        resultMap.put("success", "true");
	        resultMap.put("id", result);
	        write(JsonHelper.toJSON(resultMap));
        }catch(Exception e){
            setFailureTipMsg("保存失败："+e.getMessage());
        }
        return NULL_SUCCESS;
    }
    
    public String tcjg(){
    	return INPUT_RESULT;
    }

    public String mng(){
        return INPUT_RESULT;
    }
    
    public String edit(){
        
        return INPUT_RESULT;
    }
    
    public String feeSettlement(){
    	return INPUT_RESULT;
    }
    
    public String remove() throws IOException{
        if(StringUtils.isEmpty(key)){
            setFailureTipMsg("请选择要删除的数据");
            return NULL_SUCCESS;
        }
        try{
            hisSettleMasService.deleteByIds(TenzeUtils.str2IdList(key));
                setSuccessTipMsg();
                return NULL_SUCCESS;
        }catch(Exception e){
            e.printStackTrace();
            setFailureTipMsg("保存失败："+e.getMessage());
            return NULL_SUCCESS;
        }
    }
    
    public String updateSendPrescription() throws IOException{
    	Dto dto = this.getRequestDto();
    	Long masId = dto.getAsLong("id");
    	String aaz217 = dto.getAsString("aaz217");
    	HisSettleMasDto mas = hisSettleMasService.getById(masId);
    	mas.setHisBillState("1");
    	mas.setAaz217(aaz217);
    	hisSettleMasService.save(mas);
    	setSuccessTipMsg("true",aaz217);
    	return NULL_SUCCESS;
    }
    
    public String updateBackPrescription() throws IOException{
    	Dto dto = this.getRequestDto();
    	Long masId = dto.getAsLong("id");
    	hisSettleMasService.updateHisStatus(masId, "2");
    	setSuccessTipMsg();
    	return NULL_SUCCESS;
    }
    
    public String updateFeeSettleMent() throws IOException{
    	Dto dto = this.getRequestDto();
    	Long masId = dto.getAsLong("id");
    	String ykc618 = dto.getAsString("ykc618");
    	Float selfPay = Float.valueOf(dto.getAsString("selfPay"));
    	hisSettleMasService.updateFeeSettleMent(masId, "3", ykc618, selfPay);
    	setSuccessTipMsg();
    	return NULL_SUCCESS;
    }
    
    public String updateBackFeeSettleMent() throws IOException{
    	Dto dto = this.getRequestDto();
    	Long masId = dto.getAsLong("id");
    	hisSettleMasService.updateHisStatus(masId, "4");
    	setSuccessTipMsg();
    	return NULL_SUCCESS;
    }
    
    public String updateCashPay() throws IOException{
    	Dto dto = this.getRequestDto();
    	Long masId = dto.getAsLong("id");
    	hisSettleMasService.updateHisStatus(masId, "5");
    	setSuccessTipMsg();
    	return NULL_SUCCESS;
    }
    
    public String updateUnionPay() throws IOException{
    	Dto dto = this.getRequestDto();
    	Long masId = dto.getAsLong("id");
    	hisSettleMasService.updateHisStatus(masId, "6");
    	setSuccessTipMsg();
    	return NULL_SUCCESS;
    }
    
    public String sendYxPay() throws IOException{
    	Dto param = this.getRequestDto();
    	String yxUrl = PropUtil.getValue("YX_IF_URL");
		String version = PropUtil.getValue("YX_VERSION");
		String appid = PropUtil.getValue("YX_APPID");
		String secret = PropUtil.getValue("YX_SCRET"); 
		String signmethod = PropUtil.getValue("YX_SIGNMETHOD");
		String timestamp = System.currentTimeMillis()+"";
		JSONObject objReq = new JSONObject();
		String merNm = param.getAsString("merNm");
		if(merNm==null)merNm="";
		objReq.put("merCd", "102441380620198");
		objReq.put("merNm", merNm);
		objReq.put("phone", param.getAsString("phone"));
		float fff = Float.valueOf(param.getAsString("txnAmt"));
		BigDecimal   b  =   new BigDecimal(fff);  
		//objReq.put("txnAmt",Float.valueOf(param.getAsString("txnAmt")));
		objReq.put("txnAmt",b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue()*100);
		objReq.put("noticeUrl", "");
		
		PostMethod post = new PostMethod(yxUrl+"/Order/PushOrder?version=v1&appid=111111");
		post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		post.addParameter("data",objReq.toString());
		HttpClient hc = new HttpClient();
		int STATUS_CODE = hc.executeMethod(post);
		String result = post.getResponseBodyAsString();
		JSONObject reMsg = JSONObject.parseObject(result);
		if(reMsg.getInteger("respCode")==200){
			Map<String,Object> map = new HashMap<String,Object>();
			JSONObject reData = reMsg.getJSONArray("data").getJSONObject(0);
			reData.put("success", "true");
			write(reData.toJSONString());
		}else{
			setFailureTipMsg(reMsg.getString("respMsg"));
		}
		
    	return NULL_SUCCESS;
    }
    

	public HisSettleMasDto getMas() {
		return mas;
	}

	public void setMas(HisSettleMasDto mas) {
		this.mas = mas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCkz543() {
		return ckz543;
	}

	public void setCkz543(String ckz543) {
		this.ckz543 = ckz543;
	}

	public String getAae011() {
		return aae011;
	}

	public void setAae011(String aae011) {
		this.aae011 = aae011;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
    
	private boolean initLogin(){
		ckz543 = this.getUserInSession().getAsString("hisNo");
		String vhid = this.getUserInSession().getAsString("hisId") ;
		if (vhid.equals("") || (vhid == null)) 
			vhid =  LoginInfo.loginHisId ;
		
		if ( (ckz543.equals("") || (ckz543 == null) ) ) {
 			aae011 = LoginInfo.loginHisAae011;
 			sessionid = LoginInfo.loginSession;  
			ckz543 = LoginInfo.loginUserId;
		} else {		
//			aae011 = LoginEnum.INSTANCE.getUserId(ckz543);
			ckz543= LoginInfo.loginUserId;
			aae011 = LoginInfo.loginHisAae011;
			sessionid = LoginEnum.INSTANCE.getSessionId(ckz543);
		}
		
		if(LoginEnum.INSTANCE.getSessionId(ckz543)==null){	
			hisService.doLogin(ckz543, vhid );
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		my = LoginEnum.INSTANCE.getHisKey(ckz543+sdf.format(new Date()));
		if(StringUtils.isEmpty(my)){
			hisService.findKey(ckz543, aae011, sessionid);
		}
		return true;
	}

	public String getNextStep() {
		return nextStep;
	}

	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}

	public String getMy() {
		return my;
	}

	public void setMy(String my) {
		this.my = my;
	}

	public Long getMasId() {
		return masId;
	}

	public void setMasId(Long masId) {
		this.masId = masId;
	}

	public String getPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(String printFlag) {
		this.printFlag = printFlag;
	}
	
	
	public static void main(String[] args) {
		try {
			String s = WebUtils.doGet("http://www.baidu.com/", null);
			System.out.println(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
}