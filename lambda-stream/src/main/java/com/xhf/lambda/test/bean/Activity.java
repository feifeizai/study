package com.xhf.lambda.test.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-11 23:07
 */
@Data
@Builder
public class Activity {

    private Long id;

    /**
     * 1淘宝, 2京东
     */
    private Integer source;

    private String title;


}
