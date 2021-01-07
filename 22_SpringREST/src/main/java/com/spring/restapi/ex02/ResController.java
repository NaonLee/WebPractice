package com.spring.restapi.ex02;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResController {
	
	@RequestMapping(value = "/res1")
	@ResponseBody
	public Map<String, Object> res1(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "Lee");
		map.put("name", "Leedo");
		return map;
	}
	
	@RequestMapping(value="/res2")
	public ModelAndView res2() {
		return new ModelAndView("home");
	}
}
