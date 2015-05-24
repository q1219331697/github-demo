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
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author QQ:1219331697
 *
 */
public interface BaseService<T, ID extends Serializable> {

	/**
	 * 保存单个实体
	 * <p>
	 * 添加或修改，SaveOrUpdate
	 * 
	 * @param entity
	 * @return
	 */
	<S extends T> S save(S entity);

	/**
	 * 保存多个实体
	 * 
	 * @param entities
	 * @return
	 */
	<S extends T> List<S> save(Iterable<S> entities);

	/**
	 * 使用save方法代替
	 * 
	 * @param entity
	 * @return
	 */
	@Deprecated
	<S extends T> S add(S entity);

	@Deprecated
	<S extends T> S edit(S entity);

	void flush();

	<S extends T> S saveAndFlush(S entity);

	void delete(ID id);

	void delete(T entity);

	void delete(Iterable<T> entities);

	void deleteAll();

	/**
	 * 作废
	 */
	void invalid(ID id);

	T findOne(ID id);

	T findOne(Specification<T> spec);

	T findOne(String propertyName, Object value);

	boolean exists(ID id);

	/**
	 * 用findone(ID id)代替
	 */
	@Deprecated
	T findById(ID id);

	List<T> findAll();

	List<T> findAll(Iterable<ID> ids);

	List<T> findAll(String propertyName, Object value);

	List<T> findAll(Sort sort);

	List<T> findAll(Specification<T> spec);

	List<T> findAll(Specification<T> spec, Sort sort);

	Page<T> findAll(Pageable pageable);

	Page<T> findAll(Specification<T> spec, Pageable pageable);

	Page<T> findAll(String propertyName, Object value, Pageable pageable);

	long count();

	long count(Specification<T> spec);
}
