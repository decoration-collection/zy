package com.zy.dao.model;

import java.util.Date;

public class ZYImg {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zyzs_img.img_id
	 * @mbggenerated
	 */
	private Integer imgId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zyzs_img.reference_id
	 * @mbggenerated
	 */
	private Integer referenceId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zyzs_img.path
	 * @mbggenerated
	 */
	private String path;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zyzs_img.des
	 * @mbggenerated
	 */
	private String des;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zyzs_img.update_time
	 * @mbggenerated
	 */
	private Date updateTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zyzs_img.insert_time
	 * @mbggenerated
	 */
	private Date insertTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zyzs_img.img_id
	 * @return  the value of zyzs_img.img_id
	 * @mbggenerated
	 */
	public Integer getImgId() {
		return imgId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zyzs_img.img_id
	 * @param imgId  the value for zyzs_img.img_id
	 * @mbggenerated
	 */
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zyzs_img.reference_id
	 * @return  the value of zyzs_img.reference_id
	 * @mbggenerated
	 */
	public Integer getReferenceId() {
		return referenceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zyzs_img.reference_id
	 * @param referenceId  the value for zyzs_img.reference_id
	 * @mbggenerated
	 */
	public void setReferenceId(Integer referenceId) {
		this.referenceId = referenceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zyzs_img.path
	 * @return  the value of zyzs_img.path
	 * @mbggenerated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zyzs_img.path
	 * @param path  the value for zyzs_img.path
	 * @mbggenerated
	 */
	public void setPath(String path) {
		this.path = path == null ? null : path.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zyzs_img.des
	 * @return  the value of zyzs_img.des
	 * @mbggenerated
	 */
	public String getDes() {
		return des;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zyzs_img.des
	 * @param des  the value for zyzs_img.des
	 * @mbggenerated
	 */
	public void setDes(String des) {
		this.des = des == null ? null : des.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zyzs_img.update_time
	 * @return  the value of zyzs_img.update_time
	 * @mbggenerated
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zyzs_img.update_time
	 * @param updateTime  the value for zyzs_img.update_time
	 * @mbggenerated
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zyzs_img.insert_time
	 * @return  the value of zyzs_img.insert_time
	 * @mbggenerated
	 */
	public Date getInsertTime() {
		return insertTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zyzs_img.insert_time
	 * @param insertTime  the value for zyzs_img.insert_time
	 * @mbggenerated
	 */
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
}