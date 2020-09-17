package com.xhf.cache.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-12-20 23:36
 */
@Data
@Builder
public class Emp {

    private Long id;

    private String name;

    private String addr;

}
