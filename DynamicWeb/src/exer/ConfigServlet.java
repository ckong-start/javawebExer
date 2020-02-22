package exer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ConfigServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		//可以获取Servlet程序的别名servlet-name标签的值
		System.out.println("Servlet程序别名：" + config.getServletName());
		//可以获取初始化参数init-param
		System.out.println("初始化参数username的值是：" + config.getInitParameter("username"));
		System.out.println("初始化参数url的值是：" + config.getInitParameter("url"));
		//获取ServletContext
		System.out.println(config.getServletContext());
	}
}
