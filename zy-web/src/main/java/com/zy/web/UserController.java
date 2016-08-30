package com.zy.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@ResponseBody
	@RequestMapping(value="index")
	public Object index() {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("code", "hello world");
		
		return map;
	}
	
}
