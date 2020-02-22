package exer;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ServletContext servletContext = this.getServletConfig().getServletContext();
		ServletContext servletContext = this.getServletContext();
		String nameValue = servletContext.getInitParameter("driverClassName");
		String pswValue = servletContext.getInitParameter("password");
		System.out.println("上下文参数【driverClassName】的值是：" + nameValue);
		System.out.println("上下文参数【password】的值是：" + pswValue);
		System.out.println("==============");
		System.out.println("当前的工程路径是：" + servletContext.getContextPath());
		String projectPath = servletContext.getRealPath("/");
		System.out.println(projectPath);
		
	}
}
