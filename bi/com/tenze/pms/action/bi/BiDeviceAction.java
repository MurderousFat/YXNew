package com.tenze.pms.action.bi;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tenze.action.common.BaseAction;
import com.tenze.background.common.page.PageBean;
import com.tenze.common.utils.DataObjectUtils;
import com.tenze.pms.facade.dto.bi.BiDeviceDto;
import com.tenze.pms.facade.service.bi.BiDeviceService;
import com.tenze.utils.JsonHelper;
import com.tenze.utils.TenzeUtils;

@Controller("BiDeviceAction")
@Scope(value="prototype")
public class BiDeviceAction extends BaseAction {
    
    @Autowired
    private BiDeviceService biDeviceService;
    

    public String listPage() throws IOException{
        
        PageBean pageBean = biDeviceService.listPage(this.getPageParam(),this.getRequestDto());
        
        write(JsonHelper.toJSON(pageBean));
        
        return NULL_SUCCESS;
    }
    
    public String list() throws IOException{
        
        List<BiDeviceDto> list = biDeviceService.listBy(this.getRequestDto());
        
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
        
        BiDeviceDto biDeviceDto = new BiDeviceDto();
        DataObjectUtils.mapToObject(biDeviceDto, this.getRequestDto());
        try{
            long result = biDeviceService.save(biDeviceDto);
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
            biDeviceService.deleteByIds(TenzeUtils.str2IdList(key));
                setSuccessTipMsg();
                return NULL_SUCCESS;
        }catch(Exception e){
            e.printStackTrace();
            setFailureTipMsg("保存失败："+e.getMessage());
            return NULL_SUCCESS;
        }
    }
}

