package sec03.brd08;

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
import javax.servlet.http.HttpSession;

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
		HttpSession session;
		
		String nextPage = "";
		String action = request.getPathInfo();
		System.out.println("Path: " + action);
		
		try {
			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
			
			if(action == null) {
				String _section = request.getParameter("section");
				String _pageNum = request.getParameter("pageNum");
				
				int section = Integer.parseInt(((_section == null) ? "1" : _section));
				int pageNum = Integer.parseInt(((_pageNum == null) ? "1" : _pageNum));
				
				Map<String, Integer> pagingMap = new HashMap<String, Integer>();
				pagingMap.put("section", section);
				pagingMap.put("pageNum", pageNum);
				
				Map articlesMap = boardService.listArticles(pagingMap);
				articlesMap.put("section", section);
				articlesMap.put("pageNum", pageNum);
				request.setAttribute("articlesMap", articlesMap);
				nextPage = "/board08/listArticles.jsp";
				
				
			} else if(action.equals("/listArticles.do")) {
				String _section = request.getParameter("section");
				String _pageNum = request.getParameter("pageNum");
				
				int section = Integer.parseInt(((_section == null) ? "1" : _section));
				int pageNum = Integer.parseInt(((_pageNum == null) ? "1" : _pageNum));
				Map<String, Integer> pagingMap = new HashMap<String, Integer>();
				
				pagingMap.put("section", section);
				pagingMap.put("pageNum", pageNum);
				
				Map articlesMap = boardService.listArticles(pagingMap);
				articlesMap.put("section", section);
				articlesMap.put("pageNum", pageNum);
				request.setAttribute("articlesMap", articlesMap);
				nextPage = "/board08/listArticles.jsp";
				
			} else if (action.equals("/articleForm.do")) {
				nextPage = "/board07/articleForm.jsp";
				
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
				nextPage = "/board07/viewArticle.jsp";
				
			} else if (action.equals("/modArticle.do")) {
				articleVO = new ArticleVO();
				Map<String, String> articleMap = upload(request, response);
				int articleNo = Integer.parseInt(articleMap.get("articleNo"));
				
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				String id = request.getParameter("id");
				String id2 = articleMap.get("id");
				System.out.println("id:" +id);
				System.out.println("id2:" +id2);
				
				String originalFileName = articleMap.get("originalFileName");
				articleVO.setArticleNo(articleNo);
				articleVO.setParentNo(0);
				articleVO.setId(id);
				articleVO.setTitle(title);
				articleVO.setContent(content);
				
				System.out.println("image File Name:" +imageFileName);
				System.out.println("originale File Name:" +originalFileName);
				
				if(originalFileName != null && originalFileName.length() !=0 && imageFileName == null) {
					articleVO.setImageFileName(originalFileName);
				} else {
					articleVO.setImageFileName(imageFileName);
				}
				
				boardService.modArticle(articleVO);
				
				if(imageFileName != null && imageFileName.length() != 0) {
					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
					File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNo);
					destDir.mkdirs();
					
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
					if(originalFileName != null && originalFileName.length() !=0) {
						File oldFile = new File(ARTICLE_IMAGE_REPO + "\\" + articleNo + "\\" + originalFileName);
						oldFile.delete();
					} 
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
				
			} else if(action.equals("/replyForm.do")) {
				int parentNo = Integer.parseInt(request.getParameter("parentNo"));
				session = request.getSession();
				session.setAttribute("parentNo", parentNo);
				nextPage = "/board07/replyForm.jsp";
			
			} else if(action.equals("/addReply.do")) {
				session = request.getSession();
				int parentNo = (Integer) session.getAttribute("parentNo");
				session.removeAttribute("parentNo");
				
				Map<String, String> articleMap = upload(request, response);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				
				
				articleVO = new ArticleVO();
				articleVO.setParentNo(parentNo);
				articleVO.setId("Leee");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				int articleNo = boardService.addReply(articleVO);
				
				if(imageFileName != null && imageFileName.length() != 0) {
					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
					File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNo);
					destDir.mkdirs();
					
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
				pt.print("<script> alert('Reply for the article');"
							+ " location.href='" + request.getContextPath() + 
							"/board/viewArticle.do?articleNo=" + articleNo + "'; </script>"
						);
				return;

			}
			
				else {
				nextPage="/board07/listArticles.jsp";
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
					} else {
						articleMap.put(fileItem.getFieldName(), null);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return articleMap;
	}
}
