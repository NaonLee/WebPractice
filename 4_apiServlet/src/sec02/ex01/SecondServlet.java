package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second-1")
public class SecondServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		String name = request.getParameter("name");
		
		pt.print("<html><body>");
		pt.print("redirect by sendRedirect() <br>");
		pt.print("Name: " + name);
		pt.print("</body></html>");

	}

}
