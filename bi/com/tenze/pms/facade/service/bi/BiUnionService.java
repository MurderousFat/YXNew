package com.tenze.pms.facade.service.bi;

import com.tenze.background.common.core.service.BaseService;
import com.tenze.pms.facade.dto.bi.BiUnionDto;
import com.tenze.utils.Dto;

public interface BiUnionService extends BaseService<BiUnionDto> {
    
	long saveTree(BiUnionDto dto);
}