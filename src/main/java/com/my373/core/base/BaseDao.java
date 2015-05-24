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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <a href= "http://docs.spring.io/spring-data/jpa/docs/1.8.0.RELEASE/reference/html/"
 * >http://docs.spring.io/spring-data/jpa/docs/1.8.0.RELEASE/reference/html/</a>
 * 
 * @author QQ:1219331697
 *
 */
public interface BaseDao<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

	// find…By, read…By, query…By, count…By, and get…By

	// List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);
	// x.address.zipCode 使用 _ 避免歧义
	// // List<Person> findByAddressZipCode(ZipCode zipCode);
	// List<Person> findByAddress_ZipCode(ZipCode zipCode);
	//
	// // Enables the distinct flag for the query
	// List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
	// List<Person> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);
	//
	// // Enabling ignoring case for an individual property
	// List<Person> findByLastnameIgnoreCase(String lastname);
	// // Enabling ignoring case for all suitable properties
	// List<Person> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);
	//
	// // Enabling static ORDER BY for a query
	// List<Person> findByLastnameOrderByFirstnameAsc(String lastname);
	// List<Person> findByLastnameOrderByFirstnameDesc(String lastname);

	// Pageable, Sort
	// Page<User> findByLastname(String lastname, Pageable pageable);
	//
	// Slice<User> findByLastname(String lastname, Pageable pageable);
	//
	// List<User> findByLastname(String lastname, Sort sort);
	//
	// List<User> findByLastname(String lastname, Pageable pageable);

	// Top and First
	// User findFirstByOrderByLastnameAsc();
	//
	// User findTopByOrderByAgeDesc();
	//
	// Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);
	//
	// Slice<User> findTop3ByLastname(String lastname, Pageable pageable);
	//
	// List<User> findFirst10ByLastname(String lastname, Sort sort);
	//
	// List<User> findTop10ByLastname(String lastname, Pageable pageable);

	// Stream the result of a query with Java 8 Stream<T>
	// @Query("select u from User u")
	// Stream<User> findAllByCustomQueryAndStream();
	//
	// Stream<User> readAllByFirstnameNotNull();
	//
	// @Query("select u from User u")
	// Stream<User> streamAllPaged(Pageable pageable);

	// Specifications for a User
	// Specification<User> specification = new Specification<User>() {
	// public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
	// Predicate p = cb.equal(root.get("username"), username);
	// query.where(p);
	// query.orderBy(cb.asc(root.get("userId")));
	// return query.getRestriction();
	// }
	// };
}
