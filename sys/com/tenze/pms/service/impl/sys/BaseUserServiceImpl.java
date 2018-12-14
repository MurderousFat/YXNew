package com.tenze.pms.service.impl.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.sys.BaseUserDao;
import com.tenze.pms.facade.dto.sys.BaseUserDto;
import com.tenze.pms.facade.service.sys.BaseUserService;
import com.tenze.utils.Dto;

@Service("baseUserService")
public class BaseUserServiceImpl extends BaseServiceImpl<BaseUserDto> implements
		BaseUserService {
	
	@Autowired
	private BaseUserDao baseUserDao;

	@Override
	protected BaseDao<BaseUserDto> getDao() {
		return baseUserDao;
	}

	@Override
	public BaseUserDto findByAccountPswd(String faccount,String fpassword) {
		return baseUserDao.findByAccountPswd(faccount,fpassword);
	}

}
