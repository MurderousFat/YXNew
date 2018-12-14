package com.tenze.pms.facade.dto.his;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class HisInhospitalMasDto extends BaseEntity{

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
    /** 证件号码*/
    private String aac044;
    /** 离退休证号*/
    private String aac057;
    /** 转诊备案号*/
    private String yzz016;
    /** 就诊类别*/
    private String aka130;
    /** 住院号*/
    private String akc190;
    /** 住院次数*/
    private Integer akc090;
    /** 入院科室*/
    private String akf001;
    /** 入院床位*/
    private String ykc012;
    /** 入院诊断*/
    private String akc050;
    /** ICD10_1*/
    private String akc193;
    /** ICD10_2*/
    private String ykc601;
    /** ICD10_3*/
    private String ykc602;
    /** 生育备案审批号*/
    private String ckz564;
    /** 意外伤害标志*/
    private String ckc798;
    /** 二次返院传入标志*/
    private String ckc949;
    /** 入院日期*/
    private String ykc701;
    /** 联系电话*/
    private String aae005;
    /** 备注*/
    private String aae013;
    /** 入院方式*/
    private String inHospType;
    /** 医护人员公民身份号码*/
    private String aab014;
    /** 医疗个人结算类型*/
    private String ckc936;
    /** 单病种诊断*/
    private String ckc937;
    /** */
    private Long merchantId;
    /** 医院*/
    private String merchantName;
    /** 经办人*/
    private String jbrmc;
    /** 人员名称 */
    private String personName;
    /** 就诊记录 */
    private String aaz217;
    /** 单据状态 */
    private String hisBillState;
    /** 本次已付起付线 */
    private Float yka115;
    /** 费用结算序号 */
    private String ykc618;
    /** 费用结算类型 */
    private String ykc675;


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

    public void setAac044(String aac044){
        this.aac044 = aac044;
    }

    public String getAac044(){
        return this.aac044;
    }

    public void setAac057(String aac057){
        this.aac057 = aac057;
    }

    public String getAac057(){
        return this.aac057;
    }

    public void setYzz016(String yzz016){
        this.yzz016 = yzz016;
    }

    public String getYzz016(){
        return this.yzz016;
    }

    public void setAka130(String aka130){
        this.aka130 = aka130;
    }

    public String getAka130(){
        return this.aka130;
    }

    public void setAkc190(String akc190){
        this.akc190 = akc190;
    }

    public String getAkc190(){
        return this.akc190;
    }

    public void setAkc090(Integer akc090){
        this.akc090 = akc090;
    }

    public Integer getAkc090(){
        return this.akc090;
    }

    public void setAkf001(String akf001){
        this.akf001 = akf001;
    }

    public String getAkf001(){
        return this.akf001;
    }

    public void setYkc012(String ykc012){
        this.ykc012 = ykc012;
    }

    public String getYkc012(){
        return this.ykc012;
    }

    public void setAkc050(String akc050){
        this.akc050 = akc050;
    }

    public String getAkc050(){
        return this.akc050;
    }

    public void setAkc193(String akc193){
        this.akc193 = akc193;
    }

    public String getAkc193(){
        return this.akc193;
    }

    public void setYkc601(String ykc601){
        this.ykc601 = ykc601;
    }

    public String getYkc601(){
        return this.ykc601;
    }

    public void setYkc602(String ykc602){
        this.ykc602 = ykc602;
    }

    public String getYkc602(){
        return this.ykc602;
    }

    public void setCkz564(String ckz564){
        this.ckz564 = ckz564;
    }

    public String getCkz564(){
        return this.ckz564;
    }

    public void setCkc798(String ckc798){
        this.ckc798 = ckc798;
    }

    public String getCkc798(){
        return this.ckc798;
    }

    public void setCkc949(String ckc949){
        this.ckc949 = ckc949;
    }

    public String getCkc949(){
        return this.ckc949;
    }

    public void setYkc701(String ykc701){
        this.ykc701 = ykc701;
    }

    public String getYkc701(){
        return this.ykc701;
    }

    public void setAae005(String aae005){
        this.aae005 = aae005;
    }

    public String getAae005(){
        return this.aae005;
    }

    public void setAae013(String aae013){
        this.aae013 = aae013;
    }

    public String getAae013(){
        return this.aae013;
    }

    public void setInHospType(String inHospType){
        this.inHospType = inHospType;
    }

    public String getInHospType(){
        return this.inHospType;
    }

    public void setAab014(String aab014){
        this.aab014 = aab014;
    }

    public String getAab014(){
        return this.aab014;
    }

    public void setCkc936(String ckc936){
        this.ckc936 = ckc936;
    }

    public String getCkc936(){
        return this.ckc936;
    }

    public void setCkc937(String ckc937){
        this.ckc937 = ckc937;
    }

    public String getCkc937(){
        return this.ckc937;
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

    public void setJbrmc(String jbrmc){
        this.jbrmc = jbrmc;
    }

    public String getJbrmc(){
        return this.jbrmc;
    }

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getAaz217() {
		return aaz217;
	}

	public void setAaz217(String aaz217) {
		this.aaz217 = aaz217;
	}

	public String getHisBillState() {
		return hisBillState;
	}

	public void setHisBillState(String hisBillState) {
		this.hisBillState = hisBillState;
	}

	public Float getYka115() {
		return yka115;
	}

	public void setYka115(Float yka115) {
		this.yka115 = yka115;
	}

	public String getYkc618() {
		return ykc618;
	}

	public void setYkc618(String ykc618) {
		this.ykc618 = ykc618;
	}

	public String getYkc675() {
		return ykc675;
	}

	public void setYkc675(String ykc675) {
		this.ykc675 = ykc675;
	}

    
}