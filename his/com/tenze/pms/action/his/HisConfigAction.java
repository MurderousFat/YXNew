package com.tenze.pms.action.his;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tenze.action.common.BaseAction;
import com.tenze.background.common.page.PageBean;
import com.tenze.common.utils.DataObjectUtils;
import com.tenze.pms.facade.dto.his.HisConfigDto;
import com.tenze.pms.facade.service.his.HisConfigService;
import com.tenze.utils.JsonHelper;
import com.tenze.utils.TenzeUtils;

@Controller("HisConfigAction")
@Scope(value="prototype")
public class HisConfigAction extends BaseAction {
	
	
	@Autowired
	private HisConfigService hisConfigService;
	

	public String listPage() throws IOException{
		
		PageBean pageBean = hisConfigService.listPage(this.getPageParam(),this.getRequestDto());
		
		write(JsonHelper.toJSON(pageBean));
		
		return NULL_SUCCESS;
	}
	
	public String create() throws IOException{
		return this.save();
	}
	
	public String update() throws IOException{
		return this.save();
	}
	
	private String save() throws IOException{
		
		HisConfigDto hisConfigDto = new HisConfigDto();
		DataObjectUtils.mapToObject(hisConfigDto, this.getRequestDto());
		try{
			long result = hisConfigService.save(hisConfigDto);
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
	
	public String delete() throws IOException{
		
		String payload = this.getPayload();
		if(StringUtils.isEmpty(payload)){
			setFailureTipMsg("请选择要删除的数据");
			return NULL_SUCCESS;
		}
		try{
			hisConfigService.deleteByIds(TenzeUtils.str2IdList(payload));
				setSuccessTipMsg();
				return NULL_SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			setFailureTipMsg("保存失败："+e.getMessage());
			return NULL_SUCCESS;
		}
		
	}
	
	
}
