package com.leisure.forum.mapper;

import com.leisure.forum.entity.RoleMenuMap;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMenuMapMapper extends Mapper<RoleMenuMap> {
    List<RoleMenuMap> queryMenusByRoleIds(@Param("ids") List<Long> ids);
}