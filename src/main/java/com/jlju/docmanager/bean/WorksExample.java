package com.jlju.docmanager.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WorksExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorksExample() {
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

        public Criteria andWorkUuidIsNull() {
            addCriterion("work_uuid is null");
            return (Criteria) this;
        }

        public Criteria andWorkUuidIsNotNull() {
            addCriterion("work_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andWorkUuidEqualTo(String value) {
            addCriterion("work_uuid =", value, "workUuid");
            return (Criteria) this;
        }

        public Criteria andWorkUuidNotEqualTo(String value) {
            addCriterion("work_uuid <>", value, "workUuid");
            return (Criteria) this;
        }

        public Criteria andWorkUuidGreaterThan(String value) {
            addCriterion("work_uuid >", value, "workUuid");
            return (Criteria) this;
        }

        public Criteria andWorkUuidGreaterThanOrEqualTo(String value) {
            addCriterion("work_uuid >=", value, "workUuid");
            return (Criteria) this;
        }

        public Criteria andWorkUuidLessThan(String value) {
            addCriterion("work_uuid <", value, "workUuid");
            return (Criteria) this;
        }

        public Criteria andWorkUuidLessThanOrEqualTo(String value) {
            addCriterion("work_uuid <=", value, "workUuid");
            return (Criteria) this;
        }

        public Criteria andWorkUuidLike(String value) {
            addCriterion("work_uuid like", value, "workUuid");
            return (Criteria) this;
        }

        public Criteria andWorkUuidNotLike(String value) {
            addCriterion("work_uuid not like", value, "workUuid");
            return (Criteria) this;
        }

        public Criteria andWorkUuidIn(List<String> values) {
            addCriterion("work_uuid in", values, "workUuid");
            return (Criteria) this;
        }

        public Criteria andWorkUuidNotIn(List<String> values) {
            addCriterion("work_uuid not in", values, "workUuid");
            return (Criteria) this;
        }

        public Criteria andWorkUuidBetween(String value1, String value2) {
            addCriterion("work_uuid between", value1, value2, "workUuid");
            return (Criteria) this;
        }

        public Criteria andWorkUuidNotBetween(String value1, String value2) {
            addCriterion("work_uuid not between", value1, value2, "workUuid");
            return (Criteria) this;
        }

        public Criteria andWorkNameIsNull() {
            addCriterion("work_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkNameIsNotNull() {
            addCriterion("work_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkNameEqualTo(String value) {
            addCriterion("work_name =", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameNotEqualTo(String value) {
            addCriterion("work_name <>", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameGreaterThan(String value) {
            addCriterion("work_name >", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameGreaterThanOrEqualTo(String value) {
            addCriterion("work_name >=", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameLessThan(String value) {
            addCriterion("work_name <", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameLessThanOrEqualTo(String value) {
            addCriterion("work_name <=", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameLike(String value) {
            addCriterion("work_name like", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameNotLike(String value) {
            addCriterion("work_name not like", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameIn(List<String> values) {
            addCriterion("work_name in", values, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameNotIn(List<String> values) {
            addCriterion("work_name not in", values, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameBetween(String value1, String value2) {
            addCriterion("work_name between", value1, value2, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameNotBetween(String value1, String value2) {
            addCriterion("work_name not between", value1, value2, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkPublishIsNull() {
            addCriterion("work_publish is null");
            return (Criteria) this;
        }

        public Criteria andWorkPublishIsNotNull() {
            addCriterion("work_publish is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPublishEqualTo(String value) {
            addCriterion("work_publish =", value, "workPublish");
            return (Criteria) this;
        }

        public Criteria andWorkPublishNotEqualTo(String value) {
            addCriterion("work_publish <>", value, "workPublish");
            return (Criteria) this;
        }

        public Criteria andWorkPublishGreaterThan(String value) {
            addCriterion("work_publish >", value, "workPublish");
            return (Criteria) this;
        }

        public Criteria andWorkPublishGreaterThanOrEqualTo(String value) {
            addCriterion("work_publish >=", value, "workPublish");
            return (Criteria) this;
        }

        public Criteria andWorkPublishLessThan(String value) {
            addCriterion("work_publish <", value, "workPublish");
            return (Criteria) this;
        }

        public Criteria andWorkPublishLessThanOrEqualTo(String value) {
            addCriterion("work_publish <=", value, "workPublish");
            return (Criteria) this;
        }

        public Criteria andWorkPublishLike(String value) {
            addCriterion("work_publish like", value, "workPublish");
            return (Criteria) this;
        }

        public Criteria andWorkPublishNotLike(String value) {
            addCriterion("work_publish not like", value, "workPublish");
            return (Criteria) this;
        }

        public Criteria andWorkPublishIn(List<String> values) {
            addCriterion("work_publish in", values, "workPublish");
            return (Criteria) this;
        }

        public Criteria andWorkPublishNotIn(List<String> values) {
            addCriterion("work_publish not in", values, "workPublish");
            return (Criteria) this;
        }

        public Criteria andWorkPublishBetween(String value1, String value2) {
            addCriterion("work_publish between", value1, value2, "workPublish");
            return (Criteria) this;
        }

        public Criteria andWorkPublishNotBetween(String value1, String value2) {
            addCriterion("work_publish not between", value1, value2, "workPublish");
            return (Criteria) this;
        }

        public Criteria andWorkIsbnIsNull() {
            addCriterion("work_isbn is null");
            return (Criteria) this;
        }

        public Criteria andWorkIsbnIsNotNull() {
            addCriterion("work_isbn is not null");
            return (Criteria) this;
        }

        public Criteria andWorkIsbnEqualTo(String value) {
            addCriterion("work_isbn =", value, "workIsbn");
            return (Criteria) this;
        }

        public Criteria andWorkIsbnNotEqualTo(String value) {
            addCriterion("work_isbn <>", value, "workIsbn");
            return (Criteria) this;
        }

        public Criteria andWorkIsbnGreaterThan(String value) {
            addCriterion("work_isbn >", value, "workIsbn");
            return (Criteria) this;
        }

        public Criteria andWorkIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("work_isbn >=", value, "workIsbn");
            return (Criteria) this;
        }

        public Criteria andWorkIsbnLessThan(String value) {
            addCriterion("work_isbn <", value, "workIsbn");
            return (Criteria) this;
        }

        public Criteria andWorkIsbnLessThanOrEqualTo(String value) {
            addCriterion("work_isbn <=", value, "workIsbn");
            return (Criteria) this;
        }

        public Criteria andWorkIsbnLike(String value) {
            addCriterion("work_isbn like", value, "workIsbn");
            return (Criteria) this;
        }

        public Criteria andWorkIsbnNotLike(String value) {
            addCriterion("work_isbn not like", value, "workIsbn");
            return (Criteria) this;
        }

        public Criteria andWorkIsbnIn(List<String> values) {
            addCriterion("work_isbn in", values, "workIsbn");
            return (Criteria) this;
        }

        public Criteria andWorkIsbnNotIn(List<String> values) {
            addCriterion("work_isbn not in", values, "workIsbn");
            return (Criteria) this;
        }

        public Criteria andWorkIsbnBetween(String value1, String value2) {
            addCriterion("work_isbn between", value1, value2, "workIsbn");
            return (Criteria) this;
        }

        public Criteria andWorkIsbnNotBetween(String value1, String value2) {
            addCriterion("work_isbn not between", value1, value2, "workIsbn");
            return (Criteria) this;
        }

        public Criteria andWorkDateIsNull() {
            addCriterion("work_date is null");
            return (Criteria) this;
        }

        public Criteria andWorkDateIsNotNull() {
            addCriterion("work_date is not null");
            return (Criteria) this;
        }

        public Criteria andWorkDateEqualTo(Date value) {
            addCriterionForJDBCDate("work_date =", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("work_date <>", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateGreaterThan(Date value) {
            addCriterionForJDBCDate("work_date >", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("work_date >=", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateLessThan(Date value) {
            addCriterionForJDBCDate("work_date <", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("work_date <=", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateIn(List<Date> values) {
            addCriterionForJDBCDate("work_date in", values, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("work_date not in", values, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("work_date between", value1, value2, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("work_date not between", value1, value2, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkCharNumberIsNull() {
            addCriterion("work_char_number is null");
            return (Criteria) this;
        }

        public Criteria andWorkCharNumberIsNotNull() {
            addCriterion("work_char_number is not null");
            return (Criteria) this;
        }

        public Criteria andWorkCharNumberEqualTo(Float value) {
            addCriterion("work_char_number =", value, "workCharNumber");
            return (Criteria) this;
        }

        public Criteria andWorkCharNumberNotEqualTo(Float value) {
            addCriterion("work_char_number <>", value, "workCharNumber");
            return (Criteria) this;
        }

        public Criteria andWorkCharNumberGreaterThan(Float value) {
            addCriterion("work_char_number >", value, "workCharNumber");
            return (Criteria) this;
        }

        public Criteria andWorkCharNumberGreaterThanOrEqualTo(Float value) {
            addCriterion("work_char_number >=", value, "workCharNumber");
            return (Criteria) this;
        }

        public Criteria andWorkCharNumberLessThan(Float value) {
            addCriterion("work_char_number <", value, "workCharNumber");
            return (Criteria) this;
        }

        public Criteria andWorkCharNumberLessThanOrEqualTo(Float value) {
            addCriterion("work_char_number <=", value, "workCharNumber");
            return (Criteria) this;
        }

        public Criteria andWorkCharNumberIn(List<Float> values) {
            addCriterion("work_char_number in", values, "workCharNumber");
            return (Criteria) this;
        }

        public Criteria andWorkCharNumberNotIn(List<Float> values) {
            addCriterion("work_char_number not in", values, "workCharNumber");
            return (Criteria) this;
        }

        public Criteria andWorkCharNumberBetween(Float value1, Float value2) {
            addCriterion("work_char_number between", value1, value2, "workCharNumber");
            return (Criteria) this;
        }

        public Criteria andWorkCharNumberNotBetween(Float value1, Float value2) {
            addCriterion("work_char_number not between", value1, value2, "workCharNumber");
            return (Criteria) this;
        }

        public Criteria andWorkTeacherOrderIsNull() {
            addCriterion("work_teacher_order is null");
            return (Criteria) this;
        }

        public Criteria andWorkTeacherOrderIsNotNull() {
            addCriterion("work_teacher_order is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTeacherOrderEqualTo(Integer value) {
            addCriterion("work_teacher_order =", value, "workTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andWorkTeacherOrderNotEqualTo(Integer value) {
            addCriterion("work_teacher_order <>", value, "workTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andWorkTeacherOrderGreaterThan(Integer value) {
            addCriterion("work_teacher_order >", value, "workTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andWorkTeacherOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_teacher_order >=", value, "workTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andWorkTeacherOrderLessThan(Integer value) {
            addCriterion("work_teacher_order <", value, "workTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andWorkTeacherOrderLessThanOrEqualTo(Integer value) {
            addCriterion("work_teacher_order <=", value, "workTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andWorkTeacherOrderIn(List<Integer> values) {
            addCriterion("work_teacher_order in", values, "workTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andWorkTeacherOrderNotIn(List<Integer> values) {
            addCriterion("work_teacher_order not in", values, "workTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andWorkTeacherOrderBetween(Integer value1, Integer value2) {
            addCriterion("work_teacher_order between", value1, value2, "workTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andWorkTeacherOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("work_teacher_order not between", value1, value2, "workTeacherOrder");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNull() {
            addCriterion("work_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNotNull() {
            addCriterion("work_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeEqualTo(String value) {
            addCriterion("work_type =", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotEqualTo(String value) {
            addCriterion("work_type <>", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThan(String value) {
            addCriterion("work_type >", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThanOrEqualTo(String value) {
            addCriterion("work_type >=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThan(String value) {
            addCriterion("work_type <", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThanOrEqualTo(String value) {
            addCriterion("work_type <=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLike(String value) {
            addCriterion("work_type like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotLike(String value) {
            addCriterion("work_type not like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIn(List<String> values) {
            addCriterion("work_type in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotIn(List<String> values) {
            addCriterion("work_type not in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeBetween(String value1, String value2) {
            addCriterion("work_type between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotBetween(String value1, String value2) {
            addCriterion("work_type not between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkProductTypeIsNull() {
            addCriterion("work_product_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkProductTypeIsNotNull() {
            addCriterion("work_product_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkProductTypeEqualTo(String value) {
            addCriterion("work_product_type =", value, "workProductType");
            return (Criteria) this;
        }

        public Criteria andWorkProductTypeNotEqualTo(String value) {
            addCriterion("work_product_type <>", value, "workProductType");
            return (Criteria) this;
        }

        public Criteria andWorkProductTypeGreaterThan(String value) {
            addCriterion("work_product_type >", value, "workProductType");
            return (Criteria) this;
        }

        public Criteria andWorkProductTypeGreaterThanOrEqualTo(String value) {
            addCriterion("work_product_type >=", value, "workProductType");
            return (Criteria) this;
        }

        public Criteria andWorkProductTypeLessThan(String value) {
            addCriterion("work_product_type <", value, "workProductType");
            return (Criteria) this;
        }

        public Criteria andWorkProductTypeLessThanOrEqualTo(String value) {
            addCriterion("work_product_type <=", value, "workProductType");
            return (Criteria) this;
        }

        public Criteria andWorkProductTypeLike(String value) {
            addCriterion("work_product_type like", value, "workProductType");
            return (Criteria) this;
        }

        public Criteria andWorkProductTypeNotLike(String value) {
            addCriterion("work_product_type not like", value, "workProductType");
            return (Criteria) this;
        }

        public Criteria andWorkProductTypeIn(List<String> values) {
            addCriterion("work_product_type in", values, "workProductType");
            return (Criteria) this;
        }

        public Criteria andWorkProductTypeNotIn(List<String> values) {
            addCriterion("work_product_type not in", values, "workProductType");
            return (Criteria) this;
        }

        public Criteria andWorkProductTypeBetween(String value1, String value2) {
            addCriterion("work_product_type between", value1, value2, "workProductType");
            return (Criteria) this;
        }

        public Criteria andWorkProductTypeNotBetween(String value1, String value2) {
            addCriterion("work_product_type not between", value1, value2, "workProductType");
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