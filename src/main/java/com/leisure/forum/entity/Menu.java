package com.leisure.forum.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "menu")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 菜单名称
	 */
	@Column(name = "menu_name")
	private String menuName;

	/**
	 * 菜单图标
	 */
	private String icon;

	/**
	 * 菜单请求路径
	 */
	private String rooter;

	/**
	 * 子菜单,用,分隔。例如1,2,3表示该菜单的直接孩子为id为1,2,3的菜单。
	 */
	private String includes;

	/**
	 * 父菜单id，-1表示根菜单。
	 */
	@Column(name = "parent_id")
	private Long parentId;

	/**
	 * -1=无效的菜单。
	 */
	private Long status;
	@Column(name = "order")
	private Integer order;

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	@Transient
	private List<Menu> subMenus = new ArrayList<>();

	public List<Menu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<Menu> subMenus) {
		this.subMenus = subMenus;
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
	 * 获取菜单名称
	 *
	 * @return menu_name - 菜单名称
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * 设置菜单名称
	 *
	 * @param menuName
	 *            菜单名称
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName == null ? null : menuName.trim();
	}

	/**
	 * 获取菜单图标
	 *
	 * @return icon - 菜单图标
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * 设置菜单图标
	 *
	 * @param icon
	 *            菜单图标
	 */
	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	/**
	 * 获取菜单请求路径
	 *
	 * @return rooter - 菜单请求路径
	 */
	public String getRooter() {
		return rooter;
	}

	/**
	 * 设置菜单请求路径
	 *
	 * @param rooter
	 *            菜单请求路径
	 */
	public void setRooter(String rooter) {
		this.rooter = rooter == null ? null : rooter.trim();
	}

	/**
	 * 获取子菜单,用,分隔。例如1,2,3表示该菜单的直接孩子为id为1,2,3的菜单。
	 *
	 * @return includes - 子菜单,用,分隔。例如1,2,3表示该菜单的直接孩子为id为1,2,3的菜单。
	 */
	public String getIncludes() {
		return includes;
	}

	/**
	 * 设置子菜单,用,分隔。例如1,2,3表示该菜单的直接孩子为id为1,2,3的菜单。
	 *
	 * @param includes
	 *            子菜单,用,分隔。例如1,2,3表示该菜单的直接孩子为id为1,2,3的菜单。
	 */
	public void setIncludes(String includes) {
		this.includes = includes == null ? null : includes.trim();
	}

	/**
	 * 获取父菜单id，-1表示根菜单。
	 *
	 * @return parent_id - 父菜单id，-1表示根菜单。
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 设置父菜单id，-1表示根菜单。
	 *
	 * @param parentId
	 *            父菜单id，-1表示根菜单。
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取-1=无效的菜单。
	 *
	 * @return status - -1=无效的菜单。
	 */
	public Long getStatus() {
		return status;
	}

	/**
	 * 设置-1=无效的菜单。
	 *
	 * @param status
	 *            -1=无效的菜单。
	 */
	public void setStatus(Long status) {
		this.status = status;
	}
}