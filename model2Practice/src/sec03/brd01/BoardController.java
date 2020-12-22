package sec03.brd01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	ArticleVO articleVO;
	BoardService boardService;


	public void init(ServletConfig config) throws ServletException {
		boardService = new BoardService();
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
		
		String nextPage = "";
		String action = request.getPathInfo();
		System.out.println("Path: " + action);
		
		List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
		
		if(action == null) {
			articlesList = boardService.listArticles();
			request.setAttribute("articlesList", articlesList);
			nextPage="/board01/listArticles.jsp";
		} else if(action.equals("/listArticles.do")) {
			articlesList = boardService.listArticles();
			request.setAttribute("articlesList", articlesList);
			nextPage="/board01/listArticles.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}
