package com.zy.service.admin.form;

import java.util.ArrayList;
import java.util.List;

public class DesignerForm {

	private int designer_id;

	private String name;

	private String designer_img;

	private String working_time;

	private String design_concept;

	private String works;

	private String honor;

	private String works_show;
	
	private List<String> shows = new ArrayList<String>();

	public int getDesigner_id() {
		return designer_id;
	}

	public void setDesigner_id(int designer_id) {
		this.designer_id = designer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesigner_img() {
		return designer_img;
	}

	public void setDesigner_img(String designer_img) {
		this.designer_img = designer_img;
	}

	public String getWorking_time() {
		return working_time;
	}

	public void setWorking_time(String working_time) {
		this.working_time = working_time;
	}

	public String getDesign_concept() {
		return design_concept;
	}

	public void setDesign_concept(String design_concept) {
		this.design_concept = design_concept;
	}

	public String getWorks() {
		return works;
	}

	public void setWorks(String works) {
		this.works = works;
	}

	public String getHonor() {
		return honor;
	}

	public void setHonor(String honor) {
		this.honor = honor;
	}

	public String getWorks_show() {
		return works_show;
	}

	public void setWorks_show(String works_show) {
		this.works_show = works_show;
	}

	public List<String> getShows() {
		return shows;
	}

	public void setShows(List<String> shows) {
		this.shows = shows;
	}

}
