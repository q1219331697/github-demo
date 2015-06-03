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

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 角色 Role
 * 
 * @author QQ:1219331697
 *
 */
@Entity
@Table(name = "tb_role")
public class Role implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Integer roleId;

	/**
	 * 标题
	 */
	private String roleTitle;

	/**
	 * 备注
	 */
	private String remark;

	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

	public Role() {
	}

	/**
	 * 主键
	 */
	@Id
	@GeneratedValue
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * 主键
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * 标题
	 */
	@Column(length = 16)
	public String getRoleTitle() {
		return roleTitle;
	}

	/**
	 * 标题
	 */
	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}

	/**
	 * 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the userRoles
	 */
	@OneToMany(mappedBy = "role")
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	/**
	 * @param userRoles
	 *            the userRoles to set
	 */
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}
