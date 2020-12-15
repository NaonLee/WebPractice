package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Filter practice
@WebServlet("/login")
public class LoginTest extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		//request.setCharacterEncoding("UTF-8");
		PrintWriter pt = response.getWriter();
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		pt.println("<html><body>");
		pt.println("이름은 " + name + "<br>");
		pt.println("비밀번호는 " + pwd + "<br>");
		pt.println("</body></html>");
	}

}
