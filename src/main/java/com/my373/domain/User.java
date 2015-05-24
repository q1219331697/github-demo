/**
 * 
 */

package com.my373.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User
 * 
 * @author QQ:1219331697
 *
 */
@Entity
@Table(name = "tb_user")
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	private Integer userId;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 状态 1=正常，0=锁定
	 */
	private Integer status;

	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

	public User() {
	}

	/**
	 * 用户id
	 */
	@Id
	@GeneratedValue
	public Integer getUserId() {
		return userId;
	}

	/**
	 * 用户id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 用户名
	 */
	@Column(length = 32)
	public String getUsername() {
		return username;
	}

	/**
	 * 用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 密码
	 */
	@Column(length = 32)
	public String getPassword() {
		return password;
	}

	/**
	 * 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 状态 1=正常，0=锁定
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 状态 1=正常，0=锁定
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the userRoles
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
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
