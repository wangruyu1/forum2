package com.leisure.forum.servie.user;

import com.leisure.forum.entity.RoleMenuMap;
import com.leisure.forum.exception.ServiceException;

import java.util.List;

public interface RoleMenuMapService {
    List<RoleMenuMap> queryMenusByRoleIds(List<Long> ids) throws ServiceException;
}
