package com.xhf.format.starter.format;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-1-12 21:11
 */
public interface FormatProcessor {

    <T> String format(T t);

}
