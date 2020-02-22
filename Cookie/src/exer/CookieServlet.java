package exer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.CookieUtils;

public class CookieServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void createCookie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = null;
		for (int i = 0; i < 5; i++) {
			cookie = new Cookie("key" + i,"value" + i);
			response.addCookie(cookie);
			response.getWriter().write(cookie.getName() + "已经创建<br/>");
		}
	}
	protected void getCookie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	/*	String name = "key2";
		Cookie[] cookies = request.getCookies();
		Cookie desCookie = null;
		for (Cookie cookie : cookies) {
			if(name.equals(cookie.getName())) {
				desCookie = cookie;
				break;
			}
		}
		if(desCookie != null) {
			response.getWriter().write(desCookie.getName() + "已经找到了<br/>它的值为：" + desCookie.getValue());
		}*/
		Cookie desCookie = CookieUtils.findCookie("key3", request.getCookies());
		if(desCookie != null) {
			response.getWriter().write(desCookie.getName() + "已经找到了<br/>它的值为：" + desCookie.getValue());
		}
	}

}
