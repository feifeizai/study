package com.xhf.mybatis.service.impl;

import com.xhf.mybatis.entity.Permission;
import com.xhf.mybatis.entity.Role;
import com.xhf.mybatis.entity.User;
import com.xhf.mybatis.mapper.PermissionMapper;
import com.xhf.mybatis.mapper.RoleMapper;
import com.xhf.mybatis.mapper.UserMapper;
import com.xhf.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public User findUserById(Integer userId){

        User user = userMapper.findUserById(userId);
        System.out.println("查询到user："+user.toString());

        Integer roleId = userMapper.findRoleId(userId);
        System.out.println("用户的角色id是roleId:"+roleId);

        Role role = roleMapper.findRoleById(roleId);
        System.out.println("查询到的角色role:"+role.toString());

        List<Integer> permissionIds = roleMapper.findPermissionIds(roleId);
        System.out.println("角色拥有的权限permissionIds值:"+permissionIds.toString());

        List<Permission> permissions = permissionMapper.findPermissionById(permissionIds);
        System.out.println("查询到的权限permissions:"+permissions.toString());

        role.setPermissions(permissions);
        user.setRole(role);
        return user;
    }

    @Override
    public User findUser(Integer userId){

        User user = userMapper.findUser(userId);
        System.out.println("查询到user："+user.toString());

        return user;
    }

    @Override
    public Map<String,Object> findUserMap(Integer userId){
        return userMapper.findUserMap(userId);
    }
}
