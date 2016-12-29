package com.yidingliu.pjt.data.mapper.example.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yidingliu.pjt.data.base.EntityStatusEnum;
import com.yidingliu.pjt.data.base.mapper.BaseExample;

public class SysUserExample extends BaseExample{

    protected List<Criteria> oredCriteria;

    public SysUserExample() {
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

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("lastLoginTime is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("lastLoginTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("lastLoginTime =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("lastLoginTime <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("lastLoginTime >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastLoginTime >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("lastLoginTime <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("lastLoginTime <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("lastLoginTime in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("lastLoginTime not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("lastLoginTime between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("lastLoginTime not between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNull() {
            addCriterion("loginName is null");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNotNull() {
            addCriterion("loginName is not null");
            return (Criteria) this;
        }

        public Criteria andLoginNameEqualTo(String value) {
            addCriterion("loginName =", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotEqualTo(String value) {
            addCriterion("loginName <>", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThan(String value) {
            addCriterion("loginName >", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("loginName >=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThan(String value) {
            addCriterion("loginName <", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThanOrEqualTo(String value) {
            addCriterion("loginName <=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLike(String value) {
            addCriterion("loginName like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotLike(String value) {
            addCriterion("loginName not like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameIn(List<String> values) {
            addCriterion("loginName in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotIn(List<String> values) {
            addCriterion("loginName not in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameBetween(String value1, String value2) {
            addCriterion("loginName between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotBetween(String value1, String value2) {
            addCriterion("loginName not between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIsNull() {
            addCriterion("loginPassword is null");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIsNotNull() {
            addCriterion("loginPassword is not null");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordEqualTo(String value) {
            addCriterion("loginPassword =", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotEqualTo(String value) {
            addCriterion("loginPassword <>", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordGreaterThan(String value) {
            addCriterion("loginPassword >", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("loginPassword >=", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLessThan(String value) {
            addCriterion("loginPassword <", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLessThanOrEqualTo(String value) {
            addCriterion("loginPassword <=", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLike(String value) {
            addCriterion("loginPassword like", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotLike(String value) {
            addCriterion("loginPassword not like", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIn(List<String> values) {
            addCriterion("loginPassword in", values, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotIn(List<String> values) {
            addCriterion("loginPassword not in", values, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordBetween(String value1, String value2) {
            addCriterion("loginPassword between", value1, value2, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotBetween(String value1, String value2) {
            addCriterion("loginPassword not between", value1, value2, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andNiceNameIsNull() {
            addCriterion("niceName is null");
            return (Criteria) this;
        }

        public Criteria andNiceNameIsNotNull() {
            addCriterion("niceName is not null");
            return (Criteria) this;
        }

        public Criteria andNiceNameEqualTo(String value) {
            addCriterion("niceName =", value, "niceName");
            return (Criteria) this;
        }

        public Criteria andNiceNameNotEqualTo(String value) {
            addCriterion("niceName <>", value, "niceName");
            return (Criteria) this;
        }

        public Criteria andNiceNameGreaterThan(String value) {
            addCriterion("niceName >", value, "niceName");
            return (Criteria) this;
        }

        public Criteria andNiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("niceName >=", value, "niceName");
            return (Criteria) this;
        }

        public Criteria andNiceNameLessThan(String value) {
            addCriterion("niceName <", value, "niceName");
            return (Criteria) this;
        }

        public Criteria andNiceNameLessThanOrEqualTo(String value) {
            addCriterion("niceName <=", value, "niceName");
            return (Criteria) this;
        }

        public Criteria andNiceNameLike(String value) {
            addCriterion("niceName like", value, "niceName");
            return (Criteria) this;
        }

        public Criteria andNiceNameNotLike(String value) {
            addCriterion("niceName not like", value, "niceName");
            return (Criteria) this;
        }

        public Criteria andNiceNameIn(List<String> values) {
            addCriterion("niceName in", values, "niceName");
            return (Criteria) this;
        }

        public Criteria andNiceNameNotIn(List<String> values) {
            addCriterion("niceName not in", values, "niceName");
            return (Criteria) this;
        }

        public Criteria andNiceNameBetween(String value1, String value2) {
            addCriterion("niceName between", value1, value2, "niceName");
            return (Criteria) this;
        }

        public Criteria andNiceNameNotBetween(String value1, String value2) {
            addCriterion("niceName not between", value1, value2, "niceName");
            return (Criteria) this;
        }

        
        
        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }
        
        public Criteria andRoleIdIsNull() {
            addCriterion("roleId is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("roleId is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Long value) {
            addCriterion("roleId =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Long value) {
            addCriterion("roleId <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Long value) {
            addCriterion("roleId >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("roleId >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Long value) {
            addCriterion("roleId <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Long value) {
            addCriterion("roleId <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Long> values) {
            addCriterion("roleId in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Long> values) {
            addCriterion("roleId not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Long value1, Long value2) {
            addCriterion("roleId between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Long value1, Long value2) {
            addCriterion("roleId not between", value1, value2, "roleId");
            return (Criteria) this;
        }
       
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

}