package com.xhf.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 谢红飞
 * @Title:
 * @Package
 * @Description:
 * @date 2019-8-29 23:07
 */
@Data
@Entity
@Table(name = "tb_user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "created")
    private Date created;
    @Column(name = "updated")
    private Date updated;


}
