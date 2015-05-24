package com.my373.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie工具
 * 
 * @author QQ:1219331697
 * 
 */
public class CookieUtil {

	/**
	 * cookie保存时间, 单位为秒(Second),<br>
	 * -1:指永远有效, <br>
	 * 负值表示当关闭浏览器时，该 cookie 将被清除，<br>
	 * 0 表示必须立即清除该 cookie
	 */
	private final static int maxAge = 60 * 60 * 24 * 365;
	private final static String uri = "/";

	/**
	 * 跨域共享<br>
	 * 参数必须以“.”开始。<br>
	 * 须输入域名才能解析。如a.yunkegou.com可访问，localhost不能访问。
	 */
	private static final String domain = ".yunkegou.com";

	public static void setAttribute(String key, String value, HttpServletResponse response) {
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(maxAge);
		cookie.setPath(uri);
		cookie.setDomain(domain);
		response.addCookie(cookie);
	}

	public static String getAttribute(String key, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(key)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	public static void removeAllAttribute(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				removeAttribute(cookie.getName(), response);
			}
		}
	}

	public static void removeAttribute(String key, HttpServletResponse response) {
		Cookie cookie = new Cookie(key, null);
		cookie.setMaxAge(0);
		cookie.setPath(uri);
		response.addCookie(cookie);
	}
}
