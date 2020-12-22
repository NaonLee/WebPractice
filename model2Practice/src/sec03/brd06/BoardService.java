package sec03.brd06;

import java.util.List;

public class BoardService {
	
	BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	public List<ArticleVO> listArticles(){
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}
	
	public int addArticle(ArticleVO article) {
		return boardDAO.insertNewArticle(article);
	}
	
	public ArticleVO viewArticle(int articleNo) {
		ArticleVO article = null;
		article = boardDAO.selectArticle(articleNo);
		return article;
	}
	
	public void modArticle(ArticleVO article) {
		boardDAO.updateArticle(article);
	}
	
	public List<Integer> removeArticle(int articleNo){
		List<Integer> articleNoList = boardDAO.selectRemovedArticles(articleNo);
		boardDAO.deleteArticle(articleNo);
		return articleNoList;
	}
}
