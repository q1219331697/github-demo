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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my373.core.AppForm;
import com.my373.core.base.BaseController;
import com.my373.core.base.BaseRestful;
import com.my373.domain.Resc;
import com.my373.domain.Role;
import com.my373.domain.RoleResc;
import com.my373.domain.User;
import com.my373.domain.UserRole;
import com.my373.service.UserRoleService;
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
	@Resource
	private UserRoleService userRoleService;

	@RequestMapping(value = { "", "/index" })
	public String index(AppForm form, Model model, HttpServletRequest request, HttpServletResponse response) {
		userService.findAll("username", 1);
		userService.findAll(new PageRequest(0, 10));
		userService.findAll((Map<String, Object>) null, (Pageable) null);
		return "/user/index.html";
	}

	@RequestMapping(value = "/index.json", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<Node> json() {
		List<Node> nodes1 = new ArrayList<Node>(0);

		List<User> users = userService.findAll();
		for (User user : users) {
			List<Node> nodes2 = new ArrayList<Node>(0);

			Set<UserRole> userRoles = user.getUserRoles();
			for (UserRole userRole : userRoles) {
				List<Node> nodes3 = new ArrayList<Node>(0);

				Role role = userRole.getRole();
				Set<RoleResc> roleRescs = role.getRoleRescs();
				for (RoleResc roleResc : roleRescs) {
					Resc resc = roleResc.getResc();
					Node node = new Node(resc.getResId(), resc.getResTitle());
					nodes3.add(node);
				}
				Node node = new Node(role.getRoleId(), role.getRoleTitle(), nodes3);
				nodes2.add(node);
			}

			Node node = new Node(user.getUserId(), user.getUsername(), nodes2);
			nodes1.add(node);
		}
		return nodes1;
	}

	// public List<UserRole> json() {
	// List<UserRole> list = userRoleService.findAll();
	// return list;
	// }
	// public Set<UserRole> Json() {
	// Set<UserRole> set = userService.findAll().get(0).getUserRoles();
	// return set;
	// }

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
