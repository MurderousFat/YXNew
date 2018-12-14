package com.tenze.pms.service.impl.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.sys.SysMenuRoleDao;
import com.tenze.pms.facade.dto.sys.SysMenuRoleDto;
import com.tenze.pms.facade.service.sys.SysMenuRoleService;
import com.tenze.utils.SysConstants;


@Service("sysMenuRoleService")
public class SysMenuRoleServiceImpl extends BaseServiceImpl<SysMenuRoleDto> implements
        SysMenuRoleService {
    
    @Autowired
    private SysMenuRoleDao sysMenuRoleDao;

    @Override
    protected BaseDao<SysMenuRoleDto> getDao() {
        return sysMenuRoleDao;
    }

	@Override
	public long saveMenuRoleList(Long roleId, List<SysMenuRoleDto> list) {
		sysMenuRoleDao.deleteByRole(roleId);
		for (SysMenuRoleDto sysMenuRoleDto : list) {
			this.save(sysMenuRoleDto);
		}
		return SysConstants.BATCH_INSERT_SUCCESS;
	}


}