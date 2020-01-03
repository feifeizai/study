package com.xhf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.xhf")
public class XxlApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxlApplication.class, args);
    }

}
