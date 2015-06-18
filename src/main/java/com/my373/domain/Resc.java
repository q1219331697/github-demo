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
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 资源
 * 
 * @author QQ:1219331697
 *
 */
@Entity
@Table(name = "tb_resc")
public class Resc implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键 resId
	 */
	private Integer resId;

	/**
	 * 标题
	 */
	private String resTitle;

	/**
	 * 网址
	 */
	private String url;

	/**
	 * 备注
	 */
	private String remark;

	private Set<RoleResc> roleRescs = new HashSet<RoleResc>(0);

	/**
	 * 
	 */
	public Resc() {
	}

	/**
	 * 主键 resId
	 */
	@Id
	@GeneratedValue
	public Integer getResId() {
		return resId;
	}

	/**
	 * 主键 resId
	 */
	public void setResId(Integer resId) {
		this.resId = resId;
	}

	/**
	 * 标题
	 */
	public String getResTitle() {
		return resTitle;
	}

	/**
	 * 标题
	 */
	public void setResTitle(String resTitle) {
		this.resTitle = resTitle;
	}

	/**
	 * 网址
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 网址
	 */
	public void setUrl(String url) {
		this.url = url;
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
	 * @return the roleRescs
	 */
	@OneToMany(mappedBy = "resc")
	public Set<RoleResc> getRoleRescs() {
		return roleRescs;
	}

	/**
	 * @param roleRescs
	 *            the roleRescs to set
	 */
	public void setRoleRescs(Set<RoleResc> roleRescs) {
		this.roleRescs = roleRescs;
	}

}
