package com.xhf.lambda.test;

import com.xhf.lambda.test.bean.Activity;
import com.xhf.lambda.test.bean.PlanItem;
import com.xhf.lambda.test.bean.ResultVO;
import com.xhf.lambda.test.bean.Timeline;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-11 22:51
 */
public class MapTest {

    @Test
    public void test1() {

        Activity ac1 = Activity.builder().id(1L).source(1).title("活动1").build();
        Activity ac2 = Activity.builder().id(2L).source(1).title("活动2").build();
        Activity ac3 = Activity.builder().id(3L).source(2).title("活动3").build();
        Activity ac4 = Activity.builder().id(4L).source(2).title("活动4").build();
        Activity ac5 = Activity.builder().id(5L).source(2).title("活动5").build();
        List<Activity> activeList = Arrays.asList(ac1, ac2, ac3, ac4, ac5);
        Map<Long, Activity> id2AcMap = new HashMap<>();
        activeList.stream().forEach(ac -> id2AcMap.put(ac.getId(), ac));

        Timeline t1 = Timeline.builder().id(1L).startTime(new Time(3600 * 1000 * 8)).endTime(new Time(3600 * 1000 * 12)).build();
        Timeline t2 = Timeline.builder().id(2L).startTime(new Time(3600 * 1000 * 8)).endTime(new Time(3600 * 1000 * 22)).build();
        List<Timeline> timeList = Arrays.asList(t1, t2);
        Map<Long, Timeline> id2TimeMap = new HashMap<>();
        timeList.stream().forEach(timeline -> id2TimeMap.put(timeline.getId(), timeline));

        PlanItem p1 = PlanItem.builder().id(1L).TimelineId(1L).activityId(1L).activeDate(new Date(1575907200000l)).build();
        PlanItem p2 = PlanItem.builder().id(2L).TimelineId(1L).activityId(3L).activeDate(new Date(1575907200000l)).build();
        PlanItem p3 = PlanItem.builder().id(3L).TimelineId(1L).activityId(4L).activeDate(new Date(1575907200000l)).build();
        PlanItem p4 = PlanItem.builder().id(4L).TimelineId(1L).activityId(5L).activeDate(new Date(1575907200000l)).build();
        List<PlanItem> planList = Arrays.asList(p1, p2, p3, p4);

        planList.stream().forEach(planItem -> {
            Long activityId = planItem.getActivityId();
            Long timelineId = planItem.getTimelineId();
            Activity activity = id2AcMap.get(activityId);
            Timeline timeline = id2TimeMap.get(timelineId);

            ResultVO.CalendarVO calendarVO = new ResultVO.CalendarVO();
            BeanUtils.copyProperties(timeline, calendarVO);

        });

    }


}
