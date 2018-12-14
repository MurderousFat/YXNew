package com.tenze.pms.facade.dto.his;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class HisBedDto extends BaseEntity{

    /** */
    private Long id;
    /** */
    private Integer version;
    /** */
    private Date createtime;
    /** */
    private Date updatetime;
    /** */
    private Integer fdelFlag;
    /** */
    private Long merchantId;
    /** 商家名称*/
    private String merchantName;
    /** 床位编号*/
    private String bedNo;
    /** 床位名称*/
    private String bedName;
    /** 所属建筑*/
    private String building;
    /** 所属楼层*/
    private String storey;
    /** 备注*/
    private String remark;


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

    public void setMerchantId(Long merchantId){
        this.merchantId = merchantId;
    }

    public Long getMerchantId(){
        return this.merchantId;
    }

    public void setMerchantName(String merchantName){
        this.merchantName = merchantName;
    }

    public String getMerchantName(){
        return this.merchantName;
    }

    public void setBedNo(String bedNo){
        this.bedNo = bedNo;
    }

    public String getBedNo(){
        return this.bedNo;
    }

    public void setBedName(String bedName){
        this.bedName = bedName;
    }

    public String getBedName(){
        return this.bedName;
    }

    public void setBuilding(String building){
        this.building = building;
    }

    public String getBuilding(){
        return this.building;
    }

    public void setStorey(String storey){
        this.storey = storey;
    }

    public String getStorey(){
        return this.storey;
    }

    public void setRemark(String remark){
        this.remark = remark;
    }

    public String getRemark(){
        return this.remark;
    }

}