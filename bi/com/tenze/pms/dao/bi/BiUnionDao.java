package com.tenze.pms.dao.bi;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.pms.facade.dto.bi.BiUnionDto;

public interface BiUnionDao extends BaseDao<BiUnionDto>{

	String maxSeq(String parentNo);
	
	long updateSubMenu(String curMenuNo, String preMenuNo);
}