package com.schoolpal.db.model;

import java.util.Date;

import com.schoolpal.web.consts.Gender;

public class TParent {
    private String id;

    private String name;

    private Integer genderId;

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
    public String getGender() {
        return Gender.valueOf(genderId).getName();
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId == null ? null : genderId;
    }
    public void setGender(String gender) {
        this.genderId = Gender.nameOf(gender.trim()).getValue();
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