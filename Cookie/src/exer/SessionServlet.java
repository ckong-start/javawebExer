package exer;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	Random random = new Random();
	
	protected void deleteNow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		response.getWriter().write("session会话立即被销毁");
	}
	
	protected void life3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setMaxInactiveInterval(3);
		response.getWriter().write("修改了session的超时时间是3秒");
	}
	
	protected void defaultLife(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
		response.getWriter().write("session默认存活时间是：" + maxInactiveInterval);
	}
	
	protected void getAttribute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object num = request.getSession().getAttribute("num");
		response.getWriter().write("session取出了num：" + num);
	}
	
	protected void setAttribue(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = random.nextInt(1000);
		request.getSession().setAttribute("num", num);
		response.getWriter().write("session保存了一个num：" + num);
	}

	protected void createOrGetSession(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.getWriter()
				.write("创建了Session对象<br/>是否是新创建的呢：" + session.isNew() + "<br/>当前的session的id是：<br/>" + session.getId());
	}

}
