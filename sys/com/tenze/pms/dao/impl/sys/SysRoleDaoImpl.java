package com.tenze.pms.dao.impl.sys;

import com.tenze.background.common.core.dao.BaseDaoImpl;
import com.tenze.pms.dao.sys.SysRoleDao;
import com.tenze.pms.facade.dto.sys.SysRoleDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("sysRoleDao")
public class SysRoleDaoImpl extends BaseDaoImpl<SysRoleDto> implements SysRoleDao {

    @Override
    public List<SysRoleDto> getByMid(Map<String, Object> paramMap) {
        return this.getSessionTemplate().selectList("getByMid", paramMap);
    }
}