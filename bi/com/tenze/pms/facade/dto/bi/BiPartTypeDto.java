package com.tenze.pms.facade.dto.bi;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class BiPartTypeDto extends BaseEntity{

    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private Integer fdelFlag;
    private String typeNo;
    private String typeName;

public BiPartTypeDto(){}

public BiPartTypeDto(Long id){this.id=id;}

public BiPartTypeDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, String typeNo, String typeName){
         this.id = id;
         this.version = version;
         this.createtime = createtime;
         this.updatetime = updatetime;
         this.fdelFlag = fdelFlag;
         this.typeNo = typeNo;
         this.typeName = typeName;
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

    public void setTypeNo(String typeNo){
        this.typeNo = typeNo;
    }

    public String getTypeNo(){
        return this.typeNo;
    }

    public void setTypeName(String typeName){
        this.typeName = typeName;
    }

    public String getTypeName(){
        return this.typeName;
    }

}