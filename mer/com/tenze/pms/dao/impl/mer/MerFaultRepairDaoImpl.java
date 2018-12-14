package com.tenze.pms.dao.impl.mer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tenze.background.common.core.dao.BaseDaoImpl;
import com.tenze.pms.dao.mer.MerFaultRepairDao;
import com.tenze.pms.facade.dto.mer.MerFaultRepairDto;

@Repository("merFaultRepairDao")
public class MerFaultRepairDaoImpl extends BaseDaoImpl<MerFaultRepairDto> implements MerFaultRepairDao {

	public long updateSeize(List<Long> ids) {
		return this.getSessionTemplate().update(getStatement("updateSeize"), ids);
	}
	
	public long updateReject(List<Long> ids) {
		return this.getSessionTemplate().update(getStatement("updateReject"), ids);
	}
}