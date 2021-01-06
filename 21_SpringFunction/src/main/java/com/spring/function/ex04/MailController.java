package com.spring.function.ex04;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@EnableAsync
public class MailController {
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value="/sendMail.do", method=RequestMethod.GET)
	public void sendSimpleMain(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		StringBuffer sb = new StringBuffer();
		
		sb.append("<html><body>");
		sb.append("<mete http-equiv='Content-Type' content='text/html; charset=euc-kr'>");
		sb.append("<h1>Product introduce</h1><br>");
		sb.append("New books have been arrived! <br><br>");
		sb.append("<a href='#'>");
		sb.append("<img src='#'/></a><br>");
		sb.append("<a href='#'>Take a look </a>");
		sb.append("</body></html>");
		
		String str = sb.toString();
		
		mailService.sendMail("########@gmail.com", "New book", str);
		mailService.sendPreConfiguredMail("Test mail");
		pt.print("Sent email");
	}
}
