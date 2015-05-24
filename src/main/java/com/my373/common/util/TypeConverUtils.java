package com.my373.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 天润网络类型转换通用工具
 */
public class TypeConverUtils {

	/**
	 * isNumeric 判断是否整数
	 */
	public static boolean IsNumeric(String string) {
		Pattern pattern = Pattern.compile("[0-9]+");
		return pattern.matcher(string).matches();
	}

	/**
	 * StringToInteger 字符串转整数
	 */
	public static Integer StringToInteger(String string) {
		if (null == string) {
			return null;
		}
		Pattern pattern = Pattern.compile("[0-9]+");
		if (pattern.matcher(string).matches()) {
			return Integer.valueOf(string);
		}
		return null;
	}

	public static int StringToInt(String string) {
		if (null == string) {
			return 0;
		}
		Pattern pattern = Pattern.compile("[0-9]+");
		if (pattern.matcher(string).matches()) {
			return Integer.parseInt(string);
		}
		return 0;
	}

	public static String ListToString(List<?> list) {
		String string = StringUtils.join(list.toArray(), ",");
		return string;
	}

	public static List<String> StringToList(String string) {
		if (string == null || string.equals("")) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		list = Arrays.asList(string.split(","));
		return list;
	}

	public static String StringRemoveAll(String string, String removeString) {
		String[] strings = StringUtils.split(string, ",");
		for (String s : strings) {
			if (s.equals(removeString)) {
				strings = ArrayUtils.removeElement(strings, removeString);
			}
		}
		return StringUtils.join(strings, ",");
	}

	/**
	 * MapToString 非递归 简单数据类型
	 * 
	 * @param map
	 * @param separatorChars
	 * @return
	 */
	public static String MapToString(Map<String, Object> map, String separatorChars) {

		String string = "";

		// Set<Entry<String, Object>> set = map.entrySet();
		for (Entry<String, Object> entry : map.entrySet()) {
			string += entry.getKey().toString() + "=" + map.get(entry.getKey()) + separatorChars;
		}
		// for (String key : map.keySet()) {
		// string += key + "=" + map.get(key) + separatorChars;
		// }
		return string;

	}
}
