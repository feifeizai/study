package com.xhf.lambda.test.bean;

import lombok.Data;

import java.sql.Time;
import java.util.List;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-11 23:19
 */
@Data
public class ResultVO {

    List<CalendarVO> list;

    @Data
    public static class CalendarVO{
        private Long id;
        private Time startTime;
        private Time endTime;

        private List<Activity> activeList;
    }


}
