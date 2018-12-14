package com.tenze.pms.facade.service.bi;

import com.tenze.background.common.core.service.BaseService;
import com.tenze.pms.facade.dto.bi.BiRegionDto;
import com.tenze.utils.Dto;

public interface BiRegionService extends BaseService<BiRegionDto> {
    
	long saveTree(BiRegionDto dto);
}