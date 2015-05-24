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

package com.my373.core.spring;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

/**
 * DateConverter 日期时间格式绑定
 * 
 * @author QQ:1219331697
 *
 */
public class DateConverter implements Converter<String, Date> {
	private static Logger logger = LoggerFactory.getLogger(DateConverter.class);
	private List<String> patterns = new ArrayList<String>();

	public DateConverter() {
		patterns.add("yyyy-MM-dd HH:mm:ss");
		patterns.add("yyyyMMdd HH:mm:ss");
		patterns.add("yyyy-MM-dd");
		patterns.add("yyyyMMdd");
		patterns.add("HH:mm:ss");
	}

	public Date convert(String text) {
		if (text == null) {
			return null;
		}

		for (String pattern : patterns) {
			Date date = tryConvert(text, pattern);

			if (date != null) {
				return date;
			}
		}

		return null;
	}

	public Date tryConvert(String text, String pattern) {
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		// 把不合法日期进行转换,true=转换；false=不转换,如 2015-02-30=2015-03-02
		dateFormat.setLenient(false);

		try {
			return dateFormat.parse(text);
		} catch (ParseException ex) {
			logger.debug(ex.getMessage(), ex);
		}

		return null;
	}

	public void setPatterns(List<String> patterns) {
		this.patterns = patterns;
	}
}