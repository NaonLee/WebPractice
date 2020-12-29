package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {
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
		String address = request.getParameter("user_address");
		
		System.out.println("ID: " + id);
		System.out.println("PW: " + pw);
		
		String data = "<html>";
		data+= "<body>";
		data+= "ID: " + id;
		data+= "<br>";
		data+= "PW: " + pw;
		data+= "<br>";
		data+= "ADDRESS: " +address;
		data+= "</body>";
		data+= "</html>";
		pt.print(data);
		
		}

}
