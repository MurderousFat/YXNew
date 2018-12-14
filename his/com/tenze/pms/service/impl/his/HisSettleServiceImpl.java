package com.tenze.pms.service.impl.his;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.his.HisSettleDao;
import com.tenze.pms.facade.dto.his.HisSettleDto;
import com.tenze.pms.facade.service.his.HisSettleService;


@Service("hisSettleService")
public class HisSettleServiceImpl extends BaseServiceImpl<HisSettleDto> implements
        HisSettleService {
    
    @Autowired
    private HisSettleDao hisSettleDao;

    @Override
    protected BaseDao<HisSettleDto> getDao() {
        return hisSettleDao;
    }


}