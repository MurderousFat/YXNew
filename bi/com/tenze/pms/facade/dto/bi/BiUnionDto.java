package com.tenze.pms.facade.dto.bi;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class BiUnionDto extends BaseEntity{

    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private Integer fdelFlag;
    private String unionNo;
    private String unionName;
    private String parentNo;
    private String parentName;
    private Byte expandedFlag;
    private Byte leafFlag;

public BiUnionDto(){}

public BiUnionDto(Long id){this.id=id;}

public BiUnionDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, String unionNo, String unionName, String parentNo, String parentName, Byte expandedFlag, Byte leafFlag){
         this.id = id;
         this.version = version;
         this.createtime = createtime;
         this.updatetime = updatetime;
         this.fdelFlag = fdelFlag;
         this.unionNo = unionNo;
         this.unionName = unionName;
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

    public void setUnionNo(String unionNo){
        this.unionNo = unionNo;
    }

    public String getUnionNo(){
        return this.unionNo;
    }

    public void setUnionName(String unionName){
        this.unionName = unionName;
    }

    public String getUnionName(){
        return this.unionName;
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