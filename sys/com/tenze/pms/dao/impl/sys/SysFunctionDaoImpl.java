package com.tenze.pms.dao.impl.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tenze.background.common.core.dao.BaseDaoImpl;
import com.tenze.pms.dao.sys.SysFunctionDao;
import com.tenze.pms.facade.dto.sys.SysFunctionDto;

@Repository("sysFunctionDao")
public class SysFunctionDaoImpl extends BaseDaoImpl<SysFunctionDto> implements SysFunctionDao {

	@Override
	public long deleteByMenu(Long menuId) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("menuId", menuId);
		return this.getSessionTemplate().delete(this.getStatement("deleteByMenu"),params);
	}

	@Override
	public List<SysFunctionDto> listRoleMenuFuncs(Long menuId, Long roleId) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("menuId", menuId);
		params.put("roleId", roleId);
		return this.getSessionTemplate().selectList(this.getStatement("listRoleMenuFuncs"),params);
	}

}