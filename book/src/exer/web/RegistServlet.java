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
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		
		if("abcd".equalsIgnoreCase(code)) {
			if(userService.existsUsername(username)) {
				System.out.println("用户名【" + username + "】不可用");
				request.setAttribute("msg", "用户名已存在");
				request.setAttribute("username", username);
				request.setAttribute("email", email);
				
				request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			}else{
				userService.registUser(new User(null, username, password, email));
				request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("msg", "验证码不正确");
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			
			// 跳回注册页面
			System.out.println("验证码错误：" + code);
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}

}
