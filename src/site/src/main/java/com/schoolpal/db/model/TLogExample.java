package com.schoolpal.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TLogExample() {
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

        public Criteria andCTypeIsNull() {
            addCriterion("c_type is null");
            return (Criteria) this;
        }

        public Criteria andCTypeIsNotNull() {
            addCriterion("c_type is not null");
            return (Criteria) this;
        }

        public Criteria andCTypeEqualTo(String value) {
            addCriterion("c_type =", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotEqualTo(String value) {
            addCriterion("c_type <>", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeGreaterThan(String value) {
            addCriterion("c_type >", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeGreaterThanOrEqualTo(String value) {
            addCriterion("c_type >=", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLessThan(String value) {
            addCriterion("c_type <", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLessThanOrEqualTo(String value) {
            addCriterion("c_type <=", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLike(String value) {
            addCriterion("c_type like", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotLike(String value) {
            addCriterion("c_type not like", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeIn(List<String> values) {
            addCriterion("c_type in", values, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotIn(List<String> values) {
            addCriterion("c_type not in", values, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeBetween(String value1, String value2) {
            addCriterion("c_type between", value1, value2, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotBetween(String value1, String value2) {
            addCriterion("c_type not between", value1, value2, "cType");
            return (Criteria) this;
        }

        public Criteria andCTitleIsNull() {
            addCriterion("c_title is null");
            return (Criteria) this;
        }

        public Criteria andCTitleIsNotNull() {
            addCriterion("c_title is not null");
            return (Criteria) this;
        }

        public Criteria andCTitleEqualTo(String value) {
            addCriterion("c_title =", value, "cTitle");
            return (Criteria) this;
        }

        public Criteria andCTitleNotEqualTo(String value) {
            addCriterion("c_title <>", value, "cTitle");
            return (Criteria) this;
        }

        public Criteria andCTitleGreaterThan(String value) {
            addCriterion("c_title >", value, "cTitle");
            return (Criteria) this;
        }

        public Criteria andCTitleGreaterThanOrEqualTo(String value) {
            addCriterion("c_title >=", value, "cTitle");
            return (Criteria) this;
        }

        public Criteria andCTitleLessThan(String value) {
            addCriterion("c_title <", value, "cTitle");
            return (Criteria) this;
        }

        public Criteria andCTitleLessThanOrEqualTo(String value) {
            addCriterion("c_title <=", value, "cTitle");
            return (Criteria) this;
        }

        public Criteria andCTitleLike(String value) {
            addCriterion("c_title like", value, "cTitle");
            return (Criteria) this;
        }

        public Criteria andCTitleNotLike(String value) {
            addCriterion("c_title not like", value, "cTitle");
            return (Criteria) this;
        }

        public Criteria andCTitleIn(List<String> values) {
            addCriterion("c_title in", values, "cTitle");
            return (Criteria) this;
        }

        public Criteria andCTitleNotIn(List<String> values) {
            addCriterion("c_title not in", values, "cTitle");
            return (Criteria) this;
        }

        public Criteria andCTitleBetween(String value1, String value2) {
            addCriterion("c_title between", value1, value2, "cTitle");
            return (Criteria) this;
        }

        public Criteria andCTitleNotBetween(String value1, String value2) {
            addCriterion("c_title not between", value1, value2, "cTitle");
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

        public Criteria andCServiceIpIsNull() {
            addCriterion("c_service_ip is null");
            return (Criteria) this;
        }

        public Criteria andCServiceIpIsNotNull() {
            addCriterion("c_service_ip is not null");
            return (Criteria) this;
        }

        public Criteria andCServiceIpEqualTo(String value) {
            addCriterion("c_service_ip =", value, "cServiceIp");
            return (Criteria) this;
        }

        public Criteria andCServiceIpNotEqualTo(String value) {
            addCriterion("c_service_ip <>", value, "cServiceIp");
            return (Criteria) this;
        }

        public Criteria andCServiceIpGreaterThan(String value) {
            addCriterion("c_service_ip >", value, "cServiceIp");
            return (Criteria) this;
        }

        public Criteria andCServiceIpGreaterThanOrEqualTo(String value) {
            addCriterion("c_service_ip >=", value, "cServiceIp");
            return (Criteria) this;
        }

        public Criteria andCServiceIpLessThan(String value) {
            addCriterion("c_service_ip <", value, "cServiceIp");
            return (Criteria) this;
        }

        public Criteria andCServiceIpLessThanOrEqualTo(String value) {
            addCriterion("c_service_ip <=", value, "cServiceIp");
            return (Criteria) this;
        }

        public Criteria andCServiceIpLike(String value) {
            addCriterion("c_service_ip like", value, "cServiceIp");
            return (Criteria) this;
        }

        public Criteria andCServiceIpNotLike(String value) {
            addCriterion("c_service_ip not like", value, "cServiceIp");
            return (Criteria) this;
        }

        public Criteria andCServiceIpIn(List<String> values) {
            addCriterion("c_service_ip in", values, "cServiceIp");
            return (Criteria) this;
        }

        public Criteria andCServiceIpNotIn(List<String> values) {
            addCriterion("c_service_ip not in", values, "cServiceIp");
            return (Criteria) this;
        }

        public Criteria andCServiceIpBetween(String value1, String value2) {
            addCriterion("c_service_ip between", value1, value2, "cServiceIp");
            return (Criteria) this;
        }

        public Criteria andCServiceIpNotBetween(String value1, String value2) {
            addCriterion("c_service_ip not between", value1, value2, "cServiceIp");
            return (Criteria) this;
        }

        public Criteria andCUserIpIsNull() {
            addCriterion("c_user_ip is null");
            return (Criteria) this;
        }

        public Criteria andCUserIpIsNotNull() {
            addCriterion("c_user_ip is not null");
            return (Criteria) this;
        }

        public Criteria andCUserIpEqualTo(String value) {
            addCriterion("c_user_ip =", value, "cUserIp");
            return (Criteria) this;
        }

        public Criteria andCUserIpNotEqualTo(String value) {
            addCriterion("c_user_ip <>", value, "cUserIp");
            return (Criteria) this;
        }

        public Criteria andCUserIpGreaterThan(String value) {
            addCriterion("c_user_ip >", value, "cUserIp");
            return (Criteria) this;
        }

        public Criteria andCUserIpGreaterThanOrEqualTo(String value) {
            addCriterion("c_user_ip >=", value, "cUserIp");
            return (Criteria) this;
        }

        public Criteria andCUserIpLessThan(String value) {
            addCriterion("c_user_ip <", value, "cUserIp");
            return (Criteria) this;
        }

        public Criteria andCUserIpLessThanOrEqualTo(String value) {
            addCriterion("c_user_ip <=", value, "cUserIp");
            return (Criteria) this;
        }

        public Criteria andCUserIpLike(String value) {
            addCriterion("c_user_ip like", value, "cUserIp");
            return (Criteria) this;
        }

        public Criteria andCUserIpNotLike(String value) {
            addCriterion("c_user_ip not like", value, "cUserIp");
            return (Criteria) this;
        }

        public Criteria andCUserIpIn(List<String> values) {
            addCriterion("c_user_ip in", values, "cUserIp");
            return (Criteria) this;
        }

        public Criteria andCUserIpNotIn(List<String> values) {
            addCriterion("c_user_ip not in", values, "cUserIp");
            return (Criteria) this;
        }

        public Criteria andCUserIpBetween(String value1, String value2) {
            addCriterion("c_user_ip between", value1, value2, "cUserIp");
            return (Criteria) this;
        }

        public Criteria andCUserIpNotBetween(String value1, String value2) {
            addCriterion("c_user_ip not between", value1, value2, "cUserIp");
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