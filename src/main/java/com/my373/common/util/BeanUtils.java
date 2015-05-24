package com.my373.common.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author QQ:1219331697
 * 
 */
@Component
public class BeanUtils implements ApplicationContextAware {

	// Spring应用上下文环境
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		BeanUtils.applicationContext = applicationContext;
	}

	/**
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 获取对象 这里重写了bean方法，起主要作用
	 * 
	 * @param name
	 * @return Object 一个以所给名字注册的bean的实例
	 * @throws BeansException
	 */
	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}

	public static void copyProperties(Object source, Object target) {
		Class<? extends Object> clazz = target.getClass();
		Field[] fields = clazz.getDeclaredFields();
		// 设置访问权限 提升反射速度
		AccessibleObject.setAccessible(fields, true);

		for (int i = 0; i < fields.length; i++) {

			fields[i].setAccessible(true);// 设置允许访问
			try {
				if (fields[i].get(source) != null) {
					fields[i].set(target, fields[i].get(source));
					// System.out.println(fields[i].getName());
					// System.out.println(fields[i].get(target));
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	public static String[] field2Name(Field[] f) {
		String[] name = new String[f.length];
		for (int i = 0; i < f.length; i++) {
			name[i] = f[i].getName();
		}
		return name;
	}

	public static Object[] field2Value(Field[] f, Object o) throws Exception {
		Object[] value = new Object[f.length];
		for (int i = 0; i < f.length; i++) {
			value[i] = f[i].get(o);
		}
		return value;
	}

}
