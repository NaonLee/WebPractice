package sec03.brd06;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;


@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	ArticleVO articleVO;
	BoardService boardService;
	private static String ARTICLE_IMAGE_REPO = "D:\\뽀송이꺼\\file_repo";

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
		PrintWriter pt = response.getWriter();
		String nextPage = "";
		String action = request.getPathInfo();
		System.out.println("Path: " + action);
		
		try {
			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
			
			if(action == null) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage="/board06/listArticles.jsp";
				
			} else if(action.equals("/listArticles.do")) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage="/board06/listArticles.jsp";
				
			} else if (action.equals("/articleForm.do")) {
				nextPage = "/board06/articleForm.jsp";
				
			} else if(action.equals("/addArticle.do")) {
				int articleNo = 0;
				
				Map<String, String> articleMap = upload(request, response);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				String id = articleMap.get("id");
				
				articleVO = new ArticleVO();
				articleVO.setParentNo(0);
				articleVO.setId(id);
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				
				articleNo = boardService.addArticle(articleVO);
				
				if(imageFileName != null && imageFileName.length() != 0) {
					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
					File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNo);
					destDir.mkdirs();
					
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
				pt.print("<script> alert('Inserted a new article');"
							+ " location.href='" + request.getContextPath() + 
							"/board/listArticles.do'; </script>"
						);
				return;
			} else if (action.equals("/viewArticle.do")) {
				String articleNo = request.getParameter("articleNo");
				articleVO = boardService.viewArticle(Integer.parseInt(articleNo));
				request.setAttribute("article", articleVO);
				nextPage = "/board06/viewArticle.jsp";
				
			} else if (action.equals("/modArticle.do")) {
				articleVO = new ArticleVO();
				Map<String, String> articleMap = upload(request, response);
				int articleNo = Integer.parseInt(articleMap.get("articleNo"));
				
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				String id = request.getParameter("writerId");
				System.out.println("ID: " + id);
				System.out.println("articleNo: " + articleNo);
				System.out.println("title: " + title);
				System.out.println("content: " + content);
				System.out.println("imageFileName: " + imageFileName);
				articleVO.setArticleNo(articleNo);
				articleVO.setParentNo(0);
				articleVO.setId("Ryu");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				boardService.modArticle(articleVO);
				
				String originalFileName = articleMap.get("originalFileName");
				if(imageFileName != null & imageFileName.length() != 0) {
					
					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
					File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNo);
					destDir.mkdirs();
					
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
					
					File oldFile = new File(ARTICLE_IMAGE_REPO + "\\" + articleNo + "\\" + originalFileName);
					oldFile.delete();
				}
				if(imageFileName == null || originalFileName == null) {
					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + articleNo + "\\" + originalFileName);
					File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNo);
					destDir.mkdirs();
					
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
				pt.print("<script> alert('Modified the article');"
						+ " location.href='" + request.getContextPath() + 
						"/board/viewArticle.do?articleNo=" + articleNo + "'; </script>");
				return;
				
			} else if(action.equals("/removeArticle.do")){
				int articleNo = Integer.parseInt(request.getParameter("articleNo"));
				List<Integer> articleNoList = boardService.removeArticle(articleNo);
				for(int _articleNo : articleNoList) {
					File imgDir = new File(ARTICLE_IMAGE_REPO  + "\\" + _articleNo);
					if(imgDir.exists()) FileUtils.deleteDirectory(imgDir);
				}
				pt.print("<script> alert('Deleted the article');"
						+ " location.href='" + request.getContextPath() + 
						"/board/listArticles.do'; </script>");
				return;
				
			}	
				else {
				nextPage="/board06/listArticles.jsp";
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> articleMap = new HashMap<String, String>();
		String encoding = "utf-8";
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024*1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List items = upload.parseRequest(request);
			for(int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);
				System.out.println("----------"+i+"----------");
				if(fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + " ?= " + fileItem.getString(encoding));
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
				} else {
					System.out.println("Parameter name: " + fileItem.getFieldName());
					System.out.println("File name: " + fileItem.getName());
					System.out.println("File size: " + fileItem.getSize() + "bytes");
					if(fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						
						if(idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						
						String fileName = fileItem.getName().substring(idx + 1);
						articleMap.put(fileItem.getFieldName(), fileName);
						File uploadFile = new File(currentDirPath + "\\temp\\" + fileName);
						fileItem.write(uploadFile);
					} 
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return articleMap;
	}
}
