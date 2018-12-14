package com.tenze.pms.service.impl.his;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.his.HisSsLogDao;
import com.tenze.pms.facade.dto.his.HisSsLogDto;
import com.tenze.pms.facade.service.his.HisSsLogService;


@Service("hisSsLogService")
public class HisSsLogServiceImpl extends BaseServiceImpl<HisSsLogDto> implements
        HisSsLogService {
    
    @Autowired
    private HisSsLogDao hisSsLogDao;

    @Override
    protected BaseDao<HisSsLogDto> getDao() {
        return hisSsLogDao;
    }


}