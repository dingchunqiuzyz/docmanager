package com.jlju.docmanager.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HonoursExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HonoursExample() {
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

        public Criteria andHoUuidIsNull() {
            addCriterion("ho_uuid is null");
            return (Criteria) this;
        }

        public Criteria andHoUuidIsNotNull() {
            addCriterion("ho_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andHoUuidEqualTo(String value) {
            addCriterion("ho_uuid =", value, "hoUuid");
            return (Criteria) this;
        }

        public Criteria andHoUuidNotEqualTo(String value) {
            addCriterion("ho_uuid <>", value, "hoUuid");
            return (Criteria) this;
        }

        public Criteria andHoUuidGreaterThan(String value) {
            addCriterion("ho_uuid >", value, "hoUuid");
            return (Criteria) this;
        }

        public Criteria andHoUuidGreaterThanOrEqualTo(String value) {
            addCriterion("ho_uuid >=", value, "hoUuid");
            return (Criteria) this;
        }

        public Criteria andHoUuidLessThan(String value) {
            addCriterion("ho_uuid <", value, "hoUuid");
            return (Criteria) this;
        }

        public Criteria andHoUuidLessThanOrEqualTo(String value) {
            addCriterion("ho_uuid <=", value, "hoUuid");
            return (Criteria) this;
        }

        public Criteria andHoUuidLike(String value) {
            addCriterion("ho_uuid like", value, "hoUuid");
            return (Criteria) this;
        }

        public Criteria andHoUuidNotLike(String value) {
            addCriterion("ho_uuid not like", value, "hoUuid");
            return (Criteria) this;
        }

        public Criteria andHoUuidIn(List<String> values) {
            addCriterion("ho_uuid in", values, "hoUuid");
            return (Criteria) this;
        }

        public Criteria andHoUuidNotIn(List<String> values) {
            addCriterion("ho_uuid not in", values, "hoUuid");
            return (Criteria) this;
        }

        public Criteria andHoUuidBetween(String value1, String value2) {
            addCriterion("ho_uuid between", value1, value2, "hoUuid");
            return (Criteria) this;
        }

        public Criteria andHoUuidNotBetween(String value1, String value2) {
            addCriterion("ho_uuid not between", value1, value2, "hoUuid");
            return (Criteria) this;
        }

        public Criteria andHoNameIsNull() {
            addCriterion("ho_name is null");
            return (Criteria) this;
        }

        public Criteria andHoNameIsNotNull() {
            addCriterion("ho_name is not null");
            return (Criteria) this;
        }

        public Criteria andHoNameEqualTo(String value) {
            addCriterion("ho_name =", value, "hoName");
            return (Criteria) this;
        }

        public Criteria andHoNameNotEqualTo(String value) {
            addCriterion("ho_name <>", value, "hoName");
            return (Criteria) this;
        }

        public Criteria andHoNameGreaterThan(String value) {
            addCriterion("ho_name >", value, "hoName");
            return (Criteria) this;
        }

        public Criteria andHoNameGreaterThanOrEqualTo(String value) {
            addCriterion("ho_name >=", value, "hoName");
            return (Criteria) this;
        }

        public Criteria andHoNameLessThan(String value) {
            addCriterion("ho_name <", value, "hoName");
            return (Criteria) this;
        }

        public Criteria andHoNameLessThanOrEqualTo(String value) {
            addCriterion("ho_name <=", value, "hoName");
            return (Criteria) this;
        }

        public Criteria andHoNameLike(String value) {
            addCriterion("ho_name like", value, "hoName");
            return (Criteria) this;
        }

        public Criteria andHoNameNotLike(String value) {
            addCriterion("ho_name not like", value, "hoName");
            return (Criteria) this;
        }

        public Criteria andHoNameIn(List<String> values) {
            addCriterion("ho_name in", values, "hoName");
            return (Criteria) this;
        }

        public Criteria andHoNameNotIn(List<String> values) {
            addCriterion("ho_name not in", values, "hoName");
            return (Criteria) this;
        }

        public Criteria andHoNameBetween(String value1, String value2) {
            addCriterion("ho_name between", value1, value2, "hoName");
            return (Criteria) this;
        }

        public Criteria andHoNameNotBetween(String value1, String value2) {
            addCriterion("ho_name not between", value1, value2, "hoName");
            return (Criteria) this;
        }

        public Criteria andHoRankIsNull() {
            addCriterion("ho_rank is null");
            return (Criteria) this;
        }

        public Criteria andHoRankIsNotNull() {
            addCriterion("ho_rank is not null");
            return (Criteria) this;
        }

        public Criteria andHoRankEqualTo(String value) {
            addCriterion("ho_rank =", value, "hoRank");
            return (Criteria) this;
        }

        public Criteria andHoRankNotEqualTo(String value) {
            addCriterion("ho_rank <>", value, "hoRank");
            return (Criteria) this;
        }

        public Criteria andHoRankGreaterThan(String value) {
            addCriterion("ho_rank >", value, "hoRank");
            return (Criteria) this;
        }

        public Criteria andHoRankGreaterThanOrEqualTo(String value) {
            addCriterion("ho_rank >=", value, "hoRank");
            return (Criteria) this;
        }

        public Criteria andHoRankLessThan(String value) {
            addCriterion("ho_rank <", value, "hoRank");
            return (Criteria) this;
        }

        public Criteria andHoRankLessThanOrEqualTo(String value) {
            addCriterion("ho_rank <=", value, "hoRank");
            return (Criteria) this;
        }

        public Criteria andHoRankLike(String value) {
            addCriterion("ho_rank like", value, "hoRank");
            return (Criteria) this;
        }

        public Criteria andHoRankNotLike(String value) {
            addCriterion("ho_rank not like", value, "hoRank");
            return (Criteria) this;
        }

        public Criteria andHoRankIn(List<String> values) {
            addCriterion("ho_rank in", values, "hoRank");
            return (Criteria) this;
        }

        public Criteria andHoRankNotIn(List<String> values) {
            addCriterion("ho_rank not in", values, "hoRank");
            return (Criteria) this;
        }

        public Criteria andHoRankBetween(String value1, String value2) {
            addCriterion("ho_rank between", value1, value2, "hoRank");
            return (Criteria) this;
        }

        public Criteria andHoRankNotBetween(String value1, String value2) {
            addCriterion("ho_rank not between", value1, value2, "hoRank");
            return (Criteria) this;
        }

        public Criteria andHoStartDateIsNull() {
            addCriterion("ho_start_date is null");
            return (Criteria) this;
        }

        public Criteria andHoStartDateIsNotNull() {
            addCriterion("ho_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andHoStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("ho_start_date =", value, "hoStartDate");
            return (Criteria) this;
        }

        public Criteria andHoStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ho_start_date <>", value, "hoStartDate");
            return (Criteria) this;
        }

        public Criteria andHoStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ho_start_date >", value, "hoStartDate");
            return (Criteria) this;
        }

        public Criteria andHoStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ho_start_date >=", value, "hoStartDate");
            return (Criteria) this;
        }

        public Criteria andHoStartDateLessThan(Date value) {
            addCriterionForJDBCDate("ho_start_date <", value, "hoStartDate");
            return (Criteria) this;
        }

        public Criteria andHoStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ho_start_date <=", value, "hoStartDate");
            return (Criteria) this;
        }

        public Criteria andHoStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("ho_start_date in", values, "hoStartDate");
            return (Criteria) this;
        }

        public Criteria andHoStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ho_start_date not in", values, "hoStartDate");
            return (Criteria) this;
        }

        public Criteria andHoStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ho_start_date between", value1, value2, "hoStartDate");
            return (Criteria) this;
        }

        public Criteria andHoStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ho_start_date not between", value1, value2, "hoStartDate");
            return (Criteria) this;
        }

        public Criteria andHoEndDateIsNull() {
            addCriterion("ho_end_date is null");
            return (Criteria) this;
        }

        public Criteria andHoEndDateIsNotNull() {
            addCriterion("ho_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andHoEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("ho_end_date =", value, "hoEndDate");
            return (Criteria) this;
        }

        public Criteria andHoEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ho_end_date <>", value, "hoEndDate");
            return (Criteria) this;
        }

        public Criteria andHoEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ho_end_date >", value, "hoEndDate");
            return (Criteria) this;
        }

        public Criteria andHoEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ho_end_date >=", value, "hoEndDate");
            return (Criteria) this;
        }

        public Criteria andHoEndDateLessThan(Date value) {
            addCriterionForJDBCDate("ho_end_date <", value, "hoEndDate");
            return (Criteria) this;
        }

        public Criteria andHoEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ho_end_date <=", value, "hoEndDate");
            return (Criteria) this;
        }

        public Criteria andHoEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("ho_end_date in", values, "hoEndDate");
            return (Criteria) this;
        }

        public Criteria andHoEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ho_end_date not in", values, "hoEndDate");
            return (Criteria) this;
        }

        public Criteria andHoEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ho_end_date between", value1, value2, "hoEndDate");
            return (Criteria) this;
        }

        public Criteria andHoEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ho_end_date not between", value1, value2, "hoEndDate");
            return (Criteria) this;
        }

        public Criteria andHoTeacherOrderIsNull() {
            addCriterion("ho_teacher_order is null");
            return (Criteria) this;
        }

        public Criteria andHoTeacherOrderIsNotNull() {
            addCriterion("ho_teacher_order is not null");
            return (Criteria) this;
        }

        public Criteria andHoTeacherOrderEqualTo(Integer value) {
            addCriterion("ho_teacher_order =", value, "hoTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andHoTeacherOrderNotEqualTo(Integer value) {
            addCriterion("ho_teacher_order <>", value, "hoTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andHoTeacherOrderGreaterThan(Integer value) {
            addCriterion("ho_teacher_order >", value, "hoTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andHoTeacherOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("ho_teacher_order >=", value, "hoTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andHoTeacherOrderLessThan(Integer value) {
            addCriterion("ho_teacher_order <", value, "hoTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andHoTeacherOrderLessThanOrEqualTo(Integer value) {
            addCriterion("ho_teacher_order <=", value, "hoTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andHoTeacherOrderIn(List<Integer> values) {
            addCriterion("ho_teacher_order in", values, "hoTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andHoTeacherOrderNotIn(List<Integer> values) {
            addCriterion("ho_teacher_order not in", values, "hoTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andHoTeacherOrderBetween(Integer value1, Integer value2) {
            addCriterion("ho_teacher_order between", value1, value2, "hoTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andHoTeacherOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("ho_teacher_order not between", value1, value2, "hoTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andHoOrgIsNull() {
            addCriterion("ho_org is null");
            return (Criteria) this;
        }

        public Criteria andHoOrgIsNotNull() {
            addCriterion("ho_org is not null");
            return (Criteria) this;
        }

        public Criteria andHoOrgEqualTo(String value) {
            addCriterion("ho_org =", value, "hoOrg");
            return (Criteria) this;
        }

        public Criteria andHoOrgNotEqualTo(String value) {
            addCriterion("ho_org <>", value, "hoOrg");
            return (Criteria) this;
        }

        public Criteria andHoOrgGreaterThan(String value) {
            addCriterion("ho_org >", value, "hoOrg");
            return (Criteria) this;
        }

        public Criteria andHoOrgGreaterThanOrEqualTo(String value) {
            addCriterion("ho_org >=", value, "hoOrg");
            return (Criteria) this;
        }

        public Criteria andHoOrgLessThan(String value) {
            addCriterion("ho_org <", value, "hoOrg");
            return (Criteria) this;
        }

        public Criteria andHoOrgLessThanOrEqualTo(String value) {
            addCriterion("ho_org <=", value, "hoOrg");
            return (Criteria) this;
        }

        public Criteria andHoOrgLike(String value) {
            addCriterion("ho_org like", value, "hoOrg");
            return (Criteria) this;
        }

        public Criteria andHoOrgNotLike(String value) {
            addCriterion("ho_org not like", value, "hoOrg");
            return (Criteria) this;
        }

        public Criteria andHoOrgIn(List<String> values) {
            addCriterion("ho_org in", values, "hoOrg");
            return (Criteria) this;
        }

        public Criteria andHoOrgNotIn(List<String> values) {
            addCriterion("ho_org not in", values, "hoOrg");
            return (Criteria) this;
        }

        public Criteria andHoOrgBetween(String value1, String value2) {
            addCriterion("ho_org between", value1, value2, "hoOrg");
            return (Criteria) this;
        }

        public Criteria andHoOrgNotBetween(String value1, String value2) {
            addCriterion("ho_org not between", value1, value2, "hoOrg");
            return (Criteria) this;
        }

        public Criteria andHoMoneyIsNull() {
            addCriterion("ho_money is null");
            return (Criteria) this;
        }

        public Criteria andHoMoneyIsNotNull() {
            addCriterion("ho_money is not null");
            return (Criteria) this;
        }

        public Criteria andHoMoneyEqualTo(Float value) {
            addCriterion("ho_money =", value, "hoMoney");
            return (Criteria) this;
        }

        public Criteria andHoMoneyNotEqualTo(Float value) {
            addCriterion("ho_money <>", value, "hoMoney");
            return (Criteria) this;
        }

        public Criteria andHoMoneyGreaterThan(Float value) {
            addCriterion("ho_money >", value, "hoMoney");
            return (Criteria) this;
        }

        public Criteria andHoMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("ho_money >=", value, "hoMoney");
            return (Criteria) this;
        }

        public Criteria andHoMoneyLessThan(Float value) {
            addCriterion("ho_money <", value, "hoMoney");
            return (Criteria) this;
        }

        public Criteria andHoMoneyLessThanOrEqualTo(Float value) {
            addCriterion("ho_money <=", value, "hoMoney");
            return (Criteria) this;
        }

        public Criteria andHoMoneyIn(List<Float> values) {
            addCriterion("ho_money in", values, "hoMoney");
            return (Criteria) this;
        }

        public Criteria andHoMoneyNotIn(List<Float> values) {
            addCriterion("ho_money not in", values, "hoMoney");
            return (Criteria) this;
        }

        public Criteria andHoMoneyBetween(Float value1, Float value2) {
            addCriterion("ho_money between", value1, value2, "hoMoney");
            return (Criteria) this;
        }

        public Criteria andHoMoneyNotBetween(Float value1, Float value2) {
            addCriterion("ho_money not between", value1, value2, "hoMoney");
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