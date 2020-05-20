package com.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZuoyeQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public ZuoyeQuery() {
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

    public void setPageNo(Integer pageNo) {
        this.pageNo=pageNo;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow=startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
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

        public Criteria andZyidIsNull() {
            addCriterion("zyid is null");
            return (Criteria) this;
        }

        public Criteria andZyidIsNotNull() {
            addCriterion("zyid is not null");
            return (Criteria) this;
        }

        public Criteria andZyidEqualTo(Integer value) {
            addCriterion("zyid =", value, "zyid");
            return (Criteria) this;
        }

        public Criteria andZyidNotEqualTo(Integer value) {
            addCriterion("zyid <>", value, "zyid");
            return (Criteria) this;
        }

        public Criteria andZyidGreaterThan(Integer value) {
            addCriterion("zyid >", value, "zyid");
            return (Criteria) this;
        }

        public Criteria andZyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("zyid >=", value, "zyid");
            return (Criteria) this;
        }

        public Criteria andZyidLessThan(Integer value) {
            addCriterion("zyid <", value, "zyid");
            return (Criteria) this;
        }

        public Criteria andZyidLessThanOrEqualTo(Integer value) {
            addCriterion("zyid <=", value, "zyid");
            return (Criteria) this;
        }

        public Criteria andZyidIn(List<Integer> values) {
            addCriterion("zyid in", values, "zyid");
            return (Criteria) this;
        }

        public Criteria andZyidNotIn(List<Integer> values) {
            addCriterion("zyid not in", values, "zyid");
            return (Criteria) this;
        }

        public Criteria andZyidBetween(Integer value1, Integer value2) {
            addCriterion("zyid between", value1, value2, "zyid");
            return (Criteria) this;
        }

        public Criteria andZyidNotBetween(Integer value1, Integer value2) {
            addCriterion("zyid not between", value1, value2, "zyid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andFujianIsNull() {
            addCriterion("fujian is null");
            return (Criteria) this;
        }

        public Criteria andFujianIsNotNull() {
            addCriterion("fujian is not null");
            return (Criteria) this;
        }

        public Criteria andFujianEqualTo(String value) {
            addCriterion("fujian =", value, "fujian");
            return (Criteria) this;
        }

        public Criteria andFujianNotEqualTo(String value) {
            addCriterion("fujian <>", value, "fujian");
            return (Criteria) this;
        }

        public Criteria andFujianGreaterThan(String value) {
            addCriterion("fujian >", value, "fujian");
            return (Criteria) this;
        }

        public Criteria andFujianGreaterThanOrEqualTo(String value) {
            addCriterion("fujian >=", value, "fujian");
            return (Criteria) this;
        }

        public Criteria andFujianLessThan(String value) {
            addCriterion("fujian <", value, "fujian");
            return (Criteria) this;
        }

        public Criteria andFujianLessThanOrEqualTo(String value) {
            addCriterion("fujian <=", value, "fujian");
            return (Criteria) this;
        }

        public Criteria andFujianLike(String value) {
            addCriterion("fujian like", value, "fujian");
            return (Criteria) this;
        }

        public Criteria andFujianNotLike(String value) {
            addCriterion("fujian not like", value, "fujian");
            return (Criteria) this;
        }

        public Criteria andFujianIn(List<String> values) {
            addCriterion("fujian in", values, "fujian");
            return (Criteria) this;
        }

        public Criteria andFujianNotIn(List<String> values) {
            addCriterion("fujian not in", values, "fujian");
            return (Criteria) this;
        }

        public Criteria andFujianBetween(String value1, String value2) {
            addCriterion("fujian between", value1, value2, "fujian");
            return (Criteria) this;
        }

        public Criteria andFujianNotBetween(String value1, String value2) {
            addCriterion("fujian not between", value1, value2, "fujian");
            return (Criteria) this;
        }

        public Criteria andDaanIsNull() {
            addCriterion("daan is null");
            return (Criteria) this;
        }

        public Criteria andDaanIsNotNull() {
            addCriterion("daan is not null");
            return (Criteria) this;
        }

        public Criteria andDaanEqualTo(String value) {
            addCriterion("daan =", value, "daan");
            return (Criteria) this;
        }

        public Criteria andDaanNotEqualTo(String value) {
            addCriterion("daan <>", value, "daan");
            return (Criteria) this;
        }

        public Criteria andDaanGreaterThan(String value) {
            addCriterion("daan >", value, "daan");
            return (Criteria) this;
        }

        public Criteria andDaanGreaterThanOrEqualTo(String value) {
            addCriterion("daan >=", value, "daan");
            return (Criteria) this;
        }

        public Criteria andDaanLessThan(String value) {
            addCriterion("daan <", value, "daan");
            return (Criteria) this;
        }

        public Criteria andDaanLessThanOrEqualTo(String value) {
            addCriterion("daan <=", value, "daan");
            return (Criteria) this;
        }

        public Criteria andDaanLike(String value) {
            addCriterion("daan like", value, "daan");
            return (Criteria) this;
        }

        public Criteria andDaanNotLike(String value) {
            addCriterion("daan not like", value, "daan");
            return (Criteria) this;
        }

        public Criteria andDaanIn(List<String> values) {
            addCriterion("daan in", values, "daan");
            return (Criteria) this;
        }

        public Criteria andDaanNotIn(List<String> values) {
            addCriterion("daan not in", values, "daan");
            return (Criteria) this;
        }

        public Criteria andDaanBetween(String value1, String value2) {
            addCriterion("daan between", value1, value2, "daan");
            return (Criteria) this;
        }

        public Criteria andDaanNotBetween(String value1, String value2) {
            addCriterion("daan not between", value1, value2, "daan");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andBidIsNull() {
            addCriterion("bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Integer value) {
            addCriterion("bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Integer value) {
            addCriterion("bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Integer value) {
            addCriterion("bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Integer value) {
            addCriterion("bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Integer value) {
            addCriterion("bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Integer> values) {
            addCriterion("bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Integer> values) {
            addCriterion("bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Integer value1, Integer value2) {
            addCriterion("bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Integer value1, Integer value2) {
            addCriterion("bid not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andKemuIsNull() {
            addCriterion("kemu is null");
            return (Criteria) this;
        }

        public Criteria andKemuIsNotNull() {
            addCriterion("kemu is not null");
            return (Criteria) this;
        }

        public Criteria andKemuEqualTo(String value) {
            addCriterion("kemu =", value, "kemu");
            return (Criteria) this;
        }

        public Criteria andKemuNotEqualTo(String value) {
            addCriterion("kemu <>", value, "kemu");
            return (Criteria) this;
        }

        public Criteria andKemuGreaterThan(String value) {
            addCriterion("kemu >", value, "kemu");
            return (Criteria) this;
        }

        public Criteria andKemuGreaterThanOrEqualTo(String value) {
            addCriterion("kemu >=", value, "kemu");
            return (Criteria) this;
        }

        public Criteria andKemuLessThan(String value) {
            addCriterion("kemu <", value, "kemu");
            return (Criteria) this;
        }

        public Criteria andKemuLessThanOrEqualTo(String value) {
            addCriterion("kemu <=", value, "kemu");
            return (Criteria) this;
        }

        public Criteria andKemuLike(String value) {
            addCriterion("kemu like", value, "kemu");
            return (Criteria) this;
        }

        public Criteria andKemuNotLike(String value) {
            addCriterion("kemu not like", value, "kemu");
            return (Criteria) this;
        }

        public Criteria andKemuIn(List<String> values) {
            addCriterion("kemu in", values, "kemu");
            return (Criteria) this;
        }

        public Criteria andKemuNotIn(List<String> values) {
            addCriterion("kemu not in", values, "kemu");
            return (Criteria) this;
        }

        public Criteria andKemuBetween(String value1, String value2) {
            addCriterion("kemu between", value1, value2, "kemu");
            return (Criteria) this;
        }

        public Criteria andKemuNotBetween(String value1, String value2) {
            addCriterion("kemu not between", value1, value2, "kemu");
            return (Criteria) this;
        }

        public Criteria andPicIsNull() {
            addCriterion("pic is null");
            return (Criteria) this;
        }

        public Criteria andPicIsNotNull() {
            addCriterion("pic is not null");
            return (Criteria) this;
        }

        public Criteria andPicEqualTo(String value) {
            addCriterion("pic =", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotEqualTo(String value) {
            addCriterion("pic <>", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThan(String value) {
            addCriterion("pic >", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualTo(String value) {
            addCriterion("pic >=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThan(String value) {
            addCriterion("pic <", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualTo(String value) {
            addCriterion("pic <=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLike(String value) {
            addCriterion("pic like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotLike(String value) {
            addCriterion("pic not like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicIn(List<String> values) {
            addCriterion("pic in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotIn(List<String> values) {
            addCriterion("pic not in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicBetween(String value1, String value2) {
            addCriterion("pic between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotBetween(String value1, String value2) {
            addCriterion("pic not between", value1, value2, "pic");
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