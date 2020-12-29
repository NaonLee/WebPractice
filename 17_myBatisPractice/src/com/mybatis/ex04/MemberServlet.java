package com.mybatis.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.ex01.MemberVO;


@WebServlet("/mem4.do")
public class MemberServlet extends HttpServlet {

    public MemberServlet() {
        // TODO Auto-generated constructor stub
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
		MemberDAO dao = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		String action = request.getParameter("action");
		String nextPage = "";
		
		if(action == null || action.equals("listMembers")) {
			List<MemberVO> membersList = dao.selectAllMemberList();
			request.setAttribute("membersList", membersList);
			nextPage = "test03/listMembers.jsp";
			
		} else if(action.equals("selectMemberById")) {
			String id = request.getParameter("value");
			memberVO = dao.selectMemberById(id);
			request.setAttribute("member", memberVO);
			nextPage = "test03/memberInfo.jsp";
			
		} else if(action.equals("selectMemberByPwd")) {
			String pwd = request.getParameter("value");
			List<MemberVO> membersList = dao.selectMemberByPwd(pwd);
			request.setAttribute("membersList", membersList);
			nextPage = "test03/listMembers.jsp";
			
		} else if(action.equals("insertMember")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			memberVO.setId(id);
			memberVO.setPwd(pwd);
			memberVO.setName(name);
			memberVO.setEmail(email);
			dao.insertMember(memberVO);
			nextPage = "/mem4.do?action=listMembers";
			
		} else if(action.equals("insertMember2")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			Map memberMap = new HashMap();
			memberMap.put("id", id);
			memberMap.put("pwd", pwd);
			memberMap.put("name", name);
			memberMap.put("email", email);
			dao.insertMember2(memberMap);
			nextPage = "/mem4.do?action=listMembers";
			
		} else if(action.equals("updateMember")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			memberVO.setId(id);
			memberVO.setPwd(pwd);
			memberVO.setName(name);
			memberVO.setEmail(email);
			dao.updateMember(memberVO);
			nextPage = "/mem4.do?action=listMembers";
			
		} else if(action.equals("deleteMember")) {
			String id = request.getParameter("id");
			
			dao.deleteMember(id);
			nextPage = "/mem4.do?action=listMembers";
			
		} else if(action.equals("searchMember")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			System.out.println(name);
			System.out.println(email);
			memberVO.setName(name);
			memberVO.setEmail(email);
			
			List<MemberVO> membersList = dao.searchMember(memberVO);
			request.setAttribute("membersList", membersList);
			nextPage = "test03/listMembers.jsp";
			
		} else if(action.equals("foreachSelect")) {
			List<String> nameList = new ArrayList();
			nameList.add("최유나");
			nameList.add("류진");
			nameList.add("여환웅");
			List<MemberVO> membersList = dao.foreachSelect(nameList);
			request.setAttribute("membersList", membersList);

			nextPage = "test03/listMembers.jsp";
			
		} else if(action.equals("foreachInsert")) {
			List<MemberVO> memList = new ArrayList();
			memList.add(new MemberVO("test1", "1234", "테스트1", "t1@g.com"));
			memList.add(new MemberVO("test2", "1234", "테스트2", "t2@g.com"));
			memList.add(new MemberVO("test3", "1234", "테스트3", "t3@g.com"));
			int result = dao.foreachInsert(memList);

			nextPage = "/mem4.do?action=listMembers";
		} 
		
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
		
	}
}
