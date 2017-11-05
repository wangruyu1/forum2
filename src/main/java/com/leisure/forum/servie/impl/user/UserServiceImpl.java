package com.leisure.forum.servie.impl.user;

import com.leisure.forum.entity.*;
import com.leisure.forum.exception.ServiceException;
import com.leisure.forum.mapper.UserMapper;
import com.leisure.forum.servie.user.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author wangruyu
 *
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleMapService userRoleMapService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMenuMapService roleMenuMapService;
    @Autowired
    private MenuService menuService;

    public UserServiceImpl() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.queryByForumName(username);
    }

    @Override
    public boolean add(User user) throws ServiceException{
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.insert(user) > 0;
    }

    @Override
    public List<Role> queryRolesByUserName(String userName) throws ServiceException {
        List<Role> roles = new ArrayList<>();
        Optional<User> user = Optional.ofNullable((User) this.loadUserByUsername(userName));
        if(user.isPresent()){
            List<UserRoleMap> userRoleMaps = userRoleMapService.queryByUserId(user.get().getId());
            if(userRoleMaps != null && userRoleMaps.size() > 0){
                List<Long> roleIds = userRoleMaps.stream().map(UserRoleMap::getRoleId).collect(Collectors.toList());
                roles = roleService.queryByRoleIds(roleIds);
            }

        }
        return roles;
    }

    @Override
    public List<Menu> queryMenusByRoles(List<Role> roles) throws ServiceException {
        List<Menu> menus = new ArrayList<>();
        if(roles != null && roles.size() > 0){
            List<Long> ids = roles.stream().map(Role::getId).collect(Collectors.toList());
            List<RoleMenuMap> roleMenuMaps = roleMenuMapService.queryMenusByRoleIds(ids);
            menus = menuService.queryMenusByIds(ids);
        }
        return menus;
    }
}
