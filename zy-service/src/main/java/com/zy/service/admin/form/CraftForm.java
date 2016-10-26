package com.zy.service.admin.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CraftForm {

	private int craft_id;

	private String craft_name;

	private List<String> shows = new ArrayList<String>();
	
	private String craft_show ;
	
	private List<ImgForm> imgs = new ArrayList<ImgForm>();
	
	public int getCraft_id() {
		return craft_id;
	}

	public void setCraft_id(int craft_id) {
		this.craft_id = craft_id;
	}

	public String getCraft_name() {
		return craft_name;
	}

	public void setCraft_name(String craft_name) {
		this.craft_name = craft_name;
	}


	public List<String> getShows() {
		return shows;
	}

	public void setShows(List<String> shows) {
		this.shows = shows;
	}
	
	public String getCraft_show() {
		return craft_show;
	}

	public void setCraft_show(String craft_show) {
		this.craft_show = craft_show;
	}

	public List<ImgForm> getImgs() {
		return imgs;
	}

	public void setImgs(List<ImgForm> imgs) {
		this.imgs = imgs;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
