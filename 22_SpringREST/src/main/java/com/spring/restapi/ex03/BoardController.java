package com.spring.restapi.ex03;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
public class BoardController {
	static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<ArticleVO>> listArticle(){
		logger.info("Call listArticles method");
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		
		for(int i = 0; i < 10; i++) {
			ArticleVO vo = new ArticleVO();
			vo.setArticleNO(i);
			vo.setWrite("Leedo");
			vo.setTitle("Hello"+i);
			vo.setContent("Let me introduce!" +i);
			list.add(vo);
		}
		return new ResponseEntity<List<ArticleVO>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{articleNO}", method=RequestMethod.GET)
	public ResponseEntity<ArticleVO> findArticle(@PathVariable("articleNO") Integer articleNO){
		logger.info("Call findArticle method");
		ArticleVO vo = new ArticleVO();
		vo.setArticleNO(articleNO);
		vo.setWrite("Ryujin");
		vo.setTitle("Yo");
		vo.setContent("find find");
		return new ResponseEntity(vo, HttpStatus.OK);
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public ResponseEntity<String> addArtice(@RequestBody ArticleVO articleVO){
		ResponseEntity<String> resEntity = null;
		
		try {
			logger.info("Call addArticle method");
			logger.info(articleVO.toString());
			resEntity = new ResponseEntity("ADD_SUCCEEDED", HttpStatus.OK);
		} catch(Exception e) {
			resEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}
	
	@RequestMapping(value="/{articleNO}", method = RequestMethod.PUT)
	public ResponseEntity<String> modArticle(@PathVariable("articleNO") Integer articleNO, @RequestBody ArticleVO articleVO){
		ResponseEntity<String> resEntity = null;
		try {
			logger.info("Call modArticle method");
			logger.info(articleVO.toString());
			resEntity = new ResponseEntity<String>("MOD_SUCCEEDED", HttpStatus.OK);
		} catch (Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}
	
	@RequestMapping(value="/{articleNO}", method= RequestMethod.DELETE)
	public ResponseEntity<String> removeArticle (@PathVariable("articleNO") Integer articleNO){
		ResponseEntity<String> resEntity = null;
		try {
			logger.info("Call removeArticle method");
			logger.info(articleNO.toString());
			resEntity = new ResponseEntity("REMOVE_SUCCEEDED", HttpStatus.OK);
		} catch (Exception e) {
			resEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}
}
