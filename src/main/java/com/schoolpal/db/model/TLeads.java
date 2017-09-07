package com.schoolpal.db.model;

import java.util.Date;

public class TLeads {
    private String id;

    private String courseType;

    private String courseName;

    private Integer typeId;

    private Integer sourceId;
    private String sourceName;

    private String channelId;
    private String channelName;

    private Integer stageId;
    private String stageName;

    private Integer statusId;
    private String statusName;

    private String orgnizationId;
    private String orgnizationName;

    private String executiveId;
    private String executiveName;

    private String creatorId;
    private String creatorName;

    private Date createTime;

    private Date lastUpdate;

    private String note;
    
    private String parentId;
    private TLeadsParent parent;
    
    private String studentId;
    public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	private TLeadsStudent student;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
    public void setLeadsId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType == null ? null : courseType.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer type) {
        this.typeId = type;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getOrgnizationId() {
        return orgnizationId;
    }

    public void setOrgnizationId(String orgnizationId) {
        this.orgnizationId = orgnizationId == null ? null : orgnizationId.trim();
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

    public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getOrgnizationName() {
		return orgnizationName;
	}

	public void setOrgnizationName(String orgnizationName) {
		this.orgnizationName = orgnizationName;
	}

	public String getExecutiveName() {
		return executiveName;
	}

	public void setExecutiveName(String executiveName) {
		this.executiveName = executiveName;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
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

	public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

	public TLeadsParent getParent() {
		return parent;
	}

	public void setParent(TLeadsParent parent) {
		this.parent = parent;
	}

	public TLeadsStudent getStudent() {
		return student;
	}

	public void setStudent(TLeadsStudent student) {
		this.student = student;
	}
}