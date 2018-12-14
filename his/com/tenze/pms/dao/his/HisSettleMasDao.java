package com.tenze.pms.dao.his;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.pms.facade.dto.his.HisSettleMasDto;

public interface HisSettleMasDao extends BaseDao<HisSettleMasDto>{

	void updateHisStatus(Long id, String hisBillStatus);
	
	void updateFeeSettleMent(Long id, String hisBillStatus,String ykc618,Float selfPay);
}