package com.tenze.pms.dao.impl.his;

import org.springframework.stereotype.Repository;

import com.tenze.background.common.core.dao.BaseDaoImpl;
import com.tenze.pms.dao.his.HisConfigDao;
import com.tenze.pms.facade.dto.his.HisConfigDto;

@Repository("hisConfigDao")
public class HisConfigDaoImpl extends BaseDaoImpl<HisConfigDto>
		implements HisConfigDao {


}
