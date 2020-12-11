package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member2")
public class MemberServlet2 extends HttpServlet {


	public void init(ServletConfig config) throws ServletException {
		System.out.println("Call init method");
	}

	public void destroy() {
		System.out.println("Call destroy method");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.listMember();
		
		pt.print("<html><body>");
		pt.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		pt.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
		
		for (int i = 0; i < list.size(); i++) {
			MemberVO memberVO = list.get(i);
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			
			pt.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + 
			email + "</td><td>" + joinDate + "</td></tr>");
		}
		pt.print("</table></body></html>");
		
		
	}

}
