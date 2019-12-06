package com.xhf.mybatis.mapper;

import com.xhf.mybatis.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    public Role findRoleById(Integer roleId);

    public List<Integer> findPermissionIds(Integer roleId);

    public Role findRole(Integer userId);

}
