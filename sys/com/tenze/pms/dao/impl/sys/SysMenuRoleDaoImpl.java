package com.tenze.pms.dao.impl.sys;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tenze.background.common.core.dao.BaseDaoImpl;
import com.tenze.pms.dao.sys.SysMenuRoleDao;
import com.tenze.pms.facade.dto.sys.SysMenuRoleDto;

@Repository("sysMenuRoleDao")
public class SysMenuRoleDaoImpl extends BaseDaoImpl<SysMenuRoleDto> implements SysMenuRoleDao {

	@Override
	public long deleteByRole(Long roleId) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("roleId", roleId);
		return this.getSessionTemplate().delete(this.getStatement("deleteByRole"),params);
	}

}