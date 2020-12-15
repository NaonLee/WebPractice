package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginTest3
 */
@WebServlet("/login3")
public class LoginTest3 extends HttpServlet {

	ServletContext context = null;
	List user_list = new ArrayList();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		HttpSession session = request.getSession();
		context = this.getServletContext();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		LoginImpl loginUser = new LoginImpl(id, pwd);
		
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
			user_list.add(id);
			context.setAttribute("user_list", user_list);
		}
		
		pt.println("<html><body>");
		pt.println("id: " + loginUser.id + "<br>");
		pt.println("total user is : " + LoginImpl.total + "<br>");
		pt.println("Current login id: <br>");
		List list = (ArrayList)context.getAttribute("user_list");
		for(int i = 0; i < list.size(); i++) {
			pt.println(list.get(i) + "<br>");
		}
		pt.println("<a href='logout?id=" + id + "'>log out</a>");
		pt.println("</body></html>");
	}

}
