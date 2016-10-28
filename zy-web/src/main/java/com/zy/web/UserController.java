package com.zy.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping(value="/admin")
	public ModelAndView admin(ModelMap modelMap) {

		ModelAndView view = new ModelAndView("admin/admin",modelMap);
		return view;
	}
	
	
	@RequestMapping(value="/about/index")
	public ModelAndView aboutIndex(ModelMap modelMap) {
		
		ModelAndView view = new ModelAndView("about/index",modelMap);
		return view;
	}


}
