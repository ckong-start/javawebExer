package utils;

import javax.servlet.http.Cookie;

public class CookieUtils {
	/**
	 * 查找指定名称的Cookie
	 * @param name
	 * 		Cookie的名称<br/>
	 * @param cookies
	 * 		查找的Cookie集合<br/>
	 * @return
	 * 		返回null说明没有找到<br/>
	 */
	public static Cookie findCookie(String name, Cookie[] cookies) {
		if(name == null || cookies.length == 0 || cookies == null) {
			return null;
		}
		//遍历查找需要的cookie
		for (Cookie cookie : cookies) {
			if(name.equals(cookie.getName())){
				return cookie;
			}
		}
		return null;
	}
}
