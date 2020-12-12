package sec05.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//ServletContext 매개변수 설정
@WebServlet("/initMenu")
public class ContextParamServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter pt = response.getWriter();
		
		ServletContext context = this.getServletContext();
		String menu_member = context.getInitParameter("menu_member");
		String menu_order = context.getInitParameter("menu_order");
		String menu_goods = context.getInitParameter("menu_goods");
		
		pt.print("<html><body>");
		pt.print("<table border=1 cellspacin=0><tr>메뉴 이름</tr>");
		pt.print("<tr><td>" + menu_member + "</td></tr>");
		pt.print("<tr><td>" + menu_order + "</td></tr>");
		pt.print("<tr><td>" + menu_goods + "</td></tr>");
		pt.print("</table></body></html>");
	}

}
