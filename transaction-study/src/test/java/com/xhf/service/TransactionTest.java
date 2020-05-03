package com.xhf.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-2 15:46
 */
@SpringBootTest
@RunWith(value = SpringRunner.class)
public class TransactionTest {

    @Autowired
    private ChinaBankService chinaBankService;

    @Test
    public void trans() throws Exception {
        chinaBankService.outter();
    }

}
