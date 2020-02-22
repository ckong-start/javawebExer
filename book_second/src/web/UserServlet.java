package web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;
import util.WebUtils;

public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();

	protected void ajaxExistUsername(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		boolean existUsername = userService.existsUsername(username);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("existUsername", existUsername);
		String resultJsonString = new Gson().toJson(result);
		response.getWriter().write(resultJsonString);
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = WebUtils.copy2Bean(new User(), request.getParameterMap());
		User result = userService.login(user);
		HttpSession session = request.getSession();
		
		if (result == null) {
			request.setAttribute("username", user.getUsername());
			request.setAttribute("msg", "用户名或密码不正确");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		} else {
			
			session.setAttribute("user", result);
			System.out.println(user.getUsername() + "登录成功");
			response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
		}
	}

	protected void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		User user = WebUtils.copy2Bean(new User(), request.getParameterMap());
		boolean result = userService.existsUsername(user.getUsername());
		
		if ("1".equals(code)) {
			if (result) {
				request.setAttribute("user", user);
				System.out.println(user.getUsername() + "注册失败");
				request.setAttribute("msg", "用户名已被使用");
				request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			} else {
				request.getSession().setAttribute("user", user);
				System.out.println(user.getUsername() + "注册成功");
				userService.registUser(user);

				response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");
			}
		} else {
			request.setAttribute("code", code);
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}

	protected void loginOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			request.getSession().removeAttribute("user");
			response.sendRedirect(request.getContextPath());
		}
	}

}
