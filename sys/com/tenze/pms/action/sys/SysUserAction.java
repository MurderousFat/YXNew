package com.tenze.pms.action.sys;

import com.tenze.action.common.BaseAction;
import com.tenze.background.common.page.PageBean;
import com.tenze.common.utils.DataObjectUtils;
import com.tenze.pms.facade.dto.sys.SysUserDto;
import com.tenze.pms.facade.service.sys.SysUserService;
import com.tenze.utils.BaseDto;
import com.tenze.utils.Dto;
import com.tenze.utils.JsonHelper;
import com.tenze.utils.TenzeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller("SysUserAction")
@Scope(value="prototype")
public class SysUserAction extends BaseAction {
    
    @Autowired
    private SysUserService sysUserService;
    

    public String listPage() throws IOException{
        
        PageBean pageBean = sysUserService.listPage(this.getPageParam(),this.getRequestDto());
        
        write(JsonHelper.toJSON(pageBean));
        
        return NULL_SUCCESS;
    }
    
    public String list() throws IOException{
        
        List<SysUserDto> list = sysUserService.listBy(this.getRequestDto());
        
        write(JsonHelper.toJSON(list));
        
        return NULL_SUCCESS;
    }
    
    public String supcan(){
    	return INPUT_RESULT;
    }
    
    public String create() throws IOException{
        return this.save();
    }
    
    public String update() throws IOException{
        return this.save();
    }
    
    private String save() throws IOException{
        
        SysUserDto sysUserDto = new SysUserDto();
        DataObjectUtils.mapToObject(sysUserDto, this.getRequestDto());
        try{
            long result = sysUserService.saveUser(sysUserDto);
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
            sysUserService.deleteByIds(TenzeUtils.str2IdList(key));
                setSuccessTipMsg();
                return NULL_SUCCESS;
        }catch(Exception e){
            e.printStackTrace();
            setFailureTipMsg("保存失败："+e.getMessage());
            return NULL_SUCCESS;
        }
    }

    public String getUserInfo() throws IOException {
        Dto jsonDto = new BaseDto();
        HttpSession session = this.getSession();
       Map<String,String> map = (Map<String, String>) session.getAttribute("user_in_session");
        String account = map.get("account");
        if(StringUtils.isEmpty(account)){
            jsonDto.put("msg", "参数有误");
            jsonDto.put("success", "true");
            write(jsonDto.toJson());
            return NULL_SUCCESS;
        }
        Dto d = new BaseDto();
        d.put("account", account);
        SysUserDto sysUserDto = sysUserService.getBy(d);
        jsonDto.put("data", sysUserDto);
        jsonDto.put("success", "true");
        write(jsonDto.toJson());
        return SUCCESS;
    }


}