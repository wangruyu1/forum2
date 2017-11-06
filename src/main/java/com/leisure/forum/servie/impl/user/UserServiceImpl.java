package com.leisure.forum.servie.impl.user;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.leisure.forum.constant.AppConstant;
import com.leisure.forum.entity.Menu;
import com.leisure.forum.entity.Role;
import com.leisure.forum.entity.RoleMenuMap;
import com.leisure.forum.entity.User;
import com.leisure.forum.entity.UserRoleMap;
import com.leisure.forum.exception.ServiceException;
import com.leisure.forum.mapper.UserMapper;
import com.leisure.forum.servie.user.MenuService;
import com.leisure.forum.servie.user.RoleMenuMapService;
import com.leisure.forum.servie.user.RoleService;
import com.leisure.forum.servie.user.UserRoleMapService;
import com.leisure.forum.servie.user.UserService;
import com.leisure.forum.util.EmptyUtil;

/**
 * @author wangruyu
 *
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRoleMapService userRoleMapService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleMenuMapService roleMenuMapService;
	@Autowired
	private MenuService menuService;

	public UserServiceImpl() {
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userMapper.queryByForumName(username);
	}

	@Override
	public boolean add(User user) throws ServiceException {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userMapper.insert(user) > 0;
	}

	@Override
	public List<Role> queryRolesByUserName(String userName) throws ServiceException {
		List<Role> roles = new ArrayList<>();
		Optional<User> user = Optional.ofNullable((User) this.loadUserByUsername(userName));
		if (user.isPresent()) {
			List<UserRoleMap> userRoleMaps = userRoleMapService.queryByUserId(user.get().getId());
			if (userRoleMaps != null && userRoleMaps.size() > 0) {
				List<Long> roleIds = userRoleMaps.stream().map(UserRoleMap::getRoleId).collect(Collectors.toList());
				roles = roleService.queryByRoleIds(roleIds);
			}

		}
		return roles;
	}

	@Override
	public List<Menu> queryMenusByRoles(List<Role> roles) throws ServiceException {
		List<Menu> menus = new ArrayList<>();
		if (roles != null && roles.size() > 0) {
			List<Long> ids = roles.stream().map(Role::getId).collect(Collectors.toList());
			List<RoleMenuMap> roleMenuMaps = roleMenuMapService.queryMenusByRoleIds(ids);
			List<Long> menuIds = roleMenuMaps.stream().map(RoleMenuMap::getMenuId).distinct()
					.collect(Collectors.toList());
			menus = menuService.queryMenusByIds(menuIds);
		}
		formatMenus(menus);
		return menus;
	}

	private static void formatMenus(List<Menu> menus) {
		if (EmptyUtil.isEmpty(menus)) {
			return;
		}
		Map<String, Menu> menuMap = new HashMap<>();
		menus.forEach(m -> {
			menuMap.put(m.getId().toString(), m);
		});
		menus.clear();
		// 将菜单按照层级显示
		menuMap.forEach((key, value) -> {
			String subMenuIdStr = value.getIncludes();
			if (value.getParentId() == AppConstant.ROOT_MENU_PARENT_ID) {
				menus.add(value);
			}
			if (EmptyUtil.isEmpty(subMenuIdStr)) {
				return;
			}
			String[] menuIds = subMenuIdStr.split(AppConstant.SUB_MENU_DELIMITER);
			for (String id : menuIds) {
				Menu m = menuMap.get(id);
				if (m != null) {
					value.getSubMenus().add(m);
				}
			}
		});
		// 对菜单按照order进行排序
		menus.forEach(m -> {
			m.getSubMenus().sort(new MenuComparator());
		});
	}

	private static class MenuComparator implements Comparator<Menu> {

		@Override
		public int compare(Menu m1, Menu m2) {
			if (m1.getOrder() == m2.getOrder()) {
				return 0;
			}
			if (m1.getOrder() > m2.getOrder()) {
				return 1;
			}
			if (m1.getOrder() < m2.getOrder()) {
				return -1;
			}
			return 0;
		}

	}

	@Override
	public List<Menu> queryMenusByUserName(String userName) throws ServiceException {
		List<Role> roles = this.queryRolesByUserName(userName);
		List<Menu> menus = this.queryMenusByRoles(roles);
		return menus;
	}
}
