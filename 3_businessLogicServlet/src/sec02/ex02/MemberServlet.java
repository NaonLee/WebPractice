package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member3")
public class MemberServlet extends HttpServlet {

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
		MemberDAO dao = new MemberDAO();
		String command = request.getParameter("command");
		
		if(command != null && command.equals("addMember")) {
			String _id = request.getParameter("id");
			String _pwd = request.getParameter("pwd");
			String _name = request.getParameter("name");
			String _email = request.getParameter("email");
			MemberVO vo = new MemberVO();
			vo.setId(_id);
			vo.setPwd(_pwd);
			vo.setName(_name);
			vo.setEmail(_email);
			dao.addMember(vo);
		}else if(command != null && command.equals("delMember")) {
			String id = request.getParameter("id");
			dao.delMember(id);
		}
		
		List<MemberVO> list = dao.listMembers();
		pt.print("<html><body>");
		pt.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		pt.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");
		
		for(int i = 0; i < list.size(); i++) {
			MemberVO memberVO = (MemberVO)list.get(i);
			pt.print("<tr><td>" + memberVO.getId() + "</td><td>" + memberVO.getPwd() + "</td><td>" + memberVO.getName() +
					"</td><td>" + memberVO.getEmail() + "</td><td>" + memberVO.getJoinDate() + "</td><td>" + 
					"<a href='/businessLogicServlet/member3?command=delMember&id=" + memberVO.getId() + "'>삭제</a></td></tr>");
		}
		pt.print("</table></body></html>");
		pt.print("<a href='/businessLogicServlet/memberForm.html'>새 회원 등록하기</a>");
	}

}
