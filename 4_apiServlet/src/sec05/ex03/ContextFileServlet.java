package sec05.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/cfile")
public class ContextFileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter pt = response.getWriter();
		ServletContext context = this.getServletContext();
		InputStream is = context.getResourceAsStream("/WEB-INF/bin/init.txt");		//read file
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		
		String menu = null;
		String menu_member = null;
		String menu_order = null;
		String menu_goods = null;
		
		while((menu = buffer.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(menu, ",");
			menu_member = tokens.nextToken();
			menu_order = tokens.nextToken();
			menu_goods = tokens.nextToken();
		}
		
		pt.print("<html><body>");
		pt.print("menu_member: " + menu_member + "<br>");
		pt.print("menu_order: " + menu_order + "<br>");
		pt.print("menu_goods: " + menu_goods + "<br>");
		pt.print("</body></html>");
		pt.close();
		
	}

}
