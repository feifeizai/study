package com.xhf.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 谢红飞
 * @Title:
 * @Package
 * @Description:
 * @date 2019-4-22 21:31
 */
@Data
public class Role implements Serializable {

    private Integer roleId;

    private String roleName;

    private List<Permission> permissions;
}
