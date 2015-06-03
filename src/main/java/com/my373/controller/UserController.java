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

package com.my373.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my373.core.AppForm;
import com.my373.core.base.BaseController;
import com.my373.core.base.BaseRestful;
import com.my373.service.UserService;

/**
 * @author QQ:1219331697
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController implements BaseRestful<Integer> {

	@Resource
	private UserService userService;

	@RequestMapping(value = { "", "/index" })
	public String index(AppForm form, Model model, HttpServletRequest request, HttpServletResponse response) {
		userService.findAll("username", 1);
		userService.findAll(new PageRequest(0, 10));
		userService.findAll((Map<String, Object>) null, (Pageable) null);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.my373.core.base.BaseRestful#show(java.lang.Object, org.springframework.ui.Model,
	 * javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String show(Integer id, Model model, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.my373.core.base.BaseRestful#editNew(org.springframework.ui.Model, javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String editNew(Model model, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.my373.core.base.BaseRestful#create(com.my373.core.AppForm, org.springframework.ui.Model,
	 * javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String create(AppForm form, Model model, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.my373.core.base.BaseRestful#edit(java.lang.Object, org.springframework.ui.Model,
	 * javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String edit(Integer id, Model model, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.my373.core.base.BaseRestful#update(java.lang.Object, com.my373.core.AppForm,
	 * org.springframework.ui.Model, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String update(Integer id, AppForm form, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.my373.core.base.BaseRestful#destroy(java.lang.Object, org.springframework.ui.Model,
	 * javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String destroy(Integer id, Model model, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
