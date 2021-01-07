package com.spring.restapi.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/*")
public class TestController {
	
	
	//send text/html
	@RequestMapping("/hello")
	public String hello() {
		return "Hello REST!";
	}
	
	//Send object as JSON
	@RequestMapping("/member")
	public MemberVO member() {
		MemberVO vo = new MemberVO();
		vo.setId("id");
		vo.setPwd("pwd");
		vo.setName("name");
		vo.setEmail("email");
		return vo;
	}
	
	//Bring List(collection) 
		@RequestMapping("/membersList")
		public List membersList() {
			List<MemberVO> list = new ArrayList<MemberVO>();
			
			for(int i = 0; i < 10; i++) {
				MemberVO vo = new MemberVO();
				vo.setId("id");
				vo.setPwd("pwd");
				vo.setName("name");
				vo.setEmail("email");
				list.add(vo);
			}
			return list;
		}
	
	//Bring Map 
	@RequestMapping("/membersMap")
	public Map<Integer, MemberVO> membersMap() {
		Map<Integer, MemberVO> map = new HashMap<Integer, MemberVO>();
		
		for(int i = 0; i < 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("id");
			vo.setPwd("pwd");
			vo.setName("name");
			vo.setEmail("email");
			map.put(i, vo);
		}
		return map;
	}
	//bring the variable requested as URL
	@RequestMapping(value="/notice/{num}", method=RequestMethod.GET)
	public int notice(@PathVariable("num") int num) throws Exception{
		return num;
	}
	
	//using RequestBody, ajax
	static Logger logger = LoggerFactory.getLogger(TestController.class);
	@RequestMapping(value="/info", method=RequestMethod.POST)
	public void modify(@RequestBody MemberVO vo) {
		logger.info(vo.toString());
	}
	
	//Using ResponseEntity
	@RequestMapping(value="/membersList2")
	public ResponseEntity<List<MemberVO>> listMembers2(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		for(int i = 0; i < 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("lee" + i);
			vo.setPwd("123" + i);
			vo.setName("Leedo" + i);
			vo.setEmail("email" + i);
			list.add(vo);
		}
		return new ResponseEntity(list, HttpStatus.INTERNAL_SERVER_ERROR);	//status code 500
	}
	
	//Using ResponseEntity2
	@RequestMapping(value="/res3")
	public ResponseEntity res3() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		String message = "<script>";
		message += "alert('add a new member');";
		message += "location.href='/restapi/test/membersList2';";
		message += "</script>";
		return new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	}
}
