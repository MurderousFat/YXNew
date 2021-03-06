package com.tenze.pms.service.impl.bi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.bi.BiOrgTypeDao;
import com.tenze.pms.facade.dto.bi.BiOrgTypeDto;
import com.tenze.pms.facade.service.bi.BiOrgTypeService;


@Service("biOrgTypeService")
public class BiOrgTypeServiceImpl extends BaseServiceImpl<BiOrgTypeDto> implements
        BiOrgTypeService {
    
    @Autowired
    private BiOrgTypeDao biOrgTypeDao;

    @Override
    protected BaseDao<BiOrgTypeDto> getDao() {
        return biOrgTypeDao;
    }


}