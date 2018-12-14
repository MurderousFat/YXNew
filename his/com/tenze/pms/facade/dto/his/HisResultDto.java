package com.tenze.pms.facade.dto.his;


import java.util.Date;
import com.tenze.background.common.entity.BaseEntity;

/**
 * TODO
 * @author TenzeTseng
 *
 */
public class HisResultDto extends BaseEntity{

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
    private Long masId;
    /** */
    private String type;
    /** */
    private String content;


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

    public void setMasId(Long masId){
        this.masId = masId;
    }

    public Long getMasId(){
        return this.masId;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }

}