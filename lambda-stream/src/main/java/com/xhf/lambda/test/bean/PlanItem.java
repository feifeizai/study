package com.xhf.lambda.test.bean;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-11 23:14
 */
@Data
@Builder
public class PlanItem {

    private Long id;

    private Long activityId;

    private Long TimelineId;

    private Date activeDate;

}
