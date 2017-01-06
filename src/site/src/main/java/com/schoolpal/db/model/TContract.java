package com.schoolpal.db.model;

import java.math.BigDecimal;
import java.util.Date;

public class TContract {
    private String id;

    private String type;

    private String code;

    private Date startDate;

    private Date endDate;

    private BigDecimal originalPrice;

    private BigDecimal discountPrice;

    private BigDecimal finalPrice;

    private BigDecimal paid;

    private String courseType;

    private Integer courseOriId;

    private String courseHours;

    private String courseTimes;

    private String stuOriId;

    private String stuFirstname;

    private String stuLastname;

    private Integer stuGender;

    private Integer stuIdType;

    private String stuIdCode;

    private String stuBirthday;

    private String stuGrade;

    private String stuSchoolName;

    private String orgnizationId;

    private String creatorId;

    private String executiveId;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
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

    public Integer getCourseOriId() {
        return courseOriId;
    }

    public void setCourseOriId(Integer courseOriId) {
        this.courseOriId = courseOriId;
    }

    public String getCourseHours() {
        return courseHours;
    }

    public void setCourseHours(String courseHours) {
        this.courseHours = courseHours == null ? null : courseHours.trim();
    }

    public String getCourseTimes() {
        return courseTimes;
    }

    public void setCourseTimes(String courseTimes) {
        this.courseTimes = courseTimes == null ? null : courseTimes.trim();
    }

    public String getStuOriId() {
        return stuOriId;
    }

    public void setStuOriId(String stuOriId) {
        this.stuOriId = stuOriId == null ? null : stuOriId.trim();
    }

    public String getStuFirstname() {
        return stuFirstname;
    }

    public void setStuFirstname(String stuFirstname) {
        this.stuFirstname = stuFirstname == null ? null : stuFirstname.trim();
    }

    public String getStuLastname() {
        return stuLastname;
    }

    public void setStuLastname(String stuLastname) {
        this.stuLastname = stuLastname == null ? null : stuLastname.trim();
    }

    public Integer getStuGender() {
        return stuGender;
    }

    public void setStuGender(Integer stuGender) {
        this.stuGender = stuGender;
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

    public String getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(String stuBirthday) {
        this.stuBirthday = stuBirthday == null ? null : stuBirthday.trim();
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

    public String getOrgnizationId() {
        return orgnizationId;
    }

    public void setOrgnizationId(String orgnizationId) {
        this.orgnizationId = orgnizationId == null ? null : orgnizationId.trim();
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}