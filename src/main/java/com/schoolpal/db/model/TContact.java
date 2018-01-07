package com.schoolpal.db.model;

import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class TContact {

    @NotEmpty(groups = {AjaxControllerMod.class})
    private String id;

    @NotEmpty(groups = {AjaxControllerAdd.class})
    private String leadsId;

    @NotEmpty(groups = {AjaxControllerAdd.class})
    private String approachId;
    private String approachName;

    private Date datetime;

    private String executiveName;
    private String executiveId;

    private String orgName;
    private String orgId;
    
    public String getExecutiveName() {
		return executiveName;
	}

	public void setExecutiveName(String executiveName) {
		this.executiveName = executiveName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

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

    public String getApproachName() {
        return approachName;
    }

    public void setApproachName(String approachName) {
        this.approachName = approachName == null ? null : approachName.trim();
    }

    public String getApproachId() {
		return approachId;
	}

	public void setApproachId(String approachId) {
		this.approachId = approachId;
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