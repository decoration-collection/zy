package com.zy.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ZYImgExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table zyzs_img
	 * @mbggenerated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table zyzs_img
	 * @mbggenerated
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table zyzs_img
	 * @mbggenerated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zyzs_img
	 * @mbggenerated
	 */
	public ZYImgExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zyzs_img
	 * @mbggenerated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zyzs_img
	 * @mbggenerated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zyzs_img
	 * @mbggenerated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zyzs_img
	 * @mbggenerated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zyzs_img
	 * @mbggenerated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zyzs_img
	 * @mbggenerated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zyzs_img
	 * @mbggenerated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zyzs_img
	 * @mbggenerated
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zyzs_img
	 * @mbggenerated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zyzs_img
	 * @mbggenerated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table zyzs_img
	 * @mbggenerated
	 */
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCDate(String condition, Date value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()),
					property);
		}

		protected void addCriterionForJDBCDate(String condition,
				List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1,
				Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()),
					new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andImgIdIsNull() {
			addCriterion("img_id is null");
			return (Criteria) this;
		}

		public Criteria andImgIdIsNotNull() {
			addCriterion("img_id is not null");
			return (Criteria) this;
		}

		public Criteria andImgIdEqualTo(Integer value) {
			addCriterion("img_id =", value, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdNotEqualTo(Integer value) {
			addCriterion("img_id <>", value, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdGreaterThan(Integer value) {
			addCriterion("img_id >", value, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("img_id >=", value, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdLessThan(Integer value) {
			addCriterion("img_id <", value, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdLessThanOrEqualTo(Integer value) {
			addCriterion("img_id <=", value, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdIn(List<Integer> values) {
			addCriterion("img_id in", values, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdNotIn(List<Integer> values) {
			addCriterion("img_id not in", values, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdBetween(Integer value1, Integer value2) {
			addCriterion("img_id between", value1, value2, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdNotBetween(Integer value1, Integer value2) {
			addCriterion("img_id not between", value1, value2, "imgId");
			return (Criteria) this;
		}

		public Criteria andReferenceIdIsNull() {
			addCriterion("reference_id is null");
			return (Criteria) this;
		}

		public Criteria andReferenceIdIsNotNull() {
			addCriterion("reference_id is not null");
			return (Criteria) this;
		}

		public Criteria andReferenceIdEqualTo(Integer value) {
			addCriterion("reference_id =", value, "referenceId");
			return (Criteria) this;
		}

		public Criteria andReferenceIdNotEqualTo(Integer value) {
			addCriterion("reference_id <>", value, "referenceId");
			return (Criteria) this;
		}

		public Criteria andReferenceIdGreaterThan(Integer value) {
			addCriterion("reference_id >", value, "referenceId");
			return (Criteria) this;
		}

		public Criteria andReferenceIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("reference_id >=", value, "referenceId");
			return (Criteria) this;
		}

		public Criteria andReferenceIdLessThan(Integer value) {
			addCriterion("reference_id <", value, "referenceId");
			return (Criteria) this;
		}

		public Criteria andReferenceIdLessThanOrEqualTo(Integer value) {
			addCriterion("reference_id <=", value, "referenceId");
			return (Criteria) this;
		}

		public Criteria andReferenceIdIn(List<Integer> values) {
			addCriterion("reference_id in", values, "referenceId");
			return (Criteria) this;
		}

		public Criteria andReferenceIdNotIn(List<Integer> values) {
			addCriterion("reference_id not in", values, "referenceId");
			return (Criteria) this;
		}

		public Criteria andReferenceIdBetween(Integer value1, Integer value2) {
			addCriterion("reference_id between", value1, value2, "referenceId");
			return (Criteria) this;
		}

		public Criteria andReferenceIdNotBetween(Integer value1, Integer value2) {
			addCriterion("reference_id not between", value1, value2,
					"referenceId");
			return (Criteria) this;
		}

		public Criteria andPathIsNull() {
			addCriterion("path is null");
			return (Criteria) this;
		}

		public Criteria andPathIsNotNull() {
			addCriterion("path is not null");
			return (Criteria) this;
		}

		public Criteria andPathEqualTo(String value) {
			addCriterion("path =", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotEqualTo(String value) {
			addCriterion("path <>", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathGreaterThan(String value) {
			addCriterion("path >", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathGreaterThanOrEqualTo(String value) {
			addCriterion("path >=", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathLessThan(String value) {
			addCriterion("path <", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathLessThanOrEqualTo(String value) {
			addCriterion("path <=", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathLike(String value) {
			addCriterion("path like", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotLike(String value) {
			addCriterion("path not like", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathIn(List<String> values) {
			addCriterion("path in", values, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotIn(List<String> values) {
			addCriterion("path not in", values, "path");
			return (Criteria) this;
		}

		public Criteria andPathBetween(String value1, String value2) {
			addCriterion("path between", value1, value2, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotBetween(String value1, String value2) {
			addCriterion("path not between", value1, value2, "path");
			return (Criteria) this;
		}

		public Criteria andHeightIsNull() {
			addCriterion("height is null");
			return (Criteria) this;
		}

		public Criteria andHeightIsNotNull() {
			addCriterion("height is not null");
			return (Criteria) this;
		}

		public Criteria andHeightEqualTo(Integer value) {
			addCriterion("height =", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightNotEqualTo(Integer value) {
			addCriterion("height <>", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightGreaterThan(Integer value) {
			addCriterion("height >", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightGreaterThanOrEqualTo(Integer value) {
			addCriterion("height >=", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightLessThan(Integer value) {
			addCriterion("height <", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightLessThanOrEqualTo(Integer value) {
			addCriterion("height <=", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightIn(List<Integer> values) {
			addCriterion("height in", values, "height");
			return (Criteria) this;
		}

		public Criteria andHeightNotIn(List<Integer> values) {
			addCriterion("height not in", values, "height");
			return (Criteria) this;
		}

		public Criteria andHeightBetween(Integer value1, Integer value2) {
			addCriterion("height between", value1, value2, "height");
			return (Criteria) this;
		}

		public Criteria andHeightNotBetween(Integer value1, Integer value2) {
			addCriterion("height not between", value1, value2, "height");
			return (Criteria) this;
		}

		public Criteria andWidthIsNull() {
			addCriterion("width is null");
			return (Criteria) this;
		}

		public Criteria andWidthIsNotNull() {
			addCriterion("width is not null");
			return (Criteria) this;
		}

		public Criteria andWidthEqualTo(Integer value) {
			addCriterion("width =", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthNotEqualTo(Integer value) {
			addCriterion("width <>", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthGreaterThan(Integer value) {
			addCriterion("width >", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthGreaterThanOrEqualTo(Integer value) {
			addCriterion("width >=", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthLessThan(Integer value) {
			addCriterion("width <", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthLessThanOrEqualTo(Integer value) {
			addCriterion("width <=", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthIn(List<Integer> values) {
			addCriterion("width in", values, "width");
			return (Criteria) this;
		}

		public Criteria andWidthNotIn(List<Integer> values) {
			addCriterion("width not in", values, "width");
			return (Criteria) this;
		}

		public Criteria andWidthBetween(Integer value1, Integer value2) {
			addCriterion("width between", value1, value2, "width");
			return (Criteria) this;
		}

		public Criteria andWidthNotBetween(Integer value1, Integer value2) {
			addCriterion("width not between", value1, value2, "width");
			return (Criteria) this;
		}

		public Criteria andDesIsNull() {
			addCriterion("des is null");
			return (Criteria) this;
		}

		public Criteria andDesIsNotNull() {
			addCriterion("des is not null");
			return (Criteria) this;
		}

		public Criteria andDesEqualTo(String value) {
			addCriterion("des =", value, "des");
			return (Criteria) this;
		}

		public Criteria andDesNotEqualTo(String value) {
			addCriterion("des <>", value, "des");
			return (Criteria) this;
		}

		public Criteria andDesGreaterThan(String value) {
			addCriterion("des >", value, "des");
			return (Criteria) this;
		}

		public Criteria andDesGreaterThanOrEqualTo(String value) {
			addCriterion("des >=", value, "des");
			return (Criteria) this;
		}

		public Criteria andDesLessThan(String value) {
			addCriterion("des <", value, "des");
			return (Criteria) this;
		}

		public Criteria andDesLessThanOrEqualTo(String value) {
			addCriterion("des <=", value, "des");
			return (Criteria) this;
		}

		public Criteria andDesLike(String value) {
			addCriterion("des like", value, "des");
			return (Criteria) this;
		}

		public Criteria andDesNotLike(String value) {
			addCriterion("des not like", value, "des");
			return (Criteria) this;
		}

		public Criteria andDesIn(List<String> values) {
			addCriterion("des in", values, "des");
			return (Criteria) this;
		}

		public Criteria andDesNotIn(List<String> values) {
			addCriterion("des not in", values, "des");
			return (Criteria) this;
		}

		public Criteria andDesBetween(String value1, String value2) {
			addCriterion("des between", value1, value2, "des");
			return (Criteria) this;
		}

		public Criteria andDesNotBetween(String value1, String value2) {
			addCriterion("des not between", value1, value2, "des");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("update_time is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("update_time is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterionForJDBCDate("update_time =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("update_time <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("update_time >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("update_time >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterionForJDBCDate("update_time <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("update_time <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterionForJDBCDate("update_time in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("update_time not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("update_time between", value1, value2,
					"updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("update_time not between", value1, value2,
					"updateTime");
			return (Criteria) this;
		}

		public Criteria andInsertTimeIsNull() {
			addCriterion("insert_time is null");
			return (Criteria) this;
		}

		public Criteria andInsertTimeIsNotNull() {
			addCriterion("insert_time is not null");
			return (Criteria) this;
		}

		public Criteria andInsertTimeEqualTo(Date value) {
			addCriterionForJDBCDate("insert_time =", value, "insertTime");
			return (Criteria) this;
		}

		public Criteria andInsertTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("insert_time <>", value, "insertTime");
			return (Criteria) this;
		}

		public Criteria andInsertTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("insert_time >", value, "insertTime");
			return (Criteria) this;
		}

		public Criteria andInsertTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("insert_time >=", value, "insertTime");
			return (Criteria) this;
		}

		public Criteria andInsertTimeLessThan(Date value) {
			addCriterionForJDBCDate("insert_time <", value, "insertTime");
			return (Criteria) this;
		}

		public Criteria andInsertTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("insert_time <=", value, "insertTime");
			return (Criteria) this;
		}

		public Criteria andInsertTimeIn(List<Date> values) {
			addCriterionForJDBCDate("insert_time in", values, "insertTime");
			return (Criteria) this;
		}

		public Criteria andInsertTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("insert_time not in", values, "insertTime");
			return (Criteria) this;
		}

		public Criteria andInsertTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("insert_time between", value1, value2,
					"insertTime");
			return (Criteria) this;
		}

		public Criteria andInsertTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("insert_time not between", value1, value2,
					"insertTime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table zyzs_img
	 * @mbggenerated
	 */
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table zyzs_img
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}