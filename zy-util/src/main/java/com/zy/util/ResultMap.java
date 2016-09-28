package com.zy.util;

import java.util.HashMap;
import java.util.Map;

public class ResultMap {

	public static Map<String,Object> buildMap(int code,String msg,String data) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		if(null != data && !"".equals(data)) {
			resultMap.put("data", data);
		}
		return resultMap;
	}
	
}
