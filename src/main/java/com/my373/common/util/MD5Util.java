package com.my373.common.util;

import java.io.UnsupportedEncodingException;

import org.springframework.util.DigestUtils;

/**
 * @author QQ:1219331697
 * 
 */
public class MD5Util {

	public static String encoding(String preEncodingString) {
		String md5 = "";
		try {
			md5 = DigestUtils.md5DigestAsHex(preEncodingString.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
		}
		return md5;
	}

	public static String encoding(String preEncodingString, String salt) {
		preEncodingString = preEncodingString + "{" + salt + "}";
		return encoding(preEncodingString);
	}

}
