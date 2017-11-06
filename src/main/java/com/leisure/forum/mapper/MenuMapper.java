package com.leisure.forum.mapper;

import com.leisure.forum.entity.Menu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MenuMapper extends Mapper<Menu> {
	List<Menu> queryByIds(@Param("ids") List<Long> ids);
}