package com.xhf.autoconfigure;

import com.xhf.autoconfigure.core.config.MyComponet;
import com.xhf.autoconfigure.core.config.MyTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.xhf")
public class AutoApplication {

    /**
     * spring.factories自动注入
     */
    private static MyTemplate myTemplate;
    /**
     * @ComponentScan("com.xhf")获得, 但有局限性:如果包是提供给第三方的, 第三方并不知道扫描哪个包
     */
    private static MyComponet myComponet;

    @Autowired
    public void setMyTemplate(MyTemplate myTemplate, MyComponet myComponet) {
        this.myTemplate = myTemplate;
        this.myComponet = myComponet;
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(AutoApplication.class, args);

        //System.out.println(context.getBean(MyTemplate.class).func());

        System.out.println(myTemplate.func());
        System.out.println(myComponet.func());

    }

}
