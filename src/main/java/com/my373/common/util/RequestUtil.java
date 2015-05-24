/**
 * Copyright qq:1219331697
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.my373.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 取request中相关参数
 * 
 * @author QQ:1219331697
 */
public class RequestUtil {

	public static String getString(String name, HttpServletRequest request) {
		String string = request.getParameter(name);
		return string;
	}

	public static Integer getInteger(String name, HttpServletRequest request) {
		String string = request.getParameter(name);
		Integer integer = null;
		try {
			integer = Integer.parseInt(string);
		} catch (Exception e) {
			// throw new Exception("[" + name + "]不是数字类型");
		}
		return integer;
	}

	public static int getInt(String name, HttpServletRequest request) {
		int i = 0;
		String string = request.getParameter(name);

		try {
			i = Integer.getInteger(string, 0);
		} catch (Exception e) {
			// throw new Exception("[" + name + "]不是数字类型");
		}
		return i;
	}
}
