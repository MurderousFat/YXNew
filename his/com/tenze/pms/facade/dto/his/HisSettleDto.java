package com.tenze.pms.facade.dto.his;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class HisSettleDto extends BaseEntity{

    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private Integer fdelFlag;
    private Long merId;
    private String merName;
    private String hisNo;
    private String settleType;
    private String settleNo;
    private String cnName;
    private String enName;
    private String commonName;
    private String preparation;
    private Long hisCatetoryId;
    private String hisCategoryName;
    private Float price;
    private Long unitId;
    private String unitName;
    private String internationalCode;
    private String mnemonicCode;
    private Date effectTime;
    private String remark;
    private String socialSecurityProjectCode;

public HisSettleDto(){}

public HisSettleDto(Long id){this.id=id;}

public HisSettleDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, Long merId, String merName, String hisNo, String settleType, String settleNo, String cnName, String enName, String commonName, String preparation, Long hisCatetoryId, String hisCategoryName, Float price, Long unitId, String unitName, String internationalCode, String mnemonicCode, Date effectTime, String remark, String socialSecurityProjectCode){
         this.id = id;
         this.version = version;
         this.createtime = createtime;
         this.updatetime = updatetime;
         this.fdelFlag = fdelFlag;
         this.merId = merId;
         this.merName = merName;
         this.hisNo = hisNo;
         this.settleType = settleType;
         this.settleNo = settleNo;
         this.cnName = cnName;
         this.enName = enName;
         this.commonName = commonName;
         this.preparation = preparation;
         this.hisCatetoryId = hisCatetoryId;
         this.hisCategoryName = hisCategoryName;
         this.price = price;
         this.unitId = unitId;
         this.unitName = unitName;
         this.internationalCode = internationalCode;
         this.mnemonicCode = mnemonicCode;
         this.effectTime = effectTime;
         this.remark = remark;
         this.socialSecurityProjectCode = socialSecurityProjectCode;
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

    public void setMerId(Long merId){
        this.merId = merId;
    }

    public Long getMerId(){
        return this.merId;
    }

    public void setMerName(String merName){
        this.merName = merName;
    }

    public String getMerName(){
        return this.merName;
    }

    public void setHisNo(String hisNo){
        this.hisNo = hisNo;
    }

    public String getHisNo(){
        return this.hisNo;
    }

    public void setSettleType(String settleType){
        this.settleType = settleType;
    }

    public String getSettleType(){
        return this.settleType;
    }

    public void setSettleNo(String settleNo){
        this.settleNo = settleNo;
    }

    public String getSettleNo(){
        return this.settleNo;
    }

    public void setCnName(String cnName){
        this.cnName = cnName;
    }

    public String getCnName(){
        return this.cnName;
    }

    public void setEnName(String enName){
        this.enName = enName;
    }

    public String getEnName(){
        return this.enName;
    }

    public void setCommonName(String commonName){
        this.commonName = commonName;
    }

    public String getCommonName(){
        return this.commonName;
    }

    public void setPreparation(String preparation){
        this.preparation = preparation;
    }

    public String getPreparation(){
        return this.preparation;
    }

    public void setHisCatetoryId(Long hisCatetoryId){
        this.hisCatetoryId = hisCatetoryId;
    }

    public Long getHisCatetoryId(){
        return this.hisCatetoryId;
    }

    public void setHisCategoryName(String hisCategoryName){
        this.hisCategoryName = hisCategoryName;
    }

    public String getHisCategoryName(){
        return this.hisCategoryName;
    }

    public void setPrice(Float price){
        this.price = price;
    }

    public Float getPrice(){
        return this.price;
    }

    public void setUnitId(Long unitId){
        this.unitId = unitId;
    }

    public Long getUnitId(){
        return this.unitId;
    }

    public void setUnitName(String unitName){
        this.unitName = unitName;
    }

    public String getUnitName(){
        return this.unitName;
    }

    public void setInternationalCode(String internationalCode){
        this.internationalCode = internationalCode;
    }

    public String getInternationalCode(){
        return this.internationalCode;
    }

    public void setMnemonicCode(String mnemonicCode){
        this.mnemonicCode = mnemonicCode;
    }

    public String getMnemonicCode(){
        return this.mnemonicCode;
    }

    public void setEffectTime(Date effectTime){
        this.effectTime = effectTime;
    }

    public Date getEffectTime(){
        return this.effectTime;
    }

    public void setRemark(String remark){
        this.remark = remark;
    }

    public String getRemark(){
        return this.remark;
    }

    public void setSocialSecurityProjectCode(String socialSecurityProjectCode){
        this.socialSecurityProjectCode = socialSecurityProjectCode;
    }

    public String getSocialSecurityProjectCode(){
        return this.socialSecurityProjectCode;
    }

}