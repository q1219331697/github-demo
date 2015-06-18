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

package com.my373.core.json;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

/**
 * @author QQ:1219331697
 *
 */
public class HibernateAwareObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 1L;

	public HibernateAwareObjectMapper() {
		registerModule(new Hibernate4Module());
		
		setSerializationInclusion(Include.NON_NULL);

		// ObjectMapper mapper = new ObjectMapper();
		//
		// mapper.setSerializationInclusion(Include.NON_NULL);
		//
		// //通过该方法对mapper对象进行设置，所有序列化的对象都将按改规则进行系列化
		// //Include.Include.ALWAYS 默认
		// //Include.NON_DEFAULT 属性为默认值不序列化
		// //Include.NON_EMPTY 属性为 空（“”） 或者为 NULL 都不序列化
		// //Include.NON_NULL 属性为NULL 不序列化
		//
		// User user = new User(1,"",null);
		// String outJson = mapper.writeValueAsString(user);
		// System.out.println(outJson);
	}
}
