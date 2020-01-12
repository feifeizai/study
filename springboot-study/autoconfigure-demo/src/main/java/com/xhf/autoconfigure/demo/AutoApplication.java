package com.xhf.autoconfigure.demo;

import com.xhf.autoconfigure.core.config.MyTemplate;
import com.xhf.autoconfigure.core.yml.JiuxianProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties({JiuxianProperties.class})//注入对象
public class AutoApplication {

    /**
     * spring.factories自动注入
     */
    private static MyTemplate myTemplate;

    private static JiuxianProperties jiuxianProperties;

    @Autowired
    public void setMyTemplate(MyTemplate myTemplate, JiuxianProperties jiuxianProperties) {
        this.myTemplate = myTemplate;
        this.jiuxianProperties = jiuxianProperties;
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(AutoApplication.class, args);

        //System.out.println(context.getBean(MyTemplate.class).func());

        System.out.println(myTemplate.func());
        System.out.println(jiuxianProperties.toString());

    }

}
