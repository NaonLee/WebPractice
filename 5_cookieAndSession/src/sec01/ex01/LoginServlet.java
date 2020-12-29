package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//hidden tag practice
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		String data = "Hello!<br> you logged in!<br><br>";
				data += "<html><body>";
				data += "아이디: " + id + "<br>";
				data += "비밀번호: " + pwd + "<br>";
				data += "주소: " + address + "<br>";
				data += "이메일: " + email + "<br>";
				data += "전화번호: " + tel + "<br>";
				data += "</body></html>";
				
		pt.print(data);
				
	}

}
