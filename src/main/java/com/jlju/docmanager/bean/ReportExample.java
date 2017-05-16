package com.jlju.docmanager.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReportExample() {
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

        public Criteria andRepUuidIsNull() {
            addCriterion("rep_uuid is null");
            return (Criteria) this;
        }

        public Criteria andRepUuidIsNotNull() {
            addCriterion("rep_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andRepUuidEqualTo(String value) {
            addCriterion("rep_uuid =", value, "repUuid");
            return (Criteria) this;
        }

        public Criteria andRepUuidNotEqualTo(String value) {
            addCriterion("rep_uuid <>", value, "repUuid");
            return (Criteria) this;
        }

        public Criteria andRepUuidGreaterThan(String value) {
            addCriterion("rep_uuid >", value, "repUuid");
            return (Criteria) this;
        }

        public Criteria andRepUuidGreaterThanOrEqualTo(String value) {
            addCriterion("rep_uuid >=", value, "repUuid");
            return (Criteria) this;
        }

        public Criteria andRepUuidLessThan(String value) {
            addCriterion("rep_uuid <", value, "repUuid");
            return (Criteria) this;
        }

        public Criteria andRepUuidLessThanOrEqualTo(String value) {
            addCriterion("rep_uuid <=", value, "repUuid");
            return (Criteria) this;
        }

        public Criteria andRepUuidLike(String value) {
            addCriterion("rep_uuid like", value, "repUuid");
            return (Criteria) this;
        }

        public Criteria andRepUuidNotLike(String value) {
            addCriterion("rep_uuid not like", value, "repUuid");
            return (Criteria) this;
        }

        public Criteria andRepUuidIn(List<String> values) {
            addCriterion("rep_uuid in", values, "repUuid");
            return (Criteria) this;
        }

        public Criteria andRepUuidNotIn(List<String> values) {
            addCriterion("rep_uuid not in", values, "repUuid");
            return (Criteria) this;
        }

        public Criteria andRepUuidBetween(String value1, String value2) {
            addCriterion("rep_uuid between", value1, value2, "repUuid");
            return (Criteria) this;
        }

        public Criteria andRepUuidNotBetween(String value1, String value2) {
            addCriterion("rep_uuid not between", value1, value2, "repUuid");
            return (Criteria) this;
        }

        public Criteria andRepNameIsNull() {
            addCriterion("rep_name is null");
            return (Criteria) this;
        }

        public Criteria andRepNameIsNotNull() {
            addCriterion("rep_name is not null");
            return (Criteria) this;
        }

        public Criteria andRepNameEqualTo(String value) {
            addCriterion("rep_name =", value, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameNotEqualTo(String value) {
            addCriterion("rep_name <>", value, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameGreaterThan(String value) {
            addCriterion("rep_name >", value, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameGreaterThanOrEqualTo(String value) {
            addCriterion("rep_name >=", value, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameLessThan(String value) {
            addCriterion("rep_name <", value, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameLessThanOrEqualTo(String value) {
            addCriterion("rep_name <=", value, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameLike(String value) {
            addCriterion("rep_name like", value, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameNotLike(String value) {
            addCriterion("rep_name not like", value, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameIn(List<String> values) {
            addCriterion("rep_name in", values, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameNotIn(List<String> values) {
            addCriterion("rep_name not in", values, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameBetween(String value1, String value2) {
            addCriterion("rep_name between", value1, value2, "repName");
            return (Criteria) this;
        }

        public Criteria andRepNameNotBetween(String value1, String value2) {
            addCriterion("rep_name not between", value1, value2, "repName");
            return (Criteria) this;
        }

        public Criteria andRepRankIsNull() {
            addCriterion("rep_rank is null");
            return (Criteria) this;
        }

        public Criteria andRepRankIsNotNull() {
            addCriterion("rep_rank is not null");
            return (Criteria) this;
        }

        public Criteria andRepRankEqualTo(String value) {
            addCriterion("rep_rank =", value, "repRank");
            return (Criteria) this;
        }

        public Criteria andRepRankNotEqualTo(String value) {
            addCriterion("rep_rank <>", value, "repRank");
            return (Criteria) this;
        }

        public Criteria andRepRankGreaterThan(String value) {
            addCriterion("rep_rank >", value, "repRank");
            return (Criteria) this;
        }

        public Criteria andRepRankGreaterThanOrEqualTo(String value) {
            addCriterion("rep_rank >=", value, "repRank");
            return (Criteria) this;
        }

        public Criteria andRepRankLessThan(String value) {
            addCriterion("rep_rank <", value, "repRank");
            return (Criteria) this;
        }

        public Criteria andRepRankLessThanOrEqualTo(String value) {
            addCriterion("rep_rank <=", value, "repRank");
            return (Criteria) this;
        }

        public Criteria andRepRankLike(String value) {
            addCriterion("rep_rank like", value, "repRank");
            return (Criteria) this;
        }

        public Criteria andRepRankNotLike(String value) {
            addCriterion("rep_rank not like", value, "repRank");
            return (Criteria) this;
        }

        public Criteria andRepRankIn(List<String> values) {
            addCriterion("rep_rank in", values, "repRank");
            return (Criteria) this;
        }

        public Criteria andRepRankNotIn(List<String> values) {
            addCriterion("rep_rank not in", values, "repRank");
            return (Criteria) this;
        }

        public Criteria andRepRankBetween(String value1, String value2) {
            addCriterion("rep_rank between", value1, value2, "repRank");
            return (Criteria) this;
        }

        public Criteria andRepRankNotBetween(String value1, String value2) {
            addCriterion("rep_rank not between", value1, value2, "repRank");
            return (Criteria) this;
        }

        public Criteria andRepDateIsNull() {
            addCriterion("rep_date is null");
            return (Criteria) this;
        }

        public Criteria andRepDateIsNotNull() {
            addCriterion("rep_date is not null");
            return (Criteria) this;
        }

        public Criteria andRepDateEqualTo(Date value) {
            addCriterionForJDBCDate("rep_date =", value, "repDate");
            return (Criteria) this;
        }

        public Criteria andRepDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("rep_date <>", value, "repDate");
            return (Criteria) this;
        }

        public Criteria andRepDateGreaterThan(Date value) {
            addCriterionForJDBCDate("rep_date >", value, "repDate");
            return (Criteria) this;
        }

        public Criteria andRepDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rep_date >=", value, "repDate");
            return (Criteria) this;
        }

        public Criteria andRepDateLessThan(Date value) {
            addCriterionForJDBCDate("rep_date <", value, "repDate");
            return (Criteria) this;
        }

        public Criteria andRepDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rep_date <=", value, "repDate");
            return (Criteria) this;
        }

        public Criteria andRepDateIn(List<Date> values) {
            addCriterionForJDBCDate("rep_date in", values, "repDate");
            return (Criteria) this;
        }

        public Criteria andRepDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("rep_date not in", values, "repDate");
            return (Criteria) this;
        }

        public Criteria andRepDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rep_date between", value1, value2, "repDate");
            return (Criteria) this;
        }

        public Criteria andRepDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rep_date not between", value1, value2, "repDate");
            return (Criteria) this;
        }

        public Criteria andRepTeacherOrderIsNull() {
            addCriterion("rep_teacher_order is null");
            return (Criteria) this;
        }

        public Criteria andRepTeacherOrderIsNotNull() {
            addCriterion("rep_teacher_order is not null");
            return (Criteria) this;
        }

        public Criteria andRepTeacherOrderEqualTo(Integer value) {
            addCriterion("rep_teacher_order =", value, "repTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andRepTeacherOrderNotEqualTo(Integer value) {
            addCriterion("rep_teacher_order <>", value, "repTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andRepTeacherOrderGreaterThan(Integer value) {
            addCriterion("rep_teacher_order >", value, "repTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andRepTeacherOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("rep_teacher_order >=", value, "repTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andRepTeacherOrderLessThan(Integer value) {
            addCriterion("rep_teacher_order <", value, "repTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andRepTeacherOrderLessThanOrEqualTo(Integer value) {
            addCriterion("rep_teacher_order <=", value, "repTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andRepTeacherOrderIn(List<Integer> values) {
            addCriterion("rep_teacher_order in", values, "repTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andRepTeacherOrderNotIn(List<Integer> values) {
            addCriterion("rep_teacher_order not in", values, "repTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andRepTeacherOrderBetween(Integer value1, Integer value2) {
            addCriterion("rep_teacher_order between", value1, value2, "repTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andRepTeacherOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("rep_teacher_order not between", value1, value2, "repTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andRepOrgIsNull() {
            addCriterion("rep_org is null");
            return (Criteria) this;
        }

        public Criteria andRepOrgIsNotNull() {
            addCriterion("rep_org is not null");
            return (Criteria) this;
        }

        public Criteria andRepOrgEqualTo(String value) {
            addCriterion("rep_org =", value, "repOrg");
            return (Criteria) this;
        }

        public Criteria andRepOrgNotEqualTo(String value) {
            addCriterion("rep_org <>", value, "repOrg");
            return (Criteria) this;
        }

        public Criteria andRepOrgGreaterThan(String value) {
            addCriterion("rep_org >", value, "repOrg");
            return (Criteria) this;
        }

        public Criteria andRepOrgGreaterThanOrEqualTo(String value) {
            addCriterion("rep_org >=", value, "repOrg");
            return (Criteria) this;
        }

        public Criteria andRepOrgLessThan(String value) {
            addCriterion("rep_org <", value, "repOrg");
            return (Criteria) this;
        }

        public Criteria andRepOrgLessThanOrEqualTo(String value) {
            addCriterion("rep_org <=", value, "repOrg");
            return (Criteria) this;
        }

        public Criteria andRepOrgLike(String value) {
            addCriterion("rep_org like", value, "repOrg");
            return (Criteria) this;
        }

        public Criteria andRepOrgNotLike(String value) {
            addCriterion("rep_org not like", value, "repOrg");
            return (Criteria) this;
        }

        public Criteria andRepOrgIn(List<String> values) {
            addCriterion("rep_org in", values, "repOrg");
            return (Criteria) this;
        }

        public Criteria andRepOrgNotIn(List<String> values) {
            addCriterion("rep_org not in", values, "repOrg");
            return (Criteria) this;
        }

        public Criteria andRepOrgBetween(String value1, String value2) {
            addCriterion("rep_org between", value1, value2, "repOrg");
            return (Criteria) this;
        }

        public Criteria andRepOrgNotBetween(String value1, String value2) {
            addCriterion("rep_org not between", value1, value2, "repOrg");
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