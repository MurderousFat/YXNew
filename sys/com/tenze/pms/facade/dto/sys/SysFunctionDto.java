package com.tenze.pms.facade.dto.sys;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class SysFunctionDto extends BaseEntity{

    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private Integer fdelFlag;
    private String functionName;
    private String functionBtn;
    private String functionUrl;
    private Integer sortNo;
    private Long menuId;
    private String enabled;

public SysFunctionDto(){}

public SysFunctionDto(Long id){this.id=id;}

public SysFunctionDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, String functionName, String functionBtn, String functionUrl, Integer sortNo, Long menuId, String enabled){
         this.id = id;
         this.version = version;
         this.createtime = createtime;
         this.updatetime = updatetime;
         this.fdelFlag = fdelFlag;
         this.functionName = functionName;
         this.functionBtn = functionBtn;
         this.functionUrl = functionUrl;
         this.sortNo = sortNo;
         this.menuId = menuId;
         this.enabled = enabled;
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

    public void setFunctionName(String functionName){
        this.functionName = functionName;
    }

    public String getFunctionName(){
        return this.functionName;
    }

    public void setFunctionBtn(String functionBtn){
        this.functionBtn = functionBtn;
    }

    public String getFunctionBtn(){
        return this.functionBtn;
    }

    public void setFunctionUrl(String functionUrl){
        this.functionUrl = functionUrl;
    }

    public String getFunctionUrl(){
        return this.functionUrl;
    }

    public void setSortNo(Integer sortNo){
        this.sortNo = sortNo;
    }

    public Integer getSortNo(){
        return this.sortNo;
    }

    public void setMenuId(Long menuId){
        this.menuId = menuId;
    }

    public Long getMenuId(){
        return this.menuId;
    }

    public void setEnabled(String enabled){
        this.enabled = enabled;
    }

    public String getEnabled(){
        return this.enabled;
    }

}