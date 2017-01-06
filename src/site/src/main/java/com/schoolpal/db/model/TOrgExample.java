package com.schoolpal.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TOrgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOrgExample() {
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

        public Criteria andCCodeIsNull() {
            addCriterion("c_code is null");
            return (Criteria) this;
        }

        public Criteria andCCodeIsNotNull() {
            addCriterion("c_code is not null");
            return (Criteria) this;
        }

        public Criteria andCCodeEqualTo(String value) {
            addCriterion("c_code =", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeNotEqualTo(String value) {
            addCriterion("c_code <>", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeGreaterThan(String value) {
            addCriterion("c_code >", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeGreaterThanOrEqualTo(String value) {
            addCriterion("c_code >=", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeLessThan(String value) {
            addCriterion("c_code <", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeLessThanOrEqualTo(String value) {
            addCriterion("c_code <=", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeLike(String value) {
            addCriterion("c_code like", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeNotLike(String value) {
            addCriterion("c_code not like", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeIn(List<String> values) {
            addCriterion("c_code in", values, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeNotIn(List<String> values) {
            addCriterion("c_code not in", values, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeBetween(String value1, String value2) {
            addCriterion("c_code between", value1, value2, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeNotBetween(String value1, String value2) {
            addCriterion("c_code not between", value1, value2, "cCode");
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

        public Criteria andCNameAbbrIsNull() {
            addCriterion("c_name_abbr is null");
            return (Criteria) this;
        }

        public Criteria andCNameAbbrIsNotNull() {
            addCriterion("c_name_abbr is not null");
            return (Criteria) this;
        }

        public Criteria andCNameAbbrEqualTo(String value) {
            addCriterion("c_name_abbr =", value, "cNameAbbr");
            return (Criteria) this;
        }

        public Criteria andCNameAbbrNotEqualTo(String value) {
            addCriterion("c_name_abbr <>", value, "cNameAbbr");
            return (Criteria) this;
        }

        public Criteria andCNameAbbrGreaterThan(String value) {
            addCriterion("c_name_abbr >", value, "cNameAbbr");
            return (Criteria) this;
        }

        public Criteria andCNameAbbrGreaterThanOrEqualTo(String value) {
            addCriterion("c_name_abbr >=", value, "cNameAbbr");
            return (Criteria) this;
        }

        public Criteria andCNameAbbrLessThan(String value) {
            addCriterion("c_name_abbr <", value, "cNameAbbr");
            return (Criteria) this;
        }

        public Criteria andCNameAbbrLessThanOrEqualTo(String value) {
            addCriterion("c_name_abbr <=", value, "cNameAbbr");
            return (Criteria) this;
        }

        public Criteria andCNameAbbrLike(String value) {
            addCriterion("c_name_abbr like", value, "cNameAbbr");
            return (Criteria) this;
        }

        public Criteria andCNameAbbrNotLike(String value) {
            addCriterion("c_name_abbr not like", value, "cNameAbbr");
            return (Criteria) this;
        }

        public Criteria andCNameAbbrIn(List<String> values) {
            addCriterion("c_name_abbr in", values, "cNameAbbr");
            return (Criteria) this;
        }

        public Criteria andCNameAbbrNotIn(List<String> values) {
            addCriterion("c_name_abbr not in", values, "cNameAbbr");
            return (Criteria) this;
        }

        public Criteria andCNameAbbrBetween(String value1, String value2) {
            addCriterion("c_name_abbr between", value1, value2, "cNameAbbr");
            return (Criteria) this;
        }

        public Criteria andCNameAbbrNotBetween(String value1, String value2) {
            addCriterion("c_name_abbr not between", value1, value2, "cNameAbbr");
            return (Criteria) this;
        }

        public Criteria andCAddressIsNull() {
            addCriterion("c_address is null");
            return (Criteria) this;
        }

        public Criteria andCAddressIsNotNull() {
            addCriterion("c_address is not null");
            return (Criteria) this;
        }

        public Criteria andCAddressEqualTo(String value) {
            addCriterion("c_address =", value, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressNotEqualTo(String value) {
            addCriterion("c_address <>", value, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressGreaterThan(String value) {
            addCriterion("c_address >", value, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressGreaterThanOrEqualTo(String value) {
            addCriterion("c_address >=", value, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressLessThan(String value) {
            addCriterion("c_address <", value, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressLessThanOrEqualTo(String value) {
            addCriterion("c_address <=", value, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressLike(String value) {
            addCriterion("c_address like", value, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressNotLike(String value) {
            addCriterion("c_address not like", value, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressIn(List<String> values) {
            addCriterion("c_address in", values, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressNotIn(List<String> values) {
            addCriterion("c_address not in", values, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressBetween(String value1, String value2) {
            addCriterion("c_address between", value1, value2, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCAddressNotBetween(String value1, String value2) {
            addCriterion("c_address not between", value1, value2, "cAddress");
            return (Criteria) this;
        }

        public Criteria andCCityIsNull() {
            addCriterion("c_city is null");
            return (Criteria) this;
        }

        public Criteria andCCityIsNotNull() {
            addCriterion("c_city is not null");
            return (Criteria) this;
        }

        public Criteria andCCityEqualTo(String value) {
            addCriterion("c_city =", value, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityNotEqualTo(String value) {
            addCriterion("c_city <>", value, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityGreaterThan(String value) {
            addCriterion("c_city >", value, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityGreaterThanOrEqualTo(String value) {
            addCriterion("c_city >=", value, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityLessThan(String value) {
            addCriterion("c_city <", value, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityLessThanOrEqualTo(String value) {
            addCriterion("c_city <=", value, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityLike(String value) {
            addCriterion("c_city like", value, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityNotLike(String value) {
            addCriterion("c_city not like", value, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityIn(List<String> values) {
            addCriterion("c_city in", values, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityNotIn(List<String> values) {
            addCriterion("c_city not in", values, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityBetween(String value1, String value2) {
            addCriterion("c_city between", value1, value2, "cCity");
            return (Criteria) this;
        }

        public Criteria andCCityNotBetween(String value1, String value2) {
            addCriterion("c_city not between", value1, value2, "cCity");
            return (Criteria) this;
        }

        public Criteria andCStateIsNull() {
            addCriterion("c_state is null");
            return (Criteria) this;
        }

        public Criteria andCStateIsNotNull() {
            addCriterion("c_state is not null");
            return (Criteria) this;
        }

        public Criteria andCStateEqualTo(String value) {
            addCriterion("c_state =", value, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateNotEqualTo(String value) {
            addCriterion("c_state <>", value, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateGreaterThan(String value) {
            addCriterion("c_state >", value, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateGreaterThanOrEqualTo(String value) {
            addCriterion("c_state >=", value, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateLessThan(String value) {
            addCriterion("c_state <", value, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateLessThanOrEqualTo(String value) {
            addCriterion("c_state <=", value, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateLike(String value) {
            addCriterion("c_state like", value, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateNotLike(String value) {
            addCriterion("c_state not like", value, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateIn(List<String> values) {
            addCriterion("c_state in", values, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateNotIn(List<String> values) {
            addCriterion("c_state not in", values, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateBetween(String value1, String value2) {
            addCriterion("c_state between", value1, value2, "cState");
            return (Criteria) this;
        }

        public Criteria andCStateNotBetween(String value1, String value2) {
            addCriterion("c_state not between", value1, value2, "cState");
            return (Criteria) this;
        }

        public Criteria andCCountyIsNull() {
            addCriterion("c_county is null");
            return (Criteria) this;
        }

        public Criteria andCCountyIsNotNull() {
            addCriterion("c_county is not null");
            return (Criteria) this;
        }

        public Criteria andCCountyEqualTo(String value) {
            addCriterion("c_county =", value, "cCounty");
            return (Criteria) this;
        }

        public Criteria andCCountyNotEqualTo(String value) {
            addCriterion("c_county <>", value, "cCounty");
            return (Criteria) this;
        }

        public Criteria andCCountyGreaterThan(String value) {
            addCriterion("c_county >", value, "cCounty");
            return (Criteria) this;
        }

        public Criteria andCCountyGreaterThanOrEqualTo(String value) {
            addCriterion("c_county >=", value, "cCounty");
            return (Criteria) this;
        }

        public Criteria andCCountyLessThan(String value) {
            addCriterion("c_county <", value, "cCounty");
            return (Criteria) this;
        }

        public Criteria andCCountyLessThanOrEqualTo(String value) {
            addCriterion("c_county <=", value, "cCounty");
            return (Criteria) this;
        }

        public Criteria andCCountyLike(String value) {
            addCriterion("c_county like", value, "cCounty");
            return (Criteria) this;
        }

        public Criteria andCCountyNotLike(String value) {
            addCriterion("c_county not like", value, "cCounty");
            return (Criteria) this;
        }

        public Criteria andCCountyIn(List<String> values) {
            addCriterion("c_county in", values, "cCounty");
            return (Criteria) this;
        }

        public Criteria andCCountyNotIn(List<String> values) {
            addCriterion("c_county not in", values, "cCounty");
            return (Criteria) this;
        }

        public Criteria andCCountyBetween(String value1, String value2) {
            addCriterion("c_county between", value1, value2, "cCounty");
            return (Criteria) this;
        }

        public Criteria andCCountyNotBetween(String value1, String value2) {
            addCriterion("c_county not between", value1, value2, "cCounty");
            return (Criteria) this;
        }

        public Criteria andCOwnerIsNull() {
            addCriterion("c_owner is null");
            return (Criteria) this;
        }

        public Criteria andCOwnerIsNotNull() {
            addCriterion("c_owner is not null");
            return (Criteria) this;
        }

        public Criteria andCOwnerEqualTo(String value) {
            addCriterion("c_owner =", value, "cOwner");
            return (Criteria) this;
        }

        public Criteria andCOwnerNotEqualTo(String value) {
            addCriterion("c_owner <>", value, "cOwner");
            return (Criteria) this;
        }

        public Criteria andCOwnerGreaterThan(String value) {
            addCriterion("c_owner >", value, "cOwner");
            return (Criteria) this;
        }

        public Criteria andCOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("c_owner >=", value, "cOwner");
            return (Criteria) this;
        }

        public Criteria andCOwnerLessThan(String value) {
            addCriterion("c_owner <", value, "cOwner");
            return (Criteria) this;
        }

        public Criteria andCOwnerLessThanOrEqualTo(String value) {
            addCriterion("c_owner <=", value, "cOwner");
            return (Criteria) this;
        }

        public Criteria andCOwnerLike(String value) {
            addCriterion("c_owner like", value, "cOwner");
            return (Criteria) this;
        }

        public Criteria andCOwnerNotLike(String value) {
            addCriterion("c_owner not like", value, "cOwner");
            return (Criteria) this;
        }

        public Criteria andCOwnerIn(List<String> values) {
            addCriterion("c_owner in", values, "cOwner");
            return (Criteria) this;
        }

        public Criteria andCOwnerNotIn(List<String> values) {
            addCriterion("c_owner not in", values, "cOwner");
            return (Criteria) this;
        }

        public Criteria andCOwnerBetween(String value1, String value2) {
            addCriterion("c_owner between", value1, value2, "cOwner");
            return (Criteria) this;
        }

        public Criteria andCOwnerNotBetween(String value1, String value2) {
            addCriterion("c_owner not between", value1, value2, "cOwner");
            return (Criteria) this;
        }

        public Criteria andCOwnerPhoneIsNull() {
            addCriterion("c_owner_phone is null");
            return (Criteria) this;
        }

        public Criteria andCOwnerPhoneIsNotNull() {
            addCriterion("c_owner_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCOwnerPhoneEqualTo(String value) {
            addCriterion("c_owner_phone =", value, "cOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andCOwnerPhoneNotEqualTo(String value) {
            addCriterion("c_owner_phone <>", value, "cOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andCOwnerPhoneGreaterThan(String value) {
            addCriterion("c_owner_phone >", value, "cOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andCOwnerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("c_owner_phone >=", value, "cOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andCOwnerPhoneLessThan(String value) {
            addCriterion("c_owner_phone <", value, "cOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andCOwnerPhoneLessThanOrEqualTo(String value) {
            addCriterion("c_owner_phone <=", value, "cOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andCOwnerPhoneLike(String value) {
            addCriterion("c_owner_phone like", value, "cOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andCOwnerPhoneNotLike(String value) {
            addCriterion("c_owner_phone not like", value, "cOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andCOwnerPhoneIn(List<String> values) {
            addCriterion("c_owner_phone in", values, "cOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andCOwnerPhoneNotIn(List<String> values) {
            addCriterion("c_owner_phone not in", values, "cOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andCOwnerPhoneBetween(String value1, String value2) {
            addCriterion("c_owner_phone between", value1, value2, "cOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andCOwnerPhoneNotBetween(String value1, String value2) {
            addCriterion("c_owner_phone not between", value1, value2, "cOwnerPhone");
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

        public Criteria andCModifierIsNull() {
            addCriterion("c_modifier is null");
            return (Criteria) this;
        }

        public Criteria andCModifierIsNotNull() {
            addCriterion("c_modifier is not null");
            return (Criteria) this;
        }

        public Criteria andCModifierEqualTo(String value) {
            addCriterion("c_modifier =", value, "cModifier");
            return (Criteria) this;
        }

        public Criteria andCModifierNotEqualTo(String value) {
            addCriterion("c_modifier <>", value, "cModifier");
            return (Criteria) this;
        }

        public Criteria andCModifierGreaterThan(String value) {
            addCriterion("c_modifier >", value, "cModifier");
            return (Criteria) this;
        }

        public Criteria andCModifierGreaterThanOrEqualTo(String value) {
            addCriterion("c_modifier >=", value, "cModifier");
            return (Criteria) this;
        }

        public Criteria andCModifierLessThan(String value) {
            addCriterion("c_modifier <", value, "cModifier");
            return (Criteria) this;
        }

        public Criteria andCModifierLessThanOrEqualTo(String value) {
            addCriterion("c_modifier <=", value, "cModifier");
            return (Criteria) this;
        }

        public Criteria andCModifierLike(String value) {
            addCriterion("c_modifier like", value, "cModifier");
            return (Criteria) this;
        }

        public Criteria andCModifierNotLike(String value) {
            addCriterion("c_modifier not like", value, "cModifier");
            return (Criteria) this;
        }

        public Criteria andCModifierIn(List<String> values) {
            addCriterion("c_modifier in", values, "cModifier");
            return (Criteria) this;
        }

        public Criteria andCModifierNotIn(List<String> values) {
            addCriterion("c_modifier not in", values, "cModifier");
            return (Criteria) this;
        }

        public Criteria andCModifierBetween(String value1, String value2) {
            addCriterion("c_modifier between", value1, value2, "cModifier");
            return (Criteria) this;
        }

        public Criteria andCModifierNotBetween(String value1, String value2) {
            addCriterion("c_modifier not between", value1, value2, "cModifier");
            return (Criteria) this;
        }

        public Criteria andCModifyTimeIsNull() {
            addCriterion("c_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andCModifyTimeIsNotNull() {
            addCriterion("c_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andCModifyTimeEqualTo(Date value) {
            addCriterion("c_modify_time =", value, "cModifyTime");
            return (Criteria) this;
        }

        public Criteria andCModifyTimeNotEqualTo(Date value) {
            addCriterion("c_modify_time <>", value, "cModifyTime");
            return (Criteria) this;
        }

        public Criteria andCModifyTimeGreaterThan(Date value) {
            addCriterion("c_modify_time >", value, "cModifyTime");
            return (Criteria) this;
        }

        public Criteria andCModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("c_modify_time >=", value, "cModifyTime");
            return (Criteria) this;
        }

        public Criteria andCModifyTimeLessThan(Date value) {
            addCriterion("c_modify_time <", value, "cModifyTime");
            return (Criteria) this;
        }

        public Criteria andCModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("c_modify_time <=", value, "cModifyTime");
            return (Criteria) this;
        }

        public Criteria andCModifyTimeIn(List<Date> values) {
            addCriterion("c_modify_time in", values, "cModifyTime");
            return (Criteria) this;
        }

        public Criteria andCModifyTimeNotIn(List<Date> values) {
            addCriterion("c_modify_time not in", values, "cModifyTime");
            return (Criteria) this;
        }

        public Criteria andCModifyTimeBetween(Date value1, Date value2) {
            addCriterion("c_modify_time between", value1, value2, "cModifyTime");
            return (Criteria) this;
        }

        public Criteria andCModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("c_modify_time not between", value1, value2, "cModifyTime");
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