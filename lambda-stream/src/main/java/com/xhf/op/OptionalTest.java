package com.xhf.op;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-3-13 21:39
 */
public class OptionalTest {

    @Test
    public void test1() {

//        String name = "test1";
        String name = null;
        Optional<String> op = Optional.ofNullable(name);

        System.out.println(op.get());
    }

    @Test
    public void test2() {
        Optional op = Optional.empty();

        System.out.println(op.get());
    }



    @Test
    public void test4() {
        List<User> users = Arrays.asList(new User(1, "张三", 20),
                new User(2, "李四", 41),
                new User(3, "王五", 32),
                null,
                new User(4, "赵六", null));
        Optional<Integer> optional = users.stream()
                .filter(user -> user != null && user.getAge() != null)
                .max(Comparator.comparing(User::getAge))
                .map(User::getAge);

        Integer max = optional.orElse(100);

        System.out.println(max);

    }

    @Test
    public void test3() {
        User user = new User(1, "张三", null);
        Optional<User> optional = Optional.ofNullable(user);
        Integer max = optional.map(u->u.getAge()).orElse(100);
        System.out.println(max);

    }

    @Test
    public void test5() {
        User user = new User(1, "张三", null);
        Optional<User> optional = Optional.ofNullable(user);
        Integer age = optional.flatMap(u -> this.getAge(u))
                .orElse(100);
        System.out.println(age);
    }

    private Optional<Integer> getAge(User user){
        return Optional.ofNullable(user.getAge());
    }

}
