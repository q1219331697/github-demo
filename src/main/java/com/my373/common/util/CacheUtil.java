package com.my373.common.util;

import java.util.List;

import net.sf.ehcache.Cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 缓存管理工具类
 * 
 * @author QQ:1219331697
 * 
 */
@Component
public class CacheUtil {

	private final static Logger logger = LoggerFactory.getLogger(CacheUtil.class);

	public static void remove(String beanName) {
		Cache cache = (Cache) BeanUtils.getBean("ehCache");
		// String className = object.getClass().getName();
		String className = BeanUtils.getBean(beanName).toString();
		List<?> list = cache.getKeys();
		for (int i = 0; i < list.size(); i++) {
			String cacheKey = String.valueOf(list.get(i));
			logger.debug(cacheKey);
			if (cacheKey.startsWith(className)) {
				cache.remove(cacheKey);
				logger.debug("remove cache " + cacheKey);
			}
		}
	}

	/**
	 * 清除所有缓存
	 * 
	 * @return 清除的缓存个数
	 */
	public static Integer removeAll() {
		Cache cache = (Cache) BeanUtils.getBean("ehCache");
		Integer size = cache.getSize();
		cache.removeAll();
		return size;
	}
}
