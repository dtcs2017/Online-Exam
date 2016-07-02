package com.bs.lsx.util.page;

import java.util.HashMap;
import java.util.Map;

/**
 * 页面提示map
 * @date 2014-08-05
 */
public class PageTips {
	
	/**
	 * 返回成功提示
	 * @return
	 */
	public static final Map<String, Object> getMapSuccess(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 200);
		map.put("success", true);
		map.put("message", "保存成功");
		return map;
	}
	
	/**
	 * 返回失败提示
	 * @return
	 */
	public static final Map<String, Object> getMapFailure(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", false);
		map.put("statusCode", 300);
		map.put("message", "保存失败");
		return map;
	}
}
