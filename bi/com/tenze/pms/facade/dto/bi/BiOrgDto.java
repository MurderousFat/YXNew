package com.tenze.pms.facade.dto.bi;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class BiOrgDto extends BaseEntity{

    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private Integer fdelFlag;
    private String orgNo;
    private String orgName;
    private String acqPerm;
    private String issuePerm;
    private String forwardPerm;
    private Long orgTypeId;
    private String orgTypeName;

public BiOrgDto(){}

public BiOrgDto(Long id){this.id=id;}

public BiOrgDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, String orgNo, String orgName, String acqPerm, String issuePerm, String forwardPerm, Long orgTypeId, String orgTypeName){
         this.id = id;
         this.version = version;
         this.createtime = createtime;
         this.updatetime = updatetime;
         this.fdelFlag = fdelFlag;
         this.orgNo = orgNo;
         this.orgName = orgName;
         this.acqPerm = acqPerm;
         this.issuePerm = issuePerm;
         this.forwardPerm = forwardPerm;
         this.orgTypeId = orgTypeId;
         this.orgTypeName = orgTypeName;
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

    public void setOrgNo(String orgNo){
        this.orgNo = orgNo;
    }

    public String getOrgNo(){
        return this.orgNo;
    }

    public void setOrgName(String orgName){
        this.orgName = orgName;
    }

    public String getOrgName(){
        return this.orgName;
    }

    public void setAcqPerm(String acqPerm){
        this.acqPerm = acqPerm;
    }

    public String getAcqPerm(){
        return this.acqPerm;
    }

    public void setIssuePerm(String issuePerm){
        this.issuePerm = issuePerm;
    }

    public String getIssuePerm(){
        return this.issuePerm;
    }

    public void setForwardPerm(String forwardPerm){
        this.forwardPerm = forwardPerm;
    }

    public String getForwardPerm(){
        return this.forwardPerm;
    }

    public void setOrgTypeId(Long orgTypeId){
        this.orgTypeId = orgTypeId;
    }

    public Long getOrgTypeId(){
        return this.orgTypeId;
    }

    public void setOrgTypeName(String orgTypeName){
        this.orgTypeName = orgTypeName;
    }

    public String getOrgTypeName(){
        return this.orgTypeName;
    }

}