package com.spring.function.ex05;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//For intercept, extends HandlerInterceptorAdapter or create HandlerInterceptor interface
public class LocaleInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		String locale = request.getParameter("locale");
		if(locale == null) locale = "en";					//if locale has no value, go to the default(korean)
		
		session.setAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE",new Locale(locale));
	      return true;
	}
	
	//After controller completed
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
	}
	//After View completed
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
	}
}
