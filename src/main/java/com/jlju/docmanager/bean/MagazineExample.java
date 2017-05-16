package com.jlju.docmanager.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MagazineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MagazineExample() {
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

        public Criteria andMagUuidIsNull() {
            addCriterion("mag_uuid is null");
            return (Criteria) this;
        }

        public Criteria andMagUuidIsNotNull() {
            addCriterion("mag_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andMagUuidEqualTo(String value) {
            addCriterion("mag_uuid =", value, "magUuid");
            return (Criteria) this;
        }

        public Criteria andMagUuidNotEqualTo(String value) {
            addCriterion("mag_uuid <>", value, "magUuid");
            return (Criteria) this;
        }

        public Criteria andMagUuidGreaterThan(String value) {
            addCriterion("mag_uuid >", value, "magUuid");
            return (Criteria) this;
        }

        public Criteria andMagUuidGreaterThanOrEqualTo(String value) {
            addCriterion("mag_uuid >=", value, "magUuid");
            return (Criteria) this;
        }

        public Criteria andMagUuidLessThan(String value) {
            addCriterion("mag_uuid <", value, "magUuid");
            return (Criteria) this;
        }

        public Criteria andMagUuidLessThanOrEqualTo(String value) {
            addCriterion("mag_uuid <=", value, "magUuid");
            return (Criteria) this;
        }

        public Criteria andMagUuidLike(String value) {
            addCriterion("mag_uuid like", value, "magUuid");
            return (Criteria) this;
        }

        public Criteria andMagUuidNotLike(String value) {
            addCriterion("mag_uuid not like", value, "magUuid");
            return (Criteria) this;
        }

        public Criteria andMagUuidIn(List<String> values) {
            addCriterion("mag_uuid in", values, "magUuid");
            return (Criteria) this;
        }

        public Criteria andMagUuidNotIn(List<String> values) {
            addCriterion("mag_uuid not in", values, "magUuid");
            return (Criteria) this;
        }

        public Criteria andMagUuidBetween(String value1, String value2) {
            addCriterion("mag_uuid between", value1, value2, "magUuid");
            return (Criteria) this;
        }

        public Criteria andMagUuidNotBetween(String value1, String value2) {
            addCriterion("mag_uuid not between", value1, value2, "magUuid");
            return (Criteria) this;
        }

        public Criteria andMagNameIsNull() {
            addCriterion("mag_name is null");
            return (Criteria) this;
        }

        public Criteria andMagNameIsNotNull() {
            addCriterion("mag_name is not null");
            return (Criteria) this;
        }

        public Criteria andMagNameEqualTo(String value) {
            addCriterion("mag_name =", value, "magName");
            return (Criteria) this;
        }

        public Criteria andMagNameNotEqualTo(String value) {
            addCriterion("mag_name <>", value, "magName");
            return (Criteria) this;
        }

        public Criteria andMagNameGreaterThan(String value) {
            addCriterion("mag_name >", value, "magName");
            return (Criteria) this;
        }

        public Criteria andMagNameGreaterThanOrEqualTo(String value) {
            addCriterion("mag_name >=", value, "magName");
            return (Criteria) this;
        }

        public Criteria andMagNameLessThan(String value) {
            addCriterion("mag_name <", value, "magName");
            return (Criteria) this;
        }

        public Criteria andMagNameLessThanOrEqualTo(String value) {
            addCriterion("mag_name <=", value, "magName");
            return (Criteria) this;
        }

        public Criteria andMagNameLike(String value) {
            addCriterion("mag_name like", value, "magName");
            return (Criteria) this;
        }

        public Criteria andMagNameNotLike(String value) {
            addCriterion("mag_name not like", value, "magName");
            return (Criteria) this;
        }

        public Criteria andMagNameIn(List<String> values) {
            addCriterion("mag_name in", values, "magName");
            return (Criteria) this;
        }

        public Criteria andMagNameNotIn(List<String> values) {
            addCriterion("mag_name not in", values, "magName");
            return (Criteria) this;
        }

        public Criteria andMagNameBetween(String value1, String value2) {
            addCriterion("mag_name between", value1, value2, "magName");
            return (Criteria) this;
        }

        public Criteria andMagNameNotBetween(String value1, String value2) {
            addCriterion("mag_name not between", value1, value2, "magName");
            return (Criteria) this;
        }

        public Criteria andMagLevelIsNull() {
            addCriterion("mag_level is null");
            return (Criteria) this;
        }

        public Criteria andMagLevelIsNotNull() {
            addCriterion("mag_level is not null");
            return (Criteria) this;
        }

        public Criteria andMagLevelEqualTo(String value) {
            addCriterion("mag_level =", value, "magLevel");
            return (Criteria) this;
        }

        public Criteria andMagLevelNotEqualTo(String value) {
            addCriterion("mag_level <>", value, "magLevel");
            return (Criteria) this;
        }

        public Criteria andMagLevelGreaterThan(String value) {
            addCriterion("mag_level >", value, "magLevel");
            return (Criteria) this;
        }

        public Criteria andMagLevelGreaterThanOrEqualTo(String value) {
            addCriterion("mag_level >=", value, "magLevel");
            return (Criteria) this;
        }

        public Criteria andMagLevelLessThan(String value) {
            addCriterion("mag_level <", value, "magLevel");
            return (Criteria) this;
        }

        public Criteria andMagLevelLessThanOrEqualTo(String value) {
            addCriterion("mag_level <=", value, "magLevel");
            return (Criteria) this;
        }

        public Criteria andMagLevelLike(String value) {
            addCriterion("mag_level like", value, "magLevel");
            return (Criteria) this;
        }

        public Criteria andMagLevelNotLike(String value) {
            addCriterion("mag_level not like", value, "magLevel");
            return (Criteria) this;
        }

        public Criteria andMagLevelIn(List<String> values) {
            addCriterion("mag_level in", values, "magLevel");
            return (Criteria) this;
        }

        public Criteria andMagLevelNotIn(List<String> values) {
            addCriterion("mag_level not in", values, "magLevel");
            return (Criteria) this;
        }

        public Criteria andMagLevelBetween(String value1, String value2) {
            addCriterion("mag_level between", value1, value2, "magLevel");
            return (Criteria) this;
        }

        public Criteria andMagLevelNotBetween(String value1, String value2) {
            addCriterion("mag_level not between", value1, value2, "magLevel");
            return (Criteria) this;
        }

        public Criteria andMagPubDateIsNull() {
            addCriterion("mag_pub_date is null");
            return (Criteria) this;
        }

        public Criteria andMagPubDateIsNotNull() {
            addCriterion("mag_pub_date is not null");
            return (Criteria) this;
        }

        public Criteria andMagPubDateEqualTo(Date value) {
            addCriterionForJDBCDate("mag_pub_date =", value, "magPubDate");
            return (Criteria) this;
        }

        public Criteria andMagPubDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("mag_pub_date <>", value, "magPubDate");
            return (Criteria) this;
        }

        public Criteria andMagPubDateGreaterThan(Date value) {
            addCriterionForJDBCDate("mag_pub_date >", value, "magPubDate");
            return (Criteria) this;
        }

        public Criteria andMagPubDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mag_pub_date >=", value, "magPubDate");
            return (Criteria) this;
        }

        public Criteria andMagPubDateLessThan(Date value) {
            addCriterionForJDBCDate("mag_pub_date <", value, "magPubDate");
            return (Criteria) this;
        }

        public Criteria andMagPubDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mag_pub_date <=", value, "magPubDate");
            return (Criteria) this;
        }

        public Criteria andMagPubDateIn(List<Date> values) {
            addCriterionForJDBCDate("mag_pub_date in", values, "magPubDate");
            return (Criteria) this;
        }

        public Criteria andMagPubDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("mag_pub_date not in", values, "magPubDate");
            return (Criteria) this;
        }

        public Criteria andMagPubDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mag_pub_date between", value1, value2, "magPubDate");
            return (Criteria) this;
        }

        public Criteria andMagPubDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mag_pub_date not between", value1, value2, "magPubDate");
            return (Criteria) this;
        }

        public Criteria andMagTeacherOrderIsNull() {
            addCriterion("mag_teacher_order is null");
            return (Criteria) this;
        }

        public Criteria andMagTeacherOrderIsNotNull() {
            addCriterion("mag_teacher_order is not null");
            return (Criteria) this;
        }

        public Criteria andMagTeacherOrderEqualTo(Integer value) {
            addCriterion("mag_teacher_order =", value, "magTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andMagTeacherOrderNotEqualTo(Integer value) {
            addCriterion("mag_teacher_order <>", value, "magTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andMagTeacherOrderGreaterThan(Integer value) {
            addCriterion("mag_teacher_order >", value, "magTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andMagTeacherOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("mag_teacher_order >=", value, "magTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andMagTeacherOrderLessThan(Integer value) {
            addCriterion("mag_teacher_order <", value, "magTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andMagTeacherOrderLessThanOrEqualTo(Integer value) {
            addCriterion("mag_teacher_order <=", value, "magTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andMagTeacherOrderIn(List<Integer> values) {
            addCriterion("mag_teacher_order in", values, "magTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andMagTeacherOrderNotIn(List<Integer> values) {
            addCriterion("mag_teacher_order not in", values, "magTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andMagTeacherOrderBetween(Integer value1, Integer value2) {
            addCriterion("mag_teacher_order between", value1, value2, "magTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andMagTeacherOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("mag_teacher_order not between", value1, value2, "magTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andMagSchoolOrderIsNull() {
            addCriterion("mag_school_order is null");
            return (Criteria) this;
        }

        public Criteria andMagSchoolOrderIsNotNull() {
            addCriterion("mag_school_order is not null");
            return (Criteria) this;
        }

        public Criteria andMagSchoolOrderEqualTo(Integer value) {
            addCriterion("mag_school_order =", value, "magSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andMagSchoolOrderNotEqualTo(Integer value) {
            addCriterion("mag_school_order <>", value, "magSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andMagSchoolOrderGreaterThan(Integer value) {
            addCriterion("mag_school_order >", value, "magSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andMagSchoolOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("mag_school_order >=", value, "magSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andMagSchoolOrderLessThan(Integer value) {
            addCriterion("mag_school_order <", value, "magSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andMagSchoolOrderLessThanOrEqualTo(Integer value) {
            addCriterion("mag_school_order <=", value, "magSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andMagSchoolOrderIn(List<Integer> values) {
            addCriterion("mag_school_order in", values, "magSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andMagSchoolOrderNotIn(List<Integer> values) {
            addCriterion("mag_school_order not in", values, "magSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andMagSchoolOrderBetween(Integer value1, Integer value2) {
            addCriterion("mag_school_order between", value1, value2, "magSchoolOrder");
            return (Criteria) this;
        }

        public Criteria andMagSchoolOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("mag_school_order not between", value1, value2, "magSchoolOrder");
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

        public Criteria andMagDeacIsNull() {
            addCriterion("mag_deac is null");
            return (Criteria) this;
        }

        public Criteria andMagDeacIsNotNull() {
            addCriterion("mag_deac is not null");
            return (Criteria) this;
        }

        public Criteria andMagDeacEqualTo(String value) {
            addCriterion("mag_deac =", value, "magDeac");
            return (Criteria) this;
        }

        public Criteria andMagDeacNotEqualTo(String value) {
            addCriterion("mag_deac <>", value, "magDeac");
            return (Criteria) this;
        }

        public Criteria andMagDeacGreaterThan(String value) {
            addCriterion("mag_deac >", value, "magDeac");
            return (Criteria) this;
        }

        public Criteria andMagDeacGreaterThanOrEqualTo(String value) {
            addCriterion("mag_deac >=", value, "magDeac");
            return (Criteria) this;
        }

        public Criteria andMagDeacLessThan(String value) {
            addCriterion("mag_deac <", value, "magDeac");
            return (Criteria) this;
        }

        public Criteria andMagDeacLessThanOrEqualTo(String value) {
            addCriterion("mag_deac <=", value, "magDeac");
            return (Criteria) this;
        }

        public Criteria andMagDeacLike(String value) {
            addCriterion("mag_deac like", value, "magDeac");
            return (Criteria) this;
        }

        public Criteria andMagDeacNotLike(String value) {
            addCriterion("mag_deac not like", value, "magDeac");
            return (Criteria) this;
        }

        public Criteria andMagDeacIn(List<String> values) {
            addCriterion("mag_deac in", values, "magDeac");
            return (Criteria) this;
        }

        public Criteria andMagDeacNotIn(List<String> values) {
            addCriterion("mag_deac not in", values, "magDeac");
            return (Criteria) this;
        }

        public Criteria andMagDeacBetween(String value1, String value2) {
            addCriterion("mag_deac between", value1, value2, "magDeac");
            return (Criteria) this;
        }

        public Criteria andMagDeacNotBetween(String value1, String value2) {
            addCriterion("mag_deac not between", value1, value2, "magDeac");
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