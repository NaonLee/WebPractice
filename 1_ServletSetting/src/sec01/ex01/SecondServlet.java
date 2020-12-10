package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Call doGet method >>>>");
	}

	@Override
	public void destroy() {
		System.out.println("Call destroy method >>>>");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Call init method >>>>");
	}
}
