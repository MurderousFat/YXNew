package com.tenze.pms.service.impl.his;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.his.HisFeeSettleDao;
import com.tenze.pms.facade.dto.his.HisFeeSettleDto;
import com.tenze.pms.facade.service.his.HisFeeSettleService;


@Service("hisFeeSettleService")
public class HisFeeSettleServiceImpl extends BaseServiceImpl<HisFeeSettleDto> implements
        HisFeeSettleService {
    
    @Autowired
    private HisFeeSettleDao hisFeeSettleDao;

    @Override
    protected BaseDao<HisFeeSettleDto> getDao() {
        return hisFeeSettleDao;
    }


}