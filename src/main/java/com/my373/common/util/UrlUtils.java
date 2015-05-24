package com.my373.common.util;

import java.util.Map;

/**
 * @author QQ:1219331697
 * 
 */
public class UrlUtils {

	public static String getParameters(Map<String, Object> map) {

		return TypeConverUtils.MapToString(map, "&");

	}
}
