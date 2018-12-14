package com.tenze.pms.dao.impl.his;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tenze.background.common.core.dao.BaseDaoImpl;
import com.tenze.pms.dao.his.HisSettleMasDao;
import com.tenze.pms.facade.dto.his.HisSettleMasDto;

@Repository("hisSettleMasDao")
public class HisSettleMasDaoImpl extends BaseDaoImpl<HisSettleMasDto> implements HisSettleMasDao {

	@Override
	public void updateHisStatus(Long id, String hisBillStatus) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("id", id);
		params.put("hisBillState", hisBillStatus);
		this.getSessionTemplate().update(this.getStatement("updateHisStatus"),params);
	}

	@Override
	public void updateFeeSettleMent(Long id, String hisBillStatus,
			String ykc618, Float selfPay) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("id", id);
		params.put("hisBillState", hisBillStatus);
		params.put("ykc618", ykc618);
		params.put("selfPay", selfPay);
		long result = this.getSessionTemplate().update(this.getStatement("updateFeeSettleMent"),params);
		System.out.println(result);
	}

}