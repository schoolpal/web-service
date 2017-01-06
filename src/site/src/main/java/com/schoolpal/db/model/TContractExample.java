package com.schoolpal.db.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TContractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TContractExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNull() {
            addCriterion("original_price is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNotNull() {
            addCriterion("original_price is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceEqualTo(BigDecimal value) {
            addCriterion("original_price =", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotEqualTo(BigDecimal value) {
            addCriterion("original_price <>", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThan(BigDecimal value) {
            addCriterion("original_price >", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("original_price >=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThan(BigDecimal value) {
            addCriterion("original_price <", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("original_price <=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIn(List<BigDecimal> values) {
            addCriterion("original_price in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotIn(List<BigDecimal> values) {
            addCriterion("original_price not in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("original_price between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("original_price not between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNull() {
            addCriterion("discount_price is null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNotNull() {
            addCriterion("discount_price is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceEqualTo(BigDecimal value) {
            addCriterion("discount_price =", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotEqualTo(BigDecimal value) {
            addCriterion("discount_price <>", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThan(BigDecimal value) {
            addCriterion("discount_price >", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_price >=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThan(BigDecimal value) {
            addCriterion("discount_price <", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_price <=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIn(List<BigDecimal> values) {
            addCriterion("discount_price in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotIn(List<BigDecimal> values) {
            addCriterion("discount_price not in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_price between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_price not between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceIsNull() {
            addCriterion("final_price is null");
            return (Criteria) this;
        }

        public Criteria andFinalPriceIsNotNull() {
            addCriterion("final_price is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPriceEqualTo(BigDecimal value) {
            addCriterion("final_price =", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceNotEqualTo(BigDecimal value) {
            addCriterion("final_price <>", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceGreaterThan(BigDecimal value) {
            addCriterion("final_price >", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("final_price >=", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceLessThan(BigDecimal value) {
            addCriterion("final_price <", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("final_price <=", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceIn(List<BigDecimal> values) {
            addCriterion("final_price in", values, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceNotIn(List<BigDecimal> values) {
            addCriterion("final_price not in", values, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_price between", value1, value2, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_price not between", value1, value2, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andPaidIsNull() {
            addCriterion("paid is null");
            return (Criteria) this;
        }

        public Criteria andPaidIsNotNull() {
            addCriterion("paid is not null");
            return (Criteria) this;
        }

        public Criteria andPaidEqualTo(BigDecimal value) {
            addCriterion("paid =", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidNotEqualTo(BigDecimal value) {
            addCriterion("paid <>", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidGreaterThan(BigDecimal value) {
            addCriterion("paid >", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("paid >=", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidLessThan(BigDecimal value) {
            addCriterion("paid <", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("paid <=", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidIn(List<BigDecimal> values) {
            addCriterion("paid in", values, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidNotIn(List<BigDecimal> values) {
            addCriterion("paid not in", values, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paid between", value1, value2, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paid not between", value1, value2, "paid");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNull() {
            addCriterion("course_type is null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNotNull() {
            addCriterion("course_type is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeEqualTo(String value) {
            addCriterion("course_type =", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotEqualTo(String value) {
            addCriterion("course_type <>", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThan(String value) {
            addCriterion("course_type >", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("course_type >=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThan(String value) {
            addCriterion("course_type <", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThanOrEqualTo(String value) {
            addCriterion("course_type <=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLike(String value) {
            addCriterion("course_type like", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotLike(String value) {
            addCriterion("course_type not like", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIn(List<String> values) {
            addCriterion("course_type in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotIn(List<String> values) {
            addCriterion("course_type not in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeBetween(String value1, String value2) {
            addCriterion("course_type between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotBetween(String value1, String value2) {
            addCriterion("course_type not between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseOriIdIsNull() {
            addCriterion("course_ori_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseOriIdIsNotNull() {
            addCriterion("course_ori_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseOriIdEqualTo(Integer value) {
            addCriterion("course_ori_id =", value, "courseOriId");
            return (Criteria) this;
        }

        public Criteria andCourseOriIdNotEqualTo(Integer value) {
            addCriterion("course_ori_id <>", value, "courseOriId");
            return (Criteria) this;
        }

        public Criteria andCourseOriIdGreaterThan(Integer value) {
            addCriterion("course_ori_id >", value, "courseOriId");
            return (Criteria) this;
        }

        public Criteria andCourseOriIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_ori_id >=", value, "courseOriId");
            return (Criteria) this;
        }

        public Criteria andCourseOriIdLessThan(Integer value) {
            addCriterion("course_ori_id <", value, "courseOriId");
            return (Criteria) this;
        }

        public Criteria andCourseOriIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_ori_id <=", value, "courseOriId");
            return (Criteria) this;
        }

        public Criteria andCourseOriIdIn(List<Integer> values) {
            addCriterion("course_ori_id in", values, "courseOriId");
            return (Criteria) this;
        }

        public Criteria andCourseOriIdNotIn(List<Integer> values) {
            addCriterion("course_ori_id not in", values, "courseOriId");
            return (Criteria) this;
        }

        public Criteria andCourseOriIdBetween(Integer value1, Integer value2) {
            addCriterion("course_ori_id between", value1, value2, "courseOriId");
            return (Criteria) this;
        }

        public Criteria andCourseOriIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_ori_id not between", value1, value2, "courseOriId");
            return (Criteria) this;
        }

        public Criteria andCourseHoursIsNull() {
            addCriterion("course_hours is null");
            return (Criteria) this;
        }

        public Criteria andCourseHoursIsNotNull() {
            addCriterion("course_hours is not null");
            return (Criteria) this;
        }

        public Criteria andCourseHoursEqualTo(String value) {
            addCriterion("course_hours =", value, "courseHours");
            return (Criteria) this;
        }

        public Criteria andCourseHoursNotEqualTo(String value) {
            addCriterion("course_hours <>", value, "courseHours");
            return (Criteria) this;
        }

        public Criteria andCourseHoursGreaterThan(String value) {
            addCriterion("course_hours >", value, "courseHours");
            return (Criteria) this;
        }

        public Criteria andCourseHoursGreaterThanOrEqualTo(String value) {
            addCriterion("course_hours >=", value, "courseHours");
            return (Criteria) this;
        }

        public Criteria andCourseHoursLessThan(String value) {
            addCriterion("course_hours <", value, "courseHours");
            return (Criteria) this;
        }

        public Criteria andCourseHoursLessThanOrEqualTo(String value) {
            addCriterion("course_hours <=", value, "courseHours");
            return (Criteria) this;
        }

        public Criteria andCourseHoursLike(String value) {
            addCriterion("course_hours like", value, "courseHours");
            return (Criteria) this;
        }

        public Criteria andCourseHoursNotLike(String value) {
            addCriterion("course_hours not like", value, "courseHours");
            return (Criteria) this;
        }

        public Criteria andCourseHoursIn(List<String> values) {
            addCriterion("course_hours in", values, "courseHours");
            return (Criteria) this;
        }

        public Criteria andCourseHoursNotIn(List<String> values) {
            addCriterion("course_hours not in", values, "courseHours");
            return (Criteria) this;
        }

        public Criteria andCourseHoursBetween(String value1, String value2) {
            addCriterion("course_hours between", value1, value2, "courseHours");
            return (Criteria) this;
        }

        public Criteria andCourseHoursNotBetween(String value1, String value2) {
            addCriterion("course_hours not between", value1, value2, "courseHours");
            return (Criteria) this;
        }

        public Criteria andCourseTimesIsNull() {
            addCriterion("course_times is null");
            return (Criteria) this;
        }

        public Criteria andCourseTimesIsNotNull() {
            addCriterion("course_times is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTimesEqualTo(String value) {
            addCriterion("course_times =", value, "courseTimes");
            return (Criteria) this;
        }

        public Criteria andCourseTimesNotEqualTo(String value) {
            addCriterion("course_times <>", value, "courseTimes");
            return (Criteria) this;
        }

        public Criteria andCourseTimesGreaterThan(String value) {
            addCriterion("course_times >", value, "courseTimes");
            return (Criteria) this;
        }

        public Criteria andCourseTimesGreaterThanOrEqualTo(String value) {
            addCriterion("course_times >=", value, "courseTimes");
            return (Criteria) this;
        }

        public Criteria andCourseTimesLessThan(String value) {
            addCriterion("course_times <", value, "courseTimes");
            return (Criteria) this;
        }

        public Criteria andCourseTimesLessThanOrEqualTo(String value) {
            addCriterion("course_times <=", value, "courseTimes");
            return (Criteria) this;
        }

        public Criteria andCourseTimesLike(String value) {
            addCriterion("course_times like", value, "courseTimes");
            return (Criteria) this;
        }

        public Criteria andCourseTimesNotLike(String value) {
            addCriterion("course_times not like", value, "courseTimes");
            return (Criteria) this;
        }

        public Criteria andCourseTimesIn(List<String> values) {
            addCriterion("course_times in", values, "courseTimes");
            return (Criteria) this;
        }

        public Criteria andCourseTimesNotIn(List<String> values) {
            addCriterion("course_times not in", values, "courseTimes");
            return (Criteria) this;
        }

        public Criteria andCourseTimesBetween(String value1, String value2) {
            addCriterion("course_times between", value1, value2, "courseTimes");
            return (Criteria) this;
        }

        public Criteria andCourseTimesNotBetween(String value1, String value2) {
            addCriterion("course_times not between", value1, value2, "courseTimes");
            return (Criteria) this;
        }

        public Criteria andStuOriIdIsNull() {
            addCriterion("stu_ori_id is null");
            return (Criteria) this;
        }

        public Criteria andStuOriIdIsNotNull() {
            addCriterion("stu_ori_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuOriIdEqualTo(String value) {
            addCriterion("stu_ori_id =", value, "stuOriId");
            return (Criteria) this;
        }

        public Criteria andStuOriIdNotEqualTo(String value) {
            addCriterion("stu_ori_id <>", value, "stuOriId");
            return (Criteria) this;
        }

        public Criteria andStuOriIdGreaterThan(String value) {
            addCriterion("stu_ori_id >", value, "stuOriId");
            return (Criteria) this;
        }

        public Criteria andStuOriIdGreaterThanOrEqualTo(String value) {
            addCriterion("stu_ori_id >=", value, "stuOriId");
            return (Criteria) this;
        }

        public Criteria andStuOriIdLessThan(String value) {
            addCriterion("stu_ori_id <", value, "stuOriId");
            return (Criteria) this;
        }

        public Criteria andStuOriIdLessThanOrEqualTo(String value) {
            addCriterion("stu_ori_id <=", value, "stuOriId");
            return (Criteria) this;
        }

        public Criteria andStuOriIdLike(String value) {
            addCriterion("stu_ori_id like", value, "stuOriId");
            return (Criteria) this;
        }

        public Criteria andStuOriIdNotLike(String value) {
            addCriterion("stu_ori_id not like", value, "stuOriId");
            return (Criteria) this;
        }

        public Criteria andStuOriIdIn(List<String> values) {
            addCriterion("stu_ori_id in", values, "stuOriId");
            return (Criteria) this;
        }

        public Criteria andStuOriIdNotIn(List<String> values) {
            addCriterion("stu_ori_id not in", values, "stuOriId");
            return (Criteria) this;
        }

        public Criteria andStuOriIdBetween(String value1, String value2) {
            addCriterion("stu_ori_id between", value1, value2, "stuOriId");
            return (Criteria) this;
        }

        public Criteria andStuOriIdNotBetween(String value1, String value2) {
            addCriterion("stu_ori_id not between", value1, value2, "stuOriId");
            return (Criteria) this;
        }

        public Criteria andStuFirstnameIsNull() {
            addCriterion("stu_firstname is null");
            return (Criteria) this;
        }

        public Criteria andStuFirstnameIsNotNull() {
            addCriterion("stu_firstname is not null");
            return (Criteria) this;
        }

        public Criteria andStuFirstnameEqualTo(String value) {
            addCriterion("stu_firstname =", value, "stuFirstname");
            return (Criteria) this;
        }

        public Criteria andStuFirstnameNotEqualTo(String value) {
            addCriterion("stu_firstname <>", value, "stuFirstname");
            return (Criteria) this;
        }

        public Criteria andStuFirstnameGreaterThan(String value) {
            addCriterion("stu_firstname >", value, "stuFirstname");
            return (Criteria) this;
        }

        public Criteria andStuFirstnameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_firstname >=", value, "stuFirstname");
            return (Criteria) this;
        }

        public Criteria andStuFirstnameLessThan(String value) {
            addCriterion("stu_firstname <", value, "stuFirstname");
            return (Criteria) this;
        }

        public Criteria andStuFirstnameLessThanOrEqualTo(String value) {
            addCriterion("stu_firstname <=", value, "stuFirstname");
            return (Criteria) this;
        }

        public Criteria andStuFirstnameLike(String value) {
            addCriterion("stu_firstname like", value, "stuFirstname");
            return (Criteria) this;
        }

        public Criteria andStuFirstnameNotLike(String value) {
            addCriterion("stu_firstname not like", value, "stuFirstname");
            return (Criteria) this;
        }

        public Criteria andStuFirstnameIn(List<String> values) {
            addCriterion("stu_firstname in", values, "stuFirstname");
            return (Criteria) this;
        }

        public Criteria andStuFirstnameNotIn(List<String> values) {
            addCriterion("stu_firstname not in", values, "stuFirstname");
            return (Criteria) this;
        }

        public Criteria andStuFirstnameBetween(String value1, String value2) {
            addCriterion("stu_firstname between", value1, value2, "stuFirstname");
            return (Criteria) this;
        }

        public Criteria andStuFirstnameNotBetween(String value1, String value2) {
            addCriterion("stu_firstname not between", value1, value2, "stuFirstname");
            return (Criteria) this;
        }

        public Criteria andStuLastnameIsNull() {
            addCriterion("stu_lastname is null");
            return (Criteria) this;
        }

        public Criteria andStuLastnameIsNotNull() {
            addCriterion("stu_lastname is not null");
            return (Criteria) this;
        }

        public Criteria andStuLastnameEqualTo(String value) {
            addCriterion("stu_lastname =", value, "stuLastname");
            return (Criteria) this;
        }

        public Criteria andStuLastnameNotEqualTo(String value) {
            addCriterion("stu_lastname <>", value, "stuLastname");
            return (Criteria) this;
        }

        public Criteria andStuLastnameGreaterThan(String value) {
            addCriterion("stu_lastname >", value, "stuLastname");
            return (Criteria) this;
        }

        public Criteria andStuLastnameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_lastname >=", value, "stuLastname");
            return (Criteria) this;
        }

        public Criteria andStuLastnameLessThan(String value) {
            addCriterion("stu_lastname <", value, "stuLastname");
            return (Criteria) this;
        }

        public Criteria andStuLastnameLessThanOrEqualTo(String value) {
            addCriterion("stu_lastname <=", value, "stuLastname");
            return (Criteria) this;
        }

        public Criteria andStuLastnameLike(String value) {
            addCriterion("stu_lastname like", value, "stuLastname");
            return (Criteria) this;
        }

        public Criteria andStuLastnameNotLike(String value) {
            addCriterion("stu_lastname not like", value, "stuLastname");
            return (Criteria) this;
        }

        public Criteria andStuLastnameIn(List<String> values) {
            addCriterion("stu_lastname in", values, "stuLastname");
            return (Criteria) this;
        }

        public Criteria andStuLastnameNotIn(List<String> values) {
            addCriterion("stu_lastname not in", values, "stuLastname");
            return (Criteria) this;
        }

        public Criteria andStuLastnameBetween(String value1, String value2) {
            addCriterion("stu_lastname between", value1, value2, "stuLastname");
            return (Criteria) this;
        }

        public Criteria andStuLastnameNotBetween(String value1, String value2) {
            addCriterion("stu_lastname not between", value1, value2, "stuLastname");
            return (Criteria) this;
        }

        public Criteria andStuGenderIsNull() {
            addCriterion("stu_gender is null");
            return (Criteria) this;
        }

        public Criteria andStuGenderIsNotNull() {
            addCriterion("stu_gender is not null");
            return (Criteria) this;
        }

        public Criteria andStuGenderEqualTo(Integer value) {
            addCriterion("stu_gender =", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotEqualTo(Integer value) {
            addCriterion("stu_gender <>", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderGreaterThan(Integer value) {
            addCriterion("stu_gender >", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_gender >=", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderLessThan(Integer value) {
            addCriterion("stu_gender <", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderLessThanOrEqualTo(Integer value) {
            addCriterion("stu_gender <=", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderIn(List<Integer> values) {
            addCriterion("stu_gender in", values, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotIn(List<Integer> values) {
            addCriterion("stu_gender not in", values, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderBetween(Integer value1, Integer value2) {
            addCriterion("stu_gender between", value1, value2, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_gender not between", value1, value2, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuIdTypeIsNull() {
            addCriterion("stu_id_type is null");
            return (Criteria) this;
        }

        public Criteria andStuIdTypeIsNotNull() {
            addCriterion("stu_id_type is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdTypeEqualTo(Integer value) {
            addCriterion("stu_id_type =", value, "stuIdType");
            return (Criteria) this;
        }

        public Criteria andStuIdTypeNotEqualTo(Integer value) {
            addCriterion("stu_id_type <>", value, "stuIdType");
            return (Criteria) this;
        }

        public Criteria andStuIdTypeGreaterThan(Integer value) {
            addCriterion("stu_id_type >", value, "stuIdType");
            return (Criteria) this;
        }

        public Criteria andStuIdTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_id_type >=", value, "stuIdType");
            return (Criteria) this;
        }

        public Criteria andStuIdTypeLessThan(Integer value) {
            addCriterion("stu_id_type <", value, "stuIdType");
            return (Criteria) this;
        }

        public Criteria andStuIdTypeLessThanOrEqualTo(Integer value) {
            addCriterion("stu_id_type <=", value, "stuIdType");
            return (Criteria) this;
        }

        public Criteria andStuIdTypeIn(List<Integer> values) {
            addCriterion("stu_id_type in", values, "stuIdType");
            return (Criteria) this;
        }

        public Criteria andStuIdTypeNotIn(List<Integer> values) {
            addCriterion("stu_id_type not in", values, "stuIdType");
            return (Criteria) this;
        }

        public Criteria andStuIdTypeBetween(Integer value1, Integer value2) {
            addCriterion("stu_id_type between", value1, value2, "stuIdType");
            return (Criteria) this;
        }

        public Criteria andStuIdTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_id_type not between", value1, value2, "stuIdType");
            return (Criteria) this;
        }

        public Criteria andStuIdCodeIsNull() {
            addCriterion("stu_id_code is null");
            return (Criteria) this;
        }

        public Criteria andStuIdCodeIsNotNull() {
            addCriterion("stu_id_code is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdCodeEqualTo(String value) {
            addCriterion("stu_id_code =", value, "stuIdCode");
            return (Criteria) this;
        }

        public Criteria andStuIdCodeNotEqualTo(String value) {
            addCriterion("stu_id_code <>", value, "stuIdCode");
            return (Criteria) this;
        }

        public Criteria andStuIdCodeGreaterThan(String value) {
            addCriterion("stu_id_code >", value, "stuIdCode");
            return (Criteria) this;
        }

        public Criteria andStuIdCodeGreaterThanOrEqualTo(String value) {
            addCriterion("stu_id_code >=", value, "stuIdCode");
            return (Criteria) this;
        }

        public Criteria andStuIdCodeLessThan(String value) {
            addCriterion("stu_id_code <", value, "stuIdCode");
            return (Criteria) this;
        }

        public Criteria andStuIdCodeLessThanOrEqualTo(String value) {
            addCriterion("stu_id_code <=", value, "stuIdCode");
            return (Criteria) this;
        }

        public Criteria andStuIdCodeLike(String value) {
            addCriterion("stu_id_code like", value, "stuIdCode");
            return (Criteria) this;
        }

        public Criteria andStuIdCodeNotLike(String value) {
            addCriterion("stu_id_code not like", value, "stuIdCode");
            return (Criteria) this;
        }

        public Criteria andStuIdCodeIn(List<String> values) {
            addCriterion("stu_id_code in", values, "stuIdCode");
            return (Criteria) this;
        }

        public Criteria andStuIdCodeNotIn(List<String> values) {
            addCriterion("stu_id_code not in", values, "stuIdCode");
            return (Criteria) this;
        }

        public Criteria andStuIdCodeBetween(String value1, String value2) {
            addCriterion("stu_id_code between", value1, value2, "stuIdCode");
            return (Criteria) this;
        }

        public Criteria andStuIdCodeNotBetween(String value1, String value2) {
            addCriterion("stu_id_code not between", value1, value2, "stuIdCode");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayIsNull() {
            addCriterion("stu_birthday is null");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayIsNotNull() {
            addCriterion("stu_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayEqualTo(String value) {
            addCriterion("stu_birthday =", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayNotEqualTo(String value) {
            addCriterion("stu_birthday <>", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayGreaterThan(String value) {
            addCriterion("stu_birthday >", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("stu_birthday >=", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayLessThan(String value) {
            addCriterion("stu_birthday <", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayLessThanOrEqualTo(String value) {
            addCriterion("stu_birthday <=", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayLike(String value) {
            addCriterion("stu_birthday like", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayNotLike(String value) {
            addCriterion("stu_birthday not like", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayIn(List<String> values) {
            addCriterion("stu_birthday in", values, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayNotIn(List<String> values) {
            addCriterion("stu_birthday not in", values, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayBetween(String value1, String value2) {
            addCriterion("stu_birthday between", value1, value2, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayNotBetween(String value1, String value2) {
            addCriterion("stu_birthday not between", value1, value2, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuGradeIsNull() {
            addCriterion("stu_grade is null");
            return (Criteria) this;
        }

        public Criteria andStuGradeIsNotNull() {
            addCriterion("stu_grade is not null");
            return (Criteria) this;
        }

        public Criteria andStuGradeEqualTo(String value) {
            addCriterion("stu_grade =", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeNotEqualTo(String value) {
            addCriterion("stu_grade <>", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeGreaterThan(String value) {
            addCriterion("stu_grade >", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeGreaterThanOrEqualTo(String value) {
            addCriterion("stu_grade >=", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeLessThan(String value) {
            addCriterion("stu_grade <", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeLessThanOrEqualTo(String value) {
            addCriterion("stu_grade <=", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeLike(String value) {
            addCriterion("stu_grade like", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeNotLike(String value) {
            addCriterion("stu_grade not like", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeIn(List<String> values) {
            addCriterion("stu_grade in", values, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeNotIn(List<String> values) {
            addCriterion("stu_grade not in", values, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeBetween(String value1, String value2) {
            addCriterion("stu_grade between", value1, value2, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeNotBetween(String value1, String value2) {
            addCriterion("stu_grade not between", value1, value2, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNameIsNull() {
            addCriterion("stu_school_name is null");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNameIsNotNull() {
            addCriterion("stu_school_name is not null");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNameEqualTo(String value) {
            addCriterion("stu_school_name =", value, "stuSchoolName");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNameNotEqualTo(String value) {
            addCriterion("stu_school_name <>", value, "stuSchoolName");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNameGreaterThan(String value) {
            addCriterion("stu_school_name >", value, "stuSchoolName");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_school_name >=", value, "stuSchoolName");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNameLessThan(String value) {
            addCriterion("stu_school_name <", value, "stuSchoolName");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNameLessThanOrEqualTo(String value) {
            addCriterion("stu_school_name <=", value, "stuSchoolName");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNameLike(String value) {
            addCriterion("stu_school_name like", value, "stuSchoolName");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNameNotLike(String value) {
            addCriterion("stu_school_name not like", value, "stuSchoolName");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNameIn(List<String> values) {
            addCriterion("stu_school_name in", values, "stuSchoolName");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNameNotIn(List<String> values) {
            addCriterion("stu_school_name not in", values, "stuSchoolName");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNameBetween(String value1, String value2) {
            addCriterion("stu_school_name between", value1, value2, "stuSchoolName");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNameNotBetween(String value1, String value2) {
            addCriterion("stu_school_name not between", value1, value2, "stuSchoolName");
            return (Criteria) this;
        }

        public Criteria andOrgnizationIdIsNull() {
            addCriterion("orgnization_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgnizationIdIsNotNull() {
            addCriterion("orgnization_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgnizationIdEqualTo(String value) {
            addCriterion("orgnization_id =", value, "orgnizationId");
            return (Criteria) this;
        }

        public Criteria andOrgnizationIdNotEqualTo(String value) {
            addCriterion("orgnization_id <>", value, "orgnizationId");
            return (Criteria) this;
        }

        public Criteria andOrgnizationIdGreaterThan(String value) {
            addCriterion("orgnization_id >", value, "orgnizationId");
            return (Criteria) this;
        }

        public Criteria andOrgnizationIdGreaterThanOrEqualTo(String value) {
            addCriterion("orgnization_id >=", value, "orgnizationId");
            return (Criteria) this;
        }

        public Criteria andOrgnizationIdLessThan(String value) {
            addCriterion("orgnization_id <", value, "orgnizationId");
            return (Criteria) this;
        }

        public Criteria andOrgnizationIdLessThanOrEqualTo(String value) {
            addCriterion("orgnization_id <=", value, "orgnizationId");
            return (Criteria) this;
        }

        public Criteria andOrgnizationIdLike(String value) {
            addCriterion("orgnization_id like", value, "orgnizationId");
            return (Criteria) this;
        }

        public Criteria andOrgnizationIdNotLike(String value) {
            addCriterion("orgnization_id not like", value, "orgnizationId");
            return (Criteria) this;
        }

        public Criteria andOrgnizationIdIn(List<String> values) {
            addCriterion("orgnization_id in", values, "orgnizationId");
            return (Criteria) this;
        }

        public Criteria andOrgnizationIdNotIn(List<String> values) {
            addCriterion("orgnization_id not in", values, "orgnizationId");
            return (Criteria) this;
        }

        public Criteria andOrgnizationIdBetween(String value1, String value2) {
            addCriterion("orgnization_id between", value1, value2, "orgnizationId");
            return (Criteria) this;
        }

        public Criteria andOrgnizationIdNotBetween(String value1, String value2) {
            addCriterion("orgnization_id not between", value1, value2, "orgnizationId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNull() {
            addCriterion("creator_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNotNull() {
            addCriterion("creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdEqualTo(String value) {
            addCriterion("creator_id =", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotEqualTo(String value) {
            addCriterion("creator_id <>", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThan(String value) {
            addCriterion("creator_id >", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("creator_id >=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThan(String value) {
            addCriterion("creator_id <", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThanOrEqualTo(String value) {
            addCriterion("creator_id <=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLike(String value) {
            addCriterion("creator_id like", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotLike(String value) {
            addCriterion("creator_id not like", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIn(List<String> values) {
            addCriterion("creator_id in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotIn(List<String> values) {
            addCriterion("creator_id not in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdBetween(String value1, String value2) {
            addCriterion("creator_id between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotBetween(String value1, String value2) {
            addCriterion("creator_id not between", value1, value2, "creatorId");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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