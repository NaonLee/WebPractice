package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		
		List memberList = (List)request.getAttribute("memberList");
		
		pt.print("<html><body>");
		pt.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		pt.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");
		
		for(int i = 0; i < memberList.size(); i++) {
			MemberVO memberVo = (MemberVO)memberList.get(i);
			
			pt.print("<tr><td>" + memberVo.getId() + "</td><td>" + memberVo.getPwd() + "</td><td>" + memberVo.getName() +
					"</td><td>" + memberVo.getEmail() + "</td><td>" + memberVo.getJoinDate() + "</td><td>" + 
					"<a href='/apiServlet/member_1?command=delMember&id=" + memberVo.getId() + "'>삭제</a></td></tr>");
		}
		pt.print("</table></body></html>");
		pt.print("<a href='http://localhost:8090/businessLogicServlet/memberForm.html'> 새 회원 등록하기 </a>");

	}

}
