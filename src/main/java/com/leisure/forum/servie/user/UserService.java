package com.leisure.forum.servie.user;

import com.leisure.forum.entity.Menu;
import com.leisure.forum.entity.Role;
import com.leisure.forum.entity.User;
import com.leisure.forum.exception.ServiceException;

import java.util.List;

public interface UserService {
	boolean add(User user) throws ServiceException;

	List<Role> queryRolesByUserName(String userName) throws ServiceException;

	List<Menu> queryMenusByRoles(List<Role> roles) throws ServiceException;

	List<Menu> queryMenusByUserName(String userName) throws ServiceException;
}
