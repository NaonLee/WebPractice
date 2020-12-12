package sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//ServletConfig Practice
@WebServlet(
		urlPatterns = { 
				"/sInit", 
				"/sInit2"
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "admin@web.com"), 
				@WebInitParam(name = "tel", value = "010-0000-0000")
		})
public class InitParamServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		
		String email = this.getInitParameter("email");
		String tel = this.getInitParameter("tel");
		pt.print("<html><body>");
		pt.print("<table>");
		pt.print("<tr><td>Email: </td><td>" + email + "</td></tr>");
		pt.print("<tr><td>Tel: </td><td>" + tel + "</td></tr>");
		pt.print("</table></body></html>");
	}

}
