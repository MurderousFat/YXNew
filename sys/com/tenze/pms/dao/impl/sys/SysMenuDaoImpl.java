package com.tenze.pms.dao.impl.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tenze.background.common.core.dao.BaseDaoImpl;
import com.tenze.background.common.exceptions.BizException;
import com.tenze.pms.dao.sys.SysMenuDao;
import com.tenze.pms.facade.dto.sys.SysMenuDto;

@Repository("sysMenuDao")
public class SysMenuDaoImpl extends BaseDaoImpl<SysMenuDto> implements SysMenuDao {

	@Override
	public String maxSeq(String parentNo) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("parentNo", parentNo);
		return this.getSessionTemplate().selectOne(this.getStatement("maxSeq"), params);
	}

	@Override
	public long updateSubMenu(String curMenuNo, String preMenuNo) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("curMenuNo", curMenuNo);
		params.put("preMenuNo", preMenuNo);
		return this.getSessionTemplate().update(this.getStatement("updateSubMenu"), params);
	}

	@Override
	public List<SysMenuDto> listByRole(Long roleId) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("roleId", roleId);
		return this.getSessionTemplate().selectList(this.getStatement("listByRole"), params);
	}
	
}