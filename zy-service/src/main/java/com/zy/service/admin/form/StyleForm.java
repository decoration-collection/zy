package com.zy.service.admin.form;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class StyleForm {

	private int style_id;
	
	private String name;
	
	private String desc;
	
	private String img_path;

	public int getStyle_id() {
		return style_id;
	}

	public void setStyle_id(int style_id) {
		this.style_id = style_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	
	
	@Override
	public String  toString() {
    	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    } 
	
}
