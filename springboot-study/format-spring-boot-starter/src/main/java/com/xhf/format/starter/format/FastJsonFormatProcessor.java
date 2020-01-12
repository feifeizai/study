package com.xhf.format.starter.format;

import com.alibaba.fastjson.JSON;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-1-12 21:16
 */
public class FastJsonFormatProcessor implements FormatProcessor {

    public <T> String format(T t) {
        return "FastJsonFormatProcessor:" + JSON.toJSONString(t);
    }

}
