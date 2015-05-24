package com.my373.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 全局配置工具
 * 
 * @author QQ:1219331697
 *
 */
public class PropertyUtil {

	/**
	 * @param key
	 *            键名
	 * @param confFile
	 *            配置文件名
	 * @return value 值
	 */
	public static String getProperty(String key, String confFile) {

		String value = "";

		try {
			InputStream inputStream = PropertyUtil.class.getClassLoader().getResourceAsStream(confFile);
			Properties properties = new Properties();
			properties.load(inputStream);
			value = properties.getProperty(key);
		} catch (IOException e) {
			// 如果出现异常，返回空
			value = "";
		}

		return value;
	}

	/**
	 * @param key
	 *            键名
	 * @return value 值
	 */
	public static String getProperty(String key) {

		String value = "";

		try {
			InputStream inputStream = PropertyUtil.class.getClassLoader().getResourceAsStream("global.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			value = properties.getProperty(key);
		} catch (IOException e) {
			// 如果出现异常，返回空
			value = "";
		}

		return value;
	}
}
