package com.tenze.pms.facade.service.his;

import com.tenze.background.common.core.service.BaseService;
import com.tenze.pms.facade.dto.his.HisSettleMasDto;
import com.tenze.utils.Dto;

public interface HisSettleMasService extends BaseService<HisSettleMasDto> {
    
	long saveAll(String payload);
	
	void updateHisStatus(Long id, String hisBillStatus);
	
	void updateFeeSettleMent(Long id, String hisBillStatus,String ykc618,Float selfPay);
}