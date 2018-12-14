package com.tenze.pms.service.impl.sys;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.sys.SysRoleDao;
import com.tenze.pms.facade.dto.sys.SysRoleDto;
import com.tenze.pms.facade.service.sys.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDto> implements
        SysRoleService {
    
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    protected BaseDao<SysRoleDto> getDao() {
        return sysRoleDao;
    }


}