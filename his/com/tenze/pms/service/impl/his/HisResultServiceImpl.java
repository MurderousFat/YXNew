package com.tenze.pms.service.impl.his;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.his.HisResultDao;
import com.tenze.pms.facade.dto.his.HisResultDto;
import com.tenze.pms.facade.service.his.HisResultService;


@Service("hisResultService")
public class HisResultServiceImpl extends BaseServiceImpl<HisResultDto> implements
        HisResultService {
    
    @Autowired
    private HisResultDao hisResultDao;

    @Override
    protected BaseDao<HisResultDto> getDao() {
        return hisResultDao;
    }


}