package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginTest")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		System.out.println("Call init method");
	}

	public void destroy() {
		System.out.println("Call destroy method");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("ID: " + id);
		System.out.println("PW: " + pw);
		
		if(id != null && (id.length() != 0)) {
			pt.print("<html>");
			pt.print("<body>");
			pt.print(id + ", sucesscully loged in");
			pt.print("</body>");
			pt.print("</html>");
		}else {
			pt.print("<html>");
			pt.print("<body>");
			pt.print("You should put an id");
			pt.print("<br>");
			pt.print("<a href='http://localhost:8090/pro06/test01/login.html'> 로그인창으로 이동 </a>");
			pt.print("</body>");
			pt.print("</html>");
		}
	}

}
