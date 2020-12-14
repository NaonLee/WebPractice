package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/show")
public class ShowMember extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.print("init()");
	}

	public void destroy() {
		System.out.print("destroy()");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		
		HttpSession session = request.getSession(false);
		Boolean isLogon = false;
		String id, pwd;
		System.out.println(session.getAttribute("isLogOn"));
		if( session != null) {
			
			isLogon = (Boolean)session.getAttribute("isLogOn");
			if(isLogon == true) {
				id = (String)session.getAttribute("login.id");
				pwd = (String)session.getAttribute("login.pwd");
				
				pt.print("<html><body>");
				pt.print("Id: " + id + "<br>");
				pt.print("Pwd: " + pwd);
				pt.print("</body></html>");
			}else {
				response.sendRedirect("login3.html");
			}
		} else {
			response.sendRedirect("login3.html");
		}
	}
}
