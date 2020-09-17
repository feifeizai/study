package com.xhf.lombok.entity;

import lombok.*;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-19 20:56
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(of = {"id", "name"})
@EqualsAndHashCode(exclude = {"addr", "name"})
public class Student {

    private Long id;

    private String name;

    private String addr;

}
