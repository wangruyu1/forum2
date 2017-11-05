package com.leisure.forum.mapper;

import com.leisure.forum.entity.Menu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MenuMapper extends Mapper<Menu> {
    List<Menu> queryByIds(List<Long> ids);
}