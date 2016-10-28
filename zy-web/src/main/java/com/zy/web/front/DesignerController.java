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
import com.zy.service.admin.form.CraftForm;
import com.zy.service.admin.form.DesignerForm;

@Controller
public class DesignerController {
	
	@Autowired
	private AdminDesignerService adminDesignerService;
	
	private static final Logger logger = LoggerFactory.getLogger(DesignerController.class);
	
	private Gson gson = new Gson();
	
	@RequestMapping(value="/team/index")
	public ModelAndView craftIndex(ModelMap modelMap) {
		
		List<DesignerForm> result = adminDesignerService.findAllDesigner();
		modelMap.addAttribute("designerslist", result);

		logger.info("/admin/craft/all,modelMap=" + modelMap);
		ModelAndView view = new ModelAndView("team/index",modelMap);
		return view;
	}
	
}
