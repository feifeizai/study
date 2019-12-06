package com.xhf.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 谢红飞
 * @Title:
 * @Package
 * @Description:
 * @date 2019-4-22 21:31
 */
@Data
public class Permission implements Serializable {

    private Integer permissionId;

    private String permissionName;

}
