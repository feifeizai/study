package com.xhf.lambda;

import org.junit.Test;

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

        list.stream().map((x) -> x * x).forEach(System.out::println);

    }
}
