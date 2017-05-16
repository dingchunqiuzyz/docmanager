package com.jlju.docmanager.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PrizesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrizesExample() {
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

        public Criteria andPriUuidIsNull() {
            addCriterion("pri_uuid is null");
            return (Criteria) this;
        }

        public Criteria andPriUuidIsNotNull() {
            addCriterion("pri_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andPriUuidEqualTo(String value) {
            addCriterion("pri_uuid =", value, "priUuid");
            return (Criteria) this;
        }

        public Criteria andPriUuidNotEqualTo(String value) {
            addCriterion("pri_uuid <>", value, "priUuid");
            return (Criteria) this;
        }

        public Criteria andPriUuidGreaterThan(String value) {
            addCriterion("pri_uuid >", value, "priUuid");
            return (Criteria) this;
        }

        public Criteria andPriUuidGreaterThanOrEqualTo(String value) {
            addCriterion("pri_uuid >=", value, "priUuid");
            return (Criteria) this;
        }

        public Criteria andPriUuidLessThan(String value) {
            addCriterion("pri_uuid <", value, "priUuid");
            return (Criteria) this;
        }

        public Criteria andPriUuidLessThanOrEqualTo(String value) {
            addCriterion("pri_uuid <=", value, "priUuid");
            return (Criteria) this;
        }

        public Criteria andPriUuidLike(String value) {
            addCriterion("pri_uuid like", value, "priUuid");
            return (Criteria) this;
        }

        public Criteria andPriUuidNotLike(String value) {
            addCriterion("pri_uuid not like", value, "priUuid");
            return (Criteria) this;
        }

        public Criteria andPriUuidIn(List<String> values) {
            addCriterion("pri_uuid in", values, "priUuid");
            return (Criteria) this;
        }

        public Criteria andPriUuidNotIn(List<String> values) {
            addCriterion("pri_uuid not in", values, "priUuid");
            return (Criteria) this;
        }

        public Criteria andPriUuidBetween(String value1, String value2) {
            addCriterion("pri_uuid between", value1, value2, "priUuid");
            return (Criteria) this;
        }

        public Criteria andPriUuidNotBetween(String value1, String value2) {
            addCriterion("pri_uuid not between", value1, value2, "priUuid");
            return (Criteria) this;
        }

        public Criteria andPriNameIsNull() {
            addCriterion("pri_name is null");
            return (Criteria) this;
        }

        public Criteria andPriNameIsNotNull() {
            addCriterion("pri_name is not null");
            return (Criteria) this;
        }

        public Criteria andPriNameEqualTo(String value) {
            addCriterion("pri_name =", value, "priName");
            return (Criteria) this;
        }

        public Criteria andPriNameNotEqualTo(String value) {
            addCriterion("pri_name <>", value, "priName");
            return (Criteria) this;
        }

        public Criteria andPriNameGreaterThan(String value) {
            addCriterion("pri_name >", value, "priName");
            return (Criteria) this;
        }

        public Criteria andPriNameGreaterThanOrEqualTo(String value) {
            addCriterion("pri_name >=", value, "priName");
            return (Criteria) this;
        }

        public Criteria andPriNameLessThan(String value) {
            addCriterion("pri_name <", value, "priName");
            return (Criteria) this;
        }

        public Criteria andPriNameLessThanOrEqualTo(String value) {
            addCriterion("pri_name <=", value, "priName");
            return (Criteria) this;
        }

        public Criteria andPriNameLike(String value) {
            addCriterion("pri_name like", value, "priName");
            return (Criteria) this;
        }

        public Criteria andPriNameNotLike(String value) {
            addCriterion("pri_name not like", value, "priName");
            return (Criteria) this;
        }

        public Criteria andPriNameIn(List<String> values) {
            addCriterion("pri_name in", values, "priName");
            return (Criteria) this;
        }

        public Criteria andPriNameNotIn(List<String> values) {
            addCriterion("pri_name not in", values, "priName");
            return (Criteria) this;
        }

        public Criteria andPriNameBetween(String value1, String value2) {
            addCriterion("pri_name between", value1, value2, "priName");
            return (Criteria) this;
        }

        public Criteria andPriNameNotBetween(String value1, String value2) {
            addCriterion("pri_name not between", value1, value2, "priName");
            return (Criteria) this;
        }

        public Criteria andPriOrgIsNull() {
            addCriterion("pri_org is null");
            return (Criteria) this;
        }

        public Criteria andPriOrgIsNotNull() {
            addCriterion("pri_org is not null");
            return (Criteria) this;
        }

        public Criteria andPriOrgEqualTo(String value) {
            addCriterion("pri_org =", value, "priOrg");
            return (Criteria) this;
        }

        public Criteria andPriOrgNotEqualTo(String value) {
            addCriterion("pri_org <>", value, "priOrg");
            return (Criteria) this;
        }

        public Criteria andPriOrgGreaterThan(String value) {
            addCriterion("pri_org >", value, "priOrg");
            return (Criteria) this;
        }

        public Criteria andPriOrgGreaterThanOrEqualTo(String value) {
            addCriterion("pri_org >=", value, "priOrg");
            return (Criteria) this;
        }

        public Criteria andPriOrgLessThan(String value) {
            addCriterion("pri_org <", value, "priOrg");
            return (Criteria) this;
        }

        public Criteria andPriOrgLessThanOrEqualTo(String value) {
            addCriterion("pri_org <=", value, "priOrg");
            return (Criteria) this;
        }

        public Criteria andPriOrgLike(String value) {
            addCriterion("pri_org like", value, "priOrg");
            return (Criteria) this;
        }

        public Criteria andPriOrgNotLike(String value) {
            addCriterion("pri_org not like", value, "priOrg");
            return (Criteria) this;
        }

        public Criteria andPriOrgIn(List<String> values) {
            addCriterion("pri_org in", values, "priOrg");
            return (Criteria) this;
        }

        public Criteria andPriOrgNotIn(List<String> values) {
            addCriterion("pri_org not in", values, "priOrg");
            return (Criteria) this;
        }

        public Criteria andPriOrgBetween(String value1, String value2) {
            addCriterion("pri_org between", value1, value2, "priOrg");
            return (Criteria) this;
        }

        public Criteria andPriOrgNotBetween(String value1, String value2) {
            addCriterion("pri_org not between", value1, value2, "priOrg");
            return (Criteria) this;
        }

        public Criteria andPriRankIsNull() {
            addCriterion("pri_rank is null");
            return (Criteria) this;
        }

        public Criteria andPriRankIsNotNull() {
            addCriterion("pri_rank is not null");
            return (Criteria) this;
        }

        public Criteria andPriRankEqualTo(String value) {
            addCriterion("pri_rank =", value, "priRank");
            return (Criteria) this;
        }

        public Criteria andPriRankNotEqualTo(String value) {
            addCriterion("pri_rank <>", value, "priRank");
            return (Criteria) this;
        }

        public Criteria andPriRankGreaterThan(String value) {
            addCriterion("pri_rank >", value, "priRank");
            return (Criteria) this;
        }

        public Criteria andPriRankGreaterThanOrEqualTo(String value) {
            addCriterion("pri_rank >=", value, "priRank");
            return (Criteria) this;
        }

        public Criteria andPriRankLessThan(String value) {
            addCriterion("pri_rank <", value, "priRank");
            return (Criteria) this;
        }

        public Criteria andPriRankLessThanOrEqualTo(String value) {
            addCriterion("pri_rank <=", value, "priRank");
            return (Criteria) this;
        }

        public Criteria andPriRankLike(String value) {
            addCriterion("pri_rank like", value, "priRank");
            return (Criteria) this;
        }

        public Criteria andPriRankNotLike(String value) {
            addCriterion("pri_rank not like", value, "priRank");
            return (Criteria) this;
        }

        public Criteria andPriRankIn(List<String> values) {
            addCriterion("pri_rank in", values, "priRank");
            return (Criteria) this;
        }

        public Criteria andPriRankNotIn(List<String> values) {
            addCriterion("pri_rank not in", values, "priRank");
            return (Criteria) this;
        }

        public Criteria andPriRankBetween(String value1, String value2) {
            addCriterion("pri_rank between", value1, value2, "priRank");
            return (Criteria) this;
        }

        public Criteria andPriRankNotBetween(String value1, String value2) {
            addCriterion("pri_rank not between", value1, value2, "priRank");
            return (Criteria) this;
        }

        public Criteria andPriDateIsNull() {
            addCriterion("pri_date is null");
            return (Criteria) this;
        }

        public Criteria andPriDateIsNotNull() {
            addCriterion("pri_date is not null");
            return (Criteria) this;
        }

        public Criteria andPriDateEqualTo(Date value) {
            addCriterionForJDBCDate("pri_date =", value, "priDate");
            return (Criteria) this;
        }

        public Criteria andPriDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("pri_date <>", value, "priDate");
            return (Criteria) this;
        }

        public Criteria andPriDateGreaterThan(Date value) {
            addCriterionForJDBCDate("pri_date >", value, "priDate");
            return (Criteria) this;
        }

        public Criteria andPriDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pri_date >=", value, "priDate");
            return (Criteria) this;
        }

        public Criteria andPriDateLessThan(Date value) {
            addCriterionForJDBCDate("pri_date <", value, "priDate");
            return (Criteria) this;
        }

        public Criteria andPriDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pri_date <=", value, "priDate");
            return (Criteria) this;
        }

        public Criteria andPriDateIn(List<Date> values) {
            addCriterionForJDBCDate("pri_date in", values, "priDate");
            return (Criteria) this;
        }

        public Criteria andPriDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("pri_date not in", values, "priDate");
            return (Criteria) this;
        }

        public Criteria andPriDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pri_date between", value1, value2, "priDate");
            return (Criteria) this;
        }

        public Criteria andPriDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pri_date not between", value1, value2, "priDate");
            return (Criteria) this;
        }

        public Criteria andPriTeacherOrderIsNull() {
            addCriterion("pri_teacher_order is null");
            return (Criteria) this;
        }

        public Criteria andPriTeacherOrderIsNotNull() {
            addCriterion("pri_teacher_order is not null");
            return (Criteria) this;
        }

        public Criteria andPriTeacherOrderEqualTo(Integer value) {
            addCriterion("pri_teacher_order =", value, "priTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPriTeacherOrderNotEqualTo(Integer value) {
            addCriterion("pri_teacher_order <>", value, "priTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPriTeacherOrderGreaterThan(Integer value) {
            addCriterion("pri_teacher_order >", value, "priTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPriTeacherOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("pri_teacher_order >=", value, "priTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPriTeacherOrderLessThan(Integer value) {
            addCriterion("pri_teacher_order <", value, "priTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPriTeacherOrderLessThanOrEqualTo(Integer value) {
            addCriterion("pri_teacher_order <=", value, "priTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPriTeacherOrderIn(List<Integer> values) {
            addCriterion("pri_teacher_order in", values, "priTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPriTeacherOrderNotIn(List<Integer> values) {
            addCriterion("pri_teacher_order not in", values, "priTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPriTeacherOrderBetween(Integer value1, Integer value2) {
            addCriterion("pri_teacher_order between", value1, value2, "priTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPriTeacherOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("pri_teacher_order not between", value1, value2, "priTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andPriSchoolOrderIsNull() {
            addCriterion("pri_school_order is null");
            return (Criteria) this;
        }

        public Criteria andPriSchoolOrderIsNotNull() {
            addCriterion("pri_school_order is not null");
            return (Criteria) this;
        }

        public Criteria andPriSchoolOrderEqualTo(Integer value) {
            addCriterion("pri_school_order =", value, "priSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andPriSchoolOrderNotEqualTo(Integer value) {
            addCriterion("pri_school_order <>", value, "priSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andPriSchoolOrderGreaterThan(Integer value) {
            addCriterion("pri_school_order >", value, "priSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andPriSchoolOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("pri_school_order >=", value, "priSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andPriSchoolOrderLessThan(Integer value) {
            addCriterion("pri_school_order <", value, "priSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andPriSchoolOrderLessThanOrEqualTo(Integer value) {
            addCriterion("pri_school_order <=", value, "priSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andPriSchoolOrderIn(List<Integer> values) {
            addCriterion("pri_school_order in", values, "priSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andPriSchoolOrderNotIn(List<Integer> values) {
            addCriterion("pri_school_order not in", values, "priSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andPriSchoolOrderBetween(Integer value1, Integer value2) {
            addCriterion("pri_school_order between", value1, value2, "priSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andPriSchoolOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("pri_school_order not between", value1, value2, "priSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andPriTypeIsNull() {
            addCriterion("pri_type is null");
            return (Criteria) this;
        }

        public Criteria andPriTypeIsNotNull() {
            addCriterion("pri_type is not null");
            return (Criteria) this;
        }

        public Criteria andPriTypeEqualTo(String value) {
            addCriterion("pri_type =", value, "priType");
            return (Criteria) this;
        }

        public Criteria andPriTypeNotEqualTo(String value) {
            addCriterion("pri_type <>", value, "priType");
            return (Criteria) this;
        }

        public Criteria andPriTypeGreaterThan(String value) {
            addCriterion("pri_type >", value, "priType");
            return (Criteria) this;
        }

        public Criteria andPriTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pri_type >=", value, "priType");
            return (Criteria) this;
        }

        public Criteria andPriTypeLessThan(String value) {
            addCriterion("pri_type <", value, "priType");
            return (Criteria) this;
        }

        public Criteria andPriTypeLessThanOrEqualTo(String value) {
            addCriterion("pri_type <=", value, "priType");
            return (Criteria) this;
        }

        public Criteria andPriTypeLike(String value) {
            addCriterion("pri_type like", value, "priType");
            return (Criteria) this;
        }

        public Criteria andPriTypeNotLike(String value) {
            addCriterion("pri_type not like", value, "priType");
            return (Criteria) this;
        }

        public Criteria andPriTypeIn(List<String> values) {
            addCriterion("pri_type in", values, "priType");
            return (Criteria) this;
        }

        public Criteria andPriTypeNotIn(List<String> values) {
            addCriterion("pri_type not in", values, "priType");
            return (Criteria) this;
        }

        public Criteria andPriTypeBetween(String value1, String value2) {
            addCriterion("pri_type between", value1, value2, "priType");
            return (Criteria) this;
        }

        public Criteria andPriTypeNotBetween(String value1, String value2) {
            addCriterion("pri_type not between", value1, value2, "priType");
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