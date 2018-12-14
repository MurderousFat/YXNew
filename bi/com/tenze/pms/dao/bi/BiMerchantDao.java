package com.tenze.pms.dao.bi;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.pms.facade.dto.bi.BiMerchantDto;

import java.util.Map;

public interface BiMerchantDao extends BaseDao<BiMerchantDto> {

	String maxSeq(String parentNo);
	
	long updateSubMenu(String curMenuNo, String preMenuNo);

	public BiMerchantDto  getByRgnNo(Map<String, Object> params);

}