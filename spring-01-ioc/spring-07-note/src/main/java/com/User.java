package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
    @Value("魏鑫茂")//属性注入
    private String name;
    @Autowired//自动装配
    private Dog dog;

    public User() {
    }

    public User(String name, Dog dog) {
        this.name = name;
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "com.User{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
