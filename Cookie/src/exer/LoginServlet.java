package exer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if("qwe123".equals(username) && "123456".equals(password)) {
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(60 * 60 *24);
			System.out.println("登录成功");
			response.addCookie(cookie);
			response.sendRedirect("/Cookie/NewFile.jsp");
		}else {
			System.out.println("登录失败");
			request.getRequestDispatcher("/NewFile.jsp").forward(request, response);
		}
	}

}
