package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//to understand the scope
@WebServlet("/get")
public class GetAttribute extends HttpServlet {


	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}

	public void destroy() {
		System.out.println("destroy()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		ServletContext context = this.getServletContext();
		HttpSession session = request.getSession();
		
		String ctxMsg = (String) context.getAttribute("context");
		String sesMsg = (String) session.getAttribute("session");
		String reqMsg = (String) request.getAttribute("request");
		
		pt.print("ctxMsg: " + ctxMsg + "<br>");
		pt.print("sesMsg: " + sesMsg + "<br>");
		pt.print("reqMsg: " + reqMsg + "<br>");
	}

}
