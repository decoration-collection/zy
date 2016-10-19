package com.zy.service.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.dao.mapper.ZYStyleMapper;
import com.zy.dao.model.ZYStyle;
import com.zy.dao.model.ZYStyleExample;
import com.zy.service.admin.form.StyleForm;

@Service
public class AdminStyleService {

	@Autowired
	private ZYStyleMapper styleMapper;
	
	public void addStyle(StyleForm form) {
		ZYStyle style = new ZYStyle();
//		style.setStyleId(styleId);
		style.setType(form.getName());
		style.setDes(form.getDesc());
		style.setImgPath(form.getImg_path());
		Date now = new Date();
		style.setInsertTime(now);
		style.setUpdateTime(now);
		
		styleMapper.insert(style);
	}
	
	public void editStyle(StyleForm form) {
		ZYStyle style = new ZYStyle();
		style.setStyleId(form.getStyle_id());
		style.setType(form.getName());
		style.setDes(form.getDesc());
		style.setImgPath(form.getImg_path());
		Date now = new Date();
		style.setUpdateTime(now);
		styleMapper.updateByPrimaryKey(style);
	}
	
	public List<StyleForm> findAllStyle() {
		ZYStyleExample exmaple = new ZYStyleExample();
		exmaple.setOrderByClause(" style_id asc");
		List<ZYStyle> list =  styleMapper.selectByExample(exmaple);
		
		List<StyleForm> result = new ArrayList<StyleForm>();
		for(ZYStyle zyStyle : list) {
			StyleForm form = new StyleForm();
			form.setStyle_id(zyStyle.getStyleId());
			form.setName(zyStyle.getType());
			form.setDesc(zyStyle.getDes());
			form.setImg_path(zyStyle.getImgPath());
			
			result.add(form);
		}
		return result;
	}
	
	public StyleForm findStyleById(int styleId) {
		ZYStyle zyStyle = styleMapper.selectByPrimaryKey(styleId);
		StyleForm form = new StyleForm();
		form.setStyle_id(zyStyle.getStyleId());
		form.setName(zyStyle.getType());
		form.setDesc(zyStyle.getDes());
		form.setImg_path(zyStyle.getImgPath());
		return form;
	}
	
	public void delStyleById(int styleId) {
		styleMapper.deleteByPrimaryKey(styleId);
	}
	
}
