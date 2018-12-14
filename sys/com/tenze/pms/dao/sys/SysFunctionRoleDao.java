package com.tenze.pms.dao.sys;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.pms.facade.dto.sys.SysFunctionRoleDto;

public interface SysFunctionRoleDao extends BaseDao<SysFunctionRoleDto>{

	long deleteByRole(Long roleId);
}