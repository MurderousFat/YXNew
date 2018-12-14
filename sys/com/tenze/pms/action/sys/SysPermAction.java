package com.tenze.pms.action.sys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tenze.action.common.BaseAction;
import com.tenze.pms.facade.dto.sys.SysFunctionDto;
import com.tenze.pms.facade.dto.sys.SysFunctionRoleDto;
import com.tenze.pms.facade.dto.sys.SysMenuDto;
import com.tenze.pms.facade.dto.sys.SysMenuRoleDto;
import com.tenze.pms.facade.service.sys.SysFunctionRoleService;
import com.tenze.pms.facade.service.sys.SysFunctionService;
import com.tenze.pms.facade.service.sys.SysMenuRoleService;
import com.tenze.pms.facade.service.sys.SysMenuService;
import com.tenze.utils.Dto;
import com.tenze.utils.JsonHelper;
import com.tenze.utils.SysConstants;

@Controller("SysPermAction")
@Scope(value="prototype")
public class SysPermAction extends BaseAction {
	
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysFunctionService sysFunctionService;
	@Autowired
	private SysMenuRoleService sysMenuRoleService;
	@Autowired
	private SysFunctionRoleService sysFunctionRoleService;
	
	private Long roleId;
	
	private String roleName;
	
	public String mng(){
		
		return INPUT_RESULT;
	}

	public String menu(){
		
		return INPUT_RESULT;
	}
	
	public String btnsPerm(){
		
		return INPUT_RESULT;
	}
	
	public String menuRoleData() throws IOException{
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("roleId", roleId);
		List<SysMenuRoleDto> list = sysMenuRoleService.listBy(params);
		write(JsonHelper.toJSON(list));
		return NULL_SUCCESS;
	}
	
	public String createMenuRoleList() throws IOException{
		List<SysMenuRoleDto> list;
		if(key==null || key.trim().length()<1){
			list = Collections.emptyList();
		}else{
			list = new ArrayList<SysMenuRoleDto>();
			String[] ids = key.split(",");
			SysMenuRoleDto mrDto;
			for (String id : ids) {
				mrDto = new SysMenuRoleDto();
				mrDto.setMenuId(Long.valueOf(id));
				mrDto.setRoleId(roleId);
				list.add(mrDto);
			}
		}
		long result = sysMenuRoleService.saveMenuRoleList(roleId, list);
		if(result<1){
			setFailureTipMsg("保存角色菜单权限失败");
		}else{
			setSuccessTipMsg();
		}
		return NULL_SUCCESS;
	}
	
	public String functionRoleData() throws IOException{
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("roleId", roleId);
		List<SysFunctionRoleDto> list = sysFunctionRoleService.listBy(params);
		write(JsonHelper.toJSON(list));
		return NULL_SUCCESS;
	}
	
	public String createFunctionRoleList() throws IOException{
		List<SysFunctionRoleDto> list;
		if(key==null || key.trim().length()<1){
			list = Collections.emptyList();
		}else{
			list = new ArrayList<SysFunctionRoleDto>();
			String[] ids = key.split(",");
			SysFunctionRoleDto mrDto;
			for (String id : ids) {
				mrDto = new SysFunctionRoleDto();
				mrDto.setFunctionId(Long.valueOf(id.trim()));
				mrDto.setRoleId(roleId);
				list.add(mrDto);
			}
		}
		long result = sysFunctionRoleService.saveFunctionRoleList(roleId, list);
		if(result<1){
			setFailureTipMsg("保存角色按钮权限失败");
		}else{
			setSuccessTipMsg();
		}
		return NULL_SUCCESS;
	}
	
	public String listRoleMenu() throws IOException{
        
        List<SysMenuDto> list = sysMenuService.listByRole(roleId);
        
        write(JsonHelper.toJSON(list));
        
        return NULL_SUCCESS;
    }
	
	public String roleMenuPerm() throws IOException{
        
        List<SysMenuDto> list = null; 
        
        Dto sessionDto = getUserInSession();
		String userRoleType = sessionDto.getAsString("roleType");
        if(SysConstants.SUPER_ROLE.equals(userRoleType)){
        	list = sysMenuService.listBy(new HashMap<String,Object>());
        }else{
        	Long userRoleId = sessionDto.getAsLong("roleId");
	        list = sysMenuService.listByRole(userRoleId);
        }
		
		
        write(JsonHelper.toJSON(list));
        
        return NULL_SUCCESS;
    }
	
	
	public String roleMenuFuncsPerm() throws IOException{
		List<SysFunctionDto> list = null;
		Dto sessionDto = getUserInSession();
		String userRoleType = sessionDto.getAsString("roleType");
		if(SysConstants.SUPER_ROLE.equals(userRoleType)){
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("menuId", mainMenuId);
			list = sysFunctionService.listBy(params);
		}else{
			Long userRoleId = sessionDto.getAsLong("roleId");
	        list = sysFunctionService.listRoleMenuFuncs(mainMenuId,userRoleId);
		}
        
        write(JsonHelper.toJSON(list));
        
        return NULL_SUCCESS;
    }
	
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
}
