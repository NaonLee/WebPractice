package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second-4")
public class SecondServlet_ extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();

		String address = (String)request.getAttribute("address");
		pt.print("<html><body>");
		pt.print("address: " + address + "<br>");		//doesn't work, first에서 받아온 request와 현재 redirect된 request는 같은 객체x
		pt.print("redirect를 이용한 바인딩실습");				//Get방식 sendRedirect("second?name=lee") 는 보안문제
		pt.print("</body></html>");
	}

}
