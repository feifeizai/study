package com.xhf.schedule.task;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author 谢红飞
 * @date 2019-8-31 0:00
 */
@Component
public class DynamicScheduleTask implements SchedulingConfigurer {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * todo 动态获取下次的延迟时间
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                // 任务逻辑
                System.out.println("dynamicCronTask is running:"+format.format(new Date()));
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                //获取时间

                //1. cron表达式 0/5 * * * * ?
                CronTrigger trigger = new CronTrigger("0/5 * * * * ?");
                //2. 延迟时间
                //PeriodicTrigger trigger = new PeriodicTrigger(5, TimeUnit.SECONDS);

                Date nextExec = trigger.nextExecutionTime(triggerContext);
                return nextExec;
            }
        });

    }
}
