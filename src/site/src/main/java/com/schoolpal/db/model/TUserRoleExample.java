package com.schoolpal.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TUserRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserRoleExample() {
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

        public Criteria andCIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(String value) {
            addCriterion("c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(String value) {
            addCriterion("c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(String value) {
            addCriterion("c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(String value) {
            addCriterion("c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(String value) {
            addCriterion("c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(String value) {
            addCriterion("c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLike(String value) {
            addCriterion("c_id like", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotLike(String value) {
            addCriterion("c_id not like", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<String> values) {
            addCriterion("c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<String> values) {
            addCriterion("c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(String value1, String value2) {
            addCriterion("c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(String value1, String value2) {
            addCriterion("c_id not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCOrgIdIsNull() {
            addCriterion("c_org_id is null");
            return (Criteria) this;
        }

        public Criteria andCOrgIdIsNotNull() {
            addCriterion("c_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andCOrgIdEqualTo(String value) {
            addCriterion("c_org_id =", value, "cOrgId");
            return (Criteria) this;
        }

        public Criteria andCOrgIdNotEqualTo(String value) {
            addCriterion("c_org_id <>", value, "cOrgId");
            return (Criteria) this;
        }

        public Criteria andCOrgIdGreaterThan(String value) {
            addCriterion("c_org_id >", value, "cOrgId");
            return (Criteria) this;
        }

        public Criteria andCOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("c_org_id >=", value, "cOrgId");
            return (Criteria) this;
        }

        public Criteria andCOrgIdLessThan(String value) {
            addCriterion("c_org_id <", value, "cOrgId");
            return (Criteria) this;
        }

        public Criteria andCOrgIdLessThanOrEqualTo(String value) {
            addCriterion("c_org_id <=", value, "cOrgId");
            return (Criteria) this;
        }

        public Criteria andCOrgIdLike(String value) {
            addCriterion("c_org_id like", value, "cOrgId");
            return (Criteria) this;
        }

        public Criteria andCOrgIdNotLike(String value) {
            addCriterion("c_org_id not like", value, "cOrgId");
            return (Criteria) this;
        }

        public Criteria andCOrgIdIn(List<String> values) {
            addCriterion("c_org_id in", values, "cOrgId");
            return (Criteria) this;
        }

        public Criteria andCOrgIdNotIn(List<String> values) {
            addCriterion("c_org_id not in", values, "cOrgId");
            return (Criteria) this;
        }

        public Criteria andCOrgIdBetween(String value1, String value2) {
            addCriterion("c_org_id between", value1, value2, "cOrgId");
            return (Criteria) this;
        }

        public Criteria andCOrgIdNotBetween(String value1, String value2) {
            addCriterion("c_org_id not between", value1, value2, "cOrgId");
            return (Criteria) this;
        }

        public Criteria andCUserIdIsNull() {
            addCriterion("c_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCUserIdIsNotNull() {
            addCriterion("c_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCUserIdEqualTo(String value) {
            addCriterion("c_user_id =", value, "cUserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdNotEqualTo(String value) {
            addCriterion("c_user_id <>", value, "cUserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdGreaterThan(String value) {
            addCriterion("c_user_id >", value, "cUserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("c_user_id >=", value, "cUserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdLessThan(String value) {
            addCriterion("c_user_id <", value, "cUserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdLessThanOrEqualTo(String value) {
            addCriterion("c_user_id <=", value, "cUserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdLike(String value) {
            addCriterion("c_user_id like", value, "cUserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdNotLike(String value) {
            addCriterion("c_user_id not like", value, "cUserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdIn(List<String> values) {
            addCriterion("c_user_id in", values, "cUserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdNotIn(List<String> values) {
            addCriterion("c_user_id not in", values, "cUserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdBetween(String value1, String value2) {
            addCriterion("c_user_id between", value1, value2, "cUserId");
            return (Criteria) this;
        }

        public Criteria andCUserIdNotBetween(String value1, String value2) {
            addCriterion("c_user_id not between", value1, value2, "cUserId");
            return (Criteria) this;
        }

        public Criteria andCRoleIdIsNull() {
            addCriterion("c_role_id is null");
            return (Criteria) this;
        }

        public Criteria andCRoleIdIsNotNull() {
            addCriterion("c_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andCRoleIdEqualTo(String value) {
            addCriterion("c_role_id =", value, "cRoleId");
            return (Criteria) this;
        }

        public Criteria andCRoleIdNotEqualTo(String value) {
            addCriterion("c_role_id <>", value, "cRoleId");
            return (Criteria) this;
        }

        public Criteria andCRoleIdGreaterThan(String value) {
            addCriterion("c_role_id >", value, "cRoleId");
            return (Criteria) this;
        }

        public Criteria andCRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("c_role_id >=", value, "cRoleId");
            return (Criteria) this;
        }

        public Criteria andCRoleIdLessThan(String value) {
            addCriterion("c_role_id <", value, "cRoleId");
            return (Criteria) this;
        }

        public Criteria andCRoleIdLessThanOrEqualTo(String value) {
            addCriterion("c_role_id <=", value, "cRoleId");
            return (Criteria) this;
        }

        public Criteria andCRoleIdLike(String value) {
            addCriterion("c_role_id like", value, "cRoleId");
            return (Criteria) this;
        }

        public Criteria andCRoleIdNotLike(String value) {
            addCriterion("c_role_id not like", value, "cRoleId");
            return (Criteria) this;
        }

        public Criteria andCRoleIdIn(List<String> values) {
            addCriterion("c_role_id in", values, "cRoleId");
            return (Criteria) this;
        }

        public Criteria andCRoleIdNotIn(List<String> values) {
            addCriterion("c_role_id not in", values, "cRoleId");
            return (Criteria) this;
        }

        public Criteria andCRoleIdBetween(String value1, String value2) {
            addCriterion("c_role_id between", value1, value2, "cRoleId");
            return (Criteria) this;
        }

        public Criteria andCRoleIdNotBetween(String value1, String value2) {
            addCriterion("c_role_id not between", value1, value2, "cRoleId");
            return (Criteria) this;
        }

        public Criteria andCAvailableIsNull() {
            addCriterion("c_available is null");
            return (Criteria) this;
        }

        public Criteria andCAvailableIsNotNull() {
            addCriterion("c_available is not null");
            return (Criteria) this;
        }

        public Criteria andCAvailableEqualTo(Boolean value) {
            addCriterion("c_available =", value, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableNotEqualTo(Boolean value) {
            addCriterion("c_available <>", value, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableGreaterThan(Boolean value) {
            addCriterion("c_available >", value, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("c_available >=", value, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableLessThan(Boolean value) {
            addCriterion("c_available <", value, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableLessThanOrEqualTo(Boolean value) {
            addCriterion("c_available <=", value, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableIn(List<Boolean> values) {
            addCriterion("c_available in", values, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableNotIn(List<Boolean> values) {
            addCriterion("c_available not in", values, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableBetween(Boolean value1, Boolean value2) {
            addCriterion("c_available between", value1, value2, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("c_available not between", value1, value2, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCCreatorIsNull() {
            addCriterion("c_creator is null");
            return (Criteria) this;
        }

        public Criteria andCCreatorIsNotNull() {
            addCriterion("c_creator is not null");
            return (Criteria) this;
        }

        public Criteria andCCreatorEqualTo(String value) {
            addCriterion("c_creator =", value, "cCreator");
            return (Criteria) this;
        }

        public Criteria andCCreatorNotEqualTo(String value) {
            addCriterion("c_creator <>", value, "cCreator");
            return (Criteria) this;
        }

        public Criteria andCCreatorGreaterThan(String value) {
            addCriterion("c_creator >", value, "cCreator");
            return (Criteria) this;
        }

        public Criteria andCCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("c_creator >=", value, "cCreator");
            return (Criteria) this;
        }

        public Criteria andCCreatorLessThan(String value) {
            addCriterion("c_creator <", value, "cCreator");
            return (Criteria) this;
        }

        public Criteria andCCreatorLessThanOrEqualTo(String value) {
            addCriterion("c_creator <=", value, "cCreator");
            return (Criteria) this;
        }

        public Criteria andCCreatorLike(String value) {
            addCriterion("c_creator like", value, "cCreator");
            return (Criteria) this;
        }

        public Criteria andCCreatorNotLike(String value) {
            addCriterion("c_creator not like", value, "cCreator");
            return (Criteria) this;
        }

        public Criteria andCCreatorIn(List<String> values) {
            addCriterion("c_creator in", values, "cCreator");
            return (Criteria) this;
        }

        public Criteria andCCreatorNotIn(List<String> values) {
            addCriterion("c_creator not in", values, "cCreator");
            return (Criteria) this;
        }

        public Criteria andCCreatorBetween(String value1, String value2) {
            addCriterion("c_creator between", value1, value2, "cCreator");
            return (Criteria) this;
        }

        public Criteria andCCreatorNotBetween(String value1, String value2) {
            addCriterion("c_creator not between", value1, value2, "cCreator");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeIsNull() {
            addCriterion("c_create_time is null");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeIsNotNull() {
            addCriterion("c_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeEqualTo(Date value) {
            addCriterion("c_create_time =", value, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeNotEqualTo(Date value) {
            addCriterion("c_create_time <>", value, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeGreaterThan(Date value) {
            addCriterion("c_create_time >", value, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("c_create_time >=", value, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeLessThan(Date value) {
            addCriterion("c_create_time <", value, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("c_create_time <=", value, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeIn(List<Date> values) {
            addCriterion("c_create_time in", values, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeNotIn(List<Date> values) {
            addCriterion("c_create_time not in", values, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeBetween(Date value1, Date value2) {
            addCriterion("c_create_time between", value1, value2, "cCreateTime");
            return (Criteria) this;
        }

        public Criteria andCCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("c_create_time not between", value1, value2, "cCreateTime");
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