package com.tenze.pms.facade.dto.sys;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class SysRoleDto extends BaseEntity{

    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private String roleNo;
    private String roleName;
    private String roleType;
    private String enabled;
    private Long unionId;
    private String unionName;
    private Long merchantId;
    private String merchantName;

public SysRoleDto(){}

public SysRoleDto(Long id){this.id=id;}

public SysRoleDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, String roleNo, String roleName, String roleType, String enabled){
         this.id = id;
         this.version = version;
         this.createtime = createtime;
         this.updatetime = updatetime;
         this.fdelFlag = fdelFlag;
         this.roleNo = roleNo;
         this.roleName = roleName;
         this.roleType = roleType;
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

    public void setRoleNo(String roleNo){
        this.roleNo = roleNo;
    }

    public String getRoleNo(){
        return this.roleNo;
    }

    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    public String getRoleName(){
        return this.roleName;
    }

    public void setRoleType(String roleType){
        this.roleType = roleType;
    }

    public String getRoleType(){
        return this.roleType;
    }

    public void setEnabled(String enabled){
        this.enabled = enabled;
    }

    public String getEnabled(){
        return this.enabled;
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

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

    
}