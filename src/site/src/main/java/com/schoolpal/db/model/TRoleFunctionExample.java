package com.schoolpal.db.model;

import java.util.ArrayList;
import java.util.List;

public class TRoleFunctionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRoleFunctionExample() {
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

        public Criteria andCFunctionRootIdIsNull() {
            addCriterion("c_function_root_id is null");
            return (Criteria) this;
        }

        public Criteria andCFunctionRootIdIsNotNull() {
            addCriterion("c_function_root_id is not null");
            return (Criteria) this;
        }

        public Criteria andCFunctionRootIdEqualTo(String value) {
            addCriterion("c_function_root_id =", value, "cFunctionRootId");
            return (Criteria) this;
        }

        public Criteria andCFunctionRootIdNotEqualTo(String value) {
            addCriterion("c_function_root_id <>", value, "cFunctionRootId");
            return (Criteria) this;
        }

        public Criteria andCFunctionRootIdGreaterThan(String value) {
            addCriterion("c_function_root_id >", value, "cFunctionRootId");
            return (Criteria) this;
        }

        public Criteria andCFunctionRootIdGreaterThanOrEqualTo(String value) {
            addCriterion("c_function_root_id >=", value, "cFunctionRootId");
            return (Criteria) this;
        }

        public Criteria andCFunctionRootIdLessThan(String value) {
            addCriterion("c_function_root_id <", value, "cFunctionRootId");
            return (Criteria) this;
        }

        public Criteria andCFunctionRootIdLessThanOrEqualTo(String value) {
            addCriterion("c_function_root_id <=", value, "cFunctionRootId");
            return (Criteria) this;
        }

        public Criteria andCFunctionRootIdLike(String value) {
            addCriterion("c_function_root_id like", value, "cFunctionRootId");
            return (Criteria) this;
        }

        public Criteria andCFunctionRootIdNotLike(String value) {
            addCriterion("c_function_root_id not like", value, "cFunctionRootId");
            return (Criteria) this;
        }

        public Criteria andCFunctionRootIdIn(List<String> values) {
            addCriterion("c_function_root_id in", values, "cFunctionRootId");
            return (Criteria) this;
        }

        public Criteria andCFunctionRootIdNotIn(List<String> values) {
            addCriterion("c_function_root_id not in", values, "cFunctionRootId");
            return (Criteria) this;
        }

        public Criteria andCFunctionRootIdBetween(String value1, String value2) {
            addCriterion("c_function_root_id between", value1, value2, "cFunctionRootId");
            return (Criteria) this;
        }

        public Criteria andCFunctionRootIdNotBetween(String value1, String value2) {
            addCriterion("c_function_root_id not between", value1, value2, "cFunctionRootId");
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