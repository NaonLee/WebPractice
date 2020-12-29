package sec03.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second-3")
public class SecondServlet_ extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		
		pt.print("<html><body>");
		pt.print("dispatch를 이용한 data forward 실습<br>");
		pt.print("name: " + request.getParameter("name"));
		pt.print("</body></html>");
	}

}
