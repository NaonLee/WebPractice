package sec04.ex01;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class LoginImpl implements HttpSessionBindingListener{

	String id;
	String pwd;
	static int total = 0;
	
	public LoginImpl(){}
	
	
	public LoginImpl(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}


	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("user login");
		++total;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("user logout");
		total--;
	}


}
