package com.tenze.pms.service.impl.his;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.background.facade.service.workid.WorkIdService;
import com.tenze.common.utils.CommonException;
import com.tenze.pms.dao.his.HisSettleMasDao;
import com.tenze.pms.facade.dto.his.HisSettleDtlDto;
import com.tenze.pms.facade.dto.his.HisSettleMasDto;
import com.tenze.pms.facade.service.his.HisSettleDtlService;
import com.tenze.pms.facade.service.his.HisSettleMasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("hisSettleMasService")
public class HisSettleMasServiceImpl extends BaseServiceImpl<HisSettleMasDto> implements
        HisSettleMasService {
    
    @Autowired
    private HisSettleMasDao hisSettleMasDao;
    @Autowired
    private HisSettleDtlService hisSettleDtiService;
    @Autowired
    private WorkIdService workIdService;
    

    @Override
    protected BaseDao<HisSettleMasDto> getDao() {
        return hisSettleMasDao;
    }

	@Override
	public long saveAll(String payload) {
		if(payload==null || payload.trim().length()==0)throw new CommonException("提交的数据为空");
		JSONObject jPayload = JSONObject.parseObject(payload);
		String jmas = jPayload.getString("mas");
		String jdtl = jPayload.getString("dtl");
		HisSettleMasDto mas = JSON.parseObject(jmas,HisSettleMasDto.class);

		//对金额进行处理
		List<HisSettleDtlDto> dtl = JSON.parseArray(jdtl, HisSettleDtlDto.class);
		if(mas.getAkc190()==null || mas.getAkc190().trim().length()<1){
			mas.setAkc190(String.valueOf(workIdService.nextId()));
		}
		mas.setHisBillState("0");
		
		long masId = this.save(mas);
		String ykc610;
		for (HisSettleDtlDto hisSettleDtlDto : dtl) {
			hisSettleDtlDto.setMasId(masId);
			if(hisSettleDtlDto.getYkc610()==null || hisSettleDtlDto.getYkc610().trim().length()<1){
				ykc610 = String.valueOf(workIdService.nextId());
				hisSettleDtlDto.setYkc610(ykc610.substring(ykc610.length()-11,ykc610.length()));
			}
			hisSettleDtiService.save(hisSettleDtlDto);
		}
		return masId;
	}

	@Override
	public void updateHisStatus(Long id, String hisBillStatus) {
		hisSettleMasDao.updateHisStatus(id, hisBillStatus);
	}

	@Override
	public void updateFeeSettleMent(Long id, String hisBillStatus,
			String ykc618, Float selfPay) {
		hisSettleMasDao.updateFeeSettleMent(id, hisBillStatus, ykc618, selfPay);
	}


    
}