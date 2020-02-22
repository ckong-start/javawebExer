package exer.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.code.kaptcha.Constants;
import com.google.gson.Gson;

import exer.pojo.User;
import exer.service.UserService;
import exer.service.impl.UserServiceImpl;
import exer.util.WebUtils;

public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	/**
	 * 用Ajax验证用户名是否存在
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void ajaxExistUsername(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		boolean existsUsername = userService.existsUsername(username);
		Map<String, Object> result = new HashMap<>();
		result.put("existsUsername", existsUsername);
		String resultJsonString = new Gson().toJson(result);
		response.getWriter().write(resultJsonString);
	}
	
	protected void loginOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//清除用户登录信息，即让session马上失效
		request.getSession().invalidate();
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//第一种方法
		//User user = userService.login(new User(null,username,password,null));
		//第一种方法，针对参数很多的情况
		User user = WebUtils.copyParamToBean(new User(), request.getParameterMap());
		user = userService.login(user);
		if (user == null) {
			request.setAttribute("msg", "用户名或密码错误");
			request.setAttribute("username", username);
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);

		} else {
			request.getSession().setAttribute("user", user);
			// 成功，跳到登录成功
			request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
		}
	}
	
	protected void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		User user = WebUtils.copyParamToBean(new User(), request.getParameterMap());
		
		HttpSession session = request.getSession();
		String token = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
		
		if(token.equalsIgnoreCase(code)) {
			if(userService.existsUsername(username)) {
				System.out.println("用户名【" + username + "】已被使用");
				request.setAttribute("msg", "用户名已存在");
				request.setAttribute("username", username);
				request.setAttribute("email", email);
				request.setAttribute("code", code);
				
				request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			}else{
				//userService.registUser(new User(null, username, password, email));
				userService.registUser(user);
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("msg", "验证码不正确");
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			request.setAttribute("code", code);
			// 跳回注册页面
			System.out.println("验证码错误：" + code);
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}
}
