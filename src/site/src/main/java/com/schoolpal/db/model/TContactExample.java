package com.schoolpal.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TContactExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TContactExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLeadsIdIsNull() {
            addCriterion("leads_id is null");
            return (Criteria) this;
        }

        public Criteria andLeadsIdIsNotNull() {
            addCriterion("leads_id is not null");
            return (Criteria) this;
        }

        public Criteria andLeadsIdEqualTo(String value) {
            addCriterion("leads_id =", value, "leadsId");
            return (Criteria) this;
        }

        public Criteria andLeadsIdNotEqualTo(String value) {
            addCriterion("leads_id <>", value, "leadsId");
            return (Criteria) this;
        }

        public Criteria andLeadsIdGreaterThan(String value) {
            addCriterion("leads_id >", value, "leadsId");
            return (Criteria) this;
        }

        public Criteria andLeadsIdGreaterThanOrEqualTo(String value) {
            addCriterion("leads_id >=", value, "leadsId");
            return (Criteria) this;
        }

        public Criteria andLeadsIdLessThan(String value) {
            addCriterion("leads_id <", value, "leadsId");
            return (Criteria) this;
        }

        public Criteria andLeadsIdLessThanOrEqualTo(String value) {
            addCriterion("leads_id <=", value, "leadsId");
            return (Criteria) this;
        }

        public Criteria andLeadsIdLike(String value) {
            addCriterion("leads_id like", value, "leadsId");
            return (Criteria) this;
        }

        public Criteria andLeadsIdNotLike(String value) {
            addCriterion("leads_id not like", value, "leadsId");
            return (Criteria) this;
        }

        public Criteria andLeadsIdIn(List<String> values) {
            addCriterion("leads_id in", values, "leadsId");
            return (Criteria) this;
        }

        public Criteria andLeadsIdNotIn(List<String> values) {
            addCriterion("leads_id not in", values, "leadsId");
            return (Criteria) this;
        }

        public Criteria andLeadsIdBetween(String value1, String value2) {
            addCriterion("leads_id between", value1, value2, "leadsId");
            return (Criteria) this;
        }

        public Criteria andLeadsIdNotBetween(String value1, String value2) {
            addCriterion("leads_id not between", value1, value2, "leadsId");
            return (Criteria) this;
        }

        public Criteria andApproachIsNull() {
            addCriterion("approach is null");
            return (Criteria) this;
        }

        public Criteria andApproachIsNotNull() {
            addCriterion("approach is not null");
            return (Criteria) this;
        }

        public Criteria andApproachEqualTo(String value) {
            addCriterion("approach =", value, "approach");
            return (Criteria) this;
        }

        public Criteria andApproachNotEqualTo(String value) {
            addCriterion("approach <>", value, "approach");
            return (Criteria) this;
        }

        public Criteria andApproachGreaterThan(String value) {
            addCriterion("approach >", value, "approach");
            return (Criteria) this;
        }

        public Criteria andApproachGreaterThanOrEqualTo(String value) {
            addCriterion("approach >=", value, "approach");
            return (Criteria) this;
        }

        public Criteria andApproachLessThan(String value) {
            addCriterion("approach <", value, "approach");
            return (Criteria) this;
        }

        public Criteria andApproachLessThanOrEqualTo(String value) {
            addCriterion("approach <=", value, "approach");
            return (Criteria) this;
        }

        public Criteria andApproachLike(String value) {
            addCriterion("approach like", value, "approach");
            return (Criteria) this;
        }

        public Criteria andApproachNotLike(String value) {
            addCriterion("approach not like", value, "approach");
            return (Criteria) this;
        }

        public Criteria andApproachIn(List<String> values) {
            addCriterion("approach in", values, "approach");
            return (Criteria) this;
        }

        public Criteria andApproachNotIn(List<String> values) {
            addCriterion("approach not in", values, "approach");
            return (Criteria) this;
        }

        public Criteria andApproachBetween(String value1, String value2) {
            addCriterion("approach between", value1, value2, "approach");
            return (Criteria) this;
        }

        public Criteria andApproachNotBetween(String value1, String value2) {
            addCriterion("approach not between", value1, value2, "approach");
            return (Criteria) this;
        }

        public Criteria andDatetimeIsNull() {
            addCriterion("datetime is null");
            return (Criteria) this;
        }

        public Criteria andDatetimeIsNotNull() {
            addCriterion("datetime is not null");
            return (Criteria) this;
        }

        public Criteria andDatetimeEqualTo(Date value) {
            addCriterion("datetime =", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotEqualTo(Date value) {
            addCriterion("datetime <>", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThan(Date value) {
            addCriterion("datetime >", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("datetime >=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThan(Date value) {
            addCriterion("datetime <", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("datetime <=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeIn(List<Date> values) {
            addCriterion("datetime in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotIn(List<Date> values) {
            addCriterion("datetime not in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeBetween(Date value1, Date value2) {
            addCriterion("datetime between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("datetime not between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andExecutiveIdIsNull() {
            addCriterion("executive_id is null");
            return (Criteria) this;
        }

        public Criteria andExecutiveIdIsNotNull() {
            addCriterion("executive_id is not null");
            return (Criteria) this;
        }

        public Criteria andExecutiveIdEqualTo(String value) {
            addCriterion("executive_id =", value, "executiveId");
            return (Criteria) this;
        }

        public Criteria andExecutiveIdNotEqualTo(String value) {
            addCriterion("executive_id <>", value, "executiveId");
            return (Criteria) this;
        }

        public Criteria andExecutiveIdGreaterThan(String value) {
            addCriterion("executive_id >", value, "executiveId");
            return (Criteria) this;
        }

        public Criteria andExecutiveIdGreaterThanOrEqualTo(String value) {
            addCriterion("executive_id >=", value, "executiveId");
            return (Criteria) this;
        }

        public Criteria andExecutiveIdLessThan(String value) {
            addCriterion("executive_id <", value, "executiveId");
            return (Criteria) this;
        }

        public Criteria andExecutiveIdLessThanOrEqualTo(String value) {
            addCriterion("executive_id <=", value, "executiveId");
            return (Criteria) this;
        }

        public Criteria andExecutiveIdLike(String value) {
            addCriterion("executive_id like", value, "executiveId");
            return (Criteria) this;
        }

        public Criteria andExecutiveIdNotLike(String value) {
            addCriterion("executive_id not like", value, "executiveId");
            return (Criteria) this;
        }

        public Criteria andExecutiveIdIn(List<String> values) {
            addCriterion("executive_id in", values, "executiveId");
            return (Criteria) this;
        }

        public Criteria andExecutiveIdNotIn(List<String> values) {
            addCriterion("executive_id not in", values, "executiveId");
            return (Criteria) this;
        }

        public Criteria andExecutiveIdBetween(String value1, String value2) {
            addCriterion("executive_id between", value1, value2, "executiveId");
            return (Criteria) this;
        }

        public Criteria andExecutiveIdNotBetween(String value1, String value2) {
            addCriterion("executive_id not between", value1, value2, "executiveId");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}