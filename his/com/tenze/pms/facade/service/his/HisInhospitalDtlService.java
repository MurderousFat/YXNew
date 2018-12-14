package com.tenze.pms.facade.service.his;

import java.util.List;

import com.tenze.background.common.core.service.BaseService;
import com.tenze.pms.facade.dto.his.HisInhospitalDtlDto;

public interface HisInhospitalDtlService extends BaseService<HisInhospitalDtlDto> {
    
	public long saveAll(Long masId, List<HisInhospitalDtlDto> list);
}