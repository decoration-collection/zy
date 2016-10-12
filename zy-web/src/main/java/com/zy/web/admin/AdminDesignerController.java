package com.zy.web.admin;

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
import com.zy.service.admin.AdminDesignerService;
import com.zy.service.admin.AdminImgService;
import com.zy.service.admin.form.DesignerForm;
import com.zy.util.ResultMap;

@Controller
@RequestMapping(value="/admin/designers")
public class AdminDesignerController {
	
	@Autowired
	private AdminDesignerService adminDesignerService;
	
	@Autowired
	private AdminImgService adminImgService;
	
	@RequestMapping(value="/add")
	public ModelAndView designerAdd(ModelMap modelMap) {
		modelMap.addAttribute("isEdit", false);
		ModelAndView view = new ModelAndView("/admin/designers/add_designer",modelMap);
		return view;
	}
	@RequestMapping(value="/all")
	public ModelAndView designerAll(ModelMap modelMap) {
		List<DesignerForm> result = adminDesignerService.findAllDesigner();
		modelMap.addAttribute("designerslist", result);
		ModelAndView view = new ModelAndView("/admin/designers/all_designers",modelMap);
		return view;
	}
	
	@RequestMapping(value="/edit")
	public ModelAndView styleEdit(String designer_id,ModelMap modelMap) {
		modelMap.addAttribute("isEdit", true);
		modelMap.addAttribute("designersobj", adminDesignerService.findDesignerById(Integer.valueOf(designer_id)));
		ModelAndView view = new ModelAndView("/admin/designers/add_designer",modelMap);
		return view;
	}
	
	@ResponseBody
	@RequestMapping(value="/a_all")
	public Object findAllStyle() {
		try {
			List<DesignerForm> result = adminDesignerService.findAllDesigner();
			Map<String,String> dataMap = new HashMap<String,String>();
			dataMap.put("designerslist", new Gson().toJson(result));
			return ResultMap.buildMap(0, "success", dataMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/a_add",method=RequestMethod.POST)
	public Object styleAddPost(DesignerForm form) {
		try {
			adminDesignerService.addDesigner(form);
			 return ResultMap.buildMap(0, "success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/a_edit",method=RequestMethod.POST)
	public Object styleEditPost(DesignerForm form) {
		try {
			adminDesignerService.editDesigner(form);
			 return ResultMap.buildMap(0, "success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/del")
	public Object styleDel(String designer_id) {
		try {
			adminDesignerService.delDesignerById(Integer.parseInt(designer_id));
			 return ResultMap.buildMap(0, "success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
	}
	
}
