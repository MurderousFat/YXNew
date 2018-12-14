package com.tenze.pms.facade.dto.bi;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class BiMerchantNoDto extends BaseEntity{

    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private Integer fdelFlag;
    private Long merId;
    private String merName;
    private String noName;
    private String merTenantName;

public BiMerchantNoDto(){}

public BiMerchantNoDto(Long id){this.id=id;}

public BiMerchantNoDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, Long merId, String merName, String noName){
         this.id = id;
         this.version = version;
         this.createtime = createtime;
         this.updatetime = updatetime;
         this.fdelFlag = fdelFlag;
         this.merId = merId;
         this.merName = merName;
         this.noName = noName;
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

    public void setMerId(Long merId){
        this.merId = merId;
    }

    public Long getMerId(){
        return this.merId;
    }

    public void setMerName(String merName){
        this.merName = merName;
    }

    public String getMerName(){
        return this.merName;
    }

    public void setNoName(String noName){
        this.noName = noName;
    }

    public String getNoName(){
        return this.noName;
    }

	public String getMerTenantName() {
		return merTenantName;
	}

	public void setMerTenantName(String merTenantName) {
		this.merTenantName = merTenantName;
	}

    
}