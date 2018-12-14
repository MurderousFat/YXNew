package com.tenze.pms.facade.service.sys;

import com.tenze.background.common.core.service.BaseService;
import com.tenze.pms.facade.dto.sys.BaseUserDto;
import com.tenze.utils.Dto;

public interface BaseUserService extends BaseService<BaseUserDto> {
	
	BaseUserDto findByAccountPswd(String faccount,String fpassword);

}
