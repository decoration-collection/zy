package com.zy.web.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.zy.dao.model.ZYStyle;
import com.zy.service.admin.AdminStyleService;
import com.zy.service.admin.form.StyleForm;
import com.zy.util.ResultMap;

@Controller
@RequestMapping(value="/admin/style")
public class AdminStyleController {
	
	@Autowired
	private AdminStyleService adminStyleService;

	
	@RequestMapping(value="/add")
	public ModelAndView styleAdd(ModelMap modelMap) {
		modelMap.addAttribute("isEdit", false);
		ModelAndView view = new ModelAndView("/admin/style/add_style",modelMap);
		return view;
	}
	@RequestMapping(value="/all")
	public ModelAndView styleAll(ModelMap modelMap) {
		List<ZYStyle> list = adminStyleService.findAllStyle();
		List<StyleForm> result = new ArrayList<StyleForm>();
		for(ZYStyle zyStyle : list) {
			StyleForm form = new StyleForm();
			form.setStyle_id(zyStyle.getStyleId());
			form.setName(zyStyle.getType());
			form.setDesc(zyStyle.getDes());
			form.setImg_path(zyStyle.getImgPath());
			
			result.add(form);
		}
		
		modelMap.addAttribute("stylelist", result);
		ModelAndView view = new ModelAndView("/admin/style/all_style",modelMap);
		return view;
	}
	
	@RequestMapping(value="/edit")
	public ModelAndView styleEdit(String style_id,ModelMap modelMap) {
		ZYStyle zyStyle = adminStyleService.findStyleById(Integer.valueOf(style_id));
		StyleForm form = new StyleForm();
		form.setStyle_id(zyStyle.getStyleId());
		form.setName(zyStyle.getType());
		form.setDesc(zyStyle.getDes());
		form.setImg_path(zyStyle.getImgPath());
		
		modelMap.addAttribute("isEdit", true);
		modelMap.addAttribute("styleobj", form);
		ModelAndView view = new ModelAndView("/admin/style/add_style",modelMap);
		return view;
	}
	
	@ResponseBody
	@RequestMapping(value="/a_all")
	public Object findAllStyle() {
		try {
			List<ZYStyle> list = adminStyleService.findAllStyle();
			List<StyleForm> result = new ArrayList<StyleForm>();
			for(ZYStyle zyStyle : list) {
				StyleForm form = new StyleForm();
				form.setStyle_id(zyStyle.getStyleId());
				form.setName(zyStyle.getType());
				form.setDesc(zyStyle.getDes());
				form.setImg_path(zyStyle.getImgPath());
				
				result.add(form);
			}
			Map<String,String> dataMap = new HashMap<String,String>();
			dataMap.put("stylelist", new Gson().toJson(result));
			return ResultMap.buildMap(0, "success", dataMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/a_add",method=RequestMethod.POST)
	public Object styleAddPost(StyleForm form) {
		try {
			adminStyleService.addStyle(form);
			 return ResultMap.buildMap(0, "success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/a_edit",method=RequestMethod.POST)
	public Object styleEditPost(StyleForm form) {
		try {
			adminStyleService.editStyle(form);
			 return ResultMap.buildMap(0, "success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/del")
	public Object styleDel(String style_id) {
		try {
			adminStyleService.delStyleById(Integer.parseInt(style_id));
			 return ResultMap.buildMap(0, "success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
	}
	
}
