package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/guguTest2")
public class GuguTest2 extends HttpServlet {


	public void init(ServletConfig config) throws ServletException {
		System.out.println("Call init method");
	}

	public void destroy() {
		System.out.println("Call destroy method");
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		
		int dan = Integer.parseInt(request.getParameter("dan"));
		
		pt.print("<table border=1 width=800 align=center>");
		pt.print("<tr align=center bgcolor='#FFFF66'>");
		pt.print("<td colspan=2>" + dan + "단 출력 </td>");
		pt.print("</tr>");
		
		for(int i = 1; i < 10; i++) {
			
			if(i % 2 == 0)
				pt.print("<tr align=center bgcolor='#ACFA58'>");
			else
				pt.print("<tr align=center bgcolor='#81BEF7'>");
				
			pt.print("<td width=400>");
			pt.print(dan + " * " + i);
			pt.print("</td>");
			pt.print("<td width=400>");
			pt.print(i * dan);
			pt.print("</td>");
			pt.print("</tr>");	
		}
		pt.print("</table>");
		

	}

}
