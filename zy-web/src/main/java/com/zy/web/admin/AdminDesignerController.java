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
import com.zy.dao.mapper.ZYImgMapper;
import com.zy.dao.model.ZYImg;
import com.zy.service.admin.AdminDesignerService;
import com.zy.service.admin.AdminImgService;
import com.zy.service.admin.form.DesignerForm;
import com.zy.util.ResultMap;
import com.zy.web.LoginController;

@Controller
@RequestMapping(value="/admin/designers")
public class AdminDesignerController {
	
	@Autowired
	private AdminDesignerService adminDesignerService;
	
	@Autowired
	private AdminImgService adminImgService;
	
	@Autowired
	private ZYImgMapper imgMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminDesignerController.class);

	
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
		logger.info("/admin/designers/all,modelMap=" + modelMap);
		ModelAndView view = new ModelAndView("/admin/designers/all_designers",modelMap);
		return view;
	}
	
	@RequestMapping(value="/edit")
	public ModelAndView styleEdit(String designer_id,ModelMap modelMap) {
		DesignerForm form = adminDesignerService.findDesignerById(Integer.valueOf(designer_id));
		modelMap.addAttribute("isEdit", true);
		modelMap.addAttribute("designersobj", form);
		logger.info("/admin/designers/edit,modelMap=" + modelMap);
		ModelAndView view = new ModelAndView("/admin/designers/add_designer",modelMap);
		return view;
	}
	
	@ResponseBody
	@RequestMapping(value="/a_all")
	public Object findAllStyle() {
		try {
			List<DesignerForm> result = adminDesignerService.findAllDesigner();
			Map<String,Object> dataMap = new HashMap<String,Object>();
			dataMap.put("designerslist", new Gson().toJson(result));
			Map<String, Object> resultMap = ResultMap.buildMap(0, "success", dataMap);
			logger.info("/admin/designers/a_all,返回值" + resultMap);
			return resultMap;
		} catch (Exception e) {
			logger.error("ajax查询所有designers失败",e);
			return ResultMap.buildMap(500, "fail", null);
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/a_add",method=RequestMethod.POST)
	public Object styleAddPost(DesignerForm form) {
		try {
			logger.info("/admin/designers/a_all新增designer,参数：" + form);
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
			logger.info("/admin/designers/a_edit更新designer,参数：" + form);
			adminDesignerService.editDesigner(form);
			 return ResultMap.buildMap(0, "success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/del")
	public Object designerDel(String designer_id) {
		try {
			logger.info("/admin/designers/del删除designer,designer_id：" + designer_id);
			adminDesignerService.delDesignerById(Integer.parseInt(designer_id));
			return ResultMap.buildMap(0, "success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/del_works")
	public Object designerWorksDel(String designer_id,String works_path) {
		try {
			logger.info("/admin/designers/del_works删除作品,designer_id：" + designer_id + ",path=" + works_path);
			
			ZYImg img = adminImgService.findImgByCondition(Integer.parseInt(designer_id),works_path);
			if(null != img) {
				imgMapper.deleteByPrimaryKey(img.getImgId());
			} 
			
			List<String> works = adminImgService.findImgByReferenceId(Integer.parseInt(designer_id),img.getDes());
			Map<String,Object> dataMap = new HashMap<String,Object>();
			dataMap.put("works", new Gson().toJson(works));
			return ResultMap.buildMap(0, "success", dataMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
	}
	
}
