package com.tenze.pms.facade.dto.sys;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class SysMenuDto extends BaseEntity{

    private Long id;
    private Integer version;
    private Date createtime;
    private Date updatetime;
    private Integer fdelFlag;
    private String menuNo;
    private String menuName;
    private Byte expandedFlag;
    private Byte leafFlag;
    private String menuState;
    private String menuType;
    private String parentNo;
    private String parentName;
    private String request;
    private Integer sortNo;
    private String remark;
    private String iconCls;

public SysMenuDto(){}

public SysMenuDto(Long id){this.id=id;}

public SysMenuDto(Long id, Integer version, Date createtime, Date updatetime, Integer fdelFlag, String menuNo, String menuName, Byte expandedFlag, Byte leafFlag, String menuState, String menuType, String parentNo, String request, Integer sortNo, String remark,String parentName,String iconCls){
         this.id = id;
         this.version = version;
         this.createtime = createtime;
         this.updatetime = updatetime;
         this.fdelFlag = fdelFlag;
         this.menuNo = menuNo;
         this.menuName = menuName;
         this.expandedFlag = expandedFlag;
         this.leafFlag = leafFlag;
         this.menuState = menuState;
         this.menuType = menuType;
         this.parentNo = parentNo;
         this.request = request;
         this.sortNo = sortNo;
         this.remark = remark;
         this.parentName = parentName;
         this.iconCls = iconCls;
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

    public void setMenuNo(String menuNo){
        this.menuNo = menuNo;
    }

    public String getMenuNo(){
        return this.menuNo;
    }

    public void setMenuName(String menuName){
        this.menuName = menuName;
    }

    public String getMenuName(){
        return this.menuName;
    }

	public Byte getExpandedFlag() {
		return expandedFlag;
	}

	public void setExpandedFlag(Byte expandedFlag) {
		this.expandedFlag = expandedFlag;
	}

	public Byte getLeafFlag() {
		return leafFlag;
	}

	public void setLeafFlag(Byte leafFlag) {
		this.leafFlag = leafFlag;
	}

	public void setMenuState(String menuState){
        this.menuState = menuState;
    }

    public String getMenuState(){
        return this.menuState;
    }

    public void setMenuType(String menuType){
        this.menuType = menuType;
    }

    public String getMenuType(){
        return this.menuType;
    }

    public void setParentNo(String parentNo){
        this.parentNo = parentNo;
    }

    public String getParentNo(){
        return this.parentNo;
    }

    public void setRequest(String request){
        this.request = request;
    }

    public String getRequest(){
        return this.request;
    }

    public void setSortNo(Integer sortNo){
        this.sortNo = sortNo;
    }

    public Integer getSortNo(){
        return this.sortNo;
    }

    public void setRemark(String remark){
        this.remark = remark;
    }

    public String getRemark(){
        return this.remark;
    }

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	
}