package com.schoolpal.db.model;

import java.util.Date;

import com.schoolpal.web.consts.Gender;

public class TStudent {
    private String id;

    private String code;

    private String name;

    private Integer genderId;

    private Integer idType;

    private String idCode;

    private Date birthday;

    private String schoolGrade;

    private String classGrade;

    private String schoolName;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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

    public String getSchoolGrade() {
        return schoolGrade;
    }

    public void setSchoolGrade(String schoolGrade) {
        this.schoolGrade = schoolGrade == null ? null : schoolGrade.trim();
    }

    public String getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(String classGrade) {
        this.classGrade = classGrade == null ? null : classGrade.trim();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
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
    
    public static TStudent ParseFromContract(TContract contract){
    	TStudent stu = new TStudent();
    	
    	stu.setCode(contract.getCode());
    	stu.setName(contract.getStuName());
    	stu.setGenderId(contract.getStuGenderId());
    	stu.setBirthday(contract.getStuBirthday());
    	stu.setClassGrade(contract.getStuGrade());
    	stu.setSchoolName(contract.getStuSchoolName());
    	stu.setSchoolGrade(contract.getStuGrade());
    	stu.setIdType(contract.getStuIdType());
    	stu.setIdCode(contract.getStuIdCode());
    	
		return stu;
    }
}