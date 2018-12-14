package com.tenze.pms.service.impl.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.sys.SysFunctionRoleDao;
import com.tenze.pms.facade.dto.sys.SysFunctionRoleDto;
import com.tenze.pms.facade.service.sys.SysFunctionRoleService;
import com.tenze.utils.SysConstants;


@Service("sysFunctionRoleService")
public class SysFunctionRoleServiceImpl extends BaseServiceImpl<SysFunctionRoleDto> implements
        SysFunctionRoleService {
    
    @Autowired
    private SysFunctionRoleDao sysFunctionRoleDao;

    @Override
    protected BaseDao<SysFunctionRoleDto> getDao() {
        return sysFunctionRoleDao;
    }

	@Override
	public long saveFunctionRoleList(Long roleId, List<SysFunctionRoleDto> list) {
		sysFunctionRoleDao.deleteByRole(roleId);
		for (SysFunctionRoleDto sfrDto : list) {
			this.save(sfrDto);
		}
		return SysConstants.BATCH_INSERT_SUCCESS;
	}


}