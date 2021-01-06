package com.spring.function.ex05;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("localeController")
public class LocaleController {
	@RequestMapping(value="/test/locale.do", method=RequestMethod.GET)
	public String locale(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("Locale Controller");
		return "locale";	//only return view name
	}
}
