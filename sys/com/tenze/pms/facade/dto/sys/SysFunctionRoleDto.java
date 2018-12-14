package com.tenze.pms.facade.dto.sys;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class SysFunctionRoleDto extends BaseEntity{

    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private Integer fdelFlag;
    private Long functionId;
    private Long roleId;

public SysFunctionRoleDto(){}

public SysFunctionRoleDto(Long id){this.id=id;}

public SysFunctionRoleDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, Long functionId, Long roleId){
         this.id = id;
         this.version = version;
         this.createtime = createtime;
         this.updatetime = updatetime;
         this.fdelFlag = fdelFlag;
         this.functionId = functionId;
         this.roleId = roleId;
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

    public void setFunctionId(Long functionId){
        this.functionId = functionId;
    }

    public Long getFunctionId(){
        return this.functionId;
    }

    public void setRoleId(Long roleId){
        this.roleId = roleId;
    }

    public Long getRoleId(){
        return this.roleId;
    }

}