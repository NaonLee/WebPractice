package sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener				//listener should have this annotation except HttpSessionBindingListner
public class LoginImpl implements HttpSessionListener {			
	String id;
	String pwd;
	static int total=0;

    public LoginImpl() {
    }


    public LoginImpl(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}


	public void sessionCreated(HttpSessionEvent arg0)  { 
		System.out.println("Created session");
		++total;
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("Destroyed session");
		--total;
    }
	
}
