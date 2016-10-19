package com.zy.web.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.zy.service.admin.AdminCaseService;
import com.zy.service.admin.AdminDesignerService;
import com.zy.service.admin.AdminStyleService;
import com.zy.service.admin.form.CaseForm;
import com.zy.service.admin.form.DesignerForm;
import com.zy.service.admin.form.StyleForm;
import com.zy.util.ResultMap;

@Controller
@RequestMapping(value="/admin/case")
public class AdminCaseController {
	
	@Autowired
	private AdminCaseService caseService;

	@Autowired
	private AdminStyleService styleService;

	@Autowired
	private AdminDesignerService designerService;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminCaseController.class);

	@RequestMapping(value="/add")
	public ModelAndView addCase(ModelMap modelMap) {
		
		List<StyleForm> styleList = styleService.findAllStyle();
		List<DesignerForm> designerList = designerService.findAllDesigner();
		modelMap.addAttribute("isEdit", false);
		modelMap.addAttribute("stylelist", styleList);
		modelMap.addAttribute("designerlist", designerList);
		ModelAndView view = new ModelAndView("admin/case/add_case");
		return view;
	}
	
	@RequestMapping(value="/all")
	public ModelAndView allCase(ModelMap modelMap) {
		logger.info("/admin/case/all---start");
		List<CaseForm> caseList = caseService.findAllCase();
		modelMap.addAttribute("caselist", caseList);
		logger.info("/admin/case/all---end..result=" + caseList);
		ModelAndView view = new ModelAndView("admin/case/all_case");
		return view;
	}
	
	@RequestMapping(value="/edit")
	public ModelAndView caseEdit(String case_id,ModelMap modelMap) {
		logger.info("/admin/case/edit---start");
		CaseForm caseForm = caseService.findCaseById(Integer.parseInt(case_id));
		modelMap.addAttribute("isEdit", true);
		modelMap.addAttribute("caseobj", caseForm);
		List<StyleForm> styleList = styleService.findAllStyle();
		List<DesignerForm> designerList = designerService.findAllDesigner();
		modelMap.addAttribute("stylelist", styleList);
		modelMap.addAttribute("designerlist", designerList);
		logger.info("/admin/case/edit---end..result=" + caseForm);
		ModelAndView view = new ModelAndView("/admin/case/add_case",modelMap);
		return view;
	}
	
	@ResponseBody
	@RequestMapping(value="/a_all")
	public Object findAllcase() {
		try {
			logger.info("/admin/case/a_all---start");
			List<CaseForm> caseList = caseService.findAllCase();
			
			Map<String,Object> dataMap = new HashMap<String,Object>();
			dataMap.put("caselist", new Gson().toJson(caseList));
			
			logger.info("/admin/case/a_all---end..result=" + caseList);
			return ResultMap.buildMap(0, "success", dataMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/a_add",method=RequestMethod.POST)
	public Object caseAddPost(CaseForm form) {
		try {
			logger.info("/admin/case/a_add---start...form=" + form);
			caseService.addCase(form);
			 return ResultMap.buildMap(0, "success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/a_edit",method=RequestMethod.POST)
	public Object caseEditPost(CaseForm form) {
		try {
			logger.info("/admin/case/a_edit---start...form=" + form);
			caseService.editCase(form);
			 return ResultMap.buildMap(0, "success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/del")
	public Object caseDel(String case_id) {
		try {
			logger.info("/admin/case/del---start...case_id=" + case_id);
			caseService.delCaseById(Integer.parseInt(case_id));
			 return ResultMap.buildMap(0, "success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
	}
	
}
