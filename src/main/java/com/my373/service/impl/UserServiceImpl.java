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

package com.my373.service.impl;

import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.my373.core.base.BaseDao;
import com.my373.core.base.BaseServiceImpl;
import com.my373.dao.UserDao;
import com.my373.domain.User;
import com.my373.service.UserService;

/**
 * @author QQ:1219331697
 *
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public BaseDao<User, Integer> getDao() {
		return userDao;
	}

	@Override
	public Page<User> findAll(Map<String, Object> paramMap, Pageable pageable) {
		Specification<User> specification = new Specification<User>() {

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				return null;
			}
		};

		return userDao.findAll(specification, pageable);
	}

}
