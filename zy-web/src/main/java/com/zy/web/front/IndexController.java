package com.zy.web.front;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.zy.service.admin.AdminCraftService;
import com.zy.service.admin.AdminDesignerService;
import com.zy.service.admin.AdminImgService;
import com.zy.service.admin.AdminStyleService;
import com.zy.service.admin.form.CraftForm;
import com.zy.service.admin.form.DesignerForm;
import com.zy.service.admin.form.StyleForm;

@Controller
public class IndexController {
	
	@Autowired
	private AdminStyleService adminStyleService;

	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	private Gson gson = new Gson();
	
	@RequestMapping(value="/index")
	public ModelAndView craftIndex(ModelMap modelMap) {
		
		List<StyleForm> list = adminStyleService.findAllStyle();
		modelMap.addAttribute("stylelist", list);

		logger.info("/index,modelMap=" + modelMap);
		ModelAndView view = new ModelAndView("index/index",modelMap);
		return view;
	}
	
}
