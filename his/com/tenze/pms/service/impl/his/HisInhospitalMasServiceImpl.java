package com.tenze.pms.service.impl.his;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.his.HisInhospitalMasDao;
import com.tenze.pms.facade.dto.his.HisInhospitalMasDto;
import com.tenze.pms.facade.service.his.HisInhospitalMasService;


@Service("hisInhospitalMasService")
public class HisInhospitalMasServiceImpl extends BaseServiceImpl<HisInhospitalMasDto> implements
        HisInhospitalMasService {
    
    @Autowired
    private HisInhospitalMasDao hisInhospitalMasDao;

    @Override
    protected BaseDao<HisInhospitalMasDto> getDao() {
        return hisInhospitalMasDao;
    }


}