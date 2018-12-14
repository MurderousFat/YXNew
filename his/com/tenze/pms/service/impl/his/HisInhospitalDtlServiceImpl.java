package com.tenze.pms.service.impl.his;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.his.HisInhospitalDtlDao;
import com.tenze.pms.facade.dto.his.HisInhospitalDtlDto;
import com.tenze.pms.facade.service.his.HisInhospitalDtlService;


@Service("hisInhospitalDtlService")
public class HisInhospitalDtlServiceImpl extends BaseServiceImpl<HisInhospitalDtlDto> implements
        HisInhospitalDtlService {
    
    @Autowired
    private HisInhospitalDtlDao hisInhospitalDtlDao;

    @Override
    protected BaseDao<HisInhospitalDtlDto> getDao() {
        return hisInhospitalDtlDao;
    }

	@Override
	public long saveAll(Long masId,List<HisInhospitalDtlDto> list) {
		for (HisInhospitalDtlDto dto : list) {
			dto.setMasId(masId);
			this.save(dto);
		}
		return 1;
	}


}