package com.tenze.pms.facade.service.sys;

import java.util.List;

import com.tenze.background.common.core.service.BaseService;
import com.tenze.pms.facade.dto.sys.SysFunctionRoleDto;
import com.tenze.utils.Dto;

public interface SysFunctionRoleService extends BaseService<SysFunctionRoleDto> {

	long saveFunctionRoleList(Long roleId, List<SysFunctionRoleDto> list);
    
}