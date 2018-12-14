package com.tenze.pms.service.impl.bi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.bi.BiDeviceDao;
import com.tenze.pms.facade.dto.bi.BiDeviceDto;
import com.tenze.pms.facade.service.bi.BiDeviceService;


@Service("biDeviceService")
public class BiDeviceServiceImpl extends BaseServiceImpl<BiDeviceDto> implements
        BiDeviceService {
    
    @Autowired
    private BiDeviceDao biDeviceDao;

    @Override
    protected BaseDao<BiDeviceDto> getDao() {
        return biDeviceDao;
    }


}