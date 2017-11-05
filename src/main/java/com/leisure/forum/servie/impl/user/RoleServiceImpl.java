package com.leisure.forum.servie.impl.user;

import com.leisure.forum.entity.Role;
import com.leisure.forum.exception.ServiceException;
import com.leisure.forum.mapper.RoleMapper;
import com.leisure.forum.servie.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * wangruyu
 * 2017/11/5 下午4:59
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> queryByRoleIds(List<Long> ids) throws ServiceException {
        return roleMapper.queryByRoleIds(ids);
    }
}
