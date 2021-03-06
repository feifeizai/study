package com.xhf.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(value={"com.xhf.mybatis.mapper"})
public class MybatistestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatistestApplication.class, args);
	}

}
