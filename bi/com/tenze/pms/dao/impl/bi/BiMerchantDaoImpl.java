package com.tenze.pms.dao.impl.bi;

import com.tenze.background.common.core.dao.BaseDaoImpl;
import com.tenze.pms.dao.bi.BiMerchantDao;
import com.tenze.pms.facade.dto.bi.BiMerchantDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("biMerchantDao")
public class BiMerchantDaoImpl extends BaseDaoImpl<BiMerchantDto> implements BiMerchantDao {

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

	@Override
	public BiMerchantDto getByRgnNo(Map<String,Object> params) {
		return this.getSessionTemplate().selectOne(this.getStatement("getByRgnNo"), params);
	}

}