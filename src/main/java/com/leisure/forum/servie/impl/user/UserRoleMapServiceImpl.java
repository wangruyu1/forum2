package com.leisure.forum.servie.impl.user;

import com.leisure.forum.entity.UserRoleMap;
import com.leisure.forum.exception.ServiceException;
import com.leisure.forum.mapper.UserRoleMapMapper;
import com.leisure.forum.servie.user.UserRoleMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * wangruyu
 * 2017/11/5 下午4:36
 */
@Service
public class UserRoleMapServiceImpl implements UserRoleMapService {
    @Autowired
    private UserRoleMapMapper userRoleMapMapper;

    @Override
    public List<UserRoleMap> queryByUserId(Long userId) throws ServiceException {
        UserRoleMap userRoleMap = new UserRoleMap();
        userRoleMap.setUserId(userId);
        return userRoleMapMapper.select(userRoleMap);
    }
}
