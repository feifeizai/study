package com.xhf.controller;

import com.xhf.config.Constant;
import com.xhf.config.NacosConstants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 谢红飞
 * date 2020-9-6
 */
@RestController
public class ConstantController {

    @GetMapping("/t1")
    public Map<String, Object> test1() {
        Map<String, Object> result = new HashMap<>();

        result.put("string" , Constant.TEST);
        result.put("list" , Constant.TEST_LIST);
        result.put("map" , Constant.TEST_MAP);
        result.put("list_int" , Constant.TEST_LIST_INT);
        result.put("code" , 1);
        result.put("int" , Constant.TEST_INT);
        result.put("Long" , Constant.TEST_LONG);
        return result;
    }

    @GetMapping("/t2")
    public Map<String, Object> test2() {
        Map<String, Object> result = new HashMap<>();

        result.put("string" , NacosConstants.TEST);
        result.put("list" , NacosConstants.TEST_LIST);
        result.put("map" , NacosConstants.TEST_MAP);
        result.put("list_int" , NacosConstants.TEST_LIST_INT);
        result.put("code" , 1);
        result.put("int" , NacosConstants.TEST_INT);
        result.put("Long" , NacosConstants.TEST_LONG);
        return result;
    }

}
