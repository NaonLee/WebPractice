package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//session binding practice
@WebServlet("/sess4")
public class SessionTest4 extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}

	public void destroy() {
		System.out.println("destroy()");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);

	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		if(session.isNew()) {
			if(id != null) {
				session.setAttribute("id", id);
				pt.println("<a href='sess4'>로그인 상태 확인</a>");
			}else {
				pt.println("<a href='login2.html'>다시 로그인해주세요</a>");
				session.invalidate();
			}
		}else {
			id = (String) session.getAttribute("id");
			if(id != null && id.length() != 0) { 
				pt.print("Hello " + id + "<br>");
			
			}else {
				pt.println("<a href='login2.html'>다시 로그인해주세요</a>");
				session.invalidate();
			}
		}
	}

}
