package com.leisure.forum.servie.user;

import com.leisure.forum.entity.Role;
import com.leisure.forum.exception.ServiceException;

import java.util.List;

public interface RoleService {
    List<Role> queryByRoleIds(List<Long> ids) throws ServiceException;
}
