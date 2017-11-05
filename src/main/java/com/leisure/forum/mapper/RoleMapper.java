package com.leisure.forum.mapper;

import com.leisure.forum.entity.Role;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {
    List<Role> queryByRoleIds(@Param("ids") List<Long> ids);
}