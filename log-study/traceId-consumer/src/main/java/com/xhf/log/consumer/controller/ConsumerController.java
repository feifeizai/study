package com.xhf.log.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-29 22:16
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @GetMapping
    public String get(){
        log.info("===consumer打印日志===");
        return "consumer";
    }
}
