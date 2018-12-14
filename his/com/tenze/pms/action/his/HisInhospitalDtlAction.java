package com.tenze.pms.action.his;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.tenze.action.common.BaseAction;
import com.tenze.background.common.page.PageBean;
import com.tenze.common.utils.DataObjectUtils;
import com.tenze.pms.facade.dto.his.HisInhospitalDtlDto;
import com.tenze.pms.facade.service.his.HisInhospitalDtlService;
import com.tenze.utils.JsonHelper;
import com.tenze.utils.TenzeUtils;

@Controller("HisInhospitalDtlAction")
@Scope(value="prototype")
public class HisInhospitalDtlAction extends BaseAction {
    
    @Autowired
    private HisInhospitalDtlService hisInhospitalDtlService;
    
    private Long id;
    

    public String listPage() throws IOException{
        
        PageBean pageBean = hisInhospitalDtlService.listPage(this.getPageParam(),this.getRequestDto());
        
        write(JsonHelper.toJSON(pageBean));
        
        return NULL_SUCCESS;
    }
    
    public String list() throws IOException{
        
        List<HisInhospitalDtlDto> list = hisInhospitalDtlService.listBy(this.getRequestDto());
        
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
        String payload = this.getPayload();
        List<HisInhospitalDtlDto> list = JSON.parseArray(payload, HisInhospitalDtlDto.class);
        try{
            long result = hisInhospitalDtlService.saveAll(id, list);
            if(result<1){
                setFailureTipMsg("保存失败");
                return NULL_SUCCESS;
            }
        }catch(Exception e){
            setFailureTipMsg("保存失败："+e.getMessage());
        }
        setSuccessTipMsg();
        
        return NULL_SUCCESS;
    }

    public String mng(){
        
        return INPUT_RESULT;
    }
    
    public String edit(){
        
        return INPUT_RESULT;
    }
    
    public String remove() throws IOException{
        if(StringUtils.isEmpty(key)){
            setFailureTipMsg("请选择要删除的数据");
            return NULL_SUCCESS;
        }
        try{
            hisInhospitalDtlService.deleteByIds(TenzeUtils.str2IdList(key));
                setSuccessTipMsg();
                return NULL_SUCCESS;
        }catch(Exception e){
            e.printStackTrace();
            setFailureTipMsg("保存失败："+e.getMessage());
            return NULL_SUCCESS;
        }
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    
}