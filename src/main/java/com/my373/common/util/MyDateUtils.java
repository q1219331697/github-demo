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

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

/**
 * MyDateUtils 继承 org.apache.commons.lang3.time.DateUtils 屏蔽异常
 * 
 * 
 * @author QQ:1219331697
 *
 */
public class MyDateUtils extends DateUtils {

	/**
	 * String to Date,异常改为RuntimeException
	 * 
	 * @param str
	 * @param parsePatterns
	 * @return
	 */
	public static Date parseDate(final String str, final String... parsePatterns) {
		Date date = null;
		try {
			date = DateUtils.parseDate(str, parsePatterns);
		} catch (ParseException e) {
			throw new RuntimeException("日期格式错误");
		}
		return date;
	}

	/**
	 * 求2个日期的相差天数，endDate - beginDate
	 * 
	 * @param endDate
	 * @param beginDate
	 * @return
	 */
	public static int subDate(Date endDate, Date beginDate) {
		Calendar d1 = Calendar.getInstance();
		d1.setTime(endDate);
		d1 = setTimeToMidnight(d1);

		Calendar d2 = Calendar.getInstance();
		d2.setTime(beginDate);
		d2 = setTimeToMidnight(d2);

		// 1000 * 60 * 60 * 24 = 86400000,固定值，减少乘法运算的时间
		return (int) ((d1.getTimeInMillis() - d2.getTimeInMillis()) / 86400000);
	}

	/**
	 * 去掉日期时间的时间部分
	 * 
	 * @param calendar
	 * @return
	 */
	public static Calendar setTimeToMidnight(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar;
	}
}
