package com.xhf.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 谢红飞
 * @Title:
 * @Package
 * @Description:
 * @date 2019-4-22 21:29
 */
@Data
public class User implements Serializable{

    private Integer userId;

    private String userName;

    private String password;

    private Role role;

}
