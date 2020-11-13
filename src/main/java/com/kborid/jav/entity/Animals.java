package com.kborid.jav.entity;

import java.io.Serializable;
import java.util.Arrays;

public abstract class Animals implements Serializable {
    private String name;
    private int age;
    private transient String[] address;

    public Animals() {
        System.out.println("Animal无参构造函数");
        this.address = new String[100];
    }

    public Animals(String name, int age, String[] address) {
        System.out.println("Animal有参构造函数");
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + Arrays.toString(address) +
                '}';
    }

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        //执行 JVM 默认的序列化操作
        s.defaultWriteObject();


        //手动序列化 arr  前面30个元素
        for (int i = 0; i < 30; i++) {
            s.writeObject(address[i]);
        }
    }

    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {

        s.defaultReadObject();
        address = new String[30];

        // Read in all elements in the proper order.
        for (int i = 0; i < 30; i++) {
            address[i] = (String) s.readObject();
        }
    }

    protected abstract void fake();
}
