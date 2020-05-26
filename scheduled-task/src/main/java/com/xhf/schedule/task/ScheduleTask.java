package com.xhf.schedule.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 谢红飞
 * @Title:
 * @Package
 * @Description:
 * @date 2019-8-30 23:49
 */
@Component
@EnableScheduling
public class ScheduleTask {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //@Scheduled(fixedDelay=3000)
    public void fixedDelay() {
        System.out.println("定时任务延迟 fixedDelay:" + format.format(new Date()));
    }

    //@Scheduled(cron = "0/5 * * * * ?")
    public void cron() {
        System.out.println("定时任务延迟 cron:" + format.format(new Date()));
    }

}
