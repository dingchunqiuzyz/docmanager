package com.jlju.docmanager.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProjectsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectsExample() {
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

        public Criteria andProUuidIsNull() {
            addCriterion("pro_uuid is null");
            return (Criteria) this;
        }

        public Criteria andProUuidIsNotNull() {
            addCriterion("pro_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andProUuidEqualTo(String value) {
            addCriterion("pro_uuid =", value, "proUuid");
            return (Criteria) this;
        }

        public Criteria andProUuidNotEqualTo(String value) {
            addCriterion("pro_uuid <>", value, "proUuid");
            return (Criteria) this;
        }

        public Criteria andProUuidGreaterThan(String value) {
            addCriterion("pro_uuid >", value, "proUuid");
            return (Criteria) this;
        }

        public Criteria andProUuidGreaterThanOrEqualTo(String value) {
            addCriterion("pro_uuid >=", value, "proUuid");
            return (Criteria) this;
        }

        public Criteria andProUuidLessThan(String value) {
            addCriterion("pro_uuid <", value, "proUuid");
            return (Criteria) this;
        }

        public Criteria andProUuidLessThanOrEqualTo(String value) {
            addCriterion("pro_uuid <=", value, "proUuid");
            return (Criteria) this;
        }

        public Criteria andProUuidLike(String value) {
            addCriterion("pro_uuid like", value, "proUuid");
            return (Criteria) this;
        }

        public Criteria andProUuidNotLike(String value) {
            addCriterion("pro_uuid not like", value, "proUuid");
            return (Criteria) this;
        }

        public Criteria andProUuidIn(List<String> values) {
            addCriterion("pro_uuid in", values, "proUuid");
            return (Criteria) this;
        }

        public Criteria andProUuidNotIn(List<String> values) {
            addCriterion("pro_uuid not in", values, "proUuid");
            return (Criteria) this;
        }

        public Criteria andProUuidBetween(String value1, String value2) {
            addCriterion("pro_uuid between", value1, value2, "proUuid");
            return (Criteria) this;
        }

        public Criteria andProUuidNotBetween(String value1, String value2) {
            addCriterion("pro_uuid not between", value1, value2, "proUuid");
            return (Criteria) this;
        }

        public Criteria andProNameIsNull() {
            addCriterion("pro_name is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("pro_name is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("pro_name =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("pro_name <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("pro_name >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_name >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("pro_name <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("pro_name <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("pro_name like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("pro_name not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("pro_name in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("pro_name not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("pro_name between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("pro_name not between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProLevelIsNull() {
            addCriterion("pro_level is null");
            return (Criteria) this;
        }

        public Criteria andProLevelIsNotNull() {
            addCriterion("pro_level is not null");
            return (Criteria) this;
        }

        public Criteria andProLevelEqualTo(String value) {
            addCriterion("pro_level =", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelNotEqualTo(String value) {
            addCriterion("pro_level <>", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelGreaterThan(String value) {
            addCriterion("pro_level >", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelGreaterThanOrEqualTo(String value) {
            addCriterion("pro_level >=", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelLessThan(String value) {
            addCriterion("pro_level <", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelLessThanOrEqualTo(String value) {
            addCriterion("pro_level <=", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelLike(String value) {
            addCriterion("pro_level like", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelNotLike(String value) {
            addCriterion("pro_level not like", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelIn(List<String> values) {
            addCriterion("pro_level in", values, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelNotIn(List<String> values) {
            addCriterion("pro_level not in", values, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelBetween(String value1, String value2) {
            addCriterion("pro_level between", value1, value2, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelNotBetween(String value1, String value2) {
            addCriterion("pro_level not between", value1, value2, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProStartDateIsNull() {
            addCriterion("pro_start_date is null");
            return (Criteria) this;
        }

        public Criteria andProStartDateIsNotNull() {
            addCriterion("pro_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andProStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("pro_start_date =", value, "proStartDate");
            return (Criteria) this;
        }

        public Criteria andProStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("pro_start_date <>", value, "proStartDate");
            return (Criteria) this;
        }

        public Criteria andProStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("pro_start_date >", value, "proStartDate");
            return (Criteria) this;
        }

        public Criteria andProStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pro_start_date >=", value, "proStartDate");
            return (Criteria) this;
        }

        public Criteria andProStartDateLessThan(Date value) {
            addCriterionForJDBCDate("pro_start_date <", value, "proStartDate");
            return (Criteria) this;
        }

        public Criteria andProStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pro_start_date <=", value, "proStartDate");
            return (Criteria) this;
        }

        public Criteria andProStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("pro_start_date in", values, "proStartDate");
            return (Criteria) this;
        }

        public Criteria andProStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("pro_start_date not in", values, "proStartDate");
            return (Criteria) this;
        }

        public Criteria andProStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pro_start_date between", value1, value2, "proStartDate");
            return (Criteria) this;
        }

        public Criteria andProStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pro_start_date not between", value1, value2, "proStartDate");
            return (Criteria) this;
        }

        public Criteria andProEndDateIsNull() {
            addCriterion("pro_end_date is null");
            return (Criteria) this;
        }

        public Criteria andProEndDateIsNotNull() {
            addCriterion("pro_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andProEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("pro_end_date =", value, "proEndDate");
            return (Criteria) this;
        }

        public Criteria andProEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("pro_end_date <>", value, "proEndDate");
            return (Criteria) this;
        }

        public Criteria andProEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("pro_end_date >", value, "proEndDate");
            return (Criteria) this;
        }

        public Criteria andProEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pro_end_date >=", value, "proEndDate");
            return (Criteria) this;
        }

        public Criteria andProEndDateLessThan(Date value) {
            addCriterionForJDBCDate("pro_end_date <", value, "proEndDate");
            return (Criteria) this;
        }

        public Criteria andProEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pro_end_date <=", value, "proEndDate");
            return (Criteria) this;
        }

        public Criteria andProEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("pro_end_date in", values, "proEndDate");
            return (Criteria) this;
        }

        public Criteria andProEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("pro_end_date not in", values, "proEndDate");
            return (Criteria) this;
        }

        public Criteria andProEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pro_end_date between", value1, value2, "proEndDate");
            return (Criteria) this;
        }

        public Criteria andProEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pro_end_date not between", value1, value2, "proEndDate");
            return (Criteria) this;
        }

        public Criteria andProSourceIsNull() {
            addCriterion("pro_source is null");
            return (Criteria) this;
        }

        public Criteria andProSourceIsNotNull() {
            addCriterion("pro_source is not null");
            return (Criteria) this;
        }

        public Criteria andProSourceEqualTo(String value) {
            addCriterion("pro_source =", value, "proSource");
            return (Criteria) this;
        }

        public Criteria andProSourceNotEqualTo(String value) {
            addCriterion("pro_source <>", value, "proSource");
            return (Criteria) this;
        }

        public Criteria andProSourceGreaterThan(String value) {
            addCriterion("pro_source >", value, "proSource");
            return (Criteria) this;
        }

        public Criteria andProSourceGreaterThanOrEqualTo(String value) {
            addCriterion("pro_source >=", value, "proSource");
            return (Criteria) this;
        }

        public Criteria andProSourceLessThan(String value) {
            addCriterion("pro_source <", value, "proSource");
            return (Criteria) this;
        }

        public Criteria andProSourceLessThanOrEqualTo(String value) {
            addCriterion("pro_source <=", value, "proSource");
            return (Criteria) this;
        }

        public Criteria andProSourceLike(String value) {
            addCriterion("pro_source like", value, "proSource");
            return (Criteria) this;
        }

        public Criteria andProSourceNotLike(String value) {
            addCriterion("pro_source not like", value, "proSource");
            return (Criteria) this;
        }

        public Criteria andProSourceIn(List<String> values) {
            addCriterion("pro_source in", values, "proSource");
            return (Criteria) this;
        }

        public Criteria andProSourceNotIn(List<String> values) {
            addCriterion("pro_source not in", values, "proSource");
            return (Criteria) this;
        }

        public Criteria andProSourceBetween(String value1, String value2) {
            addCriterion("pro_source between", value1, value2, "proSource");
            return (Criteria) this;
        }

        public Criteria andProSourceNotBetween(String value1, String value2) {
            addCriterion("pro_source not between", value1, value2, "proSource");
            return (Criteria) this;
        }

        public Criteria andProFundsIsNull() {
            addCriterion("pro_funds is null");
            return (Criteria) this;
        }

        public Criteria andProFundsIsNotNull() {
            addCriterion("pro_funds is not null");
            return (Criteria) this;
        }

        public Criteria andProFundsEqualTo(Float value) {
            addCriterion("pro_funds =", value, "proFunds");
            return (Criteria) this;
        }

        public Criteria andProFundsNotEqualTo(Float value) {
            addCriterion("pro_funds <>", value, "proFunds");
            return (Criteria) this;
        }

        public Criteria andProFundsGreaterThan(Float value) {
            addCriterion("pro_funds >", value, "proFunds");
            return (Criteria) this;
        }

        public Criteria andProFundsGreaterThanOrEqualTo(Float value) {
            addCriterion("pro_funds >=", value, "proFunds");
            return (Criteria) this;
        }

        public Criteria andProFundsLessThan(Float value) {
            addCriterion("pro_funds <", value, "proFunds");
            return (Criteria) this;
        }

        public Criteria andProFundsLessThanOrEqualTo(Float value) {
            addCriterion("pro_funds <=", value, "proFunds");
            return (Criteria) this;
        }

        public Criteria andProFundsIn(List<Float> values) {
            addCriterion("pro_funds in", values, "proFunds");
            return (Criteria) this;
        }

        public Criteria andProFundsNotIn(List<Float> values) {
            addCriterion("pro_funds not in", values, "proFunds");
            return (Criteria) this;
        }

        public Criteria andProFundsBetween(Float value1, Float value2) {
            addCriterion("pro_funds between", value1, value2, "proFunds");
            return (Criteria) this;
        }

        public Criteria andProFundsNotBetween(Float value1, Float value2) {
            addCriterion("pro_funds not between", value1, value2, "proFunds");
            return (Criteria) this;
        }

        public Criteria andProTeacherOrderIsNull() {
            addCriterion("pro_teacher_order is null");
            return (Criteria) this;
        }

        public Criteria andProTeacherOrderIsNotNull() {
            addCriterion("pro_teacher_order is not null");
            return (Criteria) this;
        }

        public Criteria andProTeacherOrderEqualTo(Integer value) {
            addCriterion("pro_teacher_order =", value, "proTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andProTeacherOrderNotEqualTo(Integer value) {
            addCriterion("pro_teacher_order <>", value, "proTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andProTeacherOrderGreaterThan(Integer value) {
            addCriterion("pro_teacher_order >", value, "proTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andProTeacherOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_teacher_order >=", value, "proTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andProTeacherOrderLessThan(Integer value) {
            addCriterion("pro_teacher_order <", value, "proTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andProTeacherOrderLessThanOrEqualTo(Integer value) {
            addCriterion("pro_teacher_order <=", value, "proTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andProTeacherOrderIn(List<Integer> values) {
            addCriterion("pro_teacher_order in", values, "proTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andProTeacherOrderNotIn(List<Integer> values) {
            addCriterion("pro_teacher_order not in", values, "proTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andProTeacherOrderBetween(Integer value1, Integer value2) {
            addCriterion("pro_teacher_order between", value1, value2, "proTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andProTeacherOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_teacher_order not between", value1, value2, "proTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andFkTeacherCodeIsNull() {
            addCriterion("fk_teacher_code is null");
            return (Criteria) this;
        }

        public Criteria andFkTeacherCodeIsNotNull() {
            addCriterion("fk_teacher_code is not null");
            return (Criteria) this;
        }

        public Criteria andFkTeacherCodeEqualTo(Long value) {
            addCriterion("fk_teacher_code =", value, "fkTeacherCode");
            return (Criteria) this;
        }

        public Criteria andFkTeacherCodeNotEqualTo(Long value) {
            addCriterion("fk_teacher_code <>", value, "fkTeacherCode");
            return (Criteria) this;
        }

        public Criteria andFkTeacherCodeGreaterThan(Long value) {
            addCriterion("fk_teacher_code >", value, "fkTeacherCode");
            return (Criteria) this;
        }

        public Criteria andFkTeacherCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("fk_teacher_code >=", value, "fkTeacherCode");
            return (Criteria) this;
        }

        public Criteria andFkTeacherCodeLessThan(Long value) {
            addCriterion("fk_teacher_code <", value, "fkTeacherCode");
            return (Criteria) this;
        }

        public Criteria andFkTeacherCodeLessThanOrEqualTo(Long value) {
            addCriterion("fk_teacher_code <=", value, "fkTeacherCode");
            return (Criteria) this;
        }

        public Criteria andFkTeacherCodeIn(List<Long> values) {
            addCriterion("fk_teacher_code in", values, "fkTeacherCode");
            return (Criteria) this;
        }

        public Criteria andFkTeacherCodeNotIn(List<Long> values) {
            addCriterion("fk_teacher_code not in", values, "fkTeacherCode");
            return (Criteria) this;
        }

        public Criteria andFkTeacherCodeBetween(Long value1, Long value2) {
            addCriterion("fk_teacher_code between", value1, value2, "fkTeacherCode");
            return (Criteria) this;
        }

        public Criteria andFkTeacherCodeNotBetween(Long value1, Long value2) {
            addCriterion("fk_teacher_code not between", value1, value2, "fkTeacherCode");
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