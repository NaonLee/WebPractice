package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Login with session
@WebServlet("/sesslog")
public class SessionLoginTest extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {

	}

	public void destroy() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		HttpSession session;
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId(id);
		memberVO.setPwd(pwd);
		
		MemberDAO dao = new MemberDAO();
		boolean result = dao.isExisted(memberVO);
		
		if(result) {
			session = request.getSession();
			session.setAttribute("isLogOn", true);
			session.setAttribute("login.id", id);
			session.setAttribute("login.pwd", pwd);
			
			pt.print("<html><body>");
			pt.print("Hello" + id + "<br>");
			pt.print("<a href = 'show'>User info</a>");
			pt.print("</body></html>");
		} else {
			pt.print("<html><body>");
			pt.print("<a href='login3.html'>Log in again </a>");
			pt.print("</body></html>");
		}
	}
}
