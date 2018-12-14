package com.tenze.pms.service.impl.bi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.bi.BiMerchantTypeDao;
import com.tenze.pms.facade.dto.bi.BiMerchantTypeDto;
import com.tenze.pms.facade.service.bi.BiMerchantTypeService;


@Service("biMerchantTypeService")
public class BiMerchantTypeServiceImpl extends BaseServiceImpl<BiMerchantTypeDto> implements
        BiMerchantTypeService {
    
    @Autowired
    private BiMerchantTypeDao biMerchantTypeDao;

    @Override
    protected BaseDao<BiMerchantTypeDto> getDao() {
        return biMerchantTypeDao;
    }


}