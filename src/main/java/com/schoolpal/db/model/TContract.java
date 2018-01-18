package com.schoolpal.db.model;

import com.schoolpal.consts.Gender;
import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class TContract {

    @NotEmpty(groups = {AjaxControllerMod.class})
    private String id;

    @NotNull(groups = {AjaxControllerAdd.class})
    private Integer typeId;
    private String typeName;

    @NotEmpty(groups = {AjaxControllerAdd.class})
    private String code;

    private Date startDate;

    private Date endDate;

    @NotNull(groups = {AjaxControllerAdd.class})
    private BigDecimal oriPrice;

    @NotNull(groups = {AjaxControllerAdd.class})
    private BigDecimal discPrice;

    @NotNull(groups = {AjaxControllerAdd.class})
    private BigDecimal finalPrice;

    @NotNull(groups = {AjaxControllerAdd.class})
    private BigDecimal paid;

    @NotEmpty(groups = {AjaxControllerAdd.class})
    private String courseType;

    @NotEmpty(groups = {AjaxControllerAdd.class})
    private String courseId;
    private String courseName;

    @NotNull(groups = {AjaxControllerAdd.class})
    private Double courseHours;

    @NotNull(groups = {AjaxControllerAdd.class})
    private Integer courseTimes;

    private String stuId;

    private String stuCode;

    @NotEmpty(groups = {AjaxControllerAdd.class})
    private String stuName;

    private Integer stuGenderId;
    private String stuGenderText;

    private Integer stuIdType;

    private String stuIdCode;

    @NotNull(groups = {AjaxControllerAdd.class})
    private Date stuBirthday;

    @NotEmpty(groups = {AjaxControllerAdd.class})
    private String stuGrade;

    private String stuSchoolName;

    private String parId;

    @NotEmpty(groups = {AjaxControllerAdd.class})
    private String parName;

    @NotEmpty(groups = {AjaxControllerAdd.class})
    private String parCellphone;

    private String parWechat;

    private String parEmail;

    private String parAddress;

    private String relation;

    private String orgId;
    private String orgName;

    private String oriId;

    private String creatorId;
    private String creatorName;

    private String executiveId;
    private String executiveName;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getOriPrice() {
        return oriPrice;
    }

    public void setOriPrice(BigDecimal oriPrice) {
        this.oriPrice = oriPrice;
    }

    public BigDecimal getDiscPrice() {
        return discPrice;
    }

    public void setDiscPrice(BigDecimal discPrice) {
        this.discPrice = discPrice;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType == null ? null : courseType.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getCourseHours() {
        return courseHours;
    }

    public void setCourseHours(Double courseHours) {
        this.courseHours = courseHours;
    }

    public Integer getCourseTimes() {
        return courseTimes;
    }

    public void setCourseTimes(Integer courseTimes) {
        this.courseTimes = courseTimes;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getStuCode() {
		return stuCode;
	}

	public void setStuCode(String stuCode) {
		this.stuCode = stuCode;
	}

	public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public Integer getStuGenderId() {
        return stuGenderId;
    }
    public void setStuGenderId(Integer stuGenderId) {
        this.stuGenderId = stuGenderId;
        this.stuGenderText = Gender.valueOf(stuGenderId).getName();
    }

    public String getStuGenderText() {
        return stuGenderText;
    }

    public void setStuGenderText(String stuGenderText) {
        this.stuGenderText = stuGenderText;
        this.stuGenderId = Gender.nameOf(stuGenderText.trim()).getValue();
    }

    public Integer getStuIdType() {
        return stuIdType;
    }

    public void setStuIdType(Integer stuIdType) {
        this.stuIdType = stuIdType;
    }

    public String getStuIdCode() {
        return stuIdCode;
    }

    public void setStuIdCode(String stuIdCode) {
        this.stuIdCode = stuIdCode == null ? null : stuIdCode.trim();
    }

    public Date getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(Date stuBirthday) {
        this.stuBirthday = stuBirthday == null ? null : stuBirthday;
    }

    public String getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(String stuGrade) {
        this.stuGrade = stuGrade == null ? null : stuGrade.trim();
    }

    public String getStuSchoolName() {
        return stuSchoolName;
    }

    public void setStuSchoolName(String stuSchoolName) {
        this.stuSchoolName = stuSchoolName == null ? null : stuSchoolName.trim();
    }

    public String getParId() {
        return parId;
    }

    public void setParId(String parId) {
        this.parId = parId == null ? null : parId.trim();
    }

    public String getParName() {
        return parName;
    }

    public void setParName(String parName) {
        this.parName = parName == null ? null : parName.trim();
    }

    public String getParCellphone() {
        return parCellphone;
    }

    public void setParCellphone(String parCellphone) {
        this.parCellphone = parCellphone == null ? null : parCellphone.trim();
    }

    public String getParWechat() {
        return parWechat;
    }

    public void setParWechat(String parWechat) {
        this.parWechat = parWechat == null ? null : parWechat.trim();
    }

    public String getParEmail() {
        return parEmail;
    }

    public void setParEmail(String parEmail) {
        this.parEmail = parEmail == null ? null : parEmail.trim();
    }

    public String getParAddress() {
        return parAddress;
    }

    public void setParAddress(String parAddress) {
        this.parAddress = parAddress == null ? null : parAddress.trim();
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    public String getExecutiveId() {
        return executiveId;
    }

    public void setExecutiveId(String executiveId) {
        this.executiveId = executiveId == null ? null : executiveId.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOriId() {
        return oriId;
    }

    public void setOriId(String oriId) {
        this.oriId = oriId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getExecutiveName() {
        return executiveName;
    }

    public void setExecutiveName(String executiveName) {
        this.executiveName = executiveName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}