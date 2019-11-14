package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration//代表一个配置类，相当于一个bean.xml文件
@ComponentScan("com")//要扫描的包
@Import(Config2.class)//引入其他的配置类
public class Config1 {
    @Bean//方法名就是bean的id ，返回值就是bean的class
    public Dog dog(){
        return new Dog();
    }
    @Bean//方法名就是bean的id ，返回值就是bean的class
    public User user(){
        return new User();
    }
}
