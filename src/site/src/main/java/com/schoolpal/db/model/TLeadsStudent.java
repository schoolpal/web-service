package com.schoolpal.db.model;

import java.util.Date;

import com.schoolpal.web.consts.Gender;

public class TLeadsStudent {

	private String id;
    
    private String name;

    private Integer genderId;
    private String genderText;

    private Integer idType;

    private String idCode;

    private Date birthday;
    
    private Integer age;

    private String schoolGrade;

    private String classGrade;

    private String schoolName;

    private String creatorId;

    private Date createTime;

    private Date lastUpdate;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setStudentId(String id) {
		this.id = id;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    public void setStudentName(String name) {
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
    public void setStudentGender(String genderText) {
    	this.setGenderText(genderText);
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

    public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	public void setStudentAge(Integer age) {
		this.age = age;
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
}