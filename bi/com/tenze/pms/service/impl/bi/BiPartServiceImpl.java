package com.tenze.pms.service.impl.bi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.bi.BiPartDao;
import com.tenze.pms.facade.dto.bi.BiPartDto;
import com.tenze.pms.facade.service.bi.BiPartService;


@Service("biPartService")
public class BiPartServiceImpl extends BaseServiceImpl<BiPartDto> implements
        BiPartService {
    
    @Autowired
    private BiPartDao biPartDao;

    @Override
    protected BaseDao<BiPartDto> getDao() {
        return biPartDao;
    }


}