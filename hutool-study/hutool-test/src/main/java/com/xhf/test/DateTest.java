package com.xhf.test;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.sql.Date;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-26 22:32
 */
public class DateTest {

    @Test
    public void test(){
        DateTime dateTime = DateUtil.date();
        Date sqlDate = dateTime.toSqlDate();
    }
}
