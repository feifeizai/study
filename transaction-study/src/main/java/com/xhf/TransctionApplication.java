package com.xhf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-2 15:38
 */
@SpringBootApplication
@EnableTransactionManagement
public class TransctionApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransctionApplication.class, args);
    }
}
