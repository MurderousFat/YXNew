package com.tenze.pms.facade.dto.his;

import com.tenze.background.common.entity.BaseEntity;

public class HisConfigDto extends BaseEntity{

	private String fhospitalName;
	
	private String fkey;
	
	private String fusername;
	
	private String fpassword;
	
	private Long merchantId;
	
	// 地区 县
	private String fcounty ;
	
	// 医院全称
	private String ffullName ;

	// 医院联系人
	private String hisPhone ;

	public String getHisPhone() {
		return hisPhone;
	}

	public void setHisPhone(String hisPhone) {
		this.hisPhone = hisPhone;
	}
	public String getFhospitalName() {
		return fhospitalName;
	}

	public void setFhospitalName(String fhospitalName) {
		this.fhospitalName = fhospitalName;
	}

	public String getFkey() {
		return fkey;
	}

	public void setFkey(String fkey) {
		this.fkey = fkey;
	}

	public String getFusername() {
		return fusername;
	}

	public void setFusername(String fusername) {
		this.fusername = fusername;
	}

	public String getFpassword() {
		return fpassword;
	}

	public void setFpassword(String fpassword) {
		this.fpassword = fpassword;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	
	public String getFcounty() {
		return fcounty;
	}

	public void setFcounty(String fcounty) {
		this.fcounty = fcounty;
	}

	public String getFfullName() {
		return ffullName;
	}

	public void setFfullName(String ffullName) {
		this.ffullName = ffullName;
	}
	
	
}
