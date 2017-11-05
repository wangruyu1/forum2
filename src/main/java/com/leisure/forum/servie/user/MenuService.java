package com.leisure.forum.servie.user;

import com.leisure.forum.entity.Menu;
import com.leisure.forum.exception.ServiceException;

import java.util.List;

public interface MenuService {
    List<Menu> queryMenusByIds(List<Long> ids) throws ServiceException;
}
