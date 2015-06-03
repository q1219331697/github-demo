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
import java.util.Map;

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
	T save(T entity);

	/**
	 * 保存多个实体
	 * 
	 * @param entities
	 * @return
	 */
	List<T> save(Iterable<T> entities);

	/**
	 * save事务结束前保存，flush立即保存
	 */
	void flush();

	T saveAndFlush(T entity);

	void delete(ID id);

	void delete(T entity);

	void delete(Iterable<T> entities);

	void deleteAll();

	T findOne(ID id);

	T findOne(Specification<T> spec);

	T findOne(String propertyName, Object value);

	boolean exists(ID id);

	List<T> findAll();

	List<T> findAll(Iterable<ID> ids);

	List<T> findAll(String propertyName, Object value);

	List<T> findAll(Sort sort);

	List<T> findAll(Specification<T> specification);

	List<T> findAll(Specification<T> specification, Sort sort);

	Page<T> findAll(Pageable pageable);

	Page<T> findAll(Specification<T> specification, Pageable pageable);

	Page<T> findAll(String propertyName, Object value, Pageable pageable);

	/**
	 * 条件查询
	 * 
	 * @param paramMap
	 * @param pageable
	 * @return
	 */
	Page<T> findAll(Map<String, Object> paramMap, Pageable pageable);

	long count();

	long count(Specification<T> spec);
}
