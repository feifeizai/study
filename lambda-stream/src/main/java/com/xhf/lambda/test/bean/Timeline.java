package com.xhf.lambda.test.bean;

import lombok.Builder;
import lombok.Data;

import java.sql.Time;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-11 23:09
 */
@Data
@Builder
public class Timeline {

    private Long id;

    private Time startTime;

    private Time endTime;

}
