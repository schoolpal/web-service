package com.schoolpal.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRoleExample() {
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

        public Criteria andCNameIsNull() {
            addCriterion("c_name is null");
            return (Criteria) this;
        }

        public Criteria andCNameIsNotNull() {
            addCriterion("c_name is not null");
            return (Criteria) this;
        }

        public Criteria andCNameEqualTo(String value) {
            addCriterion("c_name =", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotEqualTo(String value) {
            addCriterion("c_name <>", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThan(String value) {
            addCriterion("c_name >", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThanOrEqualTo(String value) {
            addCriterion("c_name >=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThan(String value) {
            addCriterion("c_name <", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThanOrEqualTo(String value) {
            addCriterion("c_name <=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLike(String value) {
            addCriterion("c_name like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotLike(String value) {
            addCriterion("c_name not like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameIn(List<String> values) {
            addCriterion("c_name in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotIn(List<String> values) {
            addCriterion("c_name not in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameBetween(String value1, String value2) {
            addCriterion("c_name between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotBetween(String value1, String value2) {
            addCriterion("c_name not between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCDescIsNull() {
            addCriterion("c_desc is null");
            return (Criteria) this;
        }

        public Criteria andCDescIsNotNull() {
            addCriterion("c_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCDescEqualTo(String value) {
            addCriterion("c_desc =", value, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescNotEqualTo(String value) {
            addCriterion("c_desc <>", value, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescGreaterThan(String value) {
            addCriterion("c_desc >", value, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescGreaterThanOrEqualTo(String value) {
            addCriterion("c_desc >=", value, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescLessThan(String value) {
            addCriterion("c_desc <", value, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescLessThanOrEqualTo(String value) {
            addCriterion("c_desc <=", value, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescLike(String value) {
            addCriterion("c_desc like", value, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescNotLike(String value) {
            addCriterion("c_desc not like", value, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescIn(List<String> values) {
            addCriterion("c_desc in", values, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescNotIn(List<String> values) {
            addCriterion("c_desc not in", values, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescBetween(String value1, String value2) {
            addCriterion("c_desc between", value1, value2, "cDesc");
            return (Criteria) this;
        }

        public Criteria andCDescNotBetween(String value1, String value2) {
            addCriterion("c_desc not between", value1, value2, "cDesc");
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

        public Criteria andCOrderNumIsNull() {
            addCriterion("c_order_num is null");
            return (Criteria) this;
        }

        public Criteria andCOrderNumIsNotNull() {
            addCriterion("c_order_num is not null");
            return (Criteria) this;
        }

        public Criteria andCOrderNumEqualTo(Integer value) {
            addCriterion("c_order_num =", value, "cOrderNum");
            return (Criteria) this;
        }

        public Criteria andCOrderNumNotEqualTo(Integer value) {
            addCriterion("c_order_num <>", value, "cOrderNum");
            return (Criteria) this;
        }

        public Criteria andCOrderNumGreaterThan(Integer value) {
            addCriterion("c_order_num >", value, "cOrderNum");
            return (Criteria) this;
        }

        public Criteria andCOrderNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_order_num >=", value, "cOrderNum");
            return (Criteria) this;
        }

        public Criteria andCOrderNumLessThan(Integer value) {
            addCriterion("c_order_num <", value, "cOrderNum");
            return (Criteria) this;
        }

        public Criteria andCOrderNumLessThanOrEqualTo(Integer value) {
            addCriterion("c_order_num <=", value, "cOrderNum");
            return (Criteria) this;
        }

        public Criteria andCOrderNumIn(List<Integer> values) {
            addCriterion("c_order_num in", values, "cOrderNum");
            return (Criteria) this;
        }

        public Criteria andCOrderNumNotIn(List<Integer> values) {
            addCriterion("c_order_num not in", values, "cOrderNum");
            return (Criteria) this;
        }

        public Criteria andCOrderNumBetween(Integer value1, Integer value2) {
            addCriterion("c_order_num between", value1, value2, "cOrderNum");
            return (Criteria) this;
        }

        public Criteria andCOrderNumNotBetween(Integer value1, Integer value2) {
            addCriterion("c_order_num not between", value1, value2, "cOrderNum");
            return (Criteria) this;
        }

        public Criteria andCRankIdIsNull() {
            addCriterion("c_rank_id is null");
            return (Criteria) this;
        }

        public Criteria andCRankIdIsNotNull() {
            addCriterion("c_rank_id is not null");
            return (Criteria) this;
        }

        public Criteria andCRankIdEqualTo(Integer value) {
            addCriterion("c_rank_id =", value, "cRankId");
            return (Criteria) this;
        }

        public Criteria andCRankIdNotEqualTo(Integer value) {
            addCriterion("c_rank_id <>", value, "cRankId");
            return (Criteria) this;
        }

        public Criteria andCRankIdGreaterThan(Integer value) {
            addCriterion("c_rank_id >", value, "cRankId");
            return (Criteria) this;
        }

        public Criteria andCRankIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_rank_id >=", value, "cRankId");
            return (Criteria) this;
        }

        public Criteria andCRankIdLessThan(Integer value) {
            addCriterion("c_rank_id <", value, "cRankId");
            return (Criteria) this;
        }

        public Criteria andCRankIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_rank_id <=", value, "cRankId");
            return (Criteria) this;
        }

        public Criteria andCRankIdIn(List<Integer> values) {
            addCriterion("c_rank_id in", values, "cRankId");
            return (Criteria) this;
        }

        public Criteria andCRankIdNotIn(List<Integer> values) {
            addCriterion("c_rank_id not in", values, "cRankId");
            return (Criteria) this;
        }

        public Criteria andCRankIdBetween(Integer value1, Integer value2) {
            addCriterion("c_rank_id between", value1, value2, "cRankId");
            return (Criteria) this;
        }

        public Criteria andCRankIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_rank_id not between", value1, value2, "cRankId");
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