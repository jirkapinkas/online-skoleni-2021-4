package com.test;

import com.test.service.ItemService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan// ("com.test")
@Configuration
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(Application.class);

        ItemService itemService = applicationContext.getBean(ItemService.class);

        System.out.println(itemService.getHello());

        applicationContext.close();
    }

}
