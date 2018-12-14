package com.tenze.pms.service.impl.mer;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.mer.MerFaultRepairDao;
import com.tenze.pms.facade.dto.mer.MerFaultRepairDto;
import com.tenze.pms.facade.service.mer.MerFaultRepairService;
import com.tenze.utils.SysConstants;


@Service("merFaultRepairService")
public class MerFaultRepairServiceImpl extends BaseServiceImpl<MerFaultRepairDto> implements
        MerFaultRepairService {
    
    @Autowired
    private MerFaultRepairDao merFaultRepairDao;

    @Override
    protected BaseDao<MerFaultRepairDto> getDao() {
        return merFaultRepairDao;
    }

	@Override
	public long updateSeize(String acceptPerson,List<Long> ids) {
		MerFaultRepairDto m;
		for (Long id : ids) {
			m = this.getById(id);
			m.setAcceptState("1");
			m.setAcceptTime(new Date());
			m.setAcceptPerson(acceptPerson);
			this.save(m);
		}
		return SysConstants.BATCH_INSERT_SUCCESS;
	}

	@Override
	public long updateReject(String acceptPerson,List<Long> ids) {
		MerFaultRepairDto m;
		for (Long id : ids) {
			m = this.getById(id);
			m.setAcceptState("2");
			m.setAcceptTime(new Date());
			m.setAcceptPerson(acceptPerson);
			this.save(m);
		}
		return SysConstants.BATCH_INSERT_SUCCESS;
	}


}