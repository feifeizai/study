package com.xhf.schedule.job;

import com.xhf.schedule.annotation.CronScheduled;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-11 21:00
 */
@Slf4j
@Component("scheduleJob")
public class ScheduleJob {

    @CronScheduled(cron = "0/5 * * * * ?", desc = "定时计算花费")
    public void computeCostLimitDay(){
        System.out.println("computeCostLimitDay start");
    }

}
