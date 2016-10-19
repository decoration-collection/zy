package com.zy.web.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.zy.service.admin.AdminImgService;
import com.zy.util.ResultMap;

@Controller
@RequestMapping(value="/admin")
public class AdminCommonController {

	@Autowired
	private AdminImgService adminImgService;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminDesignerController.class);

	
	@ResponseBody
	@RequestMapping(value="/single_del")
	public Object designerWorksDel(String rid,String img_path) {
		try {
			logger.info("/admin/single_del删除图片,designer_id：" + rid + ",path=" + img_path);
			adminImgService.delImgByCondition(Integer.parseInt(rid),img_path);
			List<String> imgs = adminImgService.findImgByReferenceId(Integer.parseInt(rid));
			Map<String,Object> dataMap = new HashMap<String,Object>();
			dataMap.put("imgs", imgs);
			return ResultMap.buildMap(0, "success", dataMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.buildMap(500, "fail", null);
		}
	}
	
}
