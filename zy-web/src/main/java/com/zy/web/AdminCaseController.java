package com.zy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/admin/case")
public class AdminCaseController {

	@RequestMapping(value="/add")
	public ModelAndView addCase() {

		ModelAndView view = new ModelAndView("admin/case/add_case");
		return view;
	}
	
	@RequestMapping(value="/all")
	public ModelAndView allCase() {

		ModelAndView view = new ModelAndView("admin/case/all_case");
		return view;
	}
	
}
