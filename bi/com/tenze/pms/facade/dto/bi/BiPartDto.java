package com.tenze.pms.facade.dto.bi;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class BiPartDto extends BaseEntity{

    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private Integer fdelFlag;
    private String serialNumber;
    private String partName;
    private Long partTypeId;
    private String partTypeName;

public BiPartDto(){}

public BiPartDto(Long id){this.id=id;}

public BiPartDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, String serialNumber, String partName, Long partTypeId, String partTypeName){
         this.id = id;
         this.version = version;
         this.createtime = createtime;
         this.updatetime = updatetime;
         this.fdelFlag = fdelFlag;
         this.serialNumber = serialNumber;
         this.partName = partName;
         this.partTypeId = partTypeId;
         this.partTypeName = partTypeName;
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

    public void setSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber(){
        return this.serialNumber;
    }

    public void setPartName(String partName){
        this.partName = partName;
    }

    public String getPartName(){
        return this.partName;
    }

    public void setPartTypeId(Long partTypeId){
        this.partTypeId = partTypeId;
    }

    public Long getPartTypeId(){
        return this.partTypeId;
    }

    public void setPartTypeName(String partTypeName){
        this.partTypeName = partTypeName;
    }

    public String getPartTypeName(){
        return this.partTypeName;
    }

}