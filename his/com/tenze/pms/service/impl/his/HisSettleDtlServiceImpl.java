package com.tenze.pms.service.impl.his;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.his.HisSettleDtlDao;
import com.tenze.pms.facade.dto.his.HisSettleDtlDto;
import com.tenze.pms.facade.service.his.HisSettleDtlService;


@Service("hisSettleDtlService")
public class HisSettleDtlServiceImpl extends BaseServiceImpl<HisSettleDtlDto> implements
        HisSettleDtlService {
    
    @Autowired
    private HisSettleDtlDao hisSettleDtlDao;

    @Override
    protected BaseDao<HisSettleDtlDto> getDao() {
        return hisSettleDtlDao;
    }


}