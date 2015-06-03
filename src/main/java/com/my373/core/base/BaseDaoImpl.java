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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

/**
 * 个性化定制dao实现类
 * 
 * @author QQ:1219331697
 *
 */
public class BaseDaoImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements
		BaseDao<T, ID> {

	/**
	 * PersistenceContext是注入一坨保存实体类状态的数据结构，针对实体类的不同状态(四种,managedh或detached等)可以做出不同的反应(merge,persist等等)，其实就是把数据从数据库里提出，
	 * 然后在内存里处理的，再返回数据库的法则。 <br>
	 * 注入的是实体管理器，执行持久化操作的。
	 * <p>
	 * UserDao和OrderDao中的entityManager对象关联的PersistenceContext是同一个实例，其实这2个entityManager也是指向容器中的同一个EntityManager实例,
	 * 但是UserDao中的entityManager和entityManager2却是不同的EntityManager实例 。 <br>
	 * 在同一个类中多次定义 ， JAVAEE容器会为他们分配不同的EntityManager实例，无则新建，而这2个实例所关联的PersistenceContext对象却是同一个 。
	 */
	@PersistenceContext
	private EntityManager entityManager;

	public BaseDaoImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}

	// 1：在[接口]中加入自己需要的方法，比如：
	// public Page<Object[]> getByCondition(UserQueryModel u);
	// 2：写一个与[接口同名的类]，加上后缀为Impl(默认配置是Impl)，这个在前面xml里面配置过，可以自动被扫描到。这个类不需要实现任何接口。
	// <repositories base-package="com.my373.repository" repository-impl-postfix="Impl" />
	// 3：在实现类中，去实现这个方法就好了，会被自动找到
	// public class UserRepositoryImpl {
	// @PersistenceContext
	// private EntityManager em;
	// public Page<Object[]> getByCondition(UserQueryModel u){
	// String hql = "select o.uuid,o.name from UserModel o where 1=1 and o.uuid=:uuid";
	// Query q = em.createQuery(hql);
	// q.setParameter("uuid", u.getUuid());
	// q.setFirstResult(0);
	// q.setMaxResults(1);
	// Page<Object[]> page = new PageImpl<Object[]>(q.getResultList(),new PageRequest(0,1),3);
	// return page;
	// }}

	// 官方例子是实现了接口
	// interface UserRepositoryCustom {
	// public void someCustomMethod(User user);
	// }
	//
	// class UserRepositoryImpl implements UserRepositoryCustom {
	// public void someCustomMethod(User user) {
	// // Your custom implementation
	// }
	// }
}
