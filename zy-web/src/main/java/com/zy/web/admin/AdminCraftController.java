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
import com.zy.dao.model.ZYImg;
import com.zy.service.admin.AdminCraftService;
import com.zy.service.admin.AdminImgService;
import com.zy.service.admin.form.CraftForm;
import com.zy.service.admin.form.ImgForm;
import com.zy.util.ResultMap;

@Controller
@RequestMapping(value="/admin/crafts")
public class AdminCraftController {
	
	@Autowired
	private AdminCraftService adminCraftService;
	
	@Autowired
	private AdminImgService adminImgService;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminCraftController.class);
	
	@RequestMapping(value="/add")
	public ModelAndView CraftAdd(ModelMap modelMap) {
		modelMap.addAttribute("isEdit", false);
		ModelAndView view = new ModelAndView("/admin/crafts/add_craft",modelMap);
		return view;
	}
	@RequestMapping(value="/all")
	public ModelAndView CraftAll(ModelMap modelMap) {
		List<CraftForm> result = adminCraftService.findAllCraft();
		modelMap.addAttribute("craftlist", result);
		logger.info("/admin/craft/all,modelMap=" + modelMap);
		ModelAndView view = new ModelAndView("/admin/crafts/all_crafts",modelMap);
		return view;
	}
	
	@RequestMapping(value="/edit")
	public ModelAndView styleEdit(String craft_id,ModelMap modelMap) {
		CraftForm form = adminCraftService.findCraftById(Integer.valueOf(craft_id));
		modelMap.addAttribute("isEdit", true);
		modelMap.addAttribute("craftobj", form);
		logger.info("/admin/craft/edit,modelMap=" + modelMap);
		ModelAndView view = new ModelAndView("/admin/crafts/add_craft",modelMap);
		return view;
	}
	
	@ResponseBody
	@RequestMapping(value="/a_all")
	public Object findAllCraft() {
		try {
			List<CraftForm> result = adminCraftService.findAllCraft();
			Map<String,Object> dataMap = new HashMap<String,Object>();
			dataMap.put("craftlist", new Gson().toJson(result));
			Map<String, Object> resultMap = ResultMap.buildMap(0, "success", dataMap);
			logger.info("/admin/craft/a_all,返回值" + resultMap);
			return resultMap;
		} catch (Exception e) {
			logger.error("ajax查询所有crafts失败",e);
			return ResultMap.buildMap(500, "fail", null);
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/a_add",method=RequestMethod.POST)
	public Object craftAddPost(CraftForm form) {
		try {
			logger.info("/admin/craft/a_add新增craft,参数：" + form);
			adminCraftService.addCraft(form);
			return ResultMap.buildMap(0, "success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/a_edit",method=RequestMethod.POST)
	public Object styleEditPost(CraftForm form) {
		try {
			logger.info("/admin/Crafts/a_edit更新Craft,参数：" + form);
			adminCraftService.editCraft(form);
			 return ResultMap.buildMap(0, "success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/del")
	public Object CraftDel(String craft_id) {
		try {
			logger.info("/admin/Crafts/del删除Craft,Craft_id：" + craft_id);
			adminCraftService.delCraftById(Integer.parseInt(craft_id));
			return ResultMap.buildMap(0, "success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value="/getImgObj")
	public Object getImg(String craft_id) {
		try {
			logger.info("/admin/getImgObj图片,craft_id=" + craft_id);

			
			List<String> imgs = adminImgService.findImgByReferenceId(Integer.parseInt(craft_id),"craft");
			List<ImgForm> imgList = adminImgService.findImgObjByReferenceId(Integer.parseInt(craft_id),"craft");
			Map<String,Object> dataMap = new HashMap<String,Object>();
			dataMap.put("imgs", imgs);
			dataMap.put("imglist", imgList);
			return ResultMap.buildMap(0, "success", dataMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
	}
	
}
