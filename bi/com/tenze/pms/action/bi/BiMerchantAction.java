package com.tenze.pms.action.bi;

import com.tenze.action.common.BaseAction;
import com.tenze.background.common.page.PageBean;
import com.tenze.common.utils.DataObjectUtils;
import com.tenze.pms.facade.dto.bi.BiMerchantDto;
import com.tenze.pms.facade.service.bi.BiMerchantService;
import com.tenze.utils.JsonHelper;
import com.tenze.utils.TenzeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

@Controller("BiMerchantAction")
@Scope(value="prototype")
public class BiMerchantAction extends BaseAction {
    
    @Autowired
    private BiMerchantService biRegionService;

    public String listPage() throws IOException{
        
        PageBean pageBean = biRegionService.listPage(this.getPageParam(),this.getRequestDto());

        write(JsonHelper.toJSON(pageBean));
        
        return NULL_SUCCESS;
    }
    
    public String list() throws IOException{
        
        List<BiMerchantDto> list = biRegionService.listBy(this.getRequestDto());
        
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
        
        BiMerchantDto biRegionDto = new BiMerchantDto();
        DataObjectUtils.mapToObject(biRegionDto, this.getRequestDto());
        try{
            long result = biRegionService.saveTree(biRegionDto);
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
            biRegionService.deleteByIds(TenzeUtils.str2IdList(key));
                setSuccessTipMsg();
                return NULL_SUCCESS;
        }catch(Exception e){
            e.printStackTrace();
            setFailureTipMsg("保存失败："+e.getMessage());
            return NULL_SUCCESS;
        }
    }
}