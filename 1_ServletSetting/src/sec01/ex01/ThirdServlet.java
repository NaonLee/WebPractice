package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/third")
public class ThirdServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Call thirdServlet's init method");
	}

	public void destroy() {
		System.out.println("Call thirdServlet's destory method");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Call thirdServlet's doGet method");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Call thirdServlet's doPost method");
	}

}
