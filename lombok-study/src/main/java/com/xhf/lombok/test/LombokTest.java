package com.xhf.lombok.test;

import com.xhf.lombok.entity.User;
import org.junit.Test;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-19 20:51
 */
public class LombokTest {

    @Test
    public void builderTest(){
        User user = new User();
        user.setId(1L);
        System.out.println(user.toString());
    }

}
