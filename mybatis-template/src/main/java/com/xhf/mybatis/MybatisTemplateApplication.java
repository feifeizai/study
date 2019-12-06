package com.xhf.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.xhf.mybatis.mapper"})
public class MybatisTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisTemplateApplication.class, args);
	}

}
