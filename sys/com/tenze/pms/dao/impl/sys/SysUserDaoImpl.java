package com.tenze.pms.dao.impl.sys;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tenze.background.common.core.dao.BaseDaoImpl;
import com.tenze.common.utils.Md5;
import com.tenze.pms.dao.sys.SysUserDao;
import com.tenze.pms.facade.dto.sys.SysUserDto;

@Repository("sysUserDao")
public class SysUserDaoImpl extends BaseDaoImpl<SysUserDto> implements SysUserDao {

	@Override
	public long checkAccountExists(String account) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("account", account);
		return this.getSessionTemplate().selectOne(this.getStatement("checkAccountExists"),params);
	}

}