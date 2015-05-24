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

package com.my373.core.web;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

/**
 * 多视图解析，根据视图name.后缀，解析不同视图模板 <br/>
 * 必须实现 ViewResolver, Ordered 2个接口 <br/>
 * CustomMultipleViewResolver
 * 
 * @author QQ:1219331697
 *
 */
public class CustomMultipleViewResolver implements ViewResolver, Ordered {

	private static Logger logger = LoggerFactory.getLogger(CustomMultipleViewResolver.class);

	/**
	 * 默认使用最高优先级
	 */
	private int order = Ordered.HIGHEST_PRECEDENCE;

	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {

		for (Map.Entry<Set<String>, ViewResolver> map : viewResolverMap.entrySet()) {
			Set<String> suffixs = map.getKey();
			for (String suffix : suffixs) {
				if (viewName.endsWith(suffix)) {
					ViewResolver viewResolver = map.getValue();
					if (null != viewResolver) {
						if (logger.isDebugEnabled()) {
							logger.debug("found viewResolver '" + viewResolver + "' for viewName '" + viewName + "'");
						}
						return viewResolver.resolveViewName(viewName, locale);
					}
				}
			}
		}

		if (defaultViewResolver != null) {
			return defaultViewResolver.resolveViewName(viewName, locale);
		}
		// to allow for ViewResolver chaining
		return null;
	}

	private Map<Set<String>, ViewResolver> viewResolverMap = new HashMap<Set<String>, ViewResolver>();

	private ViewResolver defaultViewResolver = null;

	public Map<Set<String>, ViewResolver> getViewResolverMap() {
		return viewResolverMap;
	}

	public void setViewResolverMap(Map<Set<String>, ViewResolver> viewResolverMap) {
		this.viewResolverMap = viewResolverMap;
	}

	public ViewResolver getDefaultViewResolver() {
		return defaultViewResolver;
	}

	public void setDefaultViewResolver(ViewResolver defaultViewResolver) {
		this.defaultViewResolver = defaultViewResolver;
	}

	@Override
	public int getOrder() {
		return order;
	}

}
