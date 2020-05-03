package com.xhf.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-2 15:27
 */
@Data
@Builder
@Entity
@Table(name = "usa_bank")
public class UsaBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user")
    private String user;

    @Column(name = "acount")
    private Integer acount;

}
