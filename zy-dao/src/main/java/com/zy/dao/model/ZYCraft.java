package com.zy.dao.model;

import java.util.Date;

public class ZYCraft {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zyzs_craft.craft_id
	 * @mbggenerated
	 */
	private Integer craftId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zyzs_craft.name
	 * @mbggenerated
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zyzs_craft.des
	 * @mbggenerated
	 */
	private String des;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zyzs_craft.update_time
	 * @mbggenerated
	 */
	private Date updateTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zyzs_craft.insert_time
	 * @mbggenerated
	 */
	private Date insertTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zyzs_craft.craft_id
	 * @return  the value of zyzs_craft.craft_id
	 * @mbggenerated
	 */
	public Integer getCraftId() {
		return craftId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zyzs_craft.craft_id
	 * @param craftId  the value for zyzs_craft.craft_id
	 * @mbggenerated
	 */
	public void setCraftId(Integer craftId) {
		this.craftId = craftId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zyzs_craft.name
	 * @return  the value of zyzs_craft.name
	 * @mbggenerated
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zyzs_craft.name
	 * @param name  the value for zyzs_craft.name
	 * @mbggenerated
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zyzs_craft.des
	 * @return  the value of zyzs_craft.des
	 * @mbggenerated
	 */
	public String getDes() {
		return des;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zyzs_craft.des
	 * @param des  the value for zyzs_craft.des
	 * @mbggenerated
	 */
	public void setDes(String des) {
		this.des = des == null ? null : des.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zyzs_craft.update_time
	 * @return  the value of zyzs_craft.update_time
	 * @mbggenerated
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zyzs_craft.update_time
	 * @param updateTime  the value for zyzs_craft.update_time
	 * @mbggenerated
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zyzs_craft.insert_time
	 * @return  the value of zyzs_craft.insert_time
	 * @mbggenerated
	 */
	public Date getInsertTime() {
		return insertTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zyzs_craft.insert_time
	 * @param insertTime  the value for zyzs_craft.insert_time
	 * @mbggenerated
	 */
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
}