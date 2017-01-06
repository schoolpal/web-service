package com.schoolpal.db.model;

import java.util.ArrayList;
import java.util.List;

public class TFunctionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TFunctionExample() {
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

        public Criteria andCRootIdIsNull() {
            addCriterion("c_root_id is null");
            return (Criteria) this;
        }

        public Criteria andCRootIdIsNotNull() {
            addCriterion("c_root_id is not null");
            return (Criteria) this;
        }

        public Criteria andCRootIdEqualTo(String value) {
            addCriterion("c_root_id =", value, "cRootId");
            return (Criteria) this;
        }

        public Criteria andCRootIdNotEqualTo(String value) {
            addCriterion("c_root_id <>", value, "cRootId");
            return (Criteria) this;
        }

        public Criteria andCRootIdGreaterThan(String value) {
            addCriterion("c_root_id >", value, "cRootId");
            return (Criteria) this;
        }

        public Criteria andCRootIdGreaterThanOrEqualTo(String value) {
            addCriterion("c_root_id >=", value, "cRootId");
            return (Criteria) this;
        }

        public Criteria andCRootIdLessThan(String value) {
            addCriterion("c_root_id <", value, "cRootId");
            return (Criteria) this;
        }

        public Criteria andCRootIdLessThanOrEqualTo(String value) {
            addCriterion("c_root_id <=", value, "cRootId");
            return (Criteria) this;
        }

        public Criteria andCRootIdLike(String value) {
            addCriterion("c_root_id like", value, "cRootId");
            return (Criteria) this;
        }

        public Criteria andCRootIdNotLike(String value) {
            addCriterion("c_root_id not like", value, "cRootId");
            return (Criteria) this;
        }

        public Criteria andCRootIdIn(List<String> values) {
            addCriterion("c_root_id in", values, "cRootId");
            return (Criteria) this;
        }

        public Criteria andCRootIdNotIn(List<String> values) {
            addCriterion("c_root_id not in", values, "cRootId");
            return (Criteria) this;
        }

        public Criteria andCRootIdBetween(String value1, String value2) {
            addCriterion("c_root_id between", value1, value2, "cRootId");
            return (Criteria) this;
        }

        public Criteria andCRootIdNotBetween(String value1, String value2) {
            addCriterion("c_root_id not between", value1, value2, "cRootId");
            return (Criteria) this;
        }

        public Criteria andCParentIdIsNull() {
            addCriterion("c_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andCParentIdIsNotNull() {
            addCriterion("c_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andCParentIdEqualTo(String value) {
            addCriterion("c_parent_id =", value, "cParentId");
            return (Criteria) this;
        }

        public Criteria andCParentIdNotEqualTo(String value) {
            addCriterion("c_parent_id <>", value, "cParentId");
            return (Criteria) this;
        }

        public Criteria andCParentIdGreaterThan(String value) {
            addCriterion("c_parent_id >", value, "cParentId");
            return (Criteria) this;
        }

        public Criteria andCParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("c_parent_id >=", value, "cParentId");
            return (Criteria) this;
        }

        public Criteria andCParentIdLessThan(String value) {
            addCriterion("c_parent_id <", value, "cParentId");
            return (Criteria) this;
        }

        public Criteria andCParentIdLessThanOrEqualTo(String value) {
            addCriterion("c_parent_id <=", value, "cParentId");
            return (Criteria) this;
        }

        public Criteria andCParentIdLike(String value) {
            addCriterion("c_parent_id like", value, "cParentId");
            return (Criteria) this;
        }

        public Criteria andCParentIdNotLike(String value) {
            addCriterion("c_parent_id not like", value, "cParentId");
            return (Criteria) this;
        }

        public Criteria andCParentIdIn(List<String> values) {
            addCriterion("c_parent_id in", values, "cParentId");
            return (Criteria) this;
        }

        public Criteria andCParentIdNotIn(List<String> values) {
            addCriterion("c_parent_id not in", values, "cParentId");
            return (Criteria) this;
        }

        public Criteria andCParentIdBetween(String value1, String value2) {
            addCriterion("c_parent_id between", value1, value2, "cParentId");
            return (Criteria) this;
        }

        public Criteria andCParentIdNotBetween(String value1, String value2) {
            addCriterion("c_parent_id not between", value1, value2, "cParentId");
            return (Criteria) this;
        }

        public Criteria andCNameShortIsNull() {
            addCriterion("c_name_short is null");
            return (Criteria) this;
        }

        public Criteria andCNameShortIsNotNull() {
            addCriterion("c_name_short is not null");
            return (Criteria) this;
        }

        public Criteria andCNameShortEqualTo(String value) {
            addCriterion("c_name_short =", value, "cNameShort");
            return (Criteria) this;
        }

        public Criteria andCNameShortNotEqualTo(String value) {
            addCriterion("c_name_short <>", value, "cNameShort");
            return (Criteria) this;
        }

        public Criteria andCNameShortGreaterThan(String value) {
            addCriterion("c_name_short >", value, "cNameShort");
            return (Criteria) this;
        }

        public Criteria andCNameShortGreaterThanOrEqualTo(String value) {
            addCriterion("c_name_short >=", value, "cNameShort");
            return (Criteria) this;
        }

        public Criteria andCNameShortLessThan(String value) {
            addCriterion("c_name_short <", value, "cNameShort");
            return (Criteria) this;
        }

        public Criteria andCNameShortLessThanOrEqualTo(String value) {
            addCriterion("c_name_short <=", value, "cNameShort");
            return (Criteria) this;
        }

        public Criteria andCNameShortLike(String value) {
            addCriterion("c_name_short like", value, "cNameShort");
            return (Criteria) this;
        }

        public Criteria andCNameShortNotLike(String value) {
            addCriterion("c_name_short not like", value, "cNameShort");
            return (Criteria) this;
        }

        public Criteria andCNameShortIn(List<String> values) {
            addCriterion("c_name_short in", values, "cNameShort");
            return (Criteria) this;
        }

        public Criteria andCNameShortNotIn(List<String> values) {
            addCriterion("c_name_short not in", values, "cNameShort");
            return (Criteria) this;
        }

        public Criteria andCNameShortBetween(String value1, String value2) {
            addCriterion("c_name_short between", value1, value2, "cNameShort");
            return (Criteria) this;
        }

        public Criteria andCNameShortNotBetween(String value1, String value2) {
            addCriterion("c_name_short not between", value1, value2, "cNameShort");
            return (Criteria) this;
        }

        public Criteria andCNameLongIsNull() {
            addCriterion("c_name_long is null");
            return (Criteria) this;
        }

        public Criteria andCNameLongIsNotNull() {
            addCriterion("c_name_long is not null");
            return (Criteria) this;
        }

        public Criteria andCNameLongEqualTo(String value) {
            addCriterion("c_name_long =", value, "cNameLong");
            return (Criteria) this;
        }

        public Criteria andCNameLongNotEqualTo(String value) {
            addCriterion("c_name_long <>", value, "cNameLong");
            return (Criteria) this;
        }

        public Criteria andCNameLongGreaterThan(String value) {
            addCriterion("c_name_long >", value, "cNameLong");
            return (Criteria) this;
        }

        public Criteria andCNameLongGreaterThanOrEqualTo(String value) {
            addCriterion("c_name_long >=", value, "cNameLong");
            return (Criteria) this;
        }

        public Criteria andCNameLongLessThan(String value) {
            addCriterion("c_name_long <", value, "cNameLong");
            return (Criteria) this;
        }

        public Criteria andCNameLongLessThanOrEqualTo(String value) {
            addCriterion("c_name_long <=", value, "cNameLong");
            return (Criteria) this;
        }

        public Criteria andCNameLongLike(String value) {
            addCriterion("c_name_long like", value, "cNameLong");
            return (Criteria) this;
        }

        public Criteria andCNameLongNotLike(String value) {
            addCriterion("c_name_long not like", value, "cNameLong");
            return (Criteria) this;
        }

        public Criteria andCNameLongIn(List<String> values) {
            addCriterion("c_name_long in", values, "cNameLong");
            return (Criteria) this;
        }

        public Criteria andCNameLongNotIn(List<String> values) {
            addCriterion("c_name_long not in", values, "cNameLong");
            return (Criteria) this;
        }

        public Criteria andCNameLongBetween(String value1, String value2) {
            addCriterion("c_name_long between", value1, value2, "cNameLong");
            return (Criteria) this;
        }

        public Criteria andCNameLongNotBetween(String value1, String value2) {
            addCriterion("c_name_long not between", value1, value2, "cNameLong");
            return (Criteria) this;
        }

        public Criteria andCActionIsNull() {
            addCriterion("c_action is null");
            return (Criteria) this;
        }

        public Criteria andCActionIsNotNull() {
            addCriterion("c_action is not null");
            return (Criteria) this;
        }

        public Criteria andCActionEqualTo(String value) {
            addCriterion("c_action =", value, "cAction");
            return (Criteria) this;
        }

        public Criteria andCActionNotEqualTo(String value) {
            addCriterion("c_action <>", value, "cAction");
            return (Criteria) this;
        }

        public Criteria andCActionGreaterThan(String value) {
            addCriterion("c_action >", value, "cAction");
            return (Criteria) this;
        }

        public Criteria andCActionGreaterThanOrEqualTo(String value) {
            addCriterion("c_action >=", value, "cAction");
            return (Criteria) this;
        }

        public Criteria andCActionLessThan(String value) {
            addCriterion("c_action <", value, "cAction");
            return (Criteria) this;
        }

        public Criteria andCActionLessThanOrEqualTo(String value) {
            addCriterion("c_action <=", value, "cAction");
            return (Criteria) this;
        }

        public Criteria andCActionLike(String value) {
            addCriterion("c_action like", value, "cAction");
            return (Criteria) this;
        }

        public Criteria andCActionNotLike(String value) {
            addCriterion("c_action not like", value, "cAction");
            return (Criteria) this;
        }

        public Criteria andCActionIn(List<String> values) {
            addCriterion("c_action in", values, "cAction");
            return (Criteria) this;
        }

        public Criteria andCActionNotIn(List<String> values) {
            addCriterion("c_action not in", values, "cAction");
            return (Criteria) this;
        }

        public Criteria andCActionBetween(String value1, String value2) {
            addCriterion("c_action between", value1, value2, "cAction");
            return (Criteria) this;
        }

        public Criteria andCActionNotBetween(String value1, String value2) {
            addCriterion("c_action not between", value1, value2, "cAction");
            return (Criteria) this;
        }

        public Criteria andCWidgetTypeIdIsNull() {
            addCriterion("c_widget_type_id is null");
            return (Criteria) this;
        }

        public Criteria andCWidgetTypeIdIsNotNull() {
            addCriterion("c_widget_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andCWidgetTypeIdEqualTo(Integer value) {
            addCriterion("c_widget_type_id =", value, "cWidgetTypeId");
            return (Criteria) this;
        }

        public Criteria andCWidgetTypeIdNotEqualTo(Integer value) {
            addCriterion("c_widget_type_id <>", value, "cWidgetTypeId");
            return (Criteria) this;
        }

        public Criteria andCWidgetTypeIdGreaterThan(Integer value) {
            addCriterion("c_widget_type_id >", value, "cWidgetTypeId");
            return (Criteria) this;
        }

        public Criteria andCWidgetTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_widget_type_id >=", value, "cWidgetTypeId");
            return (Criteria) this;
        }

        public Criteria andCWidgetTypeIdLessThan(Integer value) {
            addCriterion("c_widget_type_id <", value, "cWidgetTypeId");
            return (Criteria) this;
        }

        public Criteria andCWidgetTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_widget_type_id <=", value, "cWidgetTypeId");
            return (Criteria) this;
        }

        public Criteria andCWidgetTypeIdIn(List<Integer> values) {
            addCriterion("c_widget_type_id in", values, "cWidgetTypeId");
            return (Criteria) this;
        }

        public Criteria andCWidgetTypeIdNotIn(List<Integer> values) {
            addCriterion("c_widget_type_id not in", values, "cWidgetTypeId");
            return (Criteria) this;
        }

        public Criteria andCWidgetTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("c_widget_type_id between", value1, value2, "cWidgetTypeId");
            return (Criteria) this;
        }

        public Criteria andCWidgetTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_widget_type_id not between", value1, value2, "cWidgetTypeId");
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

        public Criteria andCIconIsNull() {
            addCriterion("c_icon is null");
            return (Criteria) this;
        }

        public Criteria andCIconIsNotNull() {
            addCriterion("c_icon is not null");
            return (Criteria) this;
        }

        public Criteria andCIconEqualTo(String value) {
            addCriterion("c_icon =", value, "cIcon");
            return (Criteria) this;
        }

        public Criteria andCIconNotEqualTo(String value) {
            addCriterion("c_icon <>", value, "cIcon");
            return (Criteria) this;
        }

        public Criteria andCIconGreaterThan(String value) {
            addCriterion("c_icon >", value, "cIcon");
            return (Criteria) this;
        }

        public Criteria andCIconGreaterThanOrEqualTo(String value) {
            addCriterion("c_icon >=", value, "cIcon");
            return (Criteria) this;
        }

        public Criteria andCIconLessThan(String value) {
            addCriterion("c_icon <", value, "cIcon");
            return (Criteria) this;
        }

        public Criteria andCIconLessThanOrEqualTo(String value) {
            addCriterion("c_icon <=", value, "cIcon");
            return (Criteria) this;
        }

        public Criteria andCIconLike(String value) {
            addCriterion("c_icon like", value, "cIcon");
            return (Criteria) this;
        }

        public Criteria andCIconNotLike(String value) {
            addCriterion("c_icon not like", value, "cIcon");
            return (Criteria) this;
        }

        public Criteria andCIconIn(List<String> values) {
            addCriterion("c_icon in", values, "cIcon");
            return (Criteria) this;
        }

        public Criteria andCIconNotIn(List<String> values) {
            addCriterion("c_icon not in", values, "cIcon");
            return (Criteria) this;
        }

        public Criteria andCIconBetween(String value1, String value2) {
            addCriterion("c_icon between", value1, value2, "cIcon");
            return (Criteria) this;
        }

        public Criteria andCIconNotBetween(String value1, String value2) {
            addCriterion("c_icon not between", value1, value2, "cIcon");
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