package com.zy.service.admin.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CaseForm {

	private int case_id;

	private int style_id;

	private int designer_id;

	private String name;

	private String desc;

	private String build;

	private String aimgs;

	private StyleForm styleForm;

	private DesignerForm designerForm;

	private List<String> caseImgs = new ArrayList<String>();
	
	private String case_cover;

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

	public int getCase_id() {
		return case_id;
	}

	public void setCase_id(int case_id) {
		this.case_id = case_id;
	}

	public int getDesigner_id() {
		return designer_id;
	}

	public void setDesigner_id(int designer_id) {
		this.designer_id = designer_id;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public String getAimgs() {
		return aimgs;
	}

	public void setAimgs(String aimgs) {
		this.aimgs = aimgs;
	}

	public StyleForm getStyleForm() {
		return styleForm;
	}

	public void setStyleForm(StyleForm styleForm) {
		this.styleForm = styleForm;
	}

	public DesignerForm getDesignerForm() {
		return designerForm;
	}

	public void setDesignerForm(DesignerForm designerForm) {
		this.designerForm = designerForm;
	}

	public List<String> getCaseImgs() {
		return caseImgs;
	}

	public void setCaseImgs(List<String> caseImgs) {
		this.caseImgs = caseImgs;
	}

	public String getCase_cover() {
		return case_cover;
	}

	public void setCase_cover(String case_cover) {
		this.case_cover = case_cover;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
