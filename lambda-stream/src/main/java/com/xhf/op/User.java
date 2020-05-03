package com.xhf.op;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-3-13 21:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Integer id;

    private String name;

    private Integer age;
}
