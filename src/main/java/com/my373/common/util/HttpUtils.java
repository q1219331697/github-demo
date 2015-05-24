package com.my373.common.util;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

/**
 * http 工具类
 * 
 * @author QQ:1219331697
 * 
 */
public class HttpUtils {

	/**
	 * 取参数key的值，返回字符串
	 * 
	 * @param key
	 * @param map
	 * @return 字符串
	 */
	public static String getParameter(String key, Map<String, String[]> map) {
		if (map == null) {
			return null;
		}

		String v = "";
		try {
			if (map.get(key) != null) {
				v = new String(map.get(key)[0].getBytes("iso8859-1"), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			v = "";
		}
		return v;
	}

	/**
	 * 取得请求参数，拼接成url参数字符串
	 * 
	 * @param map
	 * @return url参数字符串
	 */
	public static String getUrlParameters(Map<String, String[]> map) {
		if (map == null) {
			return null;
		}

		String urlParameters = "";
		for (Entry<String, String[]> urlkv : map.entrySet()) {
			String k = urlkv.getKey().toString();
			String v = "";
			try {
				v = new String(urlkv.getValue()[0].getBytes("iso8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				v = "";
			}
			urlParameters = urlParameters + "&" + k + "=" + v;
		}
		return urlParameters;
	}
}
