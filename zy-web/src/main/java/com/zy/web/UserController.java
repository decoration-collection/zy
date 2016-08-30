package com.zy.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@ResponseBody
	@RequestMapping(value="index")
	public Object index() {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("code", "hello world");
		
		return map;
	}

	@RequestMapping(value="/admin")
	public ModelAndView index(ModelMap modelMap) {

		modelMap.put("xxx", "guage");
//		return "/admin/admin.html";

		ModelAndView view = new ModelAndView("admin/admin",modelMap);
		return view;
	}
	
}
