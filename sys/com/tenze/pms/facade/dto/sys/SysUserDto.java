package com.tenze.pms.facade.dto.sys;


import com.tenze.background.common.entity.BaseEntity;

import java.util.Date;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class SysUserDto extends BaseEntity{


    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private Integer fdelFlag;
    private String account;
    private String username;
    private String password;
    private String confirmPassword;
    private String enabled;
    private Long roleId;
    private String roleName;
    private String remark;
    private Long unionId;
    private Long merchantId;
    private String unionName;
    private String merchantName;
    private String unionNo;

    //新的添加
    private String address;
    private String villTown;
    private String adminVill;
    private String hisName;
    private Integer hisGender;
    private String hisAge;
    private String hisSfzh;
    private String mphone;
    private Integer edu;
    private Integer isHis;
    private String hisCert;

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    private Integer isminimerchant;
    private String isminimerchantCode;
    private String isminimerchantCodePri;

    public String getAddress() {
        return address;
    }

    public Integer getIsminimerchant() {
        return isminimerchant;
    }

    public void setIsminimerchant(Integer isminimerchant) {
        this.isminimerchant = isminimerchant;
    }

    public String getIsminimerchantCode() {
        return isminimerchantCode;
    }

    public void setIsminimerchantCode(String isminimerchantCode) {
        this.isminimerchantCode = isminimerchantCode;
    }

    public String getIsminimerchantCodePri() {
        return isminimerchantCodePri;
    }

    public void setIsminimerchantCodePri(String isminimerchantCodePri) {
        this.isminimerchantCodePri = isminimerchantCodePri;
    }

    public String getVillTown() {
        return villTown;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setVillTown(String villTown) {
        this.villTown = villTown;
    }

    public String getAdminVill() {
        return adminVill;
    }

    public void setAdminVill(String adminVill) {
        this.adminVill = adminVill;
    }

    public String getHisName() {
        return hisName;
    }

    public void setHisName(String hisName) {
        this.hisName = hisName;
    }

    public Integer getHisGender() {
        return hisGender;
    }

    public void setHisGender(Integer hisGender) {
        this.hisGender = hisGender;
    }

    public String getHisAge() {
        return hisAge;
    }

    public void setHisAge(String hisAge) {
        this.hisAge = hisAge;
    }

    public String getHisSfzh() {
        return hisSfzh;
    }

    public void setHisSfzh(String hisSfzh) {
        this.hisSfzh = hisSfzh;
    }

    public Integer getEdu() {
        return edu;
    }

    public void setEdu(Integer edu) {
        this.edu = edu;
    }

    public Integer getIsHis() {
        return isHis;
    }

    public void setIsHis(Integer isHis) {
        this.isHis = isHis;
    }

    public String getHisCert() {
        return hisCert;
    }

    public void setHisCert(String hisCert) {
        this.hisCert = hisCert;
    }

    public String getHisStart() {
        return hisStart;
    }

    public void setHisStart(String hisStart) {
        this.hisStart = hisStart;
    }

    private String hisStart;

public SysUserDto(){
}

public SysUserDto(Long id){this.id=id;}

public SysUserDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, String account, String username, String password, String enabled, Long roleId, String remark){
         this.id = id;
         this.version = version;
         this.createtime = createtime;
         this.updatetime = updatetime;
         this.fdelFlag = fdelFlag;
         this.account = account;
         this.username = username;
         this.password = password;
         this.enabled = enabled;
         this.roleId = roleId;
         this.remark = remark;
}

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    public void setVersion(Integer version){
        this.version = version;
    }

    public Integer getVersion(){
        return this.version;
    }

    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }

    public Date getCreatetime(){
        return this.createtime;
    }

    public void setUpdatetime(Date updatetime){
        this.updatetime = updatetime;
    }

    public Date getUpdatetime(){
        return this.updatetime;
    }

    public void setFdelFlag(Integer fdelFlag){
        this.fdelFlag = fdelFlag;
    }

    public Integer getFdelFlag(){
        return this.fdelFlag;
    }

    public void setAccount(String account){
        this.account = account;
    }

    public String getAccount(){
        return this.account;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setEnabled(String enabled){
        this.enabled = enabled;
    }

    public String getEnabled(){
        return this.enabled;
    }

    public void setRoleId(Long roleId){
        this.roleId = roleId;
    }

    public Long getRoleId(){
        return this.roleId;
    }

    public void setRemark(String remark){
        this.remark = remark;
    }

    public String getRemark(){
        return this.remark;
    }

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getUnionId() {
		return unionId;
	}

	public void setUnionId(Long unionId) {
		this.unionId = unionId;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public String getUnionName() {
		return unionName;
	}

	public void setUnionName(String unionName) {
		this.unionName = unionName;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getUnionNo() {
		return unionNo;
	}

	public void setUnionNo(String unionNo) {
		this.unionNo = unionNo;
	}
    
	

}