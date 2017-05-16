package com.jlju.docmanager.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PatentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PatentsExample() {
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

        public Criteria andPatUuidIsNull() {
            addCriterion("pat_uuid is null");
            return (Criteria) this;
        }

        public Criteria andPatUuidIsNotNull() {
            addCriterion("pat_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andPatUuidEqualTo(String value) {
            addCriterion("pat_uuid =", value, "patUuid");
            return (Criteria) this;
        }

        public Criteria andPatUuidNotEqualTo(String value) {
            addCriterion("pat_uuid <>", value, "patUuid");
            return (Criteria) this;
        }

        public Criteria andPatUuidGreaterThan(String value) {
            addCriterion("pat_uuid >", value, "patUuid");
            return (Criteria) this;
        }

        public Criteria andPatUuidGreaterThanOrEqualTo(String value) {
            addCriterion("pat_uuid >=", value, "patUuid");
            return (Criteria) this;
        }

        public Criteria andPatUuidLessThan(String value) {
            addCriterion("pat_uuid <", value, "patUuid");
            return (Criteria) this;
        }

        public Criteria andPatUuidLessThanOrEqualTo(String value) {
            addCriterion("pat_uuid <=", value, "patUuid");
            return (Criteria) this;
        }

        public Criteria andPatUuidLike(String value) {
            addCriterion("pat_uuid like", value, "patUuid");
            return (Criteria) this;
        }

        public Criteria andPatUuidNotLike(String value) {
            addCriterion("pat_uuid not like", value, "patUuid");
            return (Criteria) this;
        }

        public Criteria andPatUuidIn(List<String> values) {
            addCriterion("pat_uuid in", values, "patUuid");
            return (Criteria) this;
        }

        public Criteria andPatUuidNotIn(List<String> values) {
            addCriterion("pat_uuid not in", values, "patUuid");
            return (Criteria) this;
        }

        public Criteria andPatUuidBetween(String value1, String value2) {
            addCriterion("pat_uuid between", value1, value2, "patUuid");
            return (Criteria) this;
        }

        public Criteria andPatUuidNotBetween(String value1, String value2) {
            addCriterion("pat_uuid not between", value1, value2, "patUuid");
            return (Criteria) this;
        }

        public Criteria andPatNameIsNull() {
            addCriterion("pat_name is null");
            return (Criteria) this;
        }

        public Criteria andPatNameIsNotNull() {
            addCriterion("pat_name is not null");
            return (Criteria) this;
        }

        public Criteria andPatNameEqualTo(String value) {
            addCriterion("pat_name =", value, "patName");
            return (Criteria) this;
        }

        public Criteria andPatNameNotEqualTo(String value) {
            addCriterion("pat_name <>", value, "patName");
            return (Criteria) this;
        }

        public Criteria andPatNameGreaterThan(String value) {
            addCriterion("pat_name >", value, "patName");
            return (Criteria) this;
        }

        public Criteria andPatNameGreaterThanOrEqualTo(String value) {
            addCriterion("pat_name >=", value, "patName");
            return (Criteria) this;
        }

        public Criteria andPatNameLessThan(String value) {
            addCriterion("pat_name <", value, "patName");
            return (Criteria) this;
        }

        public Criteria andPatNameLessThanOrEqualTo(String value) {
            addCriterion("pat_name <=", value, "patName");
            return (Criteria) this;
        }

        public Criteria andPatNameLike(String value) {
            addCriterion("pat_name like", value, "patName");
            return (Criteria) this;
        }

        public Criteria andPatNameNotLike(String value) {
            addCriterion("pat_name not like", value, "patName");
            return (Criteria) this;
        }

        public Criteria andPatNameIn(List<String> values) {
            addCriterion("pat_name in", values, "patName");
            return (Criteria) this;
        }

        public Criteria andPatNameNotIn(List<String> values) {
            addCriterion("pat_name not in", values, "patName");
            return (Criteria) this;
        }

        public Criteria andPatNameBetween(String value1, String value2) {
            addCriterion("pat_name between", value1, value2, "patName");
            return (Criteria) this;
        }

        public Criteria andPatNameNotBetween(String value1, String value2) {
            addCriterion("pat_name not between", value1, value2, "patName");
            return (Criteria) this;
        }

        public Criteria andPatTypeIsNull() {
            addCriterion("pat_type is null");
            return (Criteria) this;
        }

        public Criteria andPatTypeIsNotNull() {
            addCriterion("pat_type is not null");
            return (Criteria) this;
        }

        public Criteria andPatTypeEqualTo(String value) {
            addCriterion("pat_type =", value, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeNotEqualTo(String value) {
            addCriterion("pat_type <>", value, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeGreaterThan(String value) {
            addCriterion("pat_type >", value, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pat_type >=", value, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeLessThan(String value) {
            addCriterion("pat_type <", value, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeLessThanOrEqualTo(String value) {
            addCriterion("pat_type <=", value, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeLike(String value) {
            addCriterion("pat_type like", value, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeNotLike(String value) {
            addCriterion("pat_type not like", value, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeIn(List<String> values) {
            addCriterion("pat_type in", values, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeNotIn(List<String> values) {
            addCriterion("pat_type not in", values, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeBetween(String value1, String value2) {
            addCriterion("pat_type between", value1, value2, "patType");
            return (Criteria) this;
        }

        public Criteria andPatTypeNotBetween(String value1, String value2) {
            addCriterion("pat_type not between", value1, value2, "patType");
            return (Criteria) this;
        }

        public Criteria andPatCodeIsNull() {
            addCriterion("pat_code is null");
            return (Criteria) this;
        }

        public Criteria andPatCodeIsNotNull() {
            addCriterion("pat_code is not null");
            return (Criteria) this;
        }

        public Criteria andPatCodeEqualTo(String value) {
            addCriterion("pat_code =", value, "patCode");
            return (Criteria) this;
        }

        public Criteria andPatCodeNotEqualTo(String value) {
            addCriterion("pat_code <>", value, "patCode");
            return (Criteria) this;
        }

        public Criteria andPatCodeGreaterThan(String value) {
            addCriterion("pat_code >", value, "patCode");
            return (Criteria) this;
        }

        public Criteria andPatCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pat_code >=", value, "patCode");
            return (Criteria) this;
        }

        public Criteria andPatCodeLessThan(String value) {
            addCriterion("pat_code <", value, "patCode");
            return (Criteria) this;
        }

        public Criteria andPatCodeLessThanOrEqualTo(String value) {
            addCriterion("pat_code <=", value, "patCode");
            return (Criteria) this;
        }

        public Criteria andPatCodeLike(String value) {
            addCriterion("pat_code like", value, "patCode");
            return (Criteria) this;
        }

        public Criteria andPatCodeNotLike(String value) {
            addCriterion("pat_code not like", value, "patCode");
            return (Criteria) this;
        }

        public Criteria andPatCodeIn(List<String> values) {
            addCriterion("pat_code in", values, "patCode");
            return (Criteria) this;
        }

        public Criteria andPatCodeNotIn(List<String> values) {
            addCriterion("pat_code not in", values, "patCode");
            return (Criteria) this;
        }

        public Criteria andPatCodeBetween(String value1, String value2) {
            addCriterion("pat_code between", value1, value2, "patCode");
            return (Criteria) this;
        }

        public Criteria andPatCodeNotBetween(String value1, String value2) {
            addCriterion("pat_code not between", value1, value2, "patCode");
            return (Criteria) this;
        }

        public Criteria andPatTeacherNameIsNull() {
            addCriterion("pat_teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andPatTeacherNameIsNotNull() {
            addCriterion("pat_teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andPatTeacherNameEqualTo(String value) {
            addCriterion("pat_teacher_name =", value, "patTeacherName");
            return (Criteria) this;
        }

        public Criteria andPatTeacherNameNotEqualTo(String value) {
            addCriterion("pat_teacher_name <>", value, "patTeacherName");
            return (Criteria) this;
        }

        public Criteria andPatTeacherNameGreaterThan(String value) {
            addCriterion("pat_teacher_name >", value, "patTeacherName");
            return (Criteria) this;
        }

        public Criteria andPatTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("pat_teacher_name >=", value, "patTeacherName");
            return (Criteria) this;
        }

        public Criteria andPatTeacherNameLessThan(String value) {
            addCriterion("pat_teacher_name <", value, "patTeacherName");
            return (Criteria) this;
        }

        public Criteria andPatTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("pat_teacher_name <=", value, "patTeacherName");
            return (Criteria) this;
        }

        public Criteria andPatTeacherNameLike(String value) {
            addCriterion("pat_teacher_name like", value, "patTeacherName");
            return (Criteria) this;
        }

        public Criteria andPatTeacherNameNotLike(String value) {
            addCriterion("pat_teacher_name not like", value, "patTeacherName");
            return (Criteria) this;
        }

        public Criteria andPatTeacherNameIn(List<String> values) {
            addCriterion("pat_teacher_name in", values, "patTeacherName");
            return (Criteria) this;
        }

        public Criteria andPatTeacherNameNotIn(List<String> values) {
            addCriterion("pat_teacher_name not in", values, "patTeacherName");
            return (Criteria) this;
        }

        public Criteria andPatTeacherNameBetween(String value1, String value2) {
            addCriterion("pat_teacher_name between", value1, value2, "patTeacherName");
            return (Criteria) this;
        }

        public Criteria andPatTeacherNameNotBetween(String value1, String value2) {
            addCriterion("pat_teacher_name not between", value1, value2, "patTeacherName");
            return (Criteria) this;
        }

        public Criteria andPatDateIsNull() {
            addCriterion("pat_date is null");
            return (Criteria) this;
        }

        public Criteria andPatDateIsNotNull() {
            addCriterion("pat_date is not null");
            return (Criteria) this;
        }

        public Criteria andPatDateEqualTo(Date value) {
            addCriterionForJDBCDate("pat_date =", value, "patDate");
            return (Criteria) this;
        }

        public Criteria andPatDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("pat_date <>", value, "patDate");
            return (Criteria) this;
        }

        public Criteria andPatDateGreaterThan(Date value) {
            addCriterionForJDBCDate("pat_date >", value, "patDate");
            return (Criteria) this;
        }

        public Criteria andPatDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pat_date >=", value, "patDate");
            return (Criteria) this;
        }

        public Criteria andPatDateLessThan(Date value) {
            addCriterionForJDBCDate("pat_date <", value, "patDate");
            return (Criteria) this;
        }

        public Criteria andPatDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pat_date <=", value, "patDate");
            return (Criteria) this;
        }

        public Criteria andPatDateIn(List<Date> values) {
            addCriterionForJDBCDate("pat_date in", values, "patDate");
            return (Criteria) this;
        }

        public Criteria andPatDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("pat_date not in", values, "patDate");
            return (Criteria) this;
        }

        public Criteria andPatDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pat_date between", value1, value2, "patDate");
            return (Criteria) this;
        }

        public Criteria andPatDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pat_date not between", value1, value2, "patDate");
            return (Criteria) this;
        }

        public Criteria andPatTeacherOrderIsNull() {
            addCriterion("pat_teacher_order is null");
            return (Criteria) this;
        }

        public Criteria andPatTeacherOrderIsNotNull() {
            addCriterion("pat_teacher_order is not null");
            return (Criteria) this;
        }

        public Criteria andPatTeacherOrderEqualTo(Integer value) {
            addCriterion("pat_teacher_order =", value, "patTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPatTeacherOrderNotEqualTo(Integer value) {
            addCriterion("pat_teacher_order <>", value, "patTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPatTeacherOrderGreaterThan(Integer value) {
            addCriterion("pat_teacher_order >", value, "patTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPatTeacherOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("pat_teacher_order >=", value, "patTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPatTeacherOrderLessThan(Integer value) {
            addCriterion("pat_teacher_order <", value, "patTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPatTeacherOrderLessThanOrEqualTo(Integer value) {
            addCriterion("pat_teacher_order <=", value, "patTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPatTeacherOrderIn(List<Integer> values) {
            addCriterion("pat_teacher_order in", values, "patTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPatTeacherOrderNotIn(List<Integer> values) {
            addCriterion("pat_teacher_order not in", values, "patTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPatTeacherOrderBetween(Integer value1, Integer value2) {
            addCriterion("pat_teacher_order between", value1, value2, "patTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPatTeacherOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("pat_teacher_order not between", value1, value2, "patTeacherOrder");
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