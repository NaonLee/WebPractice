package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first/test")
public class TestServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=8");
		PrintWriter pt = response.getWriter();
		
		String context = request.getContextPath();
		String url = request.getRequestURL().toString();
		String mapping = request.getServletPath();
		String uri = request.getRequestURI();
		
		pt.print("<html><head><title>Test Servlet1</title></head>");
		pt.print("<body bgcolor='green'>");
		pt.print("<b>TestServlet1.</b><br>");
		pt.print("<b>Context name: " + context + "</b><br>");
		pt.print("<b>URL: " + url + "</b><br>");
		pt.print("<b>mapping name: " + mapping + "</b><br>");
		pt.print("<b>URI: " + uri + "<b>");
		pt.print("</body></html>");
		pt.close();

	}

}
