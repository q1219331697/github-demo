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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.my373.core.base.BaseDao;
import com.my373.core.base.BaseServiceImpl;
import com.my373.dao.UserRoleDao;
import com.my373.domain.UserRole;
import com.my373.service.UserRoleService;

/**
 * @author QQ:1219331697
 *
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole, Integer> implements UserRoleService {

	@Resource
	private UserRoleDao userRoleDao;

	@Override
	public BaseDao<UserRole, Integer> getDao() {
		return userRoleDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.my373.core.base.BaseServiceImpl#findAll(java.util.Map, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<UserRole> findAll(Map<String, Object> paramMap, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
