package com.xhf.log.controller;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-1-8 21:41
 */
@RestController
@RequestMapping("/log")
@Slf4j
public class LogController {

    @GetMapping
    public Level getLoglevel(@RequestParam(value = "package") String packageName) {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        log.trace("trace getLoglevel({})={}", packageName, loggerContext.getLogger(packageName).getLevel());
        log.debug("debug getLoglevel({})={}", packageName, loggerContext.getLogger(packageName).getLevel());
        log.info("info getLoglevel({})={}", packageName, loggerContext.getLogger(packageName).getLevel());
        log.warn("warn getLoglevel({})={}", packageName, loggerContext.getLogger(packageName).getLevel());
        log.error("error getLoglevel({})={}", packageName, loggerContext.getLogger(packageName).getLevel());
        return loggerContext.getLogger(packageName).getLevel();
    }

    @GetMapping(value = "/loglevel/{loglevel}")
    public String loglevel(@PathVariable("loglevel") String logLevel,
                           @RequestParam(value = "package") String packageName) {
        // trace --> debug --> info --> warn --> error -->fatal
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.getLogger(packageName).setLevel(Level.valueOf(logLevel));
        return "ok";
    }

    @GetMapping(value = "/global")
    public void testLog(String globalLevel, String key, String level) {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        //设置全局日志级别
        Logger logger = loggerContext.getLogger("root");
        logger.setLevel(Level.toLevel(globalLevel));

        if (!StringUtils.isBlank(level)) {
            //设置某个类日志级别-可以实现定向日志级别调整
            Logger vLogger = loggerContext.getLogger(key);
            if (vLogger != null)
                vLogger.setLevel(Level.toLevel(level));
        }

        List<Logger> loggerList = loggerContext.getLoggerList();
        loggerList.stream().forEach(System.out::println);
    }
}
