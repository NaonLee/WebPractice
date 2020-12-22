package sec03.brd08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private DataSource dataFactory;
	private Connection con;
	private PreparedStatement pstmt;
	
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envCtx.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ArticleVO> selectAllArticles(Map<String, Integer> pagingMap) {
		List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
		int section = (Integer) pagingMap.get("section");
		int pageNum = (Integer) pagingMap.get("pageNum");
		
		try {
			con = dataFactory.getConnection();
			String SQL = "SELECT * FROM (SELECT ROWNUM as recNum, LVL, articleNo, parentNo, title, content, id, writeDate" +
							" from (SELECT LEVEL as LVL, articleNo, parentNo, title, content, id, writeDate FROM t_board" +
							" START WITH parentNo=0 CONNECT BY PRIOR articleNo=parentNo" +
							" ORDER SIBLINGS BY articleNo DESC)) WHERE recNum between(?-1)*100+(?-1)*10+1 and (?-1)*100+?*10";
			System.out.println("SQL: " + SQL);
			
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, section);
			pstmt.setInt(2, pageNum);
			pstmt.setInt(3, section);
			pstmt.setInt(4, pageNum);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int level = rs.getInt("lvl");
				int articleNo = rs.getInt("articleNo");
				int parentNo = rs.getInt("parentNo");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				
				ArticleVO article = new ArticleVO();
				article.setLevel(level);
				article.setArticleNo(articleNo);
				article.setParentNo(parentNo);
				article.setTitle(title);
				article.setContent(content);
				article.setId(id);
				article.setWriteDate(writeDate);
				articlesList.add(article);
			}
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articlesList;
	}
	
	public int selectTotArticles() {
		try {
			con = dataFactory.getConnection();
			String SQL = "SELECT COUNT(articleNo) FROM t_board";
			System.out.println("SQL: " + SQL);
			pstmt = con.prepareStatement(SQL);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return (rs.getInt(1));
			}
			rs.close();
			pstmt.close();
			con.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public ArticleVO selectArticle(int articleNo) {
		ArticleVO article  = new ArticleVO();
		try {
			con = dataFactory.getConnection();
			String SQL = "SELECT articleNo, parentNo, title, content, imageFileName, id, writeDate from t_board where articleNo=?";
			System.out.println("SQL: " + SQL);
			
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, articleNo);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			int _articleNo = rs.getInt("articleNo");
			int parentNo = rs.getInt("parentNo");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String imageFileName = rs.getString("imageFileName");
			String id = rs.getString("id");
			Date writeDate = rs.getDate("writeDate");
			
			article.setArticleNo(_articleNo);
			article.setParentNo(parentNo);
			article.setTitle(title);
			article.setContent(content);
			article.setImageFileName(imageFileName);
			article.setId(id);
			article.setWriteDate(writeDate);
			
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}
	
	private int getNewArticleNo() {
		try {
			con = dataFactory.getConnection();
			String SQL = "SELECT max(articleNo) from t_board";
			System.out.println("SQL: " + SQL);
			pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return (rs.getInt(1) + 1);
			}
			
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int insertNewArticle(ArticleVO article) {
		int articleNo = getNewArticleNo();
		try {
			
			con = dataFactory.getConnection();
			String SQL = "INSERT INTO t_board (articleNo, parentNo, title, content, imageFileName, id)" + " VALUES(?, ?, ?, ?, ?, ?)";
			System.out.println("SQL: " + SQL);
			
			int parentNo = article.getParentNo();
			String title = article.getTitle();
			String content = article.getContent();
			String imageFileName = article.getImageFileName();
			String id = article.getId();
			
			System.out.println("article No: " + articleNo);
			System.out.println("parentNo: " + parentNo);
			System.out.println("title: " + title);
			System.out.println("content: " + content);
			System.out.println("image: " + imageFileName);
			System.out.println("id: " + id);
			
			
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, articleNo);
			pstmt.setInt(2, parentNo);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setString(5, imageFileName);
			pstmt.setString(6, id);
			pstmt.executeUpdate();
		
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articleNo;
	}
	
	public void updateArticle(ArticleVO article) {
		int articleNo = article.getArticleNo();
		String title = article.getTitle();
		String content = article.getContent();
		String imageFileName = article.getImageFileName();
		
		try {
			con = dataFactory.getConnection();
			String SQL = "UPDATE t_board set title=?, content=?";
			
			if(imageFileName != null && imageFileName.length() != 0) {
				SQL += ", imageFileName=?";
			}
			SQL += " where articleNo=?";
			
			System.out.println("SQL: " + SQL);
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			if(imageFileName != null && imageFileName.length() != 0) {
				pstmt.setString(3, imageFileName);
				pstmt.setInt(4, articleNo);
			}
			else pstmt.setInt(3, articleNo);
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteArticle(int articleNo) {
		try {
			con = dataFactory.getConnection();
			String SQL = "DELETE FROM t_board WHERE articleNo in(" +
							"SELECT articleNo FROM t_board START WITH articleNo=? CONNECT BY PRIOR articleNo=parentNo";
			System.out.println("SQL: " + SQL);
			
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, articleNo);
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Integer> selectRemovedArticles(int articleNo){
		List<Integer> articleNoList = new ArrayList<Integer>();
		try {
			con = dataFactory.getConnection();
			String SQL = "DELETE FROM t_board WHERE articleNo in (" +
					"SELECT articleNo FROM t_board START WITH articleNo=? CONNECT BY PRIOR articleNo=parentNo)";
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, articleNo);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				articleNo = rs.getInt("articleNo");
				articleNoList.add(articleNo);
			}
			
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleNoList;
	}
}
