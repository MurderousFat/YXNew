package com.tenze.pms.facade.dto.bi;


import com.tenze.background.common.entity.BaseEntity;

import java.util.Date;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class BiRegionDto extends BaseEntity{

    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private Integer fdelFlag;
    private String rgnNo;
    private String rgnName;
    private String rgnFull;
    private String parentNo;
    private String parentName;
    private Byte expandedFlag;
    private Byte leafFlag;

public BiRegionDto(){}

public BiRegionDto(Long id){this.id=id;}

public BiRegionDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, String rgnNo, String rgnName, String rgnFull, String parentNo, String parentName, Byte expandedFlag, Byte leafFlag){
         this.id = id;
         this.version = version;
         this.createtime = createtime;
         this.updatetime = updatetime;
         this.fdelFlag = fdelFlag;
         this.rgnNo = rgnNo;
         this.rgnName = rgnName;
         this.rgnFull = rgnFull;
         this.parentNo = parentNo;
         this.parentName = parentName;
         this.expandedFlag = expandedFlag;
         this.leafFlag = leafFlag;
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

    public void setRgnName(String rgnName){
        this.rgnName = rgnName;
    }

    public String getRgnName(){
        return this.rgnName;
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

}