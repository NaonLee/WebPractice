package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookieValue
 */
@WebServlet("/get")
public class GetCookieValue extends HttpServlet {


	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}

	public void destroy() {
		System.out.println("destroy()");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		
		Cookie[] allValues = request.getCookies();
		for(int i = 0; i < allValues.length; i++) {
			if(allValues[i].getName().equals("cookieTest")) {
				pt.print("<h2>Bring cookie's value: " + URLDecoder.decode(allValues[i].getValue(), "utf-8"));
			}
		}
	}

}
