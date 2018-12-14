package com.tenze.pms.facade.service.sys;

import java.util.List;

import com.tenze.background.common.core.service.BaseService;
import com.tenze.pms.facade.dto.sys.SysFunctionDto;
import com.tenze.utils.Dto;

public interface SysFunctionService extends BaseService<SysFunctionDto> {

	void copyFunctions(Long srcMenuId, Long targetMenuId);
    
	List<SysFunctionDto> listRoleMenuFuncs(Long menuId, Long roleId);
}