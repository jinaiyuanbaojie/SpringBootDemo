package com.jinaiyuan.web.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Demo for Reading config data from application.properties
 */
@Component
public class Person {
    // read from application.properties
    @Value("${com.jinaiyuan.name}")
    private String name;

    // read from application.properties
    @Value("${com.jinaiyuan.age}")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
