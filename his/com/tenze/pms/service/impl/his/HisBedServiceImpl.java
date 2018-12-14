package com.tenze.pms.service.impl.his;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.his.HisBedDao;
import com.tenze.pms.facade.dto.his.HisBedDto;
import com.tenze.pms.facade.service.his.HisBedService;


@Service("hisBedService")
public class HisBedServiceImpl extends BaseServiceImpl<HisBedDto> implements
        HisBedService {
    
    @Autowired
    private HisBedDao hisBedDao;

    @Override
    protected BaseDao<HisBedDto> getDao() {
        return hisBedDao;
    }


}