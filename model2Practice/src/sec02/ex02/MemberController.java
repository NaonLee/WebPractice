package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO;

	public void init(ServletConfig config) throws ServletException {
		memberDAO = new MemberDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action:" + action);

		if(action == null || action.equals("/listMembers.do")) {
			List<MemberVO> membersList = memberDAO.listmembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test03/listMembers.jsp";
			
		} else if(action.equals("/addMember.do")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO member =  new MemberVO(id, pwd, name, email);
			memberDAO.addmember(member);
			request.setAttribute("msg", "addMember");
			nextPage = "/member/listMembers.do";
			
		} else if(action.equals("/memberForm.do")) {
			nextPage="/test03/memberForm.jsp";
			
		} else if(action.equals("/modMemberForm.do")){
			String id = request.getParameter("id");
			MemberVO memberInfo = memberDAO.findmember(id);
			request.setAttribute("memberInfo", memberInfo);
			nextPage="/test03/modMemberForm.jsp";
			
		} else if(action.equals("/modMember.do")){
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			MemberVO member = new MemberVO(id, pwd, name, email);
			memberDAO.modmember(member);
			request.setAttribute("msg", "modified");
			nextPage="/member/listMembers.do";
			
		} else if(action.equals("/delMember.do")) {
			String id = request.getParameter("id");
			memberDAO.delmember(id);
			request.setAttribute("msg", "deleted");
			nextPage = "/member/listMembers.do";
			
		} else {
		
		
			List<MemberVO> membersList = memberDAO.listmembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test03/listMembers.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}
