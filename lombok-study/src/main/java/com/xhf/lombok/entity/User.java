package com.xhf.lombok.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-19 20:49
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String name;

    private String addr;


}
