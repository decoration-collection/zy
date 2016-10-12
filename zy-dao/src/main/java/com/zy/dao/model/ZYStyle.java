package com.zy.dao.model;

import java.util.Date;

public class ZYStyle {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zyzs_style.style_id
     *
     * @mbggenerated
     */
    private Integer styleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zyzs_style.type
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zyzs_style.des
     *
     * @mbggenerated
     */
    private String des;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zyzs_style.img_path
     *
     * @mbggenerated
     */
    private String imgPath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zyzs_style.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zyzs_style.insert_time
     *
     * @mbggenerated
     */
    private Date insertTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zyzs_style.style_id
     *
     * @return the value of zyzs_style.style_id
     *
     * @mbggenerated
     */
    public Integer getStyleId() {
        return styleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zyzs_style.style_id
     *
     * @param styleId the value for zyzs_style.style_id
     *
     * @mbggenerated
     */
    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zyzs_style.type
     *
     * @return the value of zyzs_style.type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zyzs_style.type
     *
     * @param type the value for zyzs_style.type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zyzs_style.des
     *
     * @return the value of zyzs_style.des
     *
     * @mbggenerated
     */
    public String getDes() {
        return des;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zyzs_style.des
     *
     * @param des the value for zyzs_style.des
     *
     * @mbggenerated
     */
    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zyzs_style.img_path
     *
     * @return the value of zyzs_style.img_path
     *
     * @mbggenerated
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zyzs_style.img_path
     *
     * @param imgPath the value for zyzs_style.img_path
     *
     * @mbggenerated
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zyzs_style.update_time
     *
     * @return the value of zyzs_style.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zyzs_style.update_time
     *
     * @param updateTime the value for zyzs_style.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zyzs_style.insert_time
     *
     * @return the value of zyzs_style.insert_time
     *
     * @mbggenerated
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zyzs_style.insert_time
     *
     * @param insertTime the value for zyzs_style.insert_time
     *
     * @mbggenerated
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}