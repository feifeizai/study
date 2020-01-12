package com.xhf.an;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.stream.Stream;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-1-12 17:59
 */
@SpringBootApplication
public class AnApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(AnApplication.class, args);

        String[] names = context.getBeanDefinitionNames();
        Stream.of(names).forEach(System.out::println);
    }
}
