package com.tenze.pms.facade.service.sys;

import java.util.List;

import com.tenze.background.common.core.service.BaseService;
import com.tenze.pms.facade.dto.sys.SysMenuDto;
import com.tenze.utils.Dto;

public interface SysMenuService extends BaseService<SysMenuDto> {
	long saveWithParent(SysMenuDto menuDto);
	
	/**
	 * 根据角色获取菜单
	 * @param roleId
	 * @return
	 */
	List<SysMenuDto> listByRole(Long roleId);
}