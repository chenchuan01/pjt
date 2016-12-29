package com.yidingliu.pjt.data.mapper.example.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yidingliu.pjt.data.base.EntityStatusEnum;
import com.yidingliu.pjt.data.base.mapper.BaseExample;

/**
 * 
 * @Filename SysConfigerExample.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author cc
 *
 * @Email 329985581@qq.com
 * 
 * @History
 *          <li>Author: cc</li>
 *          <li>Date: 2016年9月13日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class SysConfigerExample extends BaseExample {

	protected List<Criteria> oredCriteria;

	public SysConfigerExample() {
		oredCriteria = new ArrayList<Criteria>();
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
		criteria.andStatusEqualTo(EntityStatusEnum.NORMAL.code());
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

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNull() {
			addCriterion("createDate is null");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNotNull() {
			addCriterion("createDate is not null");
			return (Criteria) this;
		}

		public Criteria andCreateDateEqualTo(Date value) {
			addCriterion("createDate =", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotEqualTo(Date value) {
			addCriterion("createDate <>", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThan(Date value) {
			addCriterion("createDate >", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
			addCriterion("createDate >=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThan(Date value) {
			addCriterion("createDate <", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThanOrEqualTo(Date value) {
			addCriterion("createDate <=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateIn(List<Date> values) {
			addCriterion("createDate in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotIn(List<Date> values) {
			addCriterion("createDate not in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateBetween(Date value1, Date value2) {
			addCriterion("createDate between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotBetween(Date value1, Date value2) {
			addCriterion("createDate not between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIsNull() {
			addCriterion("updateDate is null");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIsNotNull() {
			addCriterion("updateDate is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateDateEqualTo(Date value) {
			addCriterion("updateDate =", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotEqualTo(Date value) {
			addCriterion("updateDate <>", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateGreaterThan(Date value) {
			addCriterion("updateDate >", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
			addCriterion("updateDate >=", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLessThan(Date value) {
			addCriterion("updateDate <", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
			addCriterion("updateDate <=", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIn(List<Date> values) {
			addCriterion("updateDate in", values, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotIn(List<Date> values) {
			addCriterion("updateDate not in", values, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateBetween(Date value1, Date value2) {
			addCriterion("updateDate between", value1, value2, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
			addCriterion("updateDate not between", value1, value2, "updateDate");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Integer value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andValueIsNull() {
			addCriterion("value is null");
			return (Criteria) this;
		}

		public Criteria andValueIsNotNull() {
			addCriterion("value is not null");
			return (Criteria) this;
		}

		public Criteria andValueEqualTo(String value) {
			addCriterion("value =", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotEqualTo(String value) {
			addCriterion("value <>", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueGreaterThan(String value) {
			addCriterion("value >", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueGreaterThanOrEqualTo(String value) {
			addCriterion("value >=", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLessThan(String value) {
			addCriterion("value <", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLessThanOrEqualTo(String value) {
			addCriterion("value <=", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLike(String value) {
			addCriterion("value like", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotLike(String value) {
			addCriterion("value not like", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueIn(List<String> values) {
			addCriterion("value in", values, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotIn(List<String> values) {
			addCriterion("value not in", values, "value");
			return (Criteria) this;
		}

		public Criteria andValueBetween(String value1, String value2) {
			addCriterion("value between", value1, value2, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotBetween(String value1, String value2) {
			addCriterion("value not between", value1, value2, "value");
			return (Criteria) this;
		}

		public Criteria andRemarksIsNull() {
			addCriterion("remarks is null");
			return (Criteria) this;
		}

		public Criteria andRemarksIsNotNull() {
			addCriterion("remarks is not null");
			return (Criteria) this;
		}

		public Criteria andRemarksEqualTo(String value) {
			addCriterion("remarks =", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotEqualTo(String value) {
			addCriterion("remarks <>", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksGreaterThan(String value) {
			addCriterion("remarks >", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksGreaterThanOrEqualTo(String value) {
			addCriterion("remarks >=", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLessThan(String value) {
			addCriterion("remarks <", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLessThanOrEqualTo(String value) {
			addCriterion("remarks <=", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLike(String value) {
			addCriterion("remarks like", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotLike(String value) {
			addCriterion("remarks not like", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksIn(List<String> values) {
			addCriterion("remarks in", values, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotIn(List<String> values) {
			addCriterion("remarks not in", values, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksBetween(String value1, String value2) {
			addCriterion("remarks between", value1, value2, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotBetween(String value1, String value2) {
			addCriterion("remarks not between", value1, value2, "remarks");
			return (Criteria) this;
		}
		
		public Criteria andLangTnameIsNull() {
			addCriterion("langTname is null");
			return (Criteria) this;
		}

		public Criteria andLangTnameIsNotNull() {
			addCriterion("langTname is not null");
			return (Criteria) this;
		}

		public Criteria andLangTnameEqualTo(String value) {
			addCriterion("langTname =", value, "langTname");
			return (Criteria) this;
		}

		public Criteria andLangTnameNotEqualTo(String value) {
			addCriterion("langTname <>", value, "langTname");
			return (Criteria) this;
		}

		public Criteria andLangTnameGreaterThan(String value) {
			addCriterion("langTname >", value, "langTname");
			return (Criteria) this;
		}

		public Criteria andLangTnameGreaterThanOrEqualTo(String value) {
			addCriterion("langTname >=", value, "langTname");
			return (Criteria) this;
		}

		public Criteria andLangTnameLessThan(String value) {
			addCriterion("langTname <", value, "langTname");
			return (Criteria) this;
		}

		public Criteria andLangTnameLessThanOrEqualTo(String value) {
			addCriterion("langTname <=", value, "langTname");
			return (Criteria) this;
		}

		public Criteria andLangTnameLike(String value) {
			addCriterion("langTname like", value, "langTname");
			return (Criteria) this;
		}

		public Criteria andLangTnameNotLike(String value) {
			addCriterion("langTname not like", value, "langTname");
			return (Criteria) this;
		}

		public Criteria andLangTnameIn(List<String> values) {
			addCriterion("langTname in", values, "langTname");
			return (Criteria) this;
		}

		public Criteria andLangTnameNotIn(List<String> values) {
			addCriterion("langTname not in", values, "langTname");
			return (Criteria) this;
		}

		public Criteria andLangTnameBetween(String value1, String value2) {
			addCriterion("langTname between", value1, value2, "langTname");
			return (Criteria) this;
		}

		public Criteria andLangTnameNotBetween(String value1, String value2) {
			addCriterion("langTname not between", value1, value2, "langTname");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}
}