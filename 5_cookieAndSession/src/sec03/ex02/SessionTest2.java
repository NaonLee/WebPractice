package sec03.ex02;

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

//Session practice (use of setMaxInactiveInterval)
@WebServlet("/sess2")
public class SessionTest2 extends HttpServlet {

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
		pt.print("최초 세션 생성 시각 " + new Date(session.getCreationTime()) + "<br>");
		pt.print("세션 최근 접근 시각: " + new Date(session.getLastAccessedTime()) + "<br>");
		
		pt.print("기본 세션 유효 시간: " + session.getMaxInactiveInterval() + "<br>");
		
		session.setMaxInactiveInterval(5);
		pt.print("세션 유효 시간: " + session.getMaxInactiveInterval() + "<br>");
		
		if(session.isNew())
			pt.print("새 세션 생성");
		
	}

}
