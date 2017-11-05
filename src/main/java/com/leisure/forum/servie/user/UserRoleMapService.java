package com.leisure.forum.servie.user;

import com.leisure.forum.entity.UserRoleMap;
import com.leisure.forum.exception.ServiceException;

import java.util.List;

public interface UserRoleMapService {
    List<UserRoleMap> queryByUserId(Long userId) throws ServiceException;
}
