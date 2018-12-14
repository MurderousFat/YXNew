package com.tenze.pms.dao.sys;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.pms.facade.dto.sys.SysMenuRoleDto;

public interface SysMenuRoleDao extends BaseDao<SysMenuRoleDto>{

	long deleteByRole(Long roleId);
}