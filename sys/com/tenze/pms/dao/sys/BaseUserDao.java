package com.tenze.pms.dao.sys;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.pms.facade.dto.sys.BaseUserDto;

public interface BaseUserDao extends BaseDao<BaseUserDto>{

	BaseUserDto findByAccountPswd(String faccount,String fpassword);
}
