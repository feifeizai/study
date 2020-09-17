package com.xhf.lombok.test;

import com.xhf.lombok.entity.Student;
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

    @Test
    public void equalsTest(){
        Student xhf = Student.builder().id(1L).name("xhf").build();
        Student fff = Student.builder().id(1L).name("fff").build();
        System.out.println("xhf == fff, "+ xhf.equals(fff));
    }

    /**
     * 与@Builder一起使用单一注释在构建器中为集合创建单个元素“add”方法。
     */
    @Test
    public void singularTest(){
        User xhf = User.builder().id(1L).list(1L).list(2L).name("xhf").build();
        System.out.println(xhf.toString());
    }
}
