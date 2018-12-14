package com.tenze.pms.dao.impl.sys;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tenze.background.common.core.dao.BaseDaoImpl;
import com.tenze.pms.dao.sys.BaseUserDao;
import com.tenze.pms.facade.dto.sys.BaseUserDto;

@Repository("baseUserDao")
public class BaseUserDaoImpl extends BaseDaoImpl<BaseUserDto> implements BaseUserDao {

	@Override
	public BaseUserDto findByAccountPswd(String faccount,String fpassword) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("faccount", faccount);
		map.put("fpassword", fpassword);
		BaseUserDto baseUser = this.getSessionTemplate().selectOne(getStatement("findByAccountPswd"),map);
		return baseUser;
	}

}
