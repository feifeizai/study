package com.xhf.mybatis.mapper;

import com.xhf.mybatis.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {

    public List<Permission> findPermissionById(List<Integer> permissionIds);

    public List<Permission> findPermission(Integer roleId);

}
