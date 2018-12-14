package com.tenze.pms.dao.bi;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.pms.facade.dto.bi.BiRegionDto;

public interface BiRegionDao extends BaseDao<BiRegionDto>{

	String maxSeq(String parentNo);
	
	long updateSubMenu(String curMenuNo, String preMenuNo);
}