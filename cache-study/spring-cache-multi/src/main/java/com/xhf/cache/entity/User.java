package com.xhf.cache.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-12-22 16:01
 */
@Data
@Builder
public class User {

    private Long id;

    private String username;
}
