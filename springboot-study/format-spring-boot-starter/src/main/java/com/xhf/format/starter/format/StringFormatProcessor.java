package com.xhf.format.starter.format;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-1-12 21:12
 */
public class StringFormatProcessor implements FormatProcessor {

    public <T> String format(T t) {
        return "StringFormatProcessor:" + t.toString();
    }
}
