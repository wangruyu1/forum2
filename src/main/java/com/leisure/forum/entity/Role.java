package com.leisure.forum.entity;

import javax.persistence.*;

@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 角色名称
	 */
	@Column(name = "role_name")
	private String roleName;

	/**
	 * 角色code
	 */
	@Column(name = "role_code")
	private String roleCode;
	@Column(name = "description")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取角色名称
	 *
	 * @return role_name - 角色名称
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 设置角色名称
	 *
	 * @param roleName
	 *            角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	/**
	 * 获取角色code
	 *
	 * @return role_code - 角色code
	 */
	public String getRoleCode() {
		return roleCode;
	}

	/**
	 * 设置角色code
	 *
	 * @param roleCode
	 *            角色code
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode == null ? null : roleCode.trim();
	}
}