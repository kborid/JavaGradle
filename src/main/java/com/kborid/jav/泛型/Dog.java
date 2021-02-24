package com.kborid.jav.泛型;

import java.util.HashMap;

public class Dog extends Animal {

    @Override
    protected void move() {
        System.out.println("我会奔跑");
    }

    @Override
    protected HashMap<String, String> quick(HashMap<String, String> hashMap) {
        return super.quick(hashMap);
    }
}
