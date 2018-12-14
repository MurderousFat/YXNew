package com.tenze.pms.dao.sys;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.pms.facade.dto.sys.SysRoleDto;

import java.util.List;
import java.util.Map;

public interface SysRoleDao extends BaseDao<SysRoleDto>{

    public List<SysRoleDto> getByMid(Map<String, Object> paramMap);

}