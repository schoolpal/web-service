package com.schoolpal.db.model;

import java.util.ArrayList;
import java.util.List;

public class TIndexExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TIndexExample() {
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

        public Criteria andCTableIsNull() {
            addCriterion("c_table is null");
            return (Criteria) this;
        }

        public Criteria andCTableIsNotNull() {
            addCriterion("c_table is not null");
            return (Criteria) this;
        }

        public Criteria andCTableEqualTo(String value) {
            addCriterion("c_table =", value, "cTable");
            return (Criteria) this;
        }

        public Criteria andCTableNotEqualTo(String value) {
            addCriterion("c_table <>", value, "cTable");
            return (Criteria) this;
        }

        public Criteria andCTableGreaterThan(String value) {
            addCriterion("c_table >", value, "cTable");
            return (Criteria) this;
        }

        public Criteria andCTableGreaterThanOrEqualTo(String value) {
            addCriterion("c_table >=", value, "cTable");
            return (Criteria) this;
        }

        public Criteria andCTableLessThan(String value) {
            addCriterion("c_table <", value, "cTable");
            return (Criteria) this;
        }

        public Criteria andCTableLessThanOrEqualTo(String value) {
            addCriterion("c_table <=", value, "cTable");
            return (Criteria) this;
        }

        public Criteria andCTableLike(String value) {
            addCriterion("c_table like", value, "cTable");
            return (Criteria) this;
        }

        public Criteria andCTableNotLike(String value) {
            addCriterion("c_table not like", value, "cTable");
            return (Criteria) this;
        }

        public Criteria andCTableIn(List<String> values) {
            addCriterion("c_table in", values, "cTable");
            return (Criteria) this;
        }

        public Criteria andCTableNotIn(List<String> values) {
            addCriterion("c_table not in", values, "cTable");
            return (Criteria) this;
        }

        public Criteria andCTableBetween(String value1, String value2) {
            addCriterion("c_table between", value1, value2, "cTable");
            return (Criteria) this;
        }

        public Criteria andCTableNotBetween(String value1, String value2) {
            addCriterion("c_table not between", value1, value2, "cTable");
            return (Criteria) this;
        }

        public Criteria andCPrefixIsNull() {
            addCriterion("c_prefix is null");
            return (Criteria) this;
        }

        public Criteria andCPrefixIsNotNull() {
            addCriterion("c_prefix is not null");
            return (Criteria) this;
        }

        public Criteria andCPrefixEqualTo(String value) {
            addCriterion("c_prefix =", value, "cPrefix");
            return (Criteria) this;
        }

        public Criteria andCPrefixNotEqualTo(String value) {
            addCriterion("c_prefix <>", value, "cPrefix");
            return (Criteria) this;
        }

        public Criteria andCPrefixGreaterThan(String value) {
            addCriterion("c_prefix >", value, "cPrefix");
            return (Criteria) this;
        }

        public Criteria andCPrefixGreaterThanOrEqualTo(String value) {
            addCriterion("c_prefix >=", value, "cPrefix");
            return (Criteria) this;
        }

        public Criteria andCPrefixLessThan(String value) {
            addCriterion("c_prefix <", value, "cPrefix");
            return (Criteria) this;
        }

        public Criteria andCPrefixLessThanOrEqualTo(String value) {
            addCriterion("c_prefix <=", value, "cPrefix");
            return (Criteria) this;
        }

        public Criteria andCPrefixLike(String value) {
            addCriterion("c_prefix like", value, "cPrefix");
            return (Criteria) this;
        }

        public Criteria andCPrefixNotLike(String value) {
            addCriterion("c_prefix not like", value, "cPrefix");
            return (Criteria) this;
        }

        public Criteria andCPrefixIn(List<String> values) {
            addCriterion("c_prefix in", values, "cPrefix");
            return (Criteria) this;
        }

        public Criteria andCPrefixNotIn(List<String> values) {
            addCriterion("c_prefix not in", values, "cPrefix");
            return (Criteria) this;
        }

        public Criteria andCPrefixBetween(String value1, String value2) {
            addCriterion("c_prefix between", value1, value2, "cPrefix");
            return (Criteria) this;
        }

        public Criteria andCPrefixNotBetween(String value1, String value2) {
            addCriterion("c_prefix not between", value1, value2, "cPrefix");
            return (Criteria) this;
        }

        public Criteria andCCurrentIsNull() {
            addCriterion("c_current is null");
            return (Criteria) this;
        }

        public Criteria andCCurrentIsNotNull() {
            addCriterion("c_current is not null");
            return (Criteria) this;
        }

        public Criteria andCCurrentEqualTo(Long value) {
            addCriterion("c_current =", value, "cCurrent");
            return (Criteria) this;
        }

        public Criteria andCCurrentNotEqualTo(Long value) {
            addCriterion("c_current <>", value, "cCurrent");
            return (Criteria) this;
        }

        public Criteria andCCurrentGreaterThan(Long value) {
            addCriterion("c_current >", value, "cCurrent");
            return (Criteria) this;
        }

        public Criteria andCCurrentGreaterThanOrEqualTo(Long value) {
            addCriterion("c_current >=", value, "cCurrent");
            return (Criteria) this;
        }

        public Criteria andCCurrentLessThan(Long value) {
            addCriterion("c_current <", value, "cCurrent");
            return (Criteria) this;
        }

        public Criteria andCCurrentLessThanOrEqualTo(Long value) {
            addCriterion("c_current <=", value, "cCurrent");
            return (Criteria) this;
        }

        public Criteria andCCurrentIn(List<Long> values) {
            addCriterion("c_current in", values, "cCurrent");
            return (Criteria) this;
        }

        public Criteria andCCurrentNotIn(List<Long> values) {
            addCriterion("c_current not in", values, "cCurrent");
            return (Criteria) this;
        }

        public Criteria andCCurrentBetween(Long value1, Long value2) {
            addCriterion("c_current between", value1, value2, "cCurrent");
            return (Criteria) this;
        }

        public Criteria andCCurrentNotBetween(Long value1, Long value2) {
            addCriterion("c_current not between", value1, value2, "cCurrent");
            return (Criteria) this;
        }

        public Criteria andCStepIsNull() {
            addCriterion("c_step is null");
            return (Criteria) this;
        }

        public Criteria andCStepIsNotNull() {
            addCriterion("c_step is not null");
            return (Criteria) this;
        }

        public Criteria andCStepEqualTo(Integer value) {
            addCriterion("c_step =", value, "cStep");
            return (Criteria) this;
        }

        public Criteria andCStepNotEqualTo(Integer value) {
            addCriterion("c_step <>", value, "cStep");
            return (Criteria) this;
        }

        public Criteria andCStepGreaterThan(Integer value) {
            addCriterion("c_step >", value, "cStep");
            return (Criteria) this;
        }

        public Criteria andCStepGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_step >=", value, "cStep");
            return (Criteria) this;
        }

        public Criteria andCStepLessThan(Integer value) {
            addCriterion("c_step <", value, "cStep");
            return (Criteria) this;
        }

        public Criteria andCStepLessThanOrEqualTo(Integer value) {
            addCriterion("c_step <=", value, "cStep");
            return (Criteria) this;
        }

        public Criteria andCStepIn(List<Integer> values) {
            addCriterion("c_step in", values, "cStep");
            return (Criteria) this;
        }

        public Criteria andCStepNotIn(List<Integer> values) {
            addCriterion("c_step not in", values, "cStep");
            return (Criteria) this;
        }

        public Criteria andCStepBetween(Integer value1, Integer value2) {
            addCriterion("c_step between", value1, value2, "cStep");
            return (Criteria) this;
        }

        public Criteria andCStepNotBetween(Integer value1, Integer value2) {
            addCriterion("c_step not between", value1, value2, "cStep");
            return (Criteria) this;
        }

        public Criteria andCBitsIsNull() {
            addCriterion("c_bits is null");
            return (Criteria) this;
        }

        public Criteria andCBitsIsNotNull() {
            addCriterion("c_bits is not null");
            return (Criteria) this;
        }

        public Criteria andCBitsEqualTo(Byte value) {
            addCriterion("c_bits =", value, "cBits");
            return (Criteria) this;
        }

        public Criteria andCBitsNotEqualTo(Byte value) {
            addCriterion("c_bits <>", value, "cBits");
            return (Criteria) this;
        }

        public Criteria andCBitsGreaterThan(Byte value) {
            addCriterion("c_bits >", value, "cBits");
            return (Criteria) this;
        }

        public Criteria andCBitsGreaterThanOrEqualTo(Byte value) {
            addCriterion("c_bits >=", value, "cBits");
            return (Criteria) this;
        }

        public Criteria andCBitsLessThan(Byte value) {
            addCriterion("c_bits <", value, "cBits");
            return (Criteria) this;
        }

        public Criteria andCBitsLessThanOrEqualTo(Byte value) {
            addCriterion("c_bits <=", value, "cBits");
            return (Criteria) this;
        }

        public Criteria andCBitsIn(List<Byte> values) {
            addCriterion("c_bits in", values, "cBits");
            return (Criteria) this;
        }

        public Criteria andCBitsNotIn(List<Byte> values) {
            addCriterion("c_bits not in", values, "cBits");
            return (Criteria) this;
        }

        public Criteria andCBitsBetween(Byte value1, Byte value2) {
            addCriterion("c_bits between", value1, value2, "cBits");
            return (Criteria) this;
        }

        public Criteria andCBitsNotBetween(Byte value1, Byte value2) {
            addCriterion("c_bits not between", value1, value2, "cBits");
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