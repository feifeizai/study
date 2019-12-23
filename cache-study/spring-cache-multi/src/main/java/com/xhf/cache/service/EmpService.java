package com.xhf.cache.service;

import com.xhf.cache.entity.Emp;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-12-20 23:39
 */
@Service
public class EmpService {


    @Cacheable(value = "emp", condition = "#id>=2", key = "#id", unless = "#result==null", cacheManager = "secondManager")
    public Emp getEmpById(Long id) {

        if (id.equals(1L))
            return Emp.builder().id(1L).name("one").addr("北京").build();
        if (id.equals(2L))
            return Emp.builder().id(2L).name("two").addr("上海").build();
        if (id.equals(3L))
            return Emp.builder().id(3L).name("three").addr("广州").build();
        if (id.equals(4L))
            return Emp.builder().id(4L).name("four").addr("深圳").build();
        if (id.equals(5L))
            return Emp.builder().id(5L).name("five").addr("厦门").build();
        return null;
    }

}
