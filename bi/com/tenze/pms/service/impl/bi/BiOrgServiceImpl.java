package com.tenze.pms.service.impl.bi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.bi.BiOrgDao;
import com.tenze.pms.facade.dto.bi.BiOrgDto;
import com.tenze.pms.facade.service.bi.BiOrgService;


@Service("biOrgService")
public class BiOrgServiceImpl extends BaseServiceImpl<BiOrgDto> implements
        BiOrgService {
    
    @Autowired
    private BiOrgDao biOrgDao;

    @Override
    protected BaseDao<BiOrgDto> getDao() {
        return biOrgDao;
    }


}