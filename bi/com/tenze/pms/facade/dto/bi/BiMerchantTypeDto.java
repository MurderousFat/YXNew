package com.tenze.pms.facade.dto.bi;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class BiMerchantTypeDto extends BaseEntity{

    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private Integer fdelFlag;
    private String merNo;
    private String merName;
    private String type;
    private String standardFee;
    private String capAmount;

public BiMerchantTypeDto(){}

public BiMerchantTypeDto(Long id){this.id=id;}

public BiMerchantTypeDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, String merNo, String merName, String type, String standardFee, String capAmount){
         this.id = id;
         this.version = version;
         this.createtime = createtime;
         this.updatetime = updatetime;
         this.fdelFlag = fdelFlag;
         this.merNo = merNo;
         this.merName = merName;
         this.type = type;
         this.standardFee = standardFee;
         this.capAmount = capAmount;
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

    public void setMerNo(String merNo){
        this.merNo = merNo;
    }

    public String getMerNo(){
        return this.merNo;
    }

    public void setMerName(String merName){
        this.merName = merName;
    }

    public String getMerName(){
        return this.merName;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public void setStandardFee(String standardFee){
        this.standardFee = standardFee;
    }

    public String getStandardFee(){
        return this.standardFee;
    }

    public void setCapAmount(String capAmount){
        this.capAmount = capAmount;
    }

    public String getCapAmount(){
        return this.capAmount;
    }

}