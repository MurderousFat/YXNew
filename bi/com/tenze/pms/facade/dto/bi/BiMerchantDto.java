package com.tenze.pms.facade.dto.bi;


import com.tenze.background.common.entity.BaseEntity;

import java.util.Date;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class BiMerchantDto extends BaseEntity{

    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private Integer fdelFlag;
    private String rgnNo;
    private String merName;
    private String rgnFull;
    private String parentNo;
    private String parentName;
    private Byte expandedFlag;
    private Byte leafFlag;
    private Long orgId;
    private String orgName;
    private Long rgnId;
    private String rgnName;
    private Long merTypeId;
    private String merTypeName;
    private String merAddr;
    private String merCertNo;
    private String merCertImage;
    private String merDepositBank;
    private String merDepositAccount;
    private String standardFee;
    private String capAmount;
    private String merContactPerson;
    private String merContactPhone;
    private String merContactDuty;
    private String lawer;
    private Long unionId;
    private String unionName;
    private String hisNo;
    private String phone;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getRgnId() {
        return rgnId;
    }

    public void setRgnId(Long rgnId) {
        this.rgnId = rgnId;
    }

    public String getRgnName() {
        return rgnName;
    }

    public void setRgnName(String rgnName) {
        this.rgnName = rgnName;
    }

    public Long getMerTypeId() {
        return merTypeId;
    }

    public void setMerTypeId(Long merTypeId) {
        this.merTypeId = merTypeId;
    }

    public String getMerTypeName() {
        return merTypeName;
    }

    public void setMerTypeName(String merTypeName) {
        this.merTypeName = merTypeName;
    }

    public String getMerAddr() {
        return merAddr;
    }

    public void setMerAddr(String merAddr) {
        this.merAddr = merAddr;
    }

    public String getMerCertNo() {
        return merCertNo;
    }

    public void setMerCertNo(String merCertNo) {
        this.merCertNo = merCertNo;
    }

    public String getMerCertImage() {
        return merCertImage;
    }

    public void setMerCertImage(String merCertImage) {
        this.merCertImage = merCertImage;
    }

    public String getMerDepositBank() {
        return merDepositBank;
    }

    public void setMerDepositBank(String merDepositBank) {
        this.merDepositBank = merDepositBank;
    }

    public String getMerDepositAccount() {
        return merDepositAccount;
    }

    public void setMerDepositAccount(String merDepositAccount) {
        this.merDepositAccount = merDepositAccount;
    }

    public String getStandardFee() {
        return standardFee;
    }

    public void setStandardFee(String standardFee) {
        this.standardFee = standardFee;
    }

    public String getCapAmount() {
        return capAmount;
    }

    public void setCapAmount(String capAmount) {
        this.capAmount = capAmount;
    }

    public String getMerContactPerson() {
        return merContactPerson;
    }

    public void setMerContactPerson(String merContactPerson) {
        this.merContactPerson = merContactPerson;
    }

    public String getMerContactPhone() {
        return merContactPhone;
    }

    public void setMerContactPhone(String merContactPhone) {
        this.merContactPhone = merContactPhone;
    }

    public String getMerContactDuty() {
        return merContactDuty;
    }

    public void setMerContactDuty(String merContactDuty) {
        this.merContactDuty = merContactDuty;
    }

    public String getLawer() {
        return lawer;
    }

    public void setLawer(String lawer) {
        this.lawer = lawer;
    }

    public Long getUnionId() {
        return unionId;
    }

    public void setUnionId(Long unionId) {
        this.unionId = unionId;
    }

    public String getUnionName() {
        return unionName;
    }

    public void setUnionName(String unionName) {
        this.unionName = unionName;
    }

    public String getHisNo() {
        return hisNo;
    }

    public void setHisNo(String hisNo) {
        this.hisNo = hisNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



public BiMerchantDto(){}

public BiMerchantDto(Long id){this.id=id;}

    public BiMerchantDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, String rgnNo, String merName, String rgnFull, String parentNo, String parentName, Byte expandedFlag, Byte leafFlag, Long orgId, String orgName, Long rgnId, String rgnName, Long merTypeId, String merTypeName, String merAddr, String merCertNo, String merCertImage, String merDepositBank, String merDepositAccount, String standardFee, String capAmount, String merContactPerson, String merContactPhone, String merContactDuty, String lawer, Long unionId, String unionName, String hisNo, String phone) {
        this.id = id;
        this.version = version;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.fdelFlag = fdelFlag;
        this.rgnNo = rgnNo;
        this.merName = merName;
        this.rgnFull = rgnFull;
        this.parentNo = parentNo;
        this.parentName = parentName;
        this.expandedFlag = expandedFlag;
        this.leafFlag = leafFlag;
        this.orgId = orgId;
        this.orgName = orgName;
        this.rgnId = rgnId;
        this.rgnName = rgnName;
        this.merTypeId = merTypeId;
        this.merTypeName = merTypeName;
        this.merAddr = merAddr;
        this.merCertNo = merCertNo;
        this.merCertImage = merCertImage;
        this.merDepositBank = merDepositBank;
        this.merDepositAccount = merDepositAccount;
        this.standardFee = standardFee;
        this.capAmount = capAmount;
        this.merContactPerson = merContactPerson;
        this.merContactPhone = merContactPhone;
        this.merContactDuty = merContactDuty;
        this.lawer = lawer;
        this.unionId = unionId;
        this.unionName = unionName;
        this.hisNo = hisNo;
        this.phone = phone;
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

    public void setRgnNo(String rgnNo){
        this.rgnNo = rgnNo;
    }

    public String getRgnNo(){
        return this.rgnNo;
    }

    public String getMerNames() {
        return merName;
    }

    public void setMerNames(String merNames) {
        this.merName = merName;
    }

    public void setRgnFull(String rgnFull){
        this.rgnFull = rgnFull;
    }

    public String getRgnFull(){
        return this.rgnFull;
    }

    public void setParentNo(String parentNo){
        this.parentNo = parentNo;
    }

    public String getParentNo(){
        return this.parentNo;
    }

    public void setParentName(String parentName){
        this.parentName = parentName;
    }

    public String getParentName(){
        return this.parentName;
    }

    public void setExpandedFlag(Byte expandedFlag){
        this.expandedFlag = expandedFlag;
    }

    public Byte getExpandedFlag(){
        return this.expandedFlag;
    }

    public void setLeafFlag(Byte leafFlag){
        this.leafFlag = leafFlag;
    }

    public Byte getLeafFlag(){
        return this.leafFlag;
    }

    public String getMerName() {
        return merName;
    }

    public void setMerName(String merName) {
        this.merName = merName;
    }
}