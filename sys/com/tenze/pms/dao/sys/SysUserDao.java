package com.tenze.pms.dao.sys;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.pms.facade.dto.sys.SysUserDto;

public interface SysUserDao extends BaseDao<SysUserDto>{

	long checkAccountExists(String account);
		
}