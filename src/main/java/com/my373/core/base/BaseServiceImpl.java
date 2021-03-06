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

package com.my373.core.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author QQ:1219331697
 *
 */
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	// TODO Spring4新特性——泛型限定式依赖注入
	// http://jinnianshilongnian.iteye.com/blog/1989330
	public abstract BaseDao<T, ID> getDao();

	@Override
	public abstract Page<T> findAll(Map<String, Object> paramMap, Pageable pageable);

	@Override
	public T save(T entity) {
		return getDao().save(entity);
	}

	@Override
	public List<T> save(Iterable<T> entities) {
		return getDao().save(entities);
	}

	@Override
	public void flush() {
		getDao().flush();
	}

	@Override
	public T saveAndFlush(T entity) {
		return getDao().saveAndFlush(entity);
	}

	@Override
	public void delete(ID id) {
		getDao().delete(id);
	}

	@Override
	public void delete(T entity) {
		getDao().delete(entity);
	}

	@Override
	public void delete(Iterable<T> entities) {
		getDao().delete(entities);
	}

	@Override
	public void deleteAll() {
		getDao().deleteAll();
	}

	public void isDelete(ID id) {
		try {
			T entity = getDao().findOne(id);
			// 私有变量 getDeclaredField()
			Field field = entity.getClass().getDeclaredField("isDelete");
			String name = field.getName(); // 获取属性的名字
			name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
			String type = field.getGenericType().toString(); // 获取属性的类型

			if (type.equals("class java.lang.Integer")) {
				Method m = entity.getClass().getMethod("get" + name);
				// Integer value = (Integer) m.invoke(entity);
				m = entity.getClass().getMethod("set" + name, Integer.class);
				m.invoke(entity, 0);
			}

			if (type.equals("class java.lang.Boolean")) {
				Method m = entity.getClass().getMethod("get" + name);
				// Boolean value = (Boolean) m.invoke(entity);
				m = entity.getClass().getMethod("set" + name, Boolean.class);
				m.invoke(entity, false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw new RuntimeException("删除回收站失败");
		}
	}

	@Override
	public T findOne(ID id) {
		return getDao().findOne(id);
	}

	@Override
	public T findOne(Specification<T> specification) {
		return getDao().findOne(specification);
	}

	@Override
	public T findOne(final String propertyName, final Object value) {
		Specification<T> specification = new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate p = cb.equal(root.get(propertyName), value);
				query.where(p);
				return query.getRestriction();
			}
		};
		return getDao().findOne(specification);
	}

	@Override
	public boolean exists(ID id) {
		return getDao().exists(id);
	}

	@Override
	public List<T> findAll() {
		return getDao().findAll();
	}

	@Override
	public List<T> findAll(Iterable<ID> ids) {
		return getDao().findAll(ids);
	}

	@Override
	public List<T> findAll(Specification<T> specification) {
		return getDao().findAll(specification);
	}

	@Override
	public List<T> findAll(Sort sort) {
		return getDao().findAll(sort);
	}

	@Override
	public List<T> findAll(Specification<T> specification, Sort sort) {
		return getDao().findAll(specification, sort);
	}

	@Override
	public List<T> findAll(String propertyName, Object value) {
		return this.findAll(propertyName, value, null).getContent();
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return getDao().findAll(pageable);
	}

	@Override
	public Page<T> findAll(Specification<T> specification, Pageable pageable) {
		return getDao().findAll(specification, pageable);
	}

	@Override
	public Page<T> findAll(final String propertyName, final Object value, Pageable pageable) {
		Specification<T> specification = new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate p = cb.equal(root.get(propertyName), value);
				query.where(p);
				return query.getRestriction();
			}
		};
		return getDao().findAll(specification, pageable);
	}

	@Override
	public long count() {
		return getDao().count();
	}

	@Override
	public long count(Specification<T> specification) {
		return getDao().count(specification);
	}

}
