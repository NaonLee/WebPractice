package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginTest2")
public class LoginTest2 extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Call init method");
	}

	public void destroy() {
		System.out.println("Call destroy method");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("ID: " + id);
		System.out.println("PW: " + pw);
		
		if(id != null && id.length() != 0) {
			if(id.equals("admin")) {

				pt.print("<html>");
				pt.print("<boby>");
				pt.print("<font size='12'> 관리자로 로그인</font>");
				pt.print("<br>");
				pt.print("<input type=button value='회원정보 수정하기'/>");
				pt.print("<input type=button value='회원정보 삭제하기'/>");
				pt.print("</body>");
				pt.print("</html>");
			}else {
				pt.print("<html>");
				pt.print("<boby>");
				pt.print(id + "으로 로그인 성공");
				pt.print("</body>");
				pt.print("</html>");
			}
		}else {
			pt.print("<html>");
			pt.print("<boby>");
			pt.print("ID 와 비밀번호를 입력하세요");
			pt.print("<br>");
			pt.print("<a href='http://localhost:8090/basicServlet/test01/login.html'>로그인페이지로 이동</a>");
			pt.print("</body>");
			pt.print("</html>");
		}

	}

}
