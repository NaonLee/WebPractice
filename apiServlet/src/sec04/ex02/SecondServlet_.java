package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second-5")
public class SecondServlet_ extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();

		String address = (String)request.getAttribute("address");
		pt.print("<html><body>");
		pt.print("address: " + address + "<br>");		//웹브라우저를 통하지 않았기 때문에 requset 객체는 같음
		pt.print("dispatch를 이용한 바인딩실습");				
		pt.print("</body></html>");
	}

}
