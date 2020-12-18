package sec01.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/download.do")
public class FileDownload extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String file_repo = "D:\\뽀송이꺼\\file_repo";
		String fileName = request.getParameter("fileName");
		System.out.println("filename=" + fileName);
		
		OutputStream out = response.getOutputStream();
		String downFile = file_repo+"\\"+fileName;
		System.out.println("filename=" + fileName);
		System.out.println("downFile: "+ downFile);
		File f = new File(downFile);
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName=" + fileName);
		
		FileInputStream in = new FileInputStream(f);
		byte[] buffer = new byte[1024*8];
		
		while(true) {
			int count = in.read(buffer);
			if(count==-1)
				break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}
}
