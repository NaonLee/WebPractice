package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//session invalidate() practice
@WebServlet("/sess3")
public class SessionTest3 extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}

	public void destroy() {
		System.out.println("destroy()");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		HttpSession session = request.getSession();
		
		pt.print("세션 아이디: " + session.getId() + "<br>");
		pt.print("세션 최초 생성 시각: " + new Date(session.getCreationTime()) + "<br>");
		pt.print("세션 최근 접근 시각: " + new Date(session.getLastAccessedTime()) + "<br>");
		pt.print("세션 유효 시간: " + session.getMaxInactiveInterval() + "<br>");
		if(session.isNew()) pt.print("새 세션 생성.");
		
		session.invalidate();
		
	}

}
