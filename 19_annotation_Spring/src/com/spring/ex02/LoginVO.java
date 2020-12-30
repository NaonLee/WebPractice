package com.spring.ex02;

public class LoginVO {
	private String id;
	private String pwd;
	
	public LoginVO() {}
	
	public LoginVO(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
