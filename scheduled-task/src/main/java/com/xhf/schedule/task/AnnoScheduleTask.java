package com.xhf.schedule.task;

import com.xhf.schedule.annotation.CronScheduled;
import com.xhf.schedule.job.ScheduleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.ScheduledMethodRunnable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-11 21:15
 */
@Slf4j
@Component
public class AnnoScheduleTask implements ApplicationContextAware, BeanFactoryAware, BeanPostProcessor, DisposableBean {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void destroy() throws Exception {
        scheduledTaskRegistrar.destroy();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Autowired
    private ScheduleJob scheduleJob;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;
    private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(50);
    ScheduledTaskRegistrar scheduledTaskRegistrar = new ScheduledTaskRegistrar();
    private boolean init = true;

    public void configureTasks() {
        log.info("configureTasks start");
        Class<?> clazz = scheduleJob.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            CronScheduled annotation = method.getAnnotation(CronScheduled.class);
            if (null == annotation) {
                continue;
            }
            String cron = annotation.cron();
            if (StringUtils.isEmpty(cron)) {
                continue;
            }
            Runnable runnable = new ScheduledMethodRunnable(scheduleJob, method);
            scheduledTaskRegistrar.addTriggerTask(new TriggerTask(runnable, triggerContext -> {
                CronTrigger trigger = new CronTrigger(cron);
                return trigger.nextExecutionTime(triggerContext);
            }));

            scheduledTaskRegistrar.setScheduler(scheduledExecutorService);
            scheduledTaskRegistrar.afterPropertiesSet();
        }
    }

    public void reRegister() {
        log.info("reRegister");
        scheduledTaskRegistrar.destroy();
        scheduledTaskRegistrar.setTriggerTasksList(new ArrayList<>());
        log.info("after destroy taskSize:{}", scheduledTaskRegistrar.getTriggerTaskList().size());
        configureTasks();
        log.info("after reRegister taskSize:{}", scheduledTaskRegistrar.getTriggerTaskList().size());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (init) {
            configureTasks();
            init = false;
        }
        return bean;
    }
}
