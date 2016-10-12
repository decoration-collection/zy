package com.zy.service.admin;

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
	
	public List<ZYStyle> findAllStyle() {
		ZYStyleExample exmaple = new ZYStyleExample();
		exmaple.setOrderByClause(" style_id asc");
		return styleMapper.selectByExample(exmaple);
	}
	
	public ZYStyle findStyleById(int styleId) {
		return styleMapper.selectByPrimaryKey(styleId);
	}
	
	public void delStyleById(int styleId) {
		styleMapper.deleteByPrimaryKey(styleId);
	}
	
}
