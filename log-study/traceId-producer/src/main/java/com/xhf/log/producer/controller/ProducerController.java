package com.xhf.log.producer.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import com.xhf.log.producer.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-29 21:17
 */
@Slf4j
@RestController
@RequestMapping("/producer")
public class ProducerController {

    @GetMapping
    public String get(){
        log.info("===producer打印日志===");
        HttpRequest request = HttpUtil.createRequest(Method.GET, "http://localhost:8081/consumer");
        request.header("traceid", MDC.get(Constants.TRACE_ID));
        HttpResponse response = request.execute();
        String body = response.body();
        return body;
    }
}
