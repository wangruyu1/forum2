package com.leisure.forum.servie.impl.user;

import com.leisure.forum.entity.RoleMenuMap;
import com.leisure.forum.exception.ServiceException;
import com.leisure.forum.mapper.RoleMenuMapMapper;
import com.leisure.forum.servie.user.RoleMenuMapService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * wangruyu
 * 2017/11/5 下午5:13
 */
public class RoleMenuMapServiceImpl implements RoleMenuMapService{
    @Autowired
    private RoleMenuMapMapper roleMenuMapMapper;
    @Override
    public List<RoleMenuMap> queryMenusByRoleIds(List<Long> ids) throws ServiceException {
        return roleMenuMapMapper.queryMenusByRoleIds(ids);
    }
}
