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

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author QQ:1219331697
 *
 */
@Entity
@Table(name = "tb_role_resc")
public class RoleResc implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Integer rnId;

	/**
	 * 角色
	 */
	private Role role;

	/**
	 * 节点
	 */
	private Resc resc;

	/**
	 * 
	 */
	public RoleResc() {
	}

	/**
	 * 主键
	 */
	@Id
	@GeneratedValue
	public Integer getRnId() {
		return rnId;
	}

	/**
	 * 主键
	 */
	public void setRnId(Integer rnId) {
		this.rnId = rnId;
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

	/**
	 * 节点
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resId")
	public Resc getResc() {
		return resc;
	}

	/**
	 * 节点
	 */
	public void setResc(Resc resc) {
		this.resc = resc;
	}

}
