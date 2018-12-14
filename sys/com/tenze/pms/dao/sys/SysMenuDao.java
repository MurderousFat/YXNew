package com.tenze.pms.dao.sys;

import java.util.List;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.pms.facade.dto.sys.SysMenuDto;

public interface SysMenuDao extends BaseDao<SysMenuDto>{

	String maxSeq(String parentNo);
	
	long updateSubMenu(String curMenuNo, String preMenuNo);
	
	List<SysMenuDto> listByRole(Long roleId);
}