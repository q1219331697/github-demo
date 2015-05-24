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

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 部门
 * 
 * @author QQ:1219331697
 *
 */
@Entity
@Table(name = "tb_department")
public class Department implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 部门ID
	 */
	private Integer deptId;

	/**
	 * 部门标题
	 */
	private String deptTitle;

	/**
	 * 备注
	 */
	private String remark;

	private Set<UserDept> userDepts = new HashSet<UserDept>(0);

	public Department() {
	}

	/**
	 * 部门ID
	 */
	@Id
	@GeneratedValue
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * 部门ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * 部门标题
	 */
	public String getDeptTitle() {
		return deptTitle;
	}

	/**
	 * 部门标题
	 */
	public void setDeptTitle(String deptTitle) {
		this.deptTitle = deptTitle;
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
	 * @return the userDepts
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	public Set<UserDept> getUserDepts() {
		return userDepts;
	}

	/**
	 * @param userDepts
	 *            the userDepts to set
	 */
	public void setUserDepts(Set<UserDept> userDepts) {
		this.userDepts = userDepts;
	}

}
