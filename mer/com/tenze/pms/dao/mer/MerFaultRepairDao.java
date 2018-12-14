package com.tenze.pms.dao.mer;

import java.util.List;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.pms.facade.dto.mer.MerFaultRepairDto;

public interface MerFaultRepairDao extends BaseDao<MerFaultRepairDto>{

	long updateSeize(List<Long> ids);
	long updateReject(List<Long> ids);
}