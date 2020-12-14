package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		String data = "Hello!<br>You logged in!<br><br>";
				data += "<html><body>";
				data += "아이디: " + id +"<br>";
				data += "비밀번호: " + pwd +"<br>";
				data += "주소: " + address +"<br>";
				data += "이메일: " + email +"<br>";
				data += "전화번호: " + tel +"<br>";
				
		pt.print(data);
		
		address = URLEncoder.encode(address, "UTF-8");
		pt.print("<a href='/cookieAndSession/second?id=" + id + "&pwd=" + pwd + "&address=" + address + "&tel=" + tel + "'>send to second servlet</a>");
		
		data = "</body></html>";
		pt.print(data);
	}
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}

	public void destroy() {
		System.out.println("destroy()");
	}




}
