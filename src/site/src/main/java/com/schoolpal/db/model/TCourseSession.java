package com.schoolpal.db.model;

import java.math.BigDecimal;
import java.util.Date;

public class TCourseSession {
    private Integer id;

    private Integer protoId;

    private String name;

    private String type;

    private BigDecimal hours;

    private Date startDate;

    private Date endDate;

    private Integer times;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProtoId() {
        return protoId;
    }

    public void setProtoId(Integer protoId) {
        this.protoId = protoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
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

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}