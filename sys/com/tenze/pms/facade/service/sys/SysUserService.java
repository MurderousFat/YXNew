package com.tenze.pms.facade.service.sys;

import com.tenze.background.common.core.service.BaseService;
import com.tenze.pms.facade.dto.sys.SysUserDto;
import com.tenze.utils.Dto;

public interface SysUserService extends BaseService<SysUserDto> {
	long saveUser(SysUserDto sysUserDto);
}