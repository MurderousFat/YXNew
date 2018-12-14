package com.tenze.pms.facade.service.mer;

import java.util.List;

import com.tenze.background.common.core.service.BaseService;
import com.tenze.pms.facade.dto.mer.MerFaultRepairDto;
import com.tenze.utils.Dto;

public interface MerFaultRepairService extends BaseService<MerFaultRepairDto> {
    
	long updateSeize(String acceptPerson,List<Long> ids);
	long updateReject(String acceptPerson,List<Long> ids);
}