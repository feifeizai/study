package com.xhf.lombok.entity;

import lombok.*;

import java.util.List;

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

    /**
     * 1.变量名最后必须以s结尾
     * 2.@Singular只有在@Builder下面才能使用
     */
    @Singular
    private List<Long> lists;
}
