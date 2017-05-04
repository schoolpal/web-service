package com.schoolpal.db.model;

import java.math.BigDecimal;
import java.util.Date;

public class TActivity {
    private Integer id;

    private Integer rootId;

    private Integer parentId;

    private String name;

    private Date startDate;

    private Date endDate;

    private BigDecimal budget;

    private BigDecimal cost;

    private String exectiveId;

    private String creatorId;

    private Date createTime;

    private Date lastUpdate;
    
    private Integer children;
    
    private boolean hasChild;
    
    private Integer leads;
    
    private Integer opportunities;
    
    private Integer contracts;
    
    private BigDecimal totalAmount;
    
    private BigDecimal roi;

    private Integer level;
    
    private boolean parent;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRootId() {
        return rootId;
    }

    public void setRootId(Integer rootId) {
        this.rootId = rootId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getExectiveId() {
        return exectiveId;
    }

    public void setExectiveId(String exectiveId) {
        this.exectiveId = exectiveId == null ? null : exectiveId.trim();
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

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
		this.hasChild = children > 0;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	public Integer getLeads() {
		return leads;
	}

	public void setLeads(Integer leads) {
		this.leads = leads;
	}

	public Integer getOpportunities() {
		return opportunities;
	}

	public void setOpportunities(Integer opportunity) {
		this.opportunities = opportunity;
	}

	public Integer getContracts() {
		return contracts;
	}

	public void setContracts(Integer contracts) {
		this.contracts = contracts;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getRoi() {
		return roi;
	}

	public void setRoi(BigDecimal roi) {
		this.roi = roi;
	}
	
	public void calculateRoi() {
		this.roi = this.totalAmount.divide(this.cost);
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public boolean isParent() {
		return parent;
	}

	public void setParent(boolean parent) {
		this.parent = parent;
	}
}