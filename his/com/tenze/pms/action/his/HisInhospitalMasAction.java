package com.tenze.pms.action.his;

import com.tenze.action.common.BaseAction;
import com.tenze.background.common.page.PageBean;
import com.tenze.common.utils.DataObjectUtils;
import com.tenze.common.utils.LoginInfo;
import com.tenze.pms.facade.dto.his.HisInhospitalMasDto;
import com.tenze.pms.facade.service.his.HisInhospitalMasService;
import com.tenze.pms.facade.service.his.HisService;
import com.tenze.utils.Dto;
import com.tenze.utils.JsonHelper;
import com.tenze.utils.TenzeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("HisInhospitalMasAction")
@Scope(value="prototype")
public class HisInhospitalMasAction extends BaseAction {
    
    @Autowired
    private HisInhospitalMasService hisInhospitalMasService;
    @Autowired
    private HisService hisService;
    
    private HisInhospitalMasDto mas;
    
    private Long id;
    
	private String ckz543;
	
	private String aae011;
	
	private String sessionid;
	
	private String nextStep;
	
	private String my;
    

    public String listPage() throws IOException{
        
        PageBean pageBean = hisInhospitalMasService.listPage(this.getPageParam(),this.getRequestDto());
        
        write(JsonHelper.toJSON(pageBean));
        
        return NULL_SUCCESS;
    }
    
    public String list() throws IOException{
        
        List<HisInhospitalMasDto> list = hisInhospitalMasService.listBy(this.getRequestDto());
        
        write(JsonHelper.toJSON(list));
        
        return NULL_SUCCESS;
    }
    
    public String create() throws IOException{
        return this.save();
    }
    
    public String update() throws IOException{
        return this.save();
    }
    
    private String save() throws IOException{
        
        HisInhospitalMasDto hisInhospitalMasDto = new HisInhospitalMasDto();
        DataObjectUtils.mapToObject(hisInhospitalMasDto, this.getRequestDto());
        hisInhospitalMasDto.setHisBillState("0");
//		//就诊记录号随机生成8位
//		int random= (int)((Math.random()*9+1)*10000000);
//		String aaz217 =String.valueOf(random);
//		hisInhospitalMasDto.setAaz217(aaz217);
        try{
            long result = hisInhospitalMasService.save(hisInhospitalMasDto);
            if(result<1){
                setFailureTipMsg("保存失败");
                return NULL_SUCCESS;
            }
            Map<String,Object> reMsg = new HashMap<String,Object>();
            reMsg.put("success", "true");
            reMsg.put("id", result);
            write(JsonHelper.toJSON(reMsg));
        }catch(Exception e){
            setFailureTipMsg("保存失败："+e.getMessage());
        }
        
        return NULL_SUCCESS;
    }

    public String mng(){
        
        return INPUT_RESULT;
    }
    
    public String supcan(){
    	mas = new HisInhospitalMasDto();
    	return INPUT_RESULT;
    }
    
    public String mas(){
    	initLogin();
    	if(id!=null && id!=0){
    		mas = hisInhospitalMasService.getById(id);
    	}
		if(mas==null){
			mas = new HisInhospitalMasDto();
		}
    	return INPUT_RESULT;
    }
    
    public String dtl(){
    	if(id!=null && id!=0){
    		mas = hisInhospitalMasService.getById(id);
    	}
		if(mas==null){
			mas = new HisInhospitalMasDto();
		}
    	return INPUT_RESULT;
    }
    
    public String edit(){
        
        return INPUT_RESULT;
    }
    
    public String getSingle() throws IOException{
    	HisInhospitalMasDto masDto = hisInhospitalMasService.getById(id);
    	write(JsonHelper.toJSON(masDto));
    	return NULL_SUCCESS;
    }
    
    public String remove() throws IOException{
        if(StringUtils.isEmpty(key)){
            setFailureTipMsg("请选择要删除的数据");
            return NULL_SUCCESS;
        }
        try{
            hisInhospitalMasService.deleteByIds(TenzeUtils.str2IdList(key));
                setSuccessTipMsg();
                return NULL_SUCCESS;
        }catch(Exception e){
            e.printStackTrace();
            setFailureTipMsg("保存失败："+e.getMessage());
            return NULL_SUCCESS;
        }
    }
    
    public String updateInpatientRegistration() throws IOException{
    	Dto dto = this.getRequestDto();
    	Long masId = dto.getAsLong("id");
    	String aaz217 = dto.getAsString("aaz217");
    	HisInhospitalMasDto mas = hisInhospitalMasService.getById(masId);
		mas.setHisBillState("1");
    	mas.setAaz217(aaz217); 
    	hisInhospitalMasService.save(mas);
    	setSuccessTipMsg();
    	return NULL_SUCCESS;
    }
    
    public String updateBackInpatientRegistration() throws IOException{
    	Dto dto = this.getRequestDto();
    	Long masId = dto.getAsLong("id");
    	HisInhospitalMasDto mas = hisInhospitalMasService.getById(masId);
    	mas.setHisBillState("2");
    	hisInhospitalMasService.save(mas);
    	setSuccessTipMsg();
    	return NULL_SUCCESS;
    }
    
    public String updateFeeSettleMent() throws IOException{
    	Dto dto = this.getRequestDto();
    	Long masId = dto.getAsLong("id");
    	String ykc618 = dto.getAsString("ykc618");
    	HisInhospitalMasDto mas = hisInhospitalMasService.getById(masId);
    	mas.setHisBillState("3");
    	mas.setYkc618(ykc618);
    	hisInhospitalMasService.save(mas);
    	setSuccessTipMsg();
    	return NULL_SUCCESS;
    }
    
    public String updateBackFeeSettleMent() throws IOException{
    	Dto dto = this.getRequestDto();
    	Long masId = dto.getAsLong("id");
    	HisInhospitalMasDto mas = hisInhospitalMasService.getById(masId);
    	mas.setHisBillState("4");
    	hisInhospitalMasService.save(mas);
    	setSuccessTipMsg();
    	return NULL_SUCCESS;
    }

	public HisInhospitalMasDto getMas() {
		return mas;
	}

	public void setMas(HisInhospitalMasDto mas) {
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

	public String getNextStep() {
		return nextStep;
	}

	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}
    
	private boolean initLogin(){
		ckz543 = this.getUserInSession().getAsString("hisNo");
		String vhid = this.getUserInSession().getAsString("hisId") ;
		if (vhid.equals("") || (vhid == null)) 
			vhid =  LoginInfo.loginHisId ;
		if ( (ckz543.equals("") || (ckz543 == null) ) )   
			ckz543 = LoginInfo.loginUserId;
		
		if(LoginEnum.INSTANCE.getSessionId(ckz543)==null){
			hisService.doLogin(ckz543, vhid );
		}
		aae011 = LoginEnum.INSTANCE.getUserId(ckz543);
		sessionid = LoginEnum.INSTANCE.getSessionId(ckz543);
		
		if ( (aae011.equals("")) || (aae011 == null) )
			   aae011 = LoginInfo.loginHisAae011;
		if ( (sessionid.equals("")) || (sessionid == null) )
			sessionid = LoginInfo.loginSession ;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		my = LoginEnum.INSTANCE.getHisKey(ckz543+sdf.format(new Date()));
		if(StringUtils.isEmpty(my)){
			hisService.findKey(ckz543, aae011, sessionid);
		}
		return true;
	}

	public String getMy() {
		return my;
	}

	public void setMy(String my) {
		this.my = my;
	}
    
	
}