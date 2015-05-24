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

import java.util.Map;

import org.springframework.data.domain.Page;

/**
 * 分页辅助类
 * 
 * @author QQ:1219331697
 *
 */
public class PageUtil {

	public static final Integer PAGESIZE = 20;

	/**
	 * 生成 页码导航
	 * 
	 * @param page
	 *            spring data 分页对象
	 * @param soMap
	 *            查询条件，自动拼接
	 * @return
	 * @see org.springframework.data.domain.Page
	 */
	public static String createPages(Page<?> page, Map<String, Object> soMap) {
		String pages = "";
		for (int i = 1; i <= page.getTotalPages(); i++) {
			// 页码 固定参数为 p
			String tmpPages = "?p=" + i;

			// 其他动态参数
			for (Map.Entry<String, Object> entry : soMap.entrySet()) {
				tmpPages = tmpPages + "&" + entry.getKey() + "=" + entry.getValue().toString();
			}

			// 当前页 加样式 curpage
			if (page.getNumber() == i) {
				tmpPages = " <a href=\"" + tmpPages + "\" class=\"curpage\">" + i + "</a> ";
			} else {
				tmpPages = " <a href=\"" + tmpPages + "\">" + i + "</a> ";
			}

			pages = pages + tmpPages;
		}

		return pages;
	}

}
