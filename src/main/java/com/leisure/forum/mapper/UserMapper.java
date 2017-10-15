package com.leisure.forum.mapper;

import com.leisure.forum.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    UserDetails queryByForumName(@Param("forumName") String username);
}