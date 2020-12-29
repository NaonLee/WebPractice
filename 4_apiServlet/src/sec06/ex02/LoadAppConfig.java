package sec06.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Load on startup practice
@WebServlet(name = "loadConfig", urlPatterns = {"/loadConfig"}, loadOnStartup = 1)			//우선순위
public class LoadAppConfig extends HttpServlet {
	
	private ServletContext context;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Call init() method");
		context = config.getServletContext();
		String member_menu = context.getInitParameter("menu_member");
		String member_order = context.getInitParameter("menu_order");
		String member_goods = context.getInitParameter("menu_goods");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("text/html; charset=utf-8");
		response.setContentType("UTF-8");
		PrintWriter pt = response.getWriter();
		//ServletContext context = this.getServletContext();
		String member_menu = context.getInitParameter("menu_member");
		String member_order = context.getInitParameter("menu_order");
		String member_goods = context.getInitParameter("menu_goods");
		
		pt.print("<html><body>");
		pt.print("<table border=1 cellspacing=0><tr>메뉴 이름</tr>");
		pt.print("<tr><td>" + member_menu + "</td></tr>");
		pt.print("<tr><td>" + member_order + "</td></tr>");
		pt.print("<tr><td>" + member_goods + "</td></tr>");
		pt.print("</table></body></html>");
		
	}

}
