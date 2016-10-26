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
import com.zy.service.admin.AdminImgService;
import com.zy.service.admin.form.CraftForm;

@Controller
public class CraftController {
	
	@Autowired
	private AdminCraftService adminCraftService;
	
	@Autowired
	private AdminImgService adminImgService;
	
	private static final Logger logger = LoggerFactory.getLogger(CraftController.class);
	
	private Gson gson = new Gson();
	
	@RequestMapping(value="/craft/index")
	public ModelAndView craftIndex(String craft_id,ModelMap modelMap) {
		
		if(null == craft_id || "".equals(craft_id)) {
			List<CraftForm> result = adminCraftService.findAllCraft();
			modelMap.addAttribute("craftlist", gson.toJson(result));
		} else {
			CraftForm form = adminCraftService.findCraftById(Integer.parseInt(craft_id));
			modelMap.addAttribute("craftobj", gson.toJson(form));
		}
		logger.info("/admin/craft/all,modelMap=" + modelMap);
		ModelAndView view = new ModelAndView("craft/index",modelMap);
		return view;
	}
	
}
