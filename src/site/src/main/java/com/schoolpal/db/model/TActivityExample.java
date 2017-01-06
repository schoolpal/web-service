package com.schoolpal.db.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TActivityExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRootIdIsNull() {
            addCriterion("root_id is null");
            return (Criteria) this;
        }

        public Criteria andRootIdIsNotNull() {
            addCriterion("root_id is not null");
            return (Criteria) this;
        }

        public Criteria andRootIdEqualTo(Integer value) {
            addCriterion("root_id =", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdNotEqualTo(Integer value) {
            addCriterion("root_id <>", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdGreaterThan(Integer value) {
            addCriterion("root_id >", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("root_id >=", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdLessThan(Integer value) {
            addCriterion("root_id <", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdLessThanOrEqualTo(Integer value) {
            addCriterion("root_id <=", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdIn(List<Integer> values) {
            addCriterion("root_id in", values, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdNotIn(List<Integer> values) {
            addCriterion("root_id not in", values, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdBetween(Integer value1, Integer value2) {
            addCriterion("root_id between", value1, value2, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdNotBetween(Integer value1, Integer value2) {
            addCriterion("root_id not between", value1, value2, "rootId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andBudgetIsNull() {
            addCriterion("budget is null");
            return (Criteria) this;
        }

        public Criteria andBudgetIsNotNull() {
            addCriterion("budget is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetEqualTo(BigDecimal value) {
            addCriterion("budget =", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotEqualTo(BigDecimal value) {
            addCriterion("budget <>", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetGreaterThan(BigDecimal value) {
            addCriterion("budget >", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("budget >=", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetLessThan(BigDecimal value) {
            addCriterion("budget <", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("budget <=", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetIn(List<BigDecimal> values) {
            addCriterion("budget in", values, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotIn(List<BigDecimal> values) {
            addCriterion("budget not in", values, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("budget between", value1, value2, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("budget not between", value1, value2, "budget");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(BigDecimal value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(BigDecimal value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(BigDecimal value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(BigDecimal value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<BigDecimal> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<BigDecimal> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andExectiveIdIsNull() {
            addCriterion("exective_id is null");
            return (Criteria) this;
        }

        public Criteria andExectiveIdIsNotNull() {
            addCriterion("exective_id is not null");
            return (Criteria) this;
        }

        public Criteria andExectiveIdEqualTo(String value) {
            addCriterion("exective_id =", value, "exectiveId");
            return (Criteria) this;
        }

        public Criteria andExectiveIdNotEqualTo(String value) {
            addCriterion("exective_id <>", value, "exectiveId");
            return (Criteria) this;
        }

        public Criteria andExectiveIdGreaterThan(String value) {
            addCriterion("exective_id >", value, "exectiveId");
            return (Criteria) this;
        }

        public Criteria andExectiveIdGreaterThanOrEqualTo(String value) {
            addCriterion("exective_id >=", value, "exectiveId");
            return (Criteria) this;
        }

        public Criteria andExectiveIdLessThan(String value) {
            addCriterion("exective_id <", value, "exectiveId");
            return (Criteria) this;
        }

        public Criteria andExectiveIdLessThanOrEqualTo(String value) {
            addCriterion("exective_id <=", value, "exectiveId");
            return (Criteria) this;
        }

        public Criteria andExectiveIdLike(String value) {
            addCriterion("exective_id like", value, "exectiveId");
            return (Criteria) this;
        }

        public Criteria andExectiveIdNotLike(String value) {
            addCriterion("exective_id not like", value, "exectiveId");
            return (Criteria) this;
        }

        public Criteria andExectiveIdIn(List<String> values) {
            addCriterion("exective_id in", values, "exectiveId");
            return (Criteria) this;
        }

        public Criteria andExectiveIdNotIn(List<String> values) {
            addCriterion("exective_id not in", values, "exectiveId");
            return (Criteria) this;
        }

        public Criteria andExectiveIdBetween(String value1, String value2) {
            addCriterion("exective_id between", value1, value2, "exectiveId");
            return (Criteria) this;
        }

        public Criteria andExectiveIdNotBetween(String value1, String value2) {
            addCriterion("exective_id not between", value1, value2, "exectiveId");
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

        public Criteria andLastUpdateIsNull() {
            addCriterion("last_update is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIsNotNull() {
            addCriterion("last_update is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateEqualTo(String value) {
            addCriterion("last_update =", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotEqualTo(String value) {
            addCriterion("last_update <>", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateGreaterThan(String value) {
            addCriterion("last_update >", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateGreaterThanOrEqualTo(String value) {
            addCriterion("last_update >=", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLessThan(String value) {
            addCriterion("last_update <", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLessThanOrEqualTo(String value) {
            addCriterion("last_update <=", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLike(String value) {
            addCriterion("last_update like", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotLike(String value) {
            addCriterion("last_update not like", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIn(List<String> values) {
            addCriterion("last_update in", values, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotIn(List<String> values) {
            addCriterion("last_update not in", values, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateBetween(String value1, String value2) {
            addCriterion("last_update between", value1, value2, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotBetween(String value1, String value2) {
            addCriterion("last_update not between", value1, value2, "lastUpdate");
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