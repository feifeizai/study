package com.xhf.test;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-6 23:48
 */
public class StrTest {

    @Test
    public void strtest1() {
        String s = "HelloWorld";
        String s1 = StrUtil.toUnderlineCase(s);
        System.out.println("s1:" + s1);
    }
}
