package exer;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThreeServlet
 */
public class ThreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = this.getServletConfig();
		String name = config.getInitParameter("username");
		System.out.println("username:" + name);
		String clazz = config.getInitParameter("url");
		System.out.println("url" + clazz);
		ServletContext context = config.getServletContext();
		String psw = context.getInitParameter("password");
		System.out.println("password" + psw);
		String className = context.getInitParameter("className");
		System.out.println("className" + className);
		System.out.println("当前工程路径：" + context.getContextPath());
		System.out.println("获取当前工程的部署路径；" + context.getRealPath(""));
		context.setAttribute("abc", "abcValue");
		System.out.println(context.getAttribute("abc"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
}
