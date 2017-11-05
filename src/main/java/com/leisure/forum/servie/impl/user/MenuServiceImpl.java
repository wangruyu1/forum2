package com.leisure.forum.servie.impl.user;

import com.leisure.forum.entity.Menu;
import com.leisure.forum.exception.ServiceException;
import com.leisure.forum.mapper.MenuMapper;
import com.leisure.forum.servie.user.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * wangruyu
 * 2017/11/5 下午5:23
 */
@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> queryMenusByIds(List<Long> ids) throws ServiceException {
        if(ids == null || ids.size() < 1){
            return null;
        }
        return menuMapper.queryByIds(ids);
    }
}
