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

package com.my373.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserRole
 * 
 * @author QQ:1219331697
 *
 */
@Entity
@Table(name = "tb_user_role")
public class UserRole implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * urId 主键
	 */
	private Integer urId;

	/**
	 * 用户
	 */
	private User user;

	/**
	 * 角色
	 */
	private Role role;

	public UserRole() {
	}

	/**
	 * urId 主键
	 */
	@Id
	@GeneratedValue
	public Integer getUrId() {
		return urId;
	}

	/**
	 * urId 主键
	 */
	public void setUrId(Integer urId) {
		this.urId = urId;
	}

	/**
	 * 用户
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public User getUser() {
		return user;
	}

	/**
	 * 用户
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 角色
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId")
	public Role getRole() {
		return role;
	}

	/**
	 * 角色
	 */
	public void setRole(Role role) {
		this.role = role;
	}

}
