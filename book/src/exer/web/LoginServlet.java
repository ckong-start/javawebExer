package exer.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exer.pojo.User;
import exer.service.UserService;
import exer.service.impl.UserServiceImpl;
@Deprecated
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.login(new User(null, username, password, null));
		if(user == null) {
			request.setAttribute("msg", "用户名或密码错误");
			request.setAttribute("username", username);
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
			
		}else {
			//成功，跳到登录成功
			request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
		}
	}

}
