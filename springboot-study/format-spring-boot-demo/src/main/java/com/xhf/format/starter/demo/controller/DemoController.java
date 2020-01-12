package com.xhf.format.starter.demo.controller;

import com.xhf.format.starter.FormatTemplate;
import com.xhf.format.starter.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-1-12 21:45
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private FormatTemplate formatTemplate;

    @GetMapping
    public String get() {
        User user = User.builder().name("xhf").age(12).addr("苏州").build();
        return formatTemplate.doFormat(user);
    }

}
