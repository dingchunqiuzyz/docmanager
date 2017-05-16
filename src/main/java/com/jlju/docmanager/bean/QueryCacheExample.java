package com.jlju.docmanager.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class QueryCacheExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QueryCacheExample() {
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

        public Criteria andCacheIdIsNull() {
            addCriterion("cache_id is null");
            return (Criteria) this;
        }

        public Criteria andCacheIdIsNotNull() {
            addCriterion("cache_id is not null");
            return (Criteria) this;
        }

        public Criteria andCacheIdEqualTo(Integer value) {
            addCriterion("cache_id =", value, "cacheId");
            return (Criteria) this;
        }

        public Criteria andCacheIdNotEqualTo(Integer value) {
            addCriterion("cache_id <>", value, "cacheId");
            return (Criteria) this;
        }

        public Criteria andCacheIdGreaterThan(Integer value) {
            addCriterion("cache_id >", value, "cacheId");
            return (Criteria) this;
        }

        public Criteria andCacheIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cache_id >=", value, "cacheId");
            return (Criteria) this;
        }

        public Criteria andCacheIdLessThan(Integer value) {
            addCriterion("cache_id <", value, "cacheId");
            return (Criteria) this;
        }

        public Criteria andCacheIdLessThanOrEqualTo(Integer value) {
            addCriterion("cache_id <=", value, "cacheId");
            return (Criteria) this;
        }

        public Criteria andCacheIdIn(List<Integer> values) {
            addCriterion("cache_id in", values, "cacheId");
            return (Criteria) this;
        }

        public Criteria andCacheIdNotIn(List<Integer> values) {
            addCriterion("cache_id not in", values, "cacheId");
            return (Criteria) this;
        }

        public Criteria andCacheIdBetween(Integer value1, Integer value2) {
            addCriterion("cache_id between", value1, value2, "cacheId");
            return (Criteria) this;
        }

        public Criteria andCacheIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cache_id not between", value1, value2, "cacheId");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("file_type =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("file_type <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("file_type >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("file_type >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("file_type <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("file_type <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("file_type like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("file_type not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("file_type in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("file_type not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("file_type between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("file_type not between", value1, value2, "fileType");
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

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("file_path is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("file_path is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("file_path =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("file_path <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("file_path >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("file_path >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("file_path <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("file_path <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("file_path like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("file_path not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("file_path in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("file_path not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("file_path between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("file_path not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNull() {
            addCriterion("teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("teacher_name =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("teacher_name <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("teacher_name >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_name >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("teacher_name <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("teacher_name <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("teacher_name like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("teacher_name not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("teacher_name in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("teacher_name not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("teacher_name between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("teacher_name not between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andFileDateIsNull() {
            addCriterion("file_date is null");
            return (Criteria) this;
        }

        public Criteria andFileDateIsNotNull() {
            addCriterion("file_date is not null");
            return (Criteria) this;
        }

        public Criteria andFileDateEqualTo(Date value) {
            addCriterionForJDBCDate("file_date =", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("file_date <>", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateGreaterThan(Date value) {
            addCriterionForJDBCDate("file_date >", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("file_date >=", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateLessThan(Date value) {
            addCriterionForJDBCDate("file_date <", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("file_date <=", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateIn(List<Date> values) {
            addCriterionForJDBCDate("file_date in", values, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("file_date not in", values, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("file_date between", value1, value2, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("file_date not between", value1, value2, "fileDate");
            return (Criteria) this;
        }

        public Criteria andOrdersIsNull() {
            addCriterion("orders is null");
            return (Criteria) this;
        }

        public Criteria andOrdersIsNotNull() {
            addCriterion("orders is not null");
            return (Criteria) this;
        }

        public Criteria andOrdersEqualTo(Integer value) {
            addCriterion("orders =", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersNotEqualTo(Integer value) {
            addCriterion("orders <>", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersGreaterThan(Integer value) {
            addCriterion("orders >", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersGreaterThanOrEqualTo(Integer value) {
            addCriterion("orders >=", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersLessThan(Integer value) {
            addCriterion("orders <", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersLessThanOrEqualTo(Integer value) {
            addCriterion("orders <=", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersIn(List<Integer> values) {
            addCriterion("orders in", values, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersNotIn(List<Integer> values) {
            addCriterion("orders not in", values, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersBetween(Integer value1, Integer value2) {
            addCriterion("orders between", value1, value2, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersNotBetween(Integer value1, Integer value2) {
            addCriterion("orders not between", value1, value2, "orders");
            return (Criteria) this;
        }

        public Criteria andFkFileUuidIsNull() {
            addCriterion("fk_file_uuid is null");
            return (Criteria) this;
        }

        public Criteria andFkFileUuidIsNotNull() {
            addCriterion("fk_file_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andFkFileUuidEqualTo(String value) {
            addCriterion("fk_file_uuid =", value, "fkFileUuid");
            return (Criteria) this;
        }

        public Criteria andFkFileUuidNotEqualTo(String value) {
            addCriterion("fk_file_uuid <>", value, "fkFileUuid");
            return (Criteria) this;
        }

        public Criteria andFkFileUuidGreaterThan(String value) {
            addCriterion("fk_file_uuid >", value, "fkFileUuid");
            return (Criteria) this;
        }

        public Criteria andFkFileUuidGreaterThanOrEqualTo(String value) {
            addCriterion("fk_file_uuid >=", value, "fkFileUuid");
            return (Criteria) this;
        }

        public Criteria andFkFileUuidLessThan(String value) {
            addCriterion("fk_file_uuid <", value, "fkFileUuid");
            return (Criteria) this;
        }

        public Criteria andFkFileUuidLessThanOrEqualTo(String value) {
            addCriterion("fk_file_uuid <=", value, "fkFileUuid");
            return (Criteria) this;
        }

        public Criteria andFkFileUuidLike(String value) {
            addCriterion("fk_file_uuid like", value, "fkFileUuid");
            return (Criteria) this;
        }

        public Criteria andFkFileUuidNotLike(String value) {
            addCriterion("fk_file_uuid not like", value, "fkFileUuid");
            return (Criteria) this;
        }

        public Criteria andFkFileUuidIn(List<String> values) {
            addCriterion("fk_file_uuid in", values, "fkFileUuid");
            return (Criteria) this;
        }

        public Criteria andFkFileUuidNotIn(List<String> values) {
            addCriterion("fk_file_uuid not in", values, "fkFileUuid");
            return (Criteria) this;
        }

        public Criteria andFkFileUuidBetween(String value1, String value2) {
            addCriterion("fk_file_uuid between", value1, value2, "fkFileUuid");
            return (Criteria) this;
        }

        public Criteria andFkFileUuidNotBetween(String value1, String value2) {
            addCriterion("fk_file_uuid not between", value1, value2, "fkFileUuid");
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