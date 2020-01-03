package com.xhf.cache.service;

import com.xhf.cache.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-12-22 0:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpServiceTest {

    @Autowired
    private EmpService empService;

    @Test
    public void getEmpById() {

        Emp e1 = empService.getEmpById(1L);
        Emp e2 = empService.getEmpById(1L);

        Emp e3 = empService.getEmpById(3L);
        Emp e4 = empService.getEmpById(3L);


        Emp e6 = empService.getEmpById(6L);
        e6 = empService.getEmpById(6L);


    }

}