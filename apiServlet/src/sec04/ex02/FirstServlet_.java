package sec04.ex02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//dispatch forward binding
@WebServlet("/first-5")
public class FirstServlet_ extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		request.setAttribute("address", "수원시 영통구");

		RequestDispatcher dispatch = request.getRequestDispatcher("second-5");
		dispatch.forward(request, response);
	}

}
