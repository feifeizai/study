package com.xhf.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-12-14 20:48
 */
public class MapTest {


    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //list.stream().map((x) -> x*x).forEach(System.out::println);

        list.stream().filter(num -> num - 3 > 0).map((x) -> x * x).forEach(System.out::println);

        ArrayList<Integer> list1 = new ArrayList<>(list);
        Integer remove = list1.remove(0);
        System.out.println(remove);
        System.out.println(list1);

    }

    @Test
    public void test2() {
        float f = Float.parseFloat("-0.1");
        if (f <= 0) {
            System.out.println("==");
        }
    }
}
