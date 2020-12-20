package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



@WebServlet("/json3")
public class JsonServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;


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
		
		JSONObject totalObejct = new JSONObject();
		JSONArray membersArray = new JSONArray();
		JSONObject memberInfo = new JSONObject();
		
		memberInfo.put("name", "최지수");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "F");
		memberInfo.put("nickname", "리아");
		membersArray.add(memberInfo);
		
		
		memberInfo = new JSONObject();
		memberInfo.put("name", "이채령");
		memberInfo.put("age", "20");
		memberInfo.put("gender", "F");
		memberInfo.put("nickname", "채령");
		membersArray.add(memberInfo);
		
		totalObejct.put("members", membersArray);
		
		JSONArray bookArray = new JSONArray();
		JSONObject bookInfo  = new JSONObject();
		
		bookInfo.put("title", "Java programming for beginners");
		bookInfo.put("writer", "LeeByungSeung");
		bookInfo.put("price", "30000");
		bookInfo.put("genre", "IT");
		bookInfo.put("image", "http://localhost:8090/jqueryPractice/image/Koala.jpg");
		bookArray.add(bookInfo);
		
		bookInfo = new JSONObject();
		bookInfo.put("title", "Python for everyone");
		bookInfo.put("writer", "LeeSeungChan");
		bookInfo.put("price", "20000");
		bookInfo.put("genre", "IT");
		bookInfo.put("image", "http://localhost:8090/jqueryPractice/image/Penguins.jpg");
		bookArray.add(bookInfo);
		
		totalObejct.put("books", bookArray);
		
		String jsonInfo = totalObejct.toJSONString();
		System.out.print(jsonInfo);
		pt.print(jsonInfo);
	}

}
