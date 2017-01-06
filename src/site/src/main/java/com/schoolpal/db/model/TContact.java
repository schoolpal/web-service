package com.schoolpal.db.model;

import java.util.Date;

public class TContact {
    private String id;

    private String leadsId;

    private String approach;

    private Date datetime;

    private String executiveId;

    private String summary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLeadsId() {
        return leadsId;
    }

    public void setLeadsId(String leadsId) {
        this.leadsId = leadsId == null ? null : leadsId.trim();
    }

    public String getApproach() {
        return approach;
    }

    public void setApproach(String approach) {
        this.approach = approach == null ? null : approach.trim();
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getExecutiveId() {
        return executiveId;
    }

    public void setExecutiveId(String executiveId) {
        this.executiveId = executiveId == null ? null : executiveId.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }
}