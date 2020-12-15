package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login2")
public class LoginTest2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		LoginImpl loginUser = new LoginImpl(id, pwd);
		
		if(session.isNew()) session.setAttribute("loginUser", loginUser);
		
		pt.println("<head>");
		pt.println("<script type='text/javascript'>");
		pt.println("setTimeout('history.go(0);', 5000");
		pt.println("</script>");
		pt.println("</head>");
		pt.println("<html><body>");
		pt.println("id: " + id + "<br>");
		pt.println("total user is : " + LoginImpl.total + "<br>");
		pt.println("</body></html>");
	}

}
