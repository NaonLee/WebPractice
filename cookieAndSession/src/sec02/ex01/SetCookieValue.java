package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Cookie practice
@WebServlet("/set")
public class SetCookieValue extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}

	public void destroy() {
		System.out.println("destroy()");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		Date d = new Date();
		Cookie c = new Cookie("cookieTest", URLEncoder.encode("servlet-cookie practice", "utf-8"));

		c.setMaxAge(24*60*60);		//if value is -1, it's 'Session cookie'
		response.addCookie(c);
		
		pt.print("Current time: " + d);
		pt.print("<br>Save string in Cookie");
	}

}
