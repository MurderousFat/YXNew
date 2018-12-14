package com.tenze.pms.facade.service.sys;

import java.util.List;

import com.tenze.background.common.core.service.BaseService;
import com.tenze.pms.facade.dto.sys.SysMenuRoleDto;
import com.tenze.utils.Dto;

public interface SysMenuRoleService extends BaseService<SysMenuRoleDto> {
    
	long saveMenuRoleList(Long roleId, List<SysMenuRoleDto> list);
}