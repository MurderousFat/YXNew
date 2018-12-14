package com.tenze.pms.dao.impl.sys;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tenze.background.common.core.dao.BaseDaoImpl;
import com.tenze.pms.dao.sys.SysFunctionRoleDao;
import com.tenze.pms.facade.dto.sys.SysFunctionRoleDto;

@Repository("sysFunctionRoleDao")
public class SysFunctionRoleDaoImpl extends BaseDaoImpl<SysFunctionRoleDto> implements SysFunctionRoleDao {


	@Override
	public long deleteByRole(Long roleId) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("roleId", roleId);
		return this.getSessionTemplate().delete(this.getStatement("deleteByRole"),params);
	}

}