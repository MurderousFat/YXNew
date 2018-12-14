package com.tenze.pms.service.impl.bi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.bi.BiMerchantNoDao;
import com.tenze.pms.facade.dto.bi.BiMerchantNoDto;
import com.tenze.pms.facade.service.bi.BiMerchantNoService;


@Service("biMerchantNoService")
public class BiMerchantNoServiceImpl extends BaseServiceImpl<BiMerchantNoDto> implements
        BiMerchantNoService {
    
    @Autowired
    private BiMerchantNoDao biMerchantNoDao;

    @Override
    protected BaseDao<BiMerchantNoDto> getDao() {
        return biMerchantNoDao;
    }


}