package com.tenze.pms.facade.dto.bi;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class BiDeviceDto extends BaseEntity{

    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private Integer fdelFlag;
    private String deviceNo;
    private Long merNoId;
    private String merNo;
    private String accessType;
    private String keySystem;
    private String keyIndex;
    private String venderName;
    private String serialNo;
    private Date mountTime;
    private String mountAddr;
    private String mountPerson;
    private String merName;

public BiDeviceDto(){}

public BiDeviceDto(Long id){this.id=id;}

public BiDeviceDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, String deviceNo, Long merNoId, String merNo, String accessType, String keySystem, String keyIndex, String venderName, String serialNo, Date mountTime, String mountAddr, String mountPerson){
         this.id = id;
         this.version = version;
         this.createtime = createtime;
         this.updatetime = updatetime;
         this.fdelFlag = fdelFlag;
         this.deviceNo = deviceNo;
         this.merNoId = merNoId;
         this.merNo = merNo;
         this.accessType = accessType;
         this.keySystem = keySystem;
         this.keyIndex = keyIndex;
         this.venderName = venderName;
         this.serialNo = serialNo;
         this.mountTime = mountTime;
         this.mountAddr = mountAddr;
         this.mountPerson = mountPerson;
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

    public void setDeviceNo(String deviceNo){
        this.deviceNo = deviceNo;
    }

    public String getDeviceNo(){
        return this.deviceNo;
    }

    public void setMerNoId(Long merNoId){
        this.merNoId = merNoId;
    }

    public Long getMerNoId(){
        return this.merNoId;
    }

    public void setMerNo(String merNo){
        this.merNo = merNo;
    }

    public String getMerNo(){
        return this.merNo;
    }

    public void setAccessType(String accessType){
        this.accessType = accessType;
    }

    public String getAccessType(){
        return this.accessType;
    }

    public void setKeySystem(String keySystem){
        this.keySystem = keySystem;
    }

    public String getKeySystem(){
        return this.keySystem;
    }

    public void setKeyIndex(String keyIndex){
        this.keyIndex = keyIndex;
    }

    public String getKeyIndex(){
        return this.keyIndex;
    }

    public void setVenderName(String venderName){
        this.venderName = venderName;
    }

    public String getVenderName(){
        return this.venderName;
    }

    public void setSerialNo(String serialNo){
        this.serialNo = serialNo;
    }

    public String getSerialNo(){
        return this.serialNo;
    }

    public void setMountTime(Date mountTime){
        this.mountTime = mountTime;
    }

    public Date getMountTime(){
        return this.mountTime;
    }

    public void setMountAddr(String mountAddr){
        this.mountAddr = mountAddr;
    }

    public String getMountAddr(){
        return this.mountAddr;
    }

    public void setMountPerson(String mountPerson){
        this.mountPerson = mountPerson;
    }

    public String getMountPerson(){
        return this.mountPerson;
    }

	public String getMerName() {
		return merName;
	}

	public void setMerName(String merName) {
		this.merName = merName;
	}
    

}