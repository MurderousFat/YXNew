package com.tenze.pms.facade.dto.his;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class HisInhospitalDtlDto extends BaseEntity{

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
    /** 监控使用标志*/
    private String aka185;
    /** */
    private String ykc610;
    /** 大类代码*/
    private String yka111;
    /** 大类名称*/
    private String yka112;
    /** 医院*/
    private String akc222y;
    /** 医院项目名称*/
    private String akc223y;
    /** 数量*/
    private Float akc226;
    /** 单价*/
    private Float akc225;
    /** 医疗费用总额*/
    private Float akc264;
    /** 处方单据时间*/
    private String akc221;
    /** 嵌入式用户编码*/
    private String aae011;
    /** */
    private Long masId;
    /** 处方传送标志 */
    private Integer sendFlag;


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

    public void setAka185(String aka185){
        this.aka185 = aka185;
    }

    public String getAka185(){
        return this.aka185;
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

    public void setAkc221(String akc221){
        this.akc221 = akc221;
    }

    public String getAkc221(){
        return this.akc221;
    }

    public void setAae011(String aae011){
        this.aae011 = aae011;
    }

    public String getAae011(){
        return this.aae011;
    }

	public Long getMasId() {
		return masId;
	}

	public void setMasId(Long masId) {
		this.masId = masId;
	}

	public Integer getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(Integer sendFlag) {
		this.sendFlag = sendFlag;
	}


}