package com.schoolpal.db.model;

import java.util.Date;

public class TCrmAudit {
    private Long id;

    private String table;

    private String primeId;

    private String actionUserId;

    private String actionType;

    private Date actionTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table == null ? null : table.trim();
    }

    public String getPrimeId() {
        return primeId;
    }

    public void setPrimeId(String primeId) {
        this.primeId = primeId == null ? null : primeId.trim();
    }

    public String getActionUserId() {
        return actionUserId;
    }

    public void setActionUserId(String actionUserId) {
        this.actionUserId = actionUserId == null ? null : actionUserId.trim();
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType == null ? null : actionType.trim();
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }
}