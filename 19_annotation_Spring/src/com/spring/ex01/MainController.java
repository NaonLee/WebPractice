package com.spring.ex01;		//annotation 적용을 위해서는 <component-scan>으로 설정한 패키지 내부/하위에 있을것

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("mainController")	//빈 생성(id:mainController)
@RequestMapping("/test")		//URL 요청시 첫 단계가 /test일때 mainController 빈에 요청 전달
public class MainController {
	@RequestMapping(value="/main1.do", method = RequestMethod.GET)		//두번째 단계가 /main1.do 일 때 GET방식으로 main1 메소드 호출
	public ModelAndView main1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "main1");
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/main2.do", method = RequestMethod.GET) //두번째 단계가 /main2.do 일 때 GET방식으로 main2 메소드 호출
	public ModelAndView main2(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "main2");
		mav.setViewName("main");
		return mav;
	}
	
}
