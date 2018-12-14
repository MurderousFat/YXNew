package com.tenze.pms.facade.service.bi;

import com.tenze.background.common.core.service.BaseService;
import com.tenze.pms.facade.dto.bi.BiMerchantDto;

public interface BiMerchantService extends BaseService<BiMerchantDto> {

	long saveTree(BiMerchantDto dto);
}