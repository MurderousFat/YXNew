package com.tenze.pms.service.impl.his;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.pms.dao.his.HisConfigDao;
import com.tenze.pms.facade.dto.his.HisConfigDto;
import com.tenze.pms.facade.service.his.HisConfigService;

@Service("hisConfigService")
public class HisConfigServiceImpl extends
		BaseServiceImpl<HisConfigDto> implements HisConfigService {
	
	@Autowired
	private HisConfigDao hisConfigDao;
	
	@Override
	protected BaseDao<HisConfigDto> getDao() {
		return hisConfigDao;
	}

}
