package com.schoolpal.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TCrmAuditExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCrmAuditExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTableIsNull() {
            addCriterion("table is null");
            return (Criteria) this;
        }

        public Criteria andTableIsNotNull() {
            addCriterion("table is not null");
            return (Criteria) this;
        }

        public Criteria andTableEqualTo(String value) {
            addCriterion("table =", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableNotEqualTo(String value) {
            addCriterion("table <>", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableGreaterThan(String value) {
            addCriterion("table >", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableGreaterThanOrEqualTo(String value) {
            addCriterion("table >=", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableLessThan(String value) {
            addCriterion("table <", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableLessThanOrEqualTo(String value) {
            addCriterion("table <=", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableLike(String value) {
            addCriterion("table like", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableNotLike(String value) {
            addCriterion("table not like", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableIn(List<String> values) {
            addCriterion("table in", values, "table");
            return (Criteria) this;
        }

        public Criteria andTableNotIn(List<String> values) {
            addCriterion("table not in", values, "table");
            return (Criteria) this;
        }

        public Criteria andTableBetween(String value1, String value2) {
            addCriterion("table between", value1, value2, "table");
            return (Criteria) this;
        }

        public Criteria andTableNotBetween(String value1, String value2) {
            addCriterion("table not between", value1, value2, "table");
            return (Criteria) this;
        }

        public Criteria andPrimeIdIsNull() {
            addCriterion("prime_id is null");
            return (Criteria) this;
        }

        public Criteria andPrimeIdIsNotNull() {
            addCriterion("prime_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrimeIdEqualTo(String value) {
            addCriterion("prime_id =", value, "primeId");
            return (Criteria) this;
        }

        public Criteria andPrimeIdNotEqualTo(String value) {
            addCriterion("prime_id <>", value, "primeId");
            return (Criteria) this;
        }

        public Criteria andPrimeIdGreaterThan(String value) {
            addCriterion("prime_id >", value, "primeId");
            return (Criteria) this;
        }

        public Criteria andPrimeIdGreaterThanOrEqualTo(String value) {
            addCriterion("prime_id >=", value, "primeId");
            return (Criteria) this;
        }

        public Criteria andPrimeIdLessThan(String value) {
            addCriterion("prime_id <", value, "primeId");
            return (Criteria) this;
        }

        public Criteria andPrimeIdLessThanOrEqualTo(String value) {
            addCriterion("prime_id <=", value, "primeId");
            return (Criteria) this;
        }

        public Criteria andPrimeIdLike(String value) {
            addCriterion("prime_id like", value, "primeId");
            return (Criteria) this;
        }

        public Criteria andPrimeIdNotLike(String value) {
            addCriterion("prime_id not like", value, "primeId");
            return (Criteria) this;
        }

        public Criteria andPrimeIdIn(List<String> values) {
            addCriterion("prime_id in", values, "primeId");
            return (Criteria) this;
        }

        public Criteria andPrimeIdNotIn(List<String> values) {
            addCriterion("prime_id not in", values, "primeId");
            return (Criteria) this;
        }

        public Criteria andPrimeIdBetween(String value1, String value2) {
            addCriterion("prime_id between", value1, value2, "primeId");
            return (Criteria) this;
        }

        public Criteria andPrimeIdNotBetween(String value1, String value2) {
            addCriterion("prime_id not between", value1, value2, "primeId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdIsNull() {
            addCriterion("action_user_id is null");
            return (Criteria) this;
        }

        public Criteria andActionUserIdIsNotNull() {
            addCriterion("action_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andActionUserIdEqualTo(String value) {
            addCriterion("action_user_id =", value, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdNotEqualTo(String value) {
            addCriterion("action_user_id <>", value, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdGreaterThan(String value) {
            addCriterion("action_user_id >", value, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("action_user_id >=", value, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdLessThan(String value) {
            addCriterion("action_user_id <", value, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdLessThanOrEqualTo(String value) {
            addCriterion("action_user_id <=", value, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdLike(String value) {
            addCriterion("action_user_id like", value, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdNotLike(String value) {
            addCriterion("action_user_id not like", value, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdIn(List<String> values) {
            addCriterion("action_user_id in", values, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdNotIn(List<String> values) {
            addCriterion("action_user_id not in", values, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdBetween(String value1, String value2) {
            addCriterion("action_user_id between", value1, value2, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionUserIdNotBetween(String value1, String value2) {
            addCriterion("action_user_id not between", value1, value2, "actionUserId");
            return (Criteria) this;
        }

        public Criteria andActionTypeIsNull() {
            addCriterion("action_type is null");
            return (Criteria) this;
        }

        public Criteria andActionTypeIsNotNull() {
            addCriterion("action_type is not null");
            return (Criteria) this;
        }

        public Criteria andActionTypeEqualTo(String value) {
            addCriterion("action_type =", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeNotEqualTo(String value) {
            addCriterion("action_type <>", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeGreaterThan(String value) {
            addCriterion("action_type >", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("action_type >=", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeLessThan(String value) {
            addCriterion("action_type <", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeLessThanOrEqualTo(String value) {
            addCriterion("action_type <=", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeLike(String value) {
            addCriterion("action_type like", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeNotLike(String value) {
            addCriterion("action_type not like", value, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeIn(List<String> values) {
            addCriterion("action_type in", values, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeNotIn(List<String> values) {
            addCriterion("action_type not in", values, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeBetween(String value1, String value2) {
            addCriterion("action_type between", value1, value2, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTypeNotBetween(String value1, String value2) {
            addCriterion("action_type not between", value1, value2, "actionType");
            return (Criteria) this;
        }

        public Criteria andActionTimeIsNull() {
            addCriterion("action_time is null");
            return (Criteria) this;
        }

        public Criteria andActionTimeIsNotNull() {
            addCriterion("action_time is not null");
            return (Criteria) this;
        }

        public Criteria andActionTimeEqualTo(Date value) {
            addCriterion("action_time =", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeNotEqualTo(Date value) {
            addCriterion("action_time <>", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeGreaterThan(Date value) {
            addCriterion("action_time >", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("action_time >=", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeLessThan(Date value) {
            addCriterion("action_time <", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeLessThanOrEqualTo(Date value) {
            addCriterion("action_time <=", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeIn(List<Date> values) {
            addCriterion("action_time in", values, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeNotIn(List<Date> values) {
            addCriterion("action_time not in", values, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeBetween(Date value1, Date value2) {
            addCriterion("action_time between", value1, value2, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeNotBetween(Date value1, Date value2) {
            addCriterion("action_time not between", value1, value2, "actionTime");
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