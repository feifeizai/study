package com.xhf.format.starter.demo.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-1-12 21:47
 */
@Data
@Builder
public class User {

    private String name;

    private int age;

    private String addr;
}
