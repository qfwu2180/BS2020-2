package com.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StuzuoyeQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public StuzuoyeQuery() {
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

        public Criteria andStuzyidIsNull() {
            addCriterion("stuzyid is null");
            return (Criteria) this;
        }

        public Criteria andStuzyidIsNotNull() {
            addCriterion("stuzyid is not null");
            return (Criteria) this;
        }

        public Criteria andStuzyidEqualTo(Integer value) {
            addCriterion("stuzyid =", value, "stuzyid");
            return (Criteria) this;
        }

        public Criteria andStuzyidNotEqualTo(Integer value) {
            addCriterion("stuzyid <>", value, "stuzyid");
            return (Criteria) this;
        }

        public Criteria andStuzyidGreaterThan(Integer value) {
            addCriterion("stuzyid >", value, "stuzyid");
            return (Criteria) this;
        }

        public Criteria andStuzyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("stuzyid >=", value, "stuzyid");
            return (Criteria) this;
        }

        public Criteria andStuzyidLessThan(Integer value) {
            addCriterion("stuzyid <", value, "stuzyid");
            return (Criteria) this;
        }

        public Criteria andStuzyidLessThanOrEqualTo(Integer value) {
            addCriterion("stuzyid <=", value, "stuzyid");
            return (Criteria) this;
        }

        public Criteria andStuzyidIn(List<Integer> values) {
            addCriterion("stuzyid in", values, "stuzyid");
            return (Criteria) this;
        }

        public Criteria andStuzyidNotIn(List<Integer> values) {
            addCriterion("stuzyid not in", values, "stuzyid");
            return (Criteria) this;
        }

        public Criteria andStuzyidBetween(Integer value1, Integer value2) {
            addCriterion("stuzyid between", value1, value2, "stuzyid");
            return (Criteria) this;
        }

        public Criteria andStuzyidNotBetween(Integer value1, Integer value2) {
            addCriterion("stuzyid not between", value1, value2, "stuzyid");
            return (Criteria) this;
        }

        public Criteria andStidIsNull() {
            addCriterion("stid is null");
            return (Criteria) this;
        }

        public Criteria andStidIsNotNull() {
            addCriterion("stid is not null");
            return (Criteria) this;
        }

        public Criteria andStidEqualTo(Integer value) {
            addCriterion("stid =", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotEqualTo(Integer value) {
            addCriterion("stid <>", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidGreaterThan(Integer value) {
            addCriterion("stid >", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidGreaterThanOrEqualTo(Integer value) {
            addCriterion("stid >=", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidLessThan(Integer value) {
            addCriterion("stid <", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidLessThanOrEqualTo(Integer value) {
            addCriterion("stid <=", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidIn(List<Integer> values) {
            addCriterion("stid in", values, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotIn(List<Integer> values) {
            addCriterion("stid not in", values, "stid");
            return (Criteria) this;
        }

        public Criteria andStidBetween(Integer value1, Integer value2) {
            addCriterion("stid between", value1, value2, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotBetween(Integer value1, Integer value2) {
            addCriterion("stid not between", value1, value2, "stid");
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

        public Criteria andSocreIsNull() {
            addCriterion("socre is null");
            return (Criteria) this;
        }

        public Criteria andSocreIsNotNull() {
            addCriterion("socre is not null");
            return (Criteria) this;
        }

        public Criteria andSocreEqualTo(String value) {
            addCriterion("socre =", value, "socre");
            return (Criteria) this;
        }

        public Criteria andSocreNotEqualTo(String value) {
            addCriterion("socre <>", value, "socre");
            return (Criteria) this;
        }

        public Criteria andSocreGreaterThan(String value) {
            addCriterion("socre >", value, "socre");
            return (Criteria) this;
        }

        public Criteria andSocreGreaterThanOrEqualTo(String value) {
            addCriterion("socre >=", value, "socre");
            return (Criteria) this;
        }

        public Criteria andSocreLessThan(String value) {
            addCriterion("socre <", value, "socre");
            return (Criteria) this;
        }

        public Criteria andSocreLessThanOrEqualTo(String value) {
            addCriterion("socre <=", value, "socre");
            return (Criteria) this;
        }

        public Criteria andSocreLike(String value) {
            addCriterion("socre like", value, "socre");
            return (Criteria) this;
        }

        public Criteria andSocreNotLike(String value) {
            addCriterion("socre not like", value, "socre");
            return (Criteria) this;
        }

        public Criteria andSocreIn(List<String> values) {
            addCriterion("socre in", values, "socre");
            return (Criteria) this;
        }

        public Criteria andSocreNotIn(List<String> values) {
            addCriterion("socre not in", values, "socre");
            return (Criteria) this;
        }

        public Criteria andSocreBetween(String value1, String value2) {
            addCriterion("socre between", value1, value2, "socre");
            return (Criteria) this;
        }

        public Criteria andSocreNotBetween(String value1, String value2) {
            addCriterion("socre not between", value1, value2, "socre");
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

        public Criteria andBanjiIsNull() {
            addCriterion("banji is null");
            return (Criteria) this;
        }

        public Criteria andBanjiIsNotNull() {
            addCriterion("banji is not null");
            return (Criteria) this;
        }

        public Criteria andBanjiEqualTo(String value) {
            addCriterion("banji =", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiNotEqualTo(String value) {
            addCriterion("banji <>", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiGreaterThan(String value) {
            addCriterion("banji >", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiGreaterThanOrEqualTo(String value) {
            addCriterion("banji >=", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiLessThan(String value) {
            addCriterion("banji <", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiLessThanOrEqualTo(String value) {
            addCriterion("banji <=", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiLike(String value) {
            addCriterion("banji like", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiNotLike(String value) {
            addCriterion("banji not like", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiIn(List<String> values) {
            addCriterion("banji in", values, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiNotIn(List<String> values) {
            addCriterion("banji not in", values, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiBetween(String value1, String value2) {
            addCriterion("banji between", value1, value2, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiNotBetween(String value1, String value2) {
            addCriterion("banji not between", value1, value2, "banji");
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