package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}

	public void destroy() {
		System.out.println("destroy()");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		
		pt.print("<hitml><body>");
		if(id != null && id.length() != 0) {
			pt.print("You have already logged in!<br>");
			pt.print("ID from first servlet: " + id + "<br>");
			pt.print("Password from first servlet: " + pwd + "<br>");
			pt.print("Address from first servlet: " + address + "<br>");
			pt.print("Tel from first servlet: " + tel + "<br>");
			pt.print("</body></html>");
		}else {
			pt.print("You haven't logged in. <br>");
			pt.print("Please login<br><br>");
			pt.print("<a href='/cookieAndSession/login.html'>Login</a>");
			pt.print("</body></html>");
		}
	}

}
