package com.tenze.pms.dao.sys;

import java.util.List;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.pms.facade.dto.sys.SysFunctionDto;

public interface SysFunctionDao extends BaseDao<SysFunctionDto>{

	long deleteByMenu(Long menuId);
	
	List<SysFunctionDto> listRoleMenuFuncs(Long menuId, Long roleId);
}