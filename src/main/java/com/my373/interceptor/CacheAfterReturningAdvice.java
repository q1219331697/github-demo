package com.my373.interceptor;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.ehcache.Cache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

public class CacheAfterReturningAdvice implements AfterReturningAdvice {

	private final Log logger = LogFactory.getLog(getClass());

	private Cache cache;

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target)
			throws Throwable {
//		String className = target.getClass().getName();
		String className = target.toString();
		List<?> list = cache.getKeys();
		for (int i = 0; i < list.size(); i++) {
			String cacheKey = String.valueOf(list.get(i));
			if (cacheKey.startsWith(className)) {
				cache.remove(cacheKey);
				logger.debug("remove cache " + cacheKey);
			}
		}
	}
}
