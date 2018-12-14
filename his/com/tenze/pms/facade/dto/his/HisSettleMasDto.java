package com.tenze.pms.facade.dto.his;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class HisSettleMasDto extends BaseEntity{

    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private Integer fdelFlag;
    private String aac044;
    private String aac057;
    private String aka130;
    private String akc050;
    private String ckz564;
    private String aaa138;
    private String ckc803;
    private String yzz016;
    private String aac005;
    private String cab053;
    private Date ake007;
    private String aae013;
    private Integer akc090;
    private String akc220;
    private String aab014;
    private Float akc264;
    private String akc190;
    private String jbrmc;
    private String ckz543;
    private String aae011;
    private String sessionid;
    private String jmc;
    private String hisBillState;
    private Long merchantId;
    private String merchantName;
    private String aaz217;
    private String ykc675;//结算类型
    private String ykc618;//结算业务号
    private String aac004;
    private String personName;
    private String settleTypeFlag;
    private Float selfPay;
    private String xybOrderNo;

public HisSettleMasDto(){}

public HisSettleMasDto(Long id){this.id=id;}

public HisSettleMasDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, String aac044, String aac057, String aka130, String akc050, String ckz564, String aaa138, String ckc803, String yzz016, String aac005, String cab053, Date ake007, String aae013, Integer akc090, String akc220, String aab014, Float akc264, String akc190, String jbrmc, String ckz543, String aae011, String sessionid, String jmc, String hisBillState){
         this.id = id;
         this.version = version;
         this.createtime = createtime;
         this.updatetime = updatetime;
         this.fdelFlag = fdelFlag;
         this.aac044 = aac044;
         this.aac057 = aac057;
         this.aka130 = aka130;
         this.akc050 = akc050;
         this.ckz564 = ckz564;
         this.aaa138 = aaa138;
         this.ckc803 = ckc803;
         this.yzz016 = yzz016;
         this.aac005 = aac005;
         this.cab053 = cab053;
         this.ake007 = ake007;
         this.aae013 = aae013;
         this.akc090 = akc090;
         this.akc220 = akc220;
         this.aab014 = aab014;
         this.akc264 = akc264;
         this.akc190 = akc190;
         this.jbrmc = jbrmc;
         this.ckz543 = ckz543;
         this.aae011 = aae011;
         this.sessionid = sessionid;
         this.jmc = jmc;
         this.hisBillState = hisBillState;
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

    public void setAka130(String aka130){
        this.aka130 = aka130;
    }

    public String getAka130(){
        return this.aka130;
    }

    public void setAkc050(String akc050){
        this.akc050 = akc050;
    }

    public String getAkc050(){
        return this.akc050;
    }

    public void setCkz564(String ckz564){
        this.ckz564 = ckz564;
    }

    public String getCkz564(){
        return this.ckz564;
    }

    public void setAaa138(String aaa138){
        this.aaa138 = aaa138;
    }

    public String getAaa138(){
        return this.aaa138;
    }

    public void setCkc803(String ckc803){
        this.ckc803 = ckc803;
    }

    public String getCkc803(){
        return this.ckc803;
    }

    public void setYzz016(String yzz016){
        this.yzz016 = yzz016;
    }

    public String getYzz016(){
        return this.yzz016;
    }

    public void setAac005(String aac005){
        this.aac005 = aac005;
    }

    public String getAac005(){
        return this.aac005;
    }

    public void setCab053(String cab053){
        this.cab053 = cab053;
    }

    public String getCab053(){
        return this.cab053;
    }

    public void setAke007(Date ake007){
        this.ake007 = ake007;
    }

    public Date getAke007(){
        return this.ake007;
    }

    public void setAae013(String aae013){
        this.aae013 = aae013;
    }

    public String getAae013(){
        return this.aae013;
    }

    public void setAkc090(Integer akc090){
        this.akc090 = akc090;
    }

    public Integer getAkc090(){
        return this.akc090;
    }

    public void setAkc220(String akc220){
        this.akc220 = akc220;
    }

    public String getAkc220(){
        return this.akc220;
    }

    public void setAab014(String aab014){
        this.aab014 = aab014;
    }

    public String getAab014(){
        return this.aab014;
    }

    public void setAkc264(Float akc264){
        this.akc264 = akc264;
    }

    public Float getAkc264(){
        return this.akc264;
    }

    public void setAkc190(String akc190){
        this.akc190 = akc190;
    }

    public String getAkc190(){
        return this.akc190;
    }

    public void setJbrmc(String jbrmc){
        this.jbrmc = jbrmc;
    }

    public String getJbrmc(){
        return this.jbrmc;
    }

    public void setCkz543(String ckz543){
        this.ckz543 = ckz543;
    }

    public String getCkz543(){
        return this.ckz543;
    }

    public void setAae011(String aae011){
        this.aae011 = aae011;
    }

    public String getAae011(){
        return this.aae011;
    }

    public void setSessionid(String sessionid){
        this.sessionid = sessionid;
    }

    public String getSessionid(){
        return this.sessionid;
    }

    public void setJmc(String jmc){
        this.jmc = jmc;
    }

    public String getJmc(){
        return this.jmc;
    }

    public void setHisBillState(String hisBillState){
        this.hisBillState = hisBillState;
    }

    public String getHisBillState(){
        return this.hisBillState;
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

	public String getAaz217() {
		return aaz217;
	}

	public void setAaz217(String aaz217) {
		this.aaz217 = aaz217;
	}

	public String getYkc675() {
		return ykc675;
	}

	public void setYkc675(String ykc675) {
		this.ykc675 = ykc675;
	}

	public String getYkc618() {
		return ykc618;
	}

	public void setYkc618(String ykc618) {
		this.ykc618 = ykc618;
	}

	public String getAac004() {
		return aac004;
	}

	public void setAac004(String aac004) {
		this.aac004 = aac004;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getSettleTypeFlag() {
		return settleTypeFlag;
	}

	public void setSettleTypeFlag(String settleTypeFlag) {
		this.settleTypeFlag = settleTypeFlag;
	}

	public Float getSelfPay() {
		return selfPay;
	}

	public void setSelfPay(Float selfPay) {
		this.selfPay = selfPay;
	}

	public String getXybOrderNo() {
		return xybOrderNo;
	}

	public void setXybOrderNo(String xybOrderNo) {
		this.xybOrderNo = xybOrderNo;
	}

	
	
}