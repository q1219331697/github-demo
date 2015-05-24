package com.my373.interceptor;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 使用拦截器来为要缓存的对象建立缓存并缓存
 * 
 * @author QQ:1219331697
 * 
 */
public class CacheMethodInterceptor implements MethodInterceptor {

	private final Log logger = LogFactory.getLog(getClass());

	private Cache cache;

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public Object invoke(MethodInvocation invocation) throws Throwable {

		// String targetName =
		// invocation.getThis().getClass().getCanonicalName();
		// String targetName =
		// AopUtils.getTargetClass(invocation.getThis()).getClass()
		// .getName();
		// String targetName = invocation.getThis().getClass().getName();
		String targetName = invocation.getThis().toString();
		String methodName = invocation.getMethod().getName();
		Object[] arguments = invocation.getArguments();
		Object result;

		logger.debug("Find object from cache is " + cache.getName());

		String cacheKey = getCacheKey(targetName, methodName, arguments);
		Element element = cache.get(cacheKey);

		if (element == null) {
			logger.debug("Hold up method , Get method result and create cache........!");
			result = invocation.proceed();
			element = new Element(cacheKey, result);
			cache.put(element);
		}
		logger.debug("cache name is " + cacheKey);
		return element.getObjectValue();
	}

	/**
	 * 获得cache key的方法，cache key是Cache中一个Element的唯一标识 cache key包括
	 * 包名+类名+方法名，如com.co.cache.service.UserServiceImpl.getAllUser
	 */
	private String getCacheKey(String targetName, String methodName, Object[] arguments) {
		StringBuffer sb = new StringBuffer();
		sb.append(targetName).append(".").append(methodName);
		if ((arguments != null) && (arguments.length != 0)) {
			for (int i = 0; i < arguments.length; i++) {
				sb.append(".").append(arguments[i]);
			}
		}
		return sb.toString();
	}
}
