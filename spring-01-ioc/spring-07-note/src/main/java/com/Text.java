package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Text {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(Config1.class);
        User user=(User) context.getBean("user");
        System.out.println(user);
    }
}
