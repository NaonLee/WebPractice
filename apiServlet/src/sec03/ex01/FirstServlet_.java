package sec03.ex01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//forward by dispatch
//서버에서 일어나기 때문에 url이 변경이 되지않아 클라이언트 측에서는 포워딩이 됐는지 알 수 없음
@WebServlet("/first-2")
public class FirstServlet_ extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		RequestDispatcher dispatch = request.getRequestDispatcher("second-2");
		dispatch.forward(request, response);
	}

}
