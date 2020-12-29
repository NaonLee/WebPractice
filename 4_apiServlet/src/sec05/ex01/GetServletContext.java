package sec05.ex01;

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

//ServletContext - 컨테이너 실행시 생성되는 컨텍스트 이용, 서블릿간의 데이터 공유(바인딩)에 도움
@WebServlet("/cget")
public class GetServletContext extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pt = response.getWriter();
		
		ServletContext context = getServletContext();
		List member = (ArrayList)context.getAttribute("member");
		
		String name = (String)member.get(0);
		String num = (String) member.get(1);
		
		pt.print("<html><body>");
		pt.print("Name: " + name + "<br>Number: " + num);
		pt.print("</body></html>");
		
	}

}
