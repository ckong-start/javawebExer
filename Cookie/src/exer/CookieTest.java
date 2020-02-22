package exer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.CookieUtils;

public class CookieTest extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void createCookie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cookie cookie = new Cookie("abc","abcValue");
		response.addCookie(cookie);
		Cookie cookie2 = new Cookie("aaa","aaaValue");
		response.addCookie(cookie2);
		response.getWriter().write("cookies被创建了");
	}
	protected void getCookie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String name = "aaa";
		Cookie iWantCookie = CookieUtils.findCookie(name, cookies);
		if(iWantCookie != null) {
			response.getWriter().write("找到了Cookie[" + name + "],它的value为：" + iWantCookie.getValue());
		}
	}
	protected void updateCookie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//方案一
//		Cookie cookie = new Cookie("aaa","aaaNewValue");
//		response.addCookie(cookie);
//		response.getWriter().write("cookie[" + cookie.getName() + "]的值被修改了");
		//方案二
		Cookie cookie = CookieUtils.findCookie("aaa", request.getCookies());
		if(cookie != null) {
			cookie.setValue("aaaNewValue");
			response.addCookie(cookie);
		}
		response.getWriter().write("cookie[" + cookie.getName() + "]的值被修改了");
	}
}
