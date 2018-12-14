package com.tenze.pms.facade.dto.his;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class HisSettleDtlDto extends BaseEntity{

    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private Integer fdelFlag;
    private String ykc610;
    private String yka111;
    private String yka112;
    private String akc222y;
    private String akc223y;
    private Float akc226;
    private Float akc225;
    private Float akc264;
    private String akc221;
    private String aae011;
    private Long masId;
    private String masNo;
    private String aae311;

public HisSettleDtlDto(){}

public HisSettleDtlDto(Long id){this.id=id;}

public HisSettleDtlDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, String ykc610, String yka111, String yka112, String akc222y, String akc223y, Float akc226, Float akc225, Float akc264, String akc221, String aae011, Long masId, String masNo,String aae311){
         this.id = id;
         this.version = version;
         this.createtime = createtime;
         this.updatetime = updatetime;
         this.fdelFlag = fdelFlag;
         this.ykc610 = ykc610;
         this.yka111 = yka111;
         this.yka112 = yka112;
         this.akc222y = akc222y;
         this.akc223y = akc223y;
         this.akc226 = akc226;
         this.akc225 = akc225;
         this.akc264 = akc264;
         this.akc221 = akc221;
         this.aae011 = aae011;
         this.masId = masId;
         this.masNo = masNo;
         this.aae311 = aae311;
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

    public void setYkc610(String ykc610){
        this.ykc610 = ykc610;
    }

    public String getYkc610(){
        return this.ykc610;
    }

    public void setYka111(String yka111){
        this.yka111 = yka111;
    }

    public String getYka111(){
        return this.yka111;
    }

    public void setYka112(String yka112){
        this.yka112 = yka112;
    }

    public String getYka112(){
        return this.yka112;
    }

    public void setAkc222y(String akc222y){
        this.akc222y = akc222y;
    }

    public String getAkc222y(){
        return this.akc222y;
    }

    public void setAkc223y(String akc223y){
        this.akc223y = akc223y;
    }

    public String getAkc223y(){
        return this.akc223y;
    }

    public void setAkc226(Float akc226){
        this.akc226 = akc226;
    }

    public Float getAkc226(){
        return this.akc226;
    }

    public void setAkc225(Float akc225){
        this.akc225 = akc225;
    }

    public Float getAkc225(){
        return this.akc225;
    }

    public void setAkc264(Float akc264){
        this.akc264 = akc264;
    }

    public Float getAkc264(){
        return this.akc264;
    }

    public String getAkc221() {
		return akc221;
	}

	public void setAkc221(String akc221) {
		this.akc221 = akc221;
	}

	public void setAae011(String aae011){
        this.aae011 = aae011;
    }

    public String getAae011(){
        return this.aae011;
    }

    public void setMasId(Long masId){
        this.masId = masId;
    }

    public Long getMasId(){
        return this.masId;
    }

    public void setMasNo(String masNo){
        this.masNo = masNo;
    }

    public String getMasNo(){
        return this.masNo;
    }

	public String getAae311() {
		return aae311;
	}

	public void setAae311(String aae311) {
		this.aae311 = aae311;
	}

    
}