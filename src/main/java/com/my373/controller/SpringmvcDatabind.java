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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my373.core.AppForm;
import com.my373.core.base.BaseController;
import com.my373.domain.User;

/**
 * SpringmvcDatabind
 * 
 * @author QQ:1219331697
 *
 */
@Controller
@RequestMapping("/springmvc/databind")
public class SpringmvcDatabind extends BaseController {

	@RequestMapping("")
	public String index(User so, Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.debug(so.getUsername());
		return "springmvc-databind.html";
	}

	public String show(Integer id, Model model, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	public String editNew(Model model, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(AppForm form, Model model, HttpServletRequest request, HttpServletResponse response) {
		// Map<String, User> map = request.getp

		// User[] users2 = users.getUsers();
		List<User> users = form.getUsers();
		User user1 = form.getUser();
		
		// logger.debug("{}", users.length);
		for (User user : users) {
			logger.debug(user.getUsername());
		}
		return null;
	}

	public String edit(Integer id, Model model, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	public String update(Integer id, User entity, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	public String destroy(Integer id, Model model, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
