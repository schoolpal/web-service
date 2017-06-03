package com.schoolpal.db.model;

public class TParStu extends TParStuKey {
    private String relation;

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }
}