package exer;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionTest extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void createOrGetSession(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean isNew = session.isNew();
		response.getWriter().write("Session已经被创建<br/>是否是新值：" + isNew +"<br/>session的id是：" + session.getId());
	}
	protected void setAttribute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = new Random().nextInt(1000);
		request.getSession().setAttribute("num", num);
		response.getWriter().write("生成的随机数是：" + num + ",已经保存到session中");
	}
	protected void getAttribute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object num = request.getSession().getAttribute("num");
		response.getWriter().write("Session保存的随机数是：" + num);
	}
	protected void defaultValue(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
		response.getWriter().write("Session默认生存时长是：" + maxInactiveInterval + "秒~~");
	}
	protected void life3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3);
		response.getWriter().write("Session生存时长是：" + session.getMaxInactiveInterval() + "秒了~~");
	}
	protected void deleteNow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		response.getWriter().write("Session生存时长是：立马被销毁了~~");
	}

}
