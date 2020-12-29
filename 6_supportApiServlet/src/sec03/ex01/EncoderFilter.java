package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/*")
public class EncoderFilter implements Filter {
	ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init()");
		System.out.println("UTF-8로 인코딩........");
		context = fConfig.getServletContext();
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter()");
		request.setCharacterEncoding("UTF-8");
		
		String context = ((HttpServletRequest)request).getContextPath();
		String pathinfo = ((HttpServletRequest)request).getRequestURI();
		String realPath = (String)request.getRealPath(pathinfo);
		
		String msg = "Context info: " + context + "\n URI info: " + pathinfo + "\n realPath: " + realPath;
		
		System.out.println(msg);
		
		long begin = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long end = System.currentTimeMillis();
		System.out.println("작업시간: " + (end - begin) + "ms");
	}

	public void destroy() {
		System.out.println("destroy()");
	}
	

}
