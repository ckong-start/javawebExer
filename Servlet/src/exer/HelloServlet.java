package exer;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class HelloServlet implements Servlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		String method = httpRequest.getMethod();
		if("GET".equals(method)) {
			doGet();
		}else if("POST".equals(method)) {
			doPost();
		}
		
	}
	private void doGet() {
		System.out.println("执行doGet请求的业务");

	}
	private void doPost() {
		System.out.println("执行doPost请求的业务");

	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
