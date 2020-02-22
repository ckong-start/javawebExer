package exer1;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*// i.getRequestURI() 获取请求的资源路径
		System.out.println("请求的资源路径：" + request.getRequestURI());
		// ii.getRequestURL() 获取请求的统一资源定位符（绝对路径）
		System.out.println("请求的统一资源定位符：" + request.getRequestURL());
		// iii.getRemoteHost() 获取客户端的ip地址
		System.out.println("客户端ip地址：" + request.getRemoteHost());
		// iv.getHeader() 获取请求头
		System.out.println(request.getHeader("User-agent"));
		System.out.println(request.getHeader("Accept-Language"));
		// vii.getMethod() 获取请求的方式
		System.out.println(request.getMethod());*/
		
		//request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String[] hobbies = request.getParameterValues("hobby");
		
		/*byte[] buffer = username.getBytes("ISO-8859-1");
		username = new String(buffer, "UTF-8");*/
		
		System.out.println("用户名是：" + username);
		System.out.println("密码是：" + password);
		if(hobbies != null) {
			System.out.println("兴趣：" + Arrays.asList(hobbies));
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		String addr = request.getRemoteAddr();
		String host = request.getRemoteHost();
		System.out.println(host);
		String header = request.getHeader("user-agent");
		String method = request.getMethod();
		System.out.println(method);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String[] hobbies = request.getParameterValues("hobby");
		System.out.println(username);
		System.out.println(password);
		if(hobbies != null) {
			System.out.println(Arrays.asList(hobbies));
		}
	}

}
