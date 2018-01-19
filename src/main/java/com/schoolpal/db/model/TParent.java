package com.schoolpal.db.model;

import com.schoolpal.consts.Gender;
import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class TParent {

    @NotEmpty(groups = {AjaxControllerMod.class})
    private String id;

    @NotEmpty(groups = {AjaxControllerAdd.class})
    private String name;

    private Integer genderId;
    private String genderText;

    @NotEmpty(groups = {AjaxControllerAdd.class})
    private String cellphone;

    private String wechat;

    private String email;

    private String address;

    private Integer idType;

    private String idCode;

    private Date birthday;

    private String executiveId;

    private String creatorId;

    private Date createTime;

    private Date lastUpdate;

    private String relation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
        this.genderText = Gender.valueOf(genderId).getName();
    }

    public String getGenderText() {
        return genderText;
    }

    public void setGenderText(String genderText) {
        this.genderText = genderText;
        this.genderId = Gender.nameOf(genderText.trim()).getValue();
    }
    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode == null ? null : idCode.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getExecutiveId() {
        return executiveId;
    }

    public void setExecutiveId(String executiveId) {
        this.executiveId = executiveId == null ? null : executiveId.trim();
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public static TParent ParseFromContract(TContract contract){
    	TParent par = new TParent();
    	
    	par.setName(contract.getParName());
    	par.setCellphone(contract.getParCellphone());
    	par.setWechat(contract.getParWechat());
    	par.setEmail(contract.getParEmail());
    	par.setAddress(contract.getParAddress());
    	
		return par;
    }
}