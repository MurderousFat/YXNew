package com.tenze.pms.dao.impl.bi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tenze.background.common.core.dao.BaseDaoImpl;
import com.tenze.pms.dao.bi.BiUnionDao;
import com.tenze.pms.facade.dto.bi.BiUnionDto;

@Repository("biUnionDao")
public class BiUnionDaoImpl extends BaseDaoImpl<BiUnionDto> implements BiUnionDao {

	@Override
	public String maxSeq(String parentNo) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("parentNo", parentNo);
		return this.getSessionTemplate().selectOne(this.getStatement("maxSeq"), params);
	}

	@Override
	public long updateSubMenu(String curMenuNo, String preMenuNo) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("curMenuNo", curMenuNo);
		params.put("preMenuNo", preMenuNo);
		return this.getSessionTemplate().update(this.getStatement("updateSubMenu"), params);
	}
}