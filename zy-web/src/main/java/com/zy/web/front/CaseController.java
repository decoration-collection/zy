package com.zy.web.front;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zy.service.admin.AdminCaseService;
import com.zy.service.admin.AdminStyleService;
import com.zy.service.admin.form.CaseForm;
import com.zy.service.admin.form.StyleForm;

@Controller
public class CaseController {
	
	@Autowired
	private AdminCaseService caseService;

	@Autowired
	private AdminStyleService styleService;
	
	private static final Logger logger = LoggerFactory.getLogger(CaseController.class);

	
	@RequestMapping(value="/case/index")
	public ModelAndView craftIndex(String style_id,ModelMap modelMap) {
		
		logger.info("/case/index---start,style_id=" + style_id);
		List<CaseForm> caseList = null;
		if(null == style_id || "".equals(style_id)) {
			caseList = caseService.findAllCase();
		} else {
			caseList = caseService.findCaseByStyleId(Integer.parseInt(style_id));
		}
		modelMap.addAttribute("caselist", caseList);
		
		List<StyleForm> styleList =  styleService.findAllStyle();
		modelMap.addAttribute("stylelist", styleList);
		logger.info("/case/index---end..result=" + caseList);

		ModelAndView view = new ModelAndView("case/index",modelMap);
		return view;
	}
	

}
