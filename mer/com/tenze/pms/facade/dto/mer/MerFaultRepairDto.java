package com.tenze.pms.facade.dto.mer;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class MerFaultRepairDto extends BaseEntity{

    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private Integer fdelFlag;
    private String merName;
    private String merNo;
    private Long deviceId;
    private String deviceNo;
    private String faultType;
    private String faultDesc;
    private String contactPerson;
    private String contactPhone;
    private String contactAddr;
    private String acceptState;
    private Date acceptTime;
    private String acceptPerson;

public MerFaultRepairDto(){}

public MerFaultRepairDto(Long id){this.id=id;}

public MerFaultRepairDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, String merName, String merNo, Long deviceId, String deviceNo, String faultType, String faultDesc, String contactPerson, String contactPhone, String contactAddr, String acceptState, Date acceptTime, String acceptPerson){
         this.id = id;
         this.version = version;
         this.createtime = createtime;
         this.updatetime = updatetime;
         this.fdelFlag = fdelFlag;
         this.merName = merName;
         this.merNo = merNo;
         this.deviceId = deviceId;
         this.deviceNo = deviceNo;
         this.faultType = faultType;
         this.faultDesc = faultDesc;
         this.contactPerson = contactPerson;
         this.contactPhone = contactPhone;
         this.contactAddr = contactAddr;
         this.acceptState = acceptState;
         this.acceptTime = acceptTime;
         this.acceptPerson = acceptPerson;
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

    public void setMerName(String merName){
        this.merName = merName;
    }

    public String getMerName(){
        return this.merName;
    }

    public void setMerNo(String merNo){
        this.merNo = merNo;
    }

    public String getMerNo(){
        return this.merNo;
    }

    public void setDeviceId(Long deviceId){
        this.deviceId = deviceId;
    }

    public Long getDeviceId(){
        return this.deviceId;
    }

    public void setDeviceNo(String deviceNo){
        this.deviceNo = deviceNo;
    }

    public String getDeviceNo(){
        return this.deviceNo;
    }

    public void setFaultType(String faultType){
        this.faultType = faultType;
    }

    public String getFaultType(){
        return this.faultType;
    }

    public void setFaultDesc(String faultDesc){
        this.faultDesc = faultDesc;
    }

    public String getFaultDesc(){
        return this.faultDesc;
    }

    public void setContactPerson(String contactPerson){
        this.contactPerson = contactPerson;
    }

    public String getContactPerson(){
        return this.contactPerson;
    }

    public void setContactPhone(String contactPhone){
        this.contactPhone = contactPhone;
    }

    public String getContactPhone(){
        return this.contactPhone;
    }

    public void setContactAddr(String contactAddr){
        this.contactAddr = contactAddr;
    }

    public String getContactAddr(){
        return this.contactAddr;
    }

    public void setAcceptState(String acceptState){
        this.acceptState = acceptState;
    }

    public String getAcceptState(){
        return this.acceptState;
    }

    public void setAcceptTime(Date acceptTime){
        this.acceptTime = acceptTime;
    }

    public Date getAcceptTime(){
        return this.acceptTime;
    }

    public void setAcceptPerson(String acceptPerson){
        this.acceptPerson = acceptPerson;
    }

    public String getAcceptPerson(){
        return this.acceptPerson;
    }

}