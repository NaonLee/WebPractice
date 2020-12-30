package com.spring.ex02;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {

	@RequestMapping(value={"/test/loginForm.do", "test/loginForm2.do"}, method = RequestMethod.GET)
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
	}
	
	@RequestMapping(value = "/test/login.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		mav.addObject("email", email);
		return mav;
	}
	//required 속성은 true가 default
	@RequestMapping(value="test/login2.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login2(@RequestParam(value="id", required=true) String id, @RequestParam("pwd") String pwd,
			@RequestParam(value="email", required=false) String email,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		/*RequestParam annotation 사용 시 따로 getParameter 필요 X
		 * String id = request.getParameter("id");
		 * String pwd = request.getParameter("pwd");
		 */
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		return mav;
	}
	/*
	@RequestMapping(value = "/test/login2.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login2(@RequestParam("userID") String userID, 
			                  @RequestParam("userName") String userName,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		
		// String userID = request.getParameter("userID");
		// String userName = request.getParameter("userName");
		
		System.out.println("userID: "+userID);
		System.out.println("userName: "+userName);
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		return mav;
	}
	*/
	
	//@RequestParam Map으로 값 받아오기
	@RequestMapping(value="test/login3.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login3(@RequestParam Map<String, String> info,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		String id = info.get("id");
		String pwd = info.get("pwd");

		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		return mav;
	}
	
	//@ModelAttribute를 이용해 VO로 값 받아오기
	@RequestMapping(value="test/login4.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login4(@ModelAttribute("info") LoginVO loginVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		String id = loginVO.getId();
		String pwd = loginVO.getPwd();

		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		return mav;
	}
}
