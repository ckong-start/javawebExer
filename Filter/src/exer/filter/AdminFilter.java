package exer.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("AdminFilter过滤器执行了~~~");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		Object username = session.getAttribute("username");
		if (username == null) {
			// 没有登录的情况
			System.out.println("还没有登录，跳到登录页面");
			//request.getRequestDispatcher("/login.jsp").forward(request, response);
			httpRequest.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
			// 登录的情况
			chain.doFilter(httpRequest, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
