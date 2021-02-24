package com.kborid.jav.entity;

public class Person implements Cloneable {
    private int age;
    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person clone = (Person) super.clone();
        clone.age = this.age;
        clone.name = this.name;
        return clone;
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "段伟";
        person1.age = 18;
        System.out.println(person1);
        try {
            Person person2 = (Person) person1.clone();
            System.out.println(person2);

            System.out.println("person1==person2:" + (person1 == person2));
            System.out.println("person1.age==person2.age:" + (person1.age == person2.age));
            System.out.println("person1.name==person2.name:" + (person1.name == person2.name));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
