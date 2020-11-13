package com.kborid.jav.entity;

import java.io.Serializable;

public class Cat extends Animals implements Serializable {

    public Cat() {
        System.out.println("Dog无参构造函数");
    }

    public Cat(String name, int age, String[] address) {
        super(name, age, address);
        System.out.println("Dog有参构造函数");
    }

    @Override
    protected void fake() {
        System.out.println("汪汪汪");
    }
}
