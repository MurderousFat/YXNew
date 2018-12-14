package com.tenze.pms.service.impl.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.common.utils.CommonException;
import com.tenze.pms.dao.sys.SysFunctionDao;
import com.tenze.pms.facade.dto.sys.SysFunctionDto;
import com.tenze.pms.facade.service.sys.SysFunctionService;


@Service("sysFunctionService")
public class SysFunctionServiceImpl extends BaseServiceImpl<SysFunctionDto> implements
        SysFunctionService {
    
    @Autowired
    private SysFunctionDao sysFunctionDao;

    @Override
    protected BaseDao<SysFunctionDto> getDao() {
        return sysFunctionDao;
    }

	@Override
	public void copyFunctions(Long srcMenuId, Long targetMenuId) {
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("menuId", srcMenuId);
			List<SysFunctionDto> list = this.listBy(params);
			if(list==null || list.size()==0){
				throw new CommonException("被复制对象没有按钮");
			}else{
				sysFunctionDao.deleteByMenu(targetMenuId);
				SysFunctionDto sfd;
				for (SysFunctionDto dto : list) {
					sfd = new SysFunctionDto();
					sfd.setMenuId(targetMenuId);
					sfd.setFunctionBtn(dto.getFunctionBtn());
					sfd.setFunctionName(dto.getFunctionName());
					sfd.setFunctionUrl("#");
					sfd.setSortNo(dto.getSortNo());
					sfd.setEnabled(dto.getEnabled());
					this.save(sfd);
				}
			}
	}

	@Override
	public List<SysFunctionDto> listRoleMenuFuncs(Long menuId, Long roleId) {
		return sysFunctionDao.listRoleMenuFuncs(menuId, roleId);
	}


}